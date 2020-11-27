<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>
 	
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
<Style>
 	.Alta{
 	width: 100%;
    max-width: 600px;
    padding: 15px;
    margin: auto;
 	    }
 	 .crear{
 	  	width: 100%;
 
    margin: auto;
 	 }
   #Fondo{
        background-color:#020648;
     }
</Style>
<title>Modificar de cuenta</title>
</head>
<body id="Fondo">
<jsp:include page="MenuAdmin.html"></jsp:include>

<div class="row">
<div class="col-8">
<div class="container" style="background-color:black; margin-left:10px;">
<h1 class="mt-3 text-center mb-1 text-info  text-light" style="margin:auto;">Modificar cuenta</h1>
<form class="Alta">
  <div class="form-row">
    <div class="form-group col-md-3">
      <label for="inputEmail4" class="text-light">Usuario</label>
      <input type="text" class="form-control" id="inputEmail">
    </div>
          <div class="form-group col-md-3">
      <label for="inputState"class="text-light">Tipo de cuenta</label>
      <select id="inputState" class="form-control">
        <option selected>Seleccionar...</option>
        <option>Opcion 1</option>
        <option>Opcion 2</option>
      </select>
    </div>
  </div>
    <div class="form-row">
    <div class="form-group col-md-6">
      <label for="inputEmail4"class="text-light">CBU</label>
      <input type="email" class="form-control" id="inputEmail">
    </div>
    <div class="form-group col-md-3">
      <label for="inputPassword4"class="text-light">Saldo límite</label>
      <input type="text" class="form-control" id="inputPassword">
    </div>
  </div>

  <button type="submit" class="btn btn-success crear">Confirmar</button>
</form>
</div>
</div>
<div class="col-4" style="margin-top:20px; background-color:#42A975;">
    <a href=""> <img alt="" src="https://controlpublicidad.com/uploads/2019/06/bbva-nueva-identidad-085239.jpg" style="max-height:270px; max-widht:350px; margin-top:10px; margin-left:20px;">
    </a>    
    
</div>
</div>
<div class="jumbotron" style="margin-top:70px; background-color:#717573;">
  <div class="container">
    <h1 style="text-align:center; margin-bottom:50px;">Contactanos</h1>
    <a href=""> <img alt="" src="https://upload.wikimedia.org/wikipedia/commons/thumb/5/51/Facebook_f_logo_%282019%29.svg/1365px-Facebook_f_logo_%282019%29.svg.png" style="max-height:70px; max-widht:20px; margin-left:450px;">
    </a>
    <a href=""> <img alt="" src="https://images.vexels.com/media/users/3/137419/isolated/preview/b1a3fab214230557053ed1c4bf17b46c-icono-de-twitter-logo-by-vexels.png" style="max-height:70px; max-widht:20px;">
    </a>
    <a href=""> <img alt="" src="https://upload.wikimedia.org/wikipedia/commons/thumb/e/e7/Instagram_logo_2016.svg/1200px-Instagram_logo_2016.svg.png" style="max-height:70px; max-widht:20px;">
    </a>    
    
    <p class="mt-5 mb-3 text-muted text-center text-light" style="background-color:white;">© 2017-2020</p>
  
  </div>
</div>
</body>
</html>