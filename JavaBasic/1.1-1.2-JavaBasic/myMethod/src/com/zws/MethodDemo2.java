package com.zws;

import java.util.Scanner;

public class MethodDemo2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("�������һ�����ݣ�");
		int num1 = sc.nextInt();
		System.out.println("������ڶ������ݣ�");
		int num2 = sc.nextInt();
		System.out.println("��������������ݣ�");
		int num3 = sc.nextInt();
		int num = ifmax(num1,num2,num3);
		boolean comp = compare(num1,num2);
		System.out.println("�Ƚϴ��ֵ�ǣ�"+num);
		System.out.println("a,b�Ƿ����:"+comp);
	}
	public static int ifmax(int a,int b,int c){
		int max1 = (a>b)?a:b;
		int max = (c>max1)?c:max1;
		return max;
	}
	public static boolean compare(int a,int b){
		if(a == b){
			return true;
	}
		else{
			return false;
		}
	}
}
