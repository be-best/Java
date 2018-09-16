package com.store.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * ������ʵ��
 * @author 45��ը
 *
 */
public class Orders {
	private String oid; //����ID
	private Date orderTime; //����ʱ��
	private Double total; //�ܽ��
	private Integer state; //����״̬��1δ����  2�Ѹ���δ����  3�ѷ���ûȷ���ջ�  4��ȷ���ջ�����������
	private String address; //��ַ
	private String name; //����
	private String telephone; //�绰
	private User user; //�û�
	private List<OrderItem> orderItems = new ArrayList<OrderItem>(); //������
	
	public Orders() {
		
	}
	
	public Orders(String oid, Date orderTime, Double total, Integer state,
			String address, String name, String telephone, User user,
			List<OrderItem> orderItems) {
		this.oid = oid;
		this.orderTime = orderTime;
		this.total = total;
		this.state = state;
		this.address = address;
		this.name = name;
		this.telephone = telephone;
		this.user = user;
		this.orderItems = orderItems;
	}
	public String getOid() {
		return oid;
	}
	public void setOid(String oid) {
		this.oid = oid;
	}
	public Date getOrderTime() {
		return orderTime;
	}
	public void setOrderTime(Date orderTime) {
		this.orderTime = orderTime;
	}
	public Double getTotal() {
		return total;
	}
	public void setTotal(Double total) {
		this.total = total;
	}
	public Integer getState() {
		return state;
	}
	public void setState(Integer state) {
		this.state = state;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public List<OrderItem> getOrderItems() {
		return orderItems;
	}
	public void setOrderItems(List<OrderItem> orderItems) {
		this.orderItems = orderItems;
	}
	
	
}
