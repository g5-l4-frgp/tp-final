package Negocio;

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

}
