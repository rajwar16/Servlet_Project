package com.bridgeLabz.StudentForm.StudentLogin;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginUser extends HttpServlet
{

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Connection connection=null;
		PreparedStatement preparedStatemnt=null;
		PrintWriter printWriter=response.getWriter();
		boolean flag=false;

		String userName=request.getParameter("userName");
		String passWord=request.getParameter("password");

		String query="select * from StudentData.StudentFormData where StudentName='"+userName+"' and Password='"+passWord+"'";

		try 
		{
			Class.forName("com.mysql.jdbc.Driver");
			connection=DriverManager.getConnection("jdbc:mysql://localhost:3306?user=root&password=pooja");
			preparedStatemnt=connection.prepareStatement(query);
			ResultSet resultSet=preparedStatemnt.executeQuery();
			while(resultSet.next())
			{
				String userName1=resultSet.getString(2);
				String password1=resultSet.getString(3);
				if(userName1.equals(userName)&&password1.equals(passWord))
				{
					RequestDispatcher requestDispatcher=request.getRequestDispatcher("welcome.html");
					flag=true;
					requestDispatcher.forward(request, response);
					System.out.println("login sucessfully....");
				}
				
			}
			if(flag==false)
			{
				printWriter.println("Sorry incorrect userName and password...");
				RequestDispatcher requestDispatcher=request.getRequestDispatcher("LoginUser.html");
				requestDispatcher.forward(request, response);
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
