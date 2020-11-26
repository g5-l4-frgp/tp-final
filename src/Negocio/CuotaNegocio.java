package Negocio;

import java.util.ArrayList;

import DAO.CuentaDAO;
import DAO.CuotasDAO;
import Entidad.Cuotas;
import Interface.Interface_Cuota;

public class CuotaNegocio implements Interface_Cuota {
	private CuotasDAO Cuentadao=new CuotasDAO();

	@Override
	public void AgregarCuota(Cuotas cuota, String fechavenc) {
		// TODO Auto-generated method stub
		Cuentadao.AgregarCuota(cuota, fechavenc);
	}

	@Override
	public ArrayList<Cuotas> lista_Cuotas(int idprestamo) {
		// TODO Auto-generated method stub
		return Cuentadao.lista_Cuotas(idprestamo);
	}

}
