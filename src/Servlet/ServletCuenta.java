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
			float saldo;
			SimpleDateFormat formatoDelTexto = new SimpleDateFormat("yyyy-MM-dd");
			LocalDate fechanueva= LocalDate.now();
			String fecha =fechanueva.toString();
			saldo=Float.parseFloat(request.getParameter("txtSaldo"));
			CuentaNegocio negocioCuenta=new CuentaNegocio();
			Persona user=new Persona();
			user=negocioCuenta.Obtener_usuario(request.getParameter("txtDNI"));
			cuenta.setNumeroCuenta(request.getParameter("NumeroCuenta"));
			cuenta.setCBU(request.getParameter("txtCBU"));
			cuenta.setSaldo(saldo);
			cuenta.setIdPersona(user);
			cuenta.setIdtipo(Integer.parseInt(request.getParameter("seleccionCuenta")));
			negocioCuenta.AgregarCuenta(cuenta,fecha);
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
			
			if(request.getParameter("btnVolver")!=null) {
				CuentaNegocio negocio=new CuentaNegocio();
			    ArrayList<Cuentas> lista =negocio.listaCuentas();
				request.setAttribute("listaCuenta", lista);
				RequestDispatcher rd = request.getRequestDispatcher("/ListarCuentasAdmin.jsp");   
		        rd.forward(request, response);
			}
	}
		
	
		
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		if(request.getParameter("btnDetalle_Cuenta")!=null) {
			int id =Integer.parseInt(request.getParameter("idCuenta"));
    		CuentaNegocio negocioCuenta =new CuentaNegocio();
    		Cuentas cuenta = new Cuentas();
    		cuenta =  negocioCuenta.BuscarCuentasXID(id);
    		request.setAttribute("cuenta", cuenta);	
			RequestDispatcher rd = request.getRequestDispatcher("/DetalleCuenta.jsp");
	        rd.forward(request, response);
		}
		
		
	}

}
