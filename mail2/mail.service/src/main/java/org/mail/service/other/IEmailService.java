package org.mail.service.other;

import java.util.List;

import org.mail.entity.Email;

/**
 * 邮件业务接口
 * @author VIC
 *
 */
public interface IEmailService {
	
	/**
	 * 添加注册邮件
	 * @param email
	 * @param emailType
	 * @return
	 */
	boolean addRegisterEmail(String email, String emailType);
	
	/**
	 * 根据状态查询邮件
	 * @param state
	 * @return
	 */
	List<Email> searchEmailByState(String state);
	
	/**
	 * 发送邮件
	 */
	void sendEmail();
	
	/**
	 * 添加找回密码邮件
	 * @param email
	 * @param password
	 * @param emailType
	 * @return
	 */
	boolean addFindPasswordEmail(String email, String password, String emailType);

}
