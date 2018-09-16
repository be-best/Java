package com.store.service;

import java.sql.SQLException;

import com.store.domain.Adminer;
import com.store.domain.User;

/**
 * �û�ģ��Service��Ľӿ�
 * @author 45��ը
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
