package controlador;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.ArrayList;

import entidad.Bebida;
import utils.Formatear;

public class ArregloBebida {
	// atributo privado
	private ArrayList<Bebida> arBebida;
	
	// constructor
	public ArregloBebida() {
		// crear la lista
		arBebida = new ArrayList<Bebida>();
		cargarDataBebida();
		
//		adicionar(new Bebida("BEB001", "nombre1", 2, "Absolut", 50.3, true));
//		adicionar(new Bebida("BEB002", "nombre2", 4, "BARAIMA", 60.50, false));
//		adicionar(new Bebida("BEB003", "nombre3", 3, "Catena", 40.2, true));
	}
	
	// métodos públicos básicos
	public void adicionar(Bebida b) {
		arBebida.add(b);
	}
	public int tamanio() {
		return arBebida.size();
	}
	public Bebida obtener(int pos) {
		return arBebida.get(pos);
	}
	public void eliminar(Bebida b) {
		arBebida.remove(b);
	}
	
	// métodos complementarios
	public Bebida buscarBebida(String idBebida) {
		for(int i = 0; i<tamanio(); i++) {
			if(obtener(i).getIdBebida().equals(idBebida))
				return obtener(i);
		}
		return null;
	}
	
	public Bebida buscarBebidaNombre(String nombre) {
		for(int i = 0; i<tamanio(); i++) {
			if (obtener(i).getNombre().equals(nombre))
				return obtener(i);
		}
		return null;
	}
	
	public String generarBebida() {
		int num;
		if(tamanio()==0) {
			return "BEB001";
		} else {
			num = Integer.parseInt(obtener(tamanio()-1).getIdBebida().substring(3, 6))+1;
			//Formatear
			return "BEB" + Formatear.DF3.format(num);
		}
	}
	
	// Guardar la data de la Bebida
	public void guardarDataBebida() {
		try {
			PrintWriter pw;
			Bebida b;
			String linea;
			// PASO A: Obtener(abrir) el archivo de texto "bebidas.txt" en modo de escritura
			pw = new PrintWriter(new File("bebidas.txt"));
			// bucle para realizar el recorrido en el ArrayList
			for(int i = 0; i<tamanio(); i++) {
				// obtener la bebida
				b = obtener(i);
				// obtener los datos de la bebida
				linea = b.getIdBebida()+";"+
						b.getNombre()+";"+
						b.getTipoBebida()+";"+
						b.getMarca()+";"+
						b.getPrecio()+";"+
						b.getEstado()+";";
				
				// PASO B: Adicionar la informacion al archivo de texto
				pw.println(linea);
			}
			// PASO C: Cerrar el archivo
			pw.close();
			
			
		} catch (Exception e) {
			System.out.println("Error al guardar la data de las bebidas "+e.getMessage());
		}
	}
	
	// Cargar la data de la Bebida
	private void cargarDataBebida() {
		try {
			// Declarar variables
			BufferedReader br;
			String linea, idBebida, nombre, marca;
			int tipoBebida;
			double precio;
			boolean estado;
			String[] sep;
			// PASO 1: Abrir el archivo en modo lectura "bebidas.txt"
			br = new BufferedReader(new FileReader("bebidas.txt"));
			// bucle
			while((linea = br.readLine()) != null) {
				// separar en subcadenas lo obtenido en la variable linea
				sep = linea.split(";");
				idBebida = sep[0];
				nombre = sep[1];
				tipoBebida = Integer.parseInt(sep[2]);
				marca = sep[3];
				precio = Double.parseDouble(sep[4]);
				estado = Boolean.parseBoolean(sep[5]);
				// Adicionar al ArrayList en un nuevo objeto
				adicionar(new Bebida(idBebida, nombre, tipoBebida, marca, precio, estado));
			}
			// cerrar el archivo
			br.close();
			
		} catch (Exception e) {
			System.out.println("Error al cargar la data de las bebidas "+e.getMessage());
		}
	}
}
