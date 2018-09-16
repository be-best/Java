package bull01.ServletContext.readfile;
/**
 * ���Ǵ�ͳ���ļ�����
 * ֻ����tomcat��binĿ¼�½���Ŀ¼�����罨��src,��db.properties�Ž�ȥ�����ļ��Ž�ȥ�Ŷ��ĵ���
 * 
 * 
 *  ��ͳ��ʽ��ȡ�ļ�:
 * * ʹ�õ������·������Ե�JVM��·��.
 * * ����������һ��web��Ŀ,�����JVM��·����.����JVM�Ѿ�����tomcat����.
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
		//���ֶ��ļ��ķ�ʽ��һ���ֽ�����һ���ַ�����
		//InputStream is = new FileInputStream("src/db.properties");
		BufferedReader br = new BufferedReader(new FileReader("src/db.properties"));
		Properties prop = new Properties();
		//����Properties��IO����ϵķ�ʽ
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
