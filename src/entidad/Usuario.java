package entidad;

public class Usuario {
//atributos privados
	private String idUsuario;
	private String apellidoPaterno;
	private String apellidoMaterno;
	private String nombre;
	private int tipoEmpleado;
	private String login;
	private String password;
	private int turno;
	//constructores 
	public Usuario(String idUsuario, String apellidoPaterno, String apellidoMaterno, String nombres, int tipoEmpleado,
			String login, String password, int turno) {
		this.idUsuario = idUsuario;
		this.apellidoPaterno = apellidoPaterno;
		this.apellidoMaterno = apellidoMaterno;
		this.nombre = nombres;
		this.tipoEmpleado = tipoEmpleado;
		this.login = login;
		this.password = password;
		this.turno = turno;
	}
	public Usuario() {
		
	}
	//metodos SET/GET
	public String getIdUsuario() {
		return idUsuario;
	}
	public void setIdUsuario(String idUsuario) {
		this.idUsuario = idUsuario;
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
	public String getNombre() {
		return nombre;
	}
	public void setNombres(String nombre) {
		this.nombre = nombre;
	}
	public int getTipoEmpleado() {
		return tipoEmpleado;
	}
	public void setTipoEmpleado(int tipoEmpleado) {
		this.tipoEmpleado = tipoEmpleado;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getTurno() {
		return turno;
	}
	public void setTurno(int turno) {
		this.turno = turno;
	}
	
	
}