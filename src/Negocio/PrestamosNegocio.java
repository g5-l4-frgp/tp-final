package Negocio;
import DAO.PrestamoDAO;
import Entidad.Prestamos;
import Interface.Interface_Prestamos;

public class PrestamosNegocio implements Interface_Prestamos{

	@Override
	public void AltaPrestamo(Prestamos prestamo,String fecha) {
		PrestamoDAO dao=new PrestamoDAO();
		dao.AltaPrestamo(prestamo,fecha);
	}

	@Override
	public void ModificarPrestamo(Prestamos prestamo) {
		
		PrestamoDAO dao=new PrestamoDAO();
		dao.ModificarPrestamo(prestamo);
	}
	

}
