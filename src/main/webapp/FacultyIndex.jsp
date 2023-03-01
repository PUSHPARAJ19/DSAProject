<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="java.io.*" %>
    <%@page import="java.util.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>SRP</title>
 <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/css/bootstrap.min.css" rel="stylesheet"
            integrity="sha384-gH2yIJqKdNHPEq0n4Mqa/HGKIhSkIHeL5AyhkYV8i59U5AR6csBvApHHNl/vI1Bx" crossorigin="anonymous">
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-A3rJD856KowSb7dwlZdYEkO39Gagi7vIsF0jrRAoQmDKKtQBHUuLZ9AsSv4jD4Xa"
            crossorigin="anonymous"></script>
</head>
<body>
<% LinkedHashMap<String,String> faculty = new  LinkedHashMap<String,String>(); 
  faculty = (LinkedHashMap<String,String>)session.getAttribute("faculty");
//System.out.print(faculty);
%>
   <nav class="navbar navbar-expand-lg navbar-light bg-light">
        <div class="container-fluid">
            <img src="logo.png">
          <a class="navbar-brand" href="">faculty Record System</a>
         
          <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
          </button>
          <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <ul class="navbar-nav me-auto mb-2 mb-lg-0">
              <li class="nav-item">
                <a class="nav-link active" aria-current="page" href="#">Home</a>
              </li>
              <li class="nav-item">
                <a class="nav-link" href="#">View</a>
              </li> 
              <li class="nav-item">
                <a class="nav-link" href="#">Update</a>
              </li> 
              <li class="nav-item">
                <a class="nav-link" href="FacultyLogin.jsp">Log Out</a>
              </li> 
          </div>
        </div>
      </nav>
      <!--  Body -->

	<div class="profile container py-4">
		<div class="card ">
			<div class="row">
				<div class="col-4 text-center py-4">
					<h2>Welcome Faculty</h2>
				</div>
				<div class="col-8 py-4">

					<div class="row mb-3">

						<div class="col-sm-10">
							<table class="table">

								<tbody>
									<tr>
										<th scope="col">NAME</th>
										<td>:</td>
										<td scope="col"><%=faculty.get("f_name")%></td>
									</tr>
									<tr>
										<th scope="col">Faculty ID</th>
										<td>:</td>
										<td scope="col"><%=session.getAttribute("userID")%></td>
									</tr>
									<tr>
										<th scope="col">COURSE</th>
										<td>:</td>
										<td scope="col"><%=faculty.get("course")%></td>
									</tr>
									<tr>
										<th scope="col">DESIGNATION</th>
										<td>:</td>
										<td scope="col"><%=faculty.get("designation")%></td>
									</tr>
								</tbody>
							</table>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>

	<!--  opertaions -->
	<div class="container">
		<div class="a">
			<div class="row row-cols-2 row-cols-md-2 ">
				<div class="col">
					<div class="card">
						<button class="btn btn-primary" type="button" onclick="display()"
							data-bs-toggle="modal" data-bs-target="#viewDetail">
							<div class="card-body">
								<h5 class="card-title" >VIEW DETAILS</h5>
							</div>
						</button>
					</div>
				</div>

				<div class="col">
					<div class="card">
						<button class="btn btn-primary" type="button" onclick="edit()"
							data-bs-toggle="modal" data-bs-target="#editDetail">
							<div class="card-body">
								<h5 class="card-title">EDIT DETAILS</h5>
							</div>
						</button>
					</div>
				</div>
			</div>
		</div>
	</div>

	<!--  Details -->
	<div class="viewdt container py-4" id="viewdt" style="display:none;">
     <div class="row">
     <div class="col-2">
     </div>
    
     
		<div class="card px-4" style="max-width: 50rem;">
			<div class="card-body">
			<h5 class="card-title text-center">YOUR INFO</h5>
			<table class="table">

			<tbody>
				<tr>
					<th scope="col">NAME</th>
					<td>:</td>
					<td scope="col"><%=faculty.get("f_name")%></td>
				</tr>
				<tr>
					<th scope="col">FACULTY ID</th>
					<td>:</td>
					<td scope="col"><%=session.getAttribute("userID") %></td>
				</tr>
				<tr>
					<th scope="col">YEAR OF JOIN</th>
					<td>:</td>
					<td scope="col"><%=faculty.get("yearJoin") %></td>
				</tr>
				<tr>
					<th scope="col">COURSE</th>
					<td>:</td>
					<td scope="col"><%=faculty.get("course") %></td>
				</tr>
				<tr>
					<th scope="col">DESGINATION</th>
					<td>:</td>
					<td scope="col"><%=faculty.get("designation") %></td>
				</tr>
				<tr>
					<th scope="col">EMAIL</th>
					<td>:</td>
					<td scope="col"><%=faculty.get("f_email") %></td>
				</tr>
				<tr>
					<th scope="col">DOB</th>
					<td>:</td>
					<td scope="col"><%=faculty.get("dob") %></td>
				</tr>
				<tr>
					<th scope="col">BLOOD GROUP</th>
					<td>:</td>
					<td scope="col"><%=faculty.get("bloodgroup") %></td>
				</tr>
				<tr>
					<th scope="col">ADDRESS</th>
					<td>:</td>
					<td scope="col"><%=faculty.get("address") %></td>
				</tr>
				<tr>
					<th scope="col">MOBILE NUMBER</th>
					<td>:</td>
					<td scope="col"><%=faculty.get("mobileNum") %></td>
				</tr>
				
			</tbody>
		</table>
			</div>
		</div>
		 </div>
	</div>
	<!--  Edit Details -->
	 <div class="container px-4" id="editdt" style="display:none;">
	 <form action="FacultyServlet">
	   <input type="hidden" id="formname" name="formName" style="display:none;" value="editdt">
	   <table class="table">

			<tbody>
				<tr>
				
      
					<th scope="col">NAME</th>
					<td>:</td>
					<td scope="col"><input type="text" id="f_name" name="f_name"  value="<%=faculty.get("f_name")%>"></td>
				</tr>
				<tr>
					<th scope="col">FACULTY ID</th>
					<td>:</td>
					<td scope="col"><input type="hidden" id="f_id" name="f_id"  value="<%=session.getAttribute("userID") %>"></td>
				</tr>
				<tr>
					<th scope="col">YEAR OF JOINING</th>
					<td>:</td>
					<td scope="col"> <input type="text" name="yearJoin" id="yearJoin" value="<%=faculty.get("yearJoin")%>">
              </td>
				</tr>
				<tr>
				 <th scope="col">COURSE</th>
				 <td>:</td>
					<td scope="col"> <input type="text" name="course" id="course"  value="<%=faculty.get("course")%>"></td>
				</tr>
				<tr>
				<th scope="col">DESGINATION</th>
				<td>:</td>
				<td scope="col">
				<select id="designation" name="designation" class="form-control">
                              <option value="<%=faculty.get("designation") %>"><%=faculty.get("designation") %></option>
                              <option value="HOD">HOD</option>
                              <option value="Professor">Professor</option>
                              <option value="Assistant-professor">Assistant Professor</option>
                              <option value="Associate-professor">Associate professor</option>
                          </select>   
				</tr>
				<tr>
					<th scope="col">EMAIL</th>
					<td>:</td>
					<td scope="col"> <input type="email" id="f_email" name="f_email" value="<%=faculty.get("f_email") %>"></td>
				</tr>
				<tr>
					<th scope="col">DOB</th>
					<td>:</td>
					<td scope="col"><input type="date" id="dob" name="dob" value="<%=faculty.get("dob") %>"></td>
				</tr>
				<tr>
					<th scope="col">BLOOD GROUP</th>
					<td>:</td>
					<td scope="col"><input type="text" id="bloodgroup" name="bloodgroup"  value="<%=faculty.get("bloodgroup") %>"></td>
				</tr>
				<tr>
					<th scope="col">ADDRESS</th>
					<td>:</td>
					<td scope="col"> <input type="text" id="address" name="address" value="<%=faculty.get("address") %>"></td>
				</tr>
				<tr>
					<th scope="col">MOBILE NUMBER</th>
					<td>:</td>
					<td scope="col"><input type="tel" id="mobileNum" name="mobileNum" value="<%=faculty.get("mobileNum") %>"></td>
				</tr>
				
			</tbody>
		</table>
		
 <button type="submit"  class="btn btn-primary">EDIT</button>
  </form>
  
	 </div>
	
<script>
  function display()
  {
	  document.getElementById("viewdt").style.display="block";
	  document.getElementById("editdt").style.display="none";
  }
  function edit()
  {
	  document.getElementById("viewdt").style.display="none";
	  document.getElementById("editdt").style.display="block";
  }
  
  
</script>
</body>
</html>