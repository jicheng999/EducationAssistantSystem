package com.ljc.eas.admin.action;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.InterceptorRef;
import org.apache.struts2.convention.annotation.InterceptorRefs;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.beans.factory.annotation.Autowired;

import com.ljc.eas.admin.service.IClassService;
import com.ljc.eas.base.BaseAction;

@ParentPackage("easDefaultPackge")
@InterceptorRefs(value={@InterceptorRef(value="loginValidate",params={"role",
"admin"}), @InterceptorRef("defaultStack")})
@Namespace("/admin")
public class ClassAction extends BaseAction {
	
	@Autowired
	IClassService classService;
	
	private String param;
	private String result;
	public IClassService getClassService() {
		return classService;
	}
	public void setClassService(IClassService classService) {
		this.classService = classService;
	}
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
	
	@Action(value="classAction",results={@Result(name=SUCCESS,type="dispatcher",location="/WEB-INF/views/jsp/admin/classManager.jsp")})
	public String classAction(){
		return SUCCESS;
	}
	
	@Action(value="showClassAction",results={@Result(name=SUCCESS,type="json",params={"root","result"})})
	public String showClassAction(){
		
		return SUCCESS;
	}
	
	
	


}
