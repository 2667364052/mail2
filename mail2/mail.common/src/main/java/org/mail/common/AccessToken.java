package org.mail.common;

import org.mail.util.JsonUtil;

/**
 * 访问令牌
 * @author VIC
 *
 */
public class AccessToken {
	
	private Integer userId;//用户ID
	private String sessionId;// 会话ID
	private String account;// 登录账号
	private String password;// 登录密码：MD5Util.encryptMD5(password)
	private String token;// 登录成功令牌： MD5Util.encryptMD5(account + MD5Util.encryptMD5(password))
	private boolean state;// 登录状态
	
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public boolean isState() {
		return state;
	}
	public void setState(boolean state) {
		this.state = state;
	}
	
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getSessionId() {
		return sessionId;
	}
	public void setSessionId(String sessionId) {
		this.sessionId = sessionId;
	}
	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
	}
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	public String toJson(){
		return JsonUtil.toJson(this);
	}

}
