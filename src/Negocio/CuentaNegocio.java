package Negocio;

import java.sql.Date;
import java.util.ArrayList;

import DAO.CuentaDAO;
import Entidad.Cuentas;
import Entidad.Persona;
import Interface.Interface_Cuenta;


public class CuentaNegocio implements Interface_Cuenta {
	
	private CuentaDAO cuentaDAO=new CuentaDAO();
	
	public CuentaNegocio() {
		
	}
	@Override
	public void AgregarCuenta(Cuentas cuenta,String fecha) {
		cuentaDAO.AgregarCuenta(cuenta, fecha);
		// TODO Auto-generated method stub
		
	}
	@Override
	public void eliminarCuenta(int idcuenta) {
		cuentaDAO.eliminarCuenta(idcuenta);
	// TODO Auto-generated method stub
	
}
	@Override
	public Persona Obtener_usuario(String nombrePersona) {
		// TODO Auto-generated method stub
		return cuentaDAO.Obtener_usuario(nombrePersona);
	}
	@Override
	public ArrayList<Cuentas> listaCuentas() {
		//  Auto-generated method stub
		return cuentaDAO.listaCuentas();
	}
	

}
