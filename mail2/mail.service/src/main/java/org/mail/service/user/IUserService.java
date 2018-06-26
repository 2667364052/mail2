package org.mail.service.user;

import org.mail.common.AccessToken;

import org.mail.entity.User;

/**
 * 用户业务接口
 * @author VIC
 *
 */
public interface IUserService {
	
	boolean checkedAccount(String account);
	
	boolean checkedEmail(String email);
	
	boolean checkedPhone(String phone);
	
	int registerEmail(User user);
	
	
	int registerPhone(User user);
	
	AccessToken login(String sessionId, String account, String password);
	
	boolean findPassword(String email);

}
