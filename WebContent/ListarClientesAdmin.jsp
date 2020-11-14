
<%@page import="Entidad.Persona"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Listado de clientes</title>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>
 	
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
<Style>
 	.table
 	{
 	
 	width: 100%;
    max-width: 40%;
    padding: 15px;
    margin: auto;
    margin-top:15px;
 	}
 	#Filtrar
 	{
 	
 	width: 20%;
 	margin-left: 59%;
 	}
 	.Mover
 	{
 		margin-left: 10px;
 		margin-right: 20px;
		margin-top: 5px;
 	}
 	 #Fondo{
        background-color:#020648;
     }
 	 
</Style>
</head>
<body id="Fondo">
<jsp:include page="MenuAdmin.html"></jsp:include>

<div class="container Mover">
<div class="row mt-5  ">

      <input type="text" class="form-control" id="Filtrar">
      <button type="submit" class="btn btn-primary ml-2 ">Buscar</button>
    </div>
    </div>
<%
ArrayList<Persona> lista = new ArrayList<Persona>();
Persona usuario = new Persona();
lista = (ArrayList<Persona>)request.getAttribute("lista");
%>
<div class="container">
<table class="table ">
  <thead class="thead-light">
    <tr >
      <th scope="col">Nombre</th>
      <th scope="col">Apellido</th>
      <th scope="col">DNI</th>
      <th scope="col">Email</th>
      <th scope="col">Usuario</th>
      <th scope="col">Teléfono</th>
      <th scope="col">Eliminar</th>
      <th scope="col">Modificar</th>
      <th scope="col">Detalles</th>
     
    </tr>
  </thead>
  <tbody>
   <% if(lista!=null){
  		 for(Persona e : lista)
		{
%>
    <tr class="text-light">
      <form action="Controlador" method="get">
      
      <td><%=e.getNickUsuario()%><input type="hidden" name="idUsuario" value="<%=e.getID()%>"></td>
      <td><%=e.getNombre() %></td>
      <td><%=e.getApellido()%></td>
      <td><%=e.getDNI()%></td>
      <td><button type="submit" class="btn btn-danger" name="btnEliminar">Eliminar</button></td> 
      <td><button type="submit" class="btn btn-primary" name="btnModificar">Modificar</button></td> 
      <td><button type="submit" class="btn btn-success">Detalles</button></td> 
    </form>
    </tr>
      <%  } 
  		 }%>	
  </tbody>
</table>
</div>
</body>
</html>