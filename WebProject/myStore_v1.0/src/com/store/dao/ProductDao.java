package com.store.dao;

import java.sql.SQLException;
import java.util.List;

import com.store.domain.Product;

public interface ProductDao {

	List<Product> findByHot() throws SQLException;

	List<Product> findByNew() throws SQLException;

	Integer findByCid(String cid) throws SQLException;

	List<Product> findPageByCid(String cid, int begin, Integer pageSize) throws SQLException;

	Product findByPid(String pid) throws SQLException;

	List<Product> searchProduct(String productKeywords, int begin, Integer pageSize) throws SQLException;

	Integer searchCount(String productKeywords) throws SQLException;

	Integer findByCount() throws SQLException;

	List<Product> findByPage(int begin, Integer pageSize) throws SQLException;

	void addProduct(Product product) throws SQLException;

	void pushDown(Product product) throws SQLException;

	Integer findCountByPushDown() throws SQLException;

	List<Product> findPageByPushDown(int begin, Integer pageSize) throws SQLException;

	void pushUp(Product product) throws SQLException;

	void deleteProduct(String pid) throws SQLException;

	Integer searchOldProductCount(String productKeywords) throws SQLException;

	List<Product> searchOldProduct(String productKeywords, int begin,
			Integer pageSize) throws SQLException;

	void updateProduct(Product product) throws SQLException;

}
