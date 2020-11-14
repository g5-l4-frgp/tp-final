<%@page import="Entidad.Persona"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Modificar cliente</title>
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
<title>Modificar de cliente</title>
</head>
<body id="Fondo">
<jsp:include page="MenuAdmin.html"></jsp:include>
<div class="container">
<h1 class="mt-3 text-center mb-1 text-light">Modificar cliente</h1>
<form class="Alta" action="controlador" method="get">
  <%
  Persona usuario = new Persona();
  usuario = (Persona) request.getAttribute("usuario");
  %>
  <div class="form-row">
    <div class="form-group col-md-6">
      <label for="inputEmail4" class="text-light">Usuario</label>
      <input type="text" class="form-control" value="<%=usuario.getNickUsuario()%>" id="inputEmail"readonly name="usuario">
    </div>
    <div class="form-group col-md-6">
      <label for="inputPassword4" class="text-light">Contraseña</label>
      <input type="password" class="form-control" value="*********" id="inputPassword" name="contraseña">
    </div>
  </div>
    <div class="form-row">
    <div class="form-group col-md-6">
      <label for="inputEmail4" class="text-light">Email</label>
      <input type="email" class="form-control" value="<%=usuario.getContacto().getEmail()%>" name="email" id="inputEmail">
    </div>
    <div class="form-group col-md-6">
      <label for="inputPassword4" class="text-light">Teléfono</label>
      <input type="text" class="form-control" value="<%=usuario.getContacto().getTelefono()%>" name="telefono" id="inputPassword">
    </div>
  </div>
    <div class="form-row">
    <div class="form-group col-md-6">
      <label for="inputEmail4" class="text-light">Cuil</label>
      <input type="text" class="form-control" value="<%=usuario.getCuil()%>" name="cuil" id="inputEmail">
    </div>
    <div class="form-group col-md-6">
      <label for="inputPassword4" class="text-light">Dni</label>
      <input type="text" class="form-control" value="<%=usuario.getDNI()%>" name="dni" id="inputPassword">
    </div>
  </div>
    <div class="form-row">
    <div class="form-group col-md-4">
      <label for="inputEmail4" class="text-light">Nombre</label>
      <input type="text" class="form-control" value="<%=usuario.getNombre()%>" name="nombre" id="inputnombre">
    </div>
    <div class="form-group col-md-4">
      <label for="inputPassword4" class="text-light">Apellido</label>
      <input type="text" class="form-control" value="<%=usuario.getApellido()%>" name="apellido" id="inputApellido">
        </div>
          <div class="form-group col-md-4">
      <label for="inputState" class="text-light">Sexo</label>
      <select id="inputState" class="form-control" name="sexo">
        <option selected>Seleccionar...</option>
        <option>Femenino</option>
        <option>Masculino</option>
      </select>
    </div>
      </div>
  <div class="form-group">
    <label for="inputAddress" class="text-light">Calle</label>
    <input type="text" class="form-control"  value="<%=usuario.getDomicilio().getCalle()%>" name="calle" id="inputAddress">
  </div>

  <div class="form-row">
    <div class="form-group col-md-6">
      <label for="inputCity" class="text-light">Provincia</label>
      <input type="text" value="<%=usuario.getDomicilio().getProvincia()%>" class="form-control" name="provincia" id="inputCity">
    </div>
 <div class="form-group col-md-6">
      <label for="inputCity" class="text-light">Localidad</label>
      <input type="text" value="<%=usuario.getDomicilio().getLocalidad()%>" class="form-control" name="localidad" id="inputCity">
    </div>

  </div>

  <button type="submit" class="btn btn-primary crear" name="btnAceptar_modificar">Aceptar</button>
</form>
</div>
</body>
</html>