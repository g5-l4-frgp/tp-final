package Entidad;

public class Contacto {

	int ID;
	String Email;
	int Telefono;
	int contador=0;
	
	public Contacto() {
		 contador++;
		 ID=contador;
		 Email="";
	     Telefono=0;
		
	}
	
	public Contacto(int tel,String email) {
		 contador++;
		 ID=contador;
		 Email=email;
	     Telefono=tel;
	}

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public String getEmail() {
		return Email;
	}

	public void setEmail(String email) {
		Email = email;
	}

	public int getTelefono() {
		return Telefono;
	}

	public void setTelefono(int telefono) {
		Telefono = telefono;
	}

	public int getContador() {
		return contador;
	}

	public void setContador(int contador) {
		this.contador = contador;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((Email == null) ? 0 : Email.hashCode());
		result = prime * result + ID;
		result = prime * result + Telefono;
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
		Contacto other = (Contacto) obj;
		if (Email == null) {
			if (other.Email != null)
				return false;
		} else if (!Email.equals(other.Email))
			return false;
		if (ID != other.ID)
			return false;
		if (Telefono != other.Telefono)
			return false;
		if (contador != other.contador)
			return false;
		return true;
	}
	
}
