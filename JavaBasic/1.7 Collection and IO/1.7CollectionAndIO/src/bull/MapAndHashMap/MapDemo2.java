package bull.MapAndHashMap;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/*
 * Set<K> keySet();获取key
 * Collection<V> values();获取value
 */
public class MapDemo2 {
	public static void main(String[] args) {
		//创建map对象
		Map<String,String> map = new HashMap<String,String>();
		map.put("001", "张三");
		map.put("002", "李四");
		map.put("003", "李四");
		
		//Set<K> keySet();key不可重复，所以用Set
		Set<String> s = map.keySet();
		for (String string : s) {
			System.out.println(string);
		}
		System.out.println("-----------");
		//Collection<V> values();value可重复，不同的key对应的value可相同，所以用value
		Collection<String> c = map.values();
		for (String string : c) {
			System.out.println(string);
		}
	}
}
