package com.student;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.util.LinkedHashMap;
import java.util.TreeMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.admin.Admin;

/**
 * Servlet implementation class StudentServlet
 */
@WebServlet("/StudentServlet")
public class StudentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String formName = request.getParameter("formName");
		if(formName.equals("register"))
		{
			LinkedHashMap<String,String> student = new LinkedHashMap<String,String>();
			student.put("stu_name",request.getParameter("stu_name"));
			student.put("stu_email", request.getParameter("stu_email"));
			student.put("year", request.getParameter("year"));
			student.put("degree", request.getParameter("degree"));
			student.put("department", request.getParameter("department"));
			student.put("dob", request.getParameter("dob"));
			student.put("address", request.getParameter("address"));
			student.put("mobileNum", request.getParameter("mobileNum"));
			student.put("bloodgroup", request.getParameter("bloodgroup"));
			try {
				String userId =  Admin.addStudent(student);
				//System.out.print(userId);
				if(userId.length()!=0)
				{
					HttpSession session = request.getSession();
					session.setAttribute("userId", userId);
					response.sendRedirect("StudentLogin.jsp");
				}
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
		}
		else if(formName.equals("editdt"))
		{
			try {
				TreeMap<String,LinkedHashMap<String,String>> tm = Admin.getRec();
				LinkedHashMap<String,String> student = new LinkedHashMap<String,String>();
				String stu_roll = request.getParameter("stu_id");
				//System.out.println(stu_roll);
				student.put("stu_name",request.getParameter("stu_name"));
				student.put("stu_email", request.getParameter("stu_email"));
				student.put("year", request.getParameter("year"));
				student.put("degree", request.getParameter("degree"));
				student.put("department", request.getParameter("department"));
				student.put("dob", request.getParameter("dob"));
				student.put("address", request.getParameter("address"));
				student.put("mobileNum", request.getParameter("mobileNum"));
				student.put("bloodgroup", request.getParameter("bloodgroup"));
				//System.out.println(tm);
				tm.put(stu_roll, student);
				HttpSession session = request.getSession();
				session.setAttribute("student", student);
				FileOutputStream fout1 = new FileOutputStream("D:/III Year Project/DSAProject/studentDetails.txt");
				ObjectOutputStream out1 = new ObjectOutputStream(fout1);
				out1.writeObject(tm);
				out1.close();
				fout1.close();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			response.sendRedirect("StudentIndex.jsp");
		}
		else {
			PrintWriter out = response.getWriter();
			out.print("HI");
		String userID= request.getParameter("userID");
		String password = request.getParameter("password");
		
		out.print(userID+" "+password);
		try {
			if(Admin.validateStudent(userID, password))
			{
				HttpSession session = request.getSession();
				  LinkedHashMap<String,String> stu = Admin.getRec().get(userID);
				  out.print(stu+" "+userID);
				  session.setAttribute("userID", userID);
				session.setAttribute("student", stu);
				response.sendRedirect("StudentIndex.jsp");
			}
			else
			{
				out.print("INVALID PASSWORD"+userID+" "+userID.length() +" "+password+" "+password.length());
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
