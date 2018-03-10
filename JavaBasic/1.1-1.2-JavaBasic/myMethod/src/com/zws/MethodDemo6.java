package com.zws;

/*
 * 形式参数的改变不影响实际参数的改变
 * 形式参数：用于接收实际参数的变量
 * 实际参数：实际参与运算的变量
 */
public class MethodDemo6 {
	public static void main(String[] args) {
		int a = 10;  //实际参数
		int b = 20;  //实际参数
		System.out.println("a:"+a+",b:"+b);
		change(a,b);
		System.out.println("a:"+a+",b:"+b);
	}
	public static void change(int a,int b){ //这里a,b为形式参数
		a = a+30;
		b = b+40;
		System.out.println("a:"+a+",b:"+b);
	}
}
