package com.zws01;

public class PhoneDemo {
	public static void main(String[] args) {
		Phone p = new Phone();
		p.brand = "苹果";
		p.color = "土豪金";
		p.price = 10000;
		
		System.out.println(p.brand);
		System.out.println(p.color);
		System.out.println(p.price);
		System.out.println("---------");
		p.call("张三");
		p.sendMessage();
		
		Phone p1 = p;
		p1.brand = "iphone";
		p1.color = "银色";
		p1.price = 10000;
		
		System.out.println(p1.brand);
		System.out.println(p1.color);
		System.out.println(p1.price);
		System.out.println("---------");
		p.call("李四");
		p.sendMessage();
		
		System.out.println(p.brand);
		System.out.println(p.color);
		System.out.println(p.price);
		System.out.println("---------");
	}
}
