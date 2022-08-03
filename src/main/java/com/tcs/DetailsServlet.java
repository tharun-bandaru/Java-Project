package com.tcs;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DetailsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    public DetailsServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		

		response.setContentType("text/html");
		
		PrintWriter out=response.getWriter();
		String firstname=request.getParameter("firstname");
		String lastname=request.getParameter("lastname");
		
		String email=request.getParameter("email");
		String mobile=request.getParameter("mobile");
		String gender=request.getParameter("gender");
		String htno=request.getParameter("htno");
		
		 String[] addr=request.getParameterValues("t1");
		 StringBuffer buffer=new StringBuffer(); 
		 for(String data:addr) 
		 { 
			 buffer.append(data+",");
		 }
		 String caddr=buffer.toString();
		 try {
				
				Class.forName("oracle.jdbc.driver.OracleDriver"); 
		        Connection connection=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","tharun123");
				System.out.println("connection created successfully");	
					
				PreparedStatement preparedStatement=connection.prepareStatement("insert into student values(?,?,?,?,?,?,?)");
				preparedStatement.setString(1, firstname);
				preparedStatement.setString(2,lastname);
				preparedStatement.setString(3, mobile);
				preparedStatement.setString(4, email);
				preparedStatement.setString(5,gender);
				preparedStatement.setString(6, htno);
				preparedStatement.setString(7, caddr);
				
				int a=preparedStatement.executeUpdate();
					
				if(a==1)
					{
				     out.println("<font color='lightpink' size='50'>Data Inserted Successfully.....<br><br></font>");
					 out.println("<a href='Display.jsp'><font size='50'>Click here to display all the deatails......</font></a>");
				    }
		 }
		 catch(Exception e)
		 {
			 e.printStackTrace();
		 }

	}

}
