package bull.abnormal;

import javax.management.RuntimeErrorException;

/*
 * �쳣��������֤����������100����С��0�������쳣
 * 	throw:�����쳣��һ�ַ�ʽ�����쳣�׳����ɵ�����������
 * 	throws:�����쳣�ķ�ʽ�����ҽ�������
 * 
 * ע�⣺����׳�(throw)���Ǳ���ʱ���쳣�������ڷ����������׳�(throws)
 * 
 * ����Զ���һ���쳣�ࣿ
 * 		дһ����ȥ�̳�RuntimeException����Exception,Ȼ��ʵ�ֶ�����졣
 */
public class AbnormalDemo6 {
	public static void main(String[] args) {
		
		try {
			checkScore(1001);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void checkScore(int score){
		if(score < 0||score >100) {
			//throw new RuntimeException("run��������");
			//throw new Exception("exc��������");
			throw new MyException("my��������");
		}
		
		System.out.println("���Գɼ�����Ҫ��");
	}
}
