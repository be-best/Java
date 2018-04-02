package bull03.Constructor;

import java.lang.reflect.Constructor;
import org.junit.Test;

/*
 * ���乹�췽��
 */
public class ConstructorDemo {
	@Test
	public void method() {
		//�޲ι���
		Bean be = new Bean();
	}
	
	@Test
	public void method1() throws Exception  {
		/*
		 * ͨ���޲ι��췽�����ʵ��������
		 * 1.���Class����clazz
		 * 2.ͨ��clazz����޲ι���
		 * 3.ͨ�����������ʵ��������
		 */
		//���Class����clazz
		Class clazz = Class.forName("bull03.Constructor.Bean");
		
		//����޲ι��죬�൱��Bena();
		//getConstructor();���ָ���β��б�Ĺ��췽��
		Constructor cons = clazz.getConstructor();
		
		//ͨ��������ʵ��������,�൱��new Bean();
		//newInstance();����ʵ��������Ҫ����ʵ�ʲ���
		Object obj = cons.newInstance();
		System.out.println(obj);
	}
	
	@Test
	public void method2() throws Exception{
		/*
		 * ͨ���вι�����ʵ��	
		 */
		//���Class����
		Class clazz = Class.forName("bull03.Constructor.Bean");
		//��ù��죬����ָ���β�.(String.class,int.class)�ο���ȡJava����ʽ2��
		Constructor cons = clazz.getConstructor(String.class,int.class);
		//���ʵ�����󣬱���ָ��ʵ�ʲ���
		Object obj = cons.newInstance("aaa",10);
		System.out.println(obj);
	}
	
	@Test
	public void method3() throws Exception {
		/*
		 * �޲ι�����ٻ��ʵ����ʽ
		 */
		//���Class
		Class clazz = Class.forName("bull03.Constructor.Bean");
		//ͨ��clazzֱ�Ӵ�������
		Object obj = clazz.newInstance();
		System.out.println(obj);
	}
}
