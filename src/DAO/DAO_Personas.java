package DAO;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.ArrayList;
import Entidad.Contacto;
import Entidad.Direccion;
import Entidad.Persona;

public class DAO_Personas {
	
	private String host = "jdbc:mysql://localhost:3306/";
	private String user = "root";
	private String pass = "root";
	private String dbName = "db_banco";
	
	public void SPAltaUsuario(Persona usuario, String fecha)
	{
		
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
		 CallableStatement cst = cn.prepareCall("CALL SP_AgregarUsuario(?,?,?,?,?,?,?,?,?,?,?,?,?)");
		 cst.setString(1, usuario.getDNI());
		 cst.setString(2, usuario.getCuil());
		 cst.setString(3, usuario.getNombre());
		 cst.setString(4, usuario.getApellido());
		 cst.setString(5, usuario.getSexo());
		 cst.setString(6, usuario.getNacionalidad());
		 cst.setDate(7, java.sql.Date.valueOf(fecha));
		 cst.setInt(8,usuario.getIdtipo());
		 cst.setInt(9, usuario.getDomicilio().getID());
		 cst.setInt(10,usuario.getContacto().getID());
		 cst.setString(11, usuario.getNickUsuario());
		 cst.setString(12, usuario.getPassword());
		 cst.setBoolean(13, usuario.getEstado());
		 cst.execute();   
	  }
	  catch (Exception e) {
		e.printStackTrace();
	  }
		
	}
	
	public void SP_AgregarDireccion(Direccion direccion)
	{
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
			 CallableStatement cst = cn.prepareCall("CALL SP_AgregarDireccion(?,?,?,?)");
			 cst.setString(1, direccion.getCalle());
			 cst.setString(2, direccion.getAltura());
			 cst.setString(3, direccion.getLocalidad());
			 cst.setString(4, direccion.getProvincia());
			 cst.execute();
		  }
		  catch (Exception e) {
			e.printStackTrace();
		}		
	}
	public void AgregarContacto(Contacto contacto)
	{
		
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
			 CallableStatement cst = cn.prepareCall("CALL SP_AgregarContacto(?,?)");
			 cst.setString(1, contacto.getEmail());
			 cst.setString(2, contacto.getTelefono());
			 cst.execute();
		  }
		  catch (Exception e) {
			e.printStackTrace();
		}
			
	}
	public ArrayList<Persona> lista_usuarios() {
		
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ArrayList<Persona> x = new ArrayList<Persona>();
			
			Connection cn = null;
			
			try {
				
				cn = DriverManager.getConnection(host+dbName, user,pass);
				CallableStatement st = cn.prepareCall("CALL SP_ListarClientes");
				
				
				ResultSet resultado = st.executeQuery();
				while(resultado.next()){
					
					Direccion direccion = new Direccion();
					Contacto contacto = new Contacto();
					Persona aux = new Persona();
					aux.setID(resultado.getInt("idUsuario"));
					aux.setDNI(resultado.getString("DNI"));
					aux.setCuil(resultado.getString("CUIL"));
					aux.setNombre(resultado.getString("nombre"));
					aux.setApellido(resultado.getString("apellido"));
					aux.setSexo(resultado.getString("sexo"));
					aux.setNacionalidad(resultado.getString("nacionalidad"));
					aux.setFecha(resultado.getDate("fechaNacimiento"));
					aux.setNickUsuario(resultado.getString("nickUsuario"));
					direccion.setCalle(resultado.getString("calle"));
					direccion.setAltura(resultado.getString("altura"));
					direccion.setLocalidad(resultado.getString("localidad"));
					direccion.setProvincia(resultado.getString("provincia"));
					contacto.setEmail(resultado.getString("email"));
					contacto.setTelefono(resultado.getString("telefono"));	
					aux.setDireccion(direccion); 
					aux.setContacto(contacto); 
					x.add(aux);
					
				}
				
			}
			catch(Exception e) {
				
				e.printStackTrace();
				
			}
			
			return x;
			
		}

	public Contacto buscarContacto() {
		
		Connection cn = null;
		
		Contacto aux = new Contacto();
		try {
			
			cn = DriverManager.getConnection(host+dbName, user,pass);
			CallableStatement st = cn.prepareCall("CALL SP_BuscarContacto");
			
			
			ResultSet resultado = st.executeQuery();

			while(resultado.next()){
				aux.setID(resultado.getInt("idContacto"));	
					
			}
			
		}
		catch(Exception e) {
			
			e.printStackTrace();
			
		}
		
		return aux;
	}	
	

	public Direccion buscarDireccion() {
		Connection cn = null;
		
		Direccion aux = new Direccion();
		try {
			
			cn = DriverManager.getConnection(host+dbName, user,pass);
			CallableStatement st = cn.prepareCall("CALL SP_BuscarDireccion");
			
			
			ResultSet resultado = st.executeQuery();
			while(resultado.next()){
				
				aux.setID(resultado.getInt("idDireccion"));
		
					
			}
			
		}
		catch(Exception e) {
			
			e.printStackTrace();
			
		}
		
		return aux;
	}
	
	public void EliminarUsuario(int idUsuario) {
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
			 CallableStatement cst = cn.prepareCall("CALL SP_EliminarUsuario(?)");
			 cst.setInt(1, idUsuario);
			 cst.execute();
		  }
		  catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	public void ModificarUsuario(Persona usuario, String fecha)
	{
		
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
		 CallableStatement cst = cn.prepareCall("CALL SP_ModificarUsuario(?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
		 cst.setInt(1, usuario.getID());
		 cst.setString(2, usuario.getDNI());
		 cst.setString(3, usuario.getCuil());
		 cst.setString(4, usuario.getNombre());
		 cst.setString(5, usuario.getApellido());
		 cst.setString(6, usuario.getSexo());
		 cst.setString(7, usuario.getNacionalidad());
		 cst.setDate(8, java.sql.Date.valueOf(fecha));
		 cst.setInt(9, usuario.getIdtipo());
		 cst.setInt(10, usuario.getDomicilio().getID());
		 cst.setInt(11,usuario.getContacto().getID());
		 cst.setString(12, usuario.getNickUsuario());
		 cst.setString(13, usuario.getPassword());
		 cst.setBoolean(14, usuario.getEstado());
		 cst.execute();   
	  }
	  catch (Exception e) {
		e.printStackTrace();
	  }
		
	}
	public Persona BuscarUsuarioXID(int id) {
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
				CallableStatement st = cn.prepareCall("CALL SP_BuscarUsuarioxId(?)");
				st.setInt(1, id);
				
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
					usuario.setNacionalidad(resultado.getString("nacionalidad"));
					usuario.setFecha(resultado.getDate("fechaNacimiento"));
					usuario.setNickUsuario(resultado.getString("nickUsuario"));
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
