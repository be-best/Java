package com.brooke03;
/*
 * ��ĸ�ַ����У�����ĸתΪ��д����Сд
 */
import java.util.Scanner;

public class StringDemo1 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("������һ���ַ�����");
		String str = sc.nextLine();
		//��ȡ����ĸ
		String str1 = str.substring(0,1);
		str1 = str1.toUpperCase();
		//��ȡʣ���ַ�
		String str2 = str.substring(1, str.length());
		str2 = str2.toLowerCase();
		System.out.println("ת������ַ����ǣ�");
		System.out.println(str1+str2);
	}
}
