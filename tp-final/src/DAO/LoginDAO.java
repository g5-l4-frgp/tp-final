package DAO;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

import Entidad.Contacto;
import Entidad.Direccion;
import Entidad.Persona;

public class LoginDAO {
	private String host = "jdbc:mysql://localhost:3306/";
	private String user = "root";
	private String pass = "ROOT";
	private String dbName = "db_banco";
	
	
	public Persona BuscarUsuarioXNick(String Nick) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}			
			Connection cn = null;
			Persona usuario = new Persona();
			
			try {
				
				cn = DriverManager.getConnection(host+dbName, user,pass);
				CallableStatement st = cn.prepareCall("CALL SP_BuscarUsuarioxNick(?)");
				st.setString(1, Nick);
				
				ResultSet resultado = st.executeQuery();
				Direccion direccion = new Direccion();
				Contacto contacto = new Contacto();
				while(resultado.next()) {
					usuario.setID(resultado.getInt("idUsuario"));
					usuario.setDNI(resultado.getString("DNI"));
					usuario.setCuil(resultado.getString("CUIL"));
					usuario.setNombre(resultado.getString("nombre"));
					usuario.setApellido(resultado.getString("apellido"));
					usuario.setSexo(resultado.getString("sexo"));
					usuario.setIdtipo(resultado.getInt("TipoUsuario"));
					usuario.setNacionalidad(resultado.getString("nacionalidad"));
					usuario.setFecha(resultado.getDate("fechaNacimiento"));
					usuario.setNickUsuario(resultado.getString("nickUsuario"));
					usuario.setPassword(resultado.getString("Contraseña"));
					direccion.setCalle(resultado.getString("calle"));
					direccion.setAltura(resultado.getString("altura"));
					direccion.setLocalidad(resultado.getString("localidad"));
					direccion.setProvincia(resultado.getString("provincia"));
					contacto.setEmail(resultado.getString("email"));
					contacto.setTelefono(resultado.getString("telefono"));	
					usuario.setDireccion(direccion); 
					usuario.setContacto(contacto); 
				}
				
			}
			catch(Exception e) {
				
				e.printStackTrace();
				
			}
			
			return usuario;
	}

}
