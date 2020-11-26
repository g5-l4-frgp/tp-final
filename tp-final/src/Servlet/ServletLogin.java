package Servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Entidad.Persona;
import Negocio.Login_Negocio;
import Negocio.Persona_Negocio;

/**
 * Servlet implementation class ServletLogin
 */
@WebServlet("/ServletLogin")
public class ServletLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletLogin() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		if(request.getParameter("btnAceptar")!=null) {
			Persona usuario= new Persona();
			Login_Negocio negocio= new Login_Negocio();
			String nick=request.getParameter("txtUsuario");
			String pass=request.getParameter("txtPassword");
			usuario=negocio.BuscarUsuarioXNick(nick);
			System.out.println(usuario.getPassword());
			System.out.println(pass);
			System.out.println(usuario.getIdtipo());
			if(usuario==null)
			{
				
				RequestDispatcher rd = request.getRequestDispatcher("/Login.jsp");   
		        rd.forward(request, response);
			}
			if(usuario.getPassword().equals(pass))
			{
				
				if(usuario.getIdtipo()==1)
				{
					request.setAttribute("usuario", usuario);	
					RequestDispatcher rd = request.getRequestDispatcher("/Home.jsp");   
					rd.forward(request, response);
				}else
				{
					request.setAttribute("usuario", usuario);	
					RequestDispatcher rd = request.getRequestDispatcher("/Pantalla_principal.jsp");   
					rd.forward(request, response);
				}
					
			}
			else {
				request.setAttribute("usuario", usuario);	
				RequestDispatcher rd = request.getRequestDispatcher("/Login.jsp");  
		        rd.forward(request, response);
			}
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
