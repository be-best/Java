package bull01.XMLparsing;

import java.util.List;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.Node;
import org.dom4j.io.SAXReader;
import org.junit.Test;

/**
 * DOM4J的XPath的写法:
 */
public class XPath {
	@Test
	public void demo1() throws DocumentException{
		//创建解析器
		SAXReader reader = new SAXReader();
		//解析XML文档
		Document document = reader.read("xml/person.xml");
		//
		List<Node> list = document.selectNodes("//name");
		for (Node node : list) {
			Element element = (Element)node;
			System.out.println(element.getText());
		}
//		List<Node> list = document.selectNodes("//person['@id']");
//		for (Node node : list) {
//			Element element = (Element) node;
//			System.out.println(element.attributeValue("id"));
//		}
	}
	
	
}
