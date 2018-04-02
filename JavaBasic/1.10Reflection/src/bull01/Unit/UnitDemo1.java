package bull01.Unit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class UnitDemo1 {
	/*
	 * Junit：
	 * 1.在运行的方法上添加注解@Test
	 * 2.右键以Junit运行
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
	
	//测试方法前执行,类似打开资源
	@Before
	public void myBefore() {
		System.out.println("this is before");
	}
	
	//测试方法之后执行,类似释放资源
	@After
	public void myAfter() {
		System.out.println("this is after");
	}
}
