package com.zws;

public class ArrayTest {
	public static void main(String[] args) {
		int[] arr = {12,33,44,55,66};
		int max = arr[0];
		for(int x = 0;x < arr.length;x++){
			if(arr[x] > max){
				max = arr[x];
			}
		}
		System.out.println(max);
	}

}
