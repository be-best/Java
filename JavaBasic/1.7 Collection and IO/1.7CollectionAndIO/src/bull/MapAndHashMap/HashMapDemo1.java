package bull.MapAndHashMap;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/*
 * ʹ��HashMap����
 */
public class HashMapDemo1 {
	public static void main(String[] args) {
		//����HashMap����
		HashMap<String,String> hm = new HashMap<String,String>();
		//���Ԫ��
		hm.put("÷��", "����");
		hm.put("������", "����");
		hm.put("��������", "����ʥ�ն���");
		//������ʽһ
		//��ȡkeyȻ�����keyȻ��õ�value
		Set<String> player = hm.keySet();
		for (String string : player) {
			String team = hm.get(string);
			System.out.println(string+"Ч����"+team);
		}
		System.out.println("--------------");
		
		//������ʽ��
		//��ȡ���ж���Ȼ�����
		Set<Map.Entry<String, String>> entrys = hm.entrySet();
		for (Map.Entry<String, String> entry : entrys) {
			String players = entry.getKey();
			String team = entry.getValue();
			System.out.println(players+"Ч����"+team);
		}
	}
}
