package com.Brooke02;
/*
 * 工具类
 */
public class MyArrays {
	//将类构造私有，其他类就不能创建这个类的对象了。
	private MyArrays() {
		
	}
	
	//返回最大值
	public static int getMax(int[] array) {
		int max = 0;
		for(int x=0;x<array.length;x++) {
			if(array[x] > max) {
				max = array[x];
			}
		}
		return max;
	}
	
	//返回与指定值相同的索引
	public static int getIndex(int[] array,int index) {
		for(int x=0;x<array.length;x++) {
			if(array[x] == index) {
				return x;
			}
		}
		//假如数组里没有与index相等的值，那么return -1;
		return -1;
	}
}
