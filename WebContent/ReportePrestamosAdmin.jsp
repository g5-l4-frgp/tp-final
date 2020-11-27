<%@page import="Entidad.Prestamos"%>
<%@page import="Entidad.Persona"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Reporte prestamos</title>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>
 	
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
<Style>

	table{
    table-layout: fixed;
    width: 250px;
    margin-right:10px;
}

	th, td {
    border: 1px solid blue;
    width: 180px;
    word-wrap: break-word;
}
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

<div class="row">
<div class="col-8">
<div class="container" style="background-color:#717573; margin-left:10px;">
<h1 class="mt-3 text-center mb-1 text-info" style="margin:auto;">REPORTE DE PRESTAMOS</h1>
<form action="Controlador" method="get" class="Alta">
	<div class="form-row">
       <div class="form-group col-md-3">
      <label for="inputCity" class="text-light">Desde</label>
      <input type="date" class="form-control" id="fechaInicio" name="txtFechaInicio" required>
    </div>
     <div class="form-group col-md-3">
      <label for="inputCity" class="text-light">Hasta</label>
      <input type="date" class="form-control" id="fechaFin" name="txtFechaFinal" required>
    </div>
      <button type="submit" class="btn btn-success crear" style="max-height:50px; width:100px; margin-top:25px; margin-left:250px;">Filtrar</button>
    </div>
    </div>
    </div>
    </div>
</form>
<%
ArrayList<Prestamos> lista = new ArrayList<Prestamos>();
lista = (ArrayList<Prestamos>)request.getAttribute("listaPrestamos");
%>

<div class="col-8">
<div class="container" style="margin-left:5px;">
<table class="table">
<caption>Reporte de prestamos de clientes</caption>
  <thead class="thead-dark">
    <tr >
      <th scope="col">Fecha de solicitud</th>
      <th scope="col">Cliente</th>
      <th scope="col">Monto</th>
	  <th scope="col">Estado</th>
     
    </tr>
  </thead>
  <tbody>
   <% if(lista!=null){
  		 for(Prestamos e : lista)
		{
%>
    <tr class="text-light">
      <form action="ServletPrestamos" method="get">
      
      <td><%=e.getCliente().getDNI()%><input type="hidden" name="idPrestamo" value="<%=e.getIdPrestamo()%>"></td>
      <td><%=e.getFechaSoli() %></td>
      <td><button type="submit" class="btn btn-danger" name="btnSolicitud">Ver Solicitud</button></td> 

    </form>
    </tr>
      <%  } 
  		 }%>	
  </tbody>
</table>
</div>
</div>
</body>
</html>