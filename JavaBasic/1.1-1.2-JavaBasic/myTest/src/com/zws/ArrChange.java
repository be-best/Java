package com.zws;

import java.util.Scanner;
/*
 * 数组反转遍历
 */
public class ArrChange {
	public static void main(String[] args) {
		int[] arr = new int[5];
		Scanner sc = new Scanner(System.in);
		for(int i = 0;i<arr.length;i++) {
			System.out.println("请输入第"+(i+1)+"个数组元素:");
			arr[i] = sc.nextInt();
		}
		arrChange(arr);
		printArr(arr);
	}
	public static void arrChange(int arr[]) {
//		int[] arrChg = new int[5];
//		for(int i = 0;i<arr.length;i++) {
//		 arrChg[i] = arr[arr.length-1-i];
//		}
//		for(int i = 0;i<arr.length;i++) {
//			 arr[i] = arrChg[i];
//			}
		for(int start=0,end=arr.length-1;start<=end;start++,end--) {
			int temp = arr[start];
			arr[start] = arr[end];
			arr[end] = temp;
		}
	}
	public static void printArr(int arr[]) {
		System.out.print("遍历数组结果：");
		for(int i = 0;i<arr.length;i++) {
			System.out.print(arr[i]+" ");
		}
	}
}
