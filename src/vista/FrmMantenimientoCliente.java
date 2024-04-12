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
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import controlador.ArregloCliente;
import entidad.Cliente;
import entidad.Usuario;
import utils.Alertas;
import utils.Formatear;

import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.UIManager;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.util.Date;
import java.awt.event.ActionEvent;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;

public class FrmMantenimientoCliente extends JFrame implements ActionListener, MouseListener, KeyListener {

	private JPanel contentPane;
	private JLabel lblMantenimientoCliente;
	private JLabel lblIdCliente;
	private JTextField txtIdCliente;
	private JLabel lblApellidoPaterno;
	private JTextField txtApellidoPaterno;
	private JLabel lblApellidoMaterno;
	private JTextField txtApellidoMaterno;
	private JLabel lblNombres;
	private JTextField txtNombres;
	private JLabel lblDireccion;
	private JTextField txtDireccion;
	private JLabel lblFechaNacimiento;
	private JTextField txtFechaNacimiento;
	private JTextField txtAfiliacion;
	private JLabel lblFechaAfilicion;
	private JLabel lblEstadoCivil;
	private JLabel lblTelefono;
	private JTextField txtTelefono;
	private JLabel lblDni;
	private JTextField txtDni;
	private JLabel lblTipoDeCliente;
	private JComboBox cboTipoDeCliente;
	private JComboBox cboEstadoCivil;
	private JTable tblCliente;
	private JScrollPane scrollPane;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JButton btnNuevo;
	private JButton btnRegistrar;
	private JButton btnEliminar;
	private JButton btnModificar;
	private JButton btnBuscar;
	private JButton btnMostrarTodo;

	// instanciar un objeto para la tabla
	DefaultTableModel model = new DefaultTableModel();

	// instanciar el controlador
	ArregloCliente arCliente = new ArregloCliente();
	
	// crear usuario logeado
	private static Usuario usuarioLogeado;

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
					FrmMantenimientoCliente frame = new FrmMantenimientoCliente(usuarioLogeado);
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
	public FrmMantenimientoCliente(Usuario usuarioLogeado) {
		this.usuarioLogeado = usuarioLogeado;
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 1085, 786);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		lblMantenimientoCliente = new JLabel("Mantenimiento Cliente");
		lblMantenimientoCliente.setHorizontalAlignment(SwingConstants.CENTER);
		lblMantenimientoCliente.setFont(new Font("Arial", Font.BOLD, 32));
		lblMantenimientoCliente.setForeground(Color.BLACK);
		lblMantenimientoCliente.setBackground(Color.PINK);
		lblMantenimientoCliente.setBounds(0, 0, 1069, 74);
		contentPane.add(lblMantenimientoCliente);

		lblIdCliente = new JLabel("ID Cliente:");
		lblIdCliente.setFont(new Font("Arial", Font.PLAIN, 16));
		lblIdCliente.setBounds(24, 99, 105, 20);
		contentPane.add(lblIdCliente);

		txtIdCliente = new JTextField();
		txtIdCliente.setEnabled(false);
		txtIdCliente.setFont(new Font("Dialog", Font.PLAIN, 13));
		txtIdCliente.setBounds(143, 91, 140, 37);
		contentPane.add(txtIdCliente);
		txtIdCliente.setColumns(10);

		lblApellidoPaterno = new JLabel("A. Paterno:");
		lblApellidoPaterno.setFont(new Font("Arial", Font.PLAIN, 16));
		lblApellidoPaterno.setBounds(24, 149, 105, 20);
		contentPane.add(lblApellidoPaterno);

		txtApellidoPaterno = new JTextField();
		txtApellidoPaterno.setFont(new Font("Dialog", Font.PLAIN, 13));
		txtApellidoPaterno.setColumns(10);
		txtApellidoPaterno.setBounds(142, 141, 140, 37);
		contentPane.add(txtApellidoPaterno);

