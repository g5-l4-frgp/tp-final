package Negocio;

import DAO.DAO_Personas;
import DAO.LoginDAO;
import Entidad.Persona;
import Interface.Interface_Login;

public class Login_Negocio implements Interface_Login {

	private LoginDAO daoLogin = new LoginDAO();
	@Override
	public Persona BuscarUsuarioXNick(String Nick) {
		// TODO Auto-generated method stub
		return daoLogin.BuscarUsuarioXNick(Nick);
	}

	
}
