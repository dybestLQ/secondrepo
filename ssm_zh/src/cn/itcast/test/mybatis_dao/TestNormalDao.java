package cn.itcast.test.mybatis_dao;

import java.util.Date;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import cn.itcast.mybatis.dao.UserDao;
import cn.itcast.mybatis.dao.impl.UserDaoImpl;
import cn.itcast.test.jdbc.User;

public class TestNormalDao {
	private SqlSessionFactory sqlSessionFactory;
	@Before
	public void init() throws Exception{
		sqlSessionFactory=new SqlSessionFactoryBuilder().build(Resources.getResourceAsReader("SqlMapConfig.xml"));
	}
	@Test
	public void test1() throws Exception{
		UserDao userDao = new UserDaoImpl(sqlSessionFactory);
		System.out.println(userDao.findUserById(1));
	}
	@Test
	public void test2() throws Exception{
		UserDao userDao = new UserDaoImpl(sqlSessionFactory);
		System.out.println(userDao.findUserByName2("ÕÅ"));
	}
	@Test
	public void test3() throws Exception{
		UserDao userDao = new UserDaoImpl(sqlSessionFactory);
		User user = new User();
		user.setUsername("Ð¡Ò°Âí");
		user.setBirthday(new Date());
		userDao.saveUser(user);
	}
	
}
