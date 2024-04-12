package entidad;

public class Piqueo {
	//atributos privados
	private String idPiqueo;
	private String nombre;
	private int tipoPiqueo;
	private double precio;
	private boolean estado;
	
	//constructores
	public Piqueo(String idPiqueo, String nombre, int tipoPiqueo, double precio, boolean estado) {
		this.idPiqueo = idPiqueo;
		this.nombre = nombre;
		this.tipoPiqueo = tipoPiqueo;
		this.precio = precio;
		this.estado = estado;
	}

	
	public Piqueo() {
		
	}
	
	//metodos de acceso GET/SET
	public String getIdPiqueo() {
		return idPiqueo;
	}

	public void setIdPiqueo(String idPiqueo) {
		this.idPiqueo = idPiqueo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getTipoPiqueo() {
		return tipoPiqueo;
	}

	public void setTipoPiqueo(int tipoPiqueo) {
		this.tipoPiqueo = tipoPiqueo;
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
