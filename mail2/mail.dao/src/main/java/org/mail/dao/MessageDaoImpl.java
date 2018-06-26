package org.mail.dao;

import org.mail.entity.Message;
import org.springframework.stereotype.Repository;

/**
 * 消息数据Dao接口实现类
 * @author VIC
 *
 */
@Repository("messageDao")
public class MessageDaoImpl extends BaseDaoImpl<Message, Integer> implements IMessageDao {

}
