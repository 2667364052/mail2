package org.mail.service.user;

import org.mail.cache.CacheContext;
import org.mail.common.Type;
import org.mail.dao.IUserDao;
import org.mail.common.AccessToken;
import org.mail.common.State;
import org.mail.entity.User;
import org.mail.service.other.IEmailService;
import org.mail.util.MD5Util;
import org.mail.util.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 用户业务类
 * @author VIC
 *
 */
@Service("userService")
public class UserServiceImpl implements IUserService {
	
	@Autowired
	private IUserDao userDao;
	
	@Autowired
	private IEmailService emailService;
	
	public boolean checkedAccount(String account) {
		return null != userDao.selectByProperty("uemail", account) || null != userDao.selectByProperty("uphone", account);
	}

	public boolean checkedEmail(String email) {
		return null != userDao.selectByProperty("uemail", email);
	}
	
	public boolean checkedPhone(String phone) {
		return null != userDao.selectByProperty("uphone", phone);
	}

	public int registerEmail(User user) {
		
		userDao.save(user);
		//execute("insert into USERS values(USER_SEQ.nextval,?,?,?,?,?,?,?,?,?,?)", "example","example",MD5Util.encryptMD5(password),"男",29,"head.jpg",email,"1388888",State.ENABLED.toString(),new Timestamp(System.currentTimeMillis()));
		if(user.getUSERID() > 0){
			// 注册用户成功后生成邮件通知内容
			emailService.addRegisterEmail(user.getEmail(),Type.REGISTER.toString());
		}
		return 1;
	}

	public int registerPhone(User user) {
		userDao.save(user);
		//execute("insert into USERS values(USER_SEQ.nextval,?,?,?,?,?,?,?,?,?,?)","example","example",MD5Util.encryptMD5(password),"男",28,"head.jpg","example@163.com",phone,State.ENABLED.toString(),new Timestamp(System.currentTimeMillis()));
		return 1;
	}

	public AccessToken login(String sessionId, String account, String password) {
		
		User user = userDao.selectByProperty("uemail", account);// findByAttribute("select * from users where uemail=? or uphone=?", account, account);
		AccessToken accessToken = new AccessToken();
		// 如果账号存在
		if(null != user){
			// 如果用户启用
  			if(user.getState().equals(State.ENABLED.toString())){
				// 如果密码正确
				if(user.getPassword().equals(password)){
					// 将账号及密码再次MD5后放入缓存中
					String accessTokenString = buildAccessToken(account,password);
					accessToken.setUserId(user.getUSERID());
					accessToken.setSessionId(sessionId);
					accessToken.setAccount(account);
					accessToken.setPassword(password);
					accessToken.setToken(accessTokenString);
					accessToken.setState(true);
					CacheContext.setCache(sessionId, accessToken);
					// 其他逻辑
				}
			}
		}
		return accessToken;
	}
	
	/**
	 * 构建登录访问Token令牌: 用户是否登录就验证令牌是否正确
	 * @param account
	 * @param password
	 * @return
	 */
	public String buildAccessToken(String account,String password){
		return MD5Util.encryptMD5(account + password);
	}

	public boolean findPassword(String email) {
		boolean state = false;
		
		if(checkedEmail(email)){
			// 创建新密码
			String password = StringUtil.generatorString();
			// 找回密码邮件通知内容
			state = emailService.addFindPasswordEmail(email,password,Type.FIND_PASSWORD.toString());
		}
		
		return state;
	}

}
