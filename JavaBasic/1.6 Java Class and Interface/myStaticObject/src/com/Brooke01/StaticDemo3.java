package com.Brooke01;

public class StaticDemo3 {
	public static void main(String[] args) {
		//static double PI:输出π值
		System.out.println("输出π值："+Math.PI);
		
		//static double abs(double a)返回绝对值
		System.out.println("返回绝对值："+-10+"---"+Math.abs(-10));
		
		//static double ceil(double a) 向上取整
		System.out.println("向上取整:"+1.2+"---"+Math.ceil(1.2));
		
		//static double floor(double a) 向下取整
		System.out.println("向下取整:"+1.8+"---"+Math.floor(1.8));
		
		//static long round(double a) 四舍五入
		System.out.println("四舍五入："+1.2+"---"+Math.round(1.2));
		
		//static double max(double a,double b) 取最大
		System.out.println("取最大："+"(3,4)"+"---"+Math.max(3, 4));
		
		//static dpuble pow(double a,double b) 返回第一个参数的第二个参数次幂
		System.out.println("a的b次方："+"(3,2)"+"---"+Math.pow(3, 2));
		
		//static double random() 返回一个大于0小于1的随机数
		System.out.println("大于0小于1的随机数："+Math.random());
	}
}
