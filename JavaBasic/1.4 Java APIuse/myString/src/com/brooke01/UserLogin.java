package com.brooke01;

import java.util.Scanner;

public class UserLogin {
	public static void main(String[] args) {
		String str1 = "admin";
		String str2 = "admin";
		
		Scanner sc = new Scanner(System.in);
		for(int x=0;x<3;x++) {
			System.out.println("�������û�����");
			String userName = sc.nextLine();
			System.out.println("���������룺");
			String passWd = sc.nextLine();
			
			if ((str1.equals(userName))&&(str2.equals(passWd))) {
				System.out.println("��½�ɹ���");
				break;
			}
			else {
				if((2-x)>0) {
					System.out.println("��½ʧ�ܣ��㻹��"+(2-x)+"�λ���");
				}
				else {
					System.out.println("�û��˻����������������Ա��ϵ��");
				}
			}
		}
	}
}
