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
import javax.swing.JSpinner;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import controlador.ArregloArtista;
import controlador.ArregloCancion;
import entidad.Artista;
import entidad.Cancion;
import entidad.Genero;
import utils.Alertas;
import utils.Formatear;

import javax.swing.JRadioButton;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JCheckBox;
import javax.swing.ButtonGroup;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextPane;
import javax.swing.JTextArea;
import javax.swing.DropMode;
import javax.swing.UIManager;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseListener;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.awt.event.MouseEvent;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;

public class FrmMantenimientoCancion extends JFrame implements ActionListener, MouseListener, KeyListener {

	private JPanel contentPane;
	private JLabel lblMantenimientoCancion;
	private JLabel lblidCancion;
	private JLabel lblNombre;
	private JLabel lblIdArtista;
	private JLabel lblAlbum;
	private JTextField txtIdCancion;
	private JTextField txtNombre;
	private JTextField txtAlbum;
	private JLabel lblFecharegisto;
	private JTextField txtFechaRegistro;
	private JTable tblCancion;
	private JScrollPane scrollPane;
	private JLabel lblNewLabel;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JComboBox cboEstado;
	private final ButtonGroup buttonGroup_1 = new ButtonGroup();
	private JButton btnNuevo;
	private JButton btnRegistrar;
	private JButton btnMostrarTodo;
	private JButton btnBuscar;
	private JButton btnModificar;
	private JButton btnEliminar;
	// instanciar controlador
	ArregloCancion arCancion = new ArregloCancion();
	ArregloArtista arArtista = new ArregloArtista();
	
	// instanciar tabla
	DefaultTableModel model = new DefaultTableModel();
	
