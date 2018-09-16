package Filter;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/**
 * FilterConfig
 * @author 45��ը
 *
 */
public class FilterDemo2 implements Filter {

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		//��õ�ǰ��Filter����
		String filterName = filterConfig.getFilterName();
		System.out.println(filterName);//demo2
		//��ó�ʼ������
		String username = filterConfig.getInitParameter("username");
		String password = filterConfig.getInitParameter("password");
		System.out.println(username+"---"+password);//FilterDemo2��ʼ������---123
		//������г�ʼ������������
		Enumeration<String> en = filterConfig.getInitParameterNames();
		while(en.hasMoreElements()) {
			String name = en.nextElement();
			String value = filterConfig.getInitParameter(name);//username---FilterDemo2��ʼ������
			System.out.println(name+"---"+value);//password---123
		}
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}
	
}
