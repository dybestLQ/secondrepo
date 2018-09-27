package cn.itcast.mybatis.dao;

import java.util.List;

import cn.itcast.test.jdbc.User;

public interface UserDao {
	public User findUserById(int id);
	public List<User> findUserByName2(String username);
	public void saveUser(User user);
}	
