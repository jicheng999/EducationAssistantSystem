package com.ljc.eas.admin.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ljc.eas.admin.dao.IAdminDao;
import com.ljc.eas.admin.pojo.Admin;
import com.ljc.eas.admin.service.IAdminService;

@Service
public class AdminServiceImpl implements IAdminService {
	@Autowired
	private IAdminDao adminDao;
	private final String defaultPhotoPath="/EducationAssistantSystem/linkRsc/images/photos/noPhoto.jpg";
	
	public IAdminDao getAdminDao() {
		return adminDao;
	}
	
	public void setAdminDao(IAdminDao adminDao) {
		this.adminDao = adminDao;
	}
	
	@Override
	public Admin login(String username, String password) {
		// TODO Auto-generated method stub
		Admin admin=null;
		if (!username.isEmpty()&&!password.isEmpty()) {
			if ((admin=adminDao.login(username, password))!=null) {
				return transAdmin(admin);
			}
			else{
				return null;
			}
		}
		return null;
	}

	@Override
	public Admin personalInfo(String username) {
		// TODO Auto-generated method stub
		Admin admin=adminDao.queryByUsername(username);
		return transAdmin(admin);
	}

	@Override
	public int deleteAdmin(String username) {
		// TODO Auto-generated method stub
		return adminDao.delete(username);
	}

	@Override
	public int updateAdmin(Admin admin) {
		// TODO Auto-generated method stub
		admin=defaultPhotoPath(admin);
		return adminDao.update(admin);
	}
	


	@Override
	public int addAdmin(Admin admin) {
		// TODO Auto-generated method stub
		admin=defaultPhotoPath(admin);
		return adminDao.add(admin);
	}
	
	private Admin defaultPhotoPath(Admin admin){
		if (admin.getPhoto_path().equals("")||admin.getPhoto_path()==null) {
			admin.setPhoto_path(defaultPhotoPath);
		}
		return admin;
	}
	
	private Admin transAdmin(Admin admin){
		admin.setPassword(null);
		return admin;
	}

	@Override
	public int updateAdminPhoto(Admin admin) {
		// TODO Auto-generated method stub
		Admin queryAdmin=adminDao.queryByUsername(admin.getUsername());
		queryAdmin.setPhoto_path(admin.getPhoto_path());
		return adminDao.update(queryAdmin);
	}

	@Override
	public int updateAdminPassword(String oldPassword, Admin admin) {
		// TODO Auto-generated method stub
		Admin queryAdmin=adminDao.login(admin.getUsername(), oldPassword);
		if (queryAdmin!=null) {
			queryAdmin.setPassword(admin.getPassword());
			return adminDao.update(queryAdmin);
		} else {
			return -1;
		}	
	}

}
