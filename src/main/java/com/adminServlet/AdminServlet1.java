package com.adminServlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.LinkedHashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.admin.Admin;

/**
 * Servlet implementation class AdminServlet1
 */
@WebServlet("/AdminServlet1")
public class AdminServlet1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		String formName = request.getParameter("formName");
		PrintWriter out = response.getWriter();
		if(formName.equals("addAdmin"))
		{
			LinkedHashMap<String,String> admin = new LinkedHashMap<String,String>();
		   admin.put("Name", request.getParameter("Name"));
		   admin.put("Dob", request.getParameter("Dob"));
		   admin.put("Email", request.getParameter("Email"));
		   admin.put("Address", request.getParameter("Address"));
		   admin.put("YearOfJoin", request.getParameter("YearOfJoin"));
		   try {
			if(Admin.addAdmin(admin))
			   {
				HttpSession session = request.getSession();
				session.setAttribute("admin", session.getAttribute("admin"));
				response.sendRedirect("adminIndex.jsp");
			   }
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
		else {
		String userName = request.getParameter("userId");
		String passWord = request.getParameter("password");
		try {
			if( Admin.validateAdmin(userName, passWord))
			{
				HttpSession session = request.getSession();
				session.setAttribute("admin", Admin.getAdminRec(userName));
				response.sendRedirect("adminIndex.jsp");
			}
			else                                                                  
				out.print("ENter a valid");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			e.getCause();
			e.getMessage();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//out.print("HI");
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
