package bull05.transfer_1;
/*
 * 注意不要再Dao层关闭conn连接，要去业务层关闭。
 */
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import bull05.Utils.C3P0JDBCUtils;
import bull05.Utils.C3P0JDBCUtils_1;

import com.mysql.jdbc.ResultSet;

public class AccountDao {

	public void outMoney(String from, String to, Double money) {
		Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;
		try {
			conn = C3P0JDBCUtils_1.getConnection();
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
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public void inMoney(String from, String to, Double money) {
		Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;
		try {
			conn = C3P0JDBCUtils.getConnection();
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
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
