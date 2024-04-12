package controlador;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;

import entidad.Cliente;
import utils.Formatear;

public class ArregloCliente {
	// atributo privado
	private ArrayList<Cliente> arCliente;

	// constructor
	public ArregloCliente() {
		arCliente = new ArrayList<Cliente>();
		cargarDataCliente();
//		adicionar(new Cliente("CLI0001", "Vargas", "Vargas", "Andy", "Perú, Lima", "26/10/2005", "30/11/2022","Soltero", "987789765", "74743111", 3));
//		adicionar(new Cliente("CLI0002", "Auccasi", "Loa", "Yadira", "Chile, Santiago de Chile", "28/10/2005", "04/07/2021","Soltero", "972834534", "09235412", 4));
//		adicionar(new Cliente("CLI0003", "Meza", "Chanco", "Brahayan", "Bolivia, La Paz", "15/05/2005", "13/12/2022","Casado", "952834586", "56039456", 1));
	}

	// métodos públicos básicos
	public void adicionar(Cliente c) {
		arCliente.add(c);
	}

	public int tamanio() {
		return arCliente.size();
	}

	public Cliente obtener(int pos) {
		return arCliente.get(pos);
	}

	public void eliminar(Cliente c) {
		arCliente.remove(c);
	}

	// métodos complementarios
	public Cliente buscarCliente(String idCliente) {
		for (int i = 0; i < tamanio(); i++) {
			if (obtener(i).getIdCliente().equals(idCliente))
				return obtener(i);
		}
		return null;
	}
	
	public Cliente buscarClienteDni(String dni) {
		for (int i = 0; i < tamanio(); i++) {
			if (obtener(i).getDni().equals(dni))
				return obtener(i);
		}
		return null;
	}
	
	public String generarCliente() {
		int num;
		if(tamanio()==0) {
			return "CLI0001";
		} else {
			num = Integer.parseInt(obtener(tamanio()-1).getIdCliente().substring(3, 7))+1;
			//Formatear
			return "CLI" + Formatear.DF4.format(num);
		}
	}
	
	// Guardar la data del Cliente
	public void guardarDataCliente() {
		try {
			PrintWriter pw;
			Cliente c;
			String linea;
			// PASO A: Obtener(abrir) el archivo de texto en modo de escritura
			pw = new PrintWriter(new File("clientes.txt"));
			// bucle para recorrer el ArrayList
			for(int i = 0; i<tamanio(); i++) {
				// Obtenemos el cliente
				c = obtener(i);
				// Obtenemos los datos
				linea = c.getIdCliente() +";"+
						c.getApellidoPaterno() +";"+
						c.getApellidoMaterno() +";"+
						c.getNombres() +";"+
						c.getDireccion() +";"+
						c.getFechaNacimiento() +";"+
						c.getFechaAfiliacion() +";"+
						c.getEstadoCivil() +";"+
						c.getTelefono() +";"+
						c.getDni() +";"+
						c.getTipoDeCliente();
				
				// PASO B: Almacenamos la info en el archivo de texto
				pw.println(linea);
			}
			pw.close();
			
		} catch (Exception e) {
			System.out.println("Error al guardar la data de los clientes "+e.getMessage());
		}
	}
	
	// Cargar la data del Cliente
	private void cargarDataCliente() {
		try {
			BufferedReader br;
			String linea, idCliente, aPat, apMat, nomb, direc, estado, telefono, dni;
			Date fecNac, fecAfi;
			int tipo;
			String[] sep;
			
			// PASO A: Obtener(abrir) el archivo de texto en modo lectura
			br = new BufferedReader(new FileReader("clientes.txt"));
			// bucle
			while((linea = br.readLine()) != null) {
				// separar en subcadenas la variable linea
				sep = linea.split(";");
				idCliente = sep[0];
				aPat = sep[1];
				apMat = sep[2];
				nomb = sep[3];
				direc = sep[4];
				fecNac = Formatear.STRINGTODATE.parse(sep[5]);
				fecAfi = Formatear.STRINGTODATE.parse(sep[6]);
				estado = sep[7];
				telefono = sep[8];
				dni = sep[9];
				tipo = Integer.parseInt(sep[10]);
				// Adicionar al ArrayList en un nuevo objeto
				adicionar(new Cliente(idCliente, aPat, apMat, nomb, direc, fecNac, fecAfi, estado, telefono, dni, tipo));
			}
			br.close();
			
		} catch (Exception e) {
			System.out.println("Error al cargar la data de los clientes "+e.getMessage());
		}
	}

}
