package bull06.Properties;

import java.util.Properties;
import java.util.Set;

import org.junit.Test;

/*
 * Properties
 */
public class PropertiesDemo_01 {
	@Test
	public void properties() {
		//����properties����
		Properties prop = new Properties();
		/*
		 * ��������
		 * setProperty();
		 */
		prop.setProperty("k1", "v1");
		prop.setProperty("k2", "v2");
		prop.setProperty("k3", "v3");
		
		/*
		 * ��ȡָ������
		 * getProperty();
		 */
		String str = prop.getProperty("k1");
		System.out.println(str);
		System.out.println("-----------");
		
		/*
		 * ��ȡ��������
		 * stringPropertyNames();
		 */
		Set<String> keys = prop.stringPropertyNames();
		for (String key : keys) {
			String value = prop.getProperty(key);
			System.out.println(key + ":" + value);
		}
	}
}
