package com.zws06;

public class PhoneDemo {
	public static void main(String[] args) {
		//�޲�+setXxx
		Phone ph1 = new Phone();
		ph1.setBrand("iphone");
		ph1.setPrice(9999);
		ph1.setColor("������");
		System.out.println(ph1.getBrand()+","+ph1.getPrice()+","+ph1.getColor());
		
		//���ι���
		Phone ph2 = new Phone("oppo",8999,"��ɫ");
		System.out.println(ph2.getBrand()+","+ph2.getPrice()+","+ph2.getColor());
	}
}
