package entidad;

import java.util.Date;

public class Cancion {
	//atributos privados
	private String idCancion;
	private String nombre;
	private String idArtista;
	private String album;
	private Date fechaRegistro;
	private int numReprod;
	private boolean estado;
	
	//constructores
	public Cancion(String idCancion, String nombre, String idArtista, String album, Date fechaRegistro, int numReprod,
			boolean estado) {
		this.idCancion = idCancion;
		this.nombre = nombre;
		this.idArtista = idArtista;
		this.album = album;
		this.fechaRegistro = fechaRegistro;
		this.numReprod = numReprod;
		this.estado = estado;
	}
	
	public Cancion() {
		
	}

	//metodos de acceso SET/GET
	public String getIdCancion() {
		return idCancion;
	}
	public void setIdCancion(String idCancion) {
		this.idCancion = idCancion;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getIdArtista() {
		return idArtista;
	}
	public void setIdArtista(String idArtista) {
		this.idArtista = idArtista;
	}
	public String getAlbum() {
		return album;
	}
	public void setAlbum(String album) {
		this.album = album;
	}
	public Date getFechaRegistro() {
		return fechaRegistro;
	}
	public void setFechaRegistro(Date fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}
	public int getNumReprod() {
		return numReprod;
	}
	public void setNumReprod(int numReprod) {
		this.numReprod = numReprod;
	}
	public boolean getEstado() {
		return estado;
	}
	public void setEstado(boolean estado) {
		this.estado = estado;
	}
	
	
}
