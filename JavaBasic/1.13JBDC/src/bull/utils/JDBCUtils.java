package bull.utils;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class JDBCUtils {
	//连接池
	private static ComboPooledDataSource dataSource = new ComboPooledDataSource("bull");
	//给当前线程绑定连接
	private static ThreadLocal<Connection> local = new ThreadLocal<Connection>();
	
	//获得数据源
	public static DataSource getDataSource() {
		return dataSource;
	}
	
	//获得连接
	public static Connection getConnection() {
		Connection conn = local.get();
		try {
			if(conn == null) {
				conn = dataSource.getConnection();
				local.set(conn);
			}
			return conn;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}

