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
	public void EliminarUsuario(int idPersona);
	public void ModificarUsuario(Persona usuario, String fecha);
	public ArrayList<Persona> lista_usuarios ();
	public Persona BuscarUsuarioXID(int idUsuario);
	public Contacto buscarContacto();
	public Direccion buscarDireccion();
}
