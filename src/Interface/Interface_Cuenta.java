package Interface;

import java.util.ArrayList;

import Entidad.Cuentas;
import Entidad.Persona;

public interface Interface_Cuenta {
	
	public void AgregarCuenta (Cuentas cuenta, String fecha);
	public void eliminarCuenta(int idcuenta);
	public Persona Obtener_usuario (String dni);
	public void ModificarCuenta(Cuentas cuenta);
	public ArrayList<Cuentas> listaCuentas();
	public Cuentas BuscarCuentasXID(int id);
	public ArrayList<Cuentas> listaCuentasXid(int id);
}
