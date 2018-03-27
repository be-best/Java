package bull.MapAndHashMap;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/*
 * Set<K> keySet();��ȡkey
 * Collection<V> values();��ȡvalue
 */
public class MapDemo2 {
	public static void main(String[] args) {
		//����map����
		Map<String,String> map = new HashMap<String,String>();
		map.put("001", "����");
		map.put("002", "����");
		map.put("003", "����");
		
		//Set<K> keySet();key�����ظ���������Set
		Set<String> s = map.keySet();
		for (String string : s) {
			System.out.println(string);
		}
		System.out.println("-----------");
		//Collection<V> values();value���ظ�����ͬ��key��Ӧ��value����ͬ��������value
		Collection<String> c = map.values();
		for (String string : c) {
			System.out.println(string);
		}
	}
}
