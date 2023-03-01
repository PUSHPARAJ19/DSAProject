package com.admin;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.PrintWriter;
import java.util.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.student.StudentInfo;

/**
 * Servlet implementation class AdminStudent
 */
@WebServlet("/AdminStudent")
public class AdminStudent extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminStudent() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out = response.getWriter();
		out.print("<!DOCTYPE html>\r\n"
				+ "<html>\r\n"
				+ "<head>\r\n"
				+ "<meta http-equiv=\"Content-Type\" content=\"text/html; charset=ISO-8859-1\">\r\n"
				+ "<title>SRP</title>\r\n   <link href=\"https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/css/bootstrap.min.css\" rel=\"stylesheet\"\r\n"
				+ "    integrity=\"sha384-gH2yIJqKdNHPEq0n4Mqa/HGKIhSkIHeL5AyhkYV8i59U5AR6csBvApHHNl/vI1Bx\" crossorigin=\"anonymous\">\r\n"
				+ "<script src=\"https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/js/bootstrap.bundle.min.js\"\r\n"
				+ "    integrity=\"sha384-A3rJD856KowSb7dwlZdYEkO39Gagi7vIsF0jrRAoQmDKKtQBHUuLZ9AsSv4jD4Xa\"\r\n"
				+ "    crossorigin=\"anonymous\"></script>"
                 + "</head>\r\n"
				+ "\r\n"
				+ "<body>\r\n<div class=\"container-fluid py-5 \">"
				+ "\r\n"
				+ "<ul class=\"nav justify-content-end bg-primary\">\r\n"
				+ "  <li class=\"nav-item\">\r\n"
				+ "    <a class=\"nav-link active text-white\" aria-current=\"page\" href=\"#\">Profile</a>\r\n"
				+ "  </li>\r\n"
				+ "  <li class=\"nav-item\">\r\n"
				+ "    <a class=\"nav-link text-white\" href=\"#\">Add admin</a>\r\n"
				+ "  </li>\r\n"
				+ "  <li class=\"nav-item\">\r\n"
				+ "    <a class=\"nav-link text-white\" href=\"#\">Log out</a>\r\n"
				+ "  </li>\r\n"
				+ "</ul></div>\r\n"
				+ "\r\n");  
		
	   //Student Details printing
		
		out.print("<div class=\"container-fluid py-5 \">\r\n"
				+ "    <div class=\"hd text-center \">\r\n"
				+ "     <h2>STUDENT DETAILS</h2>\r\n"
				+ "    </div>\r\n"
				+ "    <div class=\"stuDet py-4\">");
	    File f2 = new File("D:/III Year Project/DSAProject/studentDetails.txt");
		TreeMap<String, LinkedHashMap<String, String>> li=null;
		FileInputStream fis2 = new FileInputStream(f2);
		try {
		ObjectInputStream ois2 = new ObjectInputStream(fis2);
		try {
			li = (TreeMap<String, LinkedHashMap<String, String>>) ois2
					.readObject();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
		catch(IOException e) 
		{}
		//table 
		out.print("<table class=\"table\">\r\n"
				+ "  <thead class=\"text-center\">\r\n"
				+ "    <tr>\r\n"
				+ "      <th scope=\"col\">S.No</th>\r\n"
				+ "      <th scope=\"col\">ROLL NO</th>\r\n"
				+ "        <th scope=\"col\">NAME</th>\r\n"
				+ "        <th scope=\"col\">EMAIL</th>\r\n"
				+ "      <th scope=\"col\">YEAR</th>\r\n"
				+ "      <th scope=\"col\">DEGREE</th>\r\n"
				+ "       <th scope=\"col\">DEPARTMENT</th>\r\n"
				+ "       <th scope=\"col\">DOB</th>\r\n"
				+ "      <th scope=\"col\">ADDRESS</th>\r\n"
				+ "       <th scope=\"col\">MOBILE NUM</th>\r\n"
				+ "       <th scope=\"col\">BLOOD GROUP</th>\r\n"
				+ "       <th scope=\"col\">ACTION</th>\r\n"
				+ "    </tr>\r\n"
				+ "  </thead>\r\n"
				+ "  <tbody class=\"text-center\">");
		if(li==null)
		{
			out.print("<tr>---- NO DATA TO DISPLAY---</tr> </tbody>\r\n"
					+ "    	    </table> ");
		}
		else
		{
			int count=0;
			  String id ="Id";
			  StudentInfo student = null;
	          for(Map.Entry e:li.entrySet())
		  	  {
	        	  count++;
	        	  student = Admin.getStudent((LinkedHashMap<String, String>)e.getValue());
	        	  out.print("<tr>\r\n"
	        	  		+ "	<td>"+count+"</td><td>"+e.getKey()+"</td>");
	        	  
	        	  
	        	 
	        	  student.setRollNo((String)e.getKey());
	        	for(Map.Entry e1: ((LinkedHashMap<String, String>) e.getValue()).entrySet())
	  			{
	        		  out.print("<td>"+e1.getValue()+"</td>");
	  			}
	        	 //System.out.println(student.getStu_name());
	        	//edit details icon
	        	out.print(" <td>"
	        			+ "  <button class=\"btn btn-primary\" type=\"button\" data-bs-toggle=\"modal\" data-bs-target=\"#editStudent"+student.getRollNo()+"\">\r\n"
                         +"Edit"
	        			+ "  </button>"
	        			+ "    <div class=\"myModal modal fade\" id=\"editStudent"+student.getRollNo()+"\" data-bs-backdrop=\"static\" data-bs-keyboard=\"false\" tabindex=\"-1\" aria-labelledby=\"editStudent"+student.getRollNo()+"abel\" aria-hidden=\"true\">\r\n"
	        					+ "<div class=\"modal-dialog modal-dialog-scrollable \" >\r\n"
	        					+ "          <div class=\"modal-content\">\r\n"
	        					+ "            <div class=\"modal-header \">\r\n"
	        					+ "              <h5 class=\"modal-title \" id=\"exampleModalLabel\">Edit Details </h5>\r\n"
	        					+ "              <button type=\"button\" class=\"btn-close\" data-bs-dismiss=\"modal\" aria-label=\"Close\"></button>\r\n"
	        					+ "            </div>\r\n"
	        					+ "            <div class=\"modal-body\">\r\n"
	        					+ "                \r\n"
	        					+ "                <form id=\"editStudent\" action=\"AdminAddStudent\">\r\n"
	        					+ "\r\n"
	        					+"                   <div class=\"row mb-3\">\r\n"
	        					+"                    <input type=\"hidden\" id=\"formName\" name=\"formName\" value=\"editStudent\"></div>"
	        					+ "                  <div class=\"row mb-3\">\r\n"
	        					+ "                    <label for=\"rollno\" class=\"col-sm-4 col-form-label\">Roll No:</label>\r\n"
	        					+ "                    <div class=\"col-sm-8\">\r\n"
	        					+ "                    <input  class=\"form-control\" id=\"stu_id\" name =\"stu_id\"  value="+student.getRollNo()+">\r\n"
	        					+ "                  </div>\r\n"
	        					+ "                  </div>\r\n"
	        					+ "\r\n"
	        					+ "                  <div class=\"row mb-3\">\r\n"
	        					+ "                    <label for=\"username\" class=\"col-sm-4 col-form-label\">Name:</label>\r\n"
	        					+ "                    <div class=\"col-sm-8\">\r\n"
	        					+ "                      <input type=\"text\" class=\"form-control\"id=\"stu_name\" name=\"stu_name\" value="+student.getStu_name()+">\r\n"
	        					+ "                    </div>\r\n"
	        					+ "                  </div>\r\n"
	        					+ "                  \r\n"
	        					+ "                  <div class=\"row mb-3\">\r\n"
	        					+ "                    <label for=\"mail\" class=\"col-sm-4 col-form-label\">Email:</label>\r\n"
	        					+ "                    <div class=\"col-sm-8\">\r\n"
	        					+ "                      <input  class=\"form-control\"type=\"email\" id=\"stu_email\" name=\"stu_email\" value="+student.getStu_email()+">\r\n"
	        					+ "                    </div>\r\n"
	        					+ "                  </div>\r\n"
	        					+ "\r\n"
	        					+ "                   <div class=\"row mb-3\">\r\n"
	        					+ "                    <label for=\"dob\" class=\"col-sm-4 col-form-label\">Date Of Birth:</label>\r\n"
	        					+ "                      <div class=\"col-sm-8\">\r\n"
	        					+ "                        <input class=\"form-control\"type=\"date\" id=\"dob\" name=\"dob\" value="+student.getDob()+">\r\n"
	        					+ "                      </div>\r\n"
	        					+ "                  </div>\r\n"
	        					+ "\r\n"
	        					+ "                  <div class=\"row mb-3\">\r\n"
	        					+ "                    <label for=\"bloodgroup\" class=\"col-sm-4 col-form-label\">BloodGroup:</label>\r\n"
	        					+ "                      <div class=\"col-sm-8\">\r\n"
	        					+ "                        <input class=\"form-control\"type=\"text\" id=\"bloodgroup\" name=\"bloodgroup\" value="+student.getBloodgroup()+">\r\n"
	        					+ "                      </div>\r\n"
	        					+ "                  </div>\r\n"
	        					+ "\r\n"
	        					+ "            <div class=\"row mb-3\">\r\n"
	        					+ "              <label for=\"address\" class=\"col-sm-4 col-form-label\">Address:</label>\r\n"
	        					+ "              <div class=\"col-sm-8\">\r\n"
	        					+ "                <input class=\"form-control\" type=\"text\" id=\"address\" name=\"address\"  value="+student.getAddress()+">\r\n"
	        					+ "              </div>\r\n"
	        					+ "            </div>\r\n"
	        					+ "\r\n"
	        					+ "            <div class=\"row mb-3\">\r\n"
	        					+ "              <label for=\"mobile\"class=\"col-sm-4 col-form-label\">Mobile Number:</label>\r\n"
	        					+ "              <div class=\"col-sm-8\">\r\n"
	        					+ "                <input class=\"form-control\" type=\"tel\" id=\"mobile\" name=\"mobile\"  value="+student.getMobileNum()+">\r\n"
	        					+ "              </div>\r\n"
	        					+ "            </div>\r\n"
	        					+ "\r\n"
	        					+ "            <div class=\"row mb-3\">\r\n"
	        					+ "              <label for=\"year\"class=\"col-sm-4 col-form-label\">Year:</label>\r\n"
	        					+ "              <div class=\"col-sm-8\">\r\n"
	        					+ "                <select id=\"year\" name=\"year\"  class=\"form-control\" >\r\n"
	    	        		    +"                   <option selected>"+student.getYear()+"</option>"
	        					+ "                  <option value=\"I\">I</option>\r\n"
	        					+ "                  <option value=\"II\">Ii</option>\r\n"
	        					+ "                  <option value=\"III\">III</option>\r\n"
	        					+ "                  <option value=\"IV\">IV</option>\r\n"
	        					+ "                  </select>\r\n"
	        					+ "              </div>\r\n"
	        					+ "            </div>\r\n"
	        					+ "\r\n"
	        					+ "\r\n"
	        					+ "\r\n"
	        					+ "\r\n"
	        					+ "            <div class=\"row mb-3\">\r\n"
	        					+ "              <label for=\"degree\"class=\"col-sm-4 col-form-label\">Degree:</label>\r\n"
	        					+ "              <div class=\"col-sm-8\">\r\n"
	        					+ "                <select class=\"form-control\" id=\"degree\" name=\"degree\" >\r\n"
	    	        		    +"                   <option selected>"+student.getDegree()+"</option>"
	        					+ "                  <option value=\"BE\">BE</option>\r\n"
	        					+ "                  <option value=\"BTech\">BTech</option>\r\n"
	        					+ "                  <option value=\"MBA\">MBA</option>\r\n"
	        					+ "                </select>\r\n"
	        					+ "              </div>\r\n"
	        					+ "            </div>\r\n"
	        					+ "\r\n"
	        					+ "            <div class=\"row mb-3\">\r\n"
	        					+ "              <label for=\"department\"class=\"col-sm-4 col-form-label\">Department:</label>\r\n"
	        					+ "              <div class=\"col-sm-8\">\r\n"
	        					+ "                <select class=\"form-control\" id=\"department\" name=\"department\" >\r\n"
	        					+"                   <option selected>"+student.getDepartment()+"</option>"
	        					+ "                  <option value=\"CSE\">CSE</option>\r\n"
	        					+ "                  <option value=\"CS\">CS</option>\r\n"
	        					+ "                  <option value=\"CST\">CST</option>\r\n"
	        					+ "                  <option value=\"IT\">IT</option>\r\n"
	        					+ "                  <option value=\"ECE\">ECE</option>\r\n"
	        					+ "                  <option value=\"EEE\">EEE</option>\r\n"
	        					+ "                  <option value=\"MECH\">MECH</option>\r\n"
	        					+ "                </select>\r\n"
	        					+ "              </div>\r\n"
	        					+ "            </div>\r\n"
	        					+ "            <div class=\"row mb-3 text-center\">\r\n"
	        					+ "           <button type=\"submit\" class=\"btn btn-primary\"  >Save Changes</button>\r\n"
	        					+ "          </div>     \r\n"
	        					+ "          </form>\r\n"
	        					+ "                    </div>\r\n"
	        					+ "                   <div class=\"modal-footer\">\r\n"
	        					+ "              <button type=\"button\" class=\"btn btn-secondary\" data-bs-dismiss=\"modal\">Discard Changes</button>\r\n"
	        					+ "              \r\n"
	        					+ "            </div>\r\n"
	        					+ "          </div>\r\n"
	        					+ "        </div>"
	        			
	        			+ "      </div>"
	        			
	        			+ "</td></tr>");
	        	student=null;
		  	  }
	          
		}
		//closing table
		out.print("</tbody>\r\n"
				+ "    	    </table>    </div>\r\n"
				+ "</div>");
		
		
		//add student button
		out.print(" <div class=\"container\">\r\n"
				+ "\r\n"
				+ "        <div class=\"a\">\r\n"
				+ "           \r\n"
				+ "            <div class=\"row row-cols-2 row-cols-md-3 \">\r\n"
				+ "                <div class=\"col\">\r\n"
				+ "\r\n"
				+ "                  <div class=\"card\">\r\n<button class=\"btn btn-primary\" type=\"button\" data-bs-toggle=\"modal\" data-bs-target=\"#addStudent\" >"
				+ "                    <div class=\"card-body\">\r\n"
				+ "                      <h5 class=\"card-title\">ADD STUDENT</h5>\r\n"
				+ "                     </div> </button>\r\n"
				+ "                  </div>\r\n"
				+ "                </div>\r\n"
				+ "\r\n"
				+ "                <div class=\"col\">\r\n"
				+ "                  <div class=\"card\">\r\n <button class=\"btn btn-primary\" type=\"button\" data-bs-toggle=\"modal\" data-bs-target=\"#editStudent\"> "
				+ "                    <div class=\"card-body\">\r\n"
				+ "                      <h5 class=\"card-title\">EDIT STUDENT DETAILS</h5>\r\n"
				+ "                     </div></button>\r\n"
				+ "                  </div>\r\n"
				+ "                </div>\r\n"
				+ "              \r\n"
				+ "                <div class=\"col\">\r\n"
				+ "                  <div class=\"card\">\r\n <button class=\"btn btn-primary\" type=\"button\" data-bs-toggle=\"modal\" data-bs-target=\"#removeStudent\" >"
				+ "                   <div class=\"card-body\">\r\n"
				+ "                      <h5 class=\"card-title\">REMOVE STUDENT</h5>\r\n"
				+ "                      </div> </button>\r\n"
				+ "                  </div>\r\n"
				+ "                </div>\r\n"
				+ "              </div>\r\n"
				+ "       </div>\r\n"
				+ "    </div> ");
		
		
		//Modals for add,edit,delete
		
		//add student modal
		out.print("  <div class=\"modal fade\" id=\"addStudent\" data-bs-backdrop=\"static\" data-bs-keyboard=\"false\" tabindex=\"-1\" aria-labelledby=\"addStudentabel\" aria-hidden=\"true\">\r\n"
				+ "        <div class=\"modal-dialog modal-dialog-scrollable modal-dialog modal-lg\" >\r\n"
				+ "          <div class=\"modal-content\">\r\n"
				+ "            <div class=\"modal-header text-center \">\r\n"
				+ "              <h5 class=\"modal-title\" id=\"exampleModalLabel\">ADD NEW STUDENT</h5>\r\n"
				+ "              <button type=\"button\" class=\"btn-close\" data-bs-dismiss=\"modal\" aria-label=\"Close\"></button>\r\n"
				+ "            </div>\r\n"
				+ "            <div class=\"modal-body\">\r\n"
				+ "                \r\n"
				+ "                <form id=\"addStudentForm\"  action=\"AdminAddStudent\">\r\n"
				+ "                   <fieldset>\r\n"
				+ "                    <legend>Personal Info</legend>\r\n"
				+ "\r\n"
				+ "                    <div class=\"row\">\r\n <div class=\"col\"> \r\n"
				+ " <input type=\"hidden\" id=\"formName\" name=\"formName\" value=\"addStudent\">"

				+ "                    </div>"
				+ "                        <div class=\"col\">\r\n"
				+ "                            <label for=\"stu_name\">Name:</label>\r\n"
				+ "                            <input type=\"text\" id=\"username\" class=\"form-control\" name=\"stu_name\" placeholder=\"Enter your Name\">\r\n"
				+ "                        </div>\r\n"
				+ "                        <div class=\"col\">\r\n"
				+ "                            <label for=\"email\">Email:</label>\r\n"
				+ "                            <input type=\"email\" id=\"mail\"  class=\"form-control\"name=\"stu_email\" placeholder=\"Enter your Email-Id\">\r\n"
				+ "                        </div>\r\n"
				+ "                      </div>\r\n"
				+ "                      <div class=\"row py-3\">\r\n"
				+ "                        <div class=\"col\">\r\n"
				+ "                            <label for=\"dob\">Date Of Birth:</label>\r\n"
				+ "                            <input type=\"date\" id=\"dob\"  class=\"form-control \"name=\"dob\">\r\n"
				+ "                         </div>\r\n"
				+ "                      </div>\r\n"
				+ "                      <div class=\"row py-3\">\r\n"
				+ "                        <div class=\"col\">\r\n"
				+ "                            <label for=\"bloodgroup\">BloodGroup</label>\r\n"
				+ "                            <input type=\"text\" id=\"bloodgroup\" class=\"form-control\"name=\"bloodgroup\" placeholder=\"Exa:O+\">\r\n"
				+ "                        </div>\r\n"
				+ "                        <div class=\"col\">\r\n"
				+ "                            <label for=\"mobile\">Mobile Number:</label>\r\n"
				+ "                            <input type=\"tel\"class=\"form-control\" id=\"mobile\" name=\"mobile\">\r\n"
				+ "                        </div>\r\n"
				+ "                      </div>\r\n"
				+ "                      <div class=\"row\">\r\n"
				+ "                        <div class=\"col\">\r\n"
				+ "                            <label for=\"address\">Address:</label>\r\n"
				+ "                            <input type=\"text\" id=\"address\" name=\"address\" class=\"form-control\">\r\n"
				+ "                        </div>\r\n"
				+ "                      </div>\r\n"
				+ "                    </fieldset>\r\n"
				+ "                      <fieldset>\r\n"
				+ "                        <legend>Educational Details</legend>\r\n"
				+ "                           \r\n <div class=\"row\">\r\n"
				+ "                            <div class=\"col\">\r\n"
				+ "                                <label for=\"year\">Year:</label>\r\n"
				+ "                                <select id=\"year\" name=\"year\">\r\n"
				+ "                                <option value=\"\">--select--</option>\r\n"
				+ "                                <option value=\"I\">I</option>\r\n"
				+ "                                <option value=\"II\">Ii</option>\r\n"
				+ "                                <option value=\"III\">III</option>\r\n"
				+ "                                <option value=\"IV\">IV</option>\r\n"
				+ "                                </select>\r\n"
				+ "                            </div>\r\n"
				+ "                           </div>"
				+ "                        <div class=\"row\">\r\n"
				+ "                            <div class=\"col\">\r\n"
				+ "                                <label for=\"degree\">Degree:</label>\r\n"
				+ "                                <select id=\"degree\" name=\"degree\" class=\"form-control\">\r\n"
				+ "                                  <option value=\"\">--Select--</option>\r\n"
				+ "                                  <option value=\"BE\">BE</option>\r\n"
				+ "                                  <option value=\"BTech\">BTech</option>\r\n"
				+ "                                  <option value=\"MBA\">MBA</option>\r\n"
				+ "                                </select>   \r\n"
				+ "                            </div>\r\n"
				+ "                     \r\n"
				+ "                            <div class=\"col\">\r\n"
				+ "                               \r\n"
				+ "                                <label for=\"department\">Department:</label>\r\n"
				+ "                                <select id=\"department\" name=\"department\" class=\"form-control\">\r\n"
				+ "                                  <option value=\"\">--Select--</option>\r\n"
				+ "                                  <option value=\"CSE\">CSE</option>\r\n"
				+ "                                  <option value=\"CS\">CS</option>\r\n"
				+ "                                  <option value=\"CST\">CST</option>\r\n"
				+ "                                  <option value=\"IT\">IT</option>\r\n"
				+ "                                  <option value=\"ECE\">ECE</option>\r\n"
				+ "                                  <option value=\"EEE\">EEE</option>\r\n"
				+ "                                  <option value=\"MECH\">MECH</option>\r\n"
				+ "                                </select></div>\r\n"
				+ "                          </div>\r\n"
				+ "	<button type=\"submit\" class=\"btn btn-primary\">Add Student</button>\n"
				+ "                       </form>\r\n"
				+ "                    </div>\r\n"
				+ "                   <div class=\"modal-footer\">\r\n"
				+ "              <button type=\"button\" class=\"btn btn-secondary\" data-bs-dismiss=\"modal\">Close</button>\r\n"

				+ "            </div>\r\n"
				+ "          </div>\r\n"
				+ "        </div>\r\n"
				+ "      </div>");
		//remove student modal
		
		out.print( "    <div class=\"modal fade\" id=\"removeStudent\" data-bs-backdrop=\"static\" data-bs-keyboard=\"false\" tabindex=\"-1\" aria-labelledby=\"editStudentabel\" aria-hidden=\"true\">\r\n"
				+ "        <div class=\"modal-dialog modal-dialog-scrollable \" >\r\n"
				+ "          <div class=\"modal-content\">\r\n"
				+ "            <div class=\"modal-header \">\r\n"
				+ "              <h5 class=\"modal-title \" id=\"exampleModalLabel\">REMOVE STUDENT</h5>\r\n"
				+ "              <button type=\"button\" class=\"btn-close\" data-bs-dismiss=\"modal\" aria-label=\"Close\"></button>\r\n"
				+ "            </div>\r\n"
				+ "            <div class=\"modal-body\">\r\n"
				+ "                \r\n"
				+ "                <form id=\"removeStudent\" action=\"AdminAddStudent\">\r\n"
				+ "                 <div class=\"row\">\r\n <div class=\"col\">\r\n"
				+ "                        <input type=\"hidden\" id=\"formName\" name=\"formName\" value=\"removeStudent\">\r\n"
				+ "                    </div>"
				+ "                    <div class=\"col\">\r\n"
				+ "                        <label for=\"stu_id\" >Enter Student Id:</label>\r\n"
				+ "                        <input type=\"text\" id=\"stu_di\" name=\"stu_id\" class=\"form-control\" autofocus>\r\n"
				+ "                    </div>\r\n"
				+ "\r\n"
				+ "                 </div>\r\n"
				+ "\r\n"
				+ "                          <button type=\"submit\" class=\"btn btn-primary\" >RemoveStudent</button>\r\n"
				+ "                </form>\r\n"
				+ "                    </div>\r\n"
				+ "                   <div class=\"modal-footer\">\r\n"
				+ "              <button type=\"button\" class=\"btn btn-secondary\" data-bs-dismiss=\"modal\">Close</button>\r\n"
				+ "              \r\n"
				+ "            </div>\r\n"
				+ "          </div>\r\n"
				+ "        </div>\r\n"
				+ "      </div>");
		
		//edit student details modal
		
   
		
		
		
		out.print(" ");
		out.print("    </body>\r\n"
				+ "</html>");
	  
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
