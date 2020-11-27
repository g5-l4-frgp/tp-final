package Negocio;

import DAO.MovimientoDAO;
import Entidad.Movimiento;
import Interface.Interface_Movimiento;

public class MovimientoNegocio implements Interface_Movimiento{
	private MovimientoDAO daoMovimiento=new MovimientoDAO();

	@Override
	public void Altamovimiento(Movimiento movimiento,String fecha) {
		// TODO Auto-generated method stub
		daoMovimiento.AltaMovimiento(movimiento,fecha);
	}

	@Override
	public Movimiento buscarMovimiento() {
		// TODO Auto-generated method stub
		return daoMovimiento.buscarMovimiento();
	}

}
