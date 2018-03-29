package bull02.ThreadImpelement;
/*
 * 多线程的实现方式二：
 * 		声明实现Runnable接口的类，然后实现run方法，然后可以分配该类的实例，在创建Thread时作为一个参数
 * 		
 * Thread(Runable target);
 * static Thread currentThread();返回当前线程对象
 * 
 * 既然有了Thread为什么还要有Runnable?
 * 		因为类的单一继承，Thread是类，一个类如果继承了Thread类那就不能继承其他类
 * 		而Runnable是接口，一个类可以实现多个接口，同时也可以去继承其他类
 */
public class ThreadDemo2 {
	public static void main(String[] args) {
		//两个线程不共享一个Runnable对象
		method1();
		//两个线程共享一个Runnable对象
		method2();
	}

	private static void method2() {
		//创建线程实例
		MyThread2 mt23 = new MyThread2(300);
		Thread t2 = new Thread(mt23);
		//重写线程名称
		t2.setName("线程3");
		//启动线程
		t2.start();
		
		Thread t4 = new Thread(mt23);
		t4.setName("线程4");
		t4.start();
	}

	private static void method1() {
		MyThread2 mt21 = new MyThread2(100);
		Thread t = new Thread(mt21);
		t.setName("线程1");
		t.start();
		
		MyThread2 mt22 = new MyThread2(200);
		Thread t1= new Thread(mt22);
		t1.setName("线程2");
		t1.start();
	}
}
