package com.brooke02;
/*
 * ͳ�ƴ�Сд��ĸ�����ָ���
 */
import java.util.Scanner;

public class StringTest1 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("������һ���ַ�����");
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
		
		System.out.println("��д��ĸ��"+bigCount);
		System.out.println("Сд��ĸ��"+smallCount);
		System.out.println("���֣�"+num);
	}
}
