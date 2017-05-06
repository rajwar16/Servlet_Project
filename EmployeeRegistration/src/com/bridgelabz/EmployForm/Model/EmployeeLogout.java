package com.bridgelabz.EmployForm.Model;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class EmployeeLogout extends HttpServlet
{
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession httpSession=request.getSession();
		
		
		 response.setContentType("text/html");  
         PrintWriter out=response.getWriter();  
         out.print("<body><h1 style='color:red;margin-left:150px'>You are successfully logged out!</h1></body>");    
         RequestDispatcher requestDispatcher= request.getRequestDispatcher("EmployLoginForm.jsp");
         requestDispatcher.include(request, response); 
         HttpSession session=request.getSession();  
         session.invalidate();  
           
         out.close();  
	}
}
