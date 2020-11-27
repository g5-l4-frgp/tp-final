package Entidad;

import java.util.Date;

public class Tranferencias {


	int contador=0;
	int idTransferencia;
	Movimiento movimiento ;
	Movimiento movimientoDestino ;
	float importe; 
	Cuentas cuenta ;
	Cuentas cuentaDestino ;
	boolean estado ;
	
	public Tranferencias(int idTransferencia, Movimiento movimiento,Movimiento movimientodestino, float importe, Cuentas cuenta,
			Cuentas cuentaDestino, Boolean estado) {
		super();
		
		this.movimiento = movimiento;
		this.movimientoDestino = movimientodestino;
		this.importe = importe;
		this.cuenta = cuenta;
		this.cuentaDestino = cuentaDestino;
		this.estado = estado;
	}
	
	public Movimiento getMovimientoDestino() {
		return movimientoDestino;
	}

	public void setMovimientoDestino(Movimiento movimientoDestino) {
		this.movimientoDestino = movimientoDestino;
	}

	public Tranferencias() {
		super();
		contador++;
		this.idTransferencia = contador;
		this.movimiento = new Movimiento();
		this.movimientoDestino = new Movimiento();
		this.importe = 0;
		this.cuenta = new Cuentas();
		this.cuentaDestino = new Cuentas();
		this.estado = true;
	}

	public int getIdTransferencia() {
		return idTransferencia;
	}

	public void setIdTransferencia(int idTransferencia) {
		this.idTransferencia = idTransferencia;
	}

	public Movimiento getMovimiento() {
		return movimiento;
	}

	public void setMovimiento(Movimiento movimiento) {
		this.movimiento = movimiento;
	}

	public float getImporte() {
		return importe;
	}

	public void setImporte(float importe) {
		this.importe = importe;
	}

	public Cuentas getCuenta() {
		return cuenta;
	}

	public void setCuenta(Cuentas cuenta) {
		this.cuenta = cuenta;
	}

	public Cuentas getCuentaDestino() {
		return cuentaDestino;
	}

	public void setCuentaDestino(Cuentas cuentaDestino) {
		this.cuentaDestino = cuentaDestino;
	}

	public boolean getEstado() {
		return estado;
	}

	public void setEstado(Boolean estado) {
		this.estado = estado;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cuenta == null) ? 0 : cuenta.hashCode());
		result = prime * result + ((cuentaDestino == null) ? 0 : cuentaDestino.hashCode());
		result = prime * result + (estado ? 1231 : 1237);
		result = prime * result + idTransferencia;
		result = prime * result + Float.floatToIntBits(importe);
		result = prime * result + ((movimiento == null) ? 0 : movimiento.hashCode());
		result = prime * result + ((movimientoDestino == null) ? 0 : movimientoDestino.hashCode());
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
		Tranferencias other = (Tranferencias) obj;
		if (cuenta == null) {
			if (other.cuenta != null)
				return false;
		} else if (!cuenta.equals(other.cuenta))
			return false;
		if (cuentaDestino == null) {
			if (other.cuentaDestino != null)
				return false;
		} else if (!cuentaDestino.equals(other.cuentaDestino))
			return false;
		if (estado != other.estado)
			return false;
		if (idTransferencia != other.idTransferencia)
			return false;
		if (Float.floatToIntBits(importe) != Float.floatToIntBits(other.importe))
			return false;
		if (movimiento == null) {
			if (other.movimiento != null)
				return false;
		} else if (!movimiento.equals(other.movimiento))
			return false;
		if (movimientoDestino == null) {
			if (other.movimientoDestino != null)
				return false;
		} else if (!movimientoDestino.equals(other.movimientoDestino))
			return false;
		return true;
	}

	

	
}
