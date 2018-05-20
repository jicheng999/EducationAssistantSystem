package com.ljc.eas.admin.pojo;

import java.util.Date;

public class Admin {
	private Long id;
	private String username;
	private String password;
	private byte typeid;
	private Date regist_time;
	private Date birthday;
	private String sex;
	private String photo_path;
	private String name;
	private String email;
	private String qq;
	private String phone;
	
	@Override
    public String toString() {
    // TODO Auto-generated method stub
      return "Admin [id=" + id 
          + ", username=" +username
          + ", password=" +password
            + ", typeid=" +typeid
       + ", regist_time=" +regist_time
       + ", birthday=" +birthday
       + ", sex=" +sex
       + ", photo_path=" +photo_path
       + ", name=" +name
       + ", qq=" +qq
       + ", phone=" +phone
       +"]";
    }
	
	public Admin(){
		
	}
	/*admin.id,
	 * admin.username, 
	 * admin.typeid,
	 * admin.regist_time,admin.photo_path,admin.qq,admin.birthday,admin.name,admin.sex,admin.phone,admin.email*/
	/*public Admin(Long id,String username,byte typeid,Date regist_time,String photo_path,String phone,String qq,String email,String name,String sex,Date birthday){
		this.id=id;
		this.username=username;
		this.typeid=typeid;
		this.regist_time=regist_time;
		this.photo_path=photo_path;
		this.phone=phone;
		this.qq=qq;
		this.email=email;
		this.name=name;
		this.sex=sex;
		this.birthday=birthday;
	}*/
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public byte getTypeid() {
		return typeid;
	}
	public void setTypeid(byte typeid) {
		this.typeid = typeid;
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

	public String getPhoto_path() {
		return photo_path;
	}

	public void setPhoto_path(String photo_path) {
		this.photo_path = photo_path;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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
