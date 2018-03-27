package bull.MapAndHashMap;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

/*
 * map的第二种遍历方式
 */
public class MapDemo4 {
	public static void main(String[] args) {
		//创建集合对象
		Map<String,String> map = new HashMap<String,String>();
		map.put("梅西", "巴萨");
		map.put("阿圭罗", "曼城");
		map.put("迪玛利亚", "巴黎圣日耳曼");
		
		//获取所有的对象
		Set<Map.Entry<String, String>> entrys = map.entrySet();
		//遍历
		for (Entry<String, String> entry : entrys) {
			//entry是entrys的一个成员
			//获取队员
			String player = entry.getKey();
			//获取球队
			String team = entry.getValue();
			System.out.println(player+"效力于"+team);
		}
	}
}
