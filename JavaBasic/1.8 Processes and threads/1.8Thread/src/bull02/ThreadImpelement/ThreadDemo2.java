package bull02.ThreadImpelement;
/*
 * ���̵߳�ʵ�ַ�ʽ����
 * 		����ʵ��Runnable�ӿڵ��࣬Ȼ��ʵ��run������Ȼ����Է�������ʵ�����ڴ���Threadʱ��Ϊһ������
 * 		
 * Thread(Runable target);
 * static Thread currentThread();���ص�ǰ�̶߳���
 * 
 * ��Ȼ����ThreadΪʲô��Ҫ��Runnable?
 * 		��Ϊ��ĵ�һ�̳У�Thread���࣬һ��������̳���Thread���ǾͲ��ܼ̳�������
 * 		��Runnable�ǽӿڣ�һ�������ʵ�ֶ���ӿڣ�ͬʱҲ����ȥ�̳�������
 */
public class ThreadDemo2 {
	public static void main(String[] args) {
		//�����̲߳�����һ��Runnable����
		method1();
		//�����̹߳���һ��Runnable����
		method2();
	}

	private static void method2() {
		//�����߳�ʵ��
		MyThread2 mt23 = new MyThread2(300);
		Thread t2 = new Thread(mt23);
		//��д�߳�����
		t2.setName("�߳�3");
		//�����߳�
		t2.start();
		
		Thread t4 = new Thread(mt23);
		t4.setName("�߳�4");
		t4.start();
	}

	private static void method1() {
		MyThread2 mt21 = new MyThread2(100);
		Thread t = new Thread(mt21);
		t.setName("�߳�1");
		t.start();
		
		MyThread2 mt22 = new MyThread2(200);
		Thread t1= new Thread(mt22);
		t1.setName("�߳�2");
		t1.start();
	}
}
