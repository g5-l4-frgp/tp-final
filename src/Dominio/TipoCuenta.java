package Dominio;

public class TipoCuenta {

		private int id;
		private String tipoCuenta;
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		public String getTipoCuenta() {
			return tipoCuenta;
		}
		public void setTipoCuenta(String tipoCuenta) {
			this.tipoCuenta = tipoCuenta;
		}
		@Override
		public String toString() {
			return "TipoCuenta [id=" + id + ", tipoCuenta=" + tipoCuenta + "]";
		}
}
