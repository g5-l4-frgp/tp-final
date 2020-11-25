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
    max-width: 1200px;
    padding: 15px;
    margin:0 0 0 300px;
    color: white;
 	    }
 	 .crear{
 	  	width: 25%;
 	  	
 
		margin:10px 0 0 35%;
 	 }
 	 
 	    #Fondo{
        background-color:#020648;
     }
</Style>
<title>Alta de cliente</title>
<meta charset="UTF-8">
</head>
<body id="Fondo">
<jsp:include page="MenuAdmin.html"></jsp:include>

<div class="container-fluid">
<h1 class="mt-3 text-center mb-1 text-info" style="margin:auto;">Alta de cliente</h1>
<form action="Controlador" method="get" class="Alta">
  <div class="form-row">
    <div class="form-group col-md-6">
      <label for="inputEmail4">Usuario</label>
      <input type="text" class="form-control" name="txtUsuario" required >
    </div>
    <div class="form-group col-md-6">
      <label for="inputPassword4">Password</label>
      <input type="password" class="form-control" name="txtPassword" required>
    </div>
  </div>
    <div class="form-row">
    <div class="form-group col-md-12">
      <label for="inputEmail4">Email</label>
      <input type="email" class="form-control" name="txtEmail" required>
    </div>

  </div>
    <div class="form-row">
        <div class="form-group col-md-4">
      <label for="inputPassword4">Telefono</label>
      <input type="number" class="form-control" name="txtTelefono" required>
    </div>
    <div class="form-group col-md-4">
      <label for="inputEmail4">Cuil</label>
      <input type="number" class="form-control" name="txtCuil" required>
    </div>
    <div class="form-group col-md-4">
      <label for="inputPassword4">DNI</label>
      <input type="number" class="form-control" name="txtDni" required>
    </div>
  </div>
    <div class="form-row">
    <div class="form-group col-md-4">
      <label for="inputEmail4">Nombre</label>
      <input type="text" class="form-control" name="txtNombre" required>
    </div>
    <div class="form-group col-md-4">
      <label for="inputPassword4">Apellido</label>
      <input type="text" class="form-control" name="txtApellido" required>
        </div>
          <div class="form-group col-md-4">
      <label for="inputState">Sexo</label>
      <select class="form-control" name="ddlSexo">
        <option selected>Seleccionar...</option>
        <option value=1>Femenino</option>
        <option value=2>Masculino</option>
      </select>
    </div>
      </div>
      
        <div class="form-row">
    <div class="form-group col-md-6">
      <label for="inputCity">Fecha de nacimiento</label>
      <input type="date" class="form-control" id="fechaNac" name="txtFechaNacimiento" required>
    </div>
 <div class="form-group col-md-6">
      <label for="inputCity">Nacionalidad</label>
      <input type="text" class="form-control" name="txtNacionalidad" required>
    </div>

  </div>
      
  <div class="form-row">
  <div class="form-group col-md-6">
    <label for="inputAddress">Calle</label>
    <input type="text" class="form-control" id="inputAddress"  name="txtCalle" required>
  </div>
    <div class="form-group col-md-6">
    <label for="inputAddress">Altura</label>
    <input type="number" class="form-control" id="inputAddress" name="txtAltura" required>
  </div>
  </div>

  <div class="form-row">
    <div class="form-group col-md-6">
      <label for="inputCity">Provincia</label>
         <select class="form-control" name="txtProvincia">
        <option selected>Seleccionar...</option>
        <option value="Buenos Aires">Buenos Aires</option>
        <option value="Catamarca">Catamarca</option>
        <option value="Chaco">Chaco</option>
        <option value="Chubut">Chubut</option>
        <option value="Cordoba">Cordoba</option>
        <option value="Corrientes">Corrientes</option>
        <option value="Entre Ríos">Entre Ríos</option>
        <option value="Formosa">Formosa</option>
        <option value="Jujuy">Jujuy</option>
        <option value="La Pampa">La Pampa</option>
        <option value="La Rioja">La Rioja</option>
        <option value="Mendoza">Mendoza</option>
        <option value="Misiones">Misiones</option>
        <option value="Neuquen">Neuquen</option>
        <option value="Rio Negro">Rio Negro</option>
        <option value="Salta">Salta</option>
        <option value="San Juan">San Juan</option>
        <option value="San Luis">San Luis</option>
        <option value="Santa Cruz">Santa Cruz</option>
        <option value="Santa Fe">Santa Fe</option>
        <option value="Santiago del Estero">Santiago del Estero</option>
        <option value="Tierra del Fuego">Tierra del Fuego</option>
        <option value="Tucuman">Tucuman</option>
      </select>
    </div>
 <div class="form-group col-md-6">
      <label for="inputCity">Localidad</label>
      <input type="text" class="form-control" name="txtLocalidad" required>
    </div>

  </div>
  
	<input type="submit" class="btn btn-primary crear" value="Crear cliente" name="btnAceptar">
  
  <script >
  var today = new Date();
  var dd = today.getDate();
  var mm = today.getMonth()+1;
  var yyyy = today.getFullYear()-18;
   if(dd<10){
          dd='0'+dd
      } 
      if(mm<10){
          mm='0'+mm
      } 

  today = yyyy+'-'+mm+'-'+dd;
  document.getElementById("fechaNac").setAttribute("max", today);
  </script>
</form>
</div>
</body>
</html>