	package bull02.ThreadImpelement;
	/*
	 * 模拟火车站售票
	 */
	public class TicketsTest {
		public static void main(String[] args) {
			//创建Runnable对象
			TicketsSell ts = new TicketsSell();
			//创建线程对象
			Thread t1 = new Thread(ts);
			t1.setName("窗口1");
			Thread t2 = new Thread(ts);
			t2.setName("窗口2");
			Thread t3 = new Thread(ts);
			t3.setName("窗口3");
			
			t1.start();
			t2.start();
			t3.start();
		}
	}
