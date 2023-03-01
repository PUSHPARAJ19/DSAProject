package com.adminServlet;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.util.LinkedHashMap;
import java.util.TreeMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.admin.Admin;
import com.student.StudentInfo;

/**
 * Servlet implementation class AdminAddStudent
 */
@WebServlet("/AdminAddStudent")
public class AdminAddStudent extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//String id = Admin.id_generate(hm);
		String formName = request.getParameter("formName");
			PrintWriter out = response.getWriter();
		if(formName.equals("addStudent")) {
		String stu_name = request.getParameter("stu_name");
		String stu_email = request.getParameter("stu_email");
		String dob = request.getParameter("dob");
		//String age = request.getParameter("dob");
		String bloodgroup = request.getParameter("bloodgroup");
		String address = request.getParameter("address");
		String mobileNum = request.getParameter("mobile");
		String year = request.getParameter("year");
		String degree = request.getParameter("degree");
		String department = request.getParameter("department");
		StudentInfo student = new StudentInfo(stu_name,stu_email, year, degree,  department,
				 dob,address,  mobileNum,  bloodgroup);
		
		//out.print("HI"+stu_name);
		try {
			if(Admin.addStudent(student)==true)
			{
				response.sendRedirect("adminStudent.jsp");
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
		else if(formName.equals("removeStudent"))
		{
			
			String stu_id = request.getParameter("stu_id");
			//out.print("Delete"+stu_id);
			boolean flag=false;
			try {
				 flag = Admin.removeStudent(stu_id);
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if(flag)
		   response.sendRedirect("adminStudent.jsp");
			else
			out.print("<html><head></head><body><h2>INVALID ROLL NO </h2></body></html> ");
		}
		else if(formName.equals("editStudent"))
		{
			String stu_roll = request.getParameter("stu_id");
			//out.print(stu_roll);
			String stu_name = request.getParameter("stu_name");
			String stu_email = request.getParameter("stu_email");
			String dob = request.getParameter("dob");
			//String age = request.getParameter("dob");
			String bloodgroup = request.getParameter("bloodgroup");
			String address = request.getParameter("address");
			String mobileNum = request.getParameter("mobile");
			String year = request.getParameter("year");
			String degree = request.getParameter("degree");
			String department = request.getParameter("department");
			StudentInfo student = new StudentInfo(stu_name,stu_email, year, degree,  department,
					 dob,address,  mobileNum,  bloodgroup);
			try {
				TreeMap<String,LinkedHashMap<String,String>> tm = Admin.getRec();
				LinkedHashMap<String,String> stu = new LinkedHashMap<String,String>();
				stu.put("stu_name", student.getStu_name());
				stu.put("stu_email", student.getStu_email());
				stu.put("year",student.getYear());
				stu.put("degree",student.getDegree());
				stu.put("department", student.getDepartment());
				stu.put("dob", student.getDob());
				stu.put("address",student.getAddress());
				stu.put("mobileNum", student.getMobileNum());
				stu.put("bloodgroup",student.getBloodgroup());
				tm.put(stu_roll, stu);
				FileOutputStream fout1 = new FileOutputStream("D:/III Year Project/DSAProject/studentDetails.txt");
				ObjectOutputStream out1 = new ObjectOutputStream(fout1);
				out1.writeObject(tm);
				out1.close();
				fout1.close();
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		  response.sendRedirect("adminStudent.jsp");
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
