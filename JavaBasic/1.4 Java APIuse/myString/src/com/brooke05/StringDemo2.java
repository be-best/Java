package com.brooke05;

import java.util.Scanner;

public class StringDemo2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("������һ���ַ�����");
		String str = sc.nextLine();
		System.out.println("��ת����ַ�����");
		String str1 = reserve1(str);
		String str2 = reserve2(str);
		System.out.println(str1);
		System.out.println(str2);
	}
	
	//ֱ�ӵ��ű�������
	public static String reserve1(String str) {
		String str1 = "";
		for(int x=(str.length()-1);x>=0;x--) {
			str1 += str.charAt(x);
		}
		return str1;
	}
	
	//ת��Ϊ�ַ������ת��Ȼ���ٰ��ַ�����ת���ַ���
	public static String reserve2(String str) {
		//ת��Ϊ�ַ�����
		char[] str2 = str.toCharArray();
		//���鷴ת
		for(int start=0,end=str2.length-1;start<=end;start++,end--) {
			char temp = str2[start];
			str2[start] = str2[end];
			str2[end] = temp;
		}
		String str1 = new String(str2);
		return str1;
	}
}
