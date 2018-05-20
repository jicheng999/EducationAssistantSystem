package com.ljc.eas.teacher.service;

import com.ljc.eas.teacher.pojo.Teacher;

public interface TeacherService {
	public Teacher login(String username,String password);
	public Teacher personalInfo(String username);
	public int deleteTeacher(String username);
	public int updateTeacher(Teacher teacher);
	public int addTeacher(Teacher teacher);
}
