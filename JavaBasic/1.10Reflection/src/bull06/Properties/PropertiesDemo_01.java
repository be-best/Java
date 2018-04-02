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
		//创建properties对象
		Properties prop = new Properties();
		/*
		 * 设置数据
		 * setProperty();
		 */
		prop.setProperty("k1", "v1");
		prop.setProperty("k2", "v2");
		prop.setProperty("k3", "v3");
		
		/*
		 * 获取指定数据
		 * getProperty();
		 */
		String str = prop.getProperty("k1");
		System.out.println(str);
		System.out.println("-----------");
		
		/*
		 * 获取所有数据
		 * stringPropertyNames();
		 */
		Set<String> keys = prop.stringPropertyNames();
		for (String key : keys) {
			String value = prop.getProperty(key);
			System.out.println(key + ":" + value);
		}
	}
}
