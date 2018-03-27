package bull.MapAndHashMap;

import java.util.HashMap;
import java.util.Map;

/*
 * Map:
 * 	将键映射到值得对象。一个映射不能包含重复的键，每个键最多只能映射到一个值
 * 
 * Map和Collection的区别：
 * 		Map是一个双集合，常用于处理有对应关系的数据，key是不可以重复的，我们也称之为夫妻对集合
 * 		Colllection是一个单列集合，有不同的子体系，有的允许重复有索引，有的不允许重复且无序
 * 
 */
public class MapDemo1 {
	public static void main(String[] args) {
		//创建Map对象
		Map<String,String> map = new HashMap<String,String>();
		//V put(K key,V value);将key映射到value，如果key存在，将原来的value返回
		System.out.println(map.put("001", "张三"));
		System.out.println(map.put("002", "李四"));
		System.out.println(map.put("001", "王五"));
		System.out.println(map);

		//boolean containsKey(Object key)
		boolean flag = map.containsKey("001");
		System.out.println(flag);
		
		//boolean containsValue(Object Value)
		boolean flag2 = map.containsValue("王五");
		System.out.println(flag2);
		
		//boolean isEmpty();判断是否有对应关系
		boolean flag3 = map.isEmpty();
		System.out.println(flag3);
		
		//int size();返回对应关系个数
		int num = map.size();
		System.out.println(num);
		
		//V get(Object key);根据指定的key返回对应的value
		System.out.println(map.get("001"));
		
		//void clear();清空对应关系
		map.clear();
		System.out.println(map);
	}
}
