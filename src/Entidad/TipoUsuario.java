package Entidad;

public class TipoUsuario {
	int ID;
	String Nombre;
	int contador=0;
	boolean estado=true;
	public TipoUsuario() {
		 contador++;
		 ID=contador;
		 Nombre="";	
	}
	
	public TipoUsuario(String nombre) {
		 contador++;
		 ID=contador;
		 Nombre=nombre;	     
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ID;
		result = prime * result + ((Nombre == null) ? 0 : Nombre.hashCode());
		result = prime * result + contador;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TipoUsuario other = (TipoUsuario) obj;
		if (ID != other.ID)
			return false;
		if (Nombre == null) {
			if (other.Nombre != null)
				return false;
		} else if (!Nombre.equals(other.Nombre))
			return false;
		if (contador != other.contador)
			return false;
		return true;
	}

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public String getNombre() {
		return Nombre;
	}

	public void setNombre(String nombre) {
		Nombre = nombre;
	}

	public int getContador() {
		return contador;
	}

	public void setContador(int contador) {
		this.contador = contador;
	}
}
