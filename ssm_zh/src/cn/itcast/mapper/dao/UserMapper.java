package cn.itcast.mapper.dao;

import java.util.List;

import cn.itcast.test.jdbc.User;

public interface UserMapper {
	public User findUserById(int id);
	public List<User> findUserByName2(String username);
	public void saveUser(User user);
}
