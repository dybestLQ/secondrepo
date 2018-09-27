package cn.itcast.test.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.junit.Test;

public class JDBCTest {
	@Test
	public void test() throws Exception {
		//1,加载数据库驱动
		Class.forName("com.mysql.jdbc.Driver");
		//2,建立数据库连接
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/crm","root","123456");
		//3,获得Preparedstatement对象
		String sql = "select * from user where id =?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, 1);
		//4,获得结果集
		ResultSet rs = pstmt.executeQuery();
		//5,处理结果集
		while(rs.next()){
			System.out.println(rs.getString(1)+":"+rs.getString(2));
		}
		rs.close();
		pstmt.close();
		conn.close();
	}

}