		lblApellidoMaterno = new JLabel("A. Materno:");
		lblApellidoMaterno.setFont(new Font("Arial", Font.PLAIN, 16));
		lblApellidoMaterno.setBounds(404, 149, 105, 20);
		contentPane.add(lblApellidoMaterno);

		txtApellidoMaterno = new JTextField();
		txtApellidoMaterno.setFont(new Font("Dialog", Font.PLAIN, 13));
		txtApellidoMaterno.setColumns(10);
		txtApellidoMaterno.setBounds(523, 141, 140, 37);
		contentPane.add(txtApellidoMaterno);

		lblNombres = new JLabel("Nombres:");
		lblNombres.setFont(new Font("Arial", Font.PLAIN, 16));
		lblNombres.setBounds(404, 99, 105, 20);
		contentPane.add(lblNombres);

		txtNombres = new JTextField();
		txtNombres.setFont(new Font("Dialog", Font.PLAIN, 13));
		txtNombres.setColumns(10);
		txtNombres.setBounds(523, 91, 140, 37);
		contentPane.add(txtNombres);

		lblDireccion = new JLabel("Direcci\u00F3n");
		lblDireccion.setFont(new Font("Arial", Font.PLAIN, 16));
		lblDireccion.setBounds(783, 199, 105, 20);
		contentPane.add(lblDireccion);

		txtDireccion = new JTextField();
		txtDireccion.setFont(new Font("Dialog", Font.PLAIN, 13));
		txtDireccion.setColumns(10);
		txtDireccion.setBounds(905, 189, 141, 37);
		contentPane.add(txtDireccion);

		lblFechaNacimiento = new JLabel("F. Nacimiento:");
		lblFechaNacimiento.setFont(new Font("Arial", Font.PLAIN, 16));
		lblFechaNacimiento.setBounds(404, 197, 105, 20);
		contentPane.add(lblFechaNacimiento);

		txtFechaNacimiento = new JTextField();
		txtFechaNacimiento.setFont(new Font("Dialog", Font.PLAIN, 13));
		txtFechaNacimiento.setColumns(10);
		txtFechaNacimiento.setBounds(523, 189, 140, 37);
		contentPane.add(txtFechaNacimiento);

		txtAfiliacion = new JTextField();
		txtAfiliacion.setEditable(false);
		txtAfiliacion.setFont(new Font("Dialog", Font.PLAIN, 13));
		txtAfiliacion.setColumns(10);
		txtAfiliacion.setBounds(143, 189, 140, 37);
		contentPane.add(txtAfiliacion);

		lblFechaAfilicion = new JLabel("F. Afiliaci\u00F3n:");
		lblFechaAfilicion.setFont(new Font("Arial", Font.PLAIN, 16));
		lblFechaAfilicion.setBounds(24, 197, 105, 20);
		contentPane.add(lblFechaAfilicion);

		lblEstadoCivil = new JLabel("Estado Civil:");
		lblEstadoCivil.setFont(new Font("Arial", Font.PLAIN, 16));
		lblEstadoCivil.setBounds(24, 247, 105, 20);
		contentPane.add(lblEstadoCivil);

		lblTelefono = new JLabel("Tel\u00E9fono:");
		lblTelefono.setFont(new Font("Arial", Font.PLAIN, 16));
		lblTelefono.setBounds(783, 99, 105, 20);
		contentPane.add(lblTelefono);

		txtTelefono = new JTextField();
		txtTelefono.setFont(new Font("Dialog", Font.PLAIN, 13));
		txtTelefono.setColumns(10);
		txtTelefono.setBounds(905, 91, 140, 37);
		contentPane.add(txtTelefono);

		lblDni = new JLabel("DNI:");
		lblDni.setFont(new Font("Arial", Font.PLAIN, 16));
		lblDni.setBounds(786, 148, 105, 20);
		contentPane.add(lblDni);

		txtDni = new JTextField();
		txtDni.setFont(new Font("Dialog", Font.PLAIN, 13));
		txtDni.setColumns(10);
		txtDni.setBounds(905, 141, 140, 37);
		contentPane.add(txtDni);

