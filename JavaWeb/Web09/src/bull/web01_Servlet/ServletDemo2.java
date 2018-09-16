package bull.web01_Servlet;

import java.io.IOException;
import java.util.Arrays;
import java.util.Map;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class ServletDemo2 implements Servlet {

	@Override
	public void service(ServletRequest req, ServletResponse res)
			throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		//方法一：一个个读取
		String name = req.getParameter("name");
		String age = req.getParameter("age");
		String sex = req.getParameter("sex");
		String city = req.getParameter("city");
		String[] hobby = req.getParameterValues("hobby");
		String info = req.getParameter("info");
		
		System.out.println(name);
		System.out.println(age);
		System.out.println(sex);
		System.out.println(city);
		//将数组转换为字符串输出
		System.out.println(Arrays.toString(hobby));
		System.out.println(info);
		
		//方法二：采用map方法
//		Map<String,String[]> map = req.getParameterMap();
//		for (String key : map.keySet()) {
//			String[] value = map.get(key);
//			//将数组转换为字符串输出
//			System.out.println(Arrays.toString(value));
//		}
	}
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ServletConfig getServletConfig() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getServletInfo() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

}
