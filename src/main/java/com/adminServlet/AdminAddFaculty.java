package com.adminServlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.LinkedHashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.admin.Admin;
import com.faculty.FacultyInfo;

/**
 * Servlet implementation class AdminAddFaculty
 */
@WebServlet("/AdminAddFaculty")
public class AdminAddFaculty extends HttpServlet {
	private static final long serialVersionUID = 1L;
  

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		 PrintWriter out = response.getWriter();
		 String formName = request.getParameter("formName");
		 if(formName.equals("addFaculty"))
		 {
			 String f_name = request.getParameter("f_name");
			 String f_email = request.getParameter("f_email");
			 String dob = request.getParameter("dob");
			 String address = request.getParameter("address");
			 String bloodgroup = request.getParameter("bloodgroup");
			 String course = request.getParameter("course");
			 String yearJoin = request.getParameter("yearJoin");
			 String mobileNum = request.getParameter("mobileNum");
			 String designation = request.getParameter("designation");
			 FacultyInfo faculty = new FacultyInfo(f_name,f_email,dob,address,bloodgroup,designation,course,yearJoin,mobileNum);
			 out.print(faculty);
			 try {
				if(Admin.addFaculty(faculty))
				  {
					  response.sendRedirect("adminFaculty.jsp");
				  }
				  else
				  {
					  out.print("PROVIDE REQUIRED DETAILS");
				  }
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			 
		 }
		 else if(formName.equals("removeFaculty"))
		 {
			 String facultyId = request.getParameter("faculty_id");
			 try {
				if(Admin.removeFaculty(facultyId))
				 {
					 response.sendRedirect("adminFaculty.jsp");
				 }
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		 }
		 else if(formName.equals("editFaculty"))
		 {
			 String faculty_id = request.getParameter("faculty_Id");
			 LinkedHashMap<String,String> fac = new LinkedHashMap<String,String>();
			 fac.put("f_name",request.getParameter("f_name"));
				fac.put("f_email", request.getParameter("f_email"));
				fac.put("dob", request.getParameter("dob"));
				fac.put("address",request.getParameter("address"));
				fac.put("bloodgroup", request.getParameter("bloodgroup"));
				fac.put("designation", request.getParameter("designation"));
				fac.put("course",request.getParameter("course"));
				fac.put("yearJoin",request.getParameter("yearJoin"));
				fac.put("mobileNum", request.getParameter("mobileNum"));
				try {
					if(Admin.editFaculty(faculty_id, fac))
					{
						response.sendRedirect("adminFaculty.jsp");
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
