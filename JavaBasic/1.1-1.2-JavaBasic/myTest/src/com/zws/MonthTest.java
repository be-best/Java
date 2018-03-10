package com.zws;

import java.util.Scanner;

public class MonthTest {
	public static void main(String[] args) {
		while(true) {
			Scanner sc = new Scanner(System.in);
			System.out.println("请输入月份：");
			int month = sc.nextInt();
			judgeSeason(month);
		}
	}
	public static void judgeSeason(int month) {
		if((month == 3)||(month == 4)||(month == 5)){
			System.out.println(month+"是春季");
		}
		else if((month == 6)||(month == 7)||(month == 8)){
			System.out.println(month+"是夏季");
		}
		else if((month == 9)||(month == 10)||(month == 11)){
			System.out.println(month+"是秋季");
		}
		else if((month == 1)||(month == 2)||(month == 12)){
			System.out.println(month+"是冬季");
		}
		else{
			System.out.println("你输入的月份有误！");
		}
	}
}
