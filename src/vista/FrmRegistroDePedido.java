package vista;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import controlador.ArregloBebida;
import controlador.ArregloCancion;
import controlador.ArregloCliente;
import controlador.ArregloPedido;
import controlador.ArregloPiqueo;
import controlador.ArregloUsuario;
import entidad.Bebida;
import entidad.Cancion;
import entidad.Cliente;
import entidad.Pedido;
import entidad.Piqueo;
import entidad.Usuario;
import utils.Alertas;

import javax.swing.UIManager;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.awt.event.ActionEvent;

public class FrmRegistroDePedido extends JFrame implements ActionListener {
	private JPanel contentPane;
	private JLabel lblNewLabel;
	private JTextField txtIdPedido;
	private JTable tblPedidos;
	private JScrollPane scrollPane;
	private JLabel lblIdPedido;
	private JButton btnRegistrar;
	private JTextField txtCliente;
	private JTextField txtUsuario;
	private JComboBox cboCliente;
	private JButton btnCliente;
	private JComboBox cboCancionesElegidas;
	private JComboBox cboBebidasElegidas;
	private JComboBox cboPiqueosElegidos;
	private JButton btnXCanciones;
	private JButton btnXBebidas;
	private JButton btnXPiqueos;
	private JComboBox cboCancionesDisponibles;
	private JComboBox cboBebidasDisponibles;
	private JComboBox cboPiqueosDisponibles;
	private JButton btnCheckCanciones;
	private JButton btnCheckBebidas;
	private JButton btnCheckPiqueos;
	// Crear usuario
	private static Usuario usuario;
	
	// instanciar la tabla
	DefaultTableModel model = new DefaultTableModel();
	
