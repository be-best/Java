package bull08.ThreadLocal;
/*
 * C3P0工具类
 */
import java.sql.Connection;
import java.sql.SQLException;

import com.mchange.v2.c3p0.ComboPooledDataSource;

//import com.mchange.v2.c3p0.ComboPooledDataSource;

public class C3P0Utils {
	//连接池
	private static ComboPooledDataSource dataSource = new ComboPooledDataSource("bull");
	//给当前线程绑定连接
	private static ThreadLocal<Connection> local = new ThreadLocal<Connection>();
	
	public static Connection getConnection() {
		//从当前的线程中获得已经绑定的连接
		Connection conn = local.get();
		try {
			if(conn == null) {
				//第一次从连接池中获得
				conn =  dataSource.getConnection();
				//将连接存ThreadLocal中                                                   
				local.set(conn);
			}
			return conn;//获得连接
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		
	}
}
