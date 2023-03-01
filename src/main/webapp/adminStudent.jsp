<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="java.util.*" %>
<%@page import="java.io.*" %>
<%@page import="com.admin.Admin" %>
<%@page import="com.adminServlet.AdminAddStudent" %>
<%@page import="com.student.StudentInfo" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>SRP</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js" integrity="sha384-IQsoLXl5PILFhosVNubq5LC7Qb9DXgDA9itQ8Zj3iwWAwPtgFTxbJ8NT4GN1R8p" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.min.js" integrity="sha384-cVKIPhGWiC2Al4uLWgxfKTRIcfu0JTxREQDz/bgldoEyl4H0zUF0QKbrJ0EcQF" crossorigin="anonymous"></script>
</head>
<body>
<% LinkedHashMap<String,String> admin = (LinkedHashMap<String,String>)session.getAttribute("admin");
  session.setAttribute("admin",session.getAttribute("admin"));
 %>
<ul class="nav justify-content-end bg-primary">
  <li class="nav-item">
    <button type="button" class="btn btn-primary"  aria-current="page" data-bs-toggle="modal" data-bs-target="#adminProfile">Profile</button>
  </li>
  <!-- <li class="nav-item">
    <button type="button" class="btn btn-primary"  aria-current="page" data-bs-toggle="modal" data-bs-target="#addAdmin">ADD ADMIN</button>
   </li> -->
  <li class="nav-item">
    <a class="nav-link text-white" href="adminLogin.html">Log out</a>
  </li>
</ul>
<!--  Modals -->
<div class="modal fade" id="adminProfile" tabindex="-1" aria-labelledby="adminProfileLabel" aria-hidden="true">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="adminProfileLabel">Profile</h5>
        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
      </div>
      <div class="modal-body">
        <form>
       
  
  <div class="row mb-3">
    <label for="inputEmail3" class="col-sm-6 col-form-label">NAME</label>
    <div class="col-sm-6">
     <%=admin.get("Name") %>
    </div>
  </div>
  <div class="row mb-3">
    <label for="inputEmail3" class="col-sm-6 col-form-label">DOB</label>
    <div class="col-sm-6">
     <%=admin.get("Dob") %>
    </div>
  </div>
  <div class="row mb-3">
    <label for="inputEmail3" class="col-sm-6 col-form-label">EMAIL</label>
    <div class="col-sm-6">
     <%=admin.get("Email") %>
    </div>
  </div>
  <div class="row mb-3">
    <label for="inputEmail3" class="col-sm-6 col-form-label">ADDRESS:</label>
    <div class="col-sm-6">
     <%=admin.get("Address") %>
    </div>
  </div>
   <div class="row mb-3">
    <label for="inputEmail3" class="col-sm-6 col-form-label">YEAR OF JOINING:</label>
    <div class="col-sm-6">
     <%=admin.get("YearOfJoin") %>
    </div>
  </div>

</form>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
        <!--   <button type="button" class="btn btn-primary">Save changes</button> -->
      </div>
    </div>
  </div>
