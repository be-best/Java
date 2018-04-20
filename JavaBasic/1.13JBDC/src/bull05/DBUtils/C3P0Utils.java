package bull05.DBUtils;
/*
 * C3P0工具类
 */
import java.sql.Connection;

import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class C3P0Utils {
	//使用命名方式
	private static ComboPooledDataSource dataSource= new ComboPooledDataSource("bull");
	
	//获得数据源
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
