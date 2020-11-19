package Entidad;

import java.util.*;

import com.sun.media.jfxmedia.events.NewFrameEvent;

import sun.reflect.ConstructorAccessor;

public class Prestamos {
	int contador=0;
	int idPrestamo;
	Persona cliente ;
	Movimiento movimiento ;
	float importeConIntereses; 
	float importePedido;
	float pagoMensual; 
	int cantidadCuotas; 
	int cuotasPagas; 
	Date fechaSolicitada;
	Cuentas cuenta ;
	int estado ;
	public Prestamos() {
	     contador++;
		this.idPrestamo = contador;
		this.cliente = new Persona();
		this.movimiento = new Movimiento();
		this.importeConIntereses = 0;
		this.importePedido = 0;
		this.fechaSolicitada= new Date();
		this.pagoMensual = 0;
		this.cantidadCuotas = 0;
		this.cuenta = new Cuentas();
		this.estado = 0;
	}
	
	public int getEstado() {
		return estado;
	}

	public Prestamos( Persona cliente, Movimiento movimiento, float importeConIntereses,
			float importePedido, float pagoMensual, int cantidadCuotas, Date fechaSoli, Cuentas cuenta,
			int estado) {
		 contador++;
			this.idPrestamo = contador;
		this.cliente = cliente;
		this.movimiento = movimiento;
		this.importeConIntereses = importeConIntereses;
		this.importePedido = importePedido;
		this.pagoMensual = pagoMensual;
		this.cantidadCuotas = cantidadCuotas;
		this.fechaSolicitada = fechaSoli;
		this.cuenta = cuenta;
		this.estado = estado;
	}

	public int getCuotasPagas() {
		return cuotasPagas;
	}
	
	public void setCuotasPagas(int cuotasPagas) {
		this.cuotasPagas = cuotasPagas;
	}

	public int getIdPrestamo() {
		return idPrestamo;
	}

	public void setIdPrestamo(int idPrestamo) {
		this.idPrestamo = idPrestamo;
	}

	public Persona getCliente() {
		return cliente;
	}

	public void setCliente(Persona cliente) {
		this.cliente = cliente;
	}

	public Movimiento getMovimiento() {
		return movimiento;
	}

	public void setMovimiento(Movimiento movimiento) {
		this.movimiento = movimiento;
	}

	public float getImporteConIntereses() {
		return importeConIntereses;
	}

	public void setImporteConIntereses(float importeConIntereses) {
		this.importeConIntereses = importeConIntereses;
	}

	public float getImportePedido() {
		return importePedido;
	}

	public void setImportePedido(float importePedido) {
		this.importePedido = importePedido;
	}



	public float getPagoMensual() {
		return pagoMensual;
	}

	public void setPagoMensual(float pagoMensual) {
		this.pagoMensual = pagoMensual;
	}

	public int getCantidadCuotas() {
		return cantidadCuotas;
	}

	public void setCantidadCuotas(int cantidadCuotas) {
		this.cantidadCuotas = cantidadCuotas;
	}

	public Date getFechaSoli() {
		return fechaSolicitada;
	}

	public void setFechaSoli(Date fechaSoli) {
		this.fechaSolicitada = fechaSoli;
	}

	public Cuentas getCuenta() {
		return cuenta;
	}

	public void setCuenta(Cuentas cuenta) {
		this.cuenta = cuenta;
	}

	public int isEstado() {
		return estado;
	}

	public void setEstado(int estado) {
		this.estado = estado;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + cantidadCuotas;
		result = prime * result + ((cliente == null) ? 0 : cliente.hashCode());
		result = prime * result + ((cuenta == null) ? 0 : cuenta.hashCode());
		result = prime * result + cuotasPagas;
		result = prime * result + estado;
		result = prime * result + ((fechaSolicitada == null) ? 0 : fechaSolicitada.hashCode());
		result = prime * result + Float.floatToIntBits(importeConIntereses);
		result = prime * result + Float.floatToIntBits(importePedido);
		result = prime * result + ((movimiento == null) ? 0 : movimiento.hashCode());
		result = prime * result + Float.floatToIntBits(pagoMensual);
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
		Prestamos other = (Prestamos) obj;
		if (cantidadCuotas != other.cantidadCuotas)
			return false;
		if (cliente == null) {
			if (other.cliente != null)
				return false;
		} else if (!cliente.equals(other.cliente))
			return false;
		if (cuenta == null) {
			if (other.cuenta != null)
				return false;
		} else if (!cuenta.equals(other.cuenta))
			return false;
		if (cuotasPagas != other.cuotasPagas)
			return false;
		if (estado != other.estado)
			return false;
		if (fechaSolicitada == null) {
			if (other.fechaSolicitada != null)
				return false;
		} else if (!fechaSolicitada.equals(other.fechaSolicitada))
			return false;
		if (Float.floatToIntBits(importeConIntereses) != Float.floatToIntBits(other.importeConIntereses))
			return false;
		if (Float.floatToIntBits(importePedido) != Float.floatToIntBits(other.importePedido))
			return false;
		if (movimiento == null) {
			if (other.movimiento != null)
				return false;
		} else if (!movimiento.equals(other.movimiento))
			return false;
		if (Float.floatToIntBits(pagoMensual) != Float.floatToIntBits(other.pagoMensual))
			return false;
		return true;
	}


	

	


	
}
