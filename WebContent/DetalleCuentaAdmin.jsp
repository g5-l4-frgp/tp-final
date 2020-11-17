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
 	}
 	.fila{
 	width: 30%;
 	}
 	.Mover
 	{
 	
		margin-right: 20px;
		margin-top: 5px;
 	}
 	.boton{
 	width: 100%;
 	}
 	#Filtrar
 	{
 	
 	width: 20%;
 	margin-left: 59%;
 	}
    #Fondo{
        background-color:#020648;
     }
</Style>
<title>Detalle de cuentas</title>
</head>
<body id="Fondo">
<jsp:include page="MenuAdmin.html"></jsp:include>
<div class="container">
<h1 class="mt-3 text-center mb-1 text-info">Detalle cuenta admin</h1>
<form action="Controlador" method="get" class="Alta">
  <div class="form-row">
    <div class="form-group col-md-6">
      <label for="inputEmail4">Numero de cuenta</label>
 <input type="text" class="form-control" id="inputEmail"readonly name="txtNumero">
    </div>
    <div class="form-group col-md-6">
      <label for="inputPassword4">Tipo de cuenta</label>
<input type="text" class="form-control"id="inputEmail"readonly name="txtTipo">
    </div>
  </div>
    <div class="form-row">
    <div class="form-group col-md-6">
      <label for="inputEmail4">CBU</label>
 <input type="text" class="form-control"id="inputEmail"readonly name="txtCBU">
    </div>
    <div class="form-group col-md-6">
      <label for="inputPassword4">Nombre</label>
<input type="text" class="form-control"id="inputEmail"readonly name="txtNombre">
    </div>
  </div>
    <div class="form-row">
    <div class="form-group col-md-6">
      <label for="inputEmail4">Apellido</label>
<input type="text" class="form-control"id="inputEmail"readonly name="txtApellido">
    </div>
    <div class="form-group col-md-6">
      <label for="inputPassword4">DNI</label>
     <input type="text" class="form-control"id="inputEmail"readonly name="txtDNI">
    </div>
  </div>
    <div class="form-row">
    <div class="form-group col-md-4">
      <label for="inputEmail4">CUIL</label>
 <input type="text" class="form-control"id="inputEmail"readonly name="txtCuil">
    </div>
    
        </div>
      
        <div class="form-row">
    <div class="form-group col-md-6">
      <label for="inputCity">Saldo</label>
<input type="text" class="form-control"id="inputEmail"readonly name="txtSaldo">
    </div>

  </div>
        <button type="submit" class="btn btn-primary crear" name="btnVolver">Volver</button>
</form>
</div>
<body>

</body>
</html>