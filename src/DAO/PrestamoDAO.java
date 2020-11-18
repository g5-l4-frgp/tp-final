package DAO;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;

import Entidad.Prestamos;

public class PrestamoDAO {
	
	private String host = "jdbc:mysql://localhost:3306/";
	private String user = "root";
	private String pass = "root";
	private String dbName = "db_banco";
	
	public void AltaPrestamo(Prestamos prestamo, String fecha) {

		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Connection cn = null;
		  try
		  {
			  
			 cn = DriverManager.getConnection(host+dbName, user,pass);
			 CallableStatement cst = cn.prepareCall("CALL SP_AltaPrestamo(?,?,?,?,?,?,?,?,?,?)");
			 cst.setInt(1, prestamo.getIdPrestamo());
			 cst.setInt(2, prestamo.getCliente().getID());
			 cst.setInt(3, prestamo.getMovimiento().getIdMovimiento());
			 cst.setFloat(4, prestamo.getImporteConIntereses());
			 cst.setFloat(5, prestamo.getImportePedido());
			 cst.setInt(6, prestamo.getPlazoPago());
			 cst.setFloat(7, prestamo.getPagoMensual());
			 cst.setInt(8, prestamo.getCantidadCuotas());
			 cst.setInt(9, prestamo.getCuenta().getID());
			 cst.setInt(10, prestamo.getEstado());
			 cst.execute();   
		  }
		  catch (Exception e) {
			e.printStackTrace();
		  }
	}
	
	public void ModificarPrestamo(Prestamos prestamo) {
		

		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Connection cn = null;
		  try
		  {
			  
			 cn = DriverManager.getConnection(host+dbName, user,pass);
			 CallableStatement cst = cn.prepareCall("CALL SP_ModificarPrestamo(?,?)");
			 cst.setInt(1, prestamo.getIdPrestamo());
			 cst.setInt(2, prestamo.getEstado());
			 cst.execute();   
		  }
		  catch (Exception e) {
			e.printStackTrace();
		  }
		
	}

}