	// instanciar ArrayList
	ArregloPedido arPedido = new ArregloPedido();
	ArregloCliente arCliente = new ArregloCliente();
	ArregloUsuario arUsuario = new ArregloUsuario();
	ArregloPiqueo arPiqueo = new ArregloPiqueo();
	ArregloBebida arBebida = new ArregloBebida();
	ArregloCancion arCancion = new ArregloCancion();
	private JLabel lblCanciones;
	private JLabel lblBebidas;
	private JLabel lblPiqueos;
	private JLabel lblUsuario;
	private JButton btnNuevo;

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
					FrmRegistroDePedido frame = new FrmRegistroDePedido(usuario);
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
	public FrmRegistroDePedido(Usuario usuario) {
		this.usuario = usuario;
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 1122, 787);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblNewLabel = new JLabel("Registro de pedido");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 32));
		lblNewLabel.setBackground(Color.DARK_GRAY);
		lblNewLabel.setForeground(Color.BLACK);
		lblNewLabel.setBounds(0, 0, 1106, 74);
		contentPane.add(lblNewLabel);
		
		txtIdPedido = new JTextField();
		txtIdPedido.setEditable(false);
		txtIdPedido.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txtIdPedido.setBounds(135, 93, 140, 37);
		contentPane.add(txtIdPedido);
		txtIdPedido.setColumns(10);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(24, 353, 1050, 368);
		contentPane.add(scrollPane);
		
		tblPedidos = new JTable();
		scrollPane.setViewportView(tblPedidos);
		tblPedidos.setFillsViewportHeight(true);
		
		lblIdPedido = new JLabel("Id Pedido:");
		lblIdPedido.setHorizontalAlignment(SwingConstants.CENTER);
		lblIdPedido.setFont(new Font("Arial", Font.PLAIN, 16));
		lblIdPedido.setBounds(24, 102, 101, 20);
		contentPane.add(lblIdPedido);
		
		btnRegistrar = new JButton("Registrar");
		btnRegistrar.addActionListener(this);
		btnRegistrar.setIcon(new ImageIcon("img\\iconRegister.png"));
		btnRegistrar.setFont(new Font("Arial", Font.BOLD, 16));
		btnRegistrar.setBounds(285, 85, 162, 55);
		contentPane.add(btnRegistrar);
		
		txtCliente = new JTextField();
		txtCliente.setEditable(false);
		txtCliente.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txtCliente.setColumns(10);
		txtCliente.setBounds(135, 234, 140, 37);
		contentPane.add(txtCliente);
		
		txtUsuario = new JTextField();
		txtUsuario.setEditable(false);
		txtUsuario.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txtUsuario.setColumns(10);
		txtUsuario.setBounds(135, 283, 140, 37);
		contentPane.add(txtUsuario);
		
		cboCliente = new JComboBox();
		cboCliente.addActionListener(this);
		cboCliente.setBounds(285, 234, 162, 37);
		contentPane.add(cboCliente);
		
		btnCliente = new JButton("Cliente");
		btnCliente.addActionListener(this);
		btnCliente.setFont(new Font("Arial", Font.PLAIN, 16));
		btnCliente.setBounds(24, 235, 101, 37);
		contentPane.add(btnCliente);
		
		cboCancionesElegidas = new JComboBox();
		cboCancionesElegidas.setFont(new Font("Tahoma", Font.PLAIN, 13));
		cboCancionesElegidas.setBounds(698, 85, 123, 37);
		contentPane.add(cboCancionesElegidas);
		
		cboBebidasElegidas = new JComboBox();
		cboBebidasElegidas.setFont(new Font("Tahoma", Font.PLAIN, 13));
		cboBebidasElegidas.setBounds(698, 187, 123, 37);
		contentPane.add(cboBebidasElegidas);
		
		cboPiqueosElegidos = new JComboBox();
		cboPiqueosElegidos.setFont(new Font("Tahoma", Font.PLAIN, 13));
		cboPiqueosElegidos.setBounds(698, 283, 123, 37);
		contentPane.add(cboPiqueosElegidos);
		
		btnXCanciones = new JButton("");
		btnXCanciones.addActionListener(this);
		btnXCanciones.setIcon(new ImageIcon("img\\iconX.png"));
		btnXCanciones.setFont(new Font("Arial", Font.PLAIN, 16));
		btnXCanciones.setBounds(831, 85, 50, 37);
		contentPane.add(btnXCanciones);
		
		btnXBebidas = new JButton("");
		btnXBebidas.addActionListener(this);
		btnXBebidas.setIcon(new ImageIcon("img\\iconX.png"));
		btnXBebidas.setFont(new Font("Arial", Font.PLAIN, 16));
		btnXBebidas.setBounds(831, 187, 50, 37);
		contentPane.add(btnXBebidas);
		
		btnXPiqueos = new JButton("");
		btnXPiqueos.addActionListener(this);
		btnXPiqueos.setIcon(new ImageIcon("img\\iconX.png"));
		btnXPiqueos.setFont(new Font("Arial", Font.PLAIN, 16));
		btnXPiqueos.setBounds(831, 283, 50, 37);
		contentPane.add(btnXPiqueos);
		
		cboCancionesDisponibles = new JComboBox();
		cboCancionesDisponibles.setFont(new Font("Tahoma", Font.PLAIN, 13));
		cboCancionesDisponibles.setBounds(891, 85, 123, 37);
		contentPane.add(cboCancionesDisponibles);
		
		cboBebidasDisponibles = new JComboBox();
		cboBebidasDisponibles.setFont(new Font("Tahoma", Font.PLAIN, 13));
		cboBebidasDisponibles.setBounds(891, 187, 123, 37);
		contentPane.add(cboBebidasDisponibles);
		
		cboPiqueosDisponibles = new JComboBox();
		cboPiqueosDisponibles.setFont(new Font("Tahoma", Font.PLAIN, 13));
		cboPiqueosDisponibles.setBounds(891, 283, 123, 37);
		contentPane.add(cboPiqueosDisponibles);
		
		btnCheckCanciones = new JButton("");
		btnCheckCanciones.addActionListener(this);
		btnCheckCanciones.setIcon(new ImageIcon("img\\iconCheck.png"));
		btnCheckCanciones.setFont(new Font("Arial", Font.PLAIN, 16));
		btnCheckCanciones.setBounds(1024, 85, 50, 37);
		contentPane.add(btnCheckCanciones);
		
		btnCheckBebidas = new JButton("");
		btnCheckBebidas.addActionListener(this);
		btnCheckBebidas.setIcon(new ImageIcon("img\\iconCheck.png"));
		btnCheckBebidas.setFont(new Font("Arial", Font.PLAIN, 16));
		btnCheckBebidas.setBounds(1024, 187, 50, 37);
		contentPane.add(btnCheckBebidas);
		
		btnCheckPiqueos = new JButton("");
		btnCheckPiqueos.addActionListener(this);
		btnCheckPiqueos.setIcon(new ImageIcon("img\\iconCheck.png"));
		btnCheckPiqueos.setFont(new Font("Arial", Font.PLAIN, 16));
		btnCheckPiqueos.setBounds(1024, 283, 50, 37);
		contentPane.add(btnCheckPiqueos);
		
		lblCanciones = new JLabel("Canciones:");
		lblCanciones.setHorizontalAlignment(SwingConstants.LEFT);
		lblCanciones.setFont(new Font("Arial", Font.PLAIN, 16));
		lblCanciones.setBounds(587, 93, 101, 20);
		contentPane.add(lblCanciones);
		
		lblBebidas = new JLabel("Bebidas:");
		lblBebidas.setHorizontalAlignment(SwingConstants.LEFT);
		lblBebidas.setFont(new Font("Arial", Font.PLAIN, 16));
		lblBebidas.setBounds(587, 195, 101, 20);
		contentPane.add(lblBebidas);
		
		lblPiqueos = new JLabel("Piqueos:");
		lblPiqueos.setHorizontalAlignment(SwingConstants.LEFT);
		lblPiqueos.setFont(new Font("Arial", Font.PLAIN, 16));
		lblPiqueos.setBounds(587, 295, 101, 20);
		contentPane.add(lblPiqueos);
		
		lblUsuario = new JLabel("Usuario:");
		lblUsuario.setHorizontalAlignment(SwingConstants.CENTER);
		lblUsuario.setFont(new Font("Arial", Font.PLAIN, 16));
		lblUsuario.setBounds(24, 291, 101, 20);
		contentPane.add(lblUsuario);
		
		btnNuevo = new JButton("Nuevo");
		btnNuevo.addActionListener(this);
		btnNuevo.setIcon(new ImageIcon("img\\iconNew.png"));
		btnNuevo.setFont(new Font("Arial", Font.BOLD, 16));
		btnNuevo.setBounds(285, 151, 162, 55);
		contentPane.add(btnNuevo);
		
		// Crear la tabla principal
		model.addColumn("Id Pedido");
		model.addColumn("Fecha de pedido");
		model.addColumn("Id Usuario");
		model.addColumn("Id Cliente");
		model.addColumn("Canciones");
		model.addColumn("Bebidas");
		model.addColumn("Piqueos");
		model.addColumn("Estado");
		tblPedidos.setModel(model);
		
		//
		txtIdPedido.setText(arPedido.generarPedido());
		
        // Llamar a los métodos para cargar las opciones en los JComboBox
        cargarClientes();
        cargarUsuarios();
        cargarCancionesDisponibles();
        cargarBebidasDisponibles();
        cargarPiqueosDisponibles();
        
        //
        listar();
	}
	
    private void cargarClientes() {
        // Crear una lista que va contener los clientes
        ArrayList<Cliente> clientes = new ArrayList<Cliente>();

        // Limpiar el JComboBox
           cboCliente.removeAllItems();
           
        // Agregar la opcion Seleccionar al combobox
           cboCliente.addItem("Seleccionar");
           
        // bucle para recorrer el ArregloCliente
        for (int i = 0; i<arCliente.tamanio(); i++) {
        	// Agregamos cada cliente a la lista
            clientes.add(arCliente.obtener(i));
            
            // Agregamos los ids de los clientes al combobox
            cboCliente.addItem(arCliente.obtener(i).getIdCliente());
        }
    }
	
    private void cargarUsuarios() {
        // establecer el usuario
    	txtUsuario.setText(usuario.getIdUsuario().toString());
    }
    
    private void cargarCancionesDisponibles() {
        // Crear una lista que va contener las canciones disponibles
        ArrayList<Cancion> canciones = new ArrayList<Cancion>();

        // Limpiar el JComboBox
           cboCancionesDisponibles.removeAllItems();
           
        // Agregar la opcion Seleccionar al combobox
           cboCancionesDisponibles.addItem("Seleccionar");
           
        // bucle para recorrer el ArregloCancion
        for (int i = 0; i<arCancion.tamanio(); i++) {
        	// Agregamos cada cancion a la lista
            canciones.add(arCancion.obtener(i));
            
            // Agregamos los ids de las canciones al combobox
            cboCancionesDisponibles.addItem(arCancion.obtener(i).getIdCancion());
        }
    }
    
    private void cargarBebidasDisponibles() {
        // Crear una lista que va contener las bebidas disponibles
        ArrayList<Bebida> bebidas = new ArrayList<Bebida>();

        // Limpiar el JComboBox
           cboBebidasDisponibles.removeAllItems();
           
        // Agregar la opcion Seleccionar al combobox
           cboBebidasDisponibles.addItem("Seleccionar");
           
        // bucle para recorrer el ArregloBebida
        for (int i = 0; i<arBebida.tamanio(); i++) {
        	// Agregamos cada bebida a la lista
            bebidas.add(arBebida.obtener(i));
            
            // Agregamos los ids de las bebidas al combobox
            cboBebidasDisponibles.addItem(arBebida.obtener(i).getIdBebida());
        }
    }
    
    private void cargarPiqueosDisponibles() {
        // Crear una lista que va contener los piqueos disponibles
        ArrayList<Piqueo> piqueos = new ArrayList<Piqueo>();

        // Limpiar el JComboBox
           cboPiqueosDisponibles.removeAllItems();
           
        // Agregar la opcion Seleccionar al combobox
           cboPiqueosDisponibles.addItem("Seleccionar");
           
        // bucle para recorrer el ArregloPiqueo
        for (int i = 0; i<arPiqueo.tamanio(); i++) {
        	// Agregamos cada piqueo a la lista
            piqueos.add(arPiqueo.obtener(i));
            
            // Agregamos los ids de los piqueos al combobox
            cboPiqueosDisponibles.addItem(arPiqueo.obtener(i).getIdPiqueo());
        }
    }
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnNuevo) {
			actionPerformedBtnNuevo(e);
		}
		if (e.getSource() == btnRegistrar) {
			actionPerformedBtnRegistrar(e);
		}
		if (e.getSource() == btnCliente) {
			actionPerformedBtnCliente(e);
		}
		if (e.getSource() == cboCliente) {
			actionPerformedCboCliente(e);
		}
		if (e.getSource() == btnCheckPiqueos) {
			actionPerformedBtnCheckPiqueos(e);
		}
		if (e.getSource() == btnCheckBebidas) {
			actionPerformedBtnCheckBebidas(e);
		}
		if (e.getSource() == btnCheckCanciones) {
			actionPerformedBtnCheckCanciones(e);
		}
		if (e.getSource() == btnXPiqueos) {
			actionPerformedBtnXPiqueos(e);
		}
		if (e.getSource() == btnXBebidas) {
			actionPerformedBtnXBebidas(e);
		}
		if (e.getSource() == btnXCanciones) {
			actionPerformedBtnXCanciones(e);
		}
	}
	protected void actionPerformedBtnCheckCanciones(ActionEvent e) {
		agregarElementoSeleccionado(cboCancionesDisponibles, cboCancionesElegidas);
	}
	protected void actionPerformedBtnCheckBebidas(ActionEvent e) {
		agregarElementoSeleccionado(cboBebidasDisponibles, cboBebidasElegidas);
	}
	protected void actionPerformedBtnCheckPiqueos(ActionEvent e) {
		agregarElementoSeleccionado(cboPiqueosDisponibles, cboPiqueosElegidos);
	}
	
	private void agregarElementoSeleccionado(JComboBox<String> cboOrigen, JComboBox<String> cboDestino) {
		try {
			// Obtener el elemento seleccionado
	        String elementoSeleccionado = cboOrigen.getSelectedItem().toString();
	
	        // Verificar que el elemento seleccionado no sea la opción "Seleccionar"
	        if (!elementoSeleccionado.equals("Seleccionar")) {
	        	
	            // Agregar el elemento seleccionado al JComboBox de destino
	            cboDestino.addItem(elementoSeleccionado);
	            
	         // Eliminar el elemento seleccionado del JComboBox de origen
	            eliminarElementoSeleccionado(cboOrigen, elementoSeleccionado);
	            cboOrigen.setSelectedIndex(0);
	        }
		} catch (Exception e) {
			// TODO: handle exception
		}
    }
	
	private void eliminarElementoSeleccionado(JComboBox<String> cboOrigen, String elementoSeleccionado) {
		cboOrigen.removeItem(elementoSeleccionado);
	}

	protected void actionPerformedBtnXCanciones(ActionEvent e) {
		eliminarElementoAgregado(cboCancionesElegidas, cboCancionesDisponibles);
	}
	protected void actionPerformedBtnXBebidas(ActionEvent e) {
		eliminarElementoAgregado(cboBebidasElegidas, cboBebidasDisponibles);
	}
	protected void actionPerformedBtnXPiqueos(ActionEvent e) {
		eliminarElementoAgregado(cboPiqueosElegidos, cboPiqueosDisponibles);
	}
	
	
	private void eliminarElementoAgregado(JComboBox cboAgregados, JComboBox cboDisponibles) {
		try {
		    // Obtener el elemento seleccionado
	        String elementoSeleccionado = cboAgregados.getSelectedItem().toString();
	
	        // Verificar que el elemento seleccionado no sea la opción "Seleccionar"
	        if (!elementoSeleccionado.equals("Seleccionar")) {
	            // Agregar el elemento seleccionado al JComboBox de destino
	        	cboDisponibles.addItem(elementoSeleccionado);
	
	            // Eliminar el elemento seleccionado del JComboBox de origen
	            eliminarElementoSeleccionado(cboAgregados, elementoSeleccionado);
	        }
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	protected void actionPerformedCboCliente(ActionEvent e) {
		// Obtener el cliente seleccionado
        String clienteSeleccionado = cboCliente.getSelectedItem().toString();

        // Mostrar el cliente seleccionado
        if(!clienteSeleccionado.equals("Seleccionar")) {
            txtCliente.setText(arCliente.buscarCliente(clienteSeleccionado).getNombres());
        }
	}
	protected void actionPerformedBtnCliente(ActionEvent e) {
		FrmMantenimientoCliente mantenimientoCliente = new FrmMantenimientoCliente(usuario);
        mantenimientoCliente.setVisible(true);
        dispose();
	}
	protected void actionPerformedBtnRegistrar(ActionEvent e) {
		// Declaracion de variables
		String idPedido, idUsuario, idCliente;
		ArrayList<Cancion> canciones;
		ArrayList<Bebida> bebidas;
		ArrayList<Piqueo> piqueos;
		Date fechaPedido;
		int estado;
		
		// Entrada de datos
		idPedido = getIdPedido();
		idUsuario = getIdUsuario();
		idCliente = getIdCliente();
		canciones = getCanciones();
		bebidas = getBebidas();
		piqueos = getPiqueos();
		fechaPedido = getFechaPedido();
		estado = getEstado();
		
		// validacion
		if(idCliente == null || canciones == null || bebidas == null || piqueos == null || fechaPedido == null) {
			return;
		} else {
			// Creamos el pedido
			Pedido p = new Pedido(idPedido, fechaPedido, idUsuario, idCliente, canciones, bebidas, piqueos, estado);
			// Aumentamos las reproducciones de las canciones
			cambiarReproducciones(canciones);
			// Agregamos el pedido al ArrayList
			arPedido.adicionar(p);
			// Guardar data del pedido
			arPedido.guardarDataPedido();
			// Actualizamos la tabla
			listar();
		}
	}

	private void listar() {
		model.setRowCount(0);
		// formatear la fecha
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		// bucle para recorrer el pedido
		for(int i = 0; i<arPedido.tamanio(); i++) {
			Object[] fila = {
				arPedido.obtener(i).getIdPedido(),
				dateFormat.format(arPedido.obtener(i).getFechaPedido()),
				arPedido.obtener(i).getIdUsuario(),
				arPedido.obtener(i).getIdCliente(),
				listadoCanciones(arPedido.obtener(i).getCanciones()),
				listadoBebidas(arPedido.obtener(i).getBebidas()),
				listadoPiqueos(arPedido.obtener(i).getPiqueos()),
				estadoString(arPedido.obtener(i).getEstado())
			};
			model.addRow(fila);
		}
	}
	
	// Cambiar reproducciones de las canciones
	private void cambiarReproducciones(ArrayList<Cancion> canciones) {
		for(int i = 0; i<arCancion.tamanio(); i++) {
			for(int x = 0; x<canciones.size(); x++) {
				if(arCancion.obtener(i).getIdCancion().equals(canciones.get(x).getIdCancion()))
					arCancion.obtener(i).setNumReprod(arCancion.obtener(i).getNumReprod()+1);
					arCancion.guardarDataCancion();
			}
		}
	}
	
	// Convertir estado en String
	private String estadoString(int estado) {
		switch(estado) {
		case 0:
			return "Pendiente";
		case 1:
			return "Atendido";
		default:
			return "Anulado";
		}
	}
	
	// Convertir en cadena de texto los ArrayList (Cancion, Piqueo y Bebida)
	private String listadoCanciones(ArrayList<Cancion> canciones) {
		String lista = "";
		for(int i = 0; i<canciones.size(); i++) {
			lista += canciones.get(i).getIdCancion() + ". ";
		}
		return lista;
	}
	
	private String listadoPiqueos(ArrayList<Piqueo> piqueos) {
		String lista = "";
		for(int i = 0; i<piqueos.size(); i++) {
			lista += piqueos.get(i).getIdPiqueo() + ". ";
		}
		return lista;
	}
	
	private String listadoBebidas(ArrayList<Bebida> bebidas) {
		String lista = "";
		for(int i = 0; i<bebidas.size(); i++) {
			lista += bebidas.get(i).getIdBebida() + ". ";
		}
		return lista;
	}
	
	//

	private int getEstado() {
		return 0;
	}

	private Date getFechaPedido() {
		return new Date();
	}

	private ArrayList<Piqueo> getPiqueos() {
		ArrayList<Piqueo> piqueos = new ArrayList<>();
		for(int i = 0; i < cboPiqueosElegidos.getItemCount(); i++) {
			String idPiqueo = cboPiqueosElegidos.getItemAt(i).toString();
			if(idPiqueo != "Seleccionar") {
				piqueos.add(arPiqueo.buscarPiqueo(idPiqueo));
			}
		}
		if(piqueos.size()<=0) {
			Alertas.mensajeAlerta("Agregue por lo menos 1 piqueo");
			return null;
		}
		return piqueos;
	}

	private ArrayList<Bebida> getBebidas() {
		ArrayList<Bebida> bebidas = new ArrayList<>();
		for(int i = 0; i < cboBebidasElegidas.getItemCount(); i++) {
			String idBebida = cboBebidasElegidas.getItemAt(i).toString();
			if(idBebida != "Seleccionar") {
				bebidas.add(arBebida.buscarBebida(idBebida));
			}
		}
		if(bebidas.size()<=0) {
			Alertas.mensajeAlerta("Agregue por lo menos 1 bebida");
			return null;
		}
		return bebidas;
	}

	private ArrayList<Cancion> getCanciones() {
		ArrayList<Cancion> canciones = new ArrayList<>();
		for(int i = 0; i < cboCancionesElegidas.getItemCount(); i++) {
			String idCancion = cboCancionesElegidas.getItemAt(i).toString();
			if(idCancion != "Seleccionar") {
				canciones.add(arCancion.buscarCancion(idCancion));
			}
		}
		if(canciones.size()<=0) {
			Alertas.mensajeAlerta("Agregue por lo menos 1 canción");
			return null;
		}
		return canciones;
	}

	private String getIdCliente() {
		String clienteSeleccionado = cboCliente.getSelectedItem().toString();
		if(clienteSeleccionado.trim().length()==0) {
			return null;
		}
		
		if (!clienteSeleccionado.equals("Seleccionar")) {
            Cliente cliente = arCliente.buscarCliente(clienteSeleccionado);
            return cliente.getIdCliente();
        } else {
        	Alertas.mensajeAlerta("Seleccione un cliente");
        	return null;
        }
	}

	private String getIdUsuario() {
		return txtUsuario.getText();
	}

	private String getIdPedido() {
		return txtIdPedido.getText();
	}
	protected void actionPerformedBtnNuevo(ActionEvent e) {
		txtIdPedido.setText(arPedido.generarPedido());
		txtCliente.setText("");
		cboCliente.setSelectedIndex(0);
		cargarCancionesDisponibles();
		cargarBebidasDisponibles();
		cargarPiqueosDisponibles();
		cboCancionesElegidas.removeAllItems();
		cboBebidasElegidas.removeAllItems();
		cboPiqueosElegidos.removeAllItems();
	}
}
