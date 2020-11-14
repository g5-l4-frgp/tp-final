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
		 cst.setString(8,usuario.getIdtipo());
		 cst.setInt(9, usuario.getDomicilio());
		 cst.setInt(10,usuario.getContacto());
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
			 cst.setString(2, direccion.getCalle());
			 cst.setString(1, direccion.getAltura());
			 cst.setString(3, direccion.getLocalidad());
			 cst.setString(4, direccion.getProvincia());
			 cst.execute();
		  }
		  catch (Exception e) {
			e.printStackTrace();
		}		
	}
	public void SP_AgregarContacto(Contacto contacto)
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
				CallableStatement st = cn.prepareCall("CALL SP_ListarUsuario");
				
				
				ResultSet resultado = st.executeQuery();
				/*  
	 select u.nickUsuario, u.DNI, u.nombre, u.apellido, u.contraseña, u.CUIL,
u.sexo, u.nacionalidad, u.fechaNacimiento, d.calle, d.altura, d.localidad, d.provincia, c.email, c.telefono  from usuario as u
inner join direccion as d on d.idDireccion=u.idDireccion
inner join contacto as c on c.idContacto = u.idContacto
where u.DNI = DniUsuario;
				 */
				while(resultado.next()){
					
					Direccion direccion = new Direccion();
					Contacto contacto = new Contacto();
					Persona aux = new Persona();
					aux.setNickUsuario(resultado.getString("nickUsuario"));
					aux.setDNI(resultado.getString("DNI"));
					aux.setNombre(resultado.getString("nombre"));
					aux.setApellido(resultado.getString("apellido"));
					aux.setPassword(resultado.getString("contraseña"));
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
					x.add(aux);
					
				}
				
			}
			catch(Exception e) {
				
				e.printStackTrace();
				
			}
			
			return x;
			
		}



}
