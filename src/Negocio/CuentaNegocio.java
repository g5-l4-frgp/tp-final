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
	public Persona Obtener_usuario(String dni) {
		// TODO Auto-generated method stub
		return cuentaDAO.Obtener_usuario(dni);
	}
	@Override
	public ArrayList<Cuentas> listaCuentas() {
		//  Auto-generated method stub
		return cuentaDAO.listaCuentas();
	}
	@Override
	public Cuentas BuscarCuentasXID(int id) {
		// TODO Auto-generated method stub
		return cuentaDAO.BuscarCuentasXID(id);
	}
	@Override
	public ArrayList<Cuentas> listaCuentasXid(int id) {
		// TODO Auto-generated method stub
		return cuentaDAO.listaCuentasXid(id);
	}

}
