package Negocio;

import DAO.CuentaDAO;
import Dominio.Cuenta;


public class CuentaNegocio {
	
	private CuentaDAO cuentaDAO=new CuentaDAO();
	
	public CuentaNegocio() {
		
	}
	public void agregarCuenta(Cuenta cuenta) {
		
		cuentaDAO.AgregarCuenta(cuenta);
	}
	public void eliminarCuenta(int id) {
		cuentaDAO.eliminarCuenta(id);
	}

}
