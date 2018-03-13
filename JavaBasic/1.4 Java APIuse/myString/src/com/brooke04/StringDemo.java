package com.brooke04;

public class StringDemo {
	public static void main(String[] args) {
		String str1 = "helloworld";
		String str2 = "    helloworld    ";
		String str3 = "    hellow world    ";
		
		//È¥³ý×Ö·û´®Á½²à¿Õ¸ñ
		System.out.println("---"+str1+"---");
		System.out.println("---"+str1.trim()+"---");
		System.out.println("---"+str2+"---");
		System.out.println("---"+str2.trim()+"---");
		System.out.println("---"+str3+"---");
		System.out.println("---"+str3.trim()+"---");
		System.out.println("---------------------");
		
		//·Ö¸î×Ö·û´®
		String str4 = "abc,def,ghi";
		String[] str5 = str4.split(",");
		System.out.println(str4);
		for(int x=0;x<str5.length;x++) {
			System.out.println(str5[x]);
		}
	}
}
