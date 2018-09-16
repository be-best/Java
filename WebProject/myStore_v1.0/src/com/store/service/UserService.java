package com.store.service;

import java.sql.SQLException;

import com.store.domain.Adminer;
import com.store.domain.User;

/**
 * 用户模块Service层的接口
 * @author 45度炸
 *
 */
public interface UserService {

	User findByUsername(String username) throws SQLException;

	void saveUser(User newUser) throws SQLException;

	User findByCode(String code) throws SQLException;

	void updateUser(User user) throws SQLException;

	User userLogin(User user) throws SQLException;

	Adminer adminLogin(Adminer adminer) throws SQLException;




}
