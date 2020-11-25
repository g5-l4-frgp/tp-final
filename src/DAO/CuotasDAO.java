package DAO;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import Entidad.Cuotas;

public class CuotasDAO {
	

	private String host = "jdbc:mysql://localhost:3306/";
	private String user = "root";
	private String pass = "root";
	private String dbName = "db_banco";
	
	public CuotasDAO (){
		
	}
	
	public void AgregarCuota (Cuotas cuota,String fechavenc) {
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
		}
		catch(ClassNotFoundException e)
		{
			e.printStackTrace();
		}
		String query="call SP_AltaCuotas(?,?,?,?,?)";
		Connection cn=null;
		try
		{
			cn= DriverManager.getConnection(host+dbName, user, pass);
			CallableStatement cst= cn.prepareCall(query);
			cst.setInt(1, cuota.getPrestamo().getIdPrestamo());
			cst.setString(2, cuota.getFechaMes());
			cst.setFloat(3, cuota.getImporte());
			cst.setDate(4, java.sql.Date.valueOf(fechavenc));
			cst.setInt(5,cuota.getEstado());
			cst.execute();
		}
		catch(Exception e)
		{
			e.printStackTrace();
			
		}

}
}
