<%@page import="Entidad.Prestamos"%>
<%@page import="Entidad.Cuentas"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
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
 	margin: 50px;
 	}
 #Fondo{
        background-color:#020648;
     }
</Style>
<title>Menu de pago</title>
</head>
<body id="Fondo">
<jsp:include page="MenuCliente.html"></jsp:include>
<div class="container">
<%
ArrayList<Prestamos> lista = new ArrayList<Prestamos>();
lista = (ArrayList<Prestamos>)request.getAttribute("listaPrestamos");
%>
<table class="table ">
  <thead class="thead-light">
    <tr>

      <th scope="col">Cantidad cuotas pagas </th>
      <th scope="col">Cuotas totales</th>
      <th scope="col">Fecha de Solicitud</th>
      <th><th>
    </tr>
  </thead>
  <tbody class="text-light">
    <% if(lista!=null){
  		 for(Prestamos e : lista)
		{
%>
    <tr class="text-light">
      <form action="Controlador" method="get">
      <td><%=e.getCuotasPagas()%><input type="hidden" name="idUsuario" value="<%=e.getCuota().getCuota()%>"></td>
      <td><%=e.getCantidadCuotas()%></td>
      <td><%=e.getCliente().getDNI()%></td>
    
      <td><button type="submit" class="btn btn-primary" name="btnPagar" >Paga</button></td> 
    </form>
    </tr>
      <%  } 
  		 }%>
  </tbody>
</table>
</div>
</body>
</html>