package com.store.domain;

import java.util.Date;

/**
 * 用户模块实体类
 * @author 45度炸
 * 
 */
public class User {
	private String uid; //用户ID
	private String username; //用户名称
	private String password; //密码
	private String name; //姓名
	private String email; //邮件
	private String telephone; //电话
	private Date birthday; //生日
	private String sex; //性别
	private Integer state; //激活状态
	private String code; //激活码
	
	public User() {
		
	}
	
	public User(String uid, String username, String password, String name,
			String email, String telephone, Date birthday, String sex,
			Integer state, String code) {
		this.uid = uid;
		this.username = username;
		this.password = password;
		this.name = name;
		this.email = email;
		this.telephone = telephone;
		this.birthday = birthday;
		this.sex = sex;
		this.state = state;
		this.code = code;
	}
	public String getUid() {
		return uid;
	}
	public void setUid(String uid) {
		this.uid = uid;
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
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
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
	public Integer getState() {
		return state;
	}
	public void setState(Integer state) {
		this.state = state;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	
}
