package com.store.service;

import java.sql.SQLException;
import java.util.List;

import com.store.domain.PageBean;
import com.store.domain.Product;

public interface ProductService {

	List<Product> findByHot() throws SQLException;

	List<Product> findByNew() throws SQLException;

	PageBean<Product> findByCid(String cid, Integer currPage) throws SQLException;

	Product findByPid(String pid) throws SQLException;

	PageBean<Product> searchProduct(String productKeywords, Integer currPage) throws SQLException;

	PageBean<Product> findByPage(Integer currPage) throws SQLException;

	void addProduct(Product product) throws SQLException;

	void pushDown(Product product) throws SQLException;

	PageBean findByPushDown(Integer currPage) throws SQLException;

	void pushUp(Product product) throws SQLException;

	void deleteProduct(String pid) throws SQLException;

	PageBean<Product> searchOldProduct(String productKeywords, Integer currPage) throws SQLException;

	void updateProduct(Product product) throws SQLException;

}
