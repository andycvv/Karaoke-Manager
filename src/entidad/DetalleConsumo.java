package entidad;

public class DetalleConsumo {
	//Atributo privado
	private String codigoConsumo;
	private String codigoProducto;
	private int cantidad;
	private double subtotal;
	
	//constructores
	public DetalleConsumo() {
		
	}
	public DetalleConsumo(String codigoConsumo, String codigoProducto, int cantidad, double subtotal) {
		super();
		this.codigoConsumo = codigoConsumo;
		this.codigoProducto = codigoProducto;
		this.cantidad = cantidad;
		this.subtotal = subtotal;
	}


	//Metodos de acceso GET/SET
	public String getCodigoConsumo() {
		return codigoConsumo;
	}


	public void setCodigoConsumo(String codigoConsumo) {
		this.codigoConsumo = codigoConsumo;
	}


	public String getCodigoProducto() {
		return codigoProducto;
	}


	public void setCodigoProducto(String codigoProducto) {
		this.codigoProducto = codigoProducto;
	}


	public int getCantidad() {
		return cantidad;
	}


	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}


	public double getSubtotal() {
		return subtotal;
	}


	public void setSubtotal(double subtotal) {
		this.subtotal = subtotal;
	}
	
}