package com.zws;

import java.util.Scanner;

public class MonthTest {
	public static void main(String[] args) {
		while(true) {
			Scanner sc = new Scanner(System.in);
			System.out.println("�������·ݣ�");
			int month = sc.nextInt();
			judgeSeason(month);
		}
	}
	public static void judgeSeason(int month) {
		if((month == 3)||(month == 4)||(month == 5)){
			System.out.println(month+"�Ǵ���");
		}
		else if((month == 6)||(month == 7)||(month == 8)){
			System.out.println(month+"���ļ�");
		}
		else if((month == 9)||(month == 10)||(month == 11)){
			System.out.println(month+"���＾");
		}
		else if((month == 1)||(month == 2)||(month == 12)){
			System.out.println(month+"�Ƕ���");
		}
		else{
			System.out.println("��������·�����");
		}
	}
}
