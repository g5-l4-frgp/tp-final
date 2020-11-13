package Interface;
import java.util.ArrayList;
import DAO.DAO_Personas;
import Entidad.Contacto;
import Entidad.Direccion;
import Entidad.Persona;

public interface Interface_negocio_persona {
	
	public void SPAltaUsuario(Persona usuario, String fecha);
	public void SP_AgregarDireccion(Direccion direccion);
	public void AgregarContacto(Contacto contacto);
	public ArrayList<Persona> lista_usuarios ();
	public Contacto buscarContacto();
	public Direccion buscarDireccion();
}
