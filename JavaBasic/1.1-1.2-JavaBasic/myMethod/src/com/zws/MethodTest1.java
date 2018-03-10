package com.zws;

public class MethodTest1 {
	public static void main(String[] args) {
		int[] arr = {1,2,3,4,5};
		printArr(arr);
		int max = getMax(arr);
		System.out.println(max);
	}
	public static void printArr(int[] arr) {
		System.out.print("[");
		for(int i = 0;i<arr.length;i++) {
			if(i == arr.length-1){
				System.out.println(arr[i]+"]");
			}
			else{
				System.out.print(arr[i]+",");
			}
		}
	}
	public static int getMax(int[] arr) {
		int max = arr[0];
		for(int i=0;i<arr.length;i++) {
			if(arr[i]>max) {
				max = arr[i];
			}
		}
		return max;
	}
}
