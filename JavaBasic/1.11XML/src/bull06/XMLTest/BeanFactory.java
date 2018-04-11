package bull06.XMLTest;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.beanutils.BeanUtils;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

public class BeanFactory {
	//1.1�ṩMap���bean.xml�����ļ��е��������ݣ������ڿ��ٲ�ѯ
	private static Map<String,BeanConfig> cache = new HashMap<String,BeanConfig>();
	//1.2����XML����������ӵ�map��
	static{
		try {
			//1)����XML�ļ������document
			SAXReader saxReader = new SAXReader();
			
			//2)��ø�Ԫ��<beans>
			Document document = saxReader.read("beans.xml");
			Element Bean = document.getRootElement();
			
			//3)�������<bean>Ԫ��
			List<Element> allBean = Bean.elements("bean");
			//4)���id��className
			for (Element beans : allBean) {
				String id = beans.attributeValue("id");
				String className = beans.attributeValue("className");
				
				/**����BeanConfig��������id��className*/
				BeanConfig beanConfig = new BeanConfig();
				beanConfig.setId(id);
				beanConfig.setClassName(className);
				
				//5)���<property>Ԫ��
				List<Element> allProperty = beans.elements("property");
				//6)���name��value����
				for (Element property : allProperty) {
					String name = property.attributeValue("name");
					String value = property.attributeValue("value");
					
					/**��name��value��װ��beanConfig.prop��*/
					beanConfig.getProp().setProperty(name, value);
				}
				
				/**����װ�õ�beanConfig��װ��Map��*/
				cache.put(id, beanConfig);
			}
			System.out.println("���ݳ�ʼ���ɹ�:"+cache);
			
		} catch (Exception e) {
			//������ʱ�쳣ת��Ϊ����ʱ�쳣
			throw new RuntimeException(e);
		}
	}
	
	public static Object getBean(String beanId) {
		//ͨ��beanId��Map�л�ȡbeanConfig
		BeanConfig beanConfig = cache.get(beanId);
		if(beanConfig == null) {
			throw new RuntimeException("��ȡ�Ķ���[" + beanConfig + "]������");
		}
		
		try {
			//ͨ��beanConfig.className��ȡʵ������
			String className = beanConfig.getClassName();
			Class clazz = Class.forName(className);
			Object obj = clazz.newInstance();
			
			//ѭ������beanConfig.prop,ʹ��BeanUtils�������ݷ�װ
			for (String name : beanConfig.getProp().stringPropertyNames()) {
				//����name��ȡvalue
				String value = beanConfig.getProp().getProperty(name);
				//ʹ��BeanUtils�������ݷ�װ,������set����
				BeanUtils.setProperty(obj, name, value);
			}
		
			return obj;
			
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		
	}
}
