package vista;

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
import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JScrollPane;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import controlador.ArregloArtista;
import controlador.ArregloGenero;
import entidad.Artista;
import entidad.Cliente;
import entidad.Genero;
import entidad.Usuario;
import utils.Alertas;
import utils.Formatear;

import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.UIManager;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import java.awt.event.MouseListener;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.awt.event.MouseEvent;

public class FrmMantenimientoArtista extends JFrame implements ActionListener, KeyListener, MouseListener {

	private JPanel contentPane;
	private JLabel lblMantenimientoArtista;
	private JLabel lblIdArtista;
	private JTextField txtIdArtista;
	private JLabel lblNombreArtistico;
	private JTextField txtNombreArtistico;
	private JLabel lblIdGenero;
	private JLabel lblFechaRegistro;
	private JTextField txtFechaRegistro;
	private JLabel lblEstado;
	private JComboBox cboEstado;
	private JTable tblArtista;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JScrollPane scrollPane;
	private JButton btnNuevo;
	private JButton btnRegistrar;
	private JButton btnMostrarTodo;
	private JButton btnBuscar;
	private JButton btnModificar;
	private JButton btnEliminar;
	
	// instanciar el controlador
	ArregloArtista arArtista = new ArregloArtista();
	ArregloGenero arGenero = new ArregloGenero();
	
