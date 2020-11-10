package Servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Dominio.Cuenta;
import Dominio.TipoCuenta;
import Dominio.Usuario;
import Negocio.CuentaNegocio;

/**
 * Servlet implementation class ServletCuenta
 */
@WebServlet("/ServletCuenta")
public class ServletCuenta extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public ServletCuenta() {

    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		if(request.getParameter("btnAceptar")!=null) {
			Cuenta cuenta=new Cuenta();
			int idUsuario=0,tipoCuenta=0,cbu=0;
			float saldo=0;
			cbu= Integer.parseInt(request.getParameter("txtCBU"));
			idUsuario=Integer.parseInt(request.getParameter("txtUsuario"));
			tipoCuenta=Integer.parseInt(request.getParameter("selectCuenta"));
			saldo=Integer.parseInt(request.getParameter("txtSaldo"));
			Usuario user=new Usuario();
			user.setId(idUsuario);
			TipoCuenta tipocuenta=new TipoCuenta();
			tipocuenta.setId(tipoCuenta);
			cuenta.setCBU(cbu);
			cuenta.setSaldo(saldo);
			cuenta.setUsuario(user);
			cuenta.setTipoCuenta(tipocuenta);
			
			CuentaNegocio negocio=new CuentaNegocio();
			negocio.agregarCuenta(cuenta);
			RequestDispatcher rd=request.getRequestDispatcher("Home.jsp");  	  
	 		rd.forward(request, response);
		}

		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	
		
		
	}

}
