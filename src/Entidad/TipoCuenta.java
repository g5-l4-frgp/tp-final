package Entidad;

public class TipoCuenta {
	int ID;
	int contador=0;
	String Nombre;
	public TipoCuenta() {
		
		contador++;
		ID=contador;
		Nombre="";
	}
	public TipoCuenta(int iD, String nombre) {
		
		contador++;
		ID = contador;
		Nombre = nombre;
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
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ID;
		result = prime * result + ((Nombre == null) ? 0 : Nombre.hashCode());
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
		TipoCuenta other = (TipoCuenta) obj;
		if (ID != other.ID)
			return false;
		if (Nombre == null) {
			if (other.Nombre != null)
				return false;
		} else if (!Nombre.equals(other.Nombre))
			return false;
		return true;
	}
	
	
}
