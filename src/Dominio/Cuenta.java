package Dominio;

import java.sql.Date;

public class Cuenta {
	
	private int id;
	private TipoCuenta tipoCuenta;
	private Usuario usuario;
	private Date fechaCreacion;
	private int CBU;
	private float saldo;
	public Cuenta(int id, TipoCuenta tipoCuenta, Usuario usuario, Date fechaCreacion, int cBU, float saldo) {
		super();
		this.id = id;
		this.tipoCuenta = tipoCuenta;
		this.usuario = usuario;
		this.fechaCreacion = fechaCreacion;
		CBU = cBU;
		this.saldo = saldo;
	}
	public Cuenta() {}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	@Override
	public String toString() {
		return "Cuenta [id=" + id + ", tipoCuenta=" + tipoCuenta + ", usuario=" + usuario + ", fechaCreacion="
				+ fechaCreacion + ", CBU=" + CBU + ", saldo=" + saldo + "]";
	}
	public TipoCuenta getTipoCuenta() {
		return tipoCuenta;
	}
	public void setTipoCuenta(TipoCuenta tipoCuenta) {
		this.tipoCuenta = tipoCuenta;
	}
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	public Date getFechaCreacion() {
		return fechaCreacion;
	}
	public void setFechaCreacion(Date fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}
	public int getCBU() {
		return CBU;
	}
	public void setCBU(int cBU) {
		CBU = cBU;
	}
	public float getSaldo() {
		return saldo;
	}
	public void setSaldo(float saldo) {
		this.saldo = saldo;
	}
	

}
