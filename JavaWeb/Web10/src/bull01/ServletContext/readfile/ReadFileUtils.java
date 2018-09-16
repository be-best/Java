package bull01.ServletContext.readfile;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ReadFileUtils {

	public static void readFile() throws IOException {
		//ʹ�������������ȡ�ļ�
		//��ļ�������������class�ļ�����class�ļ����ص��ڴ���
		InputStream is = ReadFileUtils.class.getClassLoader().getResourceAsStream("db.properties");
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
	
}
