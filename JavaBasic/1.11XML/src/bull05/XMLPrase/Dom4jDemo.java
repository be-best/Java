package bull05.XMLPrase;

import java.util.List;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.junit.Test;

/*
 * 解析XML
 */
public class Dom4jDemo {
	@Test
	public void Prase() throws DocumentException {
		//1.核心类
		SAXReader sexReader = new SAXReader();
		
		//2.获得Document（整个XML）
		Document document = sexReader.read("beans.xml");
		
		//3.获得beans
		Element rootElement = document.getRootElement();
		
		//4.获得bean
		List<Element> allBeanElement = 	rootElement.elements("bean");
		for (Element element : allBeanElement) {
			String id = element.attributeValue("id");
			String className = element.attributeValue("className");
			System.out.println("bean属性：" + id + "," + className);
			
			//5.获得property
			List<Element> allProperty = element.elements("property");
			for (Element element2 : allProperty) {
				String name = element2.attributeValue("name");
				String value = element2.attributeValue("value");
				System.out.println("property属性：" + name+ "," + value);
			}
			System.out.println();
		}
	}
}

