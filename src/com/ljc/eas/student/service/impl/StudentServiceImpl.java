package com.ljc.eas.student.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ljc.eas.student.dao.StudentDao;
import com.ljc.eas.student.pojo.Student;
import com.ljc.eas.student.service.StudentService;


@Service
public class StudentServiceImpl implements StudentService {
	@Autowired
	private StudentDao studentDao;
	

	public StudentDao getStudentDao() {
		return studentDao;
	}


	public void setStudentDao(StudentDao studentDao) {
		this.studentDao = studentDao;
	}


	@Override
	public Student login(String username, String password) {
		// TODO Auto-generated method stub
			return studentDao.login(username, password);
	}


	@Override
	public Student personalInfo(String username) {
		// TODO Auto-generated method stub
		return studentDao.queryByUsername(username);
	}


	@Override
	public int deleteStudent(String username) {
		// TODO Auto-generated method stub
		return studentDao.delete(username);
	}


	@Override
	public int updateStudent(Student student) {
		// TODO Auto-generated method stub
		return studentDao.update(student);
	}


	@Override
	public int addStudent(Student student) {
		// TODO Auto-generated method stub
		return studentDao.add(student);
	}

}
