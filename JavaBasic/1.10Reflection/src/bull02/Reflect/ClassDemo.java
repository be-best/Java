package bull02.Reflect;

import org.junit.Test;

/*
 * Java�ṩ���ַ�ʽ���Class����
 * ��ͬ��Ӧ�ó�����Ҫ��ͬ�ķ�ʽ���Class����	
 * 
 * ��ʽ��
 * 1.ͨ���ַ�����ȫ�޶����������
 * 		��ʽ��Class clazz	 = Class.forName("�ַ���");
 * 		ȫ�޶�����������+����
 *   Ӧ�ó�����ȷ�����͵�
 * 			
 * 2.ͨ��Java���ͻ��
 * 		��ʽ��Class clazz = ����.class;
 *   Ӧ�ó������ڷ����ڲ�ͨ������������͵�
 *   
 * 3.ͨ��ʵ��������
 * 		��ʽ��Class clazz = obj.getClass();
 *   Ӧ�ó�����ͨ�����û���ַ�����
 */
public class ClassDemo {
	
	@Test
	public void demo1() throws ClassNotFoundException {
		Class clazz = Class.forName("bull02.Reflect.Bean");
		System.out.println(clazz);
	}
	
	@Test
	public void demo2() {
		Class clazz = Bean.class;
		System.out.println(clazz);
	}
	
	@Test
	public void demo3() {
		Bean be = new Bean();
		Class clazz = be.getClass();
		System.out.println(clazz);
	}
}
