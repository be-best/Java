package bull02.ThreadImpelement;
/*
 * ���̵߳�ʵ�ַ�ʽһ��
 * 		��������ΪThread�����࣬��������дThread��run������������ɷ��䲢�����������ʵ��
 * 
 * Thread��
 * 		String getName();�����߳�����
 * 		void setName(String name);�ı������߳�����
 * 
 * CPU��ִ�г����̣߳���˳��������ġ�
 * 
 * �����������̣߳����ǿ������������ﴴ������̡߳�������ǵ��߳���ô��������ķ�������˳��������ģ���Ȼ����������
 * 		public static void main(String[] args) {
 * 			//�����ǰ�˳��ִ�еģ������ǵ��̡߳����߳������˳��ִ�С�
 * 			method1();
 * 			method2()
 * 		}
 * 
 */
public class ThreadDemo1 {
	public static void main(String[] args) {
		MyThread mt1 = new MyThread();
		//��д����
		mt1.setName("�߳�1");
		mt1.start();
		
		MyThread mt2 = new MyThread();
		//��д����
		mt2.setName("�߳�2");
		mt2.start();
	}
}
