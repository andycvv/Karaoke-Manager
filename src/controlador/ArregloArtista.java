package controlador;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;

import entidad.Artista;
import utils.Formatear;

public class ArregloArtista{
	// atributos privados
	private ArrayList<Artista> arArtista;
	
	// constructor
	public ArregloArtista() {
		arArtista = new ArrayList<Artista>();
		cargarDataArtista();
		
//		adicionar(new Artista("ART001", "Bad Bunny", "GEN01", "13/05/2020", true));
//		adicionar(new Artista("ART002", "J Balvin", "GEN01", "23/07/2019", false));
//		adicionar(new Artista("ART003", "Adele", "GEN03", "29/12/2021", true));
	}
	
	// métodos públicos básicos
	public void adicionar(Artista a) {
		arArtista.add(a);
	}
	public int tamanio() {
		return arArtista.size();
	}
	public Artista obtener(int pos) {
		return arArtista.get(pos);
	}
	public void eliminar(Artista a) {
		arArtista.remove(a);
	}
	
	// métodos complementarios
	public Artista buscarArtista(String idArtista) {
		for(int i = 0; i<tamanio(); i++) {
			if(obtener(i).getIdArtista().equals(idArtista))
				return obtener(i);
		}
		return null;
	}
	
	public Artista buscarArtistaNombres(String nombres) {
		for(int i = 0; i<tamanio(); i++) {
			if(obtener(i).getNombreArtistico().equals(nombres))
				return obtener(i);
		}
		return null;
	}
	
	public String generarArtista() {
		int num;
		if(tamanio()==0) {
			return "ART001";
		} else {
			num = Integer.parseInt(obtener(tamanio()-1).getIdArtista().substring(3, 6))+1;
			//Formatear
			return "ART" + Formatear.DF3.format(num);
		}
	}
	
	// Guardar la data del Artista
	public void guardarDataArtista() {
		try {
			PrintWriter pw;
			Artista a;
			String linea;
			// PASO A: Obtener(abrir) el archivo de texto "artistas.txt" en modo de escritura
			pw = new PrintWriter(new File("artistas.txt"));
			// bucle para realizar el recorrido en el ArrayList
			for(int i = 0; i<tamanio(); i++) {
				// obtener el artista
				a = obtener(i);
				// obtener los datos del artista
				linea = a.getIdArtista()+";"+
						a.getNombreArtistico()+";"+
						a.getIdGenero()+";"+
						a.getFechaRegistro()+";"+
						a.getEstado()+";";
				// PASO B: Adicionar la informacion al archivo de texto
				pw.println(linea);
			}
			// PASO C: Cerrar el archivo
			pw.close();
			
			
		} catch (Exception e) {
			System.out.println("Error al guardar la data de los artistas "+e.getMessage());
		}
	}
	
	// Cargar la data del Artista
	private void cargarDataArtista() {
		try {
			// Declarar variables
			BufferedReader br;
			String linea, idArtista, nombreArtistico, idGenero;
			Date fechaRegistro;
			boolean estado;
			String[] sep;
			// PASO 1: Abrir el archivo en modo lectura "artistas.txt"
			br = new BufferedReader(new FileReader("artistas.txt"));
			// bucle
			while((linea = br.readLine()) != null) {
				// separar en subcadenas lo obtenido en la variable linea
				sep = linea.split(";");
				idArtista = sep[0];
				nombreArtistico = sep[1];
				idGenero = sep[2];
				fechaRegistro = Formatear.STRINGTODATE.parse(sep[3]);
				estado = Boolean.parseBoolean(sep[4]);
				// Adicionar al ArrayList en un nuevo objeto
				adicionar(new Artista(idArtista, nombreArtistico, idGenero, fechaRegistro, estado));
			}
			// cerrar el archivo
			br.close();
			
		} catch (Exception e) {
			System.out.println("Error al cargar la data de los piqueos "+e.getMessage());
		}
	}
}
