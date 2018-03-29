package bull02.ThreadImpelement;

public class MyThread2 implements Runnable {
	int num;
	public MyThread2(int num) {
		this.num = num;
	}
	@Override
	public void run() {
		for(int x = 0;x < 100;x++) {
			Thread t = Thread.currentThread();
			System.out.println(t.getName()+":"+x+":"+num);
			//System.out.println(Thread.currentThread().getName()+":"+x);
		}
	}
	
}
