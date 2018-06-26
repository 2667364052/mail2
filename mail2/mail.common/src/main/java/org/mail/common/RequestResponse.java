package org.mail.common;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 请求响应辅助类
 * @author VIC
 *
 */
public class RequestResponse {

	public static void setCookies(AccessToken accessToken, HttpServletResponse resp) {
		// 设置cookie
		// expiry(单位：秒): -1表示永不过期,0表示马上过期，自定义过期时间
		
		int expiry = 60 * 60 * 24 * 30 * 12 * 3;
		
		Cookie accountCookie = new Cookie(Constans.CURRENT_USER_ACCOUNT, accessToken.getAccount());
		Cookie passwordCookie = new Cookie(Constans.CURRENT_USER_PASSWORD, accessToken.getPassword());
		Cookie tokenCookie = new Cookie(Constans.CURRENT_USER_TOKEN, accessToken.getToken());
		
		accountCookie.setMaxAge(expiry);
		accountCookie.setPath("/mail");
		passwordCookie.setMaxAge(expiry);
		passwordCookie.setPath("/mail");
		tokenCookie.setMaxAge(expiry);
		tokenCookie.setPath("/mail");
		
		resp.addCookie(accountCookie);
		resp.addCookie(passwordCookie);
		resp.addCookie(tokenCookie);
	}
	
	
	public static AccessToken getAccessTokenFromCookie(HttpServletRequest req) {
		AccessToken accessToken = new AccessToken();
		Cookie[] cookies = req.getCookies();

		for(Cookie cookie : cookies){
			if(cookie.getMaxAge() != 0){
				String name = cookie.getName();
				String value = cookie.getValue();
				if(name.equalsIgnoreCase(Constans.CURRENT_USER_ACCOUNT)){
					accessToken.setAccount(value);
				}else if(name.equalsIgnoreCase(Constans.CURRENT_USER_PASSWORD)){
					accessToken.setPassword(value);
				}else if(name.equalsIgnoreCase(Constans.CURRENT_USER_TOKEN)){
					accessToken.setToken(value);
				}
			}
		}
		return accessToken;
	}
	
	public static void delCookies(HttpServletResponse resp,HttpServletRequest req) {
		// 删除cookie
		Cookie[] cookies = req.getCookies();
		for(Cookie cookie : cookies){
			String name = cookie.getName();
			if(name.equalsIgnoreCase(Constans.CURRENT_USER_ACCOUNT) || name.equalsIgnoreCase(Constans.CURRENT_USER_PASSWORD) || name.equalsIgnoreCase(Constans.CURRENT_USER_TOKEN)){
				cookie.setMaxAge(0);
				cookie.setValue(null);
				cookie.setPath("/mail");
				resp.addCookie(cookie);
			}
		}
	}

}
