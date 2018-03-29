package com.bai.demo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.junit.Test;

import com.bai.utils.JdbcUtils;

public class JdbcBatchHandleByPrepareStatement {

    @Test
    public void testJdbcBatchHandleByPrepareStatement(){
        long starttime = System.currentTimeMillis();
        Connection conn = null;
        PreparedStatement st = null;
        ResultSet rs = null;
        
        try{
            conn = JdbcUtils.getConnection();
            String sql = "insert into testbatch(id,name) values(?,?)";
            st = conn.prepareStatement(sql);
            for(int i=1;i<1000008;i++){  //i=1000  2000
                st.setInt(1, i);
                st.setString(2, "aa" + i);
                st.addBatch();
                if(i%1000==0){
                    st.executeBatch();
                    st.clearBatch();
                }
            }
            st.executeBatch();
        }catch (Exception e) {
            e.printStackTrace();
        }finally{
            JdbcUtils.release(conn, st, rs);
        }
        long endtime = System.currentTimeMillis();
        System.out.println("程序花费时间：" + (endtime-starttime)/1000 + "秒！！");
    }
}