package Servlet;

import java.io.IOException;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sun.org.apache.xpath.internal.operations.Neg;

import Entidad.Cuentas;
import Entidad.Persona;
import Negocio.CuentaNegocio;
import Negocio.Persona_Negocio;

/**
 * Servlet implementation class ServletCuenta
 */
@WebServlet("/ServletCuenta")
public class ServletCuenta extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public ServletCuenta() {

    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		if(request.getParameter("Param2")!=null) {
			
			   CuentaNegocio negocio=new CuentaNegocio();
		    ArrayList<Cuentas> lista =negocio.listaCuentas();
			request.setAttribute("listaCuenta", lista);
						
			RequestDispatcher rd = request.getRequestDispatcher("/ListarCuentasAdmin.jsp");   
	        rd.forward(request, response);
			
				}
		if(request.getParameter("btnAceptar")!=null) {
			Cuentas cuenta=new Cuentas();
			String tipoCuenta=" ";
			String DNIusuario= null;
			int idCuenta= 0;
			float saldo=0;
			SimpleDateFormat formatoDelTexto = new SimpleDateFormat("yyyy-MM-dd");
			LocalDate fechanueva= LocalDate.now();
			String fecha =fechanueva.toString();
			DNIusuario=request.getParameter("txtDNI");
			saldo=Integer.parseInt(request.getParameter("txtSaldo"));
			CuentaNegocio negocio=new CuentaNegocio();
			Persona_Negocio negocio2= new Persona_Negocio();
			Persona user=new Persona();
			user=negocio.Obtener_usuario(DNIusuario);
			cuenta.setNumeroCuenta(request.getParameter("NumeroCuenta"));
			cuenta.setCBU(request.getParameter("txtCBU"));
			cuenta.setSaldo(saldo);
			cuenta.setIdPersona(user);
			cuenta.setIdtipo(Integer.parseInt(request.getParameter("seleccionCuenta")));
			negocio.AgregarCuenta(cuenta,fecha);
			RequestDispatcher rd=request.getRequestDispatcher("AltaCuenta.jsp");  	  
	 		rd.forward(request, response);
		}
			if(request.getParameter("btnEliminar")!=null) {
				int id =Integer.parseInt(request.getParameter("idCuenta"));
				   CuentaNegocio Negocio = new CuentaNegocio();
				   Negocio.eliminarCuenta(id);
				   ArrayList<Cuentas> lista =Negocio.listaCuentas();
				request.setAttribute("listaCuentas", lista);
				RequestDispatcher rd = request.getRequestDispatcher("/ListarCuentasAdmin.jsp");  
				       rd.forward(request, response);
		}
			if(request.getParameter("btnDetalle_Cuenta")!=null) {
				int id =Integer.parseInt(request.getParameter("idCuenta"));
			    CuentaNegocio Negocio = new CuentaNegocio();
			    Cuentas cuenta= Negocio.BuscarCuentasXID(id);
			    Persona usuario = new Persona();
			    Persona_Negocio perneg=new Persona_Negocio();
			    usuario=perneg.BuscarUsuarioXID(cuenta.getIdPersona().getID());
				request.setAttribute("cuenta", cuenta);
				request.setAttribute("usuario", usuario);		
				RequestDispatcher rd = request.getRequestDispatcher("/DetalleCuenta.jsp");   
		        rd.forward(request, response);
			}
			if(request.getParameter("btnVolver")!=null) {
				CuentaNegocio negocio=new CuentaNegocio();
			    ArrayList<Cuentas> lista =negocio.listaCuentas();
				request.setAttribute("listaCuenta", lista);
				RequestDispatcher rd = request.getRequestDispatcher("/ListarCuentasAdmin.jsp");   
		        rd.forward(request, response);
			}
	}
		
	
		
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	
		
		
	}

}
