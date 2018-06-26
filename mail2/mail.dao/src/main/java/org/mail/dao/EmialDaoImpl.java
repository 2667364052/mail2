package org.mail.dao;

import org.mail.entity.Email;
import org.springframework.stereotype.Repository;

/**
 * 邮件数据Dao接口实现类
 * @author VIC
 *
 */
@Repository("emialDao")
public class EmialDaoImpl extends BaseDaoImpl<Email, Integer> implements IEmailDao {

}
