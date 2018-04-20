package bull05.DBUtils;
/*
 * C3P0������
 */
import java.sql.Connection;

import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class C3P0Utils {
	//ʹ��������ʽ
	private static ComboPooledDataSource dataSource= new ComboPooledDataSource("bull");
	
	//�������Դ
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