</div>
				 <div class="container-fluid py-5 ">
				     <div class="hd text-center ">
				      <h2>STUDENT DETAILS</h2>
				     </div>
				     <div class="stuDet py-4">
				     <%
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
						%>
				<table class="table">
				   <thead class="text-center">
				     <tr>
				       <th scope="col">S.No</th>
				       <th scope="col">ROLL NO</th>
				         <th scope="col">NAME</th>
				         <th scope="col">EMAIL</th>
				       <th scope="col">YEAR</th>
				       <th scope="col">DEGREE</th>
				        <th scope="col">DEPARTMENT</th>
				        <th scope="col">DOB</th>
				       <th scope="col">ADDRESS</th>
				        <th scope="col">MOBILE NUM</th>
				        <th scope="col">BLOOD GROUP</th>
				        <th scope="col">ACTION</th>
				     </tr>
				   </thead>
				   <tbody class="text-center">
				   <% 
				     if(li==null)
					  { %>
						<tr>---- NO DATA TO DISPLAY---</tr> </tbody>
						</table> 
					 <% }
					else
					{
						int count=0;
						  String id ="Id";
						  StudentInfo student = null;
				          for(Map.Entry e:li.entrySet())
					  	  {
				        	  count++;
				        	  student = Admin.getStudent((LinkedHashMap<String, String>)e.getValue());
					  	  
                     %>
                     <tr>
	        	  	 <td><% out.print(count); %></td>
	        	  	 <td><% out.print(e.getKey()); %></td>
	        	  	 <% 
	        	  	 student.setRollNo((String)e.getKey());
	        	     for(Map.Entry e1: ((LinkedHashMap<String, String>) e.getValue()).entrySet())
	  			       { 
	  			       %>
	  			        <td>  <% out.print(e1.getValue()); %> </td>
	  			     <% } %>  
	  			     <td>
	        			   <button class="btn btn-primary" type="button" data-bs-toggle="modal" data-bs-target="#editStudent<%out.print(student.getRollNo()); %>">
                         Edit
	        			   </button>
	        			     <div class="myModal modal fade" id="editStudent<%out.print(student.getRollNo());%>"data-bs-backdrop="static" data-bs-keyboard="false" tabindex="-1" aria-labelledby="editStudent"student.getRollNo()"abel" aria-hidden="true">
	        					 <div class="modal-dialog modal-dialog-scrollable " >
	        					           <div class="modal-content">
	        					             <div class="modal-header ">
	        					               <h5 class="modal-title " id="exampleModalLabel">Edit Details </h5>
	        					               <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
	        					             </div>
	        					             <div class="modal-body">
	        					                 
	        					                 <form id="editStudent" action="AdminAddStudent">
	        					 
	        					                   <div class="row mb-3">
	        					                    <input type="hidden" id="formName" name="formName" value="editStudent"></div>
	        					                   <div class="row mb-3">
	        					                     <label for="rollno" class="col-sm-4 col-form-label">Roll No:</label>
	        					                     <div class="col-sm-8">
	        					                     <input  class="form-control" id="stu_id" name ="stu_id"  value="<% out.print(student.getRollNo());%>">
	        					                   </div>
	        					                   </div>
	        					 
	        					                   <div class="row mb-3">
	        					                     <label for="username" class="col-sm-4 col-form-label">Name:</label>  
	        					                     <div class="col-sm-8">
	        					                       <input type="text" class="form-control"id="stu_name" name="stu_name" value="<% out.print(student.getStu_name());%>">  
	        					                     </div>
	        					                   </div>
	        					                   
	        					                   <div class="row mb-3">
	        					                     <label for="mail" class="col-sm-4 col-form-label">Email:</label>
	        					                     <div class="col-sm-8">
	        					                       <input  class="form-control"type="email" id="stu_email" name="stu_email" value=" <% out.print(student.getStu_email());%>">
	        					                     </div>
	        					                   </div>
	        					 
	        					                    <div class="row mb-3">
	        					                     <label for="dob" class="col-sm-4 col-form-label">Date Of Birth:</label>
	        					                       <div class="col-sm-8">
	        					                         <input class="form-control"type="date" id="dob" name="dob" value="<%out.print(student.getDob());%>">
	        					                       </div>
	        					                   </div>
	        					 
	        					                   <div class="row mb-3">
	        					                     <label for="bloodgroup" class="col-sm-4 col-form-label">BloodGroup:</label>
	        					                       <div class="col-sm-8">
	        					                         <input class="form-control"type="text" id="bloodgroup" name="bloodgroup" value=" <% out.print(student.getBloodgroup());%>">
	        					                       </div>
	        					                   </div>
	        					 
	        					             <div class="row mb-3">
	        					               <label for="address" class="col-sm-4 col-form-label">Address:</label>
	        					               <div class="col-sm-8">
	        					                 <input class="form-control" type="text" id="address" name="address"  value="<% out.print(student.getAddress());%>">
	        					               </div>
	        					             </div>
	        					 
	        					             <div class="row mb-3">
	        					               <label for="mobile"class="col-sm-4 col-form-label">Mobile Number:</label>
	        					               <div class="col-sm-8">
	        					                 <input class="form-control" type="tel" id="mobile" name="mobile"  value="<% out.print(student.getMobileNum());%>">
	        					               </div>
	        					             </div>
	        					 
	        					             <div class="row mb-3">
	        					               <label for="year"class="col-sm-4 col-form-label">Year:</label>
	        					               <div class="col-sm-8">
	        					                 <select id="year" name="year"  class="form-control" >
	    	        		                      <option selected> <% out.print(student.getYear());%></option>
	        					                   <option value="I">I</option>
	        					                  <option value="II">II</option>
	        					                   <option value="III">III</option>
	        					                   <option value="IV">IV</option>
	        					                   </select>
	        					               </div>
	        					             </div>
	        					 
	        					 
	        					 
	        					 
	        					             <div class="row mb-3">
	        					               <label for="degree"class="col-sm-4 col-form-label">Degree:</label>
	        					               <div class="col-sm-8">
	        					                 <select class="form-control" id="degree" name="degree" >
	    	        		                       <option selected><% out.print(student.getDegree());%></option>
	        					                   <option value="BE">BE</option>
	        					                   <option value="BTech">BTech</option>
	        					                   <option value="MBA">MBA</option>
	        					                 </select>
	        					               </div>
	        					             </div>
	        					 
	        					             <div class="row mb-3">
	        					               <label for="department"class="col-sm-4 col-form-label">Department:</label>
	        					               <div class="col-sm-8">
	        					                <select class="form-control" id="department" name="department" >
	        					                   <option selected><% out.print(student.getDepartment());%></option>
	        					                  <option value="CSE">CSE</option>
	        					                   <option value="CS">CS</option>
	        					                   <option value="CST">CST</option>
	        					                   <option value="IT">IT</option>
	        					                   <option value="ECE">ECE</option>
	        					                   <option value="EEE">EEE</option>
	        					                   <option value="MECH">MECH</option>
	        					                 </select>
	        					               </div>
	        					             </div>
	        					             <div class="row mb-3 text-center">
	        					            <button type="submit" class="btn btn-primary"  >Save Changes</button>
	        					           </div>     
	        					           </form>
	        					                     </div>
	        					                    <div class="modal-footer">
	        					               <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Discard Changes</button>
	        					               
	        					             </div>
	        					           </div>
	        					         </div>
	        					         </div>
	        			
	        			       </td></tr>
	        			       <%student=null;
	        					         }
				          
				             	} %>
				             	<!--   closing table -->
				             	</tbody>
				    	    </table>    
				    	</div>
				 </div>
				  <div class="container">
				 
				         <div class="a">
				            
				             <div class="row row-cols-2 row-cols-md-3 ">
				                 <div class="col">
				 
				                   <div class="card"><button class="btn btn-primary" type="button" data-bs-toggle="modal" data-bs-target="#addStudent" >
				                     <div class="card-body">
				                       <h5 class="card-title">ADD STUDENT</h5>
				                      </div> </button>
				                   </div>
				               </div>
				 
				            <!--     <div class="col">
				                   <div class="card"><button class="btn btn-primary" type="button" data-bs-toggle="modal" data-bs-target="#editStudent"> 
				                     <div class="card-body">
				                       <h5 class="card-title">EDIT STUDENT DETAILS</h5>
				                      </div></button>
				                   </div>
				                 </div>  --> 
				               
				                 <div class="col">
				                   <div class="card"> <button class="btn btn-primary" type="button" data-bs-toggle="modal" data-bs-target="#removeStudent" >
				                    <div class="card-body">
				                       <h5 class="card-title">REMOVE STUDENT</h5>
				                       </div> </button>
				                   </div>
				                 </div>
				               </div>
				        </div>
				     </div> 
		
		
		

	      <div class="modal fade" id="addStudent" data-bs-backdrop="static" data-bs-keyboard="false" tabindex="-1" aria-labelledby="addStudentabel" aria-hidden="true">
				         <div class="modal-dialog modal-dialog-scrollable modal-dialog modal-lg" >
				           <div class="modal-content">
				             <div class="modal-header text-center ">
				               <h5 class="modal-title" id="exampleModalLabel">ADD NEW STUDENT</h5>
				               <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
				             </div>
				             <div class="modal-body">
				                 
				                 <form id="addStudentForm"  action="AdminAddStudent">
				                    <fieldset>
				                     <legend>Personal Info</legend>
				 
				                     <div class="row"><div class="col" style="display:none;"> 
				   <input type="hidden" id="formName" name="formName" value="addStudent" >

				                     </div>
				                         <div class="col">
				                             <label for="stu_name">Name:</label>
				                             <input type="text" id="username" class="form-control" name="stu_name" placeholder="Enter your Name">
				                         </div>
				                         <div class="col">
				                             <label for="email">Email:</label>
				                             <input type="email" id="mail"  class="form-control"name="stu_email" placeholder="Enter your Email-Id">
				                         </div>
				                       </div>
				                       <div class="row py-3">
				                         <div class="col">
				                             <label for="dob">Date Of Birth:</label>
				                             <input type="date" id="dob"  class="form-control "name="dob">
				                          </div>
				                       </div>
				                       <div class="row py-3">
				                         <div class="col">
				                             <label for="bloodgroup">BloodGroup</label>
				                             <input type="text" id="bloodgroup" class="form-control"name="bloodgroup" placeholder="Exa:O">
				                         </div>
				                         <div class="col">
				                             <label for="mobile">Mobile Number:</label>
				                            <input type="tel"class="form-control" id="mobile" name="mobile">
				                         </div>
				                       </div>
				                       <div class="row">
				                         <div class="col">
				                             <label for="address">Address:</label>
				                             <input type="text" id="address" name="address" class="form-control">
				                         </div>
				                       </div>
				                     </fieldset>
				                       <fieldset>
				                         <legend>Educational Details</legend>
				                             <div class="row">
				                             <div class="col">
				                                 <label for="year">Year:</label>
				                                 <select id="year" name="year">
				                                 <option value="">--select--</option>
				                                 <option value="I">I</option>
				                                 <option value="II">II</option>
				                                <option value="III">III</option>
				                                <option value="IV">IV</option>
				                                 </select>
				                             </div>
				                            </div>
				                         <div class="row">
				                             <div class="col">
				                                 <label for="degree">Degree:</label>
				                                 <select id="degree" name="degree" class="form-control">
				                                   <option value="">--Select--</option>
				                                   <option value="BE">BE</option>
				                                   <option value="BTech">BTech</option>
				                                   <option value="MBA">MBA</option>
				                                 </select>   
				                             </div>
				                      
				                             <div class="col">
				                                
				                                 <label for="department">Department:</label>
				                                 <select id="department" name="department" class="form-control">
				                                   <option value="">--Select--</option>
				                                   <option value="CSE">CSE</option>
				                                   <option value="CS">CS</option>
				                                   <option value="CST">CST</option>
				                                   <option value="IT">IT</option>
				                                   <option value="ECE">ECE</option>
				                                   <option value="EEE">EEE</option>
				                                   <option value="MECH">MECH</option>
				                                 </select></div>
				                           </div>
				 	<button type="submit" class="btn btn-primary">Add Student</button>
				                        </form>
				                     </div>
				                    <div class="modal-footer">
				               <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>

				             </div>
				           </div>
				         </div>
				       </div>
		
		
	    <div class="modal fade" id="removeStudent" data-bs-backdrop="static" data-bs-keyboard="false" tabindex="-1" aria-labelledby="editStudentabel" aria-hidden="true">
				         <div class="modal-dialog modal-dialog-scrollable " >
				         <div class="modal-content">
				             <div class="modal-header ">
				               <h5 class="modal-title " id="exampleModalLabel">REMOVE STUDENT</h5>
				               <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
				             </div>
				             <div class="modal-body">
				                 
				                 <form id="removeStudent" action="AdminAddStudent">
				                  <div class="row"> <div class="col" style="display:none;">
				                         <input type="hidden" id="formName" name="formName" value="removeStudent">
				                     </div>
				                     <div class="col">
				                         <label for="stu_id" >Enter Student Id:</label>
				                         <input type="text" id="stu_di" name="stu_id" class="form-control" autofocus>
				                     </div>
				 
				                  </div>
				 
				                           <button type="submit" class="btn btn-primary" >RemoveStudent</button>
				                 </form>
				                     </div>
				                    <div class="modal-footer">
				               <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
				               
				             </div>
				           </div>
				       </div>
				       </div>
	        			
	        			       
	        			       
	        			       
	        			       
	        			       
	        			       
				 
</body>
</html>