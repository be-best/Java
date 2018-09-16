package bull01.ServletContext.readfile;
/**
 * 
 * 使用ServletContext中的getResourceAsStream读取.
 * @throws FileNotFoundException
 * @throws IOException
 */
 
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ReadFileDemo2 extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//获取ServletContext对象
		ServletContext servletContext = this.getServletContext();
		//读取文件，返回一个流
		InputStream is =servletContext.getResourceAsStream("/WEB-INF/classes/db.properties");
		Properties prop = new Properties();
		prop.load(is);
		
		String driverClass = prop.getProperty("driverClass");
		String url = prop.getProperty("url");
		String username = prop.getProperty("username");
		String password = prop.getProperty("password");
		
		System.out.println(driverClass);//com.mysql.jdbc.Driver
		System.out.println(url);//jdbc:mysql://localhost:3306/mydb
		System.out.println(username);//root
		System.out.println(password);//root
	}


	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request,response);
	}

}
