package bull03.C3P0;



import java.sql.Connection;

import org.junit.Test;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class C3P0Demo_01 {
	@Test
	public void demo() throws Exception {
		//1.������ӳ�(����Դ)
		ComboPooledDataSource dataSource = new ComboPooledDataSource();
		//2.���û�����
		dataSource.setDriverClass("com.mysql.jdbc.Driver");
		dataSource.setJdbcUrl("jdbc:mysql://localhost:3306/mydb");
		dataSource.setUser("root");
		dataSource.setPassword("root");
		
		//3.����������
		//��ʼ�����ӳ��еĸ���
		dataSource.setInitialPoolSize(5);
		dataSource.setMaxPoolSize(10);
		dataSource.setMinPoolSize(2);
		//��������
		dataSource.setMaxIdleTime(60);
		//ÿ����������
		dataSource.setAcquireIncrement(2);
		
		//4.�������
		Connection conn = dataSource.getConnection();
		System.out.println(conn);
	}
}
