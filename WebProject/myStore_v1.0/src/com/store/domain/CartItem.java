package com.store.domain;
/**
 * ������
 * @author 45��ը
 *
 */
public class CartItem {
	private Product product; //��Ʒ
	private Integer count; //��Ʒ��Ŀ
	private Double subtotal; //���
	
	public CartItem() {
		
	}
	
	public CartItem(Product product, Integer count, Double subtotal) {
		this.product = product;
		this.count = count;
		this.subtotal = subtotal;
	}
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	public Integer getCount() {
		return count;
	}
	public void setCount(Integer count) {
		this.count = count;
	}
	//�Զ���getSubtotal
	public Double getSubtotal() {
		//System.out.println(count * product.getShop_price());
		return count * product.getShop_price();
	}
//	public void setSubtotal(Double subtotal) {
//		this.subtotal = subtotal;
//	}
	
	
}
