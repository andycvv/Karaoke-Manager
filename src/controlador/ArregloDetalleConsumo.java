package controlador;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import entidad.DetalleConsumo;

public class ArregloDetalleConsumo {
	// atributo privado
	private ArrayList<DetalleConsumo> arDetalleConsumo;
	
	// constructor
	public ArregloDetalleConsumo() {
		arDetalleConsumo = new ArrayList<DetalleConsumo>();
		cargarDataDetalleConsumo();
	}
	
	// metodos publicos basicos
	public void adicionar(DetalleConsumo d) {
		arDetalleConsumo.add(d);
	}
	
	public int tamanio() {
		return arDetalleConsumo.size();
	}
	
	public DetalleConsumo obtener(int pos) {
		return arDetalleConsumo.get(pos);
	}
	
	public void eliminar(DetalleConsumo d) {
		arDetalleConsumo.remove(d);
	}
	
	// Guardar la data del DetalleConsumo
	public void guardarDataDetalleConsumo() {
		try {
			PrintWriter pw;
			DetalleConsumo dc;
			String linea;
			// PASO A: Obtener(abrir) el archivo de texto "consumos.txt" en modo de escritura
			pw = new PrintWriter(new File("detalles.txt"));
			// bucle para realizar el recorrido en el ArrayList
			for(int i = 0; i<tamanio(); i++) {
				// obtener el usuario
				dc = obtener(i);
				// obtener los datos del DetalleConsumo
				linea = dc.getCodigoConsumo()+";"+
						dc.getCodigoProducto()+";"+
						dc.getCantidad()+";"+
						dc.getSubtotal()+";";
				// PASO B: Adicionar la informacion al archivo de texto
				pw.println(linea);
			}
			// PASO C: Cerrar el archivo
			pw.close();
			
			
		} catch (Exception e) {
			System.out.println("Error al guardar la data de los detalles de consumo "+e.getMessage());
		}
	}
	
	// Cargar la data del Usuario
	private void cargarDataDetalleConsumo() {
		try {
			// Declarar variables
			BufferedReader br;
			String linea, codConsumo, codProd;
			int cant;
			double impTotal;
			String[] sep;
			// PASO 1: Abrir el archivo en modo lectura "consumos.txt"
			br = new BufferedReader(new FileReader("detalles.txt"));
			// bucle
			while((linea = br.readLine()) != null) {
				// separar en subcadenas lo obtenido en la variable linea
				sep = linea.split(";");
				codConsumo = sep[0];
				codProd = sep[1];
				cant = Integer.parseInt(sep[2]);
				impTotal = Double.parseDouble(sep[3]);
				// Adicionar al ArrayList en un nuevo objeto
				adicionar(new DetalleConsumo(codConsumo, codProd, cant, impTotal));
			}
			// cerrar el archivo
			br.close();
			
		} catch (Exception e) {
			System.out.println("Error al cargar la data de los detalles de consumo "+e.getMessage());
		}
	}
}
