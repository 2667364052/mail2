package org.mail.dao;

import java.io.Serializable;
import java.util.List;

//公共基础数据操作接口
public interface IBaseDao<T extends Serializable ,P extends Serializable> {

	//保存对象
	void save(T t);
	
	//删除对象
	void delete(T t);
	
	//修改对象
	void update(T t);
	
	//批量修改对象
	void batchUpdate(List<T> ts);
	
	/**
	 * 根据属性查询对象
	 * name 属性名称
	 * value 属性值
	 * 
	 */
	T selectByProperty(String name,Object value);
	
	/**
	 * 根据属性查询对象集合
	 * name 属性名称
	 * value 属性值
	 */
	List<T> selectByPropertys(String name,Object value);
	
	/**
	 * 查询所有对象集合
	 * 
	 */
	List<T> selectAll();
	
	/**
	 * 分页查询对象
	 * name 属性名称
	 * vlaue 属性值
	 * startIndex 返回起始位置
	 * pageSize 返回数量
	 * 
	 */
	List<T> selectByPager(String name,Object value,int startIndex,int pageSize);
}
