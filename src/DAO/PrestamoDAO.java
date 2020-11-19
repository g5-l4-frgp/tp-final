package DAO;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.ArrayList;

import Entidad.Contacto;
import Entidad.Cuentas;
import Entidad.Direccion;
import Entidad.Persona;
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
			 CallableStatement cst = cn.prepareCall("CALL SP_AltaPrestamo(?,?,?,?,?,?,?,?)");
			 cst.setInt(1, prestamo.getIdPrestamo());
			 cst.setInt(2, prestamo.getCliente().getID());
			 cst.setInt(3, prestamo.getMovimiento().getIdMovimiento());
			 cst.setFloat(4, prestamo.getImporteConIntereses());
			 cst.setFloat(5, prestamo.getImportePedido());
			 cst.setFloat(6, prestamo.getPagoMensual());
			 cst.setInt(7, prestamo.getCantidadCuotas());
			 cst.setInt(8, prestamo.getEstado());
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
	public ArrayList<Prestamos> lista_Prestamos() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ArrayList<Prestamos> x = new ArrayList<Prestamos>();
			
			Connection cn = null;
			
			try {
				
				cn = DriverManager.getConnection(host+dbName, user,pass);
				CallableStatement st = cn.prepareCall("CALL SP_ListarPrestamos");
				ResultSet resultado = st.executeQuery();
				while(resultado.next()){
					Prestamos aux = new Prestamos();
					aux.setIdPrestamo(resultado.getInt("idPrestamo"));
					aux.getCliente().setID(resultado.getInt("idCliente"));
					aux.getCliente().setDNI(resultado.getString("DNI"));
					aux.getCuenta().setID(resultado.getInt("idCuenta"));
					aux.getMovimiento().setIdMovimiento(resultado.getInt("idMovimiento"));
					aux.setCantidadCuotas(resultado.getInt("cantidadCuotas"));
					aux.setEstado(resultado.getInt("estado"));
					aux.setFechaSoli(resultado.getDate("fechapedido"));
					aux.setImporteConIntereses(resultado.getFloat("importeConIntereses"));
					aux.setPagoMensual(resultado.getFloat("pagoMesual"));
					aux.setImportePedido(resultado.getFloat("importePedido")); 
					x.add(aux);
					
				}
				
			}
			catch(Exception e) {
				
				e.printStackTrace();
				
			}
			
			return x;
			
		}
		public Prestamos SP_BuscarPrestamoxId(int id) {
			try {
				Class.forName("com.mysql.jdbc.Driver");
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}			
				Connection cn = null;
				Prestamos aux = new Prestamos();
				
				try {
					
					cn = DriverManager.getConnection(host+dbName, user,pass);
					CallableStatement st = cn.prepareCall("CALL SP_BuscarPrestamoxId(?)");
					st.setInt(1, id);
					
					ResultSet resultado = st.executeQuery();
					while(resultado.next()) {
						
						aux.setIdPrestamo(resultado.getInt("idPrestamo"));
						aux.getCliente().setID(resultado.getInt("idCliente"));
						aux.getCliente().setDNI(resultado.getString("DNI"));
						aux.getCliente().setApellido(resultado.getString("apellido"));
						aux.getCliente().setNombre(resultado.getString("nombre"));
						aux.getCuenta().setID(resultado.getInt("idCuenta"));
						aux.getCuenta().setNumeroCuenta(resultado.getString("Numerocuenta"));
						aux.getMovimiento().setIdMovimiento(resultado.getInt("idMovimiento"));
						aux.setCantidadCuotas(resultado.getInt("cantidadCuotas"));
						aux.setEstado(resultado.getInt("estado"));
						aux.setFechaSoli(resultado.getDate("fechapedido"));
						aux.setImporteConIntereses(resultado.getFloat("importeConIntereses"));
						aux.setPagoMensual(resultado.getFloat("pagoMesual"));
						aux.setImportePedido(resultado.getFloat("importePedido"));
						
					}
					
				}
				catch(Exception e) {
					
					e.printStackTrace();
					
				}
				
				return aux;
		}


}
