package com.zws;

import java.util.Scanner;
/*
 * ���鷴ת����
 */
public class ArrChange {
	public static void main(String[] args) {
		int[] arr = new int[5];
		Scanner sc = new Scanner(System.in);
		for(int i = 0;i<arr.length;i++) {
			System.out.println("�������"+(i+1)+"������Ԫ��:");
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
		System.out.print("������������");
		for(int i = 0;i<arr.length;i++) {
			System.out.print(arr[i]+" ");
		}
	}
}
