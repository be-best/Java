package com.zws;

import java.util.Scanner;

public class Switchdemo {
	public static void main(String[] args) {
		Scanner week = new Scanner(System.in);
		System.out.println("������һ������");
		int weekday = week.nextInt();
		
		switch(weekday){
		case 1:
			System.out.println("����һ");
			break;
		case 2:
			System.out.println("���ڶ�");
			break;
		case 3:
			System.out.println("������");
			break;
		case 4:
			System.out.println("������");
			break;
		case 5:
			System.out.println("������");
			break;
		case 6:
			System.out.println("������");
			break;
		case 7:
			System.out.println("������");
			break;
		default:
			System.out.println("���������������");
			break;
		}
	}
}
