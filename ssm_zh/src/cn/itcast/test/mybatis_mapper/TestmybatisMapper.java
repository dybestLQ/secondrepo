package cn.itcast.test.mybatis_mapper;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import cn.itcast.mapper.dao.UserMapper;

public class TestmybatisMapper {
	private SqlSessionFactory sqlSessionFactory;
	@Before
	public void init() throws Exception{
		sqlSessionFactory=new SqlSessionFactoryBuilder().build(Resources.getResourceAsReader("SqlMapConfig.xml"));
	}
	@Test
	public void test1() throws Exception{
		SqlSession session = sqlSessionFactory.openSession();
		UserMapper userMapper = session.getMapper(UserMapper.class);
		System.out.println(userMapper.findUserById(31));
		session.close();
	}
	@Test
	public void test2() throws Exception{
		SqlSession session = sqlSessionFactory.openSession();
		UserMapper userMapper = session.getMapper(UserMapper.class);
		System.out.println(userMapper.findUserByName2("уе"));
		session.close();
	}
}
