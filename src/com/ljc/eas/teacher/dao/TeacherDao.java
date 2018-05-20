package com.ljc.eas.teacher.dao;

import com.ljc.eas.teacher.pojo.Teacher;

public interface TeacherDao {
	public Teacher login(String username, String password);
	public Teacher queryByUsername(String username);
	public int update(Teacher record);
	public int delete(String username);
	public int add(Teacher record);
}
