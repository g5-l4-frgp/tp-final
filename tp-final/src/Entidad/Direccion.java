package Entidad;

public class Direccion {
	
	int ID;
	String Calle;
	String Altura;
	String Localidad;
	String Provincia;
	int contador=0;
	boolean estado=true;
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
	public String getCalle() {
		return Calle;
	}
	public void setCalle(String calle) {
		Calle = calle;
	}
	public String getAltura() {
		return Altura;
	}
	public void setAltura(String string) {
		Altura = string;
	}
	public String getLocalidad() {
		return Localidad;
	}
	public void setLocalidad(String localidad) {
		Localidad = localidad;
	}
	public String getProvincia() {
		return Provincia;
	}
	public void setProvincia(String provincia) {
		Provincia = provincia;
	}
	
	public Direccion() {
		contador++;
		int ID=contador;
		Calle="";
	    Altura="";
	    Localidad="";
	    Provincia="";
	}
	
	public Direccion(String alt,String Loca,String Prov,String Call) {
		contador++;
		int ID=contador;
		Calle=Call;
		Altura=alt;
		Localidad=Loca;
		Provincia=Prov;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((Altura == null) ? 0 : Altura.hashCode());
		result = prime * result + ((Calle == null) ? 0 : Calle.hashCode());
		result = prime * result + ID;
		result = prime * result + ((Localidad == null) ? 0 : Localidad.hashCode());
		result = prime * result + ((Provincia == null) ? 0 : Provincia.hashCode());
		result = prime * result + contador;
		result = prime * result + (estado ? 1231 : 1237);
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
		Direccion other = (Direccion) obj;
		if (Altura == null) {
			if (other.Altura != null)
				return false;
		} else if (!Altura.equals(other.Altura))
			return false;
		if (Calle == null) {
			if (other.Calle != null)
				return false;
		} else if (!Calle.equals(other.Calle))
			return false;
		if (ID != other.ID)
			return false;
		if (Localidad == null) {
			if (other.Localidad != null)
				return false;
		} else if (!Localidad.equals(other.Localidad))
			return false;
		if (Provincia == null) {
			if (other.Provincia != null)
				return false;
		} else if (!Provincia.equals(other.Provincia))
			return false;
		if (contador != other.contador)
			return false;
		if (estado != other.estado)
			return false;
		return true;
	}
	
}
