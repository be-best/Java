package com.zws;

import java.util.Scanner;
/*
 * ȥ����߷���ͷ���ƽ����
 */
public class Score {
	public static void main(String[] args) {
		int[] arr = new int[6];
		Scanner sc = new Scanner(System.in);
		for(int i = 0;i<arr.length;i++) {
			System.out.println("�������"+(i+1)+"����ί������");
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
		System.out.println("����ǣ�"+(sum/4));
	}
}
