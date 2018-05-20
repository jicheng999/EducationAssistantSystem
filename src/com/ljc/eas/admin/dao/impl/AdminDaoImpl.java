package com.ljc.eas.admin.dao.impl;


import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.ljc.eas.admin.dao.IAdminDao;
import com.ljc.eas.admin.pojo.Admin;
import com.ljc.eas.base.BaseDao;

@Repository
public class AdminDaoImpl extends BaseDao implements IAdminDao {
	
	@Override
	public Admin login(String username, String password) {
		// TODO Auto-generated method stub
		String hql="from Admin as admin where admin.username=? and admin.password=?";
		Object[] parameters=new String[]{username,password};
		List<Admin> adminList=(List <Admin>)(getHibernateTemplate().find(hql,parameters));
		if (adminList.isEmpty()) {
			return null;
		}
		else {
			return adminList.get(0);
		}
	}

	@Override
	public Admin queryByUsername(String username) {
		// TODO Auto-generated method stub
		String hql="from Admin as admin where admin.username=?";
		Object[] parameters=new String[]{username};
		List<Admin> adminList=(List <Admin>)(getHibernateTemplate().find(hql,parameters));
		if (adminList.isEmpty()) {
			return null;
		}
		else {
			return adminList.get(0);
		}
	}

	@Override
	public int update(Admin record) {
		// TODO Auto-generated method stub
		String hql="from Admin as admin where admin.username=?";
		Object[] parameters=new String[]{record.getUsername()};
		List<Admin> adminList=(List <Admin>)(getHibernateTemplate().find(hql,parameters));
		if (adminList.isEmpty()) {
			return -1;
		} else {
			getHibernateTemplate().update(record);
			return 1;
		}
	}

	@Override
	public int delete(String username) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int add(Admin record) {
		// TODO Auto-generated method stub
		return 0;
	}

}
