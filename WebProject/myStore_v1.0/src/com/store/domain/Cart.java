package com.store.domain;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * ���ﳵ
 * @author 45��ը
 *
 */
public class Cart {
	private Double total = 0d; //���
	// Map�������ڴ�Ź�����ļ����б�,��ΪҪ����ɾ��������,����ʹ��Map����ʹ��List.ʹ����Ʒ��ID��Ϊmap��key. ��������ΪMap��value:
	private Map<String,CartItem> map = new LinkedHashMap<String,CartItem>(); //��Ŷ�����
	
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
	 * �����Ʒ����ﳵ
	 * @param cartItem
	 */
	public void addCart(CartItem cartItem) {
		//System.out.println(cartItem.getProduct().getPid());
		String pid = cartItem.getProduct().getPid();
		//���ﳵ���и���Ʒ
		if(map.containsKey(pid)) {
			//��ȡ�ɵ�cartItem
			CartItem _cartItem = map.get(pid);
			//�����µ�count:�ɵļ����µ�count
			_cartItem.setCount(_cartItem.getCount()+cartItem.getCount());
			//����cartItem�Ľ��,get������������cartItem = count*shop_price,������߲������á�
		} else {
			//���ﳵ��û�и���Ʒ
			map.put(pid, cartItem);
		}
		//�޸Ĺ��ﳵ�ܽ��
		total += cartItem.getSubtotal();
	}
	
	
	/**
	 * ɾ������������
	 * @param pid
	 */
	public void clearCartItem(String pid) {
		//�Ƴ���ƷidΪpid��cartItem
		CartItem cartItem = map.remove(pid);
		//�޸��ܽ��
		total -= cartItem.getSubtotal();
	}
	
	/**
	 * ��չ��ﳵ
	 */
	public void clearCart() {
		//���map
		map.clear();
		//�ܽ����Ϊ0
		total = 0d;
	}
	
}















