package com.ljc.eas.common.util;

import java.util.HashMap;
import java.util.Map;

import com.opensymphony.xwork2.ActionContext;

import net.sf.json.JSONObject;

public class LoginUtil {
	
	public static String loginSuccess(String role,String username) {
		Map<String,Object> session=ActionContext.getContext().getSession();
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("loginResult", true);
		map.put("message", "登录成功*");
		map.put("url", role + "/panel");
		JSONObject json = new JSONObject();
		json = JSONObject.fromObject(map);
		session.put("username", username);
		session.put("role", role);
		return json.toString();
	}
	
	public static String loginFail(String message) {
		ActionContext.getContext().getSession()
				.put("verifyCode", SecurityCode.getSecurityCode());
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("loginResult", false);
		map.put("message", message);
		JSONObject json = new JSONObject();
		json = JSONObject.fromObject(map);
		return json.toString();
	}
	
	public static String loginCheck(String username,String password,String verifyCode,Map<String, Object> session){
		if (password.length() < 8 || password.length() > 30) {
			return "密码格式错误或有非法字符 *";
		} else if (username.length() < 8 || username.length() > 30) {
			return "用户名格式错误或有非法字符*";
		} else if (!verifyCode.equals(session.get("verifyCode"))) {
			return "验证码错误*";
		} 
		return null;
	}

}
