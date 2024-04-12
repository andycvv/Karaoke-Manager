package controlador;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import java.util.List;
import java.util.Locale;

import entidad.Bebida;
import entidad.Cancion;
import entidad.Pedido;
import entidad.Piqueo;
import entidad.Usuario;
import utils.Formatear;

public class ArregloPedido {
	// atributo privado
	private ArrayList<Pedido> arPedido;
	
	// constructor
	public ArregloPedido() {
		arPedido = new ArrayList<Pedido>();
		cargarDataPedido();
	}
	
	// metodos basicos publicos
	public void adicionar(Pedido p) {
		arPedido.add(p);
	}
	
	public int tamanio() {
		return arPedido.size();
	}
	
	public Pedido obtener(int pos) {
		return arPedido.get(pos);
	}
	
	public void eliminar(Pedido p) {
		arPedido.remove(p);
	}
	
	// metodos complementarios
	
	public String generarPedido() {
		int num;
		if(tamanio()==0) {
			return "PED0001";
		} else {
			num = Integer.parseInt(obtener(tamanio()-1).getIdPedido().substring(3, 7))+1;
			//Formatear
			return "PED" + Formatear.DF4.format(num);
		}
	}
	
	public Pedido buscarPedido(String idPedido) {
		for(int i = 0; i<tamanio(); i++) {
			if(obtener(i).getIdPedido().equals(idPedido)) {
				return obtener(i);
			}
		}
		return null;
	}
	
	public Pedido buscarPedidoCliente(String idCliente) {
		for(int i = 0; i<tamanio(); i++) {
			if(obtener(i).getIdCliente().equals(idCliente)) {
				return obtener(i);
			}
		}
		return null;
	}
	
	// Convertir ArrayList en Stings
	private String listaCanciones(ArrayList<Cancion> canciones){
		String linea = "";
		for(int i = 0; i<canciones.size(); i++) {
			linea += canciones.get(i).getIdCancion()+"%";
		}
		return linea;
	}
	
	private String listaBebidas(ArrayList<Bebida> bebidas){
		String linea = "";
		for(int i = 0; i<bebidas.size(); i++) {
			linea += bebidas.get(i).getIdBebida()+"#";
		}
		return linea;
	}
	
	private String listaPiqueos(ArrayList<Piqueo> piqueos){
		String linea = "";
		for(int i = 0; i<piqueos.size(); i++) {
			linea += piqueos.get(i).getIdPiqueo()+"@";
		}
		return linea;
	}
	//
	
	// Guardar la data del Pedido
	public void guardarDataPedido() {
		try {
			PrintWriter pw;
			Pedido p;
			String linea;
			// PASO A: Obtener(abrir) el archivo de texto "pedidos.txt" en modo de escritura
			pw = new PrintWriter(new File("pedidos.txt"));
			// bucle para realizar el recorrido en el ArrayList
			for(int i = 0; i<tamanio(); i++) {
				// obtener el pedido
				p = obtener(i);
				// obtener los datos del usuario --- id, nomb, ap...
				linea = p.getIdPedido()+";"+
						p.getFechaPedido()+";"+
						p.getIdUsuario()+";"+
						p.getIdCliente()+";"+
						listaCanciones(p.getCanciones())+";"+
						listaBebidas(p.getBebidas())+";"+
						listaPiqueos(p.getPiqueos())+";"+
						p.getEstado()+";"; /// linea
				// PASO B: Adicionar la informacion al archivo de texto
				pw.println(linea);
			}
			// PASO C: Cerrar el archivo
			pw.close();
			
			
		} catch (Exception e) {
			System.out.println("Error al guardar la data de los pedidos "+e.getMessage());
		}
	}
	
	// Cargar la data del Usuario
	private void cargarDataPedido() {
		try {
			// Declarar variables
			SimpleDateFormat dateFormat = new SimpleDateFormat("EEE MMM dd HH:mm:ss zzz yyyy", Locale.ENGLISH);
			BufferedReader br;
			String linea, idPedido, idUsuario, idCliente;
			ArrayList<Cancion> canciones;
			ArrayList<Bebida> bebidas;
			ArrayList<Piqueo> piqueos;
			Date fechaPedido;
			int estado;
			String[] sep;
			// PASO 1: Abrir el archivo en modo lectura "pedidos.txt"
			br = new BufferedReader(new FileReader("pedidos.txt"));
			// bucle
			while((linea = br.readLine()) != null) {
				// separar en subcadenas lo obtenido en la variable linea
				sep = linea.split(";");
				idPedido = sep[0];
				fechaPedido = dateFormat.parse(sep[1]);
				idUsuario = sep[2];
				idCliente = sep[3];
				canciones = cargarListaCanciones(sep[4]);
				bebidas = cargarListaBebidas(sep[5]);
				piqueos = cargarListaPiqueos(sep[6]);
				estado = Integer.parseInt(sep[7]);
				// Adicionar al ArrayList en un nuevo objeto
				adicionar(new Pedido(idPedido, fechaPedido, idUsuario, idCliente, canciones, bebidas, piqueos, estado));
			}
			// cerrar el archivo
			br.close();
			
		} catch (Exception e) {
			System.out.println("Error al cargar la data de los pedidos "+e.getMessage());
		}
	}
	
	// Convertir las cadenas en Arraylist
	private ArrayList<Cancion> cargarListaCanciones(String canciones){
		ArregloCancion arCancion = new ArregloCancion();
		ArrayList<Cancion> arregloCanciones = new ArrayList<Cancion>();
		String sep[] = canciones.split("%");
		for(int i = 0; i<sep.length; i++) {
			arregloCanciones.add(arCancion.buscarCancion(sep[i]));
		}
		return arregloCanciones;
	}
	
	private ArrayList<Bebida> cargarListaBebidas(String bebidas){
		ArregloBebida arBebida = new ArregloBebida();
		ArrayList<Bebida> arregloBebidas = new ArrayList<Bebida>();
		String sep[] = bebidas.split("#");
		for(int i = 0; i<sep.length; i++) {
			arregloBebidas.add(arBebida.buscarBebida(sep[i]));
		}
		return arregloBebidas;
	}
	
	private ArrayList<Piqueo> cargarListaPiqueos(String piqueos){
		ArregloPiqueo arPiqueo = new ArregloPiqueo();
		ArrayList<Piqueo> arregloPiqueos = new ArrayList<Piqueo>();
		String sep[] = piqueos.split("@");
		for(int i = 0; i<sep.length; i++) {
			arregloPiqueos.add(arPiqueo.buscarPiqueo(sep[i]));
		}
		return arregloPiqueos;
	}
	
}
