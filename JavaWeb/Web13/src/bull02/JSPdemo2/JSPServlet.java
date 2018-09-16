package bull02.JSPdemo2;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;
/**
 * µ¼°ü£ºcommons-beanutils-1.8.3.jar
 * 	   commons-logging-1.1.1.jar
 * @author 45¶ÈÕ¨
 *
 */
public class JSPServlet extends HttpServlet {
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Map<String,String[]> map = request.getParameterMap();
		User user = new User();
		
		try {
			//BeanUtils.populate(user, map);
			MyBeanUtils.populate(user, map);
		} catch (Exception e) {
			e.printStackTrace();
		} 
		System.out.println(user.getUsername());
		System.out.println(user.getPassword());
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request,response);
	}

}
