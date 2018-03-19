package com.Brooke;

public class InterfaceDemo2 {
	public static void main(String[] args) {
		
	}
}

//多继承，一个接口可以继承多个接口
interface InterA extends InterB,InterC{
	
}

interface InterB {
	public abstract void method1();
}

interface InterC  {
	public abstract void method2();
}

interface InterD  {
	public abstract void method3();
}


//多实现，一个类可以实现多个接口
class Demo implements InterA,InterD {

	@Override
	public void method1() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void method2() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void method3() {
		// TODO Auto-generated method stub
		
	}

	


	
}