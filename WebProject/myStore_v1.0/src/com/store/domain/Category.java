package com.store.domain;

import java.io.Serializable;
/**
 * ����ģ���ʵ�����
 * @author 45��ը
 *
 */
public class Category implements Serializable {
	private String cid; //����ID
	private String cname; //��������
	
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
