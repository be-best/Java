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
		// 添加
		QueryRunner queryRunner = new QueryRunner(JDBCUtils.getDataSource());
		String sql = "insert into products(pname,price,flag,category_id) values (?,?,?,?);";
		Object[] params = {product.getPname(),product.getPrice(),product.getFlag(),product.getCategory_id()};
		queryRunner.update(sql, params);
	}

	public Product findById(Integer pid) throws SQLException {
		// 查询
		QueryRunner queryRunner = new QueryRunner(JDBCUtils.getDataSource());
		String sql = "select * from products where pid = ?;";
		Object[] params = {pid};
		//将查询的数据封装到Product这个JavaBean中。
		return queryRunner.query(sql, new BeanHandler<Product>(Product.class), params);
	}

	
	public void edit(Product product) throws SQLException {
		// 修改
		QueryRunner queryRunner = new QueryRunner(JDBCUtils.getDataSource());
		String sql = "update products set pname = ?, price = ?,category_id = ? where pid = ?;";
		Object[] params = {product.getPname(),product.getPrice(),product.getCategory_id(),product.getPid()};
		queryRunner.update(sql, params);
		
	}

	public List findAll() throws SQLException {
		// 查询所有
		QueryRunner queryRunner = new QueryRunner(JDBCUtils.getDataSource());
		String sql = "select * from products;";
		Object[] params = {};
		List<Map<String,Object>> list = queryRunner.query(sql, new MapListHandler(), params);
		return list;
	}

	public void delete(Integer pid) throws SQLException {
		// 删除
		QueryRunner queryRunner = new QueryRunner();//采用事务方式，此处不用获取连接
		String sql = "delete from products where pid = ?;";
		Object[] params = {pid};
		//此处要获取连接
		queryRunner.update(JDBCUtils.getConnection(), sql, params);
		
	}

	public void deleteAll(Integer pid) throws SQLException {
		// 删除全部记录
		QueryRunner queryRunner = new QueryRunner();
		String sql = "delete from products where pid = ?;";
		Object[] params = {pid};
		queryRunner.update(JDBCUtils.getConnection(), sql, params);
		
	}



}
