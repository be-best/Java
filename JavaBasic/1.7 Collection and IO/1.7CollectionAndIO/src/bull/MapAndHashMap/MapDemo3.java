package bull.MapAndHashMap;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/*
 * Map�ĵ�һ�ֱ�����ʽ
 */
public class MapDemo3 {
	public static void main(String[] args) {
		//����map����
		Map<String,String> map = new HashMap<String,String>();
		
		map.put("÷��", "����");
		map.put("������", "����");
		map.put("��������", "����ʥ�ն���");
		//��ȡkey
		Set<String> player = map.keySet();
		//����key
		for (String string : player) {
			//ͨ��key��ȡvalue
			String team = map.get(string);
			System.out.println(string+"Ч����"+team);
		}
	}
}
