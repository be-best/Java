package com.zws;

public class MethodDemo {
	public static void main(String[] args) {
		//单独调用,没有意义
		sum(10,20);
		//输出调用，不够好，有可能需要用到结果
		System.out.println(sum(10,20));
		//赋值调用
		int sums = sum(10,30);
		System.out.println(sums);
	}
	public static int sum(int a,int b){
		int c = a+b;
		return c;
	}
}
