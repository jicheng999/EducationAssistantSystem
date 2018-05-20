package com.ljc.eas.student.service;

import com.ljc.eas.student.pojo.Student;

public interface StudentService {
	public Student login(String username,String password);
	public Student personalInfo(String username);
	public int deleteStudent(String username);
	public int updateStudent(Student student);
	public int addStudent(Student student);
}
