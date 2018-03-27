package bull1715.Properties;

import java.util.Map;
import java.util.Map.Entry;
import java.util.Properties;
import java.util.Set;

/*
 * Properties:表示了一个持久的属性值，属性列表中每个键及其对应值都是一个字符串
 *
 * 构造方法：
 * 		Properties();
 */
public class PropertiesDemo1 {
	public static void main(String[] args) {
		//创建属性列表对象
		Properties prop = new Properties();
		//添加映射关系
		prop.put("张三", "001");
		prop.put("李四", "002");
		prop.put("王五", "003");
		
		//遍历方式一,先获取key对象，再根据key对象获取value
		Set<Object> s = prop.keySet();
		for (Object object : s) {
			Object value = prop.get(object);
			System.out.println(object + "=" + value);
		}
		System.out.println("-------------------");
		//遍历方式二,获取整个对象
		Set<Map.Entry<Object, Object>> entrys = prop.entrySet();
		for (Entry<Object, Object> entry : entrys) {
			Object key = entry.getKey();
			Object value = entry.getValue();
			System.out.println(key + "=" + value);	
		}
	}
}
