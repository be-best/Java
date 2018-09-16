package com.store.domain;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 购物车
 * @author 45度炸
 *
 */
public class Cart {
	private Double total = 0d; //金额
	// Map集合用于存放购物项的集合列表,因为要进行删除购物项,所以使用Map而不使用List.使用商品的ID作为map的key. 购物项作为Map的value:
	private Map<String,CartItem> map = new LinkedHashMap<String,CartItem>(); //存放订单项
	
	public Cart() {
		
	}
	
	public Cart(Double total, Map<String, CartItem> map) {
		this.total = total;
		this.map = map;
	}
	public Double getTotal() {
		return total;
	}
//	public void setTotal(Double total) {
//		this.total = total;
//	}
	public Map<String, CartItem> getMap() {
		return map;
	}
//	public void setMap(Map<String, CartItem> map) {
//		this.map = map;
//	}
	
	/**
	 * 添加商品项到购物车
	 * @param cartItem
	 */
	public void addCart(CartItem cartItem) {
		//System.out.println(cartItem.getProduct().getPid());
		String pid = cartItem.getProduct().getPid();
		//购物车中有该商品
		if(map.containsKey(pid)) {
			//获取旧的cartItem
			CartItem _cartItem = map.get(pid);
			//设置新的count:旧的加上新的count
			_cartItem.setCount(_cartItem.getCount()+cartItem.getCount());
			//单个cartItem的金额,get方法里面设置cartItem = count*shop_price,所以这边不用设置。
		} else {
			//购物车中没有该商品
			map.put(pid, cartItem);
		}
		//修改购物车总金额
		total += cartItem.getSubtotal();
	}
	
	
	/**
	 * 删除单个购物项
	 * @param pid
	 */
	public void clearCartItem(String pid) {
		//移除商品id为pid的cartItem
		CartItem cartItem = map.remove(pid);
		//修改总金额
		total -= cartItem.getSubtotal();
	}
	
	/**
	 * 清空购物车
	 */
	public void clearCart() {
		//清空map
		map.clear();
		//总金额设为0
		total = 0d;
	}
	
}















