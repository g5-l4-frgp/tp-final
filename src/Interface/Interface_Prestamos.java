package Interface;

import java.util.ArrayList;

import Entidad.Prestamos;

public interface Interface_Prestamos {
	
		public void AltaPrestamo(Prestamos prestamo, String fecha);
		public void ModificarPrestamo(Prestamos prestamo);
		public ArrayList<Prestamos> lista_Prestamos();
		public Prestamos SP_BuscarPrestamoxId(int id);
}
