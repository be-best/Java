package com.brooke02;
/*
 * 统计大小写字母及数字个数
 */
import java.util.Scanner;

public class StringTest1 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("请输入一个字符串：");
		String str = sc.nextLine();
		
		int bigCount = 0;
		int smallCount = 0;
		int num = 0;
		for(int x=0;x<str.length();x++) {
			char chs = str.charAt(x);
			if(chs>='A'&&chs<='Z') {
				bigCount++;
			}
			else if(chs>='a'&&chs<='z') {
				smallCount++;
			}
			else if(chs>='0'&&chs<='9') {
				num++;
			}
		}
		
		System.out.println("大写字母："+bigCount);
		System.out.println("小写字母："+smallCount);
		System.out.println("数字："+num);
	}
}
