package com.store.dao.imple;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.store.dao.CategoryDao;
import com.store.domain.Category;
import com.store.utils.C3P0JDBCUtils;

public class CategoryDaoImple implements CategoryDao {
	/**
	 * 查询所有分类
	 * @return 
	 * @throws SQLException 
	 */
	@Override
	public List<Category> findAll() throws SQLException {
		QueryRunner queryRunner = new QueryRunner(C3P0JDBCUtils.getDataSource());
		String sql = "select * from category";
		List<Category> list = queryRunner.query(sql, new BeanListHandler<Category>(Category.class));
		return list;
	}

	/**
	 * 添加分类
	 * @throws SQLException 
	 */
	@Override
	public void save(Category category) throws SQLException {
		QueryRunner queryRunner = new QueryRunner(C3P0JDBCUtils.getDataSource());
		String sql = "insert into category values (?,?)";
		queryRunner.update(sql,category.getCid(),category.getCname());
	}

	/**
	 * 根据ID查询分类
	 * @throws SQLException 
	 */
	@Override
	public Category findByCid(String cid) throws SQLException {
		QueryRunner queryRunner = new QueryRunner(C3P0JDBCUtils.getDataSource());
		String sql = "select * from category where cid = ?";
		Category category = queryRunner.query(sql, new BeanHandler<Category>(Category.class),cid);
		return category;
	}

	/**
	 * 修改分类
	 * @throws SQLException 
	 */
	@Override
	public void update(Category category) throws SQLException {
		QueryRunner queryRunner = new QueryRunner(C3P0JDBCUtils.getDataSource());
		String sql = "update category set cname = ? where cid = ?";
		queryRunner.update(sql, category.getCname(),category.getCid());
		
	}

	/**
	 * 删除分类，注意分类下有商品，可以把商品与category关联的外键cid改为null,然后再删除category
	 * @throws SQLException 
	 */
	@Override
	public void detete(String cid) throws SQLException {
		QueryRunner queryRunner = new QueryRunner(C3P0JDBCUtils.getDataSource());
		String sql = "update product set cid = null where cid = ?";
		queryRunner.update(sql, cid);
		sql="delete from category where cid = ?";
		queryRunner.update(sql, cid);
	}

}











