package com.ljc.eas.common.util;

import java.util.Map;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.ljc.eas.admin.pojo.Admin;



public class JsonHelper {
	
    public static String getJsonStr(Map<String,Object> map,String key){
    	 String[] str=(String[]) map.get(key);
    	 return str[0];
    }
    
    public static void test(String jsonStr){
    	JSONObject jsonObj = JSON.parseObject(jsonStr);     //将json字符串转成JSONObject
    	JSONObject admin = jsonObj.getJSONObject("admin");  //从JSONObject中获取对象 成员 admin
    	String str=admin.toJSONString();                    //将对获取到的对象成员重新还原成 String 的json格式字符串
    	@SuppressWarnings("unused")                        
		Admin adminUser=JSON.parseObject(str,Admin.class);  //使用fastjson 封装成对象
    	@SuppressWarnings("unused")                          
		String verifyCode=jsonObj.getString("verifyCode");  //从json字符串中获取String 类型成员  verifyCode
    	System.out.println(admin);
    }


}
