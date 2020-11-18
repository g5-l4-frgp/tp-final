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
	int plazoPago ;
	Cuotas cuota;
	float pagoMensual; 
	int cantidadCuotas; 
	int cuotasPagas; 
	Date fechaSoli;
	Cuentas cuenta ;
	int estado ;
	public Prestamos() {
	     contador++;
		this.idPrestamo = contador;
		this.cliente = new Persona();
		this.movimiento = new Movimiento();
		this.cuota=new Cuotas();
		this.importeConIntereses = 0;
		this.importePedido = 0;
		this.fechaSoli= new Date();
		this.plazoPago = 0;
		this.pagoMensual = 0;
		this.cantidadCuotas = 0;
		this.cuenta = new Cuentas();
		this.estado = 0;
	}
	
	public int getEstado() {
		return estado;
	}

	public Prestamos( Persona cliente, Movimiento movimiento, float importeConIntereses,
			float importePedido, int plazoPago, float pagoMensual, int cantidadCuotas, Date fechaSoli,Cuotas cuota, Cuentas cuenta,
			int estado) {
		 contador++;
			this.idPrestamo = contador;
		this.cliente = cliente;
		this.movimiento = movimiento;
		this.importeConIntereses = importeConIntereses;
		this.importePedido = importePedido;
		this.plazoPago = plazoPago;
		this.cuota=cuota;
		this.pagoMensual = pagoMensual;
		this.cantidadCuotas = cantidadCuotas;
		this.fechaSoli = fechaSoli;
		this.cuenta = cuenta;
		this.estado = estado;
	}

	public int getCuotasPagas() {
		return cuotasPagas;
	}
	
	public void setCuotasPagas(int cuotasPagas) {
		this.cuotasPagas = cuotasPagas;
	}
	public Cuotas getCuota() {
		return cuota;
	}

	public void setCuota(Cuotas cuota) {
		this.cuota = cuota;
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

	public int getPlazoPago() {
		return plazoPago;
	}

	public void setPlazoPago(int plazoPago) {
		this.plazoPago = plazoPago;
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
		return fechaSoli;
	}

	public void setFechaSoli(Date fechaSoli) {
		this.fechaSoli = fechaSoli;
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
		result = prime * result + ((cuota == null) ? 0 : cuota.hashCode());
		result = prime * result + cuotasPagas;
		result = prime * result + estado;
		result = prime * result + ((fechaSoli == null) ? 0 : fechaSoli.hashCode());
		result = prime * result + Float.floatToIntBits(importeConIntereses);
		result = prime * result + Float.floatToIntBits(importePedido);
		result = prime * result + ((movimiento == null) ? 0 : movimiento.hashCode());
		result = prime * result + Float.floatToIntBits(pagoMensual);
		result = prime * result + plazoPago;
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
		if (cuota == null) {
			if (other.cuota != null)
				return false;
		} else if (!cuota.equals(other.cuota))
			return false;
		if (cuotasPagas != other.cuotasPagas)
			return false;
		if (estado != other.estado)
			return false;
		if (fechaSoli == null) {
			if (other.fechaSoli != null)
				return false;
		} else if (!fechaSoli.equals(other.fechaSoli))
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
		if (plazoPago != other.plazoPago)
			return false;
		return true;
	}


	

	


	
}
