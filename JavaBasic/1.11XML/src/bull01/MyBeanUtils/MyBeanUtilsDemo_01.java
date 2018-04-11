package bull01.MyBeanUtils;

import java.lang.reflect.InvocationTargetException;
import java.util.Map;

import org.apache.commons.beanutils.BeanUtils;
import org.junit.Test;

/*
 * BeanUtils自定义工具类
 */
public class MyBeanUtilsDemo_01 {
	/*
	 * Class<T> 此处的T就是一个变量，在运行时接收具体类型。例如：User
	 * 变量必须先定义在使用
	 * 		泛型变量的定义方式：修饰符 <变量名> 返回值。
	 * 		例如下面的方法：static <User> User
	 */
	@Test
	public static <User> User populate(Class <User> beanClass,Map<String,String[]> properties) {
		//静态方法，TestTool工具类那边直接用类名访问
		try {
			//利用反射创建实例，beanClass是一个类对象
			User obj = beanClass.newInstance();
			//填充数据
			BeanUtils.populate(obj , properties);
			return obj;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			throw new RuntimeException(e);
		}
	}
}
