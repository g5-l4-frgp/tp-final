
<%@page import="Entidad.Persona"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>
 	
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
<Style>
 	.table
 	{
 	
 	width: 100%;
    max-width: 60%;
    padding: 15px;
    margin: auto;
    margin-top:15px;
 	}
 	#Filtrar
 	{
 	
 	width: 20%;
 	margin: 10px 0 10px 200px;	
 	}
 	#crear
 	{
 	
 	width: 15%;
 	margin: 10px 10px 10px 225px;	
 	}
 	.Mover
 	{
		margin-right: 20px;
		margin-top: 50px;
 	}
 	 #Fondo{
        background-color:#020648;
     }

</Style>
</head>
<body id="Fondo">
<jsp:include page="MenuAdmin.html"></jsp:include>
     <form action="Controlador" method="get">

<%
ArrayList<Persona> lista = new ArrayList<Persona>();
Persona usuario = new Persona();
lista = (ArrayList<Persona>)request.getAttribute("lista");
%>
<div class="container " style="margin-top: 50px;">
<div class="container mover">
    <div class="row  ">
      <button type="submit" class="btn btn-primary " id="crear" name="btnCrearUsuario">Crear Usuario</button>
       <input type="text" class="form-control"  id="Filtrar">
       <button type="submit" class="btn btn-primary ">Buscar</button>
    </div>

    </div>
<table class="table ">
  <thead class="thead-light">
    <tr >
      <th scope="col">Nombre</th>
      <th scope="col">Apellido</th>
      <th scope="col">DNI</th>
      <th scope="col"></th>
      <th scope="col"></th>
      <th scope="col"></th>
     
    </tr>
  </thead>
  <tbody>
   <% if(lista!=null){
  		 for(Persona e : lista)
		{
%>
   <form action="Controlador" method="post">
    <tr class="text-light">
      <td><%=e.getNombre() %><input type="hidden" name="idUsuario" value="<%=e.getID()%>"></td>
      <td><%=e.getApellido()%></td>
      <td><%=e.getDNI()%></td>
      <td><button type="submit" class="btn btn-danger" name="btnEliminarCliente">Eliminar</button></td> 
      <td><button type="submit" class="btn btn-primary" name="btnCrearCuenta">Crear cuenta</button></td> 
      <td><button type="submit" class="btn btn-success"name="btnDetalleCliente">Detalles</button></td> 
    </tr>
    
</form>
      <%  } 
  		 }%>	
  </tbody>
</table>
</div>
  		 </form>
</body>
</html>