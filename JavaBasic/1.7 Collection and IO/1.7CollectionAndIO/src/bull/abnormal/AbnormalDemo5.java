package bull.abnormal;

import java.io.FileWriter;

/*
 * �쳣�ķ��ࣺ
 * 		����ʱ���쳣��RuntimeException�������������ʱ���쳣���ڱ���ʱ�ڿ���ѡ������߲�����
 * 		����ʱ���쳣��Exception�����࣬��RuntimeException�����࣬�ڱ���ʱ�ڱ��봦��
 */
public class AbnormalDemo5 {
	public static void main(String[] args) {
		//����ʱ���쳣
		//��ָ���쳣
		String str = null;
		System.out.println(str.length());
		
		//����ʱ���쳣������IO��Ҫ������쳣
		try {
			FileWriter fw = new FileWriter("demo5.txt");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
