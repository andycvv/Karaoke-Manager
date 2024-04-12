package vista;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.SystemColor;
import java.awt.Color;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import controlador.ArregloGenero;
import entidad.Genero;
import entidad.Usuario;
import utils.Alertas;

import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;
import javax.swing.UIManager;
import javax.swing.ImageIcon;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;

public class FrmMantenimientoGenero extends JFrame implements ActionListener, KeyListener, MouseListener {

	private JPanel contentPane;
	private JLabel lblMantenimientoGenero;
	private JLabel lblIdGenero;
	private JTextField txtIdGenero;
	private JLabel lblDescripcion;
	private JLabel lblEpoca;
	private JLabel lblEstado;
	private JComboBox cboEstado;
	private JTextField txtEpoca;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JTable tblGenero;
	private JScrollPane scrollPane;
	private JButton btnNuevo;
	private JButton btnRegistrar;
	private JButton btnEliminar;
	private JButton btnModificar;
	private JButton btnBuscar;

	// instanciar la tabla
	DefaultTableModel model = new DefaultTableModel();

	// instanciar objeto
	ArregloGenero arGenero = new ArregloGenero();
	private JTextField txtDescription;
	private JButton btnMostrarTodo;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Throwable e) {
			e.printStackTrace();
		}
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmMantenimientoGenero frame = new FrmMantenimientoGenero();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public FrmMantenimientoGenero() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 1006, 680);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		lblMantenimientoGenero = new JLabel("Mantenimiento G\u00E9nero");
		lblMantenimientoGenero.setHorizontalAlignment(SwingConstants.CENTER);
		lblMantenimientoGenero.setBackground(Color.BLACK);
		lblMantenimientoGenero.setFont(new Font("Arial", Font.BOLD, 32));
		lblMantenimientoGenero.setForeground(Color.BLACK);
		lblMantenimientoGenero.setBounds(0, 0, 990, 74);
		contentPane.add(lblMantenimientoGenero);

		lblIdGenero = new JLabel("ID G\u00E9nero:");
		lblIdGenero.setFont(new Font("Arial", Font.PLAIN, 16));
		lblIdGenero.setBounds(25, 95, 78, 20);
		contentPane.add(lblIdGenero);

		txtIdGenero = new JTextField();
		txtIdGenero.setEnabled(false);
		txtIdGenero.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txtIdGenero.setBounds(126, 87, 140, 37);
		contentPane.add(txtIdGenero);
		txtIdGenero.setColumns(10);

		lblDescripcion = new JLabel("Descripci\u00F3n:");
		lblDescripcion.setFont(new Font("Arial", Font.PLAIN, 16));
		lblDescripcion.setBounds(312, 169, 90, 20);
		contentPane.add(lblDescripcion);

		lblEpoca = new JLabel("\u00C9poca:");
		lblEpoca.setFont(new Font("Arial", Font.PLAIN, 16));
		lblEpoca.setBounds(312, 92, 78, 20);
		contentPane.add(lblEpoca);

		lblEstado = new JLabel("Estado:");
		lblEstado.setFont(new Font("Arial", Font.PLAIN, 16));
		lblEstado.setBounds(25, 169, 78, 20);
		contentPane.add(lblEstado);

		cboEstado = new JComboBox();
		cboEstado.setFont(new Font("Tahoma", Font.PLAIN, 13));
		cboEstado.setModel(new DefaultComboBoxModel(new String[] { "Habilitado", "Inhabilitado" }));
		cboEstado.setBounds(126, 161, 140, 37);
		contentPane.add(cboEstado);

		txtEpoca = new JTextField();
		txtEpoca.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txtEpoca.setColumns(10);
		txtEpoca.setBounds(413, 85, 140, 37);
		contentPane.add(txtEpoca);

		scrollPane = new JScrollPane();
		scrollPane.setBounds(25, 291, 938, 328);
		contentPane.add(scrollPane);

		tblGenero = new JTable();
		tblGenero.addKeyListener(this);
		tblGenero.addMouseListener(this);
		tblGenero.setFont(new Font("Arial", Font.PLAIN, 11));
		scrollPane.setViewportView(tblGenero);
		tblGenero.setFillsViewportHeight(true);

		btnNuevo = new JButton("Nuevo");
		btnNuevo.addActionListener(this);
		btnNuevo.setIcon(new ImageIcon(
				"img\\iconNew.png"));
		btnNuevo.setFont(new Font("Arial", Font.BOLD, 16));
		btnNuevo.setBounds(629, 85, 162, 55);
		contentPane.add(btnNuevo);

		btnRegistrar = new JButton("Registrar");
		btnRegistrar.addActionListener(this);
		btnRegistrar.setIcon(new ImageIcon(
				"img\\iconRegister.png"));
		btnRegistrar.setFont(new Font("Arial", Font.BOLD, 16));
		btnRegistrar.setBounds(629, 151, 162, 55);
		contentPane.add(btnRegistrar);

		btnEliminar = new JButton("Eliminar");
		btnEliminar.addActionListener(this);
		btnEliminar.setIcon(new ImageIcon(
				"img\\iconRemove.png"));
		btnEliminar.setFont(new Font("Arial", Font.BOLD, 16));
		btnEliminar.setBounds(801, 85, 162, 55);
		contentPane.add(btnEliminar);

		btnModificar = new JButton("Modificar");
		btnModificar.addActionListener(this);
		btnModificar.setIcon(new ImageIcon(
				"img\\iconModify.png"));
		btnModificar.setFont(new Font("Arial", Font.BOLD, 16));
		btnModificar.setBounds(801, 152, 162, 52);
		contentPane.add(btnModificar);

		btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(this);
		btnBuscar.setIcon(new ImageIcon(
				"img\\iconSearch.png"));
		btnBuscar.setFont(new Font("Arial", Font.BOLD, 16));
		btnBuscar.setBounds(801, 217, 162, 55);
		contentPane.add(btnBuscar);

		txtDescription = new JTextField();
		txtDescription.addKeyListener(this);
		txtDescription.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txtDescription.setColumns(10);
		txtDescription.setBounds(413, 161, 140, 37);
		contentPane.add(txtDescription);

		// Constuir estructura de la tabla
		model.addColumn("Id Género");
		model.addColumn("Descripción");
		model.addColumn("Época");
		model.addColumn("Estado");
		tblGenero.setModel(model);
		
		btnMostrarTodo = new JButton("Mostrar");
		btnMostrarTodo.addActionListener(this);
		btnMostrarTodo.setIcon(new ImageIcon("img\\iconoMostrarTodo.png"));
		btnMostrarTodo.setFont(new Font("Arial", Font.BOLD, 16));
		btnMostrarTodo.setBounds(629, 217, 162, 55);
		contentPane.add(btnMostrarTodo);

		//
		listar();

		//
		mostrarData(0);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnMostrarTodo) {
			actionPerformedBtnMostrarTodo(e);
		}
		if (e.getSource() == btnBuscar) {
			actionPerformedBtnBuscar(e);
		}
		if (e.getSource() == btnModificar) {
			actionPerformedBtnModificar(e);
		}
		if (e.getSource() == btnEliminar) {
			actionPerformedBtnEliminar(e);
		}
		if (e.getSource() == btnNuevo) {
			actionPerformedBtnNuevo(e);
		}
		if (e.getSource() == btnRegistrar) {
			actionPerformedBtnRegistrar(e);
		}
	}

	private void mostrarData(int posFila) {
		try {
			// Declaracion de variables
			String idGenero, descripcion, epoca, estado;
	
			// Paso 1: Obtener los datos de la tabla
			idGenero = tblGenero.getValueAt(posFila, 0).toString();
			descripcion = tblGenero.getValueAt(posFila, 1).toString();
			epoca = tblGenero.getValueAt(posFila, 2).toString();
			estado = tblGenero.getValueAt(posFila, 3).toString();
	
			// Paso 2: Mostrar los datos obtenidos de la tabla
			txtIdGenero.setText(idGenero);
			txtDescription.setText(descripcion);
			txtEpoca.setText(epoca);
			cboEstado.setSelectedItem(estado);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	private void listar() {
		// 1. Limpiar la tabla
		model.setRowCount(0);

		// 2. bucle para acceder al arreglo
		for (int i = 0; i < arGenero.tamanio(); i++) {
			// 3. Guardar los datos en un arreglo lineal
			Object[] fila = { arGenero.obtener(i).getIdGenero(), arGenero.obtener(i).getDescripcion(),
					arGenero.obtener(i).getEpoca(), getEstadoString(arGenero.obtener(i).getEstado()) };
			// 4. Agregar filas a la tabla
			model.addRow(fila);
		}

	}

	public void keyPressed(KeyEvent e) {
	}

	public void keyReleased(KeyEvent e) {
		if (e.getSource() == tblGenero) {
			keyReleasedTblGenero(e);
		}
	}

	public void keyTyped(KeyEvent e) {
		if (e.getSource() == txtDescription) {
			keyTypedTxtDescription(e);
		}
	}

	protected void keyTypedTxtDescription(KeyEvent e) {
		if (txtDescription.getText().length() == 60)
			e.consume();
	}

	private String getEstadoString(boolean b) {
		if (b == true) {
			return "Habilitado";
		} else {
			return "Inhabilitado";
		}
	}

	private boolean getEstadoBollean(int b) {
		switch (b) {
		case 0:
			return true;
		default:
			return false;
		}
	}

	protected void actionPerformedBtnRegistrar(ActionEvent e) {
		registrarGenero();
	}

	private void registrarGenero() {
		// Declaración de variables
		String idGenero, descripcion;
		int epoca;
		boolean estado;

		// Entrada de datos
		idGenero = getIdGenero();
		descripcion = getDescripcion();
		epoca = getEpoca();
		estado = getEstado();

		// Validación
		if (idGenero == null || descripcion == null || epoca == 0) {
			return;
		} else {
			// Validar si el usuario existe mediante el idUsuario
			Genero bean = arGenero.buscarGenero(idGenero);
			if (bean == null) {
				// Proceso de cálculo
				// Crear un Genero y asignarles los datos obtenidos de la GUI
				Genero g = new Genero(idGenero, descripcion, epoca, estado);
				// Adicionar a la lista (ArrayList)
				arGenero.adicionar(g);
				// Guardamos la data en Piqueo
				arGenero.guardarDataGenero();
				// Actualizar datos en la tabla
				listar();
			} else {
				Alertas.mensajeError("Error, este género ya existe");
			}
		}

	}

	private boolean getEstado() {
		int estadoIndex = cboEstado.getSelectedIndex();
		return getEstadoBollean(estadoIndex);
	}

	private int getEpoca() {
		String epocaStr = txtEpoca.getText().trim();
		if (epocaStr.matches("\\d{4}")) {
			return Integer.parseInt(epocaStr);
		} else {
			Alertas.mensajeError("Ingrese un año válido.");
			return 0;
		}
	}

	private String getDescripcion() {
		String descrip = txtDescription.getText().trim();
		if (descrip.length() == 0) {
			Alertas.mensajeAlerta("Ingrese un género");
			txtDescription.setText("");
			txtDescription.requestFocus();
			return null;

		} else if (!descrip.matches("^[A-Za-záéíóúÁÉÍÓÚñÑ ]+$")) {
			Alertas.mensajeAlerta("Los géneros deben contener solo letras y espacios");
			txtDescription.setText("");
			txtDescription.requestFocus();
			return null;
			
		}

		return descrip;
	}

	private String getIdGenero() {
		String idGenero = txtIdGenero.getText().trim();
		if (idGenero.matches("GEN\\d{2}")) {
			return idGenero;
		} else {
			Alertas.mensajeError("El ID de género debe tener el formato correcto (GEN01, GEN02, etc.).");
			return null;
		}
	}

	protected void actionPerformedBtnNuevo(ActionEvent e) {
		txtIdGenero.setText(arGenero.generarGenero());
		txtEpoca.setText("");
		txtDescription.setText("");
		cboEstado.setSelectedIndex(0);
	}

	public void mouseClicked(MouseEvent e) {
	}

	public void mouseEntered(MouseEvent e) {
	}

	public void mouseExited(MouseEvent e) {
	}

	public void mousePressed(MouseEvent e) {
	}

	public void mouseReleased(MouseEvent e) {
		if (e.getSource() == tblGenero) {
			mouseReleasedTblGenero(e);
		}
	}

	protected void mouseReleasedTblGenero(MouseEvent e) {
		// Obtener el valor de la fila seleccionada
		int posFila;
		posFila = tblGenero.getSelectedRow();

		// Mostrar datos
		try {
			mostrarData(posFila);
		} catch (Exception e2) {
			// TODO: handle exception
		}
	}

	protected void keyReleasedTblGenero(KeyEvent e) {
		// Obtener el valor de la fila seleccionada
		int posFila;
		posFila = tblGenero.getSelectedRow();

		// Mostrar datos
		mostrarData(posFila);
	}

	protected void actionPerformedBtnEliminar(ActionEvent e) {
		// Declarar variables
		String idGenero;

		// Entrada de datos
		idGenero = txtIdGenero.getText();

		// Validacion
		if (idGenero == null) {
			return;
		} else {
			// Validar si el genero existe mediante el idGenero
			Genero bean = arGenero.buscarGenero(idGenero);
			if (bean != null) {
				// Ventana de confirmación
				int opcion = JOptionPane.showConfirmDialog(this, "Está seguro de eliminar este género?", "Sistema",
						JOptionPane.YES_NO_OPTION);
				if (opcion == 0) {
					// Eliminar género de la lista
					arGenero.eliminar(bean);
					// Guardamos la data en Piqueo
					arGenero.guardarDataGenero();
					// Actualizar la lista
					listar();
				}
			}
		}
	}

	protected void actionPerformedBtnModificar(ActionEvent e) {
		modificarGenero();
	}

	private void modificarGenero() {
		// Declaración de variables
		String idGenero, descripcion;
		int epoca;
		boolean estado;

		// Entrada de datos
		idGenero = getIdGenero();
		descripcion = getDescripcion();
		epoca = getEpoca();
		estado = getEstado();

		// Validación
		if (idGenero == null || descripcion == null || epoca == 0) {
			return;
		} else {
			// Validar si el usuario existe mediante el idUsuario
			Genero bean = arGenero.buscarGenero(idGenero);
			if (bean != null) {
				// Proceso de cálculo
				// Modificar valores
				bean.setDescripcion(descripcion);
				bean.setEpoca(epoca);
				bean.setEstado(estado);
				// Guardamos la data en Piqueo
				arGenero.guardarDataGenero();
				// Actualizar datos en la tabla
				listar();
			} else {
				Alertas.mensajeError("Error, este género no existe");
			}
		}
	}

	protected void actionPerformedBtnBuscar(ActionEvent e) {
		buscarGenero();
	}

	private void buscarGenero() {
		// Declaracion de variables
		String idGenero;

		// Entrada de datos
		idGenero = JOptionPane.showInputDialog(this, "Ingrese el IdGenero");

		// Validación
		if (idGenero == null) {
			return;
		} else {
			// Validar si el usuario existe
			Genero bean = arGenero.buscarGenero(idGenero);
			if (bean != null) {
				// Establecer valores en los casilleros
				txtIdGenero.setText(idGenero);
				txtDescription.setText(bean.getDescripcion());
				txtEpoca.setText("" + bean.getEpoca());
				cboEstado.setSelectedItem(getEstadoString(bean.getEstado()));
				listarEncontrar(idGenero);
			} else {
				Alertas.mensajeAlerta("Este género no existe");
			}

		}
	}
	
	private void listarEncontrar(String filtro) {
		// 1. Limpiar la tabla
		model.setRowCount(0);

		// 2. bucle para acceder al arreglo
		for (int i = 0; i < arGenero.tamanio(); i++) {
			if(arGenero.obtener(i).getIdGenero().equals(filtro)) {
				// 3. Guardar los datos en un arreglo lineal
				Object[] fila = { arGenero.obtener(i).getIdGenero(), arGenero.obtener(i).getDescripcion(),
						arGenero.obtener(i).getEpoca(), getEstadoString(arGenero.obtener(i).getEstado()) };
				// 4. Agregar filas a la tabla
				model.addRow(fila);
			}
		}
	}
	protected void actionPerformedBtnMostrarTodo(ActionEvent e) {
		listar();
	}
}
