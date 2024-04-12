package vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import controlador.ArregloCliente;
import controlador.ArregloPedido;
import entidad.Bebida;
import entidad.Cancion;
import entidad.Cliente;
import entidad.Pedido;
import entidad.Piqueo;
import entidad.Usuario;
import utils.Alertas;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.UIManager;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyListener;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.awt.event.KeyEvent;
import javax.swing.JTextArea;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;

public class FrmPedidosPorCliente extends JFrame implements ActionListener, KeyListener, MouseListener {

	private JPanel contentPane;
	private JLabel lblPedidosPorCliente;
	private JButton btnBuscar;
	private JButton btnMostrarTodo;
	private JTable tblPedidoPorCliente;
	private JScrollPane scrollPane;
	private JButton btnAtender;
	private JButton btnAnular;
	
	// instanciar tabla
	DefaultTableModel model = new DefaultTableModel();
	
	// instanciar el ArrayList
	ArregloPedido arPedido = new ArregloPedido();
	ArregloCliente arCliente = new ArregloCliente();
	private JTextArea txtS;
	private JScrollPane scrollPane_1;

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
					FrmPedidosPorCliente frame = new FrmPedidosPorCliente();
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
	public FrmPedidosPorCliente() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 939, 507);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblPedidosPorCliente = new JLabel("Pedidos Por Cliente");
		lblPedidosPorCliente.setBounds(0, 0, 923, 54);
		lblPedidosPorCliente.setHorizontalAlignment(SwingConstants.CENTER);
		lblPedidosPorCliente.setFont(new Font("Arial", Font.BOLD, 25));
		lblPedidosPorCliente.setBackground(Color.ORANGE);
		contentPane.add(lblPedidosPorCliente);
		
		btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(this);
		btnBuscar.setBounds(481, 56, 130, 45);
		btnBuscar.setFont(new Font("Arial", Font.BOLD, 15));
		btnBuscar.setIcon(new ImageIcon("img\\iconoBuscar.png"));
		contentPane.add(btnBuscar);
		
		btnMostrarTodo = new JButton("Mostrar Todo");
		btnMostrarTodo.addActionListener(this);
		btnMostrarTodo.setBounds(292, 56, 179, 45);
		btnMostrarTodo.setIcon(new ImageIcon("img\\iconoMostrarTodo.png"));
		btnMostrarTodo.setFont(new Font("Arial", Font.BOLD, 15));
		contentPane.add(btnMostrarTodo);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 111, 551, 346);
		contentPane.add(scrollPane);
		
		tblPedidoPorCliente = new JTable();
		tblPedidoPorCliente.addMouseListener(this);
		tblPedidoPorCliente.addKeyListener(this);
		scrollPane.setViewportView(tblPedidoPorCliente);
		tblPedidoPorCliente.setFillsViewportHeight(true);
		
		btnAtender = new JButton("Atender");
		btnAtender.addActionListener(this);
		btnAtender.setIcon(new ImageIcon("img\\iconoAtender.png"));
		btnAtender.setFont(new Font("Arial", Font.BOLD, 15));
		btnAtender.setBounds(571, 412, 155, 45);
		contentPane.add(btnAtender);
		
		btnAnular = new JButton("Anular");
		btnAnular.addActionListener(this);
		btnAnular.setIcon(new ImageIcon("img\\iconoAnular.png"));
		btnAnular.setFont(new Font("Arial", Font.BOLD, 15));
		btnAnular.setBounds(766, 412, 147, 45);
		contentPane.add(btnAnular);
		
		// Crear la tabla
		model.addColumn("Id Cliente");
		model.addColumn("Nombre");
		model.addColumn("A. Paterno");
		model.addColumn("A. Materno");
		model.addColumn("Id Pedido");
		model.addColumn("Estado");
		tblPedidoPorCliente.setModel(model);
		
		scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(571, 112, 342, 289);
		contentPane.add(scrollPane_1);
		
		txtS = new JTextArea();
		txtS.setFont(new Font("Tahoma", Font.PLAIN, 13));
		scrollPane_1.setViewportView(txtS);
		txtS.setEditable(false);
		
		//
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
	
	private void listar() {
		model.setRowCount(0);
		for(int i = 0; i<arPedido.tamanio(); i++) {
			if(arPedido.obtener(i).getEstado()!=2) {
				Object[] fila = {
						arPedido.obtener(i).getIdCliente(),
						arCliente.buscarCliente(arPedido.obtener(i).getIdCliente()).getNombres(),
						arCliente.buscarCliente(arPedido.obtener(i).getIdCliente()).getApellidoPaterno(),
						arCliente.buscarCliente(arPedido.obtener(i).getIdCliente()).getApellidoMaterno(),
						arPedido.obtener(i).getIdPedido(),
						estadoString(arPedido.obtener(i).getEstado())
				};
				model.addRow(fila);
			}
			
		}
		
	}
	
	protected void actionPerformedBtnBuscar(ActionEvent e) {
		buscarPedidoPorCliente();
	}

	private void buscarPedidoPorCliente() {
		// Declaración de variables
		String idCliente;

		// Entrada de datos
		idCliente = JOptionPane.showInputDialog(this, "Ingrese el IdCliente");

		// Validación
		if (idCliente == null) {
			return;
		} else {
			// Validar si el usuario existe mediante el idCliente
			Pedido bean = arPedido.buscarPedidoCliente(idCliente);
			if (bean != null) {
				listarEncontrar(idCliente);
			} else {
				Alertas.mensajeAlerta("Este cliente no ha realizado pedidos");
			}
			
		}
	}

	private void listarEncontrar(String idCliente) {
		model.setRowCount(0);
		for(int i = 0; i<arPedido.tamanio(); i++) {
			if(arPedido.obtener(i).getIdCliente().equals(idCliente)) {

				if(arPedido.obtener(i).getEstado()!=2) {
					Object[] fila = {
							arPedido.obtener(i).getIdCliente(),
							arCliente.buscarCliente(arPedido.obtener(i).getIdCliente()).getNombres(),
							arCliente.buscarCliente(arPedido.obtener(i).getIdCliente()).getApellidoPaterno(),
							arCliente.buscarCliente(arPedido.obtener(i).getIdCliente()).getApellidoMaterno(),
							arPedido.obtener(i).getIdPedido(),
							estadoString(arPedido.obtener(i).getEstado())
					};
					model.addRow(fila);
				}
				
			}
		}
	}
	
	protected void actionPerformedBtnMostrarTodo(ActionEvent e) {
		listar();
	}
	public void keyPressed(KeyEvent e) {
	}
	public void keyReleased(KeyEvent e) {
		if (e.getSource() == tblPedidoPorCliente) {
			keyReleasedTblPedidoPorCliente(e);
		}
	}
	public void keyTyped(KeyEvent e) {
	}
	protected void keyReleasedTblPedidoPorCliente(KeyEvent e) {
		try {
			mostrarDetallesPedido();
		} catch (Exception e2) {
			// TODO: handle exception
		}
	}

	private void mostrarDetallesPedido() {
		// Declarar las variables
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		String idPedido;
		int posFila;
		
		// Obtenemos la fila seleccionada y el idPedido
		posFila = tblPedidoPorCliente.getSelectedRow();
		idPedido = tblPedidoPorCliente.getValueAt(posFila, 4).toString();
		
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
	public void mouseClicked(MouseEvent e) {
	}
	public void mouseEntered(MouseEvent e) {
	}
	public void mouseExited(MouseEvent e) {
	}
	public void mousePressed(MouseEvent e) {
	}
	public void mouseReleased(MouseEvent e) {
		if (e.getSource() == tblPedidoPorCliente) {
			mouseReleasedTblPedidoPorCliente(e);
		}
	}
	protected void mouseReleasedTblPedidoPorCliente(MouseEvent e) {
		try {
			mostrarDetallesPedido();
		} catch (Exception e2) {
			// TODO: handle exception
		}
	}
	protected void actionPerformedBtnAtender(ActionEvent e) {
		try {
			// Declarar las variables
			String idPedido;
			int posFila;
			
			// Obtenemos la fila seleccionada y el idPedido
			posFila = tblPedidoPorCliente.getSelectedRow();
			idPedido = tblPedidoPorCliente.getValueAt(posFila, 4).toString();
			
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
			posFila = tblPedidoPorCliente.getSelectedRow();
			idPedido = tblPedidoPorCliente.getValueAt(posFila, 4).toString();
			
			// Validar
			if(arPedido.buscarPedido(idPedido).getEstado()==1) {
				Alertas.mensajeAlerta("Este pedido ya fue atendido");
				return;
			} else {
				arPedido.buscarPedido(idPedido).setEstado(2);
				JOptionPane.showMessageDialog(this, "El pedido se anulo correctamente");
			}
			
			// actualizar
			mostrarDetallesPedido();
			listar();
			arPedido.guardarDataPedido();
		} catch (Exception e2) {
			// TODO: handle exception
		}
	}
}
