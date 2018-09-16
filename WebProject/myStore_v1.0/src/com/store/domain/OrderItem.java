package com.store.domain;
/**
 * 订单项的实体
 * @author 45度炸
 *
 */
public class OrderItem {
	private String itemid; //订单项ID
	private Integer count; //订单项数目
	private Double subtotal; //订单项金额
	//订单项还包括商品ID和订单ID，采用面向对象方式
	private Product product; //商品
	private Orders orders; //订单
	
	public OrderItem() {
		
	}
	
	public OrderItem(String itemid, Integer count, Double subtotal,
			Product product, Orders orders) {
		this.itemid = itemid;
		this.count = count;
		this.subtotal = subtotal;
		this.product = product;
		this.orders = orders;
	}

	public String getItemid() {
		return itemid;
	}

	public void setItemid(String itemid) {
		this.itemid = itemid;
	}

	public Integer getCount() {
		return count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}

	public Double getSubtotal() {
		return subtotal;
	}

	public void setSubtotal(Double subtotal) {
		this.subtotal = subtotal;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public Orders getOrders() {
		return orders;
	}

	public void setOrders(Orders orders) {
		this.orders = orders;
	}
	
	
	
	
}
