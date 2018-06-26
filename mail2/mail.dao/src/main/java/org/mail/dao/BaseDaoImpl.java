package org.mail.dao;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;


import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;

public abstract class BaseDaoImpl <T extends Serializable,P extends Serializable> implements IBaseDao<T , P>  {
    
	//session工厂
	@Autowired
	private EntityManagerFactory entityManagerFactory;
	
	//泛型的对象类型
	protected Class<?> clz;
	
	@SuppressWarnings("unchecked")
	public BaseDaoImpl() {
		// 通过反射获取泛型对象类型
				ParameterizedType parameterizedType = (ParameterizedType)this.getClass().getGenericSuperclass();
				clz= (Class<T>)(parameterizedType.getActualTypeArguments()[0]);
				
	}
	
	//获取session
	protected EntityManager getEntityManager() {
		return entityManagerFactory.createEntityManager();
	}
	
	
	public void save(T t) {
	 
		getEntityManager().persist(t);
	}

	public void delete(T t) {
		getEntityManager().remove(t);
		
	}

	public void update(T t) {
		getEntityManager().merge(t);
		
	}

	public void batchUpdate(List<T> ts) {
		for(T t:ts) {
			update(t);
		}
		
	}

	public T selectByProperty(String name, Object value) {
		//构建oql查询语句
		String oql = "from" + clz.getSimpleName() + "obj where obj." + name + "=:" + name;
		//例如：查询User的OQL:from User obj where obj.name=:name;
		//创建查询接口
	    Query query = getEntityManager().createQuery(oql);
		//设置查询参数
		query.setParameter(name,value);
		//执行查询对象
		return (T)query.getSingleResult();
	}

	public List<T> selectByPropertys(String name, Object value) {
		// 构建oql查询语句
		String oql = "from " + clz.getSimpleName() + " obj where obj." + name + "=:" + name;
		// 创建查询接口
		Query query = getEntityManager().createQuery(oql);
		// 设置查询参数
		query.setParameter(name, value);
		// 执行查询对象
		return query.getResultList();
	}

	public List<T> selectAll() {
		// 构建oql查询语句
		String oql = "from " + clz.getSimpleName();
		// 创建查询接口
		Query query = getEntityManager().createQuery(oql);
		// 执行查询对象
		return query.getResultList();
	}

	public List<T> selectByPager(String name, Object value, int startIndex, int pageSize) {
		
		String oql = "from " + clz.getSimpleName();
		if(null != name){
			oql += " obj where " + name +"=:" + name;
		}
		Query query = getEntityManager().createQuery(oql);
		if(null != name){
			query.setParameter(name, value);
		}
		// 
		// 设置返回起始位置
		query.setFirstResult(startIndex);
		// 设置返回数量
		query.setMaxResults(pageSize);
		// 执行查询
		return query.getResultList();
	}

}
