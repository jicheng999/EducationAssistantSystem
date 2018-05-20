package com.ljc.eas.admin.dao;

import com.ljc.eas.admin.pojo.Admin;

public interface IAdminDao {
	public Admin login(String username,String password);
	public Admin queryByUsername(String username);
	public int update(Admin record);
	public int delete(String username);
	public int add(Admin record);
}
