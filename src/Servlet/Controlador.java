package Servlet;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.DAO_Personas;
import Negocio.CuentaNegocio;
import Negocio.Persona_Negocio;
import Entidad.Contacto;
import Entidad.Cuentas;
import Entidad.Direccion;
import Entidad.Persona;

/**
 * Servlet implementation class Controlador
 */
@WebServlet("/Controlador")
public class Controlador extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Controlador() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		Persona persona = new Persona();
		Direccion direccion= new Direccion();
		Contacto contacto= new Contacto();
		Persona_Negocio negocio=new Persona_Negocio();
			
		if(request.getParameter("Param1")!=null) {
			
			   
		    ArrayList<Persona> lista =negocio.lista_usuarios();
		    
			request.setAttribute("lista", lista);
						
			RequestDispatcher rd = request.getRequestDispatcher("/ListarClientesAdmin.jsp");   
	        rd.forward(request, response);
			
		}
			
    	if(request.getParameter("btnAceptar")!=null)
		{
			Persona usuario = new Persona();
			SimpleDateFormat formatoDelTexto = new SimpleDateFormat("yyyy-MM-dd");
			String sexo="N";
			String fecha  = request.getParameter("txtFechaNacimiento");
		
			if(Integer.parseInt(request.getParameter("ddlSexo"))==1) {
				sexo = "F";
			}
			else {sexo = "M";}
	        usuario.setEstado(true);
	        usuario.setDNI(request.getParameter("txtDni"));
	        usuario.setCuil(request.getParameter("txtCuil"));
	        usuario.setNombre(request.getParameter("txtNombre"));
	        usuario.setApellido(request.getParameter("txtApellido"));
			usuario.setNickUsuario(request.getParameter("txtUsuario"));
			usuario.setSexo(sexo);
	        usuario.setPassword(request.getParameter("txtPassword"));
	        usuario.setNacionalidad(request.getParameter("txtNacionalidad"));
	        usuario.setEstado(true);
	        usuario.setIdtipo(2);
			contacto.setEmail(request.getParameter("txtEmail"));
	        contacto.setTelefono(request.getParameter("txtTelefono"));
	        direccion.setAltura(request.getParameter("txtAltura"));
	        direccion.setCalle(request.getParameter("txtCalle"));
	        direccion.setLocalidad(request.getParameter("txtLocalidad"));
	        direccion.setProvincia(request.getParameter("txtProvincia"));
	        negocio.AgregarContacto(contacto);
	        negocio.SP_AgregarDireccion(direccion);
	        direccion= negocio.buscarDireccion();
	        contacto=negocio.buscarContacto();
	        direccion.setID(direccion.getID());
	        contacto.setID(contacto.getID());
	        usuario.setContacto(contacto);
	        usuario.setDomicilio(direccion);
	        negocio.SPAltaUsuario(usuario,fecha);
	        Date fechanueva= new Date();
	        Cuentas cuenta = new Cuentas(0,usuario,fechanueva,10000);
	        request.setAttribute("usuario",usuario);
	        request.setAttribute("cuenta",cuenta);
	        RequestDispatcher rd = request.getRequestDispatcher("/AltaCuenta.jsp");   
	        rd.forward(request, response);   
		 }
    	
    	if(request.getParameter("btnDetalleCliente")!=null) {
			int id =Integer.parseInt(request.getParameter("idUsuario"));
		    Persona_Negocio persona_Negocio = new Persona_Negocio();
		    Persona usuario = new Persona();
		    CuentaNegocio negociocuenta=new CuentaNegocio();
		    ArrayList<Cuentas> lista =negociocuenta.listaCuentasXid(id);
			request.setAttribute("listaCuenta", lista);
		    usuario = persona_Negocio.BuscarUsuarioXID(id);
			request.setAttribute("usuario", usuario);	
			RequestDispatcher rd = request.getRequestDispatcher("/ModificarCliente.jsp");   
	        rd.forward(request, response);
		}
    	if(request.getParameter("btnAceptar_modificar")!=null) {
    		Persona usuario = new Persona();
			SimpleDateFormat formatoDelTexto = new SimpleDateFormat("yyyy-MM-dd");
			String sexo="N";
			LocalDate todayDate = LocalDate.now();
			//String fecha  = todayDate.toString();
			String fecha = request.getParameter("fechaNacimiento");
			if(Integer.parseInt(request.getParameter("sexo"))==1) {
				sexo = "F";
			}
			else {sexo = "M";}
	        usuario.setEstado(true);
	        usuario.setDNI(request.getParameter("dni"));
	        usuario.setCuil(request.getParameter("cuil"));
	        usuario.setNombre(request.getParameter("nombre"));
	        usuario.setApellido(request.getParameter("apellido"));
			usuario.setNickUsuario(request.getParameter("usuario"));
			usuario.setSexo(sexo);
	        usuario.setPassword(request.getParameter("contraseña"));
	        usuario.setNacionalidad(request.getParameter("nacionalidad"));
	        usuario.setEstado(true);
	        usuario.setIdtipo(2);
			contacto.setEmail(request.getParameter("email"));
	        contacto.setTelefono(request.getParameter("telefono"));
	        direccion.setAltura(request.getParameter("altura"));
	        direccion.setCalle(request.getParameter("calle"));
	        direccion.setLocalidad(request.getParameter("localidad"));
	        direccion.setProvincia(request.getParameter("provincia"));
	        negocio.AgregarContacto(contacto);
	        negocio.SP_AgregarDireccion(direccion);
	        direccion= negocio.buscarDireccion();
	        contacto=negocio.buscarContacto();
	        direccion.setID(direccion.getID());
	        contacto.setID(contacto.getID());
	        usuario.setContacto(contacto);
	        usuario.setDomicilio(direccion);
	        negocio.ModificarUsuario(usuario,fecha);  
	        ArrayList<Persona> lista = negocio.lista_usuarios();
			request.setAttribute("lista", lista);		
			RequestDispatcher rd = request.getRequestDispatcher("/ListarClientesAdmin.jsp");   
	        rd.forward(request, response);
			
		}
    	if(request.getParameter("btnCancelar_modificar")!=null) {
    		ArrayList<Persona> lista = negocio.lista_usuarios();
			request.setAttribute("lista", lista);		
			RequestDispatcher rd = request.getRequestDispatcher("/ListarClientesAdmin.jsp");   
	        rd.forward(request, response);
    	}
    	if(request.getParameter("btnCrearUsuario")!=null) {
			RequestDispatcher rd = request.getRequestDispatcher("/AltaCliente.jsp");
	        rd.forward(request, response);
    	}
    	if(request.getParameter("btnCrearCuenta")!=null) {
    		int id =Integer.parseInt(request.getParameter("idUsuario"));
    		Persona_Negocio negocio2=new Persona_Negocio();
    		Persona usuario= new Persona();
    		usuario=negocio2.BuscarUsuarioXID(id);
    		request.setAttribute("usuario", usuario);	
			RequestDispatcher rd = request.getRequestDispatcher("/AltaCuenta.jsp");
	        rd.forward(request, response);
	        
    	}
    	if(request.getParameter("btnDetalle_Cuenta")!=null) {
    		int id =Integer.parseInt(request.getParameter("idUsuario"));
    		Persona_Negocio negocio2=new Persona_Negocio();
    		Persona usuario= new Persona();
    		usuario=negocio2.BuscarUsuarioXID(id);
    		request.setAttribute("usuario", usuario);	
			RequestDispatcher rd = request.getRequestDispatcher("/DetalleCuenta.jsp");
	        rd.forward(request, response);
    	}
    	
    	
    }
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		Persona persona = new Persona();
		Direccion direccion= new Direccion();
		Contacto contacto= new Contacto();
		Persona_Negocio negocio=new Persona_Negocio();
		if(request.getParameter("btnEliminarCliente")!=null) {
			int id =Integer.parseInt(request.getParameter("idUsuario"));
		    Persona_Negocio persona_Negocio = new Persona_Negocio();
		    persona_Negocio.EliminarUsuario(id);
		    ArrayList<Persona> lista =negocio.lista_usuarios();
			request.setAttribute("lista", lista);		
			RequestDispatcher rd = request.getRequestDispatcher("/ListarClientesAdmin.jsp");   
	        rd.forward(request, response);
			
		}
	}

}
