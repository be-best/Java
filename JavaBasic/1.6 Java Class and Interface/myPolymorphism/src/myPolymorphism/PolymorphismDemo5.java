package myPolymorphism;

public class PolymorphismDemo5 {
	public static void main(String[] args) {
		Factory1 fac = new Factory1();
		fac.creatPhone(new MiNote1());
		fac.creatPhone(new RedMi1());
	}
}

//������
class Factory1 {
	public void creatPhone(RedMi1 redMi1) {
		redMi1.call();
	}
	
	public void creatPhone(MiNote1 miNote1) {
		miNote1.call();
		
	}
}

//С����
class MiNote1 {
	public void call() {
		System.out.println("С��Note��绰");
	}
}
//������
class RedMi1 {
	public void call() {
		System.out.println("���״�绰");
	}
}