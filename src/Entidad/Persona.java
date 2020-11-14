package Entidad;

import java.util.Date;

public class  Persona {
	int contador=0;
	int ID;
	String DNI;
	String Cuil;
	String Sexo;
	String Nacionalidad;
	String Nombre;
	String apellido;
	String NickUsuario;
	String Password;
	TipoUsuario Idtipo;
	Contacto contacto;

	Direccion domicilio;
	Date Fecha;
	boolean estado=true;
	
	public Persona () {
		 contador++;
		 ID=contador;
		 DNI="";
		 Cuil ="";
		 Sexo="";
		 Nacionalidad="";
		 Nombre="";
		 apellido="";
		 NickUsuario="";
	     Password="";
	     Idtipo=new TipoUsuario();
		 contacto=new Contacto();
		 domicilio=new Direccion();
		 Fecha=new Date();
		 
		
	}

	public Persona(int contador, int iD, String dNI, String cuil, String sexo, String nacionalidad, String nombre,
			String apellido, String nickUsuario, String password, TipoUsuario idtipo, Contacto contacto,
			Direccion domicilio, Date fecha) {
		super();
		ID = contador;
		DNI = dNI;
		Cuil = cuil;
		Sexo = sexo;
		Nacionalidad = nacionalidad;
		Nombre = nombre;
		this.apellido = apellido;
		NickUsuario = nickUsuario;
		Password = password;
		Idtipo = idtipo;
		this.contacto = contacto;
		this.domicilio = domicilio;
		Fecha = fecha;
	}

	public int getContacto() {
		return contacto.getID();
	}
	
	public void setContacto(Contacto contacto) {
		this.contacto = contacto;
	}
	public int getContador() {
		return contador;
	}

	public void setContador(int contador) {
		this.contador = contador;
	}

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public String getDNI() {
		return DNI;
	}

	public void setDNI(String dNI) {
		DNI = dNI;
	}

	public String getCuil() {
		return Cuil;
	}

	public void setCuil(String cuil) {
		Cuil = cuil;
	}

	public String getSexo() {
		return Sexo;
	}

	public void setSexo(String sexo) {
		Sexo = sexo;
	}

	public String getNacionalidad() {
		return Nacionalidad;
	}

	public void setNacionalidad(String nacionalidad) {
		Nacionalidad = nacionalidad;
	}

	public String getNombre() {
		return Nombre;
	}

	public void setNombre(String nombre) {
		Nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getNickUsuario() {
		return NickUsuario;
	}

	public void setNickUsuario(String nickUsuario) {
		NickUsuario = nickUsuario;
	}

	public String getPassword() {
		return Password;
	}

	public void setPassword(String password) {
		Password = password;
	}

	public String getIdtipo() {
		return Idtipo.getNombre();
	}

	public void setIdtipo(TipoUsuario idtipo) {
		Idtipo=idtipo; 
	}

	public int getDomicilio() {
		return domicilio.getID();
	}

	public void setDomicilio(Direccion domicilio) {
		this.domicilio = domicilio;
	}

	public Date getFecha() {
		return Fecha;
	}

	public void setFecha(Date fecha) {
		Fecha = fecha;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((Cuil == null) ? 0 : Cuil.hashCode());
		result = prime * result + ((DNI == null) ? 0 : DNI.hashCode());
		result = prime * result + ((Fecha == null) ? 0 : Fecha.hashCode());
		result = prime * result + ID;
		result = prime * result + ((Idtipo == null) ? 0 : Idtipo.hashCode());
		result = prime * result + ((Nacionalidad == null) ? 0 : Nacionalidad.hashCode());
		result = prime * result + ((NickUsuario == null) ? 0 : NickUsuario.hashCode());
		result = prime * result + ((Nombre == null) ? 0 : Nombre.hashCode());
		result = prime * result + ((Password == null) ? 0 : Password.hashCode());
		result = prime * result + ((Sexo == null) ? 0 : Sexo.hashCode());
		result = prime * result + ((apellido == null) ? 0 : apellido.hashCode());
		result = prime * result + ((contacto == null) ? 0 : contacto.hashCode());
		result = prime * result + contador;
		result = prime * result + ((domicilio == null) ? 0 : domicilio.hashCode());
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
		Persona other = (Persona) obj;
		if (Cuil == null) {
			if (other.Cuil != null)
				return false;
		} else if (!Cuil.equals(other.Cuil))
			return false;
		if (DNI == null) {
			if (other.DNI != null)
				return false;
		} else if (!DNI.equals(other.DNI))
			return false;
		if (Fecha == null) {
			if (other.Fecha != null)
				return false;
		} else if (!Fecha.equals(other.Fecha))
			return false;
		if (ID != other.ID)
			return false;
		if (Idtipo == null) {
			if (other.Idtipo != null)
				return false;
		} else if (!Idtipo.equals(other.Idtipo))
			return false;
		if (Nacionalidad == null) {
			if (other.Nacionalidad != null)
				return false;
		} else if (!Nacionalidad.equals(other.Nacionalidad))
			return false;
		if (NickUsuario == null) {
			if (other.NickUsuario != null)
				return false;
		} else if (!NickUsuario.equals(other.NickUsuario))
			return false;
		if (Nombre == null) {
			if (other.Nombre != null)
				return false;
		} else if (!Nombre.equals(other.Nombre))
			return false;
		if (Password == null) {
			if (other.Password != null)
				return false;
		} else if (!Password.equals(other.Password))
			return false;
		if (Sexo == null) {
			if (other.Sexo != null)
				return false;
		} else if (!Sexo.equals(other.Sexo))
			return false;
		if (apellido == null) {
			if (other.apellido != null)
				return false;
		} else if (!apellido.equals(other.apellido))
			return false;
		if (contacto == null) {
			if (other.contacto != null)
				return false;
		} else if (!contacto.equals(other.contacto))
			return false;
		if (contador != other.contador)
			return false;
		if (domicilio == null) {
			if (other.domicilio != null)
				return false;
		} else if (!domicilio.equals(other.domicilio))
			return false;
		return true;
	}

	public void setEstado(boolean b) {
		// TODO Auto-generated method stub
	 estado = b;
	}

	public boolean getEstado() {
		// TODO Auto-generated method stub
		return estado;
	}

	public void setContacto1(Contacto contacto2) {
		// TODO Auto-generated method stub
		this.contacto=contacto2;
	}

	public void setDireccion(Direccion direccion) {
		// TODO Auto-generated method stub
		domicilio=direccion;
	}


	
}
