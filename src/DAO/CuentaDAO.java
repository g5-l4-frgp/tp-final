package DAO;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;

import Dominio.Cuenta;
import Dominio.Usuario;


public class CuentaDAO {

	private String host = "jdbc:mysql://localhost:3306/";
	private String user = "root";
	private String pass = "root";
	private String dbName = "bdbanco";
	
	public CuentaDAO (){
		
	}
	
	public void AgregarCuenta (Cuenta cuenta) {
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
		}
		catch(ClassNotFoundException e)
		{
			e.printStackTrace();
		}
		String query="call SP_AltaCuenta(?,?,?,?)";
		Connection cn=null;
		try
		{
			cn= DriverManager.getConnection(host+dbName, user, pass);
			CallableStatement cst= cn.prepareCall(query);
			cst.setInt(1, cuenta.getTipoCuenta().getId());
			cst.setInt(2, cuenta.getUsuario().getId());
			cst.setInt(3, cuenta.getCBU());
			cst.setFloat(4,cuenta.getSaldo());
			cst.execute();
		}
		catch(Exception e)
		{
			e.printStackTrace();
			
		}
		
		
		
		
		
	}
	public void eliminarCuenta(int id) {
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
		}
		catch(ClassNotFoundException e)
		{
			e.printStackTrace();
		}
		String query="CALL SP_Eliminar(?)";
		Connection cn=null;
		try
		{
			cn= DriverManager.getConnection(host+dbName, user, pass);
			CallableStatement cst= cn.prepareCall(query);
			cst.setInt(1,id);
			cst.execute();
		}
		catch(Exception e)
		{
			e.printStackTrace();
			
		}
		
	}
	
	
}
