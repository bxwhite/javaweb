package com.bai.demo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Savepoint;
import java.sql.Statement;

import com.bai.utils.JdbcUtils;


public class Jdbc_Transaction {
	public static void main(String[] args){
		Connection conn = null;
		PreparedStatement pr = null;
		Statement st = null;
		ResultSet rs = null;
		Savepoint sp = null;
		
		try {
			conn = JdbcUtils.getConnection();
			conn.setAutoCommit(false);//通知数据库开启事务(start transaction)
			//st = conn.createStatement();
			String sql1 = "update account set money=money-100 where name='A'";
			String sql2 = "update account set money=money+100 where name='B'";
			String sql3 = "update account set money=money+100 where name='C'";
			pr = conn.prepareStatement(sql1);
			//rs = st.executeQuery(sql3);
			pr.executeUpdate();
			
			sp = conn.setSavepoint();//回滚点
			 
			
			pr = conn.prepareStatement(sql2);
			pr.executeUpdate();
			
			//int x = 1/0;
			
			pr = conn.prepareStatement(sql3);
			pr.executeUpdate();
			
			conn.commit();
			System.out.println("成功！！！");  //log4j
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			try {
				conn.rollback(sp);
				conn.commit();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}finally {
			JdbcUtils.release(conn, pr, rs);
		}
		
		
		
	}
}	
