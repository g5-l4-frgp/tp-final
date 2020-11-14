package Entidad;

import java.util.Date;
import java.util.Random;

public class Cuentas {
   
		int ID;
		String numeroCuenta="";
		int contador=0;
		int Idtipo;
		Persona idPersona;
		Date fechaCreacion;
		String CBU="";
		float Saldo;
		String codBanco = "435";
		String codSucursal = "602";
		boolean estado=true;
		public Cuentas() {
			 contador++;
			 ID=contador;
			 numeroCuenta="";
			 idPersona=new Persona();
			 fechaCreacion=new Date();
			 CBU="";
			 Saldo=0;
		}
		public Cuentas(int iD, int idtipo, Persona idPersona, Date fechaCreacion, String cBU,float saldo) {
			super();
			contador++;
			ID = contador;
			numeroCuenta = CrearNumeroCuenta(idPersona.getCuil());
			Idtipo = idtipo;
			this.idPersona = idPersona;
			this.fechaCreacion = fechaCreacion;
			CBU = CrearCBU(numeroCuenta);
			Saldo = saldo;
		}
		public int getID() {
			return ID;
		}
		public void setID(int iD) {
			ID = iD;
		}
		public int getIdtipo() {
			return Idtipo;
		}
		public void setIdtipo(int idtipo) {
			Idtipo = idtipo;
		}
		public String getNumeroCuenta() {
			return numeroCuenta;
		}
		public void setNumeroCuenta(String numeroCuenta) {
			this.numeroCuenta = numeroCuenta;
		}
		public String getCodBanco() {
			return codBanco;
		}
		public void setCodBanco(String codBanco) {
			this.codBanco = codBanco;
		}
		public String getCodSucursal() {
			return codSucursal;
		}
		public void setCodSucursal(String codSucursal) {
			this.codSucursal = codSucursal;
		}
		public boolean isEstado() {
			return estado;
		}
		public void setEstado(boolean estado) {
			this.estado = estado;
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
		public float getSaldo() {
			return Saldo;
		}
		public void setSaldo(float saldo) {
			Saldo = saldo;
		}
	

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + ((CBU == null) ? 0 : CBU.hashCode());
			result = prime * result + ID;
			result = prime * result + Idtipo;
			result = prime * result + Float.floatToIntBits(Saldo);
			result = prime * result + ((codBanco == null) ? 0 : codBanco.hashCode());
			result = prime * result + ((codSucursal == null) ? 0 : codSucursal.hashCode());
			result = prime * result + (estado ? 1231 : 1237);
			result = prime * result + ((fechaCreacion == null) ? 0 : fechaCreacion.hashCode());
			result = prime * result + ((idPersona == null) ? 0 : idPersona.hashCode());
			result = prime * result + ((numeroCuenta == null) ? 0 : numeroCuenta.hashCode());
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
			if (Idtipo != other.Idtipo)
				return false;
			if (Float.floatToIntBits(Saldo) != Float.floatToIntBits(other.Saldo))
				return false;
			if (codBanco == null) {
				if (other.codBanco != null)
					return false;
			} else if (!codBanco.equals(other.codBanco))
				return false;
			if (codSucursal == null) {
				if (other.codSucursal != null)
					return false;
			} else if (!codSucursal.equals(other.codSucursal))
				return false;
			if (estado != other.estado)
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
			if (numeroCuenta == null) {
				if (other.numeroCuenta != null)
					return false;
			} else if (!numeroCuenta.equals(other.numeroCuenta))
				return false;
			return true;
		}
		private String CrearNumeroCuenta(String cuil) {
			String numeroCuentaString;
			numeroCuentaString = "6" + cuil + "2";
			return numeroCuentaString;
		}
		private String CrearCBU(String numeroCuenta) {
			String CBU;
			Random r = new Random();
			int codSeg1 = r.nextInt(10);
			int codSeg2 = r.nextInt(10);
			CBU = codBanco + codSucursal + String.valueOf(codSeg1) + numeroCuenta + String.valueOf(codSeg2);
			return CBU;
		}
		
		
		
		
}
