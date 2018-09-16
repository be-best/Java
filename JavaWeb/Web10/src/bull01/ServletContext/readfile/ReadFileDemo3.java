package bull01.ServletContext.readfile;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ReadFileDemo3 extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ServletContext servletContext = this.getServletContext();
		//获取db.properties的磁盘绝对路径
		String realPath = servletContext.getRealPath("/WEB-INF/classes/db.properties");
		InputStream is = new FileInputStream(realPath);
		
		Properties prop = new Properties();
		prop.load(is);
		
		String driverClass = prop.getProperty("driverClass");
		String url = prop.getProperty("url");
		String username = prop.getProperty("username");
		String password = prop.getProperty("password");
		
		System.out.println(realPath);//D:\tomcat\apache-tomcat-7.0.69\webapps\Web10\WEB-INF\classes\db.properties
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
