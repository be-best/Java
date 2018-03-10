package com.zws;

import java.util.Scanner;

public class MethodDemo4 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		printNum(num);
		printFlowerNum();
	}
	public static void printNum(int num){
		for(int i=1;i<=num;i++){
			System.out.println(i);
		}
	}
	public static void printFlowerNum(){
		for (int i=100;i<=999;i++){
			int ge = i%10;
			int shi = i/10%10;
			int bai = i/10/10%10;
			if(ge*ge*ge+shi*shi*shi+bai*bai*bai == i){
				System.out.println(i);
			}
		}
	}
}
