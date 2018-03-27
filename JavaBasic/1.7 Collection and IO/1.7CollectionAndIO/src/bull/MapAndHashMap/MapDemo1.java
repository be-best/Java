package bull.MapAndHashMap;

import java.util.HashMap;
import java.util.Map;

/*
 * Map:
 * 	����ӳ�䵽ֵ�ö���һ��ӳ�䲻�ܰ����ظ��ļ���ÿ�������ֻ��ӳ�䵽һ��ֵ
 * 
 * Map��Collection������
 * 		Map��һ��˫���ϣ������ڴ����ж�Ӧ��ϵ�����ݣ�key�ǲ������ظ��ģ�����Ҳ��֮Ϊ���޶Լ���
 * 		Colllection��һ�����м��ϣ��в�ͬ������ϵ���е������ظ����������еĲ������ظ�������
 * 
 */
public class MapDemo1 {
	public static void main(String[] args) {
		//����Map����
		Map<String,String> map = new HashMap<String,String>();
		//V put(K key,V value);��keyӳ�䵽value�����key���ڣ���ԭ����value����
		System.out.println(map.put("001", "����"));
		System.out.println(map.put("002", "����"));
		System.out.println(map.put("001", "����"));
		System.out.println(map);

		//boolean containsKey(Object key)
		boolean flag = map.containsKey("001");
		System.out.println(flag);
		
		//boolean containsValue(Object Value)
		boolean flag2 = map.containsValue("����");
		System.out.println(flag2);
		
		//boolean isEmpty();�ж��Ƿ��ж�Ӧ��ϵ
		boolean flag3 = map.isEmpty();
		System.out.println(flag3);
		
		//int size();���ض�Ӧ��ϵ����
		int num = map.size();
		System.out.println(num);
		
		//V get(Object key);����ָ����key���ض�Ӧ��value
		System.out.println(map.get("001"));
		
		//void clear();��ն�Ӧ��ϵ
		map.clear();
		System.out.println(map);
	}
}
