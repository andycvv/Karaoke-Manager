package entidad;

public class Bebida {
//	Atributos privados
	private String idBebida;
	private String nombre;
	private int tipoBebida;
	private String marca;
	private double precio;
	private boolean estado;
	
//	Constructor
	public Bebida() {
		
	}
	
	public Bebida(String idBebida, String nombre, int tipoBebida, String marca, double precio, boolean estado) {
		this.idBebida = idBebida;
		this.nombre = nombre;
		this.tipoBebida = tipoBebida;
		this.marca = marca;
		this.precio = precio;
		this.estado = estado;
	}
	
//	Métodos de acceso GET/SET
		public String getIdBebida() {
			return idBebida;
		}

		public void setIdBebida(String idBebida) {
			this.idBebida = idBebida;
		}

		public String getNombre() {
			return nombre;
		}

		public void setNombre(String nombre) {
			this.nombre = nombre;
		}

		public int getTipoBebida() {
			return tipoBebida;
		}

		public void setTipoBebida(int tipoBebida) {
			this.tipoBebida = tipoBebida;
		}

		public String getMarca() {
			return marca;
		}

		public void setMarca(String marca) {
			this.marca = marca;
		}

		public double getPrecio() {
			return precio;
		}

		public void setPrecio(double precio) {
			this.precio = precio;
		}

		public boolean getEstado() {
			return estado;
		}

		public void setEstado(boolean estado) {
			this.estado = estado;
		}
	
	
}