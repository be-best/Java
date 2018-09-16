package com.store.domain;
/**
 * 购物项
 * @author 45度炸
 *
 */
public class CartItem {
	private Product product; //商品
	private Integer count; //商品数目
	private Double subtotal; //金额
	
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
	//自定义getSubtotal
	public Double getSubtotal() {
		//System.out.println(count * product.getShop_price());
		return count * product.getShop_price();
	}
//	public void setSubtotal(Double subtotal) {
//		this.subtotal = subtotal;
//	}
	
	
}
