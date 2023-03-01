<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="java.util.*" %>
<%@page import="java.io.*" %>
<%@page import="com.admin.Admin" %>
<%@page import="com.faculty.FacultyInfo" %>
<!DOCTYPE html>
<html>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>SRP</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js" integrity="sha384-IQsoLXl5PILFhosVNubq5LC7Qb9DXgDA9itQ8Zj3iwWAwPtgFTxbJ8NT4GN1R8p" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.min.js" integrity="sha384-cVKIPhGWiC2Al4uLWgxfKTRIcfu0JTxREQDz/bgldoEyl4H0zUF0QKbrJ0EcQF" crossorigin="anonymous"></script>
</head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
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
				      <h2>FACULTY DETAILS</h2>
				     </div>
				     <div class="facDet py-4">
				      <%File f2 = new File("D:/III Year Project/DSAProject/FacultyDetails.txt");
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
				       <th scope="col">FACULTY ID</th>
				         <th scope="col">NAME</th>
				         <th scope="col">EMAIL</th>
				        <th scope="col">DOB</th>
				       <th scope="col">ADDRESS</th>
				        <th scope="col">MOBILE NUM</th>
				        <th scope="col">BLOOD GROUP</th>
				        <th scope="col">COURSE</th>
				        <th scope="col">YEAR OF JOIN</th>
				        <th scope="col">DESIGNATION</th>
				        <th scope="col">ACTION</th>
				     </tr>
				   </thead>
				   <tbody class="text-center">
				   <% 
				     if(li==null)
					  { %>
						<tr> <td colspan="12">---- NO DATA TO DISPLAY--- </td></tr> </tbody>
						</table> 
					 <% }
					else
					{
						int count=0;
						  String id ="Id";
						 FacultyInfo faculty = null;
				          for(Map.Entry e:li.entrySet())
					  	  {
				        	  count++;
				        	  faculty =Admin.getFaculty((LinkedHashMap<String, String>)e.getValue());  
                     %>
                      <tr>
	        	  	 <td><% out.print(count); %></td>
	        	  	 <td><% out.print(e.getKey()); %></td>
	        	  	 <% 
	        	  	 faculty.setFacultyId((String)e.getKey());
	        	  	 LinkedHashMap<String,String> facultyDetail = ((LinkedHashMap<String, String>) e.getValue());
	        	     for(Map.Entry e1: facultyDetail.entrySet())
	  			       { 
	  			       %>
	  			        <td>  <% out.print(e1.getValue()); %> </td>
	  			     <% } %>  
	  			     <td>
	  			     <button class="btn btn-primary" type="button" data-bs-toggle="modal" data-bs-target="#editFaculty<%out.print((String)e.getKey()); %>">
                         Edit
	        			   </button>
	        			   <div class="myModal modal fade" id="editFaculty<%out.print((String)e.getKey());%>"data-bs-backdrop="static" data-bs-keyboard="false" tabindex="-1" aria-labelledby="editStudent"student.getRollNo()"abel" aria-hidden="true">
	        					 <div class="modal-dialog modal-dialog-scrollable " >
	        					           <div class="modal-content">
	        					             <div class="modal-header ">
	        					               <h5 class="modal-title " id="exampleModalLabel">Edit Details </h5>
	        					               <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
	        					             </div>
	        					             <div class="modal-body text-start">
	        					                 
	        					            <form id="editFacultyForm"  action="AdminAddFaculty">
                <fieldset>
                 <legend>Personal Info</legend>

                 <div class="row"><div class="col" style="display:none;"> 
                 <input type="hidden" id="formName" name="formName" value="editFaculty" >
                 <input type="hidden" id="faculty_Id" name="faculty_Id" value="<%=(String)e.getKey()%>">

                 </div>
                     <div class="col">
                         <label for="stu_name">Name:</label>
                         <input type="text" id="f_name" class="form-control" name="f_name"  value="<%=facultyDetail.get("f_name") %>">
                     </div>
                     <div class="col">
                         <label for="email">Email:</label>
                         <input type="email" id="f_email"  class="form-control"name="f_email"  value="<%=facultyDetail.get("f_email")%>">
                     </div>
                   </div>
                   <div class="row py-3">
                     <div class="col">
                         <label for="dob">Date Of Birth:</label>
                         <input type="date" id="dob"  class="form-control "name="dob" value="<%=facultyDetail.get("dob") %>">
                      </div>
                   </div>
                   <div class="row py-3">
                     <div class="col">
                         <label for="bloodgroup">BloodGroup</label>
                         <input type="text" id="bloodgroup" class="form-control"name="bloodgroup"  value="<%=facultyDetail.get("bloodgroup")%>">
                     </div>
                     <div class="col">
                         <label for="mobile">Mobile Number:</label>
                        <input type="tel"class="form-control" id="mobileNum" name="mobileNum" value="<%=facultyDetail.get("mobileNum") %>">
                     </div>
                   </div>
                   <div class="row">
                     <div class="col">
                         <label for="address">Address:</label>
                         <input type="text" id="address" name="address" class="form-control" value="<%=facultyDetail.get("address") %>">
                     </div>
                   </div>
                 </fieldset>
                   <fieldset>
                     <legend>Academic Details</legend>
                         <div class="row">
                         <div class="col">
                          <label for="dateJoin">Year of Joining:</label>
                          <input type="text" name="yearJoin" id="yearJoin" class="form-control" value="<%=facultyDetail.get("yearJoin")%>">
                             
                         </div>
                        </div>
                     <div class="row">
                         <div class="col">
                          <label for="course">Course:</label>
                          <input type="text" name="course" id="course" class="form-control" value="<%=facultyDetail.get("course") %>">
                         </div>
                  
                         <div class="col">
                            
                          <label for="designation">Designation:</label>
                          <select id="designation" name="designation" class="form-control">
                              <option value="<%=facultyDetail.get("designation") %>"><%=facultyDetail.get("designation") %></option>
                              <option value="HOD">HOD</option>
                              <option value="Professor">Professor</option>
                              <option value="Assistant-professor">Assistant Professor</option>
                              <option value="Associate-professor">Associate professor</option>
                          </select>    
                        </div>
                       </div>
                         <button type="submit" class="btn btn-primary">Save Changes</button>
                    </form>
	        					                     </div>
	        					                    <div class="modal-footer">
	        					               <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Discard Changes</button>
	        					               
	        					             </div>
	        					           </div>
	        					         </div>
	        					         </div>
	        					         
	  			     </td>
	  			     </tr>
	        			       <%faculty=null;
	        					         }
				          
				             	} %>
				             	<!--   closing table -->
				             	</tbody>
				    	    </table>    
				    	</div>
				 </div>
				  <div class="container">
				 
				         <div class="a">
				            
				             <div class="row row-cols-2 row-cols-md-2 ">
				                 <div class="col">
				 
				                   <div class="card"><button class="btn btn-primary" type="button" data-bs-toggle="modal" data-bs-target="#addFaculty" >
				                     <div class="card-body">
				                       <h5 class="card-title">ADD FACULTY</h5>
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
				                   <div class="card"> <button class="btn btn-primary" type="button" data-bs-toggle="modal" data-bs-target="#removeFaculty" >
				                    <div class="card-body">
				                       <h5 class="card-title">REMOVE FACULTY</h5>
				                       </div> </button>
				                   </div>
				                 </div>
				               </div>
				        </div>
				     </div> 
		
		<!--  Add and delete modals body -->
		 <div class="myModal modal fade" id="addFaculty" data-bs-backdrop="static" data-bs-keyboard="false" tabindex="-1" aria-labelledby="addFacultyabel" aria-hidden="true">
        <div class="modal-dialog modal-dialog-scrollable " >
          <div class="modal-content">
            <div class="modal-header ">
              <h5 class="modal-title " id="exampleModalLabel">ADD FACULTY</h5>
              <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
            </div>
            <div class="modal-body">
              <form id="addFacultyForm"  action="AdminAddFaculty">
                <fieldset>
                 <legend>Personal Info</legend>

                 <div class="row"><div class="col" style="display:none;"> 
                 <input type="hidden" id="formName" name="formName" value="addFaculty" >

                 </div>
                     <div class="col">
                         <label for="stu_name">Name:</label>
                         <input type="text" id="f_name" class="form-control" name="f_name" placeholder="Enter your Name">
                     </div>
                     <div class="col">
                         <label for="email">Email:</label>
                         <input type="email" id="f_email"  class="form-control"name="f_email" placeholder="Enter your Email-Id">
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
                        <input type="tel"class="form-control" id="mobileNum" name="mobileNum">
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
                     <legend>Academic Details</legend>
                         <div class="row">
                         <div class="col">
                          <label for="dateJoin">Year of Joining:</label>
                          <input type="text" name="yearJoin" id="yearJoin" class="form-control">
                             
                         </div>
                        </div>
                     <div class="row">
                         <div class="col">
                          <label for="course">Course:</label>
                          <input type="text" name="course" id="course" class="form-control">
                         </div>
                  
                         <div class="col">
                            
                          <label for="designation">Designation:</label>
                          <select id="designation" name="designation" class="form-control">
                              <option value="">--select--</option>
                              <option value="HOD">HOD</option>
                              <option value="Professor">Professor</option>
                              <option value="Assistant-professor">Assistant Professor</option>
                              <option value="Associate-professor">Associate professor</option>
                          </select>    
                        </div>
                       </div>
                         <button type="submit" class="btn btn-primary">Add Faculty</button>
                    </form>
                    </div>
                
          </div>
        </div>
      </div>
		
		<!--  Delete Faculty Modal -->
			    <div class="modal fade" id="removeFaculty" data-bs-backdrop="static" data-bs-keyboard="false" tabindex="-1" aria-labelledby="editFacultyabel" aria-hidden="true">
				         <div class="modal-dialog modal-dialog-scrollable " >
				         <div class="modal-content">
				             <div class="modal-header ">
				               <h5 class="modal-title " id="exampleModalLabel">REMOVE FACULTY</h5>
				               <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
				             </div>
				             <div class="modal-body">
				                 
				                 <form id="removeStudent" action="AdminAddFaculty">
				                  <div class="row"> <div class="col" style="display:none;">
				                         <input type="hidden" id="formName" name="formName" value="removeFaculty">
				                     </div>
				                     <div class="col">
				                         <label for="stu_id" >Enter Faculty Id:</label>
				                         <input type="text" id="stu_di" name="faculty_id" class="form-control" autofocus>
				                     </div>
				 
				                  </div>
				 
				                           <button type="submit" class="btn btn-primary" >RemoveFaculty</button>
				                 </form>
				                     </div>
				                    <div class="modal-footer">
				               <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
				               
				             </div>
				           </div>
				       </div>
				       </div>s
				 

</body>
</html>
		