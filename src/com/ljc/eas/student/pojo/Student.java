package com.ljc.eas.student.pojo;

import java.util.Date;

public class Student {
	private Long id;
	private String number;
	private String name;
	private String class_number;
	private String password;
	private String photo_path;
	private Date regist_time;
	private Date birthday;
	private String sex;
	private String email;
	private String qq;
	private String phone;

	@Override
    public String toString() {
    // TODO Auto-generated method stub
      return "Admin [id=" + id 
          + ", number=" +number
          + ", name=" +name
          + ", password=" +password
            + ", class_number=" +class_number
            + ", photo_path=" +photo_path
       + ", regist_time=" +regist_time+"]";
    }
	
	public Student(){}
	
	public Student(Long id,String name,String number,String class_number,String photo_path,Date regist_time){
		this.id=id;
		this.number=number;
		this.class_number=class_number;
		this.name=name;
		this.photo_path=photo_path;
		this.regist_time=regist_time;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getClass_number() {
		return class_number;
	}
	public void setClass_number(String class_number) {
		this.class_number = class_number;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getPhoto_path() {
		return photo_path;
	}
	public void setPhoto_path(String photo_path) {
		this.photo_path = photo_path;
	}
	public Date getRegist_time() {
		return regist_time;
	}
	public void setRegist_time(Date regist_time) {
		this.regist_time = regist_time;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getQq() {
		return qq;
	}

	public void setQq(String qq) {
		this.qq = qq;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}
	
}
