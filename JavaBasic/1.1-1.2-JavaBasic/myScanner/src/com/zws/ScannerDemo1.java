package com.zws;

import java.util.Scanner;



public class ScannerDemo1 {
	public static void main(String[] args) {
		//创建一个对象
		Scanner sc = new Scanner(System.in);
		 System.out.println("请输入第一个数据：");
		 //调用方法接收数据
		 int i = sc.nextInt();
		 System.out.println("请输入第二个数据：");
		 int j = sc.nextInt();
		 System.out.println("和="+(i+j));
	}
}
