package Entidad;

import java.util.*;
import java.time.LocalDate;

public class Movimiento {
	 
	int contador=0;
	 int idMovimiento ;
	 Date fecha;
	 String detalle; 
	 Cuentas cuenta; 
     boolean estado;
     public Movimiento() {
 		contador++;
 		this.idMovimiento = contador;
 		this.fecha=new Date();
 		this.detalle = detalle;
 		this.cuenta = cuenta;
 		this.estado = estado;
 	}
	public Movimiento(int idMovimiento, Date fecha, String detalle, Cuentas cuenta, boolean estado) {
		super();
		this.idMovimiento = idMovimiento;
		this.fecha = fecha;
		this.detalle = detalle;
		this.cuenta = cuenta;
		this.estado = estado;
	}
	public int getIdMovimiento() {
		return idMovimiento;
	}
	public void setIdMovimiento(int idMovimiento) {
		this.idMovimiento = idMovimiento;
	}
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	public String getDetalle() {
		return detalle;
	}
	public void setDetalle(String detalle) {
		this.detalle = detalle;
	}
	public Cuentas getCuenta() {
		return cuenta;
	}
	public void setCuenta(Cuentas cuenta) {
		this.cuenta = cuenta;
	}
	public boolean isEstado() {
		return estado;
	}
	public void setEstado(boolean estado) {
		this.estado = estado;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cuenta == null) ? 0 : cuenta.hashCode());
		result = prime * result + ((detalle == null) ? 0 : detalle.hashCode());
		result = prime * result + (estado ? 1231 : 1237);
		result = prime * result + ((fecha == null) ? 0 : fecha.hashCode());
		result = prime * result + idMovimiento;
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
		Movimiento other = (Movimiento) obj;
		if (cuenta == null) {
			if (other.cuenta != null)
				return false;
		} else if (!cuenta.equals(other.cuenta))
			return false;
		if (detalle == null) {
			if (other.detalle != null)
				return false;
		} else if (!detalle.equals(other.detalle))
			return false;
		if (estado != other.estado)
			return false;
		if (fecha == null) {
			if (other.fecha != null)
				return false;
		} else if (!fecha.equals(other.fecha))
			return false;
		if (idMovimiento != other.idMovimiento)
			return false;
		return true;
	}
	
	
}
