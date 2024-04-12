package controlador;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.ArrayList;

import entidad.Piqueo;
import utils.Formatear;

public class ArregloPiqueo {
	// atributo privado
	private ArrayList<Piqueo> arPiqueo;
	
	// constructor
	public ArregloPiqueo() {
		// crear la lista
		arPiqueo = new ArrayList<Piqueo>();
		cargarDataPiqueo();
		// adicionar piqueos
//		adicionar(new Piqueo("PIQ001", "Papays Lays", 2, 7.5, false));
//		adicionar(new Piqueo("PIQ002", "Pringles", 1, 10.5, true));
//		adicionar(new Piqueo("PIQ003", "Chisitos", 3, 12.5, true));
	}
	
	// métodos públicos básicos
	public void adicionar(Piqueo p) {
		arPiqueo.add(p);
	}
	public int tamanio() {
		return arPiqueo.size();
	}
	public Piqueo obtener(int pos) {
		return arPiqueo.get(pos);
	}
	public void eliminar(Piqueo p) {
		arPiqueo.remove(p);
	}
	
	// métodos complementarios
	public Piqueo buscarPiqueo(String idPiqueo) {
		for(int i = 0; i<tamanio(); i++) {
			if(obtener(i).getIdPiqueo().equals(idPiqueo))
				return obtener(i);
		}
		return null;
	}
	
	public Piqueo buscarPiqueoNombre(String nombre) {
		for(int i = 0; i<tamanio(); i++) {
			if(obtener(i).getNombre().equals(nombre))
				return obtener(i);
		}
		return null;
	}
	
	public String generarPiqueo() {
		int num;
		if(tamanio()==0) {
			return "PIQ001";
		} else {
			num = Integer.parseInt(obtener(tamanio()-1).getIdPiqueo().substring(3, 6))+1;
			//Formatear
			return "PIQ" + Formatear.DF3.format(num);
		}
	}
	
	// Guardar la data del Piqueo
	public void guardarDataPiqueo() {
		try {
			PrintWriter pw;
			Piqueo p;
			String linea;
			// PASO A: Obtener(abrir) el archivo de texto "piqueos.txt" en modo de escritura
			pw = new PrintWriter(new File("piqueos.txt"));
			// bucle para realizar el recorrido en el ArrayList
			for(int i = 0; i<tamanio(); i++) {
				// obtener el piqueo
				p = obtener(i);
				// obtener los datos del piqueo
				linea = p.getIdPiqueo()+";"+
						p.getNombre()+";"+
						p.getTipoPiqueo()+";"+
						p.getPrecio()+";"+
						p.getEstado()+";";
				// PASO B: Adicionar la informacion al archivo de texto
				pw.println(linea);
			}
			// PASO C: Cerrar el archivo
			pw.close();
			
			
		} catch (Exception e) {
			System.out.println("Error al guardar la data de los piqueos "+e.getMessage());
		}
	}
	
	// Cargar la data del Piqueo
	private void cargarDataPiqueo() {
		try {
			// Declarar variables
			BufferedReader br;
			String linea, idPiqueo, nombre;
			int tipo;
			double precio;
			boolean estado;
			String[] sep;
			// PASO 1: Abrir el archivo en modo lectura "piqueos.txt"
			br = new BufferedReader(new FileReader("piqueos.txt"));
			// bucle
			while((linea = br.readLine()) != null) {
				// separar en subcadenas lo obtenido en la variable linea
				sep = linea.split(";");
				idPiqueo = sep[0];
				nombre = sep[1];
				tipo = Integer.parseInt(sep[2]);
				precio = Double.parseDouble(sep[3]);
				estado = Boolean.parseBoolean(sep[4]);
				// Adicionar al ArrayList en un nuevo objeto
				adicionar(new Piqueo(idPiqueo, nombre, tipo, precio, estado));
			}
			// cerrar el archivo
			br.close();
			
		} catch (Exception e) {
			System.out.println("Error al cargar la data de los piqueos "+e.getMessage());
		}
	}
}
