package bull01.XMLparsing;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
/**
 * ���Ԫ�ص�����:��ѯ�Ĳ���.
 */
import org.junit.Test;

public class XMLparsingDemo1 {
	@Test
	public void demo1() throws DocumentException {
		//����������
		SAXReader reader = new SAXReader();
		//����XML�ĵ�
		Document document = reader.read("xml/person.xml");
		//��ø��ڵ�
		Element rootElement = document.getRootElement();
		//���Ҹ��ڵ��µ��ӽڵ�
		Element person1 = rootElement.element("person");//��һ��person�ڵ�
		rootElement.elements("person").get(1);//�ڶ���personԪ��
		//��ȡ�������Խڵ�
		Element nameEle = person1.element("name");
		Element ageEle = person1.element("age");
		Element sexEle = person1.element("sex");
		System.out.println(nameEle.getText()+" "+ageEle.getText()+" "+sexEle.getText());
	}
}
