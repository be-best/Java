package bull01.ServletContext.readfile;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ReadFileUtils {

	public static void readFile() throws IOException {
		//使用类加载器来读取文件
		//类的加载器用来加载class文件，将class文件加载到内存中
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
