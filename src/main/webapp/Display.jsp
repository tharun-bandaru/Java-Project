<%@ page import="java.sql.*" %>
<% Class.forName("oracle.jdbc.driver.OracleDriver"); %>
<HTML>
      
       <HEAD>
       <TITLE>The View Of Student Database Table </TITLE>
        </HEAD>
       <BODY bgcolor="cyan" >
        <style>
       TABLE{
       border: 1px solid;
       border-collapse: collapse;
        width: 100%;
         text-align: center;

        }
        th, td {
  		border-bottom: 1px solid #ddd;
  		font-size: 25px
		}
		tr:hover {background-color: coral;}	
	</style>
       <font color="red"><center><H1>The View Of Student Database Table </H1></center></font>
       <%
       Connection connection=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","tharun123");
       Statement statement = connection.createStatement() ;
       ResultSet resultset = statement.executeQuery("select * from student") ;
       %>
      <TABLE BORDER="1">
      <TR>
      <TH>FirstName</TH>
      <TH>LastName</TH>
      <TH>Mobile</TH>
      <TH>Email</TH>
      <TH>Gender</TH>
      <TH>Hall Ticket</TH>
      <TH>Address</TH>
      
      </TR>
      <% while(resultset.next()){ %>
      <TR>
       <TD> <%= resultset.getString(1) %></td>
       <TD> <%= resultset.getString(2) %></TD>
       <TD> <%= resultset.getString(3) %></TD>
       <TD> <%= resultset.getString(4) %></TD>
       <TD> <%= resultset.getString(5) %></TD>
       <TD> <%= resultset.getString(6) %></TD>
       <TD> <%= resultset.getString(7) %></TD>
       

      </TR>
      <% } %>
     </TABLE>
     </BODY>
</HTML>
