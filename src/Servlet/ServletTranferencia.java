package Servlet;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.time.LocalDate;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Entidad.Cuentas;
import Entidad.Movimiento;
import Entidad.Persona;
import Entidad.Tranferencias;
import Negocio.CuentaNegocio;
import Negocio.MovimientoNegocio;
import Negocio.TransferenciaNegocio;

/**
 * Servlet implementation class ServletTranferencia
 */
@WebServlet("/ServletTranferencia")
public class ServletTranferencia extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletTranferencia() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		if(request.getParameter("Param1")!=null) {
			HttpSession misession= (HttpSession) request.getSession();
			Persona usuario= new Persona();
			usuario=(Persona) misession.getAttribute("usuario");
			ArrayList<Cuentas> listaPersonal1 = new ArrayList<Cuentas>();
			ArrayList<Cuentas> listaPersonal = new ArrayList<Cuentas>();
			CuentaNegocio negocio= new CuentaNegocio();
			listaPersonal1=negocio.listaCuentasXid(usuario.getID());
			listaPersonal=negocio.listaCuentasXid(usuario.getID());
			request.setAttribute("listaCuentas",listaPersonal);
			request.setAttribute("listaCuentas1",listaPersonal1);
			RequestDispatcher rd = request.getRequestDispatcher("/TransferenciaCuentaPropia.jsp");   
	        rd.forward(request, response);
		}
		if(request.getParameter("Param2")!=null) {
			HttpSession misession= (HttpSession) request.getSession();
			Persona usuario= new Persona();
			usuario=(Persona) misession.getAttribute("usuario");
			ArrayList<Cuentas> listaPersonal = new ArrayList<Cuentas>();
			CuentaNegocio negocio= new CuentaNegocio();
			listaPersonal=negocio.listaCuentasXid(usuario.getID());
			request.setAttribute("listaCuentas",listaPersonal);
			RequestDispatcher rd = request.getRequestDispatcher("/TransferenciaTerceros.jsp");   
	        rd.forward(request, response);
		}
		if(request.getParameter("btnTransferir")!=null) {
			Movimiento movimiento=new Movimiento();
			Movimiento movimientodestino=new Movimiento();
			MovimientoNegocio negociomovimiento= new MovimientoNegocio();
			Cuentas cuentas = new Cuentas();
			Cuentas cuentas2 = new Cuentas();
			Tranferencias tranferencias= new Tranferencias();
			TransferenciaNegocio negociotransferencia=new TransferenciaNegocio();
			CuentaNegocio negocio= new CuentaNegocio();
			SimpleDateFormat formatoDelTexto = new SimpleDateFormat("yyyy-MM-dd");
			LocalDate fechanueva= LocalDate.now();
			String fecha =fechanueva.toString();
			int idCuenta=Integer.parseInt( request.getParameter("CuentaOrigen"));
			int idCuenta2=Integer.parseInt( request.getParameter("CuentaDestino"));
			cuentas=negocio.BuscarCuentasXID(idCuenta);
			cuentas2=negocio.BuscarCuentasXID(idCuenta2);
			float monto=0;
			monto=Float.parseFloat(request.getParameter("txtMonto"));
			if((cuentas.getSaldo()<monto))
			{
				
				 String alerta=("No podes pagar pobre");
				 System.out.println(alerta);
				
				
			}
			else 
			{
			cuentas2.setSaldo(cuentas2.getSaldo()+monto);
			cuentas.setSaldo(cuentas.getSaldo()-monto);
			movimiento.setCuenta(cuentas);
			movimiento.setDetalle(request.getParameter("Concepto"));
			movimientodestino.setCuenta(cuentas2);
			movimientodestino.setDetalle(request.getParameter("Concepto"));
			tranferencias.setCuenta(cuentas);
			tranferencias.setCuentaDestino(cuentas2);
			tranferencias.setImporte(monto);
			negocio.ModificarCuenta(cuentas);
			negocio.ModificarCuenta(cuentas2);
			negociomovimiento.Altamovimiento(movimiento,fecha);
			movimiento=negociomovimiento.buscarMovimiento();
			negociomovimiento.Altamovimiento(movimientodestino,fecha);
			movimientodestino=negociomovimiento.buscarMovimiento();
			tranferencias.getMovimiento().setIdMovimiento(movimiento.getIdMovimiento());
			tranferencias.getMovimientoDestino().setIdMovimiento(movimientodestino.getIdMovimiento());
			negociotransferencia.AltaTranferencia(tranferencias);
			
			}
			RequestDispatcher rd = request.getRequestDispatcher("/Pantalla_principal.jsp");   
	        rd.forward(request, response);
		}
		if(request.getParameter("btnTranferencia")!=null) {
			Movimiento movimiento=new Movimiento();
			Movimiento movimientodestino=new Movimiento();
			MovimientoNegocio negociomovimiento= new MovimientoNegocio();
			Cuentas cuentas = new Cuentas();
			Cuentas cuentas2 = new Cuentas();
			Tranferencias tranferencias= new Tranferencias();
			TransferenciaNegocio negociotransferencia=new TransferenciaNegocio();
			CuentaNegocio negocio= new CuentaNegocio();
			int idCuenta=Integer.parseInt( request.getParameter("CuentaOrigen"));
			String cbu=request.getParameter("CBU");
			SimpleDateFormat formatoDelTexto = new SimpleDateFormat("yyyy-MM-dd");
			LocalDate fechanueva= LocalDate.now();
			String fecha =fechanueva.toString();
			cuentas=negocio.BuscarCuentasXID(idCuenta);
			cuentas2=negocio.BuscarCuentasXCBU(cbu);
			if(cuentas2!=null)
			{
				float monto=0;
				monto=Float.parseFloat(request.getParameter("txtMonto"));
				if((cuentas.getSaldo()<monto))
				{
					
					 String alerta=("No podes pagar pobre");
					 System.out.println(alerta);
					
					
				}
				else 
				{
				cuentas2.setSaldo(cuentas2.getSaldo()+monto);
				cuentas.setSaldo(cuentas.getSaldo()-monto);
				movimiento.setCuenta(cuentas);
				movimiento.setDetalle(request.getParameter("Conceptos"));
				movimientodestino.setCuenta(cuentas2);
				movimientodestino.setDetalle(request.getParameter("Conceptos"));
				tranferencias.setCuenta(cuentas);
				tranferencias.setCuentaDestino(cuentas2);
				tranferencias.setImporte(monto);
				negocio.ModificarCuenta(cuentas);
				negocio.ModificarCuenta(cuentas2);
				negociomovimiento.Altamovimiento(movimiento,fecha);
				movimiento=negociomovimiento.buscarMovimiento();
				negociomovimiento.Altamovimiento(movimientodestino,fecha);
				movimientodestino=negociomovimiento.buscarMovimiento();
				tranferencias.getMovimiento().setIdMovimiento(movimiento.getIdMovimiento());
				tranferencias.getMovimientoDestino().setIdMovimiento(movimientodestino.getIdMovimiento());
				negociotransferencia.AltaTranferencia(tranferencias);
				
				}
			}
			else {
				String alerta="pone bien los numero";
				System.out.println(alerta);
			}
			RequestDispatcher rd = request.getRequestDispatcher("/Pantalla_principal.jsp");   
	        rd.forward(request, response);
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

	}

}
