package Negocio;

import DAO.TransferenciasDAO;
import Entidad.Tranferencias;
import Interface.Interface_Tranferencias;

public class TransferenciaNegocio implements Interface_Tranferencias {

	private TransferenciasDAO DAOTranferencia= new TransferenciasDAO();
	@Override
	public void AltaTranferencia(Tranferencias tranferencia) {
		
		DAOTranferencia.AltaTranferencia(tranferencia);
		
	}
	
	

}
