	package bull02.ThreadImpelement;
	/*
	 * ģ���վ��Ʊ
	 */
	public class TicketsTest {
		public static void main(String[] args) {
			//����Runnable����
			TicketsSell ts = new TicketsSell();
			//�����̶߳���
			Thread t1 = new Thread(ts);
			t1.setName("����1");
			Thread t2 = new Thread(ts);
			t2.setName("����2");
			Thread t3 = new Thread(ts);
			t3.setName("����3");
			
			t1.start();
			t2.start();
			t3.start();
		}
	}
