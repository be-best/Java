package bull01.ServletContext.readfile;
/**
 * 这是传统读文件方法
 * 只能在tomcat的bin目录下建个目录（比如建个src,把db.properties放进去）把文件放进去才读的到。
 * 
 * 
 *  传统方式读取文件:
 * * 使用的是相对路径，相对的JVM的路径.
 * * 但是现在是一个web项目,相对于JVM的路径的.现在JVM已经交给tomcat管理.
 * @throws FileNotFoundException
 * @throws IOException
*/
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ReadFileDemo1 extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//两种读文件的方式，一种字节流，一种字符流。
		//InputStream is = new FileInputStream("src/db.properties");
		BufferedReader br = new BufferedReader(new FileReader("src/db.properties"));
		Properties prop = new Properties();
		//采用Properties和IO流结合的方式
		prop.load(br);
		
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
