package bull07.ReflectTest;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.Properties;

import org.junit.Test;

import bull07.domain.BeanConfig;

/*
 * ����Properties
 */
public class PropertiesDemo_02 {
	private static final int UTF = 0;

	@Test
	public void method() throws UnsupportedEncodingException, FileNotFoundException, IOException {
		//����һ��BeanConfig����
		BeanConfig beanConfig = new BeanConfig();
		/*
		 * ��ȡbean.properties���ݣ�����id��className���ԡ�
		 * Ҳ���ǰ�bean.properties���������õ�beanConfig���������С�
		 */
		//����Properties����
		Properties beanProp = new Properties();
		//��IO����ȡbean.propties����
		beanProp.load(new InputStreamReader(new FileInputStream("bean.properties"),"UTF-8"));
		//ΪbeanConfig��������id��className,���õ����ݴ�properties��ȡ
		beanConfig.setId(beanProp.getProperty("id"));
		beanConfig.setClassName(beanProp.getProperty("className"));
		
		/*
		 * ��ȡdata.properties���ݣ�����User����
		 */
		Properties dataProp = new Properties();
		//��ȡdata.properrties����
		dataProp.load(new InputStreamReader(new FileInputStream("data.properties"),"UTF-8"));
		for (String key : dataProp.stringPropertyNames()) {
			String value = dataProp.getProperty(key);
			/*
			 * ΪUser��������
			 * beanConfih.getProp()��ʵ���ǻ�ȡ��Properties������ΪBeanConfig���д���Properties����
			 */
			beanConfig.getProp().setProperty(key, value);
		}
		System.out.println(beanConfig);
	}
}
