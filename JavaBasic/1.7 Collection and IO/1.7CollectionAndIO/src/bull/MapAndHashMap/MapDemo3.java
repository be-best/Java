package bull.MapAndHashMap;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/*
 * Map的第一种遍历方式
 */
public class MapDemo3 {
	public static void main(String[] args) {
		//创建map对象
		Map<String,String> map = new HashMap<String,String>();
		
		map.put("梅西", "巴萨");
		map.put("阿圭罗", "曼城");
		map.put("迪玛利亚", "巴黎圣日耳曼");
		//获取key
		Set<String> player = map.keySet();
		//遍历key
		for (String string : player) {
			//通过key获取value
			String team = map.get(string);
			System.out.println(string+"效力于"+team);
		}
	}
}
