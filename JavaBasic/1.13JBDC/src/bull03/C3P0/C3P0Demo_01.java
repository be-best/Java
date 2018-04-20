package bull03.C3P0;



import java.sql.Connection;

import org.junit.Test;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class C3P0Demo_01 {
	@Test
	public void demo() throws Exception {
		//1.获得连接池(数据源)
		ComboPooledDataSource dataSource = new ComboPooledDataSource();
		//2.设置基本项
		dataSource.setDriverClass("com.mysql.jdbc.Driver");
		dataSource.setJdbcUrl("jdbc:mysql://localhost:3306/mydb");
		dataSource.setUser("root");
		dataSource.setPassword("root");
		
		//3.设置其他项
		//初始化连接池中的个数
		dataSource.setInitialPoolSize(5);
		dataSource.setMaxPoolSize(10);
		dataSource.setMinPoolSize(2);
		//最大空闲数
		dataSource.setMaxIdleTime(60);
		//每次增长个数
		dataSource.setAcquireIncrement(2);
		
		//4.获得连接
		Connection conn = dataSource.getConnection();
		System.out.println(conn);
	}
}
