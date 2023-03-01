<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html><head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Student Login</title>
    <!-- <link rel="stylesheet" href="css/normalize.css"> -->
    <link href='https://fonts.googleapis.com/css?family=Nunito:400,300' rel='stylesheet' type='text/css'>
    <!-- <link rel="stylesheet" href="css/main.css"> -->
   <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
   <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
   <style>
   


form {
  max-width: 300px;
  margin: 10px auto;
  padding: 10px 20px;
  border-radius: 8px;
}

@media screen and (min-width: 480px) {

  form {
    max-width: 480px;
  }

}
    </style>
</head>
<body>
   <% //String userId= (String)session.getAttribute("userId");
      // if(userId.length()!=0)
       {
    	  %>
    	  <script>
    	  //alert(userId);
    	  </script>
      <% }
      %>
       <ul class="nav text-white bg-primary">
    <li class="navbar ">STUDENT RECORD SYSTEM</li>
    <li class="nav-item">
    <a href="index.html" class="nav-link text-white">Back</a>  
    </li>
    </ul>
      <div class="vh-100 d-flex justify-content-center align-items-center ">
            <div class="col-md-5 p-5 shadow-sm border rounded-5 border-primary bg-white">
                <h2 class="text-center mb-4 text-primary">Login</h2>
               <form action="StudentServlet">
		<div class="form-outline mb-4">
		   <input type="hidden" id="formname" name="formName" style="display:none;" value="login">
			<label class="form-label" for="userID">User ID</label>
		  <input type="text" id="userID"  name="userID" class="form-control form-control-lg"
			placeholder="Enter a valid userID" />
		</div>
		<!-- Password input -->
		<div class="form-outline mb-3">
			<label class="form-label" for="password">Password</label>
		  <input type="password" id="password" name="password"  class="form-control form-control-lg"
			placeholder="Enter password" />
		  
		</div>
		<div class="text-center text-lg-start mt-4 pt-2">
		  <button type="submit" class="btn btn-primary btn-lg" >Login</button>
		  <p class="small fw-bold mt-2 pt-1 mb-0">Don't have an account? <a href="studentRegister.html"
			  class="link-danger">Register</a></p>
		</div>
	  </form>
            </div>
        
<script>
function dis(){
let x = document.getElementById("password").value;
  alert(typeof(x));
}
</script>
</body>
</html>
