package Servlet;


import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sun.jndi.url.iiopname.iiopnameURLContextFactory;
import com.sun.org.apache.bcel.internal.generic.NEW;

import Entidad.Cuentas;
import Entidad.Cuotas;
import Entidad.Movimiento;
import Entidad.Persona;
import Entidad.Prestamos;
import Negocio.CuentaNegocio;
import Negocio.CuotaNegocio;
import Negocio.Persona_Negocio;
import Negocio.PrestamosNegocio;
import javafx.scene.control.Alert;

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
		if(request.getParameter("Param8")!=null) {
			HttpSession misession= (HttpSession) request.getSession();
			 
			Persona usuario= (Persona) misession.getAttribute("usuario");
			  PrestamosNegocio negocio =new PrestamosNegocio();
			    ArrayList<Prestamos> lista =negocio.SP_BuscarPrestamoxIdUsuario(usuario.getID());
				request.setAttribute("listaPrestamos", lista);
			RequestDispatcher rd = request.getRequestDispatcher("/MisPrestamosCliente.jsp");   
	        rd.forward(request, response);
			
				}
		if(request.getParameter("Param7")!=null) {
			HttpSession misession= (HttpSession) request.getSession();
			 
			Persona usuario= (Persona) misession.getAttribute("usuario");
			CuentaNegocio negociocuenta=new CuentaNegocio();
		    ArrayList<Cuentas> lista =negociocuenta.listaCuentasXid(usuario.getID());
			request.setAttribute("listaCuenta", lista);
			RequestDispatcher rd = request.getRequestDispatcher("/PrestamoCliente.jsp");   
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
			float monto2 =(float)monto/cant;
			System.out.println(monto2);
			System.out.println(monto);
			System.out.println(cant);
			prestamo.setPagoMensual(monto2);
			SimpleDateFormat formatoDelTexto = new SimpleDateFormat("yyyy-MM-dd");
			LocalDate fechanueva= LocalDate.now();
			String fecha =fechanueva.toString();
			negocioprestamo.AltaPrestamo(prestamo, fecha);
		
			
			
			RequestDispatcher rd = request.getRequestDispatcher("/Pantalla_principal.jsp");   
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
			
				if(request.getParameter("btnPagar")!=null) {
					HttpSession misession= (HttpSession) request.getSession();
					int idCuenta=Integer.parseInt(request.getParameter("idCuenta"));
					int idprestamo=Integer.parseInt(request.getParameter("idPrestamo"));
				    misession.setAttribute("idcuenta",idCuenta);
				    misession.setAttribute("idprestamo",idprestamo);
					RequestDispatcher rd = request.getRequestDispatcher("/ListarCuotasImpagas.jsp");   
			        rd.forward(request, response);
				}
				
//				if(request.getParameter("btnPagarCuotas")!=null) {
//					
//					int idCuenta=Integer.parseInt(request.getParameter("idCuenta"));
//					int idprestamo=Integer.parseInt(request.getParameter("idPrestamo"));
//					Prestamos prestamos= new Prestamos();
//					PrestamosNegocio negocioPrestamo=new PrestamosNegocio();
//					Cuotas cuotas=new Cuotas();
//					CuotaNegocio negociocuota=new CuotaNegocio();
//					Cuentas cuenta= new Cuentas();
//					CuentaNegocio negocioCuenta=new CuentaNegocio();
//					prestamos=negocioPrestamo.SP_BuscarPrestamoxId(idprestamo);
//					cuenta=negocioCuenta.BuscarCuentasXID(idCuenta);
//					if((cuenta.getSaldo()-prestamos.getPagoMensual())<0)
//					{
//						
//						String alerta=("No podes pagar pobre");
//						
//					}
//					else 
//					{
//						
//						cuenta.setSaldo(cuenta.getSaldo()-prestamos.getPagoMensual());
//						negocioCuenta.ModificarCuenta(cuenta);	
//					}
//					
//					RequestDispatcher rd = request.getRequestDispatcher("/PrestamoAdmin.jsp");   
//					rd.forward(request, response);
//				}
				if(request.getParameter("btnAprobar")!=null) {
					Cuotas cuotas=new Cuotas();
					CuotaNegocio negociocuota=new CuotaNegocio();
					Prestamos prestamos= new Prestamos();
					PrestamosNegocio negocioPrestamo=new PrestamosNegocio();
					LocalDate fecha2= LocalDate.now();
					int fechaMes=fecha2.getMonthValue();
					int anio=fecha2.getYear();					
					int idprestamo=Integer.parseInt(request.getParameter("idPrestamo"));
					prestamos=negocioPrestamo.SP_BuscarPrestamoxId(idprestamo);
					
					
					for(int x=0;x<prestamos.getCantidadCuotas();x++)
					{
						
						if(fechaMes>12)
						{
							fechaMes=fechaMes-12;
							anio+=1;
						}
						switch (fechaMes) {
						case 1:
							cuotas.setFechaMes("Enero");
							break;
						case 2:
							cuotas.setFechaMes("Febrero");
							break;
						case 3:
							cuotas.setFechaMes("Marzo");
							break;
						case 4:
							cuotas.setFechaMes("Abril");
							break;
						case 5:
							cuotas.setFechaMes("Mayo");
							break;	
						case 6:
							cuotas.setFechaMes("Junio");
							break;
						case 7:
							cuotas.setFechaMes("Julio");
							break;
						case 8:
							cuotas.setFechaMes("Agosto");
							break;
						case 9:
							cuotas.setFechaMes("Septiembre");
							break;
						case 10:
							cuotas.setFechaMes("Octubre");
							break;
						case 11:
							cuotas.setFechaMes("Noviembre");
							break;	
						case 12:
							cuotas.setFechaMes("Diciembre");
							
							break;
							
						}

						cuotas.setImporte(prestamos.getPagoMensual());
						cuotas.getPrestamo().setIdPrestamo(prestamos.getIdPrestamo());
						cuotas.setEstado(2);
						SimpleDateFormat formatoDelTexto = new SimpleDateFormat("yyyy-MM-dd");
						String fechavencimiento=String.valueOf(anio)+"-"+String.valueOf(fechaMes)+"-"+"25";
						System.out.println(fechavencimiento);
						negociocuota.AgregarCuota(cuotas, fechavencimiento);
						prestamos.setEstado(1);
						negocioPrestamo.ModificarPrestamo(prestamos);
						fechaMes++;
					
					}
				
				}
				if(request.getParameter("btnMostrar")!=null) {
					HttpSession misession= (HttpSession) request.getSession();
					int idCuenta=(int) misession.getAttribute("idcuenta");
					int idprestamo=(int) misession.getAttribute("idprestamo");
					CuentaNegocio negociocuenta=new CuentaNegocio();
				    ArrayList<Cuentas> lista =negociocuenta.listaCuentasXid(idCuenta);
				    CuotaNegocio negociocuota=new CuotaNegocio();
				    ArrayList<Cuotas> listacuota =negociocuota.lista_Cuotas(idprestamo);
				    request.setAttribute("listaCuenta",lista);
				   request.setAttribute("listaCuota",listacuota);
					RequestDispatcher rd = request.getRequestDispatcher("/ListarCuotasImpagas.jsp");   
			        rd.forward(request, response);
				
				}
				if(request.getParameter("btnPagarCuotas")!=null) {
					 String listacuota[] = request.getParameterValues("ChkCuota");
					 for (String i : listacuota) {
						System.out.println(i);
					}
					
					
				}
				
				

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}
