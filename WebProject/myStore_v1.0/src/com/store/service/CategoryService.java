package com.store.service;

import java.sql.SQLException;
import java.util.List;

import com.store.domain.Category;


public interface CategoryService {

	List<Category> findAll() throws SQLException;

	void save(Category category) throws SQLException;

	Category findByCid(String cid) throws SQLException;

	void update(Category category) throws SQLException;

	void delete(String cid) throws SQLException;

}
