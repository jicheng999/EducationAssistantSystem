package com.ljc.eas.common.intercepter;

import java.util.Map;

import org.springframework.stereotype.Component;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

@Component
public class LoginValidate extends AbstractInterceptor {
	private String role;

	public String getRole() {
		return role;
	}
	
	public void setRole(String role) {
		this.role = role;
	}

	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		// TODO Auto-generated method stub
		Map session=ActionContext.getContext().getSession();
		String username=(String)session.get("username");
		/*Map paramMap = invocation.getInvocationContext().getParameters();
		String[] urlList=(String[]) paramMap.get("url");
		String url=urlList[0];*/
		if (username!=null&&role.equals((String)session.get("role"))) {
			return invocation.invoke();
		}
		return "no_access";
	}

}
