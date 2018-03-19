package myPolymorphism;

public class PolymorphismDemo4 {
	public static void main(String[] args) {
		Factory fac = new Factory();
		fac.creatPhone(new MiNote());
		fac.creatPhone(new RedMi());
	}
}

//������
class Factory {
	public void creatPhone(Phone p) {
		p.call();
	}
}
//�ӿ�,ʵ��call()����
interface Phone {
	public void call();
}
//С����
class MiNote implements Phone {
	public void call() {
		System.out.println("С��Note��绰");
	}
}
//������
class RedMi implements Phone {
	public void call() {
		System.out.println("���״�绰");
	}
}