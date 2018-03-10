package com.zws;

public class HuiwenNum {
	public static void main(String[] args) {
		for(int i = 10000;i<99999;i++) {
			hwNum(i);
		}
	}
	public static void hwNum(int num) {
		int ge = num%10;
		int shi = num/10%10;
		int qian = num/10/10/10%10;
		int wan = num/10/10/10/10%10;
		if((ge == wan)&&(shi == qian)) {
			System.out.println(num);
		}
	}
}
