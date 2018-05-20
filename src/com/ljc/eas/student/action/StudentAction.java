package com.ljc.eas.student.action;

import java.util.HashMap;
import java.util.Map;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.InterceptorRef;
import org.apache.struts2.convention.annotation.InterceptorRefs;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.ljc.eas.admin.pojo.Admin;
import com.ljc.eas.admin.service.IAdminService;
import com.ljc.eas.base.BaseAction;
import com.ljc.eas.student.service.StudentService;
import com.opensymphony.xwork2.ActionSupport;


@ParentPackage("easDefaultPackge")
@InterceptorRefs(value={@InterceptorRef(value="loginValidate",params={"role",
"student"}), @InterceptorRef("defaultStack")})
@Namespace("/student")
public class StudentAction extends BaseAction {

	@Autowired
	private StudentService studentService;

	private String result;
	
	private String param;

	public String getParam() {
		return param;
	}

	public void setParam(String param) {
		this.param = param;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}
	
	@Action(value = "panel", results = { @Result(name = "success", type = "dispatcher", location = "/WEB-INF/views/jsp/student/studentPanel.jsp")})
	public String showPanel() {
		return SUCCESS;
	}
	
	@Action(value="personalInfo",results={@Result(name="success",type="dispatcher",location = "/WEB-INF/views/jsp/student/personalInfo.jsp")})
	public String showPersonalInfo(){
		Admin admin=new Admin();
		admin.setId((long)1);
		admin.setPassword("123123");
		admin.setUsername("ljc");
		admin.setTypeid((byte)0);
		/*JSONObject jsonObject=new JSONObject();
		jsonObject=(JSONObject) JSON.toJSON(admin);*/
		Map<String,Object> map=new HashMap<String,Object>();
		map.put("admin", admin);
		ServletActionContext.getRequest().setAttribute("data",map );
		return SUCCESS;
	}


}
