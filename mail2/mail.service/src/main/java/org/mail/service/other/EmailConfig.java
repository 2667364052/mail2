package org.mail.service.other;

import java.util.Properties;

import org.mail.util.FileUtil;

/**
 * 邮件服务器配置
 * @author VIC
 *
 */
public class EmailConfig {
	
	private String from;// 发邮件的邮箱
	private String host;// 发邮件的主机
	private String username;// 发邮件的主机登录用户名
	private String password;// 发邮件的主机登录密码
	
	private static EmailConfig emailConfig;
	
	private EmailConfig(){
		Properties properties = FileUtil.loadProperties("/email_config.properties");
		this.from=properties.getProperty("email.from");
		this.host=properties.getProperty("email.host");
		this.username=properties.getProperty("email.username");
		this.password=properties.getProperty("email.password");
	}
	
	public static synchronized EmailConfig getInstance(){
		if(null == emailConfig){
			emailConfig = new EmailConfig();
		}
		return emailConfig;
	}
	
	public String getFrom() {
		return from;
	}
	public void setFrom(String from) {
		this.from = from;
	}
	public String getHost() {
		return host;
	}
	public void setHost(String host) {
		this.host = host;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "EmailConfig [from=" + from + ", host=" + host + ", username=" + username + ", password=" + password
				+ "]";
	}
	

}
