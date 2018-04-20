package bull05.DBUtils;

import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;
import org.junit.Test;

/*
 * QueryRunnerʵ����ӡ����¡�ɾ������
 */
public class DBUtils {
	@Test
	public void demo1() throws SQLException {
		//���
		//1.������
		QueryRunner queryRunner = new QueryRunner(C3P0Utils.getDataSource());
		//2.SQL���
		String sql = "insert into product (pid,pname,price,category_id) values (?,?,?,?);";
		//3.ʵ�ʲ���
		Object[] parms = {14,"�Ϳ�",999,"c002"};
		//4.ִ��
		int r = queryRunner.update(sql,parms);
		
		System.out.println(r);
	}
	
	@Test
	public void demo2() throws SQLException {
		//�޸�
		//1.������
		QueryRunner queryRunner = new QueryRunner(C3P0Utils.getDataSource());
		//2.sql���
		String sql = "update product set pname = ?,price = ?,category_id = ? where pid = ?;";
		//3.ʵ�ʲ���
		Object[] parms = {"���ϴ�˹",666,"c002",11};
		//4.ִ��
		int r = queryRunner.update(sql, parms);
		System.out.println(r);
	}
	
	@Test
	public void demo3() throws SQLException {
		//ɾ��
		//1.������
		QueryRunner queryRunner = new QueryRunner(C3P0Utils.getDataSource());
		//2.sql���
		String sql = "delete from product where pid = ?";
		//3.ʵ�ʲ���
		Object[] parms = {14};
		//4.ִ��
		int r = queryRunner.update(sql, parms);
		System.out.println(r);
	}
}