		lblTipoDeCliente = new JLabel("Tipo:");
		lblTipoDeCliente.setFont(new Font("Arial", Font.PLAIN, 16));
		lblTipoDeCliente.setBounds(404, 247, 105, 20);
		contentPane.add(lblTipoDeCliente);

		cboTipoDeCliente = new JComboBox();
		cboTipoDeCliente.setFont(new Font("Dialog", Font.PLAIN, 13));
		cboTipoDeCliente.setModel(new DefaultComboBoxModel(new String[] {"Seleccionar", "Est\u00E1ndar", "Bronce", "Plata", "Oro", "Diamante"}));
		cboTipoDeCliente.setBounds(522, 237, 142, 37);
		contentPane.add(cboTipoDeCliente);

		cboEstadoCivil = new JComboBox();
		cboEstadoCivil.setFont(new Font("Dialog", Font.PLAIN, 13));
		cboEstadoCivil.setModel(new DefaultComboBoxModel(
				new String[] { "Seleccionar", "Soltero", "Casado", "Viudo", "Divorciado", "No especifica" }));
		cboEstadoCivil.setBounds(143, 237, 140, 37);
		contentPane.add(cboEstadoCivil);

		scrollPane = new JScrollPane();
		scrollPane.setBounds(24, 377, 1022, 344);
		contentPane.add(scrollPane);

		btnNuevo = new JButton("Nuevo");
		btnNuevo.addActionListener(this);
		btnNuevo.setIcon(new ImageIcon(
				"img\\iconNew.png"));
		btnNuevo.setFont(new Font("Arial", Font.BOLD, 16));
		btnNuevo.setBounds(24, 296, 162, 55);
		contentPane.add(btnNuevo);

		btnRegistrar = new JButton("Registrar");
		btnRegistrar.addActionListener(this);
		btnRegistrar.setIcon(new ImageIcon(
				"img\\iconRegister.png"));
		btnRegistrar.setFont(new Font("Arial", Font.BOLD, 16));
		btnRegistrar.setBounds(368, 296, 162, 55);
		contentPane.add(btnRegistrar);

		btnEliminar = new JButton("Eliminar");
		btnEliminar.addActionListener(this);
		btnEliminar.setIcon(new ImageIcon(
				"img\\iconRemove.png"));
		btnEliminar.setFont(new Font("Arial", Font.BOLD, 16));
		btnEliminar.setBounds(196, 296, 162, 55);
		contentPane.add(btnEliminar);

		btnModificar = new JButton("Modificar");
		btnModificar.addActionListener(this);
		btnModificar.setIcon(new ImageIcon(
				"img\\iconModify.png"));
		btnModificar.setFont(new Font("Arial", Font.BOLD, 16));
		btnModificar.setBounds(540, 297, 162, 52);
		contentPane.add(btnModificar);

		btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(this);
		btnBuscar.setIcon(new ImageIcon(
				"img\\iconSearch.png"));
		btnBuscar.setFont(new Font("Arial", Font.BOLD, 16));
		btnBuscar.setBounds(712, 296, 162, 55);
		contentPane.add(btnBuscar);

		tblCliente = new JTable();
		tblCliente.addKeyListener(this);
		tblCliente.addMouseListener(this);
		scrollPane.setViewportView(tblCliente);
		tblCliente.setFont(new Font("Tahoma", Font.PLAIN, 11));
		tblCliente.setFillsViewportHeight(true);
		

		// Definir columas para la tabla
		model.addColumn("Id Cliente");
		model.addColumn("A. Paterno");
		model.addColumn("A. Materno");
		model.addColumn("Nombres");
		model.addColumn("Dirección");
		model.addColumn("F. Nacimiento");
		model.addColumn("F. Afiliación");
		model.addColumn("Estado Civil");
		model.addColumn("Teléfono");
		model.addColumn("DNI");
		model.addColumn("Tipo");
		tblCliente.setModel(model);
		
