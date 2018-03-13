package com.brooke01;

import java.util.Scanner;

public class UserLogin {
	public static void main(String[] args) {
		String str1 = "admin";
		String str2 = "admin";
		
		Scanner sc = new Scanner(System.in);
		for(int x=0;x<3;x++) {
			System.out.println("请输入用户名：");
			String userName = sc.nextLine();
			System.out.println("请输入密码：");
			String passWd = sc.nextLine();
			
			if ((str1.equals(userName))&&(str2.equals(passWd))) {
				System.out.println("登陆成功！");
				break;
			}
			else {
				if((2-x)>0) {
					System.out.println("登陆失败，你还有"+(2-x)+"次机会");
				}
				else {
					System.out.println("用户账户被锁定，请与管理员联系！");
				}
			}
		}
	}
}
