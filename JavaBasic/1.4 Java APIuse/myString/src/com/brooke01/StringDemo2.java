package com.brooke01;
/*
 * ���췽�������ַ������󣺶��ڴ�
 * ֱ�Ӹ�ֵ��ʽ�������󣺷������ĳ�����
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
