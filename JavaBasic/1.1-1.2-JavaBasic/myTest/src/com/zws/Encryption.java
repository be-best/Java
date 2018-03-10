package com.zws;

import java.util.Scanner;

/*
 * Êý¾Ý¼ÓÃÜ
 */
public class Encryption {
	public static void main(String[] args) {
		int[] arr = new int[4];
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		encryptionNum(num);
	}
	public static void encryptionNum(int num){
		int ge = (num%10+5)%10;
		int shi = (num/10%10+5)%10;
		int bai = (num/10/10%10+5)%10;
		int qian = (num /10/10/10%10+5)%10;
		int temp = ge;
		ge = qian;
		qian =temp;
		temp = shi;
		shi = bai;
		bai = temp;
		System.out.print(qian);
		System.out.print(bai);
		System.out.print(shi);
		System.out.print(ge);
	}
}
