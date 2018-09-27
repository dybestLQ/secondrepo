package cn.itcast.test.mybatis;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import cn.itcast.test.jdbc.User;

public class MybatisTest {
	private SqlSessionFactory sqlSessionFactory;
	@Before
	public void init() throws IOException {
		sqlSessionFactory = new SqlSessionFactoryBuilder().build(Resources.getResourceAsStream("SqlMapConfig.xml"));
	}
	@Test
	public void test() throws Exception{
		SqlSession session = sqlSessionFactory.openSession();
		User user = session.selectOne("user.findUserById", 1);
		System.out.println(user);
		session.close();
	}
	@Test
	public void query1() throws Exception{
		SqlSession session = sqlSessionFactory.openSession();
		List<User> selectList = session.selectList("findUserByName1", "%��%");
		System.out.println(selectList);
		session.close();
	}
	@Test
	public void query2() throws Exception{
		SqlSession session = sqlSessionFactory.openSession();
		List<User> selectList = session.selectList("findUserByName2", "��");
		System.out.println(selectList);
		session.close();
	}
	@Test
	public void insert() throws Exception{
		SqlSession session = sqlSessionFactory.openSession();
		User user = new User();
		user.setBirthday(new Date());
		user.setUsername("���ֺ�«��1");
		user.setAddress("����");
		user.setSex("2");
		int rows = session.insert("saveUser", user);
		System.out.println("Ӱ�������"+rows);
		System.out.println("�������ݵ�idΪ:"+user.getId());
		session.commit();
		session.close();
	}
	@Test
	public void delete() throws Exception{
		SqlSession session = sqlSessionFactory.openSession();
		session.delete("deleteUserById", 32);
		session.commit();
		session.close();
	}
	@Test
	public void update() throws Exception{
		SqlSession session = sqlSessionFactory.openSession();
		User user = session.selectOne("findUserById",31);
		user.setUsername(user.getUsername()+"222");
		session.update("updateUser", user);
		session.commit();
		session.close();
	}
}
