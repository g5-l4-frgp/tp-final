package DAO;

import java.awt.datatransfer.FlavorEvent;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import Entidad.Contacto;
import Entidad.Cuentas;
import Entidad.Direccion;
import Entidad.Persona;
import sun.util.locale.provider.AuxLocaleProviderAdapter;;


public class CuentaDAO {

	private String host = "jdbc:mysql://localhost:3306/";
	private String user = "root";
	private String pass = "root";
	private String dbName = "db_banco";
	
	public CuentaDAO (){
		
	}
	
	public void AgregarCuenta (Cuentas cuenta,String fecha) {
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
		}
		catch(ClassNotFoundException e)
		{
			e.printStackTrace();
		}
		String query="call SP_AltaCuenta(?,?,?,?,?,?,?)";
		Connection cn=null;
		try
		{
			cn= DriverManager.getConnection(host+dbName, user, pass);
			CallableStatement cst= cn.prepareCall(query);
			cst.setString(1, cuenta.getIdtipo());
			cst.setInt(2, cuenta.getIdPersona().getID());
			cst.setString(3, cuenta.getCBU());
			cst.setString(4, cuenta.getNumeroCuenta());
			cst.setFloat(5,cuenta.getSaldo());
			cst.setDate(6, java.sql.Date.valueOf(fecha));
			cst.setBoolean(7,cuenta.isEstado());
			cst.execute();
		}
		catch(Exception e)
		{
			e.printStackTrace();
			
		}
		
		
	}
	public void eliminarCuenta(int idcuenta) {
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
		}
		catch(ClassNotFoundException e)
		{
			e.printStackTrace();
		}
		String query="CALL SP_EliminarCuenta(?)";
		Connection cn=null;
		try
		{
			cn= DriverManager.getConnection(host+dbName, user, pass);
			CallableStatement cst= cn.prepareCall(query);
			cst.setInt(1,idcuenta);
			cst.execute();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	public ArrayList<Cuentas> listaCuentas() {
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ArrayList<Cuentas> x = new ArrayList<Cuentas>();
			
			Connection cn = null;
			
			try {
				
				cn = DriverManager.getConnection(host+dbName, user,pass);
				CallableStatement st = cn.prepareCall("CALL SP_ListarCuentas");
				
				ResultSet resultado = st.executeQuery();
				/*  
				c.idTipo, c.idUsuario, c.Numerocuenta, c.CBU, c.saldo , c.fechaCreacion, u.nombre, u.apellido from cuentas
				 */
				while(resultado.next()){
					Cuentas aux = new Cuentas();
					aux.setIdtipo(Integer.parseInt(resultado.getString("idTipo")));
					aux.getIdPersona().setID(Integer.parseInt(resultado.getString("idUsuario")));
					aux.setNumeroCuenta((resultado.getString("Numerocuenta")));
					aux.setCBU(resultado.getString("CBU"));
					aux.setSaldo(Float.parseFloat(resultado.getString("saldo")));
					aux.setFechaCreacion(resultado.getDate("fechaCreacion"));
					aux.getIdPersona().setNombre(resultado.getString("nombre"));
					aux.getIdPersona().setApellido(resultado.getString("apellido"));
					x.add(aux);
				}
				
			}
			catch(Exception e) {
				
				e.printStackTrace();
				
			}
			
			return x;
			
		}

	public Persona Obtener_usuario (String dni) {
		
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Persona aux = new Persona();
			Direccion direccion = new Direccion();
			Contacto contacto = new Contacto();
			Connection cn = null;
			
			try {
				
				cn = DriverManager.getConnection(host+dbName, user,pass);
				CallableStatement st = cn.prepareCall("CALL SP_BuscarUsuario(?)");
				 st.setString(1, dni);
				 

				ResultSet resultado = st.executeQuery();

				while(resultado.next()){
					aux.setNickUsuario(resultado.getString("nickUsuario"));
					aux.setDNI(resultado.getString("DNI"));
					aux.setNombre(resultado.getString("nombre"));
					aux.setApellido(resultado.getString("apellido"));
					aux.setCuil(resultado.getString("CUIL"));
					aux.setSexo(resultado.getString("sexo"));
					aux.setNacionalidad(resultado.getString("nacionalidad"));
					aux.setFecha(resultado.getDate("fechaNacimiento"));
					direccion.setCalle(resultado.getString("calle"));
					direccion.setAltura(resultado.getString("altura"));
					direccion.setLocalidad(resultado.getString("localidad"));
					direccion.setProvincia(resultado.getString("provincia"));
					contacto.setEmail(resultado.getString("email"));
					contacto.setTelefono(resultado.getString("telefono"));	
					aux.setDireccion(direccion); 
					aux.setContacto(contacto); 		
					
				}
					
				
			}
			catch(Exception e) {
				
				e.printStackTrace();
				
			}
			
			return aux;
			
		}


	

	
	
}
