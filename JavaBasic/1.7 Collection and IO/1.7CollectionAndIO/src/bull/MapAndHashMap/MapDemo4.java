package bull.MapAndHashMap;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

/*
 * map�ĵڶ��ֱ�����ʽ
 */
public class MapDemo4 {
	public static void main(String[] args) {
		//�������϶���
		Map<String,String> map = new HashMap<String,String>();
		map.put("÷��", "����");
		map.put("������", "����");
		map.put("��������", "����ʥ�ն���");
		
		//��ȡ���еĶ���
		Set<Map.Entry<String, String>> entrys = map.entrySet();
		//����
		for (Entry<String, String> entry : entrys) {
			//entry��entrys��һ����Ա
			//��ȡ��Ա
			String player = entry.getKey();
			//��ȡ���
			String team = entry.getValue();
			System.out.println(player+"Ч����"+team);
		}
	}
}
