package cn.itcast.test.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.junit.Test;

public class JDBCTest {
	@Test
	public void test() throws Exception {
		//1,�������ݿ�����
		Class.forName("com.mysql.jdbc.Driver");
		//2,�������ݿ�����
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/crm","root","123456");
		//3,���Preparedstatement����
		String sql = "select * from user where id =?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, 1);
		//4,��ý����
		ResultSet rs = pstmt.executeQuery();
		//5,��������
		while(rs.next()){
			System.out.println(rs.getString(1)+":"+rs.getString(2));
		}
		rs.close();
		pstmt.close();
		conn.close();
	}

}
