package com.faculty;

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
import javax.servlet.http.HttpSession;

import com.admin.Admin;

/**
 * Servlet implementation class requestServlet
 */
@WebServlet("/FacultyServlet")
public class FacultyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
  
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String formName = request.getParameter("formName");
		if(formName.equals("register"))
		{
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
				String userId =  Admin.addFaculty(fac);
				//System.out.print(userId);
				if(userId.length()!=0)
				{
					HttpSession session = request.getSession();
					session.setAttribute("userId", userId);
					response.sendRedirect("FacultyLogin.jsp");
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
				TreeMap<String,LinkedHashMap<String,String>> tm = Admin.getFacultyRec();
				//LinkedHashMap<String,String> f = new LinkedHashMap<String,String>();
				String f_id = request.getParameter("f_id");
				//System.out.println(stu_roll);
				LinkedHashMap<String,String> faculty = new LinkedHashMap<String,String>();
				faculty.put("f_name",request.getParameter("f_name"));
				faculty.put("f_email", request.getParameter("f_email"));
				faculty.put("dob", request.getParameter("dob"));
				faculty.put("address",request.getParameter("address"));
				faculty.put("bloodgroup", request.getParameter("bloodgroup"));
				faculty.put("designation", request.getParameter("designation"));
				faculty.put("course",request.getParameter("course"));
				faculty.put("yearJoin",request.getParameter("yearJoin"));
				faculty.put("mobileNum", request.getParameter("mobileNum"));
				//System.out.println(tm);
				tm.put(f_id, faculty);
				HttpSession session = request.getSession();
				session.setAttribute("faculty", faculty);
				FileOutputStream fout1 = new FileOutputStream("D:/III Year Project/DSAProject/FacultyDetails.txt");
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
			
			response.sendRedirect("FacultyIndex.jsp");
		}
		
		else {
			String userID= request.getParameter("userID");
			String password = request.getParameter("password");
			PrintWriter out = response.getWriter();
			//out.print(userID+" "+password);
			try {
				if(Admin.validateFaculty(userID, password))
				{
					HttpSession session = request.getSession();
					  LinkedHashMap<String,String> faculty = Admin.getFacultyRec().get(userID);
					  //out.print(stu+" "+userID);
					  session.setAttribute("userID", userID);
					session.setAttribute("faculty", faculty);
					response.sendRedirect("FacultyIndex.jsp");
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
