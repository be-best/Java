package bull04.DBCP;

import java.sql.Connection;
import java.sql.SQLException;

import org.apache.commons.dbcp.BasicDataSource;
import org.junit.Test;

public class DBCPDemo_01 {
	@Test
	public void method () throws SQLException {
		//1.获得连接池
		BasicDataSource dataSource = new BasicDataSource();
		//2.配置基本项： 驱动、URL、user、password
		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://localhost:3306/mydb");
		dataSource.setUsername("root");
		dataSource.setPassword("root");
		
		//3.配置其他项
		//设置初始连接个数
		dataSource.setInitialSize(5);
		//最大活动数
		dataSource.setMaxActive(10);
		
		//4.获得连接
		Connection conn = dataSource.getConnection();
		System.out.println(conn);
	}
}
