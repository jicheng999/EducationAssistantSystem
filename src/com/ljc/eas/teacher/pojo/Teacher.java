package com.ljc.eas.teacher.pojo;

import java.util.Date;

public class Teacher {
	private Long id;
	private String number;
	private String password;
	private Date regist_time;
	private String name;
	private String username;
	private Date birthday;
	private String sex;
	private String photo_path;
	private String email;
	private String qq;
	private String phone;

	@Override
    public String toString() {
    // TODO Auto-generated method stub
      return "Admin [id=" + id 
          + ", number=" +number
          + ", password=" +password
            + ", name=" +name
            +", username" + username
       + ", regist_time=" +regist_time+"]";
    }
	
	public Teacher(){}
	
	public Teacher(Long id,String number,Date regist_time,String name,String username){
		this.id=id;
		this.username=username;
		this.name=name;
		this.number=number;
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
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Date getRegist_time() {
		return regist_time;
	}
	public void setRegist_time(Date regist_time) {
		this.regist_time = regist_time;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
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

	public String getPhoto_path() {
		return photo_path;
	}

	public void setPhoto_path(String photo_path) {
		this.photo_path = photo_path;
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
