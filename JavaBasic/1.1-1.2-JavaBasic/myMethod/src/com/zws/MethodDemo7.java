package com.zws;
/*
 * ��������������������ͣ�
 * 			��ʽ�����ĸı�ֱ��Ӱ��ʵ�ʲ���
 */

public class MethodDemo7 {
	public static void main(String[] args) {
		int[] arr = {1,2,3,4,5};
		for(int i=0;i<arr.length;i++) {
			System.out.println(arr[i]);
		}
		change(arr);
		System.out.println("-------------");
		for(int i=0;i<arr.length;i++) {
			System.out.println(arr[i]);
		}
	}
	public static void change(int[] arr) {
		for(int i=0;i<arr.length;i++){
			arr[i]+=1;
		}
	}
}
