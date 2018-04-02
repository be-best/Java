package bull04.Method;

import java.lang.reflect.Method;

import org.junit.Test;

/*
 * main����
 */
public class MainMethod {
	@Test
	public void method() throws Exception {
		//1.��ȡClass����main�����Ǿ�̬�������Բ���Ҫ��ȡʵ��
		Class clazz = Class.forName("bull04.Method.Bean");
		
		//2.��ȡmain����
		Method mainMethod = clazz.getMethod("main", String[].class);	
		
		//3.ִ��main����
		/*
		 * ����1��Ϊʵ�����󣨱���������static��������Ҫʵ��
		 * ����2��main����ִ��ʱ��ʵ�ʲ���
		 * �ɱ������ִ��ʱ��JVM�ڲ�������ʵ�������ɢ,��ɶ������
		 * 		method.invoke(null,args);
		 * 		method.invoke(null,"abc","123","xxx");
		 */
		String[] args = {"abc","123","xxx"};
		//mainMethod.invoke(null, args);//����д��
		//3.1ִ�з�ʽһ����Stringת��ΪObject���ɱ����������������
		mainMethod.invoke(null, (Object)args);
		//3.2ִ�з�ʽ�����ṩ��ά���飬args����Ϊ��ά����ĵ�һ����
		mainMethod.invoke(null, new Object[] {args});
	}
}
