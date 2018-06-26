package org.mail.dao;


import org.mail.entity.User;
import org.springframework.stereotype.Repository;

/**
 * 用户数据Dao接口实现类
 * @author VIC
 *
 */
@Repository("userDao")
public class UserDaoImpl extends BaseDaoImpl<User, Integer> implements IUserDao {

}
