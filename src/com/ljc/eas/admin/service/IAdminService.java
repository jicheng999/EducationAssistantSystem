package com.ljc.eas.admin.service;

import com.ljc.eas.admin.pojo.Admin;

public interface IAdminService {
	public Admin login(String username,String password);
	public Admin personalInfo(String username);
	public int addAdmin(Admin admin);
	public int deleteAdmin(String username);
	public int updateAdmin(Admin admin);
	public int updateAdminPhoto(Admin admin);
	public int updateAdminPassword(String oldPassword,Admin admin);
}
