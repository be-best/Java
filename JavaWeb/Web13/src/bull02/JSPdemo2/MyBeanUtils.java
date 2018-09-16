package bull02.JSPdemo2;
/**
 *内省:用来获得JavaBean的属性及属性的get或set方法.
	* JavaBean:就是一个满足了特定格式的Java类:
	* 需要提供无参数的构造方法:
	* 属性私有
	* 对私有的属性提供public的get/set方法.
 */
import java.beans.BeanInfo;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Method;
import java.util.Map;

import org.junit.Test;

public class MyBeanUtils {
	@Test
	public static void populate(Object obj,Map<String,String[]> map) throws Exception {
		//获得类的所有属性的名称
		BeanInfo beanInfo = Introspector.getBeanInfo(obj.getClass());
		System.out.println("beanInfo:"+beanInfo);//beanInfo:java.beans.GenericBeanInfo@1cfbc8b9

		//获得类中的所有属性
		PropertyDescriptor[] pds = beanInfo.getPropertyDescriptors();
		for (PropertyDescriptor pd : pds) {
			System.out.println("pd:"+pd);
/**
 * pd:java.beans.PropertyDescriptor[name=class; propertyType=class java.lang.Class; readMethod=public final native java.lang.Class java.lang.Object.getClass()]
 * pd:java.beans.PropertyDescriptor[name=id; propertyType=class java.lang.Integer; readMethod=public java.lang.Integer bull02.JSPdemo2.User.getId(); writeMethod=public void bull02.JSPdemo2.User.setId(java.lang.Integer)]
 * pd:java.beans.PropertyDescriptor[name=password; propertyType=class java.lang.String; readMethod=public java.lang.String bull02.JSPdemo2.User.getPassword(); writeMethod=public void bull02.JSPdemo2.User.setPassword(java.lang.String)]
 * pd:java.beans.PropertyDescriptor[name=username; propertyType=class java.lang.String; readMethod=public java.lang.String bull02.JSPdemo2.User.getUsername(); writeMethod=public void bull02.JSPdemo2.User.setUsername(java.lang.String)]
 */
			if(map.containsKey(pd.getName())) {
				Method method = pd.getWriteMethod();//获得set方法
				method.invoke(obj,map.get(pd.getName())[0]);
				//pd.getName获得key.
				//map.get(pd.getName)获得一个value.这里value是String[]类型。
			}
		}
	}
}
