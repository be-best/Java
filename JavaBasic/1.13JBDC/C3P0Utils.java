package bull08.ThreadLocal;
/*
 * C3P0������
 */
import java.sql.Connection;
import java.sql.SQLException;

import com.mchange.v2.c3p0.ComboPooledDataSource;

//import com.mchange.v2.c3p0.ComboPooledDataSource;

public class C3P0Utils {
	//���ӳ�
	private static ComboPooledDataSource dataSource = new ComboPooledDataSource("bull");
	//����ǰ�̰߳�����
	private static ThreadLocal<Connection> local = new ThreadLocal<Connection>();
	
	public static Connection getConnection() {
		//�ӵ�ǰ���߳��л���Ѿ��󶨵�����
		Connection conn = local.get();
		try {
			if(conn == null) {
				//��һ�δ����ӳ��л��
				conn =  dataSource.getConnection();
				//�����Ӵ�ThreadLocal��                                                   
				local.set(conn);
			}
			return conn;//�������
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		
	}
}
