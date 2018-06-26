package org.mail.service.other;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import org.mail.common.State;
import org.mail.common.Type;
import org.mail.dao.IMessageDao;
import org.mail.entity.Message;
import org.mail.util.LoggerUtil;
import org.mail.util.SmsUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 短信业务类
 * @author VIC
 *
 */
@Service("messageService")
public class MessageServiceImpl implements IMessageService {
	
	private LoggerUtil logger = LoggerUtil.getLogger(MessageServiceImpl.class);
	
	@Autowired
	private IMessageDao messageDao;
	
	public int addRegisterMessage(String phone, String code){
		Timestamp currentTimestamp = new Timestamp(System.currentTimeMillis());
		Message message = new Message();
		message.setTitle("title");
		message.setContent(code);
		message.setPhone(phone);
		message.setCreateTime(currentTimestamp);
		message.setSendState(State.WAIT.toString());
		message.setMessageType(Type.REGISTER.toString());
		message.setSendTime(currentTimestamp);
		message.setCreator("SYSTEM");
		message.setState(State.ENABLED.toString());
		messageDao.save(message);
		return 1;
	}

	public void sendMessage() {
		
		// 查询所有等待发送的邮件
		List<Message> waitMessages = searchMessageByState(State.WAIT.toString());
		logger.info("查询到等待发送短信数量: " + waitMessages.size());
		// 发送方式1: 循序发送
		List<Message> updateMessages = new ArrayList<Message>();
		for(Message message : waitMessages){
			SmsUtil.sendMessage(message.getContent(), message.getPhone());
			message.setSendState(State.SEND.toString());
			updateMessages.add(message);
			logger.info(" 发送给 " + message.getPhone() + "短信");
		}
				
		if(updateMessages.size()>0){
			// 更新所有已经发送过的邮件状态为send状态
			messageDao.batchUpdate(updateMessages);
			logger.info("更新已发送的短信状态数量: " + updateMessages.size());
		}
	}

	public List<Message> searchMessageByState(String state) {
		return messageDao.selectByPropertys("M_SEND_STATE", state);
	}

}
