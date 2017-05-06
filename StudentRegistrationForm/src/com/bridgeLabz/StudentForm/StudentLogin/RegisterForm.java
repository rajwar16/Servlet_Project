package com.bridgeLabz.StudentForm.StudentLogin;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RegisterForm extends HttpServlet
{
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
		Connection connection=null;
		PreparedStatement preparedStatemnt=null;
		String query="insert into StudentData.StudentFormData values(?,?,?,?,?,?,?,?,?,?,?,?,?)";
		
		String id1=request.getParameter("studentid");
		int id=Integer.parseInt(id1);
		String studentName=request.getParameter("studentName");
		String password=request.getParameter("password");
		String dateOfBirth=request.getParameter("DOB");
		String gender=request.getParameter("gender");
		String departmant=request.getParameter("department");
		String emailId=request.getParameter("emailId");
		String address=request.getParameter("address");
		String city=request.getParameter("city");
		String district=request.getParameter("district");
		String state=request.getParameter("state");	
		String pincode1=request.getParameter("pincode");
		int pincode=Integer.parseInt(pincode1);
		String contactNo1=request.getParameter("contactNo");
		long contactNo=Long.parseLong(contactNo1);
		
		 

		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306?user=root&password=pooja");
			System.out.println("Connection establish...");
			preparedStatemnt=connection.prepareStatement(query);

			preparedStatemnt.setInt(1, id);
			preparedStatemnt.setString(2, studentName);
			preparedStatemnt.setString(3, password);
			preparedStatemnt.setString(4, dateOfBirth);
			preparedStatemnt.setString(5, gender);
			preparedStatemnt.setString(6, departmant);
			preparedStatemnt.setString(7, emailId);
			preparedStatemnt.setString(8, address);
			preparedStatemnt.setString(9, city);
			preparedStatemnt.setString(10, district);
			preparedStatemnt.setString(11, state);
			preparedStatemnt.setInt(12, pincode);
			preparedStatemnt.setLong(13, contactNo);
			preparedStatemnt.execute();

			System.out.println("Query Executed successfully.....");
			RequestDispatcher requestDispatcher=request.getRequestDispatcher("LoginUser.html");
			requestDispatcher.forward(request, response);

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}
}
