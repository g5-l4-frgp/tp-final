<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
		<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>
 	<Style>

 	.form-signin{
 	width: 100%;
    max-width: 420px;
    padding: 15px;
    margin: auto;
 	    }
 	.container{
 	margin-top: 130px;}
 	#Fondo{
        background-color:#020648;
     }
 	</Style>
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">

<title>Login</title>
</head>
<body  id="Fondo">
<jsp:include page="MenuLogin.html"></jsp:include>
<div class="container">
<h1 class="mt-3 text-center mb-4 text-info text-info ">Iniciar sesi�n</h1>
<form class="form-signin">
  	<div class="form-label-group">
    <input type="email" id="inputEmail" class="form-control" placeholder="Email address" required="" autofocus="">
    <label for="inputEmail"class="text-light">Email address</label>
  </div>

  <div class="form-label-group">
    <input type="password" id="inputPassword" class="form-control" placeholder="Password" required="">
    <label for="inputPassword"class="text-light">Password</label>
  </div>

  <div class="checkbox mb-3">
    <label class="text-light">
      <input type="checkbox" value="remember-me"> Remember me
    </label>
  </div>
  <button id="boton"   class="btn btn-lg btn-primary btn-block text-light" type="submit">Sign in</button>
  <p class="mt-5 mb-3 text-muted text-center text-light">� 2017-2020</p>
</form>
</div>
</body>
</html>