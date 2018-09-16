package bull02.JDBCconnectionPool;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.SQLFeatureNotSupportedException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import javax.sql.DataSource;

import bull01.JDBCbasis.JDBCUtils;

/**
 * 
 * @author 45��ը
 * �Զ������ӳ�
 */
public class MyDataSource implements DataSource {
	//����һ��list���ϴ������
	private List<Connection> list = new ArrayList<Connection>();
	
	public MyDataSource() {
		//��ʼ��3������
		for(int i = 0;i < 3;i++) {
			Connection conn = JDBCUtils.getConnection();
			list.add(conn);
		}
	}
	
	@Override
	public Connection getConnection() throws SQLException {
		// �������
		if(list.size() <= 0) {
			for(int i = 0;i < 3;i++) {
				Connection conn = JDBCUtils.getConnection();
				list.add(conn);
			}
		}
		Connection conn = list.remove(0);
		//��ǿ���ӣ�MyConnection������close�黹���Ӳ�����
		MyConnection myConnection = new MyConnection(conn,list);
		return myConnection;
		//return conn;
	}
	
//	public void addback(Connection conn) {
//		//�黹����
//		list.add(conn);
//	}

	@Override
	public PrintWriter getLogWriter() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setLogWriter(PrintWriter out) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setLoginTimeout(int seconds) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int getLoginTimeout() throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Logger getParentLogger() throws SQLFeatureNotSupportedException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <T> T unwrap(Class<T> iface) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isWrapperFor(Class<?> iface) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Connection getConnection(String username, String password)
			throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

}
