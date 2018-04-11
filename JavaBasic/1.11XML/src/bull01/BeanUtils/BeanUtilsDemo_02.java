package bull01.BeanUtils;

import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.beanutils.BeanUtils;
import org.junit.Test;

/*
 * 模拟数据
 */
public class BeanUtilsDemo_02 {
	@Test
	public void method() throws Exception, InvocationTargetException {
		//创建一个Map对象,填充需要的数据
		Map<String,String[]> map = new HashMap();
		map.put("userName", new String[]{"张三"});
		map.put("userId", new String[]{"李四"});
		map.put("userPasswd", new String[]{"王五"});
		map.put("userHobby", new String[]{"打篮球","踢足球"});
		map.put("userAge", new String[]{"10"});
		
		//创建User对象
		User users = new User();
		/*
		 * 使用populate()进行填充:
		 * 	1.可以向指定的属性填充一组数据，类型必须是数组[];
		 * 	2.如果属性不是数组，将使用map.value表示数组中的第一个。
		 * 		例如：usrId属性不是数组。
		 * 			若有map.put("userId", new String[]{"李四","王五"});会默认李四。
		 * 	3.BeanUtils支持类型：基本类型和基本类型对应的包装类,自动将字符串转换基本类型。
		 * 		例如：userAge是int型，
		 * 			map.put("userAge", new String[]{"10"})会默认转换"10"。
		 */
		BeanUtils.populate(users, map);
		
		System.out.println(users);
	}
}
