package com.tcs;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class DisplayServlet
 */
public class DisplayServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    public DisplayServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter writer=response.getWriter();
		writer.println("Display Servlet.......");
		
		  try { Class.forName("oracle.jdbc.driver.OracleDriver"); Connection
		  connection=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","tharun123"); 
		  Statement statement=connection.createStatement(); 
		  ResultSet set=statement.executeQuery("select * from student");
		  writer.println("<b> FirstName LastName Mobile Email Gender Address</b><br><br>");
		  while(set.next())
		  {
		  writer.println(set.getString(1)+" "+set.getString(2)+" "+set.getString(3)+" "+set.getString(4)+" "+set.getString(5)+" "+set.getString(6));
    	  writer.println("<br><br>");
    	     }
		  
		  } catch(Exception e) { e.printStackTrace(); }
		 
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
