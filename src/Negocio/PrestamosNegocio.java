package Negocio;
import java.util.ArrayList;

import DAO.PrestamoDAO;
import Entidad.Prestamos;
import Interface.Interface_Prestamos;

public class PrestamosNegocio implements Interface_Prestamos{
	public  PrestamoDAO dao=new PrestamoDAO();
	@Override
	public void AltaPrestamo(Prestamos prestamo,String fecha) {
		
		dao.AltaPrestamo(prestamo,fecha);
	}

	@Override
	public void ModificarPrestamo(Prestamos prestamo) {
		
		dao.ModificarPrestamo(prestamo);
	}

	@Override
	public ArrayList<Prestamos> lista_Prestamos() {
		// TODO Auto-generated method stub
		return dao.lista_Prestamos();
	}

	@Override
	public Prestamos SP_BuscarPrestamoxId(int id) {
		// TODO Auto-generated method stub
		return dao.SP_BuscarPrestamoxId(id);
	}

	@Override
	public ArrayList<Prestamos> SP_BuscarPrestamoxIdUsuario(int idusuario) {
		// TODO Auto-generated method stub
		return dao.SP_BuscarPrestamoxIdUsuario(idusuario);
	}


	
	

}
