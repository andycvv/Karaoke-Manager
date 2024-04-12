package vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import controlador.ArregloUsuario;
import entidad.Usuario;
import utils.Alertas;

import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import javax.swing.ButtonGroup;
import java.awt.event.ActionListener;
import java.io.Console;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;
import javax.swing.UIManager;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import javax.swing.ImageIcon;

public class FrmMantenimientoUsuario extends JFrame implements ActionListener, MouseListener, KeyListener {
	private JPanel contentPane;
	private JLabel lblIdUsuario;
	private JTextField txtIdUsuario;
	private JLabel lblApellidoPaterno;
	private JTextField txtApellidoPaterno;
	private JLabel lblNombres;
	private JTextField txtNombre;
	private JTextField txtApellidoMaterno;
	private JLabel lblApellidoMaterno;
	private JLabel lblLogin;
	private JTextField txtLogin;
	private JLabel lblPassword;
	private JLabel lblNewLabel;
	private JLabel lblTipo;
	private JLabel lblTurno;
	private JComboBox cboTipo;
	private JComboBox cboTurno;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JButton btnNuevo;
	private JButton btnRegistrar;
	private JButton btnModificar;
	private JButton btnEliminar;
	private JTable tblUsuarios;
	private JScrollPane scrollPane;
	private JPasswordField txtPassword;

