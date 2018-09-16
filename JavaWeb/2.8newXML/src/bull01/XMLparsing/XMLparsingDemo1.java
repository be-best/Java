package bull01.XMLparsing;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
/**
 * 获得元素的内容:查询的操作.
 */
import org.junit.Test;

public class XMLparsingDemo1 {
	@Test
	public void demo1() throws DocumentException {
		//创建解析器
		SAXReader reader = new SAXReader();
		//解析XML文档
		Document document = reader.read("xml/person.xml");
		//获得根节点
		Element rootElement = document.getRootElement();
		//查找根节点下的子节点
		Element person1 = rootElement.element("person");//第一个person节点
		rootElement.elements("person").get(1);//第二个person元素
		//获取各个属性节点
		Element nameEle = person1.element("name");
		Element ageEle = person1.element("age");
		Element sexEle = person1.element("sex");
		System.out.println(nameEle.getText()+" "+ageEle.getText()+" "+sexEle.getText());
	}
}
