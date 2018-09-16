package bull04.transfer;
/*
 * 注意不要再Dao层关闭conn连接，要去业务层关闭。
 */
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.mysql.jdbc.ResultSet;

public class AccountDao {

	public void outMoney(Connection conn, String from, String to, Double money) {
		PreparedStatement psmt = null;
		ResultSet rs = null;
		try {
			String sql = "update  account set money = money - ? where name = ?";
			psmt = conn.prepareStatement(sql);
			psmt.setDouble(1, money);
			psmt.setString(2, from);
			psmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				psmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public void inMoney(Connection conn, String from, String to, Double money) {
		PreparedStatement psmt = null;
		ResultSet rs = null;
		try {
			//System.out.println(from+"---"+to+"---"+money);
			String sql = "update account set money = money + ? where name = ?";
			psmt = conn.prepareStatement(sql);
			psmt.setDouble(1, money);
			psmt.setString(2, to);
			psmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				psmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
