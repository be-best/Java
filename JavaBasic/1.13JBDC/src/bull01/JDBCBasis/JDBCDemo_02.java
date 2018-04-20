package bull01.JDBCBasis;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.junit.Test;

public class JDBCDemo_02 {
	@Test
	public void method1()  {
		//1.ע������
		//2.�������,��������url,user,password
		Connection conn = null;
		//3.������ִ����
		Statement st = null;
		//4.ִ��SQL���
		ResultSet rs = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb", "root", "root");
			st = conn.createStatement();
			rs = st.executeQuery("select * from category");
			//5.��������
			/*
			 * rs.next()ָ����һ�С�true:��Ч��false:β��
			 * rs.previous()ָ����һ�С�true:��Ч��false:ͷ��
			 */
			while(rs.next()) {
				Integer cid = rs.getInt("cid");
				String cname = rs.getString("cname");
				System.out.println(cid+"---"+cname);
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		//6.�ͷ���Դ
		/*
		 * ���ȹ�
		 * �������Ϲ�
		 */
		if(rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		if(st != null) {
			try {
				st.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		if(conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
