package com.bridgelabz.EmployForm.Model;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class EmployeeDetails extends HttpServlet 
{
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
	Connection connection=null;
	PreparedStatement preparedStatemnt=null;
	PrintWriter printWriter=response.getWriter();
	boolean flag=false;
	
	String name=request.getParameter("name");
	ServletContext servletContext=getServletContext();
	int uid=(int) servletContext.getAttribute("UserId");
	
	/*HttpSession httpSession = request.getSession();
	int uid = (int) httpSession.getAttribute("UserId");*/
	
	String query="select * from StudentData.EmployeeFormData where uerid="+uid+" ORDER BY Age DESC";

	try 
	{
		Class.forName("com.mysql.jdbc.Driver");
		connection=DriverManager.getConnection("jdbc:mysql://localhost:3306?user=root&password=pooja");
		preparedStatemnt=connection.prepareStatement(query);
		ResultSet resultSet=preparedStatemnt.executeQuery();
		/*List<EmployeeDeatails1> employeeDeatails = new ArrayList<EmployeeDeatails1>();
		while(resultSet.next())
		{
			EmployeeDeatails1 employeeDeatails1=new EmployeeDeatails1(resultSet);
			employeeDeatails1.setId(resultSet.getInt(1));
			employeeDeatails1.setEmployeeName(resultSet.getString(2));
			employeeDeatails1.setPassword(resultSet.getString(3));
			employeeDeatails1.setGender(resultSet.getString(4));
			employeeDeatails1.setEmailId(resultSet.getString(5));
			employeeDeatails1.setAddress(resultSet.getString(6));
			employeeDeatails1.setSpecialized(resultSet.getString(7));
			employeeDeatails1.setLanguage(resultSet.getString(8));
			employeeDeatails1.setContactNo(resultSet.getInt(9));
			employeeDeatails1.setAge(resultSet.getInt(10));
			employeeDeatails1.setSalary(resultSet.getFloat(11));
			employeeDeatails.add(employeeDeatails1);
			
			
		}*/
		
		request.setAttribute("resultSet", resultSet);
		RequestDispatcher requestDispatcher=request.getRequestDispatcher("EmployeeDetails.jsp");
		requestDispatcher.forward(request, response);
		
		/*if(flag==false)
		{
			printWriter.println("Sorry that Employee Id is Not present in Database...");
			RequestDispatcher requestDispatcher=request.getRequestDispatcher("EmployLoginForm.jsp");
			requestDispatcher.forward(request, response);
		}*/


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
