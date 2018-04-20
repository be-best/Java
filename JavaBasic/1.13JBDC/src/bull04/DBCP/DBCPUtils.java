package bull04.DBCP;

import java.io.InputStream;
import java.sql.Connection;
import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSourceFactory;

/*
 * DBCP工具类
 */
public class DBCPUtils {
	private static DataSource dataSource;
	
	static{
		try {
			//1.加载配置文件，获得文件流,运用类的加载：DBCPUtils.class.getClassLoader()
			InputStream is = DBCPUtils.class.getClassLoader().getResourceAsStream("dbcp-config.properties");
			//2.使用Properties处理配置文件
			Properties prop = new Properties();
			prop.load(is);
			//3.使用工具类创建连接池
			dataSource = BasicDataSourceFactory.createDataSource(prop);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	//获得连接池
	public static DataSource getDataSource() {
		return dataSource;
	}
	
	
	//获得连接
	public static Connection getConnection() {
		try {
			return dataSource.getConnection();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}
	