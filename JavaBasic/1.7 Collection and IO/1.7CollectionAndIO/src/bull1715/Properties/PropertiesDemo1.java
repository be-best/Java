package bull1715.Properties;

import java.util.Map;
import java.util.Map.Entry;
import java.util.Properties;
import java.util.Set;

/*
 * Properties:��ʾ��һ���־õ�����ֵ�������б���ÿ���������Ӧֵ����һ���ַ���
 *
 * ���췽����
 * 		Properties();
 */
public class PropertiesDemo1 {
	public static void main(String[] args) {
		//���������б����
		Properties prop = new Properties();
		//���ӳ���ϵ
		prop.put("����", "001");
		prop.put("����", "002");
		prop.put("����", "003");
		
		//������ʽһ,�Ȼ�ȡkey�����ٸ���key�����ȡvalue
		Set<Object> s = prop.keySet();
		for (Object object : s) {
			Object value = prop.get(object);
			System.out.println(object + "=" + value);
		}
		System.out.println("-------------------");
		//������ʽ��,��ȡ��������
		Set<Map.Entry<Object, Object>> entrys = prop.entrySet();
		for (Entry<Object, Object> entry : entrys) {
			Object key = entry.getKey();
			Object value = entry.getValue();
			System.out.println(key + "=" + value);	
		}
	}
}
