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

import controlador.ArregloBebida;
import entidad.Bebida;
import entidad.Piqueo;
import utils.Alertas;

import javax.swing.JRadioButton;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ButtonGroup;
import javax.swing.UIManager;
import javax.swing.ImageIcon;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FrmMantenimientoBebida extends JFrame implements MouseListener, KeyListener, ActionListener {

	private JPanel contentPane;
	private JLabel lblClaseBebida;
	private JLabel lblIdBebida;
	private JLabel lblNombre;
	private JLabel lblTipo;
	private JTextField txtIdBebida;
	private JTextField txtNombre;
	private JComboBox cboTipo;
	private JLabel lblMarca;
	private JTextField txtMarca;
	private JLabel lblPecio;
	private JTextField txtPrecio;
	private JTable tblBebida;
	private JScrollPane scrollPane;
	private JLabel lblEstado;
	private JComboBox cboEstado;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JButton btnNuevo;
	private JButton btnRegistrar;
	private JButton btnBuscar;
	private JButton btnModificar;
	private JButton btnEliminar;
	// instanciar objeto para la tabla
	DefaultTableModel model = new DefaultTableModel();
	
	// instanciar objeto para el arreglo
	ArregloBebida arBebida = new ArregloBebida();
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
					FrmMantenimientoBebida frame = new FrmMantenimientoBebida();
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
	public FrmMantenimientoBebida() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 956, 702);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblClaseBebida = new JLabel("Mantenimiento Bebida");
		lblClaseBebida.setHorizontalAlignment(SwingConstants.CENTER);
		lblClaseBebida.setForeground(Color.BLACK);
		lblClaseBebida.setFont(new Font("Arial", Font.BOLD, 32));
		lblClaseBebida.setBackground(Color.DARK_GRAY);
		lblClaseBebida.setBounds(0, 0, 940, 74);
		contentPane.add(lblClaseBebida);
		
		lblIdBebida = new JLabel("Id Bebida:");
		lblIdBebida.setFont(new Font("Arial", Font.PLAIN, 16));
		lblIdBebida.setBounds(24, 111, 80, 20);
		contentPane.add(lblIdBebida);
		
		lblNombre = new JLabel("Nombre:");
		lblNombre.setFont(new Font("Arial", Font.PLAIN, 16));
		lblNombre.setBounds(289, 111, 80, 20);
		contentPane.add(lblNombre);
		
		lblTipo = new JLabel("Tipo:");
		lblTipo.setFont(new Font("Arial", Font.PLAIN, 16));
		lblTipo.setBounds(24, 161, 80, 20);
		contentPane.add(lblTipo);
		
		txtIdBebida = new JTextField();
		txtIdBebida.setEnabled(false);
		txtIdBebida.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txtIdBebida.setColumns(10);
		txtIdBebida.setBounds(113, 103, 140, 37);
		contentPane.add(txtIdBebida);
		
		txtNombre = new JTextField();
		txtNombre.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txtNombre.setColumns(10);
		txtNombre.setBounds(379, 103, 140, 37);
		contentPane.add(txtNombre);
		
		cboTipo = new JComboBox();
		cboTipo.setFont(new Font("Tahoma", Font.PLAIN, 13));
		cboTipo.setModel(new DefaultComboBoxModel(new String[] {"Seleccionar", "Cerveza", "Vino", "Whisky", "Ron", "Frutado", "Combinaci\u00F3n preparada", "Agua embotellada"}));
		cboTipo.setBounds(113, 153, 140, 37);
		contentPane.add(cboTipo);
		
		lblMarca = new JLabel("Marca:");
		lblMarca.setFont(new Font("Arial", Font.PLAIN, 16));
		lblMarca.setBounds(289, 161, 80, 20);
		contentPane.add(lblMarca);
		
		txtMarca = new JTextField();
		txtMarca.addKeyListener(this);
		txtMarca.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txtMarca.setColumns(10);
		txtMarca.setBounds(379, 153, 140, 37);
		contentPane.add(txtMarca);
		
		lblPecio = new JLabel("Precio(S/.)");
		lblPecio.setFont(new Font("Arial", Font.PLAIN, 16));
		lblPecio.setBounds(24, 212, 80, 20);
		contentPane.add(lblPecio);
		
		txtPrecio = new JTextField();
		txtPrecio.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txtPrecio.setColumns(10);
		txtPrecio.setBounds(113, 204, 140, 37);
		contentPane.add(txtPrecio);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(24, 284, 886, 351);
		contentPane.add(scrollPane);
		
		tblBebida = new JTable();
		tblBebida.addKeyListener(this);
		tblBebida.addMouseListener(this);
		scrollPane.setViewportView(tblBebida);
		tblBebida.setFillsViewportHeight(true);
		
		lblEstado = new JLabel("Estado:");
		lblEstado.setFont(new Font("Arial", Font.PLAIN, 16));
		lblEstado.setBounds(289, 212, 80, 20);
		contentPane.add(lblEstado);
		
		cboEstado = new JComboBox();
		cboEstado.setModel(new DefaultComboBoxModel(new String[] {"Habilitado", "Inhabilitado"}));
		cboEstado.setFont(new Font("Tahoma", Font.PLAIN, 13));
		cboEstado.setBounds(379, 204, 140, 37);
		contentPane.add(cboEstado);
		
		btnNuevo = new JButton("Nuevo");
		btnNuevo.addActionListener(this);
		btnNuevo.setIcon(new ImageIcon("img\\iconNew.png"));
		btnNuevo.setFont(new Font("Arial", Font.BOLD, 16));
		btnNuevo.setBounds(576, 80, 162, 55);
		contentPane.add(btnNuevo);
		
		btnRegistrar = new JButton("Registrar");
		btnRegistrar.addActionListener(this);
		btnRegistrar.setIcon(new ImageIcon("img\\iconRegister.png"));
		btnRegistrar.setFont(new Font("Arial", Font.BOLD, 16));
		btnRegistrar.setBounds(576, 146, 162, 55);
		contentPane.add(btnRegistrar);
		
		btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(this);
		btnBuscar.setIcon(new ImageIcon("img\\iconSearch.png"));
		btnBuscar.setFont(new Font("Arial", Font.BOLD, 16));
		btnBuscar.setBounds(748, 212, 162, 55);
		contentPane.add(btnBuscar);
		
		btnModificar = new JButton("Modificar");
		btnModificar.addActionListener(this);
		btnModificar.setIcon(new ImageIcon("img\\iconModify.png"));
		btnModificar.setFont(new Font("Arial", Font.BOLD, 16));
		btnModificar.setBounds(748, 147, 162, 52);
		contentPane.add(btnModificar);
		
		btnEliminar = new JButton("Eliminar");
		btnEliminar.addActionListener(this);
		btnEliminar.setIcon(new ImageIcon("img\\iconRemove.png"));
		btnEliminar.setFont(new Font("Arial", Font.BOLD, 16));
		btnEliminar.setBounds(748, 80, 162, 55);
		contentPane.add(btnEliminar);
		
		// crear tabla
		model.addColumn("Id Bebida");
		model.addColumn("Nombre");
		model.addColumn("Tipo");
		model.addColumn("Marca");
		model.addColumn("Precio");
		model.addColumn("Estado");
		tblBebida.setModel(model);
		
		btnMostrarTodo = new JButton("Mostrar");
		btnMostrarTodo.addActionListener(this);
		btnMostrarTodo.setIcon(new ImageIcon("img\\iconoMostrarTodo.png"));
		btnMostrarTodo.setFont(new Font("Arial", Font.BOLD, 16));
		btnMostrarTodo.setBounds(576, 212, 162, 55);
		contentPane.add(btnMostrarTodo);
		
		//
		listar();
		//
		mostrarData(0);
		
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
		if (e.getSource() == tblBebida) {
			mouseReleasedTblBebida(e);
		}
	}
	protected void mouseReleasedTblBebida(MouseEvent e) {
		// Obtener el valor de la fila seleccionada
		int posFila;
		posFila = tblBebida.getSelectedRow();

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
		if (e.getSource() == tblBebida) {
			keyReleasedTblBebida(e);
		}
	}
	public void keyTyped(KeyEvent e) {
		if (e.getSource() == txtMarca) {
			keyTypedTxtMarca(e);
		}
	}
	protected void keyReleasedTblBebida(KeyEvent e) {
		// Obtener el valor de la fila seleccionada
		int posFila;
		posFila = tblBebida.getSelectedRow();

		// Mostrar datos
		try {
			mostrarData(posFila);
		} catch (Exception e2) {
			// TODO: handle exception
		}
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
	protected void actionPerformedBtnRegistrar(ActionEvent e) {
		registrarBebida();
	}

	private void registrarBebida() {
		// Declaración de variables
		String idBebida, nombre, marca;	
		int tipo;
		double precio;
		boolean estado;
		
		// Entrada de datos
		idBebida = getIdBebida();
		nombre = getNombre();
		marca = getMarca();
		tipo = getTipo();
		precio = getPrecio();
		estado = getEstado();
		
		// Validación
		if(idBebida == null || nombre == null || marca == null || tipo == 0 || precio == 0.0) {
			return;
		} else {
			// Validar si la bebida existe mediante el idBebida
			Bebida bean = arBebida.buscarBebida(idBebida);
			if(bean == null) {
				// Proceso de calculo
				// Crear una bebida y asignarles los valores obtenidos
				Bebida b = new Bebida(idBebida, nombre, tipo, marca, precio, estado);
				// Agregar a la lista
				arBebida.adicionar(b);
				// Guardamos la data de Bebida
				arBebida.guardarDataBebida();
				// Actualizar la tabla
				listar();
			} else {
				Alertas.mensajeError("Esta bebida ya existe");
			}
		}
		
	}

	private void listar() {
		model.setRowCount(0);
		for(int i = 0; i<arBebida.tamanio(); i++) {
			Object[] fila = {
					arBebida.obtener(i).getIdBebida(),
					arBebida.obtener(i).getNombre(),
					getTipoString(arBebida.obtener(i).getTipoBebida()),
					arBebida.obtener(i).getMarca(),
					arBebida.obtener(i).getPrecio(),
					getEstadoString(arBebida.obtener(i).getEstado())
			};
			model.addRow(fila);
		}
	}
	
	private void mostrarData(int posFila) {
		try {
			// Declaración de variables
			String idBebida, nombre, tipo, marca, precio, estado;
			
			// Paso 1: Obtener los datos de la tabla
			idBebida = tblBebida.getValueAt(posFila, 0).toString();
			nombre = tblBebida.getValueAt(posFila, 1).toString();
			tipo = tblBebida.getValueAt(posFila, 2).toString();
			marca = tblBebida.getValueAt(posFila, 3).toString();
			precio = tblBebida.getValueAt(posFila, 4).toString();
			estado = tblBebida.getValueAt(posFila, 5).toString();
			
			// Paso 2: Mostrar los datos obtenidos de la tabla
			txtIdBebida.setText(idBebida);
			txtNombre.setText(nombre);
			cboTipo.setSelectedItem(tipo);
			txtMarca.setText(marca);
			txtPrecio.setText(precio);
			cboEstado.setSelectedItem(estado);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	private String getTipoString(int i) {
		switch(i) {
		case 1:
			return "Cerveza";
		case 2:
			return "Vino";
		case 3:
			return "Whisky";
		case 4:
			return "Ron";
		case 5:
			return "Frutado";
		case 6:
			return "Combinación preparada";
		case 7:
			return "Agua embotellada";
		default:
			return "Seleccionar";
		}
	}
	
	private String getEstadoString(boolean b) {
		if (b == true) {
			return "Habilitado";
		} else {
			return "Inhabilitado";
		}
	}

	private boolean getEstado() {
		int estado = cboEstado.getSelectedIndex();
		return getEstadoBoolean(estado);
	}

	private int getTipo() {
		int tipo = cboTipo.getSelectedIndex();
		if(tipo == 0) {
			Alertas.mensajeError("Elija el tipo");
			return 0;
		} else {
			return tipo;
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

	private String getMarca() {
		String marca = txtMarca.getText().trim();
		
		if (marca.matches(".{1,50}")) {
			if (marca.length() == 0) {
				Alertas.mensajeError("Ingresar Marca");
				txtMarca.setText("");
				txtMarca.requestFocus();
				return null;

			} else if (!marca.matches("^[A-Za-záéíóúÁÉÍÓÚñÑ ]+$")) {
				Alertas.mensajeError("El nombre debe contener solo letras y espacios");
				txtMarca.setText("");
				txtMarca.requestFocus();
				marca = null;
				return marca;
			} else {
				marca = txtMarca.getText().trim();
			}

			return marca;
			
		} else {
			Alertas.mensajeError("La marca debe tener entre 1 y 50 caracteres.");
			return null;
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

	private String getIdBebida() {
		String idBebida = txtIdBebida.getText().trim();
		if (!idBebida.matches("BEB\\d{3}")) {
			Alertas.mensajeError("El ID de Bebida debe tener el formato correcto (BEB001, BEB002, etc.).");
			return null;
		}
		return idBebida;
	}
	
	private boolean getEstadoBoolean(int i) {
		switch(i) {
		case 0:
			return true;
		default:
			return false;
		}
	}
	protected void keyTypedTxtMarca(KeyEvent e) {
		if (txtMarca.getText().length() == 50)
			e.consume();
	}
	protected void actionPerformedBtnNuevo(ActionEvent e) {
		nuevaBebida();
	}

	private void nuevaBebida() {
		txtIdBebida.setText(arBebida.generarBebida());
		txtMarca.setText("");
		txtNombre.setText("");
		txtPrecio.setText("");
		cboEstado.setSelectedIndex(0);
		cboTipo.setSelectedIndex(0);
	}
	protected void actionPerformedBtnEliminar(ActionEvent e) {
		eliminarBebida();
	}

	private void eliminarBebida() {
		// Declaracion de variables
		String idBebida;
				
		// Entrada de datos
		idBebida = txtIdBebida.getText();
				
		// Validacion
		if(idBebida == null) {
			return;
		} else {
			// Validar si la bebida existe mediante el idBebida
			Bebida bean = arBebida.buscarBebida(idBebida);
			if(bean!=null) {
				int opcion = JOptionPane.showConfirmDialog(this, "Está seguro de eliminar esta bebida?", "Sistema",JOptionPane.YES_NO_OPTION);
				if (opcion == 0) {
					// Eliminar género de la lista
					arBebida.eliminar(bean);
					// Guardamos la data de Bebida
					arBebida.guardarDataBebida();
					// Actualizar la lista
					listar();
				}
			}
		}
	}
	protected void actionPerformedBtnModificar(ActionEvent e) {
		modificarBebida();
	}

	private void modificarBebida() {
		// Declaración de variables
		String idBebida, nombre, marca;	
		int tipo;
		double precio;
		boolean estado;
		
		// Entrada de datos
		idBebida = getIdBebida();
		nombre = getNombre();
		marca = getMarca();
		tipo = getTipo();
		precio = getPrecio();
		estado = getEstado();
		
		// Validación
		if(idBebida == null || nombre == null || marca == null || tipo == 0 || precio == 0.0) {
			return;
		} else {
			// Validar si el usuario existe mediante el idUsuario
			Bebida bean = arBebida.buscarBebida(idBebida);
			if (bean != null) {
				// Proceso de cálculo
				// Modificar Piqueo
				bean.setNombre(nombre);
				bean.setMarca(marca);
				bean.setTipoBebida(tipo);
				bean.setPrecio(precio);
				bean.setEstado(estado);
				// Guardamos la data de Bebida
				arBebida.guardarDataBebida();
				// Actualizar datos en la tabla
				listar();
			} else {
				Alertas.mensajeError("Error, esta bebida no existe");
			}
		}
	}
	protected void actionPerformedBtnBuscar(ActionEvent e) {
		buscarBebida();
	}

	private void buscarBebida() {
		// Declaración de variables
		String idBebidaNombre;

		// Entrada de datos
		idBebidaNombre = JOptionPane.showInputDialog(this, "Ingrese el IdBebida o Nombre");

		// Validación
		if (idBebidaNombre == null) {
			return;
		} else {
			// Validar si el usuario existe mediante el idUsuario
			Bebida bean = arBebida.buscarBebida(idBebidaNombre);
			if (bean != null) {
				// Proceso de cálculo
				// Establecer datos en los casilleros
				txtIdBebida.setText(bean.getIdBebida());
				txtMarca.setText(bean.getMarca());
				txtNombre.setText(bean.getNombre());
				txtPrecio.setText(""+bean.getPrecio());
				cboEstado.setSelectedItem(""+bean.getEstado());
				cboTipo.setSelectedItem(getTipoString(bean.getTipoBebida()));
				listarEncontrar(idBebidaNombre);

			} else {
				// Validar si el usuario existe mediante el login
				Bebida beanNombre = arBebida.buscarBebidaNombre(idBebidaNombre);
				if (beanNombre != null) {
					// Establecer datos en los casilleros
					txtIdBebida.setText(beanNombre.getIdBebida());
					txtMarca.setText(beanNombre.getMarca());
					txtNombre.setText(beanNombre.getNombre());
					txtPrecio.setText(""+beanNombre.getPrecio());
					cboEstado.setSelectedItem(""+beanNombre.getEstado());
					cboTipo.setSelectedItem(getTipoString(beanNombre.getTipoBebida()));
					listarEncontrar(idBebidaNombre);
					
				} else {
					Alertas.mensajeAlerta("Bebida no encontrada");
				}
			}
		}
	}
	
	private void listarEncontrar(String filtro) {
		model.setRowCount(0);
		for(int i = 0; i<arBebida.tamanio(); i++) {
			if(arBebida.obtener(i).getIdBebida().equals(filtro) || arBebida.obtener(i).getNombre().equals(filtro)) {
				Object[] fila = {
						arBebida.obtener(i).getIdBebida(),
						arBebida.obtener(i).getNombre(),
						getTipoString(arBebida.obtener(i).getTipoBebida()),
						arBebida.obtener(i).getMarca(),
						arBebida.obtener(i).getPrecio(),
						getEstadoString(arBebida.obtener(i).getEstado())
				};
				model.addRow(fila);
			}
		}
	}
	protected void actionPerformedBtnMostrarTodo(ActionEvent e) {
		listar();
	}
}
