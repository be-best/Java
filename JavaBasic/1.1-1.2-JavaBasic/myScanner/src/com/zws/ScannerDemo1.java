package com.zws;

import java.util.Scanner;



public class ScannerDemo1 {
	public static void main(String[] args) {
		//����һ������
		Scanner sc = new Scanner(System.in);
		 System.out.println("�������һ�����ݣ�");
		 //���÷�����������
		 int i = sc.nextInt();
		 System.out.println("������ڶ������ݣ�");
		 int j = sc.nextInt();
		 System.out.println("��="+(i+j));
	}
}
