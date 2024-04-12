package controlador;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.ArrayList;

import entidad.Usuario;
import utils.Formatear;

public class ArregloUsuario {
	//atributo privado
	private ArrayList<Usuario> arUsuario;
	
	//constructor
	public ArregloUsuario() {
		// Crear a la lista
		arUsuario = new ArrayList<Usuario>();
		cargarDataUsuario();
		// Adicionar usuarios
//		adicionar(new Usuario("USU001", "Vargas", "Vargas", "Andy", 1, "n0001", "159263", 2));
//		adicionar(new Usuario("USU002", "Aucassi", "Loa", "Yadira", 1, "n0002", "123456", 1));
//		adicionar(new Usuario("USU003", "Meza", "Chanco", "Brahayan", 2, "n0003", "235123", 1));
	}
	
	//métodos públicos básicos
	public void adicionar(Usuario u) {
		arUsuario.add(u);
	}
	
	public int tamanio() {
		return arUsuario.size();
	}
	
	public Usuario obtener(int pos) {
		return arUsuario.get(pos);
	}
	
	public void eliminar(Usuario u) {
		arUsuario.remove(u);
	}
	
	//métodos públicos complementarios
	public Usuario buscarUsuario(String idUser) {
		for(int i = 0; i<tamanio(); i++) {
			if(obtener(i).getIdUsuario().equals(idUser)) {
				return obtener(i);
			}
		}
		return null;
	}
	
	public Usuario buscarUsuarioLogin(String login) {
		for(int i = 0; i<tamanio(); i++) {
			if(obtener(i).getLogin().equals(login))
				return obtener(i);
		}
		return null;
	}
	
	public Usuario buscarUsuarioNombre(String nombre) {
		for(int i = 0; i<tamanio(); i++) {
			if(obtener(i).getNombre().equals(nombre))
				return obtener(i);
		}
		return null;
	}
	
	public String encontrarLogin(String login) {
		for(int i = 0; i<tamanio(); i++) {
			if(obtener(i).getLogin().equals(login)) {
				return login;
			}
		}
		return null;
	}
	
	public String encontrarPassword(String password) {
		for(int i = 0; i<tamanio(); i++) {
			if(obtener(i).getPassword().equals(password)) {
				return password;
			}
		}
		return null;
	}
	
		// Generar codigo
	public String generarUsuario() {
		int num;
		if(tamanio()==0) {
			return "USU001";
		} else {
			num = Integer.parseInt(obtener(tamanio()-1).getIdUsuario().substring(3, 6))+1;
			//Formatear
			return "USU" + Formatear.DF3.format(num);
		}
	}
	
	// Guardar la data del Usuario
	public void guardarDataUsuario() {
		try {
			PrintWriter pw;
			Usuario u;
			String linea;
			// PASO A: Obtener(abrir) el archivo de texto "usuarios.txt" en modo de escritura
			pw = new PrintWriter(new File("usuarios.txt"));
			// bucle para realizar el recorrido en el ArrayList
			for(int i = 0; i<tamanio(); i++) {
				// obtener el usuario
				u = obtener(i);
				// obtener los datos del usuario --- id, nomb, ap...
				linea = u.getIdUsuario()+";"+
						u.getApellidoPaterno()+";"+
						u.getApellidoMaterno()+";"+
						u.getNombre()+";"+
						u.getTipoEmpleado()+";"+
						u.getLogin()+";"+
						u.getPassword()+";"+
						u.getTurno()+";"; /// linea = "USU001;Vargas;Vargas;Andy;1;n0001;159263;2"
				// PASO B: Adicionar la informacion al archivo de texto
				pw.println(linea);
			}
			// PASO C: Cerrar el archivo
			pw.close();
			
			
		} catch (Exception e) {
			System.out.println("Error al guardar la data de los usuarios "+e.getMessage());
		}
	}
	
	// Cargar la data del Usuario
	private void cargarDataUsuario() {
		try {
			// Declarar variables
			BufferedReader br;
			String linea, idUser, apPat, apMat, nomb, log, clave;
			int tipEmpl, turno;
			String[] sep;
			// PASO 1: Abrir el archivo en modo lectura "usuarios.txt"
			br = new BufferedReader(new FileReader("usuarios.txt"));
			// bucle
			while((linea = br.readLine()) != null) {
				// separar en subcadenas lo obtenido en la variable linea
				// "USU001;Vargas;Vargas;Andy;1;n0001;159263;2"
				sep = linea.split(";");
				idUser = sep[0];
				apPat = sep[1];
				apMat = sep[2];
				nomb = sep[3];
				tipEmpl = Integer.parseInt(sep[4]);
				log = sep[5];
				clave = sep[6];
				turno = Integer.parseInt(sep[7]);
				// Adicionar al ArrayList en un nuevo objeto
				adicionar(new Usuario(idUser, apPat, apMat, nomb, tipEmpl, log, clave, turno));
			}
			// cerrar el archivo
			br.close();
			
		} catch (Exception e) {
			System.out.println("Error al cargar la data de los usuarios "+e.getMessage());
		}
	}
}
