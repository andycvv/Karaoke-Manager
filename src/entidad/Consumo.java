package entidad;
import java.util.Date;
public class Consumo {
	//Atributo privados
	private String codigoConsumo;
	private String idCliente;
	private String idPedido;
	private Date fechaConsumo;
	private double importeTotal;
	
	//constructores
	public Consumo() {
		
	}
	
	public Consumo(String codigoConsumo, String idCliente, String idPedido, Date fechaConsumo, double importeTotal) {
		super();
		this.codigoConsumo = codigoConsumo;
		this.idCliente = idCliente;
		this.idPedido = idPedido;
		this.fechaConsumo = fechaConsumo;
		this.importeTotal = importeTotal;
	}

	//Metodos de acceso GET/SET
	public String getCodigoConsumo() {
		return codigoConsumo;
	}

	public void setCodigoConsumo(String codigoConsumo) {
		this.codigoConsumo = codigoConsumo;
	}

	public String getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(String idCliente) {
		this.idCliente = idCliente;
	}

	public String getIdPedido() {
		return idPedido;
	}

	public void setIdPedido(String idPedido) {
		this.idPedido = idPedido;
	}

	public Date getFechaConsumo() {
		return fechaConsumo;
	}

	public void setFechaConsumo(Date fechaConsumo) {
		this.fechaConsumo = fechaConsumo;
	}

	public double getImporteTotal() {
		return importeTotal;
	}

	public void setImporteTotal(double importeTotal) {
		this.importeTotal = importeTotal;
	}
	
}