	// instanciar un objeto para la estructura de la tabla ---> DefaultTableModel
	DefaultTableModel model = new DefaultTableModel();
	// instanciar objeto
	ArregloUsuario arUsuario = new ArregloUsuario();
	private JButton btnBuscar;
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
					FrmMantenimientoUsuario frame = new FrmMantenimientoUsuario();
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
	public FrmMantenimientoUsuario() {
		setTitle("Mantenimiento Usuario");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 959, 695);
		contentPane = new JPanel();
		contentPane.setOpaque(false);
		contentPane.setBackground(Color.PINK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		lblNewLabel = new JLabel("Mantenimiento Usuario");
		lblNewLabel.setBackground(Color.ORANGE);
		lblNewLabel.setBounds(0, 0, 943, 74);
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 32));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblNewLabel);

		lblIdUsuario = new JLabel("Id Usuario:");
		lblIdUsuario.setFont(new Font("Arial", Font.PLAIN, 16));
		lblIdUsuario.setBounds(28, 93, 78, 20);
		contentPane.add(lblIdUsuario);

		txtIdUsuario = new JTextField();
		txtIdUsuario.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txtIdUsuario.setEnabled(false);
		txtIdUsuario.setBounds(114, 85, 140, 37);
		contentPane.add(txtIdUsuario);
		txtIdUsuario.setColumns(10);

		lblApellidoPaterno = new JLabel("A. Paterno:");
		lblApellidoPaterno.setFont(new Font("Arial", Font.PLAIN, 16));
		lblApellidoPaterno.setBounds(28, 141, 78, 20);
		contentPane.add(lblApellidoPaterno);

		txtApellidoPaterno = new JTextField();
		txtApellidoPaterno.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txtApellidoPaterno.setColumns(10);
		txtApellidoPaterno.setBounds(114, 133, 140, 37);
		contentPane.add(txtApellidoPaterno);

		lblNombres = new JLabel("Nombres:");
		lblNombres.setFont(new Font("Arial", Font.PLAIN, 15));
		lblNombres.setBounds(296, 94, 78, 20);
		contentPane.add(lblNombres);

		txtNombre = new JTextField();
		txtNombre.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txtNombre.setColumns(10);
		txtNombre.setBounds(384, 85, 140, 37);
		contentPane.add(txtNombre);

		txtApellidoMaterno = new JTextField();
		txtApellidoMaterno.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txtApellidoMaterno.setColumns(10);
		txtApellidoMaterno.setBounds(384, 133, 140, 37);
		contentPane.add(txtApellidoMaterno);

		lblApellidoMaterno = new JLabel("A. Materno:");
		lblApellidoMaterno.setFont(new Font("Arial", Font.PLAIN, 15));
		lblApellidoMaterno.setBounds(296, 142, 78, 20);
		contentPane.add(lblApellidoMaterno);

		lblLogin = new JLabel("Login:");
		lblLogin.setFont(new Font("Arial", Font.PLAIN, 16));
		lblLogin.setBounds(28, 189, 78, 20);
		contentPane.add(lblLogin);

		txtLogin = new JTextField();
		txtLogin.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txtLogin.setColumns(10);
		txtLogin.setBounds(114, 181, 140, 37);
		contentPane.add(txtLogin);

		lblPassword = new JLabel("Password:");
		lblPassword.setFont(new Font("Arial", Font.PLAIN, 15));
		lblPassword.setBounds(296, 190, 78, 20);
		contentPane.add(lblPassword);

		lblTipo = new JLabel("Tipo:");
		lblTipo.setFont(new Font("Arial", Font.PLAIN, 16));
		lblTipo.setBounds(28, 237, 78, 20);
		contentPane.add(lblTipo);

		lblTurno = new JLabel("Turno:");
		lblTurno.setFont(new Font("Arial", Font.PLAIN, 15));
		lblTurno.setBounds(296, 238, 78, 20);
		contentPane.add(lblTurno);

		cboTipo = new JComboBox();
		cboTipo.setFont(new Font("Tahoma", Font.PLAIN, 13));
		cboTipo.setModel(
				new DefaultComboBoxModel(new String[] {"Seleccionar", "Administrador", "Supervisor", "Mozo"}));
		cboTipo.setBounds(114, 229, 140, 37);
		contentPane.add(cboTipo);

		cboTurno = new JComboBox();
		cboTurno.setFont(new Font("Tahoma", Font.PLAIN, 13));
		cboTurno.setModel(new DefaultComboBoxModel(new String[] {"Seleccionar", "Tarde", "Noche"}));
		cboTurno.setBounds(384, 229, 140, 37);
		contentPane.add(cboTurno);

		btnNuevo = new JButton("Nuevo");
		btnNuevo.setIcon(new ImageIcon(
				"img\\iconNew.png"));
		btnNuevo.addActionListener(this);
		btnNuevo.setFont(new Font("Arial", Font.BOLD, 16));
		btnNuevo.setBounds(575, 85, 162, 55);
		contentPane.add(btnNuevo);

		btnRegistrar = new JButton("Registrar");
		btnRegistrar.setIcon(new ImageIcon(
				"img\\iconRegister.png"));
		btnRegistrar.setFont(new Font("Arial", Font.BOLD, 16));
		btnRegistrar.addActionListener(this);
		btnRegistrar.setBounds(575, 151, 162, 55);
		contentPane.add(btnRegistrar);

		btnModificar = new JButton("Modificar");
		btnModificar.setIcon(new ImageIcon(
				"img\\iconModify.png"));
		btnModificar.addActionListener(this);
		btnModificar.setFont(new Font("Arial", Font.BOLD, 16));
		btnModificar.setBounds(747, 152, 162, 52);
		contentPane.add(btnModificar);

		btnEliminar = new JButton("Eliminar");
		btnEliminar.setIcon(new ImageIcon(
				"img\\iconRemove.png"));
		btnEliminar.addActionListener(this);
		btnEliminar.setFont(new Font("Arial", Font.BOLD, 16));
		btnEliminar.setBounds(747, 85, 162, 55);
		contentPane.add(btnEliminar);

		scrollPane = new JScrollPane();
		scrollPane.setBounds(28, 287, 881, 339);
		contentPane.add(scrollPane);

		tblUsuarios = new JTable();
		tblUsuarios.addKeyListener(this);
		tblUsuarios.addMouseListener(this);
		scrollPane.setViewportView(tblUsuarios);
		tblUsuarios.setFillsViewportHeight(true);

		// Definir columnas para la tabla
		model.addColumn("Id Usuario");
		model.addColumn("Apellido P.");
		model.addColumn("Apellido M.");
		model.addColumn("Nombres");
		model.addColumn("Login");
		model.addColumn("Clave");
		model.addColumn("Tipo");
		model.addColumn("Turno");
		tblUsuarios.setModel(model);

		txtPassword = new JPasswordField();
		txtPassword.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txtPassword.setBounds(384, 181, 140, 37);
		contentPane.add(txtPassword);

		btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(this);
		btnBuscar.setIcon(new ImageIcon(
				"img\\iconSearch.png"));
		btnBuscar.setFont(new Font("Arial", Font.BOLD, 16));
		btnBuscar.setBounds(746, 217, 162, 55);
		contentPane.add(btnBuscar);
		
		btnMostrarTodo = new JButton("Mostrar");
		btnMostrarTodo.addActionListener(this);
		btnMostrarTodo.setIcon(new ImageIcon("img\\iconoMostrarTodo.png"));
		btnMostrarTodo.setFont(new Font("Arial", Font.BOLD, 16));
		btnMostrarTodo.setBounds(575, 217, 162, 55);
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
		if (e.getSource() == btnNuevo) {
			actionPerformedBtnNuevo(e);
		}
		if (e.getSource() == btnEliminar) {
			actionPerformedBtnEliminar(e);
		}
		if (e.getSource() == btnModificar) {
			actionPerformedBtnModificar(e);
		}
		if (e.getSource() == btnRegistrar) {
			actionPerformedBtnRegistrar(e);
		}
	}

	protected void actionPerformedBtnRegistrar(ActionEvent e) {
		registrarUsuario();
	}

	private void registrarUsuario() {
		// Declaración de variables
		String idUser, aPaterno, aMaterno, nombre, login, password;
		int tipo, turno;

		// Entrada de datos
		idUser = getIdUsuario();
		aPaterno = getApellidoPaterno();
		aMaterno = getApellidoMaterno();
		nombre = getNombre();
		login = getLogin();
		password = getPassword();
		tipo = getTipoEmpleado();
		turno = getTurno();

		// Validación
		if (idUser == null || aPaterno == null || aMaterno == null || nombre == null || login == null
				|| password == null || tipo == 0 || turno == 0) {
			return;
		} else {
			// Validar si el usuario existe mediante el idUsuario
			Usuario bean = arUsuario.buscarUsuario(idUser);
			if (bean == null) {
				// Proceso de cálculo
				// Crear un Usuario y asignarles los datos obtenidos de la GUI
				Usuario u = new Usuario(idUser, aPaterno, aMaterno, nombre, tipo, login, password, turno);
				// Adicionar a la lista (ArrayList)
				arUsuario.adicionar(u);
				// Guardamos el usuario en el archivo de texto
				arUsuario.guardarDataUsuario();
				// Actualizar datos en la tabla
				listar();
			} else {
				Alertas.mensajeError("Error, usuario ya existe");
			}
		}

	}

	private String getIdUsuario() {
		String idUsuario = txtIdUsuario.getText().trim();

		if (idUsuario.length() == 0) {
			mensaje("Ingresar ID de Usuario");
			txtIdUsuario.setText("");
			txtIdUsuario.requestFocus();

		} else if (!idUsuario.matches("^USU\\d{3}$")) {
			mensaje("El ID de usuario no tiene el formato correcto (Ej. USU001)");
			txtIdUsuario.setText("");
			txtIdUsuario.requestFocus();
			idUsuario = null;
		}

		return idUsuario;
	}

	private String getApellidoPaterno() {
		String ap = txtApellidoPaterno.getText().trim();

		if (ap.length() == 0) {
			mensaje("Ingresar Apellido Paterno");
			txtApellidoPaterno.setText("");
			txtApellidoPaterno.requestFocus();
			ap = null;

		} else if (ap.split("\\s+").length > 1) {
			mensaje("El apellido paterno debe ser una sola palabra.");
			txtApellidoPaterno.setText("");
			txtApellidoPaterno.requestFocus();
			ap = null;

		} else if (!ap.matches("^[A-Za-zñÑáéíóúÁÉÍÓÚüÜ\\s]+$")) {
			mensaje("El apellido paterno no debe contener números ni caracteres especiales.");
			txtApellidoPaterno.setText("");
			txtApellidoPaterno.requestFocus();
			ap = null;
		}

		return ap;
	}

	private String getApellidoMaterno() {
		String am = txtApellidoMaterno.getText().trim();

		if (am.length() == 0) {
			mensaje("Ingresar Apellido Materno");
			txtApellidoMaterno.setText("");
			txtApellidoMaterno.requestFocus();
			am = null;

		} else if (am.split("\\s+").length > 1) {
			mensaje("El apellido materno debe ser una sola palabra.");
			txtApellidoMaterno.setText("");
			txtApellidoMaterno.requestFocus();
			am = null;

		} else if (!txtApellidoMaterno.getText().trim().matches("^[A-Za-zñÑáéíóúÁÉÍÓÚüÜ\\s]+$")) {
			mensaje("El apellido materno no debe contener números ni caracteres especiales.");
			txtApellidoMaterno.setText("");
			txtApellidoMaterno.requestFocus();
			am = null;
		}

		return am;
	}

	private String getNombre() {
		String nombre = txtNombre.getText().trim();

		if (nombre.length() == 0) {
			mensaje("Ingresar Nombres");
			txtNombre.setText("");
			txtNombre.requestFocus();

		} else if (!nombre.matches("^[A-Za-záéíóúÁÉÍÓÚñÑ ]+$")) {
			mensaje("Los nombres deben contener solo letras y espacios");
			txtNombre.setText("");
			txtNombre.requestFocus();
			nombre = null;
		} else {
			nombre = txtNombre.getText().trim();
		}

		return nombre;
	}

	private String getLogin() {
		String login = txtLogin.getText().trim();

		if (login.length() == 0) {
			mensaje("Ingresar Login");
			txtLogin.setText("");
			txtLogin.requestFocus();

		} else if (login.split("\\s+").length > 1) {
			mensaje("El Login debe ser una sola palabra.");
			txtLogin.setText("");
			txtLogin.requestFocus();
			login = null;

		} else if (!login.matches("^[A-Za-z0-9]+$")) {
			mensaje("El Login debe contener solo letras y números");
			txtLogin.setText("");
			txtLogin.requestFocus();
			login = null;
		} else {
			login = txtLogin.getText().trim();
		}

		return login;
	}

	private String getPassword() {
		String contrasena = String.valueOf(txtPassword.getPassword());

		if (contrasena.length() == 0) {
			mensaje("Ingresar una Contraseña");
			txtPassword.setText("");
			txtPassword.requestFocus();
			return null;
		}

		if (contrasena.contains(" ")) {
			mensaje("La contraseña no debe contener espacios en blanco");
			txtPassword.setText("");
			txtPassword.requestFocus();
			return null;
		}

		return contrasena;
	}

	private int getTipoEmpleado() {
		int tipo = 0;
		tipo = cboTipo.getSelectedIndex();
		if (tipo == 0) {
			mensaje("Seleccionar el tipo de empleado");
		}
		return tipo;
	}

	private int getTurno() {
		int turno = 0;
		turno = cboTurno.getSelectedIndex();
		if (turno == 0) {
			mensaje("Seleccionar el turno");
		}
		return turno;
	}

	private void mensaje(String str) {
		JOptionPane.showMessageDialog(this, str, "error", 0);
	}

	// Método listar que permite mostrar los datos del arreglo en la tabla
	private void listar() {
		// 1. limpiar la tabla
		model.setRowCount(0);
		// 2. bucle para acceder a la informacion
		for (int i = 0; i < arUsuario.tamanio(); i++) {
			// 3. Guardar los datos de la lista en un arreglo lineal (Object)
			Object fila[] = { arUsuario.obtener(i).getIdUsuario(),
					arUsuario.obtener(i).getApellidoPaterno(),
					arUsuario.obtener(i).getApellidoMaterno(),
					arUsuario.obtener(i).getNombre(),
					arUsuario.obtener(i).getLogin(),
					arUsuario.obtener(i).getPassword(),
					getTipoEmpleadoString(arUsuario.obtener(i).getTipoEmpleado()),
					getTurnoString(arUsuario.obtener(i).getTurno()) };
			// 4. Agregar datos a la fila de la tabla
			model.addRow(fila);
		}
	}

	private void mostrarData(int posFila) {
		try {
			// Declaracion de variables
			String user, aPat, aMat, nomb, login, clav, tipo, turn;
	
			// Paso 1: Obtener los datos de la tabla
			user = tblUsuarios.getValueAt(posFila, 0).toString();
			aPat = tblUsuarios.getValueAt(posFila, 1).toString();
			aMat = tblUsuarios.getValueAt(posFila, 2).toString();
			nomb = tblUsuarios.getValueAt(posFila, 3).toString();
			login = tblUsuarios.getValueAt(posFila, 4).toString();
			clav = tblUsuarios.getValueAt(posFila, 5).toString();
			tipo = tblUsuarios.getValueAt(posFila, 6).toString();
			turn = tblUsuarios.getValueAt(posFila, 7).toString();
	
			// Paso 2: Mostrar los datos obtenidos de la tabla
			txtIdUsuario.setText(user);
			txtApellidoPaterno.setText(aPat);
			txtApellidoMaterno.setText(aMat);
			txtNombre.setText(nomb);
			txtLogin.setText(login);
			txtPassword.setText(clav);
			cboTipo.setSelectedItem(tipo);
			cboTurno.setSelectedItem(turn);
		} catch (Exception e) {
			// TODO: handle exception
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
		if (e.getSource() == tblUsuarios) {
			mouseReleasedTblUsuarios(e);
		}
	}

	protected void mouseReleasedTblUsuarios(MouseEvent e) {
		// Obtener el valor de la fila seleccionada
		int posFila;
		posFila = tblUsuarios.getSelectedRow();

		// Mostrar datos
		try {
			mostrarData(posFila);
		} catch (Exception e2) {
			// TODO: handle exception
		}
	}

	public void keyPressed(KeyEvent e) {
	}

	public void keyReleased(KeyEvent e) {
		if (e.getSource() == tblUsuarios) {
			keyReleasedTblUsuarios(e);
		}
	}

	public void keyTyped(KeyEvent e) {
	}

	protected void keyReleasedTblUsuarios(KeyEvent e) {
		// Obtener el valor de la fila seleccionada
		int posFila;
		posFila = tblUsuarios.getSelectedRow();

		// Mostrar datos
		mostrarData(posFila);
	}

	protected void actionPerformedBtnModificar(ActionEvent e) {
		modificarUsuario();
	}

	private void modificarUsuario() {
		// Declaración de variables
		String idUser, aPaterno, aMaterno, nombre, login, password;
		int tipo, turno;

		// Entrada de datos
		idUser = getIdUsuario();
		aPaterno = getApellidoPaterno();
		aMaterno = getApellidoMaterno();
		nombre = getNombre();
		login = getLogin();
		password = getPassword();
		tipo = getTipoEmpleado();
		turno = getTurno();

		// Validación
		if (idUser == null || aPaterno == null || aMaterno == null || nombre == null || login == null
				|| password == null || tipo == 0 || turno == 0) {
			return;
		} else {
			// Validar si el usuario existe mediante el idUsuario
			Usuario bean = arUsuario.buscarUsuario(idUser);
			if (bean != null) {
				// Modificar los datos del Usuario
				bean.setApellidoPaterno(aPaterno);
				bean.setApellidoMaterno(aMaterno);
				bean.setNombres(nombre);
				bean.setLogin(login);
				bean.setPassword(password);
				bean.setTipoEmpleado(tipo);
				bean.setTurno(turno);
				// Guardar la modificacion en el archivo de texto
				arUsuario.guardarDataUsuario();
				// Mostrar la informacion en la tabla
				listar();
			} else {
				Alertas.mensajeError("Error, usuario no existe");
			}
		}
	}

	protected void actionPerformedBtnEliminar(ActionEvent e) {
		// Declaración de variables
		String idUser;

		// Entrada de datos
		idUser = getIdUsuario();

		// Validación
		if (idUser == null) {
			return;
		} else {
			// Validar si el usuario existe mediante el idUsuario
			Usuario bean = arUsuario.buscarUsuario(idUser);
			if (bean != null) {
				// Ventana de confirmacion
				int opcion = JOptionPane.showConfirmDialog(this, "Está seguro de eliminar este usuario?", "Sistema",
						JOptionPane.YES_NO_OPTION);
				if (opcion == 0) {
					// Eliminar usuario de la lista
					arUsuario.eliminar(bean);
					// Guardar eliminacion del usuario
					arUsuario.guardarDataUsuario();
					// Mostrar la informacion en la tabla
					listar();
				}

			} else {
				Alertas.mensajeError("Error, usuario no existe");
			}
		}
	}

	protected void actionPerformedBtnNuevo(ActionEvent e) {
		txtIdUsuario.setText(arUsuario.generarUsuario());
		txtApellidoPaterno.setText("");
		txtApellidoMaterno.setText("");
		txtLogin.setText("");
		txtNombre.setText("");
		txtPassword.setText("");
		cboTipo.setSelectedIndex(0);
		cboTurno.setSelectedIndex(0);
	}

	protected void actionPerformedBtnBuscar(ActionEvent e) {
		buscarUsuario();
	}

	private void buscarUsuario() {
		// Declaración de variables
		String idUserLogin;

		// Entrada de datos
		idUserLogin = JOptionPane.showInputDialog(this, "Ingrese el IdUsuario o Login");

		// Validación
		if (idUserLogin == null) {
			return;
		} else {
			// Validar si el usuario existe mediante el idUsuario
			Usuario bean = arUsuario.buscarUsuario(idUserLogin);
			if (bean != null) {
				// Proceso de cálculo
				// Establecer datos en los casilleros
				txtIdUsuario.setText(bean.getIdUsuario());
				txtApellidoPaterno.setText(bean.getApellidoPaterno());
				txtApellidoMaterno.setText(bean.getApellidoMaterno());
				txtLogin.setText(bean.getLogin());
				txtNombre.setText(bean.getNombre());
				txtPassword.setText(bean.getPassword());
				cboTipo.setSelectedIndex(bean.getTipoEmpleado());
				cboTurno.setSelectedIndex(bean.getTurno());
				listarEncontrar(idUserLogin);

			} else {
				// Validar si el usuario existe mediante el login
				Usuario beanLogin = arUsuario.buscarUsuarioLogin(idUserLogin);
				if(beanLogin != null) {
					// Establecer datos en los casilleros
					txtIdUsuario.setText(beanLogin.getIdUsuario());
					txtApellidoPaterno.setText(beanLogin.getApellidoPaterno());
					txtApellidoMaterno.setText(beanLogin.getApellidoMaterno());
					txtLogin.setText(beanLogin.getLogin());
					txtNombre.setText(beanLogin.getNombre());
					txtPassword.setText(beanLogin.getPassword());
					cboTipo.setSelectedIndex(beanLogin.getTipoEmpleado());
					cboTurno.setSelectedIndex(beanLogin.getTurno());
					listarEncontrar(idUserLogin);
				} else{
					Alertas.mensajeAlerta("Usuario no encontrado");
				}
			}
		}
	}
	
	// metodo listar para el boton buscar
	private void listarEncontrar(String filtro) {
		// 1. limpiar la tabla
		model.setRowCount(0);
		// 2. bucle para acceder a la informacion
		for (int i = 0; i < arUsuario.tamanio(); i++) {
			if(arUsuario.obtener(i).getIdUsuario().contains(filtro) || arUsuario.obtener(i).getLogin().contains(filtro)) {
				// 3. Guardar los datos de la lista en un arreglo lineal (Object)
				Object fila[] = { arUsuario.obtener(i).getIdUsuario(),
						arUsuario.obtener(i).getApellidoPaterno(),
						arUsuario.obtener(i).getApellidoMaterno(),
						arUsuario.obtener(i).getNombre(),
						arUsuario.obtener(i).getLogin(),
						arUsuario.obtener(i).getPassword(),
						getTipoEmpleadoString(arUsuario.obtener(i).getTipoEmpleado()),
						getTurnoString(arUsuario.obtener(i).getTurno()) };
				// 4. Agregar datos a la fila de la tabla
				model.addRow(fila);
			}
			
		}
	}
	
	// Método para obtener la representación de cadena del tipo de empleado
	private String getTipoEmpleadoString(int i) {
	    switch (i) {
	        case 1:
	            return "Administrador";
	        case 2:
	            return "Supervisor";
	        case 3:
	            return "Mozo";
	        default:
	            return "Seleccionar";
	    }
	}

	// Método para obtener la representación de cadena del turno
	private String getTurnoString(int turnoIndex) {
	    switch (turnoIndex) {
	        case 1:
	            return "Tarde";
	        case 2:
	            return "Noche";
	        default:
	            return "Seleccionar";
	    }
	}
	protected void actionPerformedBtnMostrarTodo(ActionEvent e) {
		listar();
	}
}
