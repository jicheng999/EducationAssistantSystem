package com.ljc.eas.teacher.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.ljc.eas.base.BaseDao;
import com.ljc.eas.teacher.dao.TeacherDao;
import com.ljc.eas.teacher.pojo.*;




@Repository
public class TeacherDaoImpl extends BaseDao implements TeacherDao {

	@Override
	public Teacher login(String username, String password) {
		// TODO Auto-generated method stub
		String hql="from Teacher as teacher where teacher.username=? and teacher.password=?";
		Object[] parameters=new String[]{username,password};
		List<Teacher> teacherList=(List <Teacher>)getHibernateTemplate().find(hql,parameters);
		if (teacherList.isEmpty()) {
			return null;
		}
		else {
			return teacherList.get(0);
		}
	}

	@Override
	public Teacher queryByUsername(String username) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int update(Teacher record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(String username) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int add(Teacher record) {
		// TODO Auto-generated method stub
		return 0;
	}

}