	// formatear fechas
	SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
	private JComboBox cboIdArtistas;
	
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
					FrmMantenimientoCancion frame = new FrmMantenimientoCancion();
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
	public FrmMantenimientoCancion() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 983, 683);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblMantenimientoCancion = new JLabel("Mantenimiento Canci\u00F3n");
		lblMantenimientoCancion.setHorizontalAlignment(SwingConstants.CENTER);
		lblMantenimientoCancion.setForeground(Color.BLACK);
		lblMantenimientoCancion.setFont(new Font("Arial", Font.BOLD, 32));
		lblMantenimientoCancion.setBackground(Color.DARK_GRAY);
		lblMantenimientoCancion.setBounds(0, 0, 967, 74);
		contentPane.add(lblMantenimientoCancion);
		
		lblidCancion = new JLabel("Id Canci\u00F3n:");
		lblidCancion.setFont(new Font("Arial", Font.PLAIN, 16));
		lblidCancion.setBounds(21, 94, 90, 20);
		contentPane.add(lblidCancion);
		
		lblNombre = new JLabel("Nombre:");
		lblNombre.setFont(new Font("Arial", Font.PLAIN, 16));
		lblNombre.setBounds(21, 142, 90, 20);
		contentPane.add(lblNombre);
		
		lblIdArtista = new JLabel("Id Artista");
		lblIdArtista.setFont(new Font("Arial", Font.PLAIN, 16));
		lblIdArtista.setBounds(298, 190, 90, 20);
		contentPane.add(lblIdArtista);
		
		lblAlbum = new JLabel("Album");
		lblAlbum.setFont(new Font("Arial", Font.PLAIN, 16));
		lblAlbum.setBounds(21, 190, 90, 20);
		contentPane.add(lblAlbum);
		
		txtIdCancion = new JTextField();
		txtIdCancion.setEnabled(false);
		txtIdCancion.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txtIdCancion.setBounds(121, 85, 140, 37);
		contentPane.add(txtIdCancion);
		txtIdCancion.setColumns(10);
		
		txtNombre = new JTextField();
		txtNombre.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txtNombre.setBounds(121, 133, 140, 37);
		contentPane.add(txtNombre);
		txtNombre.setColumns(10);
		
		txtAlbum = new JTextField();
		txtAlbum.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txtAlbum.setBounds(121, 181, 140, 37);
		contentPane.add(txtAlbum);
		txtAlbum.setColumns(10);
		
		lblFecharegisto = new JLabel("F. Registro:");
		lblFecharegisto.setFont(new Font("Arial", Font.PLAIN, 16));
		lblFecharegisto.setBounds(298, 142, 90, 20);
		contentPane.add(lblFecharegisto);
		
		txtFechaRegistro = new JTextField();
		txtFechaRegistro.setEditable(false);
		txtFechaRegistro.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txtFechaRegistro.setBounds(398, 133, 140, 37);
		contentPane.add(txtFechaRegistro);
		txtFechaRegistro.setColumns(10);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(21, 283, 922, 337);
		contentPane.add(scrollPane);
		
		tblCancion = new JTable();
		tblCancion.addKeyListener(this);
		tblCancion.addMouseListener(this);
		scrollPane.setViewportView(tblCancion);
		tblCancion.setFillsViewportHeight(true);
		
		lblNewLabel = new JLabel("Estado:");
		lblNewLabel.setFont(new Font("Arial", Font.PLAIN, 16));
		lblNewLabel.setBounds(298, 94, 90, 20);
		contentPane.add(lblNewLabel);
		
		cboEstado = new JComboBox();
		cboEstado.setModel(new DefaultComboBoxModel(new String[] {"Habilitado", "Inhabilitado"}));
		cboEstado.setFont(new Font("Tahoma", Font.PLAIN, 13));
		cboEstado.setBounds(398, 85, 140, 37);
		contentPane.add(cboEstado);
		
		btnNuevo = new JButton("Nuevo");
		btnNuevo.addActionListener(this);
		btnNuevo.setIcon(new ImageIcon("img\\iconNew.png"));
		btnNuevo.setFont(new Font("Arial", Font.BOLD, 16));
		btnNuevo.setBounds(609, 85, 162, 55);
		contentPane.add(btnNuevo);
		
		btnRegistrar = new JButton("Registrar");
		btnRegistrar.addActionListener(this);
		btnRegistrar.setIcon(new ImageIcon("img\\iconRegister.png"));
		btnRegistrar.setFont(new Font("Arial", Font.BOLD, 16));
		btnRegistrar.setBounds(609, 151, 162, 55);
		contentPane.add(btnRegistrar);
		
		btnMostrarTodo = new JButton("Mostrar");
		btnMostrarTodo.addActionListener(this);
		btnMostrarTodo.setIcon(new ImageIcon("img\\iconoMostrarTodo.png"));
		btnMostrarTodo.setFont(new Font("Arial", Font.BOLD, 16));
		btnMostrarTodo.setBounds(609, 217, 162, 55);
		contentPane.add(btnMostrarTodo);
		
		btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(this);
		btnBuscar.setIcon(new ImageIcon("img\\iconSearch.png"));
		btnBuscar.setFont(new Font("Arial", Font.BOLD, 16));
		btnBuscar.setBounds(780, 217, 162, 55);
		contentPane.add(btnBuscar);
		
		btnModificar = new JButton("Modificar");
		btnModificar.addActionListener(this);
		btnModificar.setIcon(new ImageIcon("img\\iconModify.png"));
		btnModificar.setFont(new Font("Arial", Font.BOLD, 16));
		btnModificar.setBounds(781, 152, 162, 52);
		contentPane.add(btnModificar);
		
		btnEliminar = new JButton("Eliminar");
		btnEliminar.addActionListener(this);
		btnEliminar.setIcon(new ImageIcon("img\\iconRemove.png"));
		btnEliminar.setFont(new Font("Arial", Font.BOLD, 16));
		btnEliminar.setBounds(781, 85, 162, 55);
		contentPane.add(btnEliminar);
		
		// creamos la tabla
		model.addColumn("IdCancion");
		model.addColumn("Nombre");
		model.addColumn("IdArtista");
		model.addColumn("Album");
		model.addColumn("Fecha de Registro");
		model.addColumn("Nro. Reproducciones");
		model.addColumn("Estado");
		tblCancion.setModel(model);
		
		cboIdArtistas = new JComboBox();
		cboIdArtistas.setFont(new Font("Tahoma", Font.PLAIN, 13));
		cboIdArtistas.setBounds(398, 181, 140, 37);
		contentPane.add(cboIdArtistas);
        // Llamar a los métodos para cargar las opciones en los JComboBox
        cargarIdArtistas();
		
		//
		listar();
		
		//
		mostrarData(0);
	}
	
    private void cargarIdArtistas() {
        // Crear una lista que va contener los clientes
        ArrayList<Artista> artistas = new ArrayList<Artista>();

        // Limpiar el JComboBox
           cboIdArtistas.removeAllItems();
           
        // Agregar la opcion Seleccionar al combobox
           cboIdArtistas.addItem("Seleccionar");
           
        // bucle para recorrer el ArregloCliente
        for (int i = 0; i<arArtista.tamanio(); i++) {
        	// Agregamos cada cliente a la lista
        	artistas.add(arArtista.obtener(i));
            
            // Agregamos los ids de los clientes al combobox
        	cboIdArtistas.addItem(arArtista.obtener(i).getIdArtista());
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
		registrarCancion();
	}

	private void registrarCancion() {
		// Declaracion de variables
		String idCancion, nombre,  idArtista, album;
		Date fecReg;
		int nroReprod;
		boolean estado;
		
		// entrada de datos
		idCancion = getIdCancion();
		nombre = getNombre();
		idArtista = getIdArtista();
		album = getAlbum();
		fecReg = getFecReg();
		nroReprod = getNroReprod();
		estado = getEstado();
		
		// validacion
		if(idCancion==null || nombre==null || idArtista==null|| album==null || fecReg==null) {
			return;
		} else {
			// Verificamos que la cancion no exista
			Cancion bean = arCancion.buscarCancion(idCancion);
			if(bean==null) {
				// creamos una Cancion con los datos obtenidos
				Cancion c = new Cancion(idCancion, nombre, idArtista, album, fecReg, nroReprod, estado);
				// Ingresamos la cancion en el arreglo
				arCancion.adicionar(c);
				// Guardamos la data de cancion
				arCancion.guardarDataCancion();
				// actualizamos la tabla
				listar();
			} else {
				Alertas.mensajeError("Error, esta canción ya existe");
			}
		}
	}

	private void listar() {
		model.setRowCount(0);
		for(int i = 0; i<arCancion.tamanio(); i++) {
			Object[] fila = {
					arCancion.obtener(i).getIdCancion(),
					arCancion.obtener(i).getNombre(),
					arCancion.obtener(i).getIdArtista(),
					arCancion.obtener(i).getAlbum(),
					Formatear.DATETOSTRING.format(arCancion.obtener(i).getFechaRegistro()),
					arCancion.obtener(i).getNumReprod(),
					getEstadoString(arCancion.obtener(i).getEstado())
			};
			model.addRow(fila);
		}
	}
	
	private void mostrarData(int posFila) {
		try {
			// Declaracion de variables
			String idCancion, nombre,  idArtista, album, fecReg, nroReprod, estado;
			// entrada de datos
			idCancion = tblCancion.getValueAt(posFila, 0).toString();
			nombre = tblCancion.getValueAt(posFila, 1).toString();
			idArtista = tblCancion.getValueAt(posFila, 2).toString();
			album = tblCancion.getValueAt(posFila, 3).toString();
			fecReg = tblCancion.getValueAt(posFila, 4).toString();
			nroReprod = tblCancion.getValueAt(posFila, 5).toString();
			estado = tblCancion.getValueAt(posFila, 6).toString();
			// establecer datos en la gui
			txtIdCancion.setText(idCancion);
			txtNombre.setText(nombre);
			cboIdArtistas.setSelectedItem(idArtista);
			txtAlbum.setText(album);
			txtFechaRegistro.setText(fecReg);
			cboEstado.setSelectedItem(estado);
		} catch (Exception e) {
			// TODO: handle exception
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

	private boolean getEstado() {
		int estadoIndex = cboEstado.getSelectedIndex();
		return getEstadoBoolean(estadoIndex);
	}

	private boolean getEstadoBoolean(int estadoIndex) {
		switch(estadoIndex) {
		case 0:
			return true;
		default:
			return false;
		}
	}
	
	private String getEstadoString(boolean estado) {
		if(estado) {
			return "Habilitado";
		} else {
			return "Inhabilitado";
		}
	}

	private int getNroReprod() {
	    return 0;
	}

	private Date getFecReg() {
		try {
			Date fecReg;
			String fecRegistroString = txtFechaRegistro.getText().trim();
	
		    if (!fecRegistroString.matches("\\d{2}/\\d{2}/\\d{4}")) {
		        Alertas.mensajeError("Ingrese una fecha de afiliación válida en el formato dd/mm/yyyy.");
		        return null;
		    } 
	    	fecReg = dateFormat.parse(fecRegistroString);
			return fecReg;
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}

	private String getAlbum() {
		String album = txtAlbum.getText().trim();

		if (album.length() == 0) {
			Alertas.mensajeError("Ingresar album");
			txtAlbum.setText("");
			txtAlbum.requestFocus();
			return null;

		} else if (!album.matches("^[A-Za-záéíóúÁÉÍÓÚñÑ ]+$")) {
			Alertas.mensajeError("El album debe contener solo letras y espacios");
			txtAlbum.setText("");
			txtAlbum.requestFocus();
			album = null;
		} else {
			album = txtAlbum.getText().trim();
		}

		return album;
	}

	private String getIdArtista() {
		String idArtista = cboIdArtistas.getSelectedItem().toString();
		if (idArtista.matches("ART\\d{3}")) {
			for(int i = 0; i<arArtista.tamanio(); i++) {
				if(arArtista.obtener(i).getIdArtista().equals(idArtista))
					return idArtista;
			}
			Alertas.mensajeError("No existe el Artista ingresado");
			return null;
		} else {
			Alertas.mensajeError("Elija un artista.");
			return null;
		}
	}

	private String getIdCancion() {
		String idCancion = txtIdCancion.getText().trim();
		if (idCancion.matches("CAN\\d{4}")) {
			return idCancion;
		} else {
			Alertas.mensajeError("El Id Artista debe tener el formato correcto (ART001, ART002… ART050, etc.).");
			return null;
		}
	}
	protected void actionPerformedBtnModificar(ActionEvent e) {
		modificarCancion();
	}

	private void modificarCancion() {
		// Declaracion de variables
		String idCancion, nombre,  idArtista, album;
		Date fecReg;
		int nroReprod;
		boolean estado;
		
		// entrada de datos
		idCancion = getIdCancion();
		nombre = getNombre();
		idArtista = getIdArtista();
		album = getAlbum();
		fecReg = getFecReg();
		nroReprod = getNroReprod();
		estado = getEstado();
		
		// validacion
		if(idCancion==null || nombre==null || idArtista==null|| album==null || fecReg==null || nroReprod==0) {
			return;
		} else {
			// Verificamos que la cancion exista
			Cancion bean = arCancion.buscarCancion(idCancion);
			if(bean!=null) {
				// Modificamos los datos de la Cancion
				bean.setIdCancion(idCancion);
				bean.setNombre(nombre);
				bean.setIdArtista(idArtista);
				bean.setAlbum(album);
				bean.setFechaRegistro(fecReg);
				bean.setNumReprod(nroReprod);
				bean.setEstado(estado);
				// Guardamos la data de cancion
				arCancion.guardarDataCancion();
				// actualizamos la tabla
				listar();
			} else {
				Alertas.mensajeError("Esta canción no existe");
			}
		}
	}
	
	
	protected void actionPerformedBtnNuevo(ActionEvent e) {
		txtIdCancion.setText(arCancion.generarCancion());
		txtNombre.setText("");
		cboIdArtistas.setSelectedIndex(0);;
		txtAlbum.setText("");
		txtFechaRegistro.setText(Formatear.DATETOSTRING.format(new Date()));
		cboEstado.setSelectedItem("Habilitado");
	}
	
	
	protected void actionPerformedBtnEliminar(ActionEvent e) {
		eliminarCancion();
	}

	private void eliminarCancion() {
		// Declaracion de variables
		String idCancion;
		// Entrada de variables
		idCancion = getIdCancion();
		// validacion
		if(idCancion==null) {
			return;
		} else {
			// Verificamos que la cancion existe
			Cancion bean = arCancion.buscarCancion(idCancion);
			if(bean != null) {
				int opcion = JOptionPane.showConfirmDialog(this, "Está seguro de eliminar esta canción?", "Sistema",
						JOptionPane.YES_NO_OPTION);
				if (opcion == 0) {
					arCancion.eliminar(bean);
					// Guardamos la data de cancion
					arCancion.guardarDataCancion();
					// actualizamos la tabla
					listar();
				}
			} else {
				Alertas.mensajeError("Esta canción no existe");
			}
		}
	}
	
	
	protected void actionPerformedBtnBuscar(ActionEvent e) {
		buscarCancion();
	}

	private void buscarCancion() {
		// Declaración de variables
		String idCancionNombre;

		// Entrada de datos
		idCancionNombre = JOptionPane.showInputDialog(this, "Ingrese el IdCancion o Nombre");

		// Validación
		if (idCancionNombre == null) {
			return;
		} else {
			// Validar si el usuario existe mediante el idUsuario
			Cancion bean = arCancion.buscarCancion(idCancionNombre);
			if (bean != null) {
				// Proceso de cálculo
				// Establecer datos en los casilleros
				txtIdCancion.setText(bean.getIdCancion());
				txtNombre.setText(bean.getNombre());
				cboIdArtistas.setSelectedItem(bean.getIdArtista());
				txtAlbum.setText(bean.getAlbum());
				txtFechaRegistro.setText(dateFormat.format(bean.getFechaRegistro()));
				cboEstado.setSelectedItem(getEstadoString(bean.getEstado()));
				listarEncontrar(idCancionNombre);

			} else {
				// Validar si el usuario existe mediante el login
				Cancion beanNombre = arCancion.buscarCancionNombre(idCancionNombre);
				if(beanNombre != null) {
					// Establecer datos en los casilleros
					txtIdCancion.setText(beanNombre.getIdCancion());
					txtNombre.setText(beanNombre.getNombre());
					cboIdArtistas.setSelectedItem(beanNombre.getIdArtista());
					txtAlbum.setText(beanNombre.getAlbum());
					txtFechaRegistro.setText(dateFormat.format(beanNombre.getFechaRegistro()));
					cboEstado.setSelectedItem(getEstadoString(beanNombre.getEstado()));
					listarEncontrar(idCancionNombre);
					
				} else{
					Alertas.mensajeAlerta("Canción no encontrada");
				}
			}
		}
	}
	protected void actionPerformedBtnMostrarTodo(ActionEvent e) {
		listar();
	}
	
	private void listarEncontrar(String filtro) {
		model.setRowCount(0);
		for(int i = 0; i<arCancion.tamanio(); i++) {
			if(arCancion.obtener(i).getIdCancion().equals(filtro) || arCancion.obtener(i).getNombre().equals(filtro)) {
				Object[] fila = {
						arCancion.obtener(i).getIdCancion(),
						arCancion.obtener(i).getNombre(),
						arCancion.obtener(i).getIdArtista(),
						arCancion.obtener(i).getAlbum(),
						Formatear.DATETOSTRING.format(arCancion.obtener(i).getFechaRegistro()),
						arCancion.obtener(i).getNumReprod(),
						getEstadoString(arCancion.obtener(i).getEstado())
				};
				model.addRow(fila);
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
		if (e.getSource() == tblCancion) {
			mouseReleasedTblCancion(e);
		}
	}
	protected void mouseReleasedTblCancion(MouseEvent e) {
		int posFila;
		posFila = tblCancion.getSelectedRow();
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
		if (e.getSource() == tblCancion) {
			keyReleasedTblCancion(e);
		}
	}
	public void keyTyped(KeyEvent e) {
	}
	protected void keyReleasedTblCancion(KeyEvent e) {
		int posFila;
		posFila = tblCancion.getSelectedRow();
		// Mostrar datos
		try {
			mostrarData(posFila);
		} catch (Exception e2) {
			// TODO: handle exception
		}
	}
}
