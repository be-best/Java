package com.Brooke01;
/*
 * 方法的重写
 */
public class ExtendsDemo4 {
	public static void main(String[] args) {
		NewPhone np = new NewPhone();
		np.call();
	}
}

class Phone {
	public void call() {
		System.out.println("我是Phone");
	}
}

class NewPhone extends Phone {
	//方法的重写
	@Override  //注解
	public void call() {
		System.out.println("我是NewPhone");
		super.call();
	}
	
}