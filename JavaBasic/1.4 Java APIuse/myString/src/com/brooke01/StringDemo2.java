package com.brooke01;
/*
 * 构造方法创建字符串对象：堆内存
 * 直接赋值方式创建对象：方法区的常量池
 */
public class StringDemo2 {
	public static void main(String[] args) {
		String str1 = new String("hello");
		
		String str2 = "hello";
		String str3 = "hello";
		
		System.out.println("str1=str2 "+(str1 == str2));
		System.out.println("str2=str3 "+(str2 == str3));
	}
}
