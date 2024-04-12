package entidad;

public class Genero {
	//atributos privados
	private String idGenero;
	private String descripcion;
	private int epoca;
	private boolean estado;
	
	//constructores
	public Genero(String idGenero, String descripcion, int epoca, boolean estado) {
		this.idGenero = idGenero;
		this.descripcion = descripcion;
		this.epoca = epoca;
		this.estado = estado;
	}

	public Genero() {
		
	}

	//metodos de acceso GET/SET
	public String getIdGenero() {
		return idGenero;
	}

	public void setIdGenero(String idGenero) {
		this.idGenero = idGenero;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public int getEpoca() {
		return epoca;
	}

	public void setEpoca(int epoca) {
		this.epoca = epoca;
	}

	public boolean getEstado() {
		return estado;
	}

	public void setEstado(boolean estado) {
		this.estado = estado;
	}
	
	
}
