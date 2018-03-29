package com.bai.demo;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import org.junit.Test;

import com.bai.utils.JdbcUtils;

public class JdbcBatchHandleByStatement {

    @Test
    public void testJdbcBatchHandleByStatement(){
    	long starttime = System.currentTimeMillis();
        Connection conn = null;
        Statement st = null;
        ResultSet rs = null;
        try{
            conn = JdbcUtils.getConnection();
            String sql1 = "insert into testbatch(id,name) values(1,'aaa')";
            String sql2 = "insert into testbatch(id,name) values(2,'bbb')";
            String sql3 = "insert into testbatch(id,name) values(3,'CCC')";
            String sql4 = "insert into testbatch(id,name) values(4,'DDD')";
            String sql5 = "update testbatch set name='gacl' where id=1";
            String sql6 = "insert into testbatch(id,name) values(5,'FFF')";
            String sql7 = "delete from testbatch where id=2";
            st = conn.createStatement();
            //添加要批量执行的SQL
            st.addBatch(sql1);
            st.addBatch(sql2);
            st.addBatch(sql3);
            st.addBatch(sql4);
            st.addBatch(sql5);
            st.addBatch(sql6);
            st.addBatch(sql7);
            //执行批处理SQL语句
            st.executeBatch();
            //清除批处理命令
            st.clearBatch();
        }catch (Exception e) {
            e.printStackTrace();
        }finally{
            JdbcUtils.release(conn, st, rs);
        }
        long endtime = System.currentTimeMillis();
        System.out.println("程序花费时间：" + (endtime-starttime)/1000 + "秒！！");
    }
}