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
	
	private DAO_Personas dao_p = new DAO_Personas();

	@Override
	public void SPAltaUsuario(Persona personas,String fecha) {
		// TODO Auto-generated method stub
		 dao_p.SPAltaUsuario(personas, fecha);
	}
	
	public void SP_AgregarDireccion(Direccion direccion) {
	
		dao_p.SP_AgregarDireccion(direccion);
	}
	public void SP_AgregarContacto(Contacto contacto) {
	
		dao_p.SP_AgregarContacto(contacto);
	}

	public ArrayList<Persona> lista_usuarios() {
		// TODO Auto-generated method stub
		return dao_p.lista_usuarios();
	}
}
		

	