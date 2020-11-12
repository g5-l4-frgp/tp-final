package Interface;

import Entidad.Contacto;
import Entidad.Direccion;
import Entidad.Persona;

import java.util.ArrayList;

import DAO.DAO_Personas;

public interface Interface_Persona {
	
	public void SPAltaUsuario(Persona usuario, String fecha);
	public void SP_AgregarDireccion(Direccion direccion);
	public void SP_AgregarContacto(Contacto contacto);
	public ArrayList<Persona> lista_usuarios();

}