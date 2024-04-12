package controlador;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

import entidad.Consumo;
import utils.Formatear;

public class ArregloConsumo {
	// atributo privado
	private ArrayList<Consumo> arConsumo;
	
	// constructor
	public ArregloConsumo() {
		arConsumo = new ArrayList<Consumo>();
		cargarDataConsumo();
	}
	
	// metodos publicos basicos
	public void adicionar(Consumo c) {
		arConsumo.add(c);
	}
	
	public int tamanio() {
		return arConsumo.size();
	}
	
	public Consumo obtener(int pos) {
		return arConsumo.get(pos);
	}
	
	public void eliminar(Consumo c) {
		arConsumo.remove(c);
	}
	
	// metodos complementarios
	public Consumo buscarConsumo(String codigoConsumo) {
		for(int i = 0; i<tamanio(); i++) {
			if(obtener(i).getCodigoConsumo().equals(codigoConsumo)) {
				return obtener(i);
			}
		}
		return null;
	}
	
	public Consumo buscarConsumoIdPedido(String idPedido) {
		for(int i = 0; i<tamanio(); i++) {
			if(obtener(i).getIdPedido().equals(idPedido))
				return obtener(i);
		}
		return null;
	}
	
	public Consumo buscarConsumoIdCliente(String idCliente) {
		for(int i = 0; i<tamanio(); i++) {
			if(obtener(i).getIdCliente().equals(idCliente))
				return obtener(i);
		}
		return null;
	}

	public boolean existeConsumoParaPedido(String idPedido) {
		for(int i = 0; i<tamanio(); i++) {
			if(obtener(i).getIdPedido().equals(idPedido))
				return true;
		}
		return false;
	}
	
	public String generarConsumo() {
		int num;
		if(tamanio()==0) {
			return "CON0001";
		} else {
			num = Integer.parseInt(obtener(tamanio()-1).getCodigoConsumo().substring(3, 7))+1;
			//Formatear
			return "CON" + Formatear.DF4.format(num);
		}
	}
	
	// Guardar la data del Consumo
	public void guardarDataConsumo() {
		try {
			PrintWriter pw;
			Consumo c;
			String linea;
			// PASO A: Obtener(abrir) el archivo de texto "consumos.txt" en modo de escritura
			pw = new PrintWriter(new File("consumos.txt"));
			// bucle para realizar el recorrido en el ArrayList
			for(int i = 0; i<tamanio(); i++) {
				// obtener el usuario
				c = obtener(i);
				// obtener los datos del Consumo
				linea = c.getCodigoConsumo()+";"+
						c.getIdCliente()+";"+
						c.getIdPedido()+";"+
						c.getFechaConsumo()+";"+
						c.getImporteTotal()+";";
				// PASO B: Adicionar la informacion al archivo de texto
				pw.println(linea);
			}
			// PASO C: Cerrar el archivo
			pw.close();
			
			
		} catch (Exception e) {
			System.out.println("Error al guardar la data de los consumos "+e.getMessage());
		}
	}
	
	// Cargar la data del Consumo
	private void cargarDataConsumo() {
		SimpleDateFormat dateFormat = new SimpleDateFormat("EEE MMM dd HH:mm:ss z yyyy", Locale.ENGLISH);
		try {
			// Declarar variables
			BufferedReader br;
			String linea, codConsumo, idCliente, idPedido;
			Date fecConsumo;
			double impTotal;
			String[] sep;
			// PASO 1: Abrir el archivo en modo lectura "consumos.txt"
			br = new BufferedReader(new FileReader("consumos.txt"));
			// bucle
			while((linea = br.readLine()) != null) {
				// separar en subcadenas lo obtenido en la variable linea
				sep = linea.split(";");
				codConsumo = sep[0];
				idCliente = sep[1];
				idPedido = sep[2];
				fecConsumo = dateFormat.parse(sep[3]);
				impTotal = Double.parseDouble(sep[4]);
				// Adicionar al ArrayList en un nuevo objeto
				adicionar(new Consumo(codConsumo, idCliente, idPedido, fecConsumo, impTotal));
			}
			// cerrar el archivo
			br.close();
			
		} catch (Exception e) {
			System.out.println("Error al cargar la data de los consumos "+e.getMessage());
		}
	}
}
