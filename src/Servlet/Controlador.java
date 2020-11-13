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
import Entidad.TipoUsuario;
import Negocio.Persona_Negocio;
import Entidad.Contacto;
import Entidad.Cuentas;
import Entidad.TipoCuenta;
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
		TipoUsuario tipoUsuario= new TipoUsuario();
		Direccion direccion= new Direccion();
		DAO_Personas dao_Personas = new DAO_Personas();
		Contacto contacto= new Contacto();
		Persona_Negocio perNeg=new Persona_Negocio();
			
		if(request.getParameter("Param1")!=null) {
			
			   
		    ArrayList<Persona> lista =perNeg.lista_usuarios();
		    
			request.setAttribute("listaU", lista);
						
			RequestDispatcher rd = request.getRequestDispatcher("/ListarClientesAdmin.jsp");   
	        rd.forward(request, response);
			
				}
			
        	if(request.getParameter("btnAceptar")!=null)
    		{
    			Persona usuario = new Persona();
    			SimpleDateFormat formatoDelTexto = new SimpleDateFormat("yyyy-MM-dd");
    			Persona_Negocio persNeg=new Persona_Negocio(); 
    			String sexo="N";
    			String fecha  = request.getParameter("txtFechaNacimiento");
    		
    			if(Integer.parseInt(request.getParameter("ddlSexo"))==1) {
    				sexo = "F";
    			}
    			else {sexo = "M";}
    			
    		   
    	        usuario.setEstado(true);
    	        
    	        usuario.setSexo(sexo);
    			usuario.setNickUsuario(request.getParameter("txtUsuario"));
    			usuario.setDNI(request.getParameter("txtDni"));
    	        usuario.setNombre(request.getParameter("txtNombre"));
    	        usuario.setApellido(request.getParameter("txtApellido"));
    	        usuario.setPassword(request.getParameter("txtPassword"));
    	        usuario.setCuil(request.getParameter("txtCuil"));
    	        usuario.setNacionalidad(request.getParameter("txtNacionalidad"));
    	        usuario.setEstado(true);
    	        tipoUsuario.setNombre("user");
    	        usuario.setIdtipo(tipoUsuario);
				contacto.setEmail(request.getParameter("txtEmail"));
    	        contacto.setTelefono(request.getParameter("txtTelefono"));
    	        direccion.setAltura(request.getParameter("txtAltura"));
    	        direccion.setCalle(request.getParameter("txtCalle"));
    	        direccion.setLocalidad(request.getParameter("txtLocalidad"));
    	        direccion.setProvincia(request.getParameter("txtProvincia"));
    	        direccion.setID(2);
    	        contacto.setID(2);
    	        persNeg.SP_AgregarDireccion(direccion);
    	        persNeg.SP_AgregarContacto(contacto);
    	        usuario.setContacto(contacto);
    	        usuario.setDomicilio(direccion);
    	        persNeg.SPAltaUsuario(usuario,fecha);
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
