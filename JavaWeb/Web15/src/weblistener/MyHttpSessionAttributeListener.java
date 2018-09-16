package weblistener;

import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;

public class MyHttpSessionAttributeListener implements HttpSessionAttributeListener {

	@Override
	public void attributeAdded(HttpSessionBindingEvent se) {
		System.out.println("Session中添加了属性...");
	}

	@Override
	public void attributeRemoved(HttpSessionBindingEvent se) {
		// TODO Auto-generated method stub
		System.out.println("Session中移除了属性...");
	}

	@Override
	public void attributeReplaced(HttpSessionBindingEvent se) {
		// TODO Auto-generated method stub
		System.out.println("Session中替换了属性...");
	}

}
