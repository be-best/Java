package com.zws;

public class ForTest4 {
	public static void main(String[] args) {
		int num3,num2,num1,sum;
		for(int i = 100;i <= 999;i++){
			num3 = i%10;
			num2 = i/10%10;
			num1 = i/10/10%10;
			sum = num3*num3*num3+num2*num2*num2+num1*num1*num1;
			if(sum == i){
				System.out.println(i);
			}
		}
	}

}
