package Entidad;

import java.util.Date;

import sun.print.PageableDoc;

public class Cuentas {
   
		int ID;
		int contador=0;
		TipoCuenta Idtipo;
		Persona idPersona;
		Date fechaCreacion;
		String CBU;
		Double Saldo;
		boolean estado=true;
		public Cuentas() {
			 contador++;
			 ID=contador;
			 idPersona=new Persona();
			 fechaCreacion=new Date();
			 CBU="";
			 Saldo=0.0;
		}
		public Cuentas(int iD, TipoCuenta idtipo, Persona idPersona, Date fechaCreacion, String cBU, Double saldo) {
			super();
			contador++;
			ID = contador;
			Idtipo = idtipo;
			this.idPersona = idPersona;
			this.fechaCreacion = fechaCreacion;
			CBU = cBU;
			Saldo = saldo;
		}
		public int getID() {
			return ID;
		}
		public void setID(int iD) {
			ID = iD;
		}
		public TipoCuenta getIdtipo() {
			return Idtipo;
		}
		public void setIdtipo(TipoCuenta idtipo) {
			Idtipo = idtipo;
		}
		public Persona getIdPersona() {
			return idPersona;
		}
		public void setIdPersona(Persona idPersona) {
			this.idPersona = idPersona;
		}
		public Date getFechaCreacion() {
			return fechaCreacion;
		}
		public void setFechaCreacion(Date fechaCreacion) {
			this.fechaCreacion = fechaCreacion;
		}
		public String getCBU() {
			return CBU;
		}
		public void setCBU(String cBU) {
			CBU = cBU;
		}
		public Double getSaldo() {
			return Saldo;
		}
		public void setSaldo(Double saldo) {
			Saldo = saldo;
		}
		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + ((CBU == null) ? 0 : CBU.hashCode());
			result = prime * result + ID;
			result = prime * result + ((Idtipo == null) ? 0 : Idtipo.hashCode());
			result = prime * result + ((Saldo == null) ? 0 : Saldo.hashCode());
			result = prime * result + contador;
			result = prime * result + ((fechaCreacion == null) ? 0 : fechaCreacion.hashCode());
			result = prime * result + ((idPersona == null) ? 0 : idPersona.hashCode());
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
			Cuentas other = (Cuentas) obj;
			if (CBU == null) {
				if (other.CBU != null)
					return false;
			} else if (!CBU.equals(other.CBU))
				return false;
			if (ID != other.ID)
				return false;
			if (Idtipo == null) {
				if (other.Idtipo != null)
					return false;
			} else if (!Idtipo.equals(other.Idtipo))
				return false;
			if (Saldo == null) {
				if (other.Saldo != null)
					return false;
			} else if (!Saldo.equals(other.Saldo))
				return false;
			if (contador != other.contador)
				return false;
			if (fechaCreacion == null) {
				if (other.fechaCreacion != null)
					return false;
			} else if (!fechaCreacion.equals(other.fechaCreacion))
				return false;
			if (idPersona == null) {
				if (other.idPersona != null)
					return false;
			} else if (!idPersona.equals(other.idPersona))
				return false;
			return true;
		}
		
		
		
		
}
