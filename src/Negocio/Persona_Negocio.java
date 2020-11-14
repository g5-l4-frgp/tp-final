package Negocio;
import java.util.ArrayList;
import java.util.List;
import DAO.DAO_Personas;
import Entidad.Contacto;
import Entidad.Direccion;
import Entidad.Persona;
import Interface.Interface_negocio_persona;
import Interface.Interface_negocio_persona;

public class Persona_Negocio implements Interface_negocio_persona{
	
	private DAO_Personas daoPersona = new DAO_Personas();

	@Override
	public void SPAltaUsuario(Persona personas,String fecha) {
		// TODO Auto-generated method stub
		daoPersona.SPAltaUsuario(personas, fecha);
	}
	
	public void SP_AgregarDireccion(Direccion direccion) {
	
		daoPersona.SP_AgregarDireccion(direccion);
	}
	public void AgregarContacto(Contacto contacto) {
	
		daoPersona.AgregarContacto(contacto);
	}

	public ArrayList<Persona> lista_usuarios() {
		// TODO Auto-generated method stub
		return daoPersona.lista_usuarios();
	}

	public Contacto buscarContacto() {
		// TODO Auto-generated method stub
		return daoPersona.buscarContacto();
	}

	public Direccion buscarDireccion() {
		// TODO Auto-generated method stub
		return daoPersona.buscarDireccion();
	}

	@Override
	public void EliminarUsuario(int idUsuario) {
		// TODO Auto-generated method stub
		daoPersona.EliminarUsuario(idUsuario);
	}

	@Override
	public void ModificarUsuario(Persona usuario, String fecha) {
		// TODO Auto-generated method stub
		daoPersona.ModificarUsuario(usuario, fecha);
	}

	@Override
	public Persona BuscarUsuarioXID(int idUsuario) {
		// TODO Auto-generated method stub
		return daoPersona.BuscarUsuarioXID(idUsuario);
	}
	

	
}
		

	