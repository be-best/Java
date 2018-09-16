package com.store.domain;

import java.io.Serializable;
/**
 * 分类模块的实体对象
 * @author 45度炸
 *
 */
public class Category implements Serializable {
	private String cid; //分类ID
	private String cname; //分类名称
	
	public Category() {
		
	}
	
	public Category(String cid, String cname) {
		this.cid = cid;
		this.cname = cname;
	}
	public String getCid() {
		return cid;
	}
	public void setCid(String cid) {
		this.cid = cid;
	}
	public String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}
	
	
}
