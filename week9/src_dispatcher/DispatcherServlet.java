package com.amey.dispatcher;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class DispatcherServlet
 */
@WebServlet("/*")
public class DispatcherServlet extends HttpServlet {


    public DispatcherServlet() {
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String u = request.getRequestURI().substring(request.getContextPath().length());
		if(u.equals("/getEmp")) {
			response.getWriter().append("you are at /getEmp");
		}
		if(u.equals("/getCustomer")) {
			response.getWriter().append("you are at /getCustomer");
		}
		if(u.equals("/getProducts")) {
			response.getWriter().append("you are at /getProducts");
		}
		if(u.equals("/hi")) {
			response.getWriter().append("you are at hi");
		}
		if(u.equals("/hello")) {
			response.getWriter().append("you are at hello");
		}
		if(u.equals("/bye")) {
			response.getWriter().append("you are at bye");
		}
	}

}