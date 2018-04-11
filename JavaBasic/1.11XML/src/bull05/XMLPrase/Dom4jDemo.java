package bull05.XMLPrase;

import java.util.List;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.junit.Test;

/*
 * ����XML
 */
public class Dom4jDemo {
	@Test
	public void Prase() throws DocumentException {
		//1.������
		SAXReader sexReader = new SAXReader();
		
		//2.���Document������XML��
		Document document = sexReader.read("beans.xml");
		
		//3.���beans
		Element rootElement = document.getRootElement();
		
		//4.���bean
		List<Element> allBeanElement = 	rootElement.elements("bean");
		for (Element element : allBeanElement) {
			String id = element.attributeValue("id");
			String className = element.attributeValue("className");
			System.out.println("bean���ԣ�" + id + "," + className);
			
			//5.���property
			List<Element> allProperty = element.elements("property");
			for (Element element2 : allProperty) {
				String name = element2.attributeValue("name");
				String value = element2.attributeValue("value");
				System.out.println("property���ԣ�" + name+ "," + value);
			}
			System.out.println();
		}
	}
}

