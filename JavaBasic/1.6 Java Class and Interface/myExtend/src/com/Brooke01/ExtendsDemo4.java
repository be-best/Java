package com.Brooke01;
/*
 * ��������д
 */
public class ExtendsDemo4 {
	public static void main(String[] args) {
		NewPhone np = new NewPhone();
		np.call();
	}
}

class Phone {
	public void call() {
		System.out.println("����Phone");
	}
}

class NewPhone extends Phone {
	//��������д
	@Override  //ע��
	public void call() {
		System.out.println("����NewPhone");
		super.call();
	}
	
}