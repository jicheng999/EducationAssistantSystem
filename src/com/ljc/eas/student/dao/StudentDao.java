package com.ljc.eas.student.dao;

import com.ljc.eas.student.pojo.Student;


public interface StudentDao {
	public Student login(String username,String password);
	public Student queryByUsername(String username);
	public int update(Student record);
	public int delete(String username);
	public int add(Student record);

}
