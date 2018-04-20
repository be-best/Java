package bull.utils;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class JDBCUtils {
	//���ӳ�
	private static ComboPooledDataSource dataSource = new ComboPooledDataSource("bull");
	//����ǰ�̰߳�����
	private static ThreadLocal<Connection> local = new ThreadLocal<Connection>();
	
	//�������Դ
	public static DataSource getDataSource() {
		return dataSource;
	}
	
	//�������
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

