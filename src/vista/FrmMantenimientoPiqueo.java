package vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import controlador.ArregloPiqueo;
import entidad.Genero;
import entidad.Piqueo;
import entidad.Usuario;
import utils.Alertas;

import javax.swing.JRadioButton;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ButtonGroup;
import javax.swing.JScrollPane;
import javax.swing.UIManager;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;

public class FrmMantenimientoPiqueo extends JFrame implements ActionListener, MouseListener, KeyListener {

	private JPanel contentPane;
	private JLabel lblClasePiqueo;
	private JLabel lblIdPiqueo;
	private JLabel lblTipoPiqueo;
	private JLabel lblNombre;
	private JLabel lblPrecio;
	private JTextField txtidPiqueo;
	private JTextField txtNombre;
	private JComboBox cboTipoPiqueo;
	private JTextField txtPrecio;
	private JTable tblPiqueo;
	private JLabel lblNewLabel;
	private JComboBox cboEstado;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JScrollPane scrollPane;
	private JButton btnNuevo;
	private JButton btnRegistrar;
	private JButton btnEliminar;
	private JButton btnModificar;
	private JButton btnBuscar;
	// instanciar la tabla
	DefaultTableModel model = new DefaultTableModel();

	// instanciar el objeto
	ArregloPiqueo arPiqueo = new ArregloPiqueo();
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
					FrmMantenimientoPiqueo frame = new FrmMantenimientoPiqueo();
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
	public FrmMantenimientoPiqueo() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 1012, 692);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		lblClasePiqueo = new JLabel("Mantenimiento Piqueo");
		lblClasePiqueo.setHorizontalAlignment(SwingConstants.CENTER);
		lblClasePiqueo.setForeground(Color.BLACK);
		lblClasePiqueo.setFont(new Font("Arial", Font.BOLD, 32));
		lblClasePiqueo.setBackground(Color.DARK_GRAY);
		lblClasePiqueo.setBounds(0, 0, 996, 74);
		contentPane.add(lblClasePiqueo);

		lblIdPiqueo = new JLabel("Id Piqueo:");
		lblIdPiqueo.setFont(new Font("Arial", Font.PLAIN, 16));
		lblIdPiqueo.setBounds(23, 94, 80, 20);
		contentPane.add(lblIdPiqueo);

		lblTipoPiqueo = new JLabel("Tipo:");
		lblTipoPiqueo.setFont(new Font("Arial", Font.PLAIN, 16));
		lblTipoPiqueo.setBounds(23, 199, 80, 20);
		contentPane.add(lblTipoPiqueo);

		lblNombre = new JLabel("Nombre:");
		lblNombre.setFont(new Font("Arial", Font.PLAIN, 16));
		lblNombre.setBounds(333, 94, 80, 20);
		contentPane.add(lblNombre);

		lblPrecio = new JLabel("Precio(S/.):");
		lblPrecio.setFont(new Font("Arial", Font.PLAIN, 16));
		lblPrecio.setBounds(23, 147, 80, 20);
		contentPane.add(lblPrecio);

		txtidPiqueo = new JTextField();
		txtidPiqueo.setEnabled(false);
		txtidPiqueo.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txtidPiqueo.setBounds(124, 86, 140, 37);
		contentPane.add(txtidPiqueo);
		txtidPiqueo.setColumns(10);

		txtNombre = new JTextField();
		txtNombre.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txtNombre.setColumns(10);
		txtNombre.setBounds(437, 85, 140, 37);
		contentPane.add(txtNombre);

		cboTipoPiqueo = new JComboBox();
		cboTipoPiqueo.setFont(new Font("Tahoma", Font.PLAIN, 13));
		cboTipoPiqueo.setModel(
				new DefaultComboBoxModel(new String[] { "Seleccionar", "Fr\u00EDos", "Calientes", "Snacks" }));
		cboTipoPiqueo.setBounds(124, 190, 140, 37);
		contentPane.add(cboTipoPiqueo);

		txtPrecio = new JTextField();
		txtPrecio.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txtPrecio.setColumns(10);
		txtPrecio.setBounds(124, 138, 140, 37);
		contentPane.add(txtPrecio);

		scrollPane = new JScrollPane();
		scrollPane.setBounds(23, 283, 947, 341);
		contentPane.add(scrollPane);

		tblPiqueo = new JTable();
		tblPiqueo.addKeyListener(this);
		tblPiqueo.addMouseListener(this);
		scrollPane.setViewportView(tblPiqueo);
		tblPiqueo.setFillsViewportHeight(true);

		lblNewLabel = new JLabel("Estado:");
		lblNewLabel.setFont(new Font("Arial", Font.PLAIN, 16));
		lblNewLabel.setBounds(333, 147, 80, 20);
		contentPane.add(lblNewLabel);

		cboEstado = new JComboBox();
		cboEstado.setModel(new DefaultComboBoxModel(new String[] { "Habilitado", "Inhabilitado" }));
		cboEstado.setFont(new Font("Tahoma", Font.PLAIN, 13));
		cboEstado.setBounds(437, 138, 140, 37);
		contentPane.add(cboEstado);

		btnNuevo = new JButton("Nuevo");
		btnNuevo.addActionListener(this);
		btnNuevo.setIcon(new ImageIcon(
				"img\\iconNew.png"));
		btnNuevo.setFont(new Font("Arial", Font.BOLD, 16));
		btnNuevo.setBounds(636, 85, 162, 55);
		contentPane.add(btnNuevo);

		btnRegistrar = new JButton("Registrar");
		btnRegistrar.addActionListener(this);
		btnRegistrar.setIcon(new ImageIcon(
				"img\\iconRegister.png"));
		btnRegistrar.setFont(new Font("Arial", Font.BOLD, 16));
		btnRegistrar.setBounds(636, 151, 162, 55);
		contentPane.add(btnRegistrar);

		btnEliminar = new JButton("Eliminar");
		btnEliminar.addActionListener(this);
		btnEliminar.setIcon(new ImageIcon(
				"img\\iconRemove.png"));
		btnEliminar.setFont(new Font("Arial", Font.BOLD, 16));
		btnEliminar.setBounds(808, 85, 162, 55);
		contentPane.add(btnEliminar);

		btnModificar = new JButton("Modificar");
		btnModificar.addActionListener(this);
		btnModificar.setIcon(new ImageIcon(
				"img\\iconModify.png"));
		btnModificar.setFont(new Font("Arial", Font.BOLD, 16));
		btnModificar.setBounds(808, 152, 162, 52);
		contentPane.add(btnModificar);

		btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(this);
		btnBuscar.setIcon(new ImageIcon(
				"img\\iconSearch.png"));
		btnBuscar.setFont(new Font("Arial", Font.BOLD, 16));
		btnBuscar.setBounds(808, 217, 162, 55);
		contentPane.add(btnBuscar);

		// Crear tabla
		model.addColumn("Id Piqueo");
		model.addColumn("Nombre");
		model.addColumn("Tipo");
		model.addColumn("Precio");
		model.addColumn("Estado");
		tblPiqueo.setModel(model);
		
		btnMostrarTodo = new JButton("Mostrar");
		btnMostrarTodo.addActionListener(this);
		btnMostrarTodo.setIcon(new ImageIcon("img\\iconoMostrarTodo.png"));
		btnMostrarTodo.setFont(new Font("Arial", Font.BOLD, 16));
		btnMostrarTodo.setBounds(636, 217, 162, 55);
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
		if (e.getSource() == btnEliminar) {
			actionPerformedBtnEliminar(e);
		}
		if (e.getSource() == btnNuevo) {
			actionPerformedBtnNuevo(e);
		}
		if (e.getSource() == btnModificar) {
			actionPerformedBtnModificar(e);
		}
		if (e.getSource() == btnRegistrar) {
			actionPerformedBtnRegistrar(e);
		}
	}

	protected void actionPerformedBtnRegistrar(ActionEvent e) {
		registrarPiqueo();
	}

	private void registrarPiqueo() {
		// Declaración de variables
		String idPiqueo, nombre;
		int tipo;
		double precio;
		boolean estado;

		// Entrada de datos
		idPiqueo = getIdPiqueo();
		nombre = getNombre();
		tipo = getTipo();
		precio = getPrecio();
		estado = getEstado();

		// Validación
		if (idPiqueo == null || nombre == null || tipo == 0 || precio == 0.0) {
			return;
		} else {
			// Validar si el usuario existe mediante el idUsuario
			Piqueo bean = arPiqueo.buscarPiqueo(idPiqueo);
			if (bean == null) {
				// Proceso de cálculo
				// Crear un Usuario y asignarles los datos obtenidos de la GUI
				Piqueo p = new Piqueo(idPiqueo, nombre, tipo, precio, estado);
				// Adicionar a la lista (ArrayList)
				arPiqueo.adicionar(p);
				// Guardamos la data en Piqueo
				arPiqueo.guardarDataPiqueo();
				// Actualizar datos en la tabla
				listar();
			} else {
				Alertas.mensajeError("Error, usuario ya existe");
			}
		}
	}

	private void listar() {
		model.setRowCount(0);
		for (int i = 0; i < arPiqueo.tamanio(); i++) {
			Object[] fila = { arPiqueo.obtener(i).getIdPiqueo(), arPiqueo.obtener(i).getNombre(),
					getTipoString(arPiqueo.obtener(i).getTipoPiqueo()), arPiqueo.obtener(i).getPrecio(),
					getEstadoString(arPiqueo.obtener(i).getEstado()) };
			model.addRow(fila);
		}
	}

	private void mostrarData(int posFila) {
		try {
			// Declaracion de variables
			String idPiqueo, nombre, tipo, precio, estado;
	
			// Paso 1: Obtener los datos de la tabla
			idPiqueo = tblPiqueo.getValueAt(posFila, 0).toString();
			nombre = tblPiqueo.getValueAt(posFila, 1).toString();
			tipo = tblPiqueo.getValueAt(posFila, 2).toString();
			precio = tblPiqueo.getValueAt(posFila, 3).toString();
			estado = tblPiqueo.getValueAt(posFila, 4).toString();
	
			// Paso 2: Mostrar los datos obtenidos de la tabla
			txtidPiqueo.setText(idPiqueo);
			txtNombre.setText(nombre);
			cboTipoPiqueo.setSelectedItem(tipo);
			txtPrecio.setText(precio);
			cboEstado.setSelectedItem(estado);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	private double getPrecio() {
		String precioStr = txtPrecio.getText().trim();
		try {
			double precio = Double.parseDouble(precioStr);
			if (precio < 0) {
				Alertas.mensajeError("El precio debe ser mayor o igual a cero.");
				return 0.0;
			}
			return precio;
		} catch (NumberFormatException e) {
			Alertas.mensajeError("Ingrese un valor numérico válido para el precio.");
			return 0.0;
		}
	}

	private String getNombre() {
		String nombre = txtNombre.getText().trim();

		if (nombre.length() == 0) {
			Alertas.mensajeError("Ingresar Nombre");
			txtNombre.setText("");
			txtNombre.requestFocus();
			return null;

		} else if (!nombre.matches("^[A-Za-záéíóúÁÉÍÓÚñÑ ]+$")) {
			Alertas.mensajeError("El nombre debe contener solo letras y espacios");
			txtNombre.setText("");
			txtNombre.requestFocus();
			nombre = null;
		} else {
			nombre = txtNombre.getText().trim();
		}

		return nombre;
	}

	private String getIdPiqueo() {
		String idPiqueo = txtidPiqueo.getText().trim();
		if (!idPiqueo.matches("PIQ\\d{3}")) {
			Alertas.mensajeError("El ID de piqueo debe tener el formato correcto (PIQ001, PIQ002, etc.).");
			return null;
		}
		return idPiqueo;
	}

	private int getTipo() {
		int tipo = 0;
		tipo = cboTipoPiqueo.getSelectedIndex();
		if (tipo == 0) {
			Alertas.mensajeError("Seleccionar el tipo de empleado");
		}
		return tipo;
	}

	private boolean getEstado() {
		int estadoIndex = cboEstado.getSelectedIndex();
		return getEstadoBollean(estadoIndex);
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

	private String getTipoString(int s) {
		switch (s) {
		case 1:
			return "Fríos";
		case 2:
			return "Calientes";
		case 3:
			return "Snacks";
		default:
			return "Seleccionar";
		}
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
		if (e.getSource() == tblPiqueo) {
			mouseReleasedTblPiqueo(e);
		}
	}

	protected void mouseReleasedTblPiqueo(MouseEvent e) {
		// Obtener el valor de la fila seleccionada
		int posFila;
		posFila = tblPiqueo.getSelectedRow();

		// Mostrar datos
		try {
			mostrarData(posFila);
		} catch (Exception e2) {
			// TODO: handle exception
		}
	}

	protected void actionPerformedBtnModificar(ActionEvent e) {
		modificarPiqueo();
	}

	private void modificarPiqueo() {
		// Declaración de variables
		String idPiqueo, nombre;
		int tipo;
		double precio;
		boolean estado;

		// Entrada de datos
		idPiqueo = getIdPiqueo();
		nombre = getNombre();
		tipo = getTipo();
		precio = getPrecio();
		estado = getEstado();

		// Validación
		if (idPiqueo == null || nombre == null || tipo == 0 || precio == 0.0) {
			return;
		} else {
			// Validar si el usuario existe mediante el idUsuario
			Piqueo bean = arPiqueo.buscarPiqueo(idPiqueo);
			if (bean != null) {
				// Proceso de cálculo
				// Modificar Piqueo
				bean.setNombre(nombre);
				bean.setTipoPiqueo(tipo);
				bean.setPrecio(precio);
				bean.setEstado(estado);
				// Guardamos la data en Piqueo
				arPiqueo.guardarDataPiqueo();
				// Actualizar datos en la tabla
				listar();
			} else {
				Alertas.mensajeError("Error, este piqueo no existe");
			}
		}
	}

	protected void actionPerformedBtnNuevo(ActionEvent e) {
		txtidPiqueo.setText(arPiqueo.generarPiqueo());
		txtNombre.setText("");
		txtPrecio.setText("");
		cboEstado.setSelectedIndex(0);
		cboTipoPiqueo.setSelectedIndex(0);
	}

	protected void actionPerformedBtnEliminar(ActionEvent e) {
		eliminarPiqueo();
	}

	private void eliminarPiqueo() {
		// Declarar variables
		String idPiqueo;

		// Entrada de datos
		idPiqueo = txtidPiqueo.getText();

		// Validacion
		if (idPiqueo == null) {
			return;
		} else {
			// Validar si el genero existe mediante el idGenero
			Piqueo bean = arPiqueo.buscarPiqueo(idPiqueo);
			if (bean != null) {
				// Ventana de confirmación
				int opcion = JOptionPane.showConfirmDialog(this, "Está seguro de eliminar este piqueo?", "Sistema",
						JOptionPane.YES_NO_OPTION);
				if (opcion == 0) {
					// Eliminar género de la lista
					arPiqueo.eliminar(bean);
					// Guardamos la data de los Piqueos
					arPiqueo.guardarDataPiqueo();
					// Actualizar la lista
					listar();
				}
			}
		}
	}

	protected void actionPerformedBtnBuscar(ActionEvent e) {
		buscarPiqueo();
	}

	private void buscarPiqueo() {
		// Declaración de variables
		String idPiqueoNombre;

		// Entrada de datos
		idPiqueoNombre = JOptionPane.showInputDialog(this, "Ingrese el IdPiqueo o Nombre");

		// Validación
		if (idPiqueoNombre == null) {
			return;
		} else {
			// Validar si el usuario existe mediante el idUsuario
			Piqueo bean = arPiqueo.buscarPiqueo(idPiqueoNombre);
			if (bean != null) {
				// Proceso de cálculo
				// Establecer datos en los casilleros
				txtidPiqueo.setText(bean.getIdPiqueo());
				txtNombre.setText(bean.getNombre());
				txtPrecio.setText(""+bean.getPrecio());
				cboEstado.setSelectedItem(""+bean.getEstado());
				cboTipoPiqueo.setSelectedItem(getTipoString(bean.getTipoPiqueo()));
				listarEncontrar(idPiqueoNombre);
				
			} else {
				// Validar si el usuario existe mediante el login
				Piqueo beanNombre = arPiqueo.buscarPiqueoNombre(idPiqueoNombre);
				if (beanNombre != null) {
					// Establecer datos en los casilleros
					txtidPiqueo.setText(beanNombre.getIdPiqueo());
					txtNombre.setText(beanNombre.getNombre());
					txtPrecio.setText(""+beanNombre.getPrecio());
					cboEstado.setSelectedItem(getEstadoString(beanNombre.getEstado()));
					cboTipoPiqueo.setSelectedItem(getTipoString(beanNombre.getTipoPiqueo()));
					listarEncontrar(idPiqueoNombre);
				} else {
					Alertas.mensajeAlerta("Usuario no encontrado");
				}
			}
		}
	}
	
	private void listarEncontrar(String filtro) {
		model.setRowCount(0);
		for (int i = 0; i < arPiqueo.tamanio(); i++) {
			if(arPiqueo.obtener(i).getIdPiqueo().equals(filtro) || arPiqueo.obtener(i).getNombre().equals(filtro)) {
				Object[] fila = { arPiqueo.obtener(i).getIdPiqueo(), arPiqueo.obtener(i).getNombre(),
						getTipoString(arPiqueo.obtener(i).getTipoPiqueo()), arPiqueo.obtener(i).getPrecio(),
						getEstadoString(arPiqueo.obtener(i).getEstado()) };
				model.addRow(fila);
			}
		}
	}
	
	
	public void keyPressed(KeyEvent e) {
	}
	public void keyReleased(KeyEvent e) {
		if (e.getSource() == tblPiqueo) {
			keyReleasedTblPiqueo(e);
		}
	}
	public void keyTyped(KeyEvent e) {
	}
	protected void keyReleasedTblPiqueo(KeyEvent e) {
		// Obtener el valor de la fila seleccionada
		int posFila;
		posFila = tblPiqueo.getSelectedRow();

		// Mostrar datos
		try {
			mostrarData(posFila);
		} catch (Exception e2) {
			// TODO: handle exception
		}
	}
	protected void actionPerformedBtnMostrarTodo(ActionEvent e) {
		listar();
	}
}
