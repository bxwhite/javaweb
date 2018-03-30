package com.bai.servlet;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**字符流输出*/
public class Pwriter_Ostream extends HttpServlet{
	public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
		
		//outputOneByOutputStream(response);//使用OutputStream输出1到客户端浏览器
		outputOneByPrintWriter( response);
		        
	}

	private void outputOneByPrintWriter(HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub
		 response.setHeader("content-type", "text/html;charset=UTF-8");
		 response.setCharacterEncoding("UTF-8");
		         PrintWriter out = response.getWriter();//获取PrintWriter输出流
		         out.write("使用PrintWriter流输出数字1：");
		         out.write("中国");
	}

	/*private void outputOneByOutputStream(HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub
		 response.setHeader("content-type", "text/html;charset=UTF-8");
		 response.setCharacterEncoding("UTF-8");
		          OutputStream outputStream = response.getOutputStream();
		          outputStream.write("使用OutputStream流输出数字1：".getBytes("UTF-8"));
		          outputStream.write((1+"").getBytes());
	}*/
}
