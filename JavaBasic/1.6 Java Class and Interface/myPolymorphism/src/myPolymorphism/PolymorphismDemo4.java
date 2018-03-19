package myPolymorphism;

public class PolymorphismDemo4 {
	public static void main(String[] args) {
		Factory fac = new Factory();
		fac.creatPhone(new MiNote());
		fac.creatPhone(new RedMi());
	}
}

//生产类
class Factory {
	public void creatPhone(Phone p) {
		p.call();
	}
}
//接口,实现call()方法
interface Phone {
	public void call();
}
//小米类
class MiNote implements Phone {
	public void call() {
		System.out.println("小米Note打电话");
	}
}
//红米类
class RedMi implements Phone {
	public void call() {
		System.out.println("红米打电话");
	}
}