package com.zws01;

public class PhoneDemo {
	public static void main(String[] args) {
		Phone p = new Phone();
		p.brand = "ƻ��";
		p.color = "������";
		p.price = 10000;
		
		System.out.println(p.brand);
		System.out.println(p.color);
		System.out.println(p.price);
		System.out.println("---------");
		p.call("����");
		p.sendMessage();
		
		Phone p1 = p;
		p1.brand = "iphone";
		p1.color = "��ɫ";
		p1.price = 10000;
		
		System.out.println(p1.brand);
		System.out.println(p1.color);
		System.out.println(p1.price);
		System.out.println("---------");
		p.call("����");
		p.sendMessage();
		
		System.out.println(p.brand);
		System.out.println(p.color);
		System.out.println(p.price);
		System.out.println("---------");
	}
}
