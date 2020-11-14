<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Lista de movimientos</title>
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
     
     #Tama�oInput{
     	width: 40%;
     }
     
     .Desde
     {
     	margin-left:20px;
     }
     
     .Hasta
     {
     	margin-right:10px;
     }
     
</Style>
</head>
<body id="Fondo">
<jsp:include page="MenuCliente.html"></jsp:include>
<div class="container">
<h1 class="mt-3 text-center mb-1 text-info">Lista de movimientos</h1>
  <div class="form-row">
    <div class="form-group col-md-6">
      <label for="inputCity" class="text-light">Desde</label>
      <input type="date" class="form-control" id="Tama�oInput" name="txtDesde">
    </div>
 	<div class="form-group col-md-6">
      <label for="inputCity" class="text-light">Hasta</label>
      <input type="date" class="form-control" id="Tama�oInput" name="txtHasta">
    </div>
  </div>
  
<table class="table ">
  <thead class="thead-light">
    <tr >

      <th scope="col">Movimiento</th>
      <th scope="col">Fecha</th>
      <th scope="col">Monto</th>
    </tr>
  </thead>
  <tbody class="text-light">
    <tr >
      <td>Transferencia</td>
      <td>09/12/20</td>
      <td class="text-success"><b>-$1800</b></td>
      <td></td> 
    </tr>
       <tr>
      <td>Prestamos</td>
      <td>09/12/18</td>
      <td class="text-danger"><b>+$10000<b></td>
      <td></td> 
    </tr>
  </tbody>
</table>
</div>
</body>
</html>