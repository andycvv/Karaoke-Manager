package utils;

import javax.swing.JOptionPane;

public class Alertas {
	//mensaje error
	public static void mensajeError(String msj) {
		JOptionPane.showMessageDialog(null, msj, "Error!!!", 0);
	}
	
	//mensaje de alerta
	public static void mensajeAlerta(String msj) {
		JOptionPane.showMessageDialog(null, msj, "Sistema", 0);
	}
}
