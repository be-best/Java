package com.brooke01;

public class StringDemo {
	public static void main(String[] args) {
		//��ʽһ
		String str1 = new String("helloworld");
		System.out.println("str1:"+str1);
		
		//��ʽ��
		char[] chs = {'h','e','l','l','o'};
		String str2 = new String(chs);
		System.out.println("str2:"+str2);
		
		//��ʽ��
		String str3 = new String(chs,1,4);
		System.out.println("str3:"+str3);
		
		//��ʽ��
		String str4 = "hello";
		System.out.println("str4:"+str4);
	}
}
