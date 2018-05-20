package com.ljc.eas.common.action;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;

import com.opensymphony.xwork2.ActionSupport;

public class LoginAction extends ActionSupport {
	@Override
	@Action(value = "loginAction", results = { @Result(name = "success", location = "/WEB-INF/views/jsp/login.jsp", type = "dispatcher") })
	public String execute() throws Exception {
		// TODO Auto-generated method stub

		return SUCCESS;
	}

}