		btnMostrarTodo = new JButton("Mostrar");
		btnMostrarTodo.addActionListener(this);
		btnMostrarTodo.setIcon(new ImageIcon("img\\iconoMostrarTodo.png"));
		btnMostrarTodo.setFont(new Font("Arial", Font.BOLD, 16));
		btnMostrarTodo.setBounds(884, 296, 162, 55);
		contentPane.add(btnMostrarTodo);

		//
		listar();

		//
		mostrarData(0);
		
		//
		if(usuarioLogeado.getTipoEmpleado()!=1) {
			lblMantenimientoCliente.setText("Registrar nuevo cliente");
			nuevoCliente();
			btnModificar.setEnabled(false);
			btnEliminar.setEnabled(false);
		}
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
		if (e.getSource() == btnModificar) {
			actionPerformedBtnModificar(e);
		}
		if (e.getSource() == btnNuevo) {
			actionPerformedBtnNuevo(e);
		}
		if (e.getSource() == btnRegistrar) {
			actionPerformedBtnRegistrar(e);
		}
	}

	protected void actionPerformedBtnRegistrar(ActionEvent e) {
		registrarCliente();
	}

	private void registrarCliente() {
		// Declaración de variables
		String idCliente, apellidoPaterno, apellidoMaterno, nombres, direccion, estadoCivil, telefono, dni;
		Date fechaNacimiento, fechaAfiliacion;
		int tipoDeCliente;

		// Entrada de datos de la GUI
		idCliente = getIdCliente();
		apellidoPaterno = getApellidoPaterno();
		apellidoMaterno = getApellidoMaterno();
		nombres = getNombres();
		direccion = getDireccion();
		estadoCivil = getEstadoCivil();
		telefono = getTelefono();
		dni = getDni();
		tipoDeCliente = getTipoDeCliente();
		fechaNacimiento = getFechaNacimiento();
		fechaAfiliacion = getFechaAfiliacion();

		// Validacion
		if (idCliente == null || apellidoPaterno == null || apellidoMaterno == null || nombres == null
				|| direccion == null || estadoCivil == null || telefono == null || dni == null || tipoDeCliente == 0
				|| fechaNacimiento == null || fechaAfiliacion == null) {
			return;
		} else {
			// Validar si el cliente existe
			Cliente bean = arCliente.buscarCliente(idCliente);
			if (bean == null) {
				// Crear un cliente y asignarle los valores obtenidos
				Cliente c = new Cliente(idCliente, apellidoPaterno, apellidoMaterno, nombres, direccion,
						fechaNacimiento, fechaAfiliacion, estadoCivil, telefono, dni, tipoDeCliente);
				// Añadir al ArrayList
				arCliente.adicionar(c);
				// Guardar datos del cliente
				arCliente.guardarDataCliente();
				// Actualizar la tabla
				listar();
			} else {
				Alertas.mensajeError("Error, este cliente ya existe");
			}
		}
	}

	private void listar() {
		// 1. limpiar la tabla
		model.setRowCount(0);
		// 2. bucle para acceder a la informacion
		for (int i = 0; i < arCliente.tamanio(); i++) {
			// 3. Guardar los datos de la lista en un arreglo lineal (Object)
			Object fila[] = { arCliente.obtener(i).getIdCliente(), 
							  arCliente.obtener(i).getApellidoPaterno(),
							  arCliente.obtener(i).getApellidoMaterno(), 
							  arCliente.obtener(i).getNombres(),
							  arCliente.obtener(i).getDireccion(), 
							  Formatear.DATETOSTRING.format(arCliente.obtener(i).getFechaNacimiento()),
							  Formatear.DATETOSTRING.format(arCliente.obtener(i).getFechaAfiliacion()), 
							  arCliente.obtener(i).getEstadoCivil(),
							  arCliente.obtener(i).getTelefono(), 
							  arCliente.obtener(i).getDni(),
							  getTipodeClienteString(arCliente.obtener(i).getTipoDeCliente())};
			
			// 4. Agregar datos a la fila de la tabla
			model.addRow(fila);
		}
	}

	private void mostrarData(int posFila) {
		try {
			// Declaración de variables
			String idCliente, aPat, aMat, nomb, direc, estado, tel, dni, tipo, fecNac, fecAfi;
	
			// Paso 1: Obtener los datos de la tabla
			idCliente = tblCliente.getValueAt(posFila, 0).toString();
			aPat = tblCliente.getValueAt(posFila, 1).toString();
			aMat = tblCliente.getValueAt(posFila, 2).toString();
			nomb = tblCliente.getValueAt(posFila, 3).toString();
			direc = tblCliente.getValueAt(posFila, 4).toString();
			fecNac = tblCliente.getValueAt(posFila, 5).toString();
			fecAfi = tblCliente.getValueAt(posFila, 6).toString();
			estado = tblCliente.getValueAt(posFila, 7).toString();
			tel = tblCliente.getValueAt(posFila, 8).toString();
			dni = tblCliente.getValueAt(posFila, 9).toString();
			tipo = tblCliente.getValueAt(posFila, 10).toString();
	
			// Paso 2: Mostrar los datos obtenidos de la tabla
			txtIdCliente.setText(idCliente);
			txtApellidoPaterno.setText(aPat);
			txtApellidoMaterno.setText(aMat);
			txtNombres.setText(nomb);
			txtDireccion.setText(direc);
			txtFechaNacimiento.setText(fecNac);
			txtAfiliacion.setText(fecAfi);
			cboEstadoCivil.setSelectedItem(estado);
			txtTelefono.setText(tel);
			txtDni.setText(dni);
			cboTipoDeCliente.setSelectedItem(tipo);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	private Date getFechaAfiliacion() {
//		String fechaAfiliacion = txtAfiliacion.getText().trim();
//
//	    if (!fechaAfiliacion.matches("\\d{2}/\\d{2}/\\d{4}")) {
//	        Alertas.mensajeError("Ingrese una fecha de afiliación válida en el formato dd/mm/yyyy.");
//	        return null;
//	    }
//	    
//	    return fechaAfiliacion;
		try {
			return Formatear.DATETOSTRING.parse(txtAfiliacion.getText().trim());
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			return null;
		}
	}

	private Date getFechaNacimiento() {
		try {
			String fechaNacimiento = txtFechaNacimiento.getText().trim();
	
			if (!fechaNacimiento.matches("\\d{2}/\\d{2}/\\d{4}")) {
				Alertas.mensajeError("Ingrese una fecha de nacimiento válida en el formato dd/mm/yyyy.");
				return null;
			}
	
			return Formatear.DATETOSTRING.parse(fechaNacimiento);
		} catch (Exception e) {
			return null;
		}
	}

	private int getTipoDeCliente() {
		int tipo = 0;
		tipo = cboTipoDeCliente.getSelectedIndex();
		if (tipo == 0) {
			Alertas.mensajeError("Seleccione el tipo de cliente.");
		}
		return tipo;

	}
	
	// Obtener tipo como String
	private String getTipodeClienteString(int index) {
		switch(index) {
		case 1:
			return "Estándar";
		case 2:
			return "Bronce";
		case 3:
			return "Plata";
		case 4:
			return "Oro";
		case 5:
			return "Diamante";
		default:
			return "Seleccionar";
		}
	}

	private String getDni() {
		String dni = txtDni.getText().trim();
		if (!dni.matches("\\d{8}")) {
			Alertas.mensajeError("Ingrese un DNI válido de 8 dígitos.");
			return null;
		}
		return dni;
	}

	private String getTelefono() {
		String telefono = txtTelefono.getText().trim();
		if (!telefono.matches("\\d+")) {
			Alertas.mensajeError("Ingrese un número de teléfono válido.");
			return null;
		}
		
		if (!telefono.matches("\\d{9}")) {
	        Alertas.mensajeError("Ingrese un número de teléfono válido de 9 dígitos.");
	        return null;
	    }
		
		return telefono;
	}

	private String getEstadoCivil() {
		int index = cboEstadoCivil.getSelectedIndex();
		if (index == 0) {
			Alertas.mensajeError("Seleccione el estado civil.");
			return null;
		} else {
			return cboEstadoCivil.getSelectedItem().toString();
		}
	}

	private String getDireccion() {
		String direccion = null;
		direccion = txtDireccion.getText().trim();
		return direccion;
	}

	private String getNombres() {
		String nombres = txtNombres.getText().trim();
		if (nombres.isEmpty()) {
			Alertas.mensajeError("Ingrese los nombres.");
			return null;
		} else if (!nombres.matches("^[A-Za-záéíóúÁÉÍÓÚñÑ ]+$")) {
			Alertas.mensajeError("Los nombres deben contener solo letras y espacios");
			txtNombres.setText("");
			txtNombres.requestFocus();
			nombres = null;
		} else {
			nombres = txtNombres.getText().trim();
		}
		return nombres;
	}

	private String getApellidoMaterno() {
		String apellidoMaterno = txtApellidoMaterno.getText().trim();
		if (apellidoMaterno.isEmpty()) {
			Alertas.mensajeError("Ingrese el apellido materno.");
			return null;
		} else if (!apellidoMaterno.matches("^[A-Za-záéíóúÁÉÍÓÚñÑ ]+$")) {
			Alertas.mensajeError("El apellido debe contener solo letras y espacios");
			txtApellidoMaterno.setText("");
			txtApellidoMaterno.requestFocus();
			apellidoMaterno = null;
		} else {
			apellidoMaterno = txtApellidoPaterno.getText().trim();
		}
		return apellidoMaterno;
	}

	private String getApellidoPaterno() {
		String apellidoPaterno = txtApellidoPaterno.getText().trim();
		if (apellidoPaterno.isEmpty()) {
			Alertas.mensajeError("Ingrese el apellido paterno.");
			return null;
		} else if (!apellidoPaterno.matches("^[A-Za-záéíóúÁÉÍÓÚñÑ ]+$")) {
			Alertas.mensajeError("El apellido debe contener solo letras y espacios");
			txtApellidoPaterno.setText("");
			txtApellidoPaterno.requestFocus();
			apellidoPaterno = null;
		} else {
			apellidoPaterno = txtApellidoPaterno.getText().trim();
		}

		return apellidoPaterno;
	}

	private String getIdCliente() {
		String idCliente = txtIdCliente.getText().trim();

		if (idCliente.length() == 0) {
			Alertas.mensajeAlerta("Ingresar ID de Usuario");
			txtIdCliente.setText("");
			txtIdCliente.requestFocus();

		} else if (!idCliente.matches("^CLI\\d{4}$")) {
			Alertas.mensajeAlerta("El ID de cliente no tiene el formato correcto (Ej. CLI0001)");
			txtIdCliente.setText("");
			txtIdCliente.requestFocus();
			idCliente = null;
		}

		return idCliente;
	}
	protected void actionPerformedBtnNuevo(ActionEvent e) {
		nuevoCliente();
	}

	private void nuevoCliente() {
		txtIdCliente.setText(arCliente.generarCliente());
		txtApellidoPaterno.setText("");
		txtApellidoMaterno.setText("");
		txtNombres.setText("");
		txtDireccion.setText("");
		txtAfiliacion.setText(Formatear.DATETOSTRING.format(new Date()));
		txtFechaNacimiento.setText("");
		cboEstadoCivil.setSelectedItem("Seleccionar");
		txtTelefono.setText("");
		txtDni.setText("");
		cboTipoDeCliente.setSelectedItem("Seleccionar");
	}
	protected void actionPerformedBtnModificar(ActionEvent e) {
		modificarCliente();
	}

	private void modificarCliente() {
		// Declaración de variables
		String idCliente, apellidoPaterno, apellidoMaterno, nombres, direccion, estadoCivil, telefono, dni;
		Date fechaNacimiento, fechaAfiliacion;
		int tipoDeCliente;

		// Entrada de datos de la GUI
		idCliente = getIdCliente();
		apellidoPaterno = getApellidoPaterno();
		apellidoMaterno = getApellidoMaterno();
		nombres = getNombres();
		direccion = getDireccion();
		estadoCivil = getEstadoCivil();
		telefono = getTelefono();
		dni = getDni();
		tipoDeCliente = getTipoDeCliente();
		fechaNacimiento = getFechaNacimiento();
		fechaAfiliacion = getFechaAfiliacion();

		// Validacion
		if (idCliente == null || apellidoPaterno == null || apellidoMaterno == null || nombres == null
				|| direccion == null || estadoCivil == null || telefono == null || dni == null || tipoDeCliente == 0
				|| fechaNacimiento == null || fechaAfiliacion == null) {
			return;
		} else {
			// Validar si el usuario existe mediante el idUsuario
			Cliente bean = arCliente.buscarCliente(idCliente);
			if (bean != null) {
				// Modificar los datos del Usuario
				bean.setApellidoPaterno(apellidoPaterno);
				bean.setApellidoMaterno(apellidoMaterno);
				bean.setNombres(nombres);
				bean.setDireccion(direccion);
				bean.setEstadoCivil(estadoCivil);
				bean.setTelefono(telefono);
				bean.setTipoDeCliente(tipoDeCliente);
				bean.setFechaNacimiento(fechaNacimiento);;
				bean.setFechaAfiliacion(fechaAfiliacion);
				// Guardar datos del cliente
				arCliente.guardarDataCliente();
				// Mostrar la informacion en la tabla
				listar();
			} else {
				Alertas.mensajeError("Error, este cliente no existe");
			}
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
		if (e.getSource() == tblCliente) {
			mouseReleasedTblCliente(e);
		}
	}
	protected void mouseReleasedTblCliente(MouseEvent e) {
		try {
			int posFila = tblCliente.getSelectedRow();
			mostrarData(posFila);
		} catch (Exception e2) {
		}
	}
	public void keyPressed(KeyEvent e) {
	}
	public void keyReleased(KeyEvent e) {
		if (e.getSource() == tblCliente) {
			keyReleasedTblCliente(e);
		}
	}
	public void keyTyped(KeyEvent e) {
	}
	protected void keyReleasedTblCliente(KeyEvent e) {
		int posFila = tblCliente.getSelectedRow();
		mostrarData(posFila);
	}
	protected void actionPerformedBtnEliminar(ActionEvent e) {
		eliminarCliente();
	}

	private void eliminarCliente() {
		// Declaración de variables
		String idCliente;

		// Entrada de datos
		idCliente = getIdCliente();

		// Validación
		if (idCliente == null) {
			return;
		} else {
			// Validar si el usuario existe mediante el idUsuario
			Cliente bean = arCliente.buscarCliente(idCliente);
			if (bean != null) {
				// Ventana de confirmacion
				int opcion = JOptionPane.showConfirmDialog(this, "Está seguro de eliminar este usuario?", "Sistema",
						JOptionPane.YES_NO_OPTION);
				if (opcion == 0) {
					// Eliminar usuario de la lista
					arCliente.eliminar(bean);
					// Guardar datos del cliente
					arCliente.guardarDataCliente();
					// Mostrar la informacion en la tabla
					listar();
				}

			} else {
				Alertas.mensajeError("Error, usuario no existe");
			}
		}
	}
	protected void actionPerformedBtnBuscar(ActionEvent e) {
		buscarCliente();
	}

	private void buscarCliente() {
		// Declaración de variables
		String idClienteDni;

		// Entrada de datos
		idClienteDni = JOptionPane.showInputDialog(this, "Ingrese el IdCliente o DNI");

		// Validación
		if (idClienteDni == null) {
			return;
		} else {
			// Validar si el usuario existe mediante el idUsuario
			Cliente bean = arCliente.buscarCliente(idClienteDni);
			if (bean != null) {
				// Proceso de cálculo
				// Establecer datos en los casilleros
				txtIdCliente.setText(bean.getIdCliente());
				txtApellidoPaterno.setText(bean.getApellidoPaterno());
				txtApellidoMaterno.setText(bean.getApellidoMaterno());
				txtNombres.setText(bean.getNombres());
				txtDireccion.setText(bean.getDireccion());
				txtFechaNacimiento.setText(Formatear.DATETOSTRING.format(bean.getFechaNacimiento()));
				txtAfiliacion.setText(Formatear.DATETOSTRING.format(bean.getFechaAfiliacion()));
				cboEstadoCivil.setSelectedItem(bean.getEstadoCivil());
				txtTelefono.setText(bean.getTelefono());
				txtDni.setText(bean.getDni());
				cboTipoDeCliente.setSelectedItem(getTipodeClienteString(bean.getTipoDeCliente()));
				listarEncontrar(idClienteDni);

			} else {
				// Validar si el usuario existe mediante el login
				Cliente beanDni = arCliente.buscarClienteDni(idClienteDni);
				if(beanDni != null) {
					// Establecer datos en los casilleros
					txtIdCliente.setText(beanDni.getIdCliente());
					txtApellidoPaterno.setText(beanDni.getApellidoPaterno());
					txtApellidoMaterno.setText(beanDni.getApellidoMaterno());
					txtNombres.setText(beanDni.getNombres());
					txtDireccion.setText(beanDni.getDireccion());
					txtFechaNacimiento.setText(Formatear.DATETOSTRING.format(beanDni.getFechaNacimiento()));
					txtAfiliacion.setText(Formatear.DATETOSTRING.format(beanDni.getFechaAfiliacion()));
					cboEstadoCivil.setSelectedItem(beanDni.getEstadoCivil());
					txtTelefono.setText(beanDni.getTelefono());
					txtDni.setText(beanDni.getDni());
					cboTipoDeCliente.setSelectedItem(getTipodeClienteString(beanDni.getTipoDeCliente()));
					listarEncontrar(idClienteDni);
					
				} else{
					Alertas.mensajeAlerta("Cliente no encontrado");
				}
			}
		}
	}
	
	private void listarEncontrar(String filtro) {
		// 1. limpiar la tabla
		model.setRowCount(0);
		// 2. bucle para acceder a la informacion
		for (int i = 0; i < arCliente.tamanio(); i++) {
			if(arCliente.obtener(i).getIdCliente().contains(filtro) || arCliente.obtener(i).getDni().contains(filtro)) {
				// 3. Guardar los datos de la lista en un arreglo lineal (Object)
				Object fila[] = { arCliente.obtener(i).getIdCliente(), 
						  arCliente.obtener(i).getApellidoPaterno(),
						  arCliente.obtener(i).getApellidoMaterno(), 
						  arCliente.obtener(i).getNombres(),
						  arCliente.obtener(i).getDireccion(), 
						  Formatear.DATETOSTRING.format(arCliente.obtener(i).getFechaNacimiento()),
						  Formatear.DATETOSTRING.format(arCliente.obtener(i).getFechaAfiliacion()), 
						  arCliente.obtener(i).getEstadoCivil(),
						  arCliente.obtener(i).getTelefono(), 
						  arCliente.obtener(i).getDni(),
						  getTipodeClienteString(arCliente.obtener(i).getTipoDeCliente())};
				// 4. Agregar datos a la fila de la tabla
				model.addRow(fila);
			}
			
		}
	}
	protected void actionPerformedBtnMostrarTodo(ActionEvent e) {
		listar();
	}
}