	// instanciar tabla
	DefaultTableModel model = new DefaultTableModel();
	private JComboBox cboIdGenero;

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
					FrmMantenimientoArtista frame = new FrmMantenimientoArtista();
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
	public FrmMantenimientoArtista() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 1001, 692);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblMantenimientoArtista = new JLabel("Mantenimiento Artista");
		lblMantenimientoArtista.setHorizontalAlignment(SwingConstants.CENTER);
		lblMantenimientoArtista.setFont(new Font("Arial", Font.BOLD, 32));
		lblMantenimientoArtista.setBackground(Color.PINK);
		lblMantenimientoArtista.setForeground(Color.BLACK);
		lblMantenimientoArtista.setBounds(0, 0, 985, 74);
		contentPane.add(lblMantenimientoArtista);
		
		lblIdArtista = new JLabel("Id Artista:");
		lblIdArtista.setFont(new Font("Arial", Font.PLAIN, 16));
		lblIdArtista.setBounds(25, 101, 90, 20);
		contentPane.add(lblIdArtista);
		
		txtIdArtista = new JTextField();
		txtIdArtista.setEnabled(false);
		txtIdArtista.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txtIdArtista.setBounds(125, 93, 140, 37);
		contentPane.add(txtIdArtista);
		txtIdArtista.setColumns(10);
		
		lblNombreArtistico = new JLabel("N. Art\u00EDstico:");
		lblNombreArtistico.setFont(new Font("Arial", Font.PLAIN, 16));
		lblNombreArtistico.setBounds(25, 199, 90, 20);
		contentPane.add(lblNombreArtistico);
		
		txtNombreArtistico = new JTextField();
		txtNombreArtistico.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txtNombreArtistico.setColumns(10);
		txtNombreArtistico.setBounds(125, 191, 140, 37);
		contentPane.add(txtNombreArtistico);
		
		lblIdGenero = new JLabel("Id G\u00E9nero:");
		lblIdGenero.setFont(new Font("Arial", Font.PLAIN, 16));
		lblIdGenero.setBounds(25, 151, 90, 20);
		contentPane.add(lblIdGenero);
		
		lblFechaRegistro = new JLabel("F. Registro:");
		lblFechaRegistro.setFont(new Font("Arial", Font.PLAIN, 16));
		lblFechaRegistro.setBounds(317, 101, 90, 20);
		contentPane.add(lblFechaRegistro);
		
		txtFechaRegistro = new JTextField();
		txtFechaRegistro.setEditable(false);
		txtFechaRegistro.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txtFechaRegistro.setColumns(10);
		txtFechaRegistro.setBounds(417, 93, 140, 37);
		contentPane.add(txtFechaRegistro);
		
		lblEstado = new JLabel("Estado:");
		lblEstado.setFont(new Font("Arial", Font.PLAIN, 16));
		lblEstado.setBounds(317, 151, 90, 20);
		contentPane.add(lblEstado);
		
		cboEstado = new JComboBox();
		cboEstado.setFont(new Font("Tahoma", Font.PLAIN, 13));
		cboEstado.setModel(new DefaultComboBoxModel(new String[] {"Habilitado", "Inhabilitado"}));
		cboEstado.setBounds(417, 143, 140, 37);
		contentPane.add(cboEstado);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(25, 288, 934, 336);
		contentPane.add(scrollPane);
		
		tblArtista = new JTable();
		tblArtista.addMouseListener(this);
		tblArtista.addKeyListener(this);
		scrollPane.setViewportView(tblArtista);
		tblArtista.setFillsViewportHeight(true);
		tblArtista.setFont(new Font("Tahoma", Font.PLAIN, 11));
		
		btnNuevo = new JButton("Nuevo");
		btnNuevo.addActionListener(this);
		btnNuevo.setIcon(new ImageIcon("img\\iconNew.png"));
		btnNuevo.setFont(new Font("Arial", Font.BOLD, 16));
		btnNuevo.setBounds(625, 90, 162, 55);
		contentPane.add(btnNuevo);
		
		btnRegistrar = new JButton("Registrar");
		btnRegistrar.addActionListener(this);
		btnRegistrar.setIcon(new ImageIcon("img\\iconRegister.png"));
		btnRegistrar.setFont(new Font("Arial", Font.BOLD, 16));
		btnRegistrar.setBounds(625, 156, 162, 55);
		contentPane.add(btnRegistrar);
		
		btnMostrarTodo = new JButton("Mostrar");
		btnMostrarTodo.addActionListener(this);
		btnMostrarTodo.setIcon(new ImageIcon("img\\iconoMostrarTodo.png"));
		btnMostrarTodo.setFont(new Font("Arial", Font.BOLD, 16));
		btnMostrarTodo.setBounds(625, 222, 162, 55);
		contentPane.add(btnMostrarTodo);
		
		btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(this);
		btnBuscar.setIcon(new ImageIcon("img\\iconSearch.png"));
		btnBuscar.setFont(new Font("Arial", Font.BOLD, 16));
		btnBuscar.setBounds(796, 222, 162, 55);
		contentPane.add(btnBuscar);
		
		btnModificar = new JButton("Modificar");
		btnModificar.addActionListener(this);
		btnModificar.setIcon(new ImageIcon("img\\iconModify.png"));
		btnModificar.setFont(new Font("Arial", Font.BOLD, 16));
		btnModificar.setBounds(797, 157, 162, 52);
		contentPane.add(btnModificar);
		
		btnEliminar = new JButton("Eliminar");
		btnEliminar.addActionListener(this);
		btnEliminar.setIcon(new ImageIcon("img\\iconRemove.png"));
		btnEliminar.setFont(new Font("Arial", Font.BOLD, 16));
		btnEliminar.setBounds(797, 90, 162, 55);
		contentPane.add(btnEliminar);
		
		// construir la tabla
		model.addColumn("Id Artista");
		model.addColumn("Nombre Artístico");
		model.addColumn("Id Género");
		model.addColumn("Fecha de Registro");
		model.addColumn("Estado");
		tblArtista.setModel(model);
		
		cboIdGenero = new JComboBox();
		cboIdGenero.setFont(new Font("Tahoma", Font.PLAIN, 13));
		cboIdGenero.setBounds(125, 143, 140, 37);
		contentPane.add(cboIdGenero);
		
        // Llamar a los métodos para cargar las opciones en los JComboBox
        cargarIdGeneros();
		
		//
		listar();
		
		//
		mostrarData(0);
	}
	
    private void cargarIdGeneros() {
        // Crear una lista que va contener los clientes
        ArrayList<Genero> generos = new ArrayList<Genero>();

        // Limpiar el JComboBox
           cboIdGenero.removeAllItems();
           
        // Agregar la opcion Seleccionar al combobox
           cboIdGenero.addItem("Seleccionar");
           
        // bucle para recorrer el ArregloCliente
        for (int i = 0; i<arGenero.tamanio(); i++) {
        	// Agregamos cada cliente a la lista
        	generos.add(arGenero.obtener(i));
            
            // Agregamos los ids de los clientes al combobox
        	cboIdGenero.addItem(arGenero.obtener(i).getIdGenero());
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
		registrarArtista();
	}

	private void registrarArtista() {
		// declaración de variables
		String idArtista, nombArtistico, idGenero;
		Date fecRegistro;
		boolean  estado;
		
		// entrada de datos
		idArtista = getIdArtista();
		nombArtistico = getNombArtistico();
		idGenero = getIdGenero();
		fecRegistro = getFecRegistro();
		estado = getEstado();
		
		// validación
		if(idArtista == null || nombArtistico == null || idGenero == null || fecRegistro == null) {
			return;
		} else {
			// verificar que no exista el artista
			Artista bean = arArtista.buscarArtista(idArtista);
			if(bean==null) {
				// creamos un artista
				Artista a = new Artista(idArtista, nombArtistico, idGenero, fecRegistro, estado);
				// agregamos el artista al arreglo
				arArtista.adicionar(a);
				// Guardamos la data de los Artistas
				arArtista.guardarDataArtista();
				// actualizamos la tabla
				listar();
			}else {
				Alertas.mensajeError("Error, este artista ya existe");
			}
		}
	}

	private void listar() {
		// limpiar la tabla
		model.setRowCount(0);
		// bucle para recorrer el arreglo
		for(int i = 0; i<arArtista.tamanio(); i++) {
			Object[] fila = {
					arArtista.obtener(i).getIdArtista(),
					arArtista.obtener(i).getNombreArtistico(),
					arArtista.obtener(i).getIdGenero(),
					Formatear.DATETOSTRING.format(arArtista.obtener(i).getFechaRegistro()),
					getEstadoString(arArtista.obtener(i).getEstado())
			};
			model.addRow(fila);
		}
	}
	
	private void mostrarData(int posFila) {
		try {
			// declaracion de variables
			String idArtista, nombArtistico, idGenero, fecRegistro, estado;
			
			// obtener los datos de la tabla
			idArtista = tblArtista.getValueAt(posFila, 0).toString();
			nombArtistico = tblArtista.getValueAt(posFila, 1).toString();
			idGenero = tblArtista.getValueAt(posFila, 2).toString();
			fecRegistro = tblArtista.getValueAt(posFila, 3).toString();
			estado = tblArtista.getValueAt(posFila, 4).toString();
			
			// mostrar datos obtenidos de la tabla
			txtIdArtista.setText(idArtista);
			txtNombreArtistico.setText(nombArtistico);
			cboIdGenero.setSelectedItem(idGenero);
			txtFechaRegistro.setText(fecRegistro);
			cboEstado.setSelectedItem(estado);
		} catch (Exception e) {
			// TODO: handle exception
		}
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

	private Date getFecRegistro() {
		try {
			return Formatear.DATETOSTRING.parse(txtFechaRegistro.getText().trim());
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			return null;
		}
	}

	private String getIdGenero() {
		String idGenero = cboIdGenero.getSelectedItem().toString();
		if (idGenero.matches("GEN\\d{2}")) {
			for(int i = 0; i<arGenero.tamanio(); i++) {
				if(arGenero.obtener(i).getIdGenero().equals(idGenero)){
					return idGenero;
				}
			}
			Alertas.mensajeError("No existe el género ingresado");
			return null;
		} else {
			Alertas.mensajeError("Seleccione un género");
			return null;
		}
	}

	private String getNombArtistico() {
		String nombre = txtNombreArtistico.getText().trim();

		if (nombre.length() == 0) {
			Alertas.mensajeError("Ingresar Nombre");
			txtNombreArtistico.setText("");
			txtNombreArtistico.requestFocus();
			return null;

		} else if (!nombre.matches("^[A-Za-záéíóúÁÉÍÓÚñÑ ]+$")) {
			Alertas.mensajeError("El nombre debe contener solo letras y espacios");
			txtNombreArtistico.setText("");
			txtNombreArtistico.requestFocus();
			nombre = null;
		} else {
			nombre = txtNombreArtistico.getText().trim();
		}

		return nombre;
	}

	private String getIdArtista() {
		String idArtista = txtIdArtista.getText().trim();
		if (idArtista.matches("ART\\d{3}")) {
			return idArtista;
		} else {
			Alertas.mensajeError("El Id Artista debe tener el formato correcto (ART001, ART002… ART050, etc.).");
			return null;
		}
	}
	protected void actionPerformedBtnNuevo(ActionEvent e) {
		txtIdArtista.setText(arArtista.generarArtista());
		cboIdGenero.setSelectedIndex(0);
		txtFechaRegistro.setText(Formatear.DATETOSTRING.format(new Date()));
		txtNombreArtistico.setText("");
		cboEstado.setSelectedIndex(0);
	}
	
	
	protected void actionPerformedBtnModificar(ActionEvent e) {
		modificarArtista();
	}

	private void modificarArtista() {
		// declaración de variables
		String idArtista, nombArtistico, idGenero;
		Date fecRegistro;
		boolean  estado;
		
		// entrada de datos
		idArtista = getIdArtista();
		nombArtistico = getNombArtistico();
		idGenero = getIdGenero();
		fecRegistro = getFecRegistro();
		estado = getEstado();
		
		// validación
		if(idArtista == null || nombArtistico == null || idGenero == null || fecRegistro == null) {
			return;
		} else {
			// verificar si existe el Artista
			Artista bean = arArtista.buscarArtista(idArtista);
			if(bean!=null) {
				// Modificamos los datos del Artista
				bean.setIdGenero(idGenero);
				bean.setNombreArtistico(nombArtistico);
				bean.setFechaRegistro(fecRegistro);
				bean.setEstado(estado);
				// Guardamos la data de los Artistas
				arArtista.guardarDataArtista();
				// actualizamos la tabla
				listar();
			}
		}
	}
	
	
	protected void actionPerformedBtnEliminar(ActionEvent e) {
		eliminarArtista();
	}

	private void eliminarArtista() {
		// declaracion de variables
		String idArtista;
		
		// entrada de datos
		idArtista = getIdArtista();
		
		// validacion
		if(idArtista==null) {
			return;
		} else {
			// verificamos que el Artista exista
			Artista bean = arArtista.buscarArtista(idArtista);
			if(bean!=null) {
				int opcion = JOptionPane.showConfirmDialog(this, "Está seguro de eliminar este artista?", "Sistema",
						JOptionPane.YES_NO_OPTION);
				if (opcion == 0) {
					// eliminar el artista
					arArtista.eliminar(bean);
					// Guardamos la data de los Artistas
					arArtista.guardarDataArtista();
					// Actualizar la tabla
					listar();
				}
			} else {
				Alertas.mensajeError("Este artista no existe");
			}
		}
	}
	protected void actionPerformedBtnBuscar(ActionEvent e) {
		buscarArtista();
	}

	private void buscarArtista() {
		// Declaración de variables
		String idArtistaNombre;

		// Entrada de datos
		idArtistaNombre = JOptionPane.showInputDialog(this, "Ingrese el IdArtista o Nombre Artístico");

		// Validación
		if (idArtistaNombre == null) {
			return;
		} else {
			// Validar si el usuario existe mediante el idUsuario
			Artista bean = arArtista.buscarArtista(idArtistaNombre);
			if (bean != null) {
				// Proceso de cálculo
				// Establecer datos en los casilleros
				txtIdArtista.setText(bean.getIdArtista());
				txtFechaRegistro.setText(Formatear.DATETOSTRING.format(bean.getFechaRegistro()));
				cboIdGenero.setSelectedItem(bean.getIdGenero());
				txtNombreArtistico.setText(bean.getNombreArtistico());
				cboEstado.setSelectedItem(getEstadoString(bean.getEstado()));
				listarEncontrar(idArtistaNombre);

			} else {
				// Validar si el usuario existe mediante el login
				Artista beanNombre = arArtista.buscarArtistaNombres(idArtistaNombre);
				if(beanNombre != null) {
					// Establecer datos en los casilleros
					txtIdArtista.setText(beanNombre.getIdArtista());
					txtFechaRegistro.setText(Formatear.DATETOSTRING.format(beanNombre.getFechaRegistro()));
					cboIdGenero.setSelectedItem(beanNombre.getIdGenero());
					txtNombreArtistico.setText(beanNombre.getNombreArtistico());
					cboEstado.setSelectedItem(getEstadoString(beanNombre.getEstado()));
					listarEncontrar(idArtistaNombre);
				} else{
					Alertas.mensajeAlerta("Artista no encontrado");
				}
			}
		}
	}
	
	private void listarEncontrar(String filtro) {
		// limpiar la tabla
		model.setRowCount(0);
		// bucle para recorrer el arreglo
		for(int i = 0; i<arArtista.tamanio(); i++) {
			if(arArtista.obtener(i).getIdArtista().equals(filtro) || arArtista.obtener(i).getNombreArtistico().equals(filtro)) {
				Object[] fila = {
						arArtista.obtener(i).getIdArtista(),
						arArtista.obtener(i).getNombreArtistico(),
						arArtista.obtener(i).getIdGenero(),
						Formatear.DATETOSTRING.format(arArtista.obtener(i).getFechaRegistro()),
						getEstadoString(arArtista.obtener(i).getEstado())
				};
				model.addRow(fila);
			}
		}
	}
	
	protected void actionPerformedBtnMostrarTodo(ActionEvent e) {
		listar();
	}
	public void keyPressed(KeyEvent e) {
	}
	public void keyReleased(KeyEvent e) {
		if (e.getSource() == tblArtista) {
			keyReleasedTblArtista(e);
		}
	}
	public void keyTyped(KeyEvent e) {
	}
	protected void keyReleasedTblArtista(KeyEvent e) {
		int posFila;
		posFila = tblArtista.getSelectedRow();
		// Mostrar datos
		try {
			mostrarData(posFila);
		} catch (Exception e2) {
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
		if (e.getSource() == tblArtista) {
			mouseReleasedTblArtista(e);
		}
	}
	protected void mouseReleasedTblArtista(MouseEvent e) {
		int posFila;
		posFila = tblArtista.getSelectedRow();
		// Mostrar datos
		try {
			mostrarData(posFila);
		} catch (Exception e2) {
			// TODO: handle exception
		}
	}
}
