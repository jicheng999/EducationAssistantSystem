package com.ljc.eas.teacher.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ljc.eas.teacher.dao.TeacherDao;
import com.ljc.eas.teacher.pojo.Teacher;
import com.ljc.eas.teacher.service.TeacherService;


@Service
public class TeacherServiceImpl implements TeacherService {
	@Autowired
	private TeacherDao teacherDao;

	public TeacherDao getTeacherDao() {
		return teacherDao;
	}

	public void setTeacherDao(TeacherDao teacherDao) {
		this.teacherDao = teacherDao;
	}

	@Override
	public Teacher login(String username, String password) {
		// TODO Auto-generated method stub
		return teacherDao.login(username, password);
	}

	@Override
	public Teacher personalInfo(String username) {
		// TODO Auto-generated method stub
		return teacherDao.queryByUsername(username);
	}

	@Override
	public int deleteTeacher(String username) {
		// TODO Auto-generated method stub
		return teacherDao.delete(username);
	}

	@Override
	public int updateTeacher(Teacher teacher) {
		// TODO Auto-generated method stub
		return teacherDao.update(teacher);
	}

	@Override
	public int addTeacher(Teacher teacher) {
		// TODO Auto-generated method stub
		return teacherDao.add(teacher);
	}

}
