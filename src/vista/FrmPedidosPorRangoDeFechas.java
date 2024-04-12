package vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import controlador.ArregloCliente;
import controlador.ArregloPedido;
import controlador.ArregloUsuario;
import entidad.Bebida;
import entidad.Cancion;
import entidad.Piqueo;
import utils.Alertas;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.awt.event.ActionEvent;
import javax.swing.UIManager;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;

public class FrmPedidosPorRangoDeFechas extends JFrame implements ActionListener, KeyListener, MouseListener {

	private JPanel contentPane;
	private JLabel lblPedidosPorRangoDeFechas;
	private JButton btnBuscar;
	private JButton btnMostrarTodo;
	private JScrollPane scrollPane;
	private JTable tblPedidosRangoFecha;
	private JButton btnAtender;
	private JButton btnAnular;
	private JLabel lblFInicio;
	private JLabel lblFFin;
	private JTextField txtFechaInicio;
	private JTextField txtFechaFin;
	private JTextArea txtS;
	private JScrollPane scrollPane_1;
	
	// Instanciar tabla
	DefaultTableModel model = new DefaultTableModel();
	
	// formatear fechas
	SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
	
	// Instanciar ArrayList
	ArregloPedido arPedido = new ArregloPedido();
	ArregloUsuario arUsuario = new ArregloUsuario();
	ArregloCliente arCliente = new ArregloCliente();

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
					FrmPedidosPorRangoDeFechas frame = new FrmPedidosPorRangoDeFechas();
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
	public FrmPedidosPorRangoDeFechas() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 1085, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblPedidosPorRangoDeFechas = new JLabel("Pedidos Por Rango de Fechas");
		lblPedidosPorRangoDeFechas.setHorizontalAlignment(SwingConstants.CENTER);
		lblPedidosPorRangoDeFechas.setFont(new Font("Arial", Font.BOLD, 25));
		lblPedidosPorRangoDeFechas.setBackground(Color.ORANGE);
		lblPedidosPorRangoDeFechas.setBounds(0, 0, 1069, 54);
		contentPane.add(lblPedidosPorRangoDeFechas);
		
		btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(this);
		btnBuscar.setIcon(new ImageIcon("img\\iconoBuscar.png"));
		btnBuscar.setFont(new Font("Arial", Font.BOLD, 15));
		btnBuscar.setBounds(705, 55, 130, 45);
		contentPane.add(btnBuscar);
		
