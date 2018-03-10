package com.zws;

import java.util.Scanner;

public class Switchdemo {
	public static void main(String[] args) {
		Scanner week = new Scanner(System.in);
		System.out.println("请输入一个数据");
		int weekday = week.nextInt();
		
		switch(weekday){
		case 1:
			System.out.println("星期一");
			break;
		case 2:
			System.out.println("星期二");
			break;
		case 3:
			System.out.println("星期三");
			break;
		case 4:
			System.out.println("星期四");
			break;
		case 5:
			System.out.println("星期五");
			break;
		case 6:
			System.out.println("星期六");
			break;
		case 7:
			System.out.println("星期日");
			break;
		default:
			System.out.println("你输入的数据有误");
			break;
		}
	}
}
