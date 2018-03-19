package com.Brooke01;
/*
 * 局部代码块
 */
public class CodeBlockDemo1 {
	public static void main(String[] args) {
		//局部代码块：存在于方法中，控制变量的生命周期（作用域）
		{
			int num = 10;
			System.out.println(num);
		}
		
		//这边不能调用局部代码块里面的变量
		//System.out.println(num);
	}
}
