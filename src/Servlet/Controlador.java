package Servlet;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.DAO_Personas;
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
    	        RequestDispatcher rd = request.getRequestDispatcher("/AltaCliente.jsp");   
    	        rd.forward(request, response);   
    		 }
    		
    	
    	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
