package bull06.XMLTest;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.beanutils.BeanUtils;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

public class BeanFactory {
	//1.1提供Map存放bean.xml配置文件中的所有内容，且易于快速查询
	private static Map<String,BeanConfig> cache = new HashMap<String,BeanConfig>();
	//1.2解析XML，将数据添加到map中
	static{
		try {
			//1)加载XML文件，获得document
			SAXReader saxReader = new SAXReader();
			
			//2)获得根元素<beans>
			Document document = saxReader.read("beans.xml");
			Element Bean = document.getRootElement();
			
			//3)获得所有<bean>元素
			List<Element> allBean = Bean.elements("bean");
			//4)获得id和className
			for (Element beans : allBean) {
				String id = beans.attributeValue("id");
				String className = beans.attributeValue("className");
				
				/**创建BeanConfig对象并配置id和className*/
				BeanConfig beanConfig = new BeanConfig();
				beanConfig.setId(id);
				beanConfig.setClassName(className);
				
				//5)获得<property>元素
				List<Element> allProperty = beans.elements("property");
				//6)获得name和value属性
				for (Element property : allProperty) {
					String name = property.attributeValue("name");
					String value = property.attributeValue("value");
					
					/**将name和value封装到beanConfig.prop中*/
					beanConfig.getProp().setProperty(name, value);
				}
				
				/**将封装好的beanConfig封装到Map中*/
				cache.put(id, beanConfig);
			}
			System.out.println("数据初始化成功:"+cache);
			
		} catch (Exception e) {
			//将编译时异常转化为运行时异常
			throw new RuntimeException(e);
		}
	}
	
	public static Object getBean(String beanId) {
		//通过beanId从Map中获取beanConfig
		BeanConfig beanConfig = cache.get(beanId);
		if(beanConfig == null) {
			throw new RuntimeException("获取的对象[" + beanConfig + "]不存在");
		}
		
		try {
			//通过beanConfig.className获取实例对象
			String className = beanConfig.getClassName();
			Class clazz = Class.forName(className);
			Object obj = clazz.newInstance();
			
			//循环遍历beanConfig.prop,使用BeanUtils进行数据封装
			for (String name : beanConfig.getProp().stringPropertyNames()) {
				//根据name获取value
				String value = beanConfig.getProp().getProperty(name);
				//使用BeanUtils进行数据封装,类似于set方法
				BeanUtils.setProperty(obj, name, value);
			}
		
			return obj;
			
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		
	}
}
