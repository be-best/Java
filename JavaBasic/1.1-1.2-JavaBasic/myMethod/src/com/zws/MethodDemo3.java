package com.zws;

import java.util.Scanner;

public class MethodDemo3 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("请输入第一个数据：");
		int num1 = sc.nextInt();
		System.out.println("请输入第二个数据：");
		int num2 = sc.nextInt();
		boolean comp = compare(num1,num2);
		System.out.println("a,b是否相等:"+comp);
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
