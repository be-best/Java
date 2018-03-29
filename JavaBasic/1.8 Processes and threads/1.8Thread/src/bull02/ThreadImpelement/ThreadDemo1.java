package bull02.ThreadImpelement;
/*
 * 多线程的实现方式一：
 * 		将类声明为Thread的子类，该子类重写Thread的run方法，接下类可分配并启动该子类的实例
 * 
 * Thread：
 * 		String getName();返回线程名称
 * 		void setName(String name);改变设置线程名称
 * 
 * CPU的执行程序（线程）的顺序是随机的。
 * 
 * 主方法：单线程，但是可以在主方法里创建多个线程。如果不是单线程那么主方法里的方法调用顺序是随机的，显然不是这样。
 * 		public static void main(String[] args) {
 * 			//方法是按顺序执行的，所以是单线程。多线程是随机顺序执行。
 * 			method1();
 * 			method2()
 * 		}
 * 
 */
public class ThreadDemo1 {
	public static void main(String[] args) {
		MyThread mt1 = new MyThread();
		//重写名称
		mt1.setName("线程1");
		mt1.start();
		
		MyThread mt2 = new MyThread();
		//重写名称
		mt2.setName("线程2");
		mt2.start();
	}
}
