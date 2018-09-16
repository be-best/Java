package com.store.utils;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

/**
 * 对代码解耦
 * @author 45度炸
 *
 */
public class BeanFactory {
	public static Object getBean(String id) {
		SAXReader reader = new SAXReader();
		//解析XML文件
		try {
			Document document = reader.read(BeanFactory.class.getClassLoader().getResourceAsStream("applicationContext.xml"));
			//获取class属性中的内容
			Element beanElement = (Element) document.selectSingleNode("//bean[@id='"+id+"']");
			String value = beanElement.attributeValue("class");
			
			//反射生成实例
			Class clazz = Class.forName(value);
			return clazz.newInstance();//实例化对象
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
		
	}
}
