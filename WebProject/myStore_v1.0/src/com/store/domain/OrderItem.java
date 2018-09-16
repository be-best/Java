package com.store.domain;
/**
 * �������ʵ��
 * @author 45��ը
 *
 */
public class OrderItem {
	private String itemid; //������ID
	private Integer count; //��������Ŀ
	private Double subtotal; //��������
	//�����������ƷID�Ͷ���ID�������������ʽ
	private Product product; //��Ʒ
	private Orders orders; //����
	
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
