package myPolymorphism;
/*
 * ��̬�ĳ�Ա�ص㣺
 * 		��Ա����������ʱ����ߣ�����ʱ�����
 * 		��Ա����������ʱ����ߣ�����ʱ���ұ�
 * 		��̬����:����ʱ����ߣ�����ʱ�����
 */
public class PolymorphismDemo2 {
	public static void main(String[] args) {
		Dad d = new Son();
		int num = d.num;
		System.out.println(num);
		d.show();
		d.stat();//ʹ�ñ������þ�̬��������ʵ�൱�ڱ������͵���ȥ����
	}
}

class Dad {
	int num = 10;
	public void show() {
		System.out.println("���Ǹ����Ա����");
	}
	
	public static void stat() {
		System.out.println("���Ǹ��ྲ̬����");
	}
}

class Son extends Dad {
	int num = 20;
	public void show() {
		System.out.println("���������Ա����");
	}
	
	public static void stat() {
		System.out.println("�������ྲ̬����");
	}
}