package Entidad;

import java.util.*;

public class Cuotas {
	
		int contador=0;
		int idCuota; 
		Prestamos prestamo; 
		String fechaMes ;
		float importe ;
		Date fechaVencimiento; 
		Date fechaPago; 
	    int estado; 
		
		public Cuotas( Prestamos prestamo, String fechaMes, float importe, Date fechaVencimiento,
				Date fechaPago, int estado) {
			contador++;
			this.idCuota = contador;
			this.prestamo = prestamo;
			this.fechaMes = fechaMes;
			this.importe = importe;
			this.fechaVencimiento = fechaVencimiento;
			this.fechaPago = fechaPago;
			this.estado = estado;
		}
		
		public Cuotas() {
			super();
			this.idCuota = 0;
			this.prestamo = new Prestamos();
			this.fechaMes =null;
			this.importe = 0;
			this.fechaVencimiento = new Date();
			this.fechaPago = new Date();;
			this.estado = 0;
		}
		public int getCuota() {
			return idCuota;
		}
		public void setCuota(int cuota) {
			this.idCuota = cuota;
		}
		public Prestamos getPrestamo() {
			return prestamo;
		}
		public void setPrestamo(Prestamos prestamo) {
			this.prestamo = prestamo;
		}
		public String getFechaMes() {
			return fechaMes;
		}
		public void setFechaMes(String fechaMes) {
			this.fechaMes = fechaMes;
		}
		public float getImporte() {
			return importe;
		}
		public void setImporte(float importe) {
			this.importe = importe;
		}
		public Date getFechaVencimiento() {
			return fechaVencimiento;
		}
		public void setFechaVencimiento(Date fechaVencimiento) {
			this.fechaVencimiento = fechaVencimiento;
		}
		public Date getFechaPago() {
			return fechaPago;
		}
		public void setFechaPago(Date fechaPago) {
			this.fechaPago = fechaPago;
		}
		public int getEstado() {
			return estado;
		}
		public void setEstado(int estado) {
//			switch (estado)
//			{
//			case 1:
//			{
//				this.estado="Pago";
//			}
//			case 2:
//			{
//				this.estado="Vencido";
//			}
//			case 3:
//			{
//				this.estado="Pendiente";
//			}
//			
//			}
			this.estado=estado;
			
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + contador;
			result = prime * result + estado;
			result = prime * result + ((fechaMes == null) ? 0 : fechaMes.hashCode());
			result = prime * result + ((fechaPago == null) ? 0 : fechaPago.hashCode());
			result = prime * result + ((fechaVencimiento == null) ? 0 : fechaVencimiento.hashCode());
			result = prime * result + idCuota;
			result = prime * result + Float.floatToIntBits(importe);
			result = prime * result + ((prestamo == null) ? 0 : prestamo.hashCode());
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
			Cuotas other = (Cuotas) obj;
			if (contador != other.contador)
				return false;
			if (estado != other.estado)
				return false;
			if (fechaMes == null) {
				if (other.fechaMes != null)
					return false;
			} else if (!fechaMes.equals(other.fechaMes))
				return false;
			if (fechaPago == null) {
				if (other.fechaPago != null)
					return false;
			} else if (!fechaPago.equals(other.fechaPago))
				return false;
			if (fechaVencimiento == null) {
				if (other.fechaVencimiento != null)
					return false;
			} else if (!fechaVencimiento.equals(other.fechaVencimiento))
				return false;
			if (idCuota != other.idCuota)
				return false;
			if (Float.floatToIntBits(importe) != Float.floatToIntBits(other.importe))
				return false;
			if (prestamo == null) {
				if (other.prestamo != null)
					return false;
			} else if (!prestamo.equals(other.prestamo))
				return false;
			return true;
		}
		
		
		
    
}
