package bull02.ThreadImpelement;
/*
 * 采用实现Runnable的方式
 * 
 * 同步方法：使用关键字synchronized修饰的方法，一旦被一个线程访问，则整个方法全部锁住，其他线程无法访问
 * 
 * 注意：
 * 	非静态方法的锁对象是this
 *  静态方法的锁对象是当前码的字节码对象
 */
public class TicketsSell implements Runnable {
	static int tickets = 100;
	//创建锁对象
	Object obj = new Object();
	@Override
	public void run() {
		while(true) {
			synchronized (obj) {
				if(tickets > 0) {
					
					try {
						Thread.sleep(100);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					System.out.println(Thread.currentThread().getName()+":"+tickets--);
			}
			}
			
			
				//method();
				//method1();			
		}
		
	}
	//非静态方法;锁对象是this
	private synchronized void method() {
			if(tickets > 0) {
					
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println(Thread.currentThread().getName()+":"+tickets--);
		}
	}
	//静态方法;锁对象是当前码的字节码对象
	private static synchronized void method1() {
		if(tickets > 0) {
				
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println(Thread.currentThread().getName()+":"+tickets--);
	}
}
	

}
