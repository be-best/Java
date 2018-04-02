package bull01.Unit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class UnitDemo1 {
	/*
	 * Junit��
	 * 1.�����еķ��������ע��@Test
	 * 2.�Ҽ���Junit����
	 */
	@Test
	public void method1() {
		System.out.println("this is method1");
	}
	
	@Test
	public void method2() {
		System.out.println("this is method2");
	}
	
	@Test
	public void method3() {
		System.out.println("this is method3");
	}
	
	//���Է���ǰִ��,���ƴ���Դ
	@Before
	public void myBefore() {
		System.out.println("this is before");
	}
	
	//���Է���֮��ִ��,�����ͷ���Դ
	@After
	public void myAfter() {
		System.out.println("this is after");
	}
}
