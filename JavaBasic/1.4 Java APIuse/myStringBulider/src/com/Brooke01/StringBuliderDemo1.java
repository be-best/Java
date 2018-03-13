package com.Brooke01;

public class StringBuliderDemo1 {
	public static void main(String[] args) {
		StringBuilder strBui = new StringBuilder("ssa");
		System.out.println("strBui:"+strBui);
		System.out.println("当前容量："+strBui.capacity());
		System.out.println("长度是："+strBui.length());
	} 
}
