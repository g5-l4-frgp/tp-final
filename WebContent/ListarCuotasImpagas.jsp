<%@page import="Entidad.Cuentas"%>
<%@page import="Entidad.Cuotas"%>
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

<div class="container Mover  ">
<div class="row mt-5  ">

      <input type="text" class="form-control" id="Filtrar">
      <button type="submit" class="btn btn-primary ml-2 ">Buscar</button>
    </div>
    </div>
<%
ArrayList<Cuotas> lista = new ArrayList<Cuotas>();
ArrayList<Cuentas> listaPersonal = new ArrayList<Cuentas>();
lista = (ArrayList<Cuotas>)request.getAttribute("listaCuota");
listaPersonal = (ArrayList<Cuentas>)request.getAttribute("listaCuenta");
String alerta=(String)request.getAttribute("mensaje");
%>
	<div class="form-group col-md-4">
		<form action="ServletPrestamos" method="get">
      <label for="inputState"class="text-light">Concepto</label>
      <select id="inputState" name="Cuenta" class="form-control">
        <option selected>Seleccionar...</option>
  <% if(listaPersonal!=null){
  		 for(Cuentas e : listaPersonal)
		{
  			 
%>
        <option value="<%=e.getID()%>"><%=e.getNumeroCuenta()%></option>
 <%  } 
  		 }%>
      </select>
   </div>

      <button type="submit" class="btn btn-success "name="btnMostrar" >Mostrar</button>
     
<div class="container">
<table class="table ">
  <thead class="thead-light">
    <tr >
      <th scope="col">Mes correspondiente</th>
      <th scope="col">Importe</th>
      <th scope="col">Fecha De Vencimiento</th>
      <th scope="col">Estado</th>
      <th scope="col">CHECK</th>
     
     
    </tr>
  </thead>
  <tbody>
   <% if(lista!=null){
  		 for(Cuotas e : lista)
		{
  			 
%>
    <tr class="text-light">
      <form action="ServletPrestamos" method="get">
      <td><%=e.getFechaMes()%><input type="hidden" name="Cuota" value="<%=e.getCuota()%>"></td>
      <td><%=e.getImporte()%></td><input type="hidden" name="Prestamo" value="<%=e.getPrestamo().getIdPrestamo()%>"></td>
      <td><%=e.getFechaVencimiento()%></td>
      <td><%=e.getEstado()%></td>
      <td><button type="submit" class="btn btn-success"name="btnPagarCuotas">Pagar</button></td>
      
    </form>
    </tr>
      <%  } 
  		 }%>	
  		  </form>
  </tbody>
</table>
</div>
</body>
</html>