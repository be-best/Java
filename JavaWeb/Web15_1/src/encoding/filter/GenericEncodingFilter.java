package encoding.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

public class GenericEncodingFilter implements Filter {

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		//增强request,MyHttpServletRequestWrapper中根据请求的方式的不同去处理乱码
		MyHttpServletRequestWrapper myHttpSercletRequestWrapper = new MyHttpServletRequestWrapper(req);
		chain.doFilter(myHttpSercletRequestWrapper, response);
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

}
