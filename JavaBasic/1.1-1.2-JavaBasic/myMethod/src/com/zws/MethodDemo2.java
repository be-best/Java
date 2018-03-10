package com.zws;

import java.util.Scanner;

public class MethodDemo2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("请输入第一个数据：");
		int num1 = sc.nextInt();
		System.out.println("请输入第二个数据：");
		int num2 = sc.nextInt();
		System.out.println("请输入第三个数据：");
		int num3 = sc.nextInt();
		int num = ifmax(num1,num2,num3);
		boolean comp = compare(num1,num2);
		System.out.println("比较大的值是："+num);
		System.out.println("a,b是否相等:"+comp);
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
