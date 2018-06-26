package org.mail.service.other;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import org.mail.common.State;
import org.mail.dao.IEmailDao;
import org.mail.entity.Email;
import org.mail.util.DateUtil;
import org.mail.util.FileUtil;
import org.mail.util.LoggerUtil;
import org.mail.util.MailParameter;
import org.mail.util.MailUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 邮件业务类
 * @author VIC
 *
 */
@Service("emailService")
public class EmailServiceImpl implements IEmailService {
	
	private static LoggerUtil logger = LoggerUtil.getLogger(EmailServiceImpl.class);
	
	@Autowired
	private IEmailDao emailDao;

	/**
	 * 添加注册邮件
	 * @param email
	 * @param emailType
	 * @return
	 */
	public boolean addRegisterEmail(String email, String emailType) {
		
		Email emailObj = new Email();
		emailObj.setTitle("2018商城-注册成功");
		emailObj.setEmail(email);
		emailObj.setSendTime(new Timestamp(System.currentTimeMillis()));
		emailObj.setCreateTime(emailObj.getSendTime());
		emailObj.setCreator("SYSTEM");
		emailObj.setSendState(State.WAIT.toString());
		emailObj.setState(State.ENABLED.toString());
		emailObj.setEmailType(emailType);
		
		String emailTemplate = FileUtil.loadFileContent("/config/template/active_account_email.html");
		emailTemplate = emailTemplate.replaceAll("TITLE", emailObj.getTitle()).replaceAll("USERNAME", emailObj.getEmail()).replaceAll("EMAIL", "2018show@shop.com").replaceAll("TIME", DateUtil.formatYYYYMMDD(emailObj.getCreateTime()));
		emailObj.setContent(emailTemplate);
		emailDao.save(emailObj);
		return true;
	}

	/**
	 * 根据状态查询邮件
	 * @param state
	 * @return
	 */
	public List<Email> searchEmailByState(String state) {
		return emailDao.selectByPropertys("E_SEND_STATE", state);
	}

	/**
	 * 发送所有WAIT状态的邮件
	 */
	public void sendEmail() {
		// 加载邮件服务器配置
		EmailConfig emailConfig = EmailConfig.getInstance();
		// 查询所有等待发送的邮件
		List<Email> waitEmails = searchEmailByState(State.WAIT.toString());
		logger.info("查询到等待发送邮件数量: " + waitEmails.size());
		// 发送方式1: 循序发送
		List<Email> updateEmails = new ArrayList<Email>();
		for(Email email : waitEmails){
			MailParameter parameter = new MailParameter();
			parameter.setContent(email.getContent());
			parameter.setEmails(email.getEmail());
			parameter.setFrom(emailConfig.getFrom());
			parameter.setHost(emailConfig.getHost());
			parameter.setPassword(emailConfig.getPassword());
			parameter.setTitle(email.getTitle());
			parameter.setUsername(emailConfig.getUsername());
			// 发送邮件
			boolean state = MailUtil.send(parameter);
			if(state){
				// 改变发送状态
				email.setSendState(State.SEND.toString());
				updateEmails.add(email);
			}
			logger.info(emailConfig.getFrom() + " 发送给 " + email.getEmail() + " 状态: " + state);
		}
		
		if(updateEmails.size()>0){
			// 更新所有已经发送过的邮件状态为send状态
			emailDao.batchUpdate(updateEmails);
			logger.info("更新已发送的邮件状态数量: " + updateEmails.size());
		}
	}

	public boolean addFindPasswordEmail(String email, String password, String emailType) {
		
		Email emailObj = new Email();
		emailObj.setTitle("2018商城-找回密码");
		emailObj.setEmail(email);
		emailObj.setSendTime(new Timestamp(System.currentTimeMillis()));
		emailObj.setCreateTime(emailObj.getSendTime());
		emailObj.setCreator("SYSTEM");
		emailObj.setSendState(State.WAIT.toString());
		emailObj.setState(State.ENABLED.toString());
		emailObj.setEmailType(emailType);
		
		String emailTemplate = FileUtil.loadFileContent("/config/template/find_password_email.html");
		emailTemplate = emailTemplate.replaceAll("TITLE", emailObj.getTitle()).replaceAll("USERNAME", email).replaceAll("PASSWORD", password).replaceAll("TIME", DateUtil.formatYYYYMMDD(emailObj.getCreateTime()));
		emailObj.setContent(emailTemplate);
		emailDao.save(emailObj);
		return true;
	}

}
