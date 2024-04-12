package controlador;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.ArrayList;

import entidad.Genero;
import utils.Formatear;

public class ArregloGenero {
	// atributo privado
	private ArrayList<Genero> arGenero;
	
	// constructor
	public ArregloGenero() {
		arGenero = new ArrayList<Genero>();
		cargarDataGenero();
//		adicionar(new Genero("GEN01", "Género más popular entre los jovenes", 1990, true));
//		adicionar(new Genero("GEN02", "Género menos escuchada de los ultimos años", 1975, false));
//		adicionar(new Genero("GEN03", "Género escuchada entre los adultos de la epoca", 1970, true));
	}
	
	// métodos públicos
	public void adicionar(Genero g) {
		arGenero.add(g);
	}
	
	public Genero obtener(int pos) {
		return arGenero.get(pos);
	}
	
	public int tamanio() { 
		return arGenero.size();
	}
	
	public void eliminar(Genero g) {
		arGenero.remove(g);
	}
	
	// métodos complementarios
	public Genero buscarGenero(String idGenero) {
		for(int i = 0; i<tamanio(); i++) {
			if(obtener(i).getIdGenero().equals(idGenero))
				return obtener(i);
		}
		return null;
	}
	
	public String generarGenero() {
		int num;
		if(tamanio()==0) {
			return "GEN01";
		} else {
			num = Integer.parseInt(obtener(tamanio()-1).getIdGenero().substring(3, 5))+1;
			//Formatear
			return "GEN" + Formatear.DF2.format(num);
		}
	}
	
	// Guardar la data del Genero
	public void guardarDataGenero() {
		try {
			PrintWriter pw;
			Genero g;
			String linea;
			// PASO A: Obtener(abrir) el archivo de texto "generos.txt" en modo de escritura
			pw = new PrintWriter(new File("generos.txt"));
			// bucle para realizar el recorrido en el ArrayList
			for(int i = 0; i<tamanio(); i++) {
				// obtener el Genero
				g = obtener(i);
				// obtener los datos del Genero
				linea = g.getIdGenero()+";"+
						g.getDescripcion()+";"+
						g.getEpoca()+";"+
						g.getEstado()+";";
				// PASO B: Adicionar la informacion al archivo de texto
				pw.println(linea);
			}
			// PASO C: Cerrar el archivo
			pw.close();
			
			
		} catch (Exception e) {
			System.out.println("Error al guardar la data de los géneros "+e.getMessage());
		}
	}
	
	// Cargar la data de Genero
	private void cargarDataGenero() {
		try {
			// Declarar variables
			BufferedReader br;
			String linea, idGenero, descripcion;
			int epoca;
			boolean estado;
			String[] sep;
			// PASO 1: Abrir el archivo en modo lectura "generos.txt"
			br = new BufferedReader(new FileReader("generos.txt"));
			// bucle
			while((linea = br.readLine()) != null) {
				// separar en subcadenas lo obtenido en la variable linea
				sep = linea.split(";");
				idGenero = sep[0];
				descripcion = sep[1];
				epoca = Integer.parseInt(sep[2]);
				estado = Boolean.parseBoolean(sep[3]);
				// Adicionar al ArrayList en un nuevo objeto
				adicionar(new Genero(idGenero, descripcion, epoca, estado));
			}
			// cerrar el archivo
			br.close();
			
		} catch (Exception e) {
			System.out.println("Error al cargar la data de los géneros "+e.getMessage());
		}
	}
}
