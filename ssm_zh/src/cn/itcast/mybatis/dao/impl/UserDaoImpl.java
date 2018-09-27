package cn.itcast.mybatis.dao.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import cn.itcast.mybatis.dao.UserDao;
import cn.itcast.test.jdbc.User;

public class UserDaoImpl implements UserDao {
	private SqlSessionFactory sqlSessionFactory;
	
	public SqlSessionFactory getSqlSessionFactory() {
		return sqlSessionFactory;
	}
	public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
		this.sqlSessionFactory = sqlSessionFactory;
	}
	public UserDaoImpl(SqlSessionFactory sqlSessionFactory){
		this.setSqlSessionFactory(sqlSessionFactory);
	}
	@Override
	public User findUserById(int id) {
		SqlSession openSession = sqlSessionFactory.openSession();
		User user = openSession.selectOne("user.findUserById", id);
		openSession.close();
		return user;
	}

	@Override
	public List<User> findUserByName2(String username) {
		SqlSession openSession = sqlSessionFactory.openSession();
		List<User> list = openSession.selectList("user.findUserByName2", username);
		openSession.close();
		return list;
	}

	@Override
	public void saveUser(User user) {
		SqlSession openSession = sqlSessionFactory.openSession();
		openSession.update("user.saveUser", user);
		openSession.commit();
		openSession.close();
	}

}
