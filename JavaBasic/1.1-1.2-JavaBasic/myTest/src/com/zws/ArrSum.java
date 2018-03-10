package com.zws;

public class ArrSum {
	public static void main(String[] args) {
		int[] arr = {171,72,19,16,118,51,210,7,18};
		int sum = 0;
		for(int i = 0;i<arr.length;i++) {
			if(arr[i]%2 == 0) {
				int ge = arr[i]%10;
				int shi = arr[i]/10%10;
				if((ge!=7)&&(shi!=7)){
					sum+=arr[i];
				}
			}
		}
		System.out.println(sum);
	}
}
