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
<% LinkedHashMap<String,String> student = new  LinkedHashMap<String,String>(); 
  student = (LinkedHashMap<String,String>)session.getAttribute("student");
//System.out.print(student);
%>
   <nav class="navbar navbar-expand-lg navbar-light bg-light">
        <div class="container-fluid">
            <img src="logo.png">
          <a class="navbar-brand" href="">Student Record System</a>
         
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
                <a class="nav-link" href="StudentLogin.jsp">Log Out</a>
              </li> 
          </div>
        </div>
      </nav>
      <!--  Body -->
<img src="D:/III Year Project/DSAProject/admin.jpg"  width="120px" height="120px" alt="demoimg">
	<div class="profile container py-4">
		<div class="card ">
			<div class="row">
				<div class="col-4 text-center py-4">
					<h2>Welcome Student</h2>
				</div>
				<div class="col-8 py-4">

					<div class="row mb-3">

						<div class="col-sm-10">
							<table class="table">

								<tbody>
									<tr>
										<th scope="col">NAME</th>
										<td>:</td>
										<td scope="col"><%=student.get("stu_name")%></td>
									</tr>
									<tr>
										<th scope="col">ROLL NO</th>
										<td>:</td>
										<td scope="col"><%=session.getAttribute("userID")%></td>
									</tr>
									<tr>
										<th scope="col">DEGREE</th>
										<td>:</td>
										<td scope="col"><%=student.get("degree")%></td>
									</tr>
									<tr>
										<th scope="col">DEPARTMENT</th>
										<td>:</td>
										<td scope="col"><%=student.get("department")%></td>
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
					<td scope="col"><%=student.get("stu_name")%></td>
				</tr>
				<tr>
					<th scope="col">ROLL NO</th>
					<td>:</td>
					<td scope="col"><%=session.getAttribute("userID") %></td>
				</tr>
				<tr>
					<th scope="col">YEAR</th>
					<td>:</td>
					<td scope="col"><%=student.get("year") %></td>
				</tr>
				<tr>
					<th scope="col">DEGREE</th>
					<td>:</td>
					<td scope="col"><%=student.get("degree") %></td>
				</tr>
				<tr>
					<th scope="col">DEPARTMENT</th>
					<td>:</td>
					<td scope="col"><%=student.get("department") %></td>
				</tr>
				<tr>
					<th scope="col">EMAIL</th>
					<td>:</td>
					<td scope="col"><%=student.get("stu_email") %></td>
				</tr>
				<tr>
					<th scope="col">DOB</th>
					<td>:</td>
					<td scope="col"><%=student.get("dob") %></td>
				</tr>
				<tr>
					<th scope="col">BLOOD GROUP</th>
					<td>:</td>
					<td scope="col"><%=student.get("bloodgroup") %></td>
				</tr>
				<tr>
					<th scope="col">ADDRESS</th>
					<td>:</td>
					<td scope="col"><%=student.get("address") %></td>
				</tr>
				<tr>
					<th scope="col">MOBILE NUMBER</th>
					<td>:</td>
					<td scope="col"><%=student.get("mobileNum") %></td>
				</tr>
				
			</tbody>
		</table>
			</div>
		</div>
		 </div>
	</div>
	<!--  Edit Details -->
	 <div class="container px-4" id="editdt" style="display:none;">
	 <form action="StudentServlet">
	   <input type="hidden" id="formname" name="formName" style="display:none;" value="editdt">
	   <table class="table">

			<tbody>
				<tr>
				
      
					<th scope="col">NAME</th>
					<td>:</td>
					<td scope="col"><input type="text" id="stu_name" name="stu_name"  value="<%=student.get("stu_name")%>"></td>
				</tr>
				<tr>
					<th scope="col">ROLL NO</th>
					<td>:</td>
					<td scope="col"><input type="hidden" id="stu_id" name="stu_id"  value="<%=session.getAttribute("userID") %>"></td>
				</tr>
				<tr>
					<th scope="col">YEAR</th>
					<td>:</td>
					<td scope="col"><select id="year" name="year">
      <option value="<%=student.get("year") %>"><%=student.get("year") %></option>
      <option value="I">I</option>
      <option value="II">II</option>
      <option value="III">III</option>
      <option value="IV">IV</option>
      </select></td>
				</tr>
				<tr>
					<th scope="col">DEGREE</th>
					<td>:</td>
					<td scope="col">
					<select id="degree" name="degree">
        <option value="<%=student.get("degree") %>"><%=student.get("degree") %></option>
        <option value="BE">BE</option>
        <option value="BTech">BTech</option>
        <option value="MBA">MBA</option>
      </select></td>
				</tr>
				<tr>
					<th scope="col">DEPARTMENT</th>
					<td>:</td>
					<td scope="col"> <select id="department" name="department">
      <option value="<%=student.get("department") %>"><%=student.get("department") %></option>
      <option value="CSE">CSE</option>
      <option value="CS">CS</option>
      <option value="CST">CST</option>
      <option value="IT">IT</option>
      <option value="ECE">ECE</option>
      <option value="EEE">EEE</option>
      <option value="MECH">MECH</option>
    </select></td>
				</tr>
				<tr>
					<th scope="col">EMAIL</th>
					<td>:</td>
					<td scope="col"> <input type="email" id="stu_email" name="stu_email" value="<%=student.get("stu_email") %>"></td>
				</tr>
				<tr>
					<th scope="col">DOB</th>
					<td>:</td>
					<td scope="col"><input type="date" id="dob" name="dob" value="<%=student.get("dob") %>"></td>
				</tr>
				<tr>
					<th scope="col">BLOOD GROUP</th>
					<td>:</td>
					<td scope="col"><input type="text" id="bloodgroup" name="bloodgroup"  value="<%=student.get("bloodgroup") %>"></td>
				</tr>
				<tr>
					<th scope="col">ADDRESS</th>
					<td>:</td>
					<td scope="col"> <input type="text" id="address" name="address" value="<%=student.get("address") %>"></td>
				</tr>
				<tr>
					<th scope="col">MOBILE NUMBER</th>
					<td>:</td>
					<td scope="col"><input type="tel" id="mobileNum" name="mobileNum" value="<%=student.get("mobileNum") %>"></td>
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