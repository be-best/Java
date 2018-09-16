package com.store.dao.imple;

import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import com.store.dao.UserDao;
import com.store.domain.Adminer;
import com.store.domain.User;
import com.store.utils.C3P0JDBCUtils;

public class UserDaoImple implements UserDao {

	/**
	 * 异步校验用户名
	 */
	@Override
	public User findByUsername(String username) throws SQLException {
		QueryRunner queryRunner = new QueryRunner(C3P0JDBCUtils.getDataSource());
		String sql = "select * from user where username = ?";
		User user = queryRunner.query(sql, new BeanHandler<User>(User.class), username);
		return user;
	}

	/**
	 * 用户注册
	 * @throws SQLException 
	 */
	@Override
	public void saveUser(User newUser) throws SQLException {
		QueryRunner queryRunner = new QueryRunner(C3P0JDBCUtils.getDataSource());
		String sql = "insert into user values (?,?,?,?,?,?,?,?,?,?)";
		Object[] params = {newUser.getUid(),newUser.getUsername(),newUser.getPassword(),newUser.getName(),newUser.getEmail(),
				newUser.getTelephone(),newUser.getBirthday(),newUser.getSex(),newUser.getState(),newUser.getCode()};
		queryRunner.update(sql, params);
	}

	/**
	 * 用户激活
	 * @throws SQLException 
	 */
	@Override
	public User findByCode(String code) throws SQLException {
		return null;
//		QueryRunner queryRunner = new QueryRunner(C3P0JDBCUtils.getDataSource());
//		String sql = "select * from user where code = ?";
//		User user = queryRunner.query(sql, new BeanHandler<User>(User.class), code);
//		return user;
	}

	/**
	 * 激活成功后修改状态码和激活码设置为空
	 * @throws SQLException 
	 */
	@Override
	public void updateUser(User user) throws SQLException {
//		QueryRunner queryRunner = new QueryRunner(C3P0JDBCUtils.getDataSource());
//		String sql = "update user set username=?,password=?,name=?,email=?,telephone=?,birthday=?,sex=?,state=?,code=? where uid=?";
//		Object[] params = {user.getUsername(),user.getPassword(),user.getName(),user.getEmail(),user.getTelephone(),user.getBirthday(),
//					user.getSex(),user.getState(),user.getCode(),user.getUid()};
//		queryRunner.update(sql, params);
	}

	/**
	 * 用户登录
	 * @throws SQLException 
	 */
	@Override
	public User userLogin(User user) throws SQLException {
		QueryRunner queryRunner = new QueryRunner(C3P0JDBCUtils.getDataSource());
		String sql = "select * from user where username = ? and password = ? and state = ?";
		User existUser = queryRunner.query(sql, new BeanHandler<User>(User.class), user.getUsername(),user.getPassword(),2);
		return existUser;
	}

	/**
	 * 管理员登录
	 * @throws SQLException 
	 */
	@Override
	public Adminer adminLogin(Adminer adminer) throws SQLException {
		QueryRunner queryRunner = new QueryRunner(C3P0JDBCUtils.getDataSource());
		String sql = "select * from adminer where username = ? and password = ?";
		Adminer existUser = queryRunner.query(sql, new BeanHandler<Adminer>(Adminer.class), adminer.getUsername(),adminer.getPassword());
		return existUser;
		
	}

}
