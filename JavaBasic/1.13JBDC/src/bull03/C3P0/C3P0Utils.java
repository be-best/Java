package bull03.C3P0;

import java.sql.Connection;

import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;

/*
 * C3P0工具类
 */
public class C3P0Utils {
	//1.采用默认方式
	//private static ComboPooledDataSource dataSource = new ComboPooledDataSource();
	//2.使用命名配置,c3p0-config.xml里面获取
	private static ComboPooledDataSource dataSource = new ComboPooledDataSource("bull");
	
	//获得连接池
	public static DataSource getDataSource() {
		return dataSource;//dataSource1
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
