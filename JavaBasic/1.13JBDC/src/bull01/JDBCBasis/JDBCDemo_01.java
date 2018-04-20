package bull01.JDBCBasis;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import org.junit.Test;

public class JDBCDemo_01 {
	@Test
	public void method1() throws Exception {
		Connection conn = JDBCUtils.getConnections();
		//1.ע������
		//Class.forName("com.mysql.jdbc.Driver");
		//2.�������,��������url,user,password
		//Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb", "root", "root");
		//3.������ִ����
		Statement st = conn.createStatement();
		//4.ִ��SQL���
		ResultSet rs = st.executeQuery("select * from category");
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
		//6.�ͷ���Դ
		/*
		 * ���ȹ�
		 * �������Ϲ�
		 */
		rs.close();
		st.close();
		conn.close();
	}
}
