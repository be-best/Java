package bull03.C3P0;

import java.sql.Connection;

import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;

/*
 * C3P0������
 */
public class C3P0Utils {
	//1.����Ĭ�Ϸ�ʽ
	//private static ComboPooledDataSource dataSource = new ComboPooledDataSource();
	//2.ʹ����������,c3p0-config.xml�����ȡ
	private static ComboPooledDataSource dataSource = new ComboPooledDataSource("bull");
	
	//������ӳ�
	public static DataSource getDataSource() {
		return dataSource;//dataSource1
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
