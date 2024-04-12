package entidad;

import java.util.Date;

public class Artista {
	//atributos privados
	private String idArtista;
	private String nombreArtistico;
	private String idGenero;
	private Date fechaRegistro;
	private boolean estado;
	
	//constructores
	public Artista(String idArtista, String nombreArtistico, String idGenero, Date fechaRegistro, boolean estado) {
		this.idArtista = idArtista;
		this.nombreArtistico = nombreArtistico;
		this.idGenero = idGenero;
		this.fechaRegistro = fechaRegistro;
		this.estado = estado;
	}

	public Artista() {
		
	}

	//metodos de acceso GET/SET
	public String getIdArtista() {
		return idArtista;
	}

	public void setIdArtista(String idArtista) {
		this.idArtista = idArtista;
	}

	public String getNombreArtistico() {
		return nombreArtistico;
	}

	public void setNombreArtistico(String nombreArtistico) {
		this.nombreArtistico = nombreArtistico;
	}

	public String getIdGenero() {
		return idGenero;
	}

	public void setIdGenero(String idGenero) {
		this.idGenero = idGenero;
	}

	public Date getFechaRegistro() {
		return fechaRegistro;
	}

	public void setFechaRegistro(Date fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}

	public boolean getEstado() {
		return estado;
	}

	public void setEstado(boolean estado) {
		this.estado = estado;
	}
	
}
