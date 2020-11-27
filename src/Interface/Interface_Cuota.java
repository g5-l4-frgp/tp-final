package Interface;

import java.util.ArrayList;

import Entidad.Cuotas;

public interface Interface_Cuota {
	public void AgregarCuota (Cuotas cuota,String fechavenc);
	public ArrayList<Cuotas> lista_Cuotas(int idprestamo) ;
	public Cuotas lista_CuotasxID(int idcuota);
	public void ModificarCuota(Cuotas cuota);
}
