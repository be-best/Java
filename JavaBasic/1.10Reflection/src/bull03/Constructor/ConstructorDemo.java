package bull03.Constructor;

import java.lang.reflect.Constructor;
import org.junit.Test;

/*
 * 反射构造方法
 */
public class ConstructorDemo {
	@Test
	public void method() {
		//无参构造
		Bean be = new Bean();
	}
	
	@Test
	public void method1() throws Exception  {
		/*
		 * 通过无参构造方法获得实例化对象
		 * 1.获得Class对象clazz
		 * 2.通过clazz获得无参构造
		 * 3.通过构造对象获得实例化对象
		 */
		//获得Class对象clazz
		Class clazz = Class.forName("bull03.Constructor.Bean");
		
		//获得无参构造，相当于Bena();
		//getConstructor();获得指定形参列表的构造方法
		Constructor cons = clazz.getConstructor();
		
		//通过构造获得实例化对象,相当于new Bean();
		//newInstance();创建实例对象，需要设置实际参数
		Object obj = cons.newInstance();
		System.out.println(obj);
	}
	
	@Test
	public void method2() throws Exception{
		/*
		 * 通过有参构造获得实例	
		 */
		//获得Class对象
		Class clazz = Class.forName("bull03.Constructor.Bean");
		//获得构造，必须指定形参.(String.class,int.class)参考获取Java对象方式2。
		Constructor cons = clazz.getConstructor(String.class,int.class);
		//获得实例对象，必须指定实际参数
		Object obj = cons.newInstance("aaa",10);
		System.out.println(obj);
	}
	
	@Test
	public void method3() throws Exception {
		/*
		 * 无参构造快速获得实例方式
		 */
		//获得Class
		Class clazz = Class.forName("bull03.Constructor.Bean");
		//通过clazz直接创建对象
		Object obj = clazz.newInstance();
		System.out.println(obj);
	}
}