		btnMostrarTodo = new JButton("Mostrar Todo");
		btnMostrarTodo.addActionListener(this);
		btnMostrarTodo.setIcon(new ImageIcon("img\\iconoMostrarTodo.png"));
		btnMostrarTodo.setFont(new Font("Arial", Font.BOLD, 15));
		btnMostrarTodo.setBounds(452, 122, 179, 45);
		contentPane.add(btnMostrarTodo);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 178, 691, 372);
		contentPane.add(scrollPane);
		
		tblPedidosRangoFecha = new JTable();
		tblPedidosRangoFecha.addMouseListener(this);
		tblPedidosRangoFecha.addKeyListener(this);
		tblPedidosRangoFecha.setFillsViewportHeight(true);
		scrollPane.setViewportView(tblPedidosRangoFecha);
		
		btnAtender = new JButton("Atender");
		btnAtender.addActionListener(this);
		btnAtender.setIcon(new ImageIcon("img\\iconoAtender.png"));
		btnAtender.setFont(new Font("Arial", Font.BOLD, 15));
		btnAtender.setBounds(711, 505, 155, 45);
		contentPane.add(btnAtender);
		
		btnAnular = new JButton("Anular");
		btnAnular.addActionListener(this);
		btnAnular.setIcon(new ImageIcon("img\\iconoAnular.png"));
		btnAnular.setFont(new Font("Arial", Font.BOLD, 15));
		btnAnular.setBounds(914, 505, 145, 45);
		contentPane.add(btnAnular);
		
		lblFInicio = new JLabel("F. Inicio:");
		lblFInicio.setFont(new Font("Arial", Font.PLAIN, 16));
		lblFInicio.setBounds(247, 68, 65, 20);
		contentPane.add(lblFInicio);
		
		lblFFin = new JLabel("F. Fin:");
		lblFFin.setFont(new Font("Arial", Font.PLAIN, 16));
		lblFFin.setBounds(485, 68, 54, 20);
		contentPane.add(lblFFin);
		
		txtFechaInicio = new JTextField();
		txtFechaInicio.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txtFechaInicio.setColumns(10);
		txtFechaInicio.setBounds(320, 60, 140, 37);
		contentPane.add(txtFechaInicio);
		
		txtFechaFin = new JTextField();
		txtFechaFin.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txtFechaFin.setColumns(10);
		txtFechaFin.setBounds(547, 60, 140, 37);
		contentPane.add(txtFechaFin);
		
		scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(710, 178, 349, 316);
		contentPane.add(scrollPane_1);
		
		txtS = new JTextArea();
		txtS.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txtS.setEditable(false);
		scrollPane_1.setViewportView(txtS);
		
		// Crear tabla
		model.addColumn("Id Pedido");
		model.addColumn("Nombre de cliente");
		model.addColumn("Apellidos de cliente");
		model.addColumn("Nombre de usuario");
		model.addColumn("Apellidos de usuario");
		model.addColumn("Estado");
		tblPedidosRangoFecha.setModel(model);
		listar();
		
	}
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnAnular) {
			actionPerformedBtnAnular(e);
		}
		if (e.getSource() == btnAtender) {
			actionPerformedBtnAtender(e);
		}
		if (e.getSource() == btnMostrarTodo) {
			actionPerformedBtnMostrarTodo(e);
		}
		if (e.getSource() == btnBuscar) {
			actionPerformedBtnBuscar(e);
		}
	}
	protected void actionPerformedBtnBuscar(ActionEvent e) {
			// declarar variables
			Date fechaInicio;
			Date fechaFinal;
			// entrada de datos
			fechaInicio = getFechaInicio();
			fechaFinal = getFechaFinal();
			// validacion
			if(fechaInicio == null || fechaFinal == null) {
				return;
			} else {
				encontrarPedidos();
			}
	}

	private void encontrarPedidos() {
		model.setRowCount(0);
		for(int i = 0; i<arPedido.tamanio(); i++) {
			if(arPedido.obtener(i).getFechaPedido().before(getFechaFinal()) && arPedido.obtener(i).getFechaPedido().after(getFechaInicio())) {
				if(arPedido.obtener(i).getEstado()!=2) {
					Object[] fila = {
							arPedido.obtener(i).getIdPedido(),
							arCliente.buscarCliente(arPedido.obtener(i).getIdCliente()).getNombres(),
							arCliente.buscarCliente(arPedido.obtener(i).getIdCliente()).getApellidoPaterno()+" "+arCliente.buscarCliente(arPedido.obtener(i).getIdCliente()).getApellidoMaterno(),
							arUsuario.buscarUsuario(arPedido.obtener(i).getIdUsuario()).getNombre(),
							arUsuario.buscarUsuario(arPedido.obtener(i).getIdUsuario()).getApellidoPaterno()+" "+arUsuario.buscarUsuario(arPedido.obtener(i).getIdUsuario()).getApellidoMaterno(),
							arPedido.obtener(i).getEstado()
					};
					model.addRow(fila);
				}

			}
		}
	}

	private Date getFechaFinal() {
		Date fechaFinal = null;
		String fechaFinalString = txtFechaFin.getText();
		
		if(fechaFinalString.isEmpty()) {
			Alertas.mensajeAlerta("La fecha final no puede estar vacía");
			return null;
		}
		
	    try {
	    	fechaFinal = dateFormat.parse(fechaFinalString);
	    } catch (ParseException e) {
	        Alertas.mensajeAlerta("Error al ingresar la fecha final. Formato correcto: dd/MM/yyyy");
	    }

	    return fechaFinal;
	}

	private Date getFechaInicio() {
		Date fechaInicio = null;
		String fechaInicioString = txtFechaInicio.getText();
		
		if(fechaInicioString.isEmpty()) {
			Alertas.mensajeError("La fecha incial no puede estar vacía");
			return null;
		}
		
	    try {
	    	fechaInicio = dateFormat.parse(fechaInicioString);
	    } catch (ParseException e) {
	        Alertas.mensajeError("Error al ingresar la fecha inicial. Formato correcto: dd/MM/yyyy");
	    }

	    return fechaInicio;
	}
	protected void actionPerformedBtnMostrarTodo(ActionEvent e) {
		listar();
	}

	private void listar() {
		model.setRowCount(0);
		for(int i = 0; i<arPedido.tamanio(); i++) {
			if(arPedido.obtener(i).getEstado()!=2) {
				Object[] fila = {
						arPedido.obtener(i).getIdPedido(),
						arCliente.buscarCliente(arPedido.obtener(i).getIdCliente()).getNombres(),
						arCliente.buscarCliente(arPedido.obtener(i).getIdCliente()).getApellidoPaterno()+" "+arCliente.buscarCliente(arPedido.obtener(i).getIdCliente()).getApellidoMaterno(),
						arUsuario.buscarUsuario(arPedido.obtener(i).getIdUsuario()).getNombre(),
						arUsuario.buscarUsuario(arPedido.obtener(i).getIdUsuario()).getApellidoPaterno()+" "+arUsuario.buscarUsuario(arPedido.obtener(i).getIdUsuario()).getApellidoMaterno(),
						estadoString(arPedido.obtener(i).getEstado())
				};
				model.addRow(fila);
			}

		};
		
	}
	public void keyPressed(KeyEvent e) {
	}
	public void keyReleased(KeyEvent e) {
		if (e.getSource() == tblPedidosRangoFecha) {
			keyReleasedTblPedidosRangoFecha(e);
		}
	}
	public void keyTyped(KeyEvent e) {
	}
	protected void keyReleasedTblPedidosRangoFecha(KeyEvent e) {
		try {
			mostrarDetallesPedido();
		} catch (Exception e2) {
			
		}
	}
	
	private void mostrarDetallesPedido() {
		// Declarar las variables
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		String idPedido;
		int posFila;
		
		// Obtenemos la fila seleccionada y el idPedido
		posFila = tblPedidosRangoFecha.getSelectedRow();
		idPedido = tblPedidosRangoFecha.getValueAt(posFila, 0).toString();
		
		txtS.setText("");
		imprimir("Id Pedido           : " + idPedido);
		imprimir("Fecha del pedido    : " + dateFormat.format(arPedido.buscarPedido(idPedido).getFechaPedido()));
		imprimir("Id Cliente          : " + arPedido.buscarPedido(idPedido).getIdCliente());
		imprimir("Canciones           : " + listadoCanciones(arPedido.buscarPedido(idPedido).getCanciones()));
		imprimir("Piqueos             : " + listadoPiqueos(arPedido.buscarPedido(idPedido).getPiqueos()));
		imprimir("Bebidas             : " + listadoBebidas(arPedido.buscarPedido(idPedido).getBebidas()));
		imprimir("Estado de pedido    : " + estadoString(arPedido.buscarPedido(idPedido).getEstado()));
	}
	
	private void imprimir(String s) {
	    txtS.append(s + "\n" + "\n");
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
	public void mouseClicked(MouseEvent e) {
	}
	public void mouseEntered(MouseEvent e) {
	}
	public void mouseExited(MouseEvent e) {
	}
	public void mousePressed(MouseEvent e) {
	}
	public void mouseReleased(MouseEvent e) {
		if (e.getSource() == tblPedidosRangoFecha) {
			mouseReleasedTblPedidosRangoFecha(e);
		}
	}
	protected void mouseReleasedTblPedidosRangoFecha(MouseEvent e) {
		try {
			mostrarDetallesPedido();
		} catch (Exception e2) {
			
		}
	}
	protected void actionPerformedBtnAtender(ActionEvent e) {
		try {
			// Declarar las variables
			String idPedido;
			int posFila;
			
			// Obtenemos la fila seleccionada y el idPedido
			posFila = tblPedidosRangoFecha.getSelectedRow();
			idPedido = tblPedidosRangoFecha.getValueAt(posFila, 0).toString();
			
			// Validar
			if(arPedido.buscarPedido(idPedido).getEstado()==1) {
				Alertas.mensajeAlerta("Este pedido ya fue atendido");
				return;
			}

			arPedido.buscarPedido(idPedido).setEstado(1);
			JOptionPane.showMessageDialog(this, "El pedido se atendio correctamente");
			
			// actualizar
			mostrarDetallesPedido();
			listar();
			arPedido.guardarDataPedido();
		} catch (Exception e2) {
			// TODO: handle exception
		}
	}
	protected void actionPerformedBtnAnular(ActionEvent e) {
		try {
			// Declarar las variables
			String idPedido;
			int posFila;
			
			// Obtenemos la fila seleccionada y el idPedido
			posFila = tblPedidosRangoFecha.getSelectedRow();
			idPedido = tblPedidosRangoFecha.getValueAt(posFila, 0).toString();
			
			// Validar
			if(arPedido.buscarPedido(idPedido).getEstado()==1) {
				Alertas.mensajeAlerta("Este pedido ya fue atendido");
				return;
			} else {
				arPedido.buscarPedido(idPedido).setEstado(2);
				JOptionPane.showMessageDialog(this, "El pedido se anulo correctamente");
			}
			
			// Actualizar
			mostrarDetallesPedido();
			listar();
			arPedido.guardarDataPedido();
		} catch (Exception e2) {
			// TODO: handle exception
		}
	}
}
