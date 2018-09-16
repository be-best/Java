package com.store.domain;
/**
 * 管理员实体
 * @author 45度炸
 *
 */
public class Adminer {
	private String pid;
	private String username;
	private String password;
	
	public Adminer() {
		
	}
	
	public Adminer(String username, String password) {
		this.username = username;
		this.password = password;
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
	
	
}
