package bull04.Method;

import java.lang.reflect.Method;

import org.junit.Test;

/*
 * public���ͷ���
 */
public class PublicMethod {
	@Test
	public void method1() {
		Bean be = new Bean();
		be.setName("aaa");
		be.setAge(10);
		String name = be.getName();
		int age = be.getAge();
		System.out.println(name+"---"+age);
	}
	
	//�÷���ʵ����������
	@Test
	public void method2() throws Exception {
		//1.��ȡʵ��
		Class clazz = Class.forName("bull04.Method.Bean");
		Object obj = clazz.newInstance();
		
		//2.ͨ����ȡBean�е�set������������
		//2.1��÷���,��Ҫ��ȷ�β��б�String.class��;
		//��ȡ������������setName
		Method methodSetName = clazz.getMethod("setName", String.class);
		//��ȡ�������䷽��setAge
		Method methodSetAge = clazz.getMethod("setAge", int.class);
		
		//2.2ִ�з���
		//ȷ��ʵ�����󣬲�ִ��ȷ������������ʵ�ʲ�����
		//invoke�������Ϊִ�е���˼
		methodSetName.invoke(obj, "aaa");//��������
		methodSetAge.invoke(obj, 10);//��������
		
		System.out.println(obj);
	}
	
	//��method2�Ļ����ϣ���get������ȡ����
		@Test
		public void method3() throws Exception {
			//1.��ȡʵ��
			Class clazz = Class.forName("bull04.Method.Bean");
			Object obj = clazz.newInstance();
			
			//2.ͨ����ȡBean�е�set������������
			//2.1��÷���,��Ҫ��ȷ�β��б�String.class��;
			//��ȡ������������setName
			Method methodSetName = clazz.getMethod("setName", String.class);
			//��ȡ�������䷽��setAge
			Method methodSetAge = clazz.getMethod("setAge", int.class);
			
			//2.2ִ�з���
			//ȷ��ʵ�����󣬲�ִ��ȷ������������ʵ�ʲ�����
			//invoke�������Ϊִ�е���˼
			methodSetName.invoke(obj, "aaa");//��������
			methodSetAge.invoke(obj, 10);//��������
			
			//3.ͨ��get������ȡ����
			//�ֱ��ȡ������ȡ�����������getName��getAge����
			//��Ҫע�����get����û����ʽ�������������Բ���ָ���β����͡�
			Method methodGetName = clazz.getMethod("getName");
			Method methodGetAge = clazz.getMethod("getAge");
			
			//invoke���ص���object��������Ҫ����ǿ��װ����invoke�������Ų���ָ��������
			String str = (String) methodGetName.invoke(obj);
			int age = (int) methodGetAge.invoke(obj);
			
			System.out.println(str+"---"+age);
		}
}
