package admin.service;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.ljc.eas.admin.pojo.Admin;
import com.ljc.eas.admin.service.IAdminService;

public class testAdminService {
	@Autowired
	private IAdminService adminService;
	
	@Test
	public void getPersonalInfo(){
		Admin admin=adminService.personalInfo("ljc123456");
		System.out.println("1111");
	}

}
