package com.bridgeLabz.StudentForm.StudentLogin;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginForm extends HttpServlet
{
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Connection connection=null;
		PreparedStatement preparedStatemnt=null;
		String query="insert into StudentData.StudentLoginFormData values(?,?,?,?,?,?,?,?)";
		String id1=request.getParameter("studentid");
		int id=Integer.parseInt(id1);
		String studentName=request.getParameter("studentName");
		String gender=request.getParameter("gender");
		String emailId=request.getParameter("emailId");
		String contactNo1=request.getParameter("contactNo");
		long contactNo=Integer.parseInt(contactNo1);
		String address=request.getParameter("address");
		String password=request.getParameter("password"); 

		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306?user=root&password=pooja");
			System.out.println("Connection establish...");
			preparedStatemnt=connection.prepareStatement(query);

			preparedStatemnt.setInt(1, id);
			preparedStatemnt.setString(2, studentName);
			preparedStatemnt.setString(3, gender);
			preparedStatemnt.setString(4, emailId);
			preparedStatemnt.setLong(5, contactNo);
			preparedStatemnt.setString(6, address);
			preparedStatemnt.setString(7, studentName);
			preparedStatemnt.setString(8, password);
			preparedStatemnt.execute();

			System.out.println("Query Executed successfully.....");
			RequestDispatcher requestDispatcher=request.getRequestDispatcher("LoginUser.html");
			requestDispatcher.forward(request, response);

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}
}
		


