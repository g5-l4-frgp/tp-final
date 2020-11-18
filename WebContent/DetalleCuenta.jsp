<%@page import="Entidad.Persona"%>
<%@page import="Entidad.Cuentas"%>
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
<div class="container">
<h1 class="mt-3 text-center mb-1 text-info  text-light">Modificar cuenta</h1>
<form class="Alta" action="ServletCuenta" method="get">
  <%
  Cuentas cuenta = new Cuentas();
  cuenta = (Cuentas) request.getAttribute("cuenta");
  Persona usuario = new Persona();
  usuario = (Persona) request.getAttribute("usuario");
  %>
  <%
  String tipo=null;
  switch (cuenta.getIdtipo())
  
		{
		case 1:
		{
			tipo="Corriente";
		}
		case 2:
		{
			tipo="Caja de ahorro";
		}
		}
		%>
  <div class="form-row">
    <div class="form-group col-md-6">
      <label for="inputEmail4" class="text-light">Usuario</label>
      <input type="text" class="form-control"value="<%=usuario.getNickUsuario()%>"  id="inputEmail">
    </div>
     <div class="form-group col-md-6">
      <label for="inputEmail4" class="text-light">Tipo de cuenta</label>
      <input type="text" class="form-control"value="<%=tipo%>"  id="inputEmail">
    </div>
  </div>
    <div class="form-row">
    <div class="form-group col-md-6">
      <label for="inputEmail4"class="text-light">CBU</label>
      <input type="email" class="form-control"value="<%=cuenta.getCBU()%>"  id="inputEmail">
    </div>
    <div class="form-group col-md-6">
      <label for="inputPassword4"class="text-light">Saldo límite</label>
      <input type="text" class="form-control"value="<%=cuenta.getSaldo()%>"  id="inputPassword">
    </div>
  </div>

  <button type="submit" class="btn btn-success crear"name="btnVolver" >Volver</button>
</form>
</div>
</body>
</html>