package com.store.utils;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

/**
 * �Դ������
 * @author 45��ը
 *
 */
public class BeanFactory {
	public static Object getBean(String id) {
		SAXReader reader = new SAXReader();
		//����XML�ļ�
		try {
			Document document = reader.read(BeanFactory.class.getClassLoader().getResourceAsStream("applicationContext.xml"));
			//��ȡclass�����е�����
			Element beanElement = (Element) document.selectSingleNode("//bean[@id='"+id+"']");
			String value = beanElement.attributeValue("class");
			
			//��������ʵ��
			Class clazz = Class.forName(value);
			return clazz.newInstance();//ʵ��������
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
		
	}
}
