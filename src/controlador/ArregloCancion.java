package controlador;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import entidad.Cancion;
import utils.Formatear;

public class ArregloCancion {
	// atributo privado
	ArrayList<Cancion> arCancion;
	
	// constructor
	public ArregloCancion() {
		arCancion = new ArrayList<Cancion>();
		cargarDataCancion();
//		adicionar(new Cancion("CAN0001", "MONACO", "ART001", "nadie sabe lo que va a pasar mañana", "18/11/2023", 57, true));
//		adicionar(new Cancion("CAN0002", "Amarillo", "ART002", "Colores", "15/09/2023", 29, false));
//		adicionar(new Cancion("CAN0003", "LOS PITS", "ART001", "nadie sabe lo que va a pasar mañana", "15/11/2023", 40, true));
	}
	
	// metodos publicos basicos
	public void adicionar(Cancion c) {
		arCancion.add(c);
	}
	
	public int tamanio() {
		return arCancion.size();
	}
	
	public Cancion obtener(int pos) {
		return arCancion.get(pos);
	}
	
	public void eliminar(Cancion c) {
		arCancion.remove(c);
	}
	
	// metodos complementarios
	public Cancion buscarCancion(String idCancion) {
		for(int i = 0; i<tamanio(); i++) {
			if(obtener(i).getIdCancion().equals(idCancion)) {
				return obtener(i);
			}
		}
		return null;
	}
	
	public Cancion buscarCancionNombre(String idCancionNombre) {
		for(int i = 0; i<tamanio(); i++) {
			if(obtener(i).getNombre().equals(idCancionNombre)) {
				return obtener(i);
			}
		}
		return null;
	}
	
	public String generarCancion() {
		int num;
		if(tamanio()==0) {
			return "CAN0001";
		} else {
			num = Integer.parseInt(obtener(tamanio()-1).getIdCancion().substring(3, 7))+1;
			//Formatear
			return "CAN" + Formatear.DF4.format(num);
		}
	}
	
	// Guardar la data de Cancion
	public void guardarDataCancion() {
		try {
			PrintWriter pw;
			Cancion c;
			String linea;
			// PASO A: Obtener(abrir) el archivo de texto "canciones.txt" en modo de escritura
			pw = new PrintWriter(new File("canciones.txt"));
			// bucle para realizar el recorrido en el ArrayList
			for(int i = 0; i<tamanio(); i++) {
				// obtener el usuario
				c = obtener(i);
				// obtener los datos de cancion
				linea = c.getIdCancion()+";"+
						c.getNombre()+";"+
						c.getIdArtista()+";"+
						c.getAlbum()+";"+
						c.getFechaRegistro()+";"+
						c.getNumReprod()+";"+
						c.getEstado()+";";
				// PASO B: Adicionar la informacion al archivo de texto
				pw.println(linea);
			}
			// PASO C: Cerrar el archivo
			pw.close();
			
			
		} catch (Exception e) {
			System.out.println("Error al guardar la data de las canciones "+e.getMessage());
		}
	}
	
	// Cargar la data de Cancion
	private void cargarDataCancion() {
		try {
			// Declarar variables
			// formatear fechas
			SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
			BufferedReader br;
			String linea, idCancion, nombre, idArtista, album;
			Date fechaRegistro;
			int numReprod;
			boolean estado;
			String[] sep;
			// PASO 1: Abrir el archivo en modo lectura "canciones.txt"
			br = new BufferedReader(new FileReader("canciones.txt"));
			// bucle
			while((linea = br.readLine()) != null) {
				// separar en subcadenas lo obtenido en la variable linea
				sep = linea.split(";");
				idCancion = sep[0];
				nombre = sep[1];
				idArtista = sep[2];
				album = sep[3];
				fechaRegistro = Formatear.STRINGTODATE.parse(sep[4]);
				numReprod = Integer.parseInt(sep[5]);
				estado = Boolean.parseBoolean(sep[6]);
				// Adicionar al ArrayList en un nuevo objeto
				adicionar(new Cancion(idCancion, nombre, idArtista, album, fechaRegistro, numReprod, estado));
			}
			// cerrar el archivo
			br.close();
			
		} catch (Exception e) {
			System.out.println("Error al cargar la data de las canciones "+e.getMessage());
		}
	}
}
