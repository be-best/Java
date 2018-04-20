package bull04.DBCP;

import java.sql.Connection;
import java.sql.SQLException;

import org.apache.commons.dbcp.BasicDataSource;
import org.junit.Test;

public class DBCPDemo_01 {
	@Test
	public void method () throws SQLException {
		//1.������ӳ�
		BasicDataSource dataSource = new BasicDataSource();
		//2.���û���� ������URL��user��password
		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://localhost:3306/mydb");
		dataSource.setUsername("root");
		dataSource.setPassword("root");
		
		//3.����������
		//���ó�ʼ���Ӹ���
		dataSource.setInitialSize(5);
		//�����
		dataSource.setMaxActive(10);
		
		//4.�������
		Connection conn = dataSource.getConnection();
		System.out.println(conn);
	}
}
