package com.zws;

import java.util.Scanner;
/*
 * ������λ��
 */
public class ArrIndex {
	public static void main(String[] args) {
		int[] arr = {1,2,3,4,5};
		while(true){
			Scanner sc = new Scanner(System.in);
			int num = sc.nextInt();
			int index = getIndex(arr,num);
			System.out.println("�����ǣ�"+index);	
		}
	}
	
	public static int getIndex(int[] arr,int num) {
		for(int i = 0;i<arr.length;i++) {
			if(arr[i] == num){
				return i;
			}
		}
		return -1;
	}
}
