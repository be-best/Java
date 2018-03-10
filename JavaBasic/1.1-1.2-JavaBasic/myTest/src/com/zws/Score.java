package com.zws;

import java.util.Scanner;
/*
 * 去掉最高分最低分求平均分
 */
public class Score {
	public static void main(String[] args) {
		int[] arr = new int[6];
		Scanner sc = new Scanner(System.in);
		for(int i = 0;i<arr.length;i++) {
			System.out.println("请输入第"+(i+1)+"个评委分数：");
			arr[i] = sc.nextInt();
		}
		int num;
		for(int i = 1;i<arr.length;i++) {
			if(arr[i]>arr[i-1]) {
				num = arr[i-1];
				arr[i-1] = arr[i];
				arr[i] = num;
			}
		}
		int sum = 0;
		for(int i=1;i<arr.length-1;i++){
			sum+=arr[i];
		}
		System.out.println("结果是："+(sum/4));
	}
}
