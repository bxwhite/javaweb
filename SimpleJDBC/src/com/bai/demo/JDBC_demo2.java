package com.bai.demo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;

import com.bai.utils.JdbcUtils;


public class JDBC_demo2 {
	//
	public static void main(String[] args) throws SQLException {
		//
		
		Connection conn = JdbcUtils.getConnection();
		String sql = "select * from users";
		//String sql = "insert into users(id,name,password,email,birthday) values(?,?,?,?,?)";
		Statement st = conn.createStatement();
		//PreparedStatement st = conn.prepareStatement(sql);
		/* st.setInt(1, 1);//id是int类型的
		 st.setString(2, "bai");//name是varchar(字符串类型)
		 st.setString(3, "123");//password是varchar(字符串类型)
		 st.setString(4, "bhsh@sina.com");//email是varchar(字符串类型)
		 st.setDate(5, new java.sql.Date(new Date().getTime()));//birthday是date类型
*/		
		//int sum =  st.executeUpdate();
		/*ResultSet rs = st.executeQuery(sql);
		if(rs!= null)
		{
			System.out.println(rs.next());
		}*/
		ResultSet rs = st.executeQuery(sql);
		while(rs.next()){
            System.out.println("id=" + rs.getObject("id"));
            System.out.println("name=" + rs.getObject("name"));
            System.out.println("password=" + rs.getObject("password"));
            System.out.println("email=" + rs.getObject("email"));
            System.out.println("birthday=" + rs.getObject("birthday"));
        }
	}
}
