package bull.ProductDao;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.MapHandler;
import org.apache.commons.dbutils.handlers.MapListHandler;
import org.junit.Test;

import bull.domain.Product;
import bull.utils.JDBCUtils;
import bull05.DBSelectUtils.ProductJavaBean;


/*
 * 
 */
public class ProductDao {
	
	

	public void add(Product product) throws SQLException {
		// ���
		QueryRunner queryRunner = new QueryRunner(JDBCUtils.getDataSource());
		String sql = "insert into products(pname,price,flag,category_id) values (?,?,?,?);";
		Object[] params = {product.getPname(),product.getPrice(),product.getFlag(),product.getCategory_id()};
		queryRunner.update(sql, params);
	}

	public Product findById(Integer pid) throws SQLException {
		// ��ѯ
		QueryRunner queryRunner = new QueryRunner(JDBCUtils.getDataSource());
		String sql = "select * from products where pid = ?;";
		Object[] params = {pid};
		//����ѯ�����ݷ�װ��Product���JavaBean�С�
		return queryRunner.query(sql, new BeanHandler<Product>(Product.class), params);
	}

	
	public void edit(Product product) throws SQLException {
		// �޸�
		QueryRunner queryRunner = new QueryRunner(JDBCUtils.getDataSource());
		String sql = "update products set pname = ?, price = ?,category_id = ? where pid = ?;";
		Object[] params = {product.getPname(),product.getPrice(),product.getCategory_id(),product.getPid()};
		queryRunner.update(sql, params);
		
	}

	public List findAll() throws SQLException {
		// ��ѯ����
		QueryRunner queryRunner = new QueryRunner(JDBCUtils.getDataSource());
		String sql = "select * from products;";
		Object[] params = {};
		List<Map<String,Object>> list = queryRunner.query(sql, new MapListHandler(), params);
		return list;
	}

	public void delete(Integer pid) throws SQLException {
		// ɾ��
		QueryRunner queryRunner = new QueryRunner();//��������ʽ���˴����û�ȡ����
		String sql = "delete from products where pid = ?;";
		Object[] params = {pid};
		//�˴�Ҫ��ȡ����
		queryRunner.update(JDBCUtils.getConnection(), sql, params);
		
	}

	public void deleteAll(Integer pid) throws SQLException {
		// ɾ��ȫ����¼
		QueryRunner queryRunner = new QueryRunner();
		String sql = "delete from products where pid = ?;";
		Object[] params = {pid};
		queryRunner.update(JDBCUtils.getConnection(), sql, params);
		
	}



}
