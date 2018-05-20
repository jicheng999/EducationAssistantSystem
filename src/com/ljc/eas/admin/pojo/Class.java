package com.ljc.eas.admin.pojo;

public class Class {
	private long id;
	private String number;
	private long teacher_id;
	private String specialty_id;
	private String college_id;
	
	
	public String getSpecialty_id() {
		return specialty_id;
	}
	public void setSpecialty_id(String specialty_id) {
		this.specialty_id = specialty_id;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public long getTeacher_id() {
		return teacher_id;
	}
	public void setTeacher_id(long teacher_id) {
		this.teacher_id = teacher_id;
	}
	
	public String getCollege_id() {
		return college_id;
	}
	public void setCollege_id(String college_id) {
		this.college_id = college_id;
	}
    
	
	
}
