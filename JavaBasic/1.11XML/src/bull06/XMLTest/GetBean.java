package bull06.XMLTest;

import org.junit.Test;

public class GetBean {
	@Test
	public void get() {
		User user = (User)BeanFactory.getBean("uid001");
		System.out.println(user);
		
		Book book = (Book)BeanFactory.getBean("bid001");
		System.out.println(book);
	}
}
