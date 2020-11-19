package Servlet;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sun.jndi.url.iiopname.iiopnameURLContextFactory;

import Entidad.Cuentas;
import Entidad.Movimiento;
import Entidad.Persona;
import Entidad.Prestamos;
import Negocio.CuentaNegocio;
import Negocio.Persona_Negocio;
import Negocio.PrestamosNegocio;

/**
 * Servlet implementation class ServletPrestamos
 */
@WebServlet("/ServletPrestamos")
public class ServletPrestamos extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public ServletPrestamos() {
        super();
        
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
		
		
		if(request.getParameter("Param4")!=null) {
			
			  PrestamosNegocio negocio =new PrestamosNegocio();
		    ArrayList<Prestamos> lista =negocio.lista_Prestamos();
			request.setAttribute("listaPrestamos", lista);
			
			RequestDispatcher rd = request.getRequestDispatcher("/ListadoPrestamosAdmin.jsp");   
	        rd.forward(request, response);
			
				}
		
		if(request.getParameter("btnAceptar")!=null) {
			
			Persona usuario=new Persona();
			Cuentas cuenta=new Cuentas();
			Prestamos prestamo=new Prestamos();
			Movimiento movimiento = new Movimiento();
			Persona_Negocio negocioper= new Persona_Negocio();
			CuentaNegocio negociocuenta= new CuentaNegocio();
			PrestamosNegocio negocioprestamo= new PrestamosNegocio();
			int idcuenta=Integer.parseInt(request.getParameter("selectCuenta"));
			cuenta=negociocuenta.BuscarCuentasXID(idcuenta);
			prestamo.setCliente(usuario);
		    prestamo.setCuenta(cuenta);
			prestamo.setMovimiento(movimiento);
			float monto=0;
			monto=Float.parseFloat(request.getParameter("txtMonto"));
			prestamo.setImportePedido(monto);
			int cant=0;
			cant=Integer.parseInt(request.getParameter("selectCuotas"));
			prestamo.setCantidadCuotas(cant);
			SimpleDateFormat formatoDelTexto = new SimpleDateFormat("yyyy-MM-dd");
			LocalDate fechanueva= LocalDate.now();
			String fecha =fechanueva.toString();
			negocioprestamo.AltaPrestamo(prestamo, fecha);
			RequestDispatcher rd = request.getRequestDispatcher("/PrestamosCliente.jsp");   
	        rd.forward(request, response);
			
				}
			if(request.getParameter("btnSolicitud")!=null) {
				
				int idprestamo=Integer.parseInt(request.getParameter("idPrestamo"));
				Prestamos prestamos= new Prestamos();
				PrestamosNegocio negocio=new PrestamosNegocio();
				prestamos=negocio.SP_BuscarPrestamoxId(idprestamo);
				request.setAttribute("Prestamo", prestamos);
				RequestDispatcher rd = request.getRequestDispatcher("/PrestamoAdmin.jsp");   
		        rd.forward(request, response);
				}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}
