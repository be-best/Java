package com.store.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 订单的实体
 * @author 45度炸
 *
 */
public class Orders {
	private String oid; //订单ID
	private Date orderTime; //订单时间
	private Double total; //总金额
	private Integer state; //订单状态：1未付款  2已付款未发货  3已发货没确认收货  4已确认收货，订单结束
	private String address; //地址
	private String name; //姓名
	private String telephone; //电话
	private User user; //用户
	private List<OrderItem> orderItems = new ArrayList<OrderItem>(); //订单项
	
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
