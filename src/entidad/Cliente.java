package entidad;

import java.util.Date;

public class Cliente {
	//atributos privados
	private String idCliente;
	private String apellidoPaterno;
	private String apellidoMaterno;
	private String nombres;
	private String direccion;
	private Date fechaNacimiento;
	private Date fechaAfiliacion;
	private String estadoCivil;
	private String telefono;
	private String  dni;
	private int tipoDeCliente;
	//constructores
	public Cliente(String idCliente, String apellidoPaterno, String apellidoMaterno, String nombres, String direccion,
			Date fechaNacimiento, Date fechaAfiliacion, String estadoCivil, String telefono, String dni,
			int tipoDeCliente) {
		this.idCliente = idCliente;
		this.apellidoPaterno = apellidoPaterno;
		this.apellidoMaterno = apellidoMaterno;
		this.nombres = nombres;
		this.direccion = direccion;
		this.fechaNacimiento = fechaNacimiento;
		this.fechaAfiliacion = fechaAfiliacion;
		this.estadoCivil = estadoCivil;
		this.telefono = telefono;
		this.dni = dni;
		this.tipoDeCliente = tipoDeCliente;
	}
	public Cliente() {
		
	}
	//metodos de acceso GET/SET
	
	public String getIdCliente() {
		return idCliente;
	}
	public void setIdCliente(String idCliente) {
		this.idCliente = idCliente;
	}
	public String getApellidoPaterno() {
		return apellidoPaterno;
	}
	public void setApellidoPaterno(String apellidoPaterno) {
		this.apellidoPaterno = apellidoPaterno;
	}
	public String getApellidoMaterno() {
		return apellidoMaterno;
	}
	public void setApellidoMaterno(String apellidoMaterno) {
		this.apellidoMaterno = apellidoMaterno;
	}
	public String getNombres() {
		return nombres;
	}
	public void setNombres(String nombres) {
		this.nombres = nombres;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}
	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}
	public Date getFechaAfiliacion() {
		return fechaAfiliacion;
	}
	public void setFechaAfiliacion(Date fechaAfiliacion) {
		this.fechaAfiliacion = fechaAfiliacion;
	}
	public String getEstadoCivil() {
		return estadoCivil;
	}
	public void setEstadoCivil(String estadoCivil) {
		this.estadoCivil = estadoCivil;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	public String getDni() {
		return dni;
	}
	public void setDni(String dni) {
		this.dni = dni;
	}
	public int getTipoDeCliente() {
		return tipoDeCliente;
	}
	public void setTipoDeCliente(int tipoDeCliente) {
		this.tipoDeCliente = tipoDeCliente;
	}
	
}