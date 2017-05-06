package com.bridgelabz.EmployForm.Model;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginForm extends HttpServlet
{
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
	Connection connection=null;
	PreparedStatement preparedStatemnt=null;
	PrintWriter printWriter=response.getWriter();
	boolean flag=false;
	
	ServletContext servletContext=getServletContext();

	String userName=request.getParameter("userName");
	String passWord=request.getParameter("password");
	String query="select * from StudentData.User_info where UserName='"+userName+"' and password='"+passWord+"'";

	try 
	{
		Class.forName("com.mysql.jdbc.Driver");
		connection=DriverManager.getConnection("jdbc:mysql://localhost:3306?user=root&password=pooja");
		preparedStatemnt=connection.prepareStatement(query);
		ResultSet resultSet=preparedStatemnt.executeQuery();
		while(resultSet.next())
		{	
			int uid=resultSet.getInt(1);
			String userName1=resultSet.getString(2);
			String password1=resultSet.getString(3);
			
			if(userName1.equals(userName)&&password1.equals(passWord))
			{
				servletContext.setAttribute("UserId", uid);
				HttpSession httpSession = request.getSession();
				httpSession.setAttribute("UserId", uid);
				RequestDispatcher requestDispatcher=request.getRequestDispatcher("EmployeeDetails");
				flag=true;
				requestDispatcher.forward(request, response);
				System.out.println("login sucessfully....");
			}
			
		}
		if(flag==false)
		{
			request.setAttribute("incorrectMassage", "Sorry incorrect userName and password...");
			//printWriter.println("Sorry incorrect userName and password...");
			RequestDispatcher requestDispatcher=request.getRequestDispatcher("EmployLoginForm.jsp");
			requestDispatcher.include(request, response);
		}


	} catch (ClassNotFoundException | SQLException e) {
		e.printStackTrace();
	}
	finally {
		if(connection!=null)
		{
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if (preparedStatemnt!=null) 
		{
			try {
				preparedStatemnt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

}
}
