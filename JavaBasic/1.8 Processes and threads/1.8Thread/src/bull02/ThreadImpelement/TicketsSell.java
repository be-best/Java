package bull02.ThreadImpelement;
/*
 * ����ʵ��Runnable�ķ�ʽ
 * 
 * ͬ��������ʹ�ùؼ���synchronized���εķ�����һ����һ���̷߳��ʣ�����������ȫ����ס�������߳��޷�����
 * 
 * ע�⣺
 * 	�Ǿ�̬��������������this
 *  ��̬�������������ǵ�ǰ����ֽ������
 */
public class TicketsSell implements Runnable {
	static int tickets = 100;
	//����������
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
	//�Ǿ�̬����;��������this
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
	//��̬����;�������ǵ�ǰ����ֽ������
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
