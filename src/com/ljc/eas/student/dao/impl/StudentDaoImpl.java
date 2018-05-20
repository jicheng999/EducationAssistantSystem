package com.ljc.eas.student.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.ljc.eas.base.BaseDao;
import com.ljc.eas.student.dao.StudentDao;
import com.ljc.eas.student.pojo.Student;

@Repository
public class StudentDaoImpl extends BaseDao implements StudentDao {

	@Override
	public Student login(String username, String password) {
		// TODO Auto-generated method stub
		String hql="from Student as student where student.number=? and student.password=?";
		Object[] parameters=new String[]{username,password};
		List<Student> studentList=(List <Student>)getHibernateTemplate().find(hql,parameters);
		if (studentList.isEmpty()) {
			return null;
		}
		else {
			return studentList.get(0);
		}
	}

	@Override
	public Student queryByUsername(String username) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int update(Student record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(String username) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int add(Student record) {
		// TODO Auto-generated method stub
		return 0;
	}

}
