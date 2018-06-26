package org.mail.service.other;

import java.util.List;

import org.mail.entity.Message;

/**
 * 消息业务接口
 * @author VIC
 *
 */
public interface IMessageService {
	
	int addRegisterMessage(String phone, String code);
	
	void sendMessage();
	
	List<Message> searchMessageByState(String state);

}
