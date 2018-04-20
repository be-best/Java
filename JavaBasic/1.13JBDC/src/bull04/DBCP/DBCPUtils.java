package bull04.DBCP;

import java.io.InputStream;
import java.sql.Connection;
import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSourceFactory;

/*
 * DBCP������
 */
public class DBCPUtils {
	private static DataSource dataSource;
	
	static{
		try {
			//1.���������ļ�������ļ���,������ļ��أ�DBCPUtils.class.getClassLoader()
			InputStream is = DBCPUtils.class.getClassLoader().getResourceAsStream("dbcp-config.properties");
			//2.ʹ��Properties���������ļ�
			Properties prop = new Properties();
			prop.load(is);
			//3.ʹ�ù����ഴ�����ӳ�
			dataSource = BasicDataSourceFactory.createDataSource(prop);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	//������ӳ�
	public static DataSource getDataSource() {
		return dataSource;
	}
	
	
	//�������
	public static Connection getConnection() {
		try {
			return dataSource.getConnection();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}
	