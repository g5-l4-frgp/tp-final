package DAO;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;

import Entidad.Prestamos;
import Entidad.Tranferencias;

public class TransferenciasDAO {
	private String host = "jdbc:mysql://localhost:3306/";
	private String user = "root";
	private String pass = "root";
	private String dbName = "db_banco";
	
	public void AltaTranferencia(Tranferencias tranferencia) {

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
			 CallableStatement cst = cn.prepareCall("CALL SP_AltaTransferencia(?,?,?,?,?,?)");
			 cst.setFloat(1, tranferencia.getImporte());
			 cst.setInt(2, tranferencia.getMovimiento().getIdMovimiento());
			 cst.setInt(3, tranferencia.getMovimientoDestino().getIdMovimiento());
			 cst.setInt(4, tranferencia.getCuentaDestino().getID());
			 cst.setInt(5, tranferencia.getCuenta().getID());
			 cst.setBoolean(6, tranferencia.getEstado());
			 cst.execute();   
		  }
		  catch (Exception e) {
			e.printStackTrace();
		  }
	}

}
