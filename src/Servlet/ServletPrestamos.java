package Servlet;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Entidad.Persona;
import Entidad.Prestamos;

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
			Persona usuario=new Persona();
			Prestamos prestamo=new Prestamos();
			prestamo.setCliente(usuario);
			//Utilizar funcion buscar cuenta prestamo.setCuenta(request.getParameter("selectCuenta"););
			//utlizar funcion generar movimiento prestamo.setMovimiento(movimiento);
			//utilizar funcion generar importe con intereses prestamo.setImporteConIntereses(importeConIntereses);
			float monto=0;
			monto=Float.parseFloat(request.getParameter("txtMonto"));
			prestamo.setImportePedido(monto);
			int cant=0;
			cant=Integer.parseInt(request.getParameter("selectCuotas"));
			prestamo.setCantidadCuotas(cant);
			SimpleDateFormat formatoDelTexto = new SimpleDateFormat("yyyy-MM-dd");
			LocalDate fechanueva= LocalDate.now();
			String fecha =fechanueva.toString();
			
			

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}
