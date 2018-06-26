package org.mail.service.other;

import java.util.Properties;

import org.mail.util.FileUtil;

/**
 * 短信服务配置
 * @author VIC
 *
 */
public class SmsConfig {
	
	private String key;//应用APPKEY(应用详细页查询) 
	private String userAgent;// 
	private String charset;// 
	private String blockUrl;//屏蔽词检查请求接口地址 
	private String sendUrl;// 
	private int connectTimeOut;//
	private int readTimeOut;//
	
	private static SmsConfig smsConfig;
	
	private SmsConfig(){
		Properties properties = FileUtil.loadProperties("/sms_config.properties");
		this.key=properties.getProperty("sms.appkey");
		this.userAgent=properties.getProperty("sms.userAgent");
		this.charset=properties.getProperty("sms.charset");
		this.blockUrl=properties.getProperty("sms.block.url");
		this.sendUrl=properties.getProperty("sms.send.url");
		this.connectTimeOut=Integer.valueOf(properties.getProperty("sms.connect.time.out"));
		this.readTimeOut=Integer.valueOf(properties.getProperty("sms.read.time.out"));
	}
	
	public static synchronized SmsConfig getInstance(){
		if(null == smsConfig){
			smsConfig = new SmsConfig();
		}
		return smsConfig;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public String getUserAgent() {
		return userAgent;
	}

	public void setUserAgent(String userAgent) {
		this.userAgent = userAgent;
	}

	public String getCharset() {
		return charset;
	}

	public void setCharset(String charset) {
		this.charset = charset;
	}

	public String getBlockUrl() {
		return blockUrl;
	}

	public void setBlockUrl(String blockUrl) {
		this.blockUrl = blockUrl;
	}

	public String getSendUrl() {
		return sendUrl;
	}

	public void setSendUrl(String sendUrl) {
		this.sendUrl = sendUrl;
	}

	public Integer getConnectTimeOut() {
		return connectTimeOut;
	}

	public void setConnectTimeOut(Integer connectTimeOut) {
		this.connectTimeOut = connectTimeOut;
	}

	public Integer getReadTimeOut() {
		return readTimeOut;
	}

	public void setReadTimeOut(Integer readTimeOut) {
		this.readTimeOut = readTimeOut;
	}
	
}
