package bull.MapAndHashMap;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/*
 * 使用HashMap遍历
 */
public class HashMapDemo1 {
	public static void main(String[] args) {
		//创建HashMap集合
		HashMap<String,String> hm = new HashMap<String,String>();
		//添加元素
		hm.put("梅西", "巴萨");
		hm.put("阿圭罗", "曼城");
		hm.put("迪玛利亚", "巴黎圣日耳曼");
		//遍历方式一
		//获取key然后遍历key然后得到value
		Set<String> player = hm.keySet();
		for (String string : player) {
			String team = hm.get(string);
			System.out.println(string+"效力于"+team);
		}
		System.out.println("--------------");
		
		//遍历方式二
		//获取所有对象然后遍历
		Set<Map.Entry<String, String>> entrys = hm.entrySet();
		for (Map.Entry<String, String> entry : entrys) {
			String players = entry.getKey();
			String team = entry.getValue();
			System.out.println(players+"效力于"+team);
		}
	}
}
