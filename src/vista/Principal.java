package vista;

import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;


import entidad.Usuario;

import javax.swing.UIManager;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Principal extends JFrame implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JMenuBar menuBar;
	private JMenu mnMantenimiento;
	private JMenuItem mntmUsuario;
	private JMenuItem mntmCliente;
	private JMenuItem mntmGenero;
	private JMenuItem mntmArtista;
	private JMenuItem mntmCancion;
	private JMenuItem mntmBebida;
	private JMenuItem mntmPiqueo;
	private JMenu mnConsulta;
	private JMenuItem mntmCancionesMasPedidas;
	private JMenuItem mntmPedidosCliente;
	private JMenuItem mntmPedidosRangoFechas;
	private JMenu mnReporte;
	private JMenuItem mntmUsuariosMasPedidos;
	private JMenuItem mntmConsumosRegistrados;
	private JMenu mnArchivo;
	private JMenuItem mntmSalir;
	private JMenu mnRegistro;
	private JMenuItem mntmRegistroDePedido;
	private JMenuItem mntmRegistroDeConsumo;
	private JLabel backgroundLabel;
	
	// Crear el usuario
	private static Usuario usuario;
	private JMenuItem mntmCerrarSesion;

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
					Principal frame = new Principal(usuario);
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
	public Principal(Usuario usuario) {
		this.usuario = usuario;
		
		setTitle("Sistema de Gesti\u00F3n de Karaoke");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1600, 900);
//	    // Obtener el tamaño de la pantalla
	    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	    int screenWidth = (int) screenSize.getWidth();
	    int screenHeight = (int) screenSize.getHeight();

//	    // Maximizar la ventana al tamaño de la pantalla
	    setExtendedState(JFrame.MAXIMIZED_BOTH);
	    setSize(screenWidth, screenHeight);
		
		menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		mnArchivo = new JMenu("Archivo");
		mnArchivo.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		mnArchivo.setIcon(new ImageIcon("img\\iconoArchivo.png"));
		menuBar.add(mnArchivo);
		
		mntmSalir = new JMenuItem("Salir");
		mntmSalir.addActionListener(this);
		mnArchivo.add(mntmSalir);
		
		mntmCerrarSesion = new JMenuItem("Cerrar sesi\u00F3n");
		mntmCerrarSesion.addActionListener(this);
		mnArchivo.add(mntmCerrarSesion);
		
		mnMantenimiento = new JMenu("Mantenimiento");
		mnMantenimiento.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		mnMantenimiento.setIcon(new ImageIcon("img\\iconoMantenimiento.png"));
		menuBar.add(mnMantenimiento);
		
		mntmUsuario = new JMenuItem("Usuario");
		mntmUsuario.addActionListener(this);
		mnMantenimiento.add(mntmUsuario);
		
		mntmCliente = new JMenuItem("Cliente");
		mntmCliente.addActionListener(this);
		mnMantenimiento.add(mntmCliente);
		
		mntmGenero = new JMenuItem("G\u00E9nero");
		mntmGenero.addActionListener(this);
		mnMantenimiento.add(mntmGenero);
		
		mntmArtista = new JMenuItem("Artista");
		mntmArtista.addActionListener(this);
		mnMantenimiento.add(mntmArtista);
		
		mntmCancion = new JMenuItem("Canci\u00F3n");
		mntmCancion.addActionListener(this);
		mnMantenimiento.add(mntmCancion);
		
		mntmBebida = new JMenuItem("Bebida");
		mntmBebida.addActionListener(this);
		mnMantenimiento.add(mntmBebida);
		
		mntmPiqueo = new JMenuItem("Piqueo");
		mntmPiqueo.addActionListener(this);
		mnMantenimiento.add(mntmPiqueo);
		
		mnRegistro = new JMenu("Registro");
		mnRegistro.setIcon(new ImageIcon("img\\iconoRegistro.png"));
		mnRegistro.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		menuBar.add(mnRegistro);
		
		mntmRegistroDePedido = new JMenuItem("Regitro de Pedido");
		mntmRegistroDePedido.setIcon(new ImageIcon("img\\iconoRegistroDePedido.png"));
		mntmRegistroDePedido.addActionListener(this);
		mnRegistro.add(mntmRegistroDePedido);
		
		mntmRegistroDeConsumo = new JMenuItem("Registro de Consumo");
		mntmRegistroDeConsumo.setIcon(new ImageIcon("img\\iconoRegistroConsumo.png"));
		mntmRegistroDeConsumo.addActionListener(this);
		mnRegistro.add(mntmRegistroDeConsumo);
		
		mnConsulta = new JMenu("Consulta");
		mnConsulta.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		mnConsulta.setIcon(new ImageIcon("img\\iconoConsulta.png"));
		menuBar.add(mnConsulta);
		
		mntmCancionesMasPedidas = new JMenuItem("Canciones m\u00E1s pedidas");
		mntmCancionesMasPedidas.addActionListener(this);
		mnConsulta.add(mntmCancionesMasPedidas);
		
		mntmPedidosCliente = new JMenuItem("Pedidos por cliente");
		mntmPedidosCliente.addActionListener(this);
		mnConsulta.add(mntmPedidosCliente);
		
		mntmPedidosRangoFechas = new JMenuItem("Pedidos por rango de fechas");
		mntmPedidosRangoFechas.addActionListener(this);
		mnConsulta.add(mntmPedidosRangoFechas);
		
		mnReporte = new JMenu("Reporte");
		mnReporte.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		mnReporte.setIcon(new ImageIcon("img\\iconoReporte.png"));
		menuBar.add(mnReporte);
		
		mntmUsuariosMasPedidos = new JMenuItem("Usuarios que han atendido m\u00E1s pedidos");
		mntmUsuariosMasPedidos.addActionListener(this);
		mnReporte.add(mntmUsuariosMasPedidos);
		
		mntmConsumosRegistrados = new JMenuItem("Consumos registrados");
		mntmConsumosRegistrados.addActionListener(this);
		mnReporte.add(mntmConsumosRegistrados);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);
		
        backgroundLabel = new JLabel(new ImageIcon("img\\fondo.jpg"));
        backgroundLabel.setBounds(0, 0, getWidth(), getHeight());
        backgroundLabel.setOpaque(false);
        contentPane.add(backgroundLabel);

		
		if(usuario.getTipoEmpleado() != 1) {
            mntmUsuario.setEnabled(false);
            mntmCliente.setEnabled(false);
            mntmGenero.setEnabled(false);
            mntmArtista.setEnabled(false);
            mntmCancion.setEnabled(false);
            mntmBebida.setEnabled(false);
            mntmPiqueo.setEnabled(false);
            mntmRegistroDeConsumo.setEnabled(false);
            mntmUsuariosMasPedidos.setEnabled(false);
            mntmConsumosRegistrados.setEnabled(false);
            if(usuario.getTipoEmpleado() == 2) {
            	mntmRegistroDeConsumo.setEnabled(true);
            }
		}
	}
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == mntmCerrarSesion) {
			actionPerformedMntmCerrarSesion(e);
		}
		if (e.getSource() == mntmRegistroDeConsumo) {
			actionPerformedMntmRegistroDeConsumo(e);
		}
		if (e.getSource() == mntmRegistroDePedido) {
			actionPerformedMntmRegistroDePedido(e);
		}
		if (e.getSource() == mntmConsumosRegistrados) {
			actionPerformedMntmConsumosRegistrados(e);
		}
		if (e.getSource() == mntmUsuariosMasPedidos) {
			actionPerformedMntmUsuariosMasPedidos(e);
		}
		if (e.getSource() == mntmPedidosRangoFechas) {
			actionPerformedMntmPedidosRangoFechas(e);
		}
		if (e.getSource() == mntmPedidosCliente) {
			actionPerformedMntmPedidosCliente(e);
		}
		if (e.getSource() == mntmCancionesMasPedidas) {
			actionPerformedMntmCancionesMasPedidas(e);
		}
		if (e.getSource() == mntmPiqueo) {
			actionPerformedMntmPiqueo(e);
		}
		if (e.getSource() == mntmBebida) {
			actionPerformedMntmBebida(e);
		}
		if (e.getSource() == mntmCancion) {
			actionPerformedMntmCancion(e);
		}
		if (e.getSource() == mntmArtista) {
			actionPerformedMntmArtista(e);
		}
		if (e.getSource() == mntmGenero) {
			actionPerformedMntmGenero(e);
		}
		if (e.getSource() == mntmCliente) {
			actionPerformedMntmCliente(e);
		}
		if (e.getSource() == mntmUsuario) {
			actionPerformedMntmUsuario(e);
		}
		if (e.getSource() == mntmSalir) {
			actionPerformedMntmSalir(e);
		}
	}
	protected void actionPerformedMntmSalir(ActionEvent e) {
		System.exit(0);
	}
	
	protected void actionPerformedMntmUsuario(ActionEvent e) {
		FrmMantenimientoUsuario f = new FrmMantenimientoUsuario();
		f.setLocationRelativeTo(this);
		f.setVisible(true);
	}
	
	protected void actionPerformedMntmCliente(ActionEvent e) {
		FrmMantenimientoCliente f = new FrmMantenimientoCliente(usuario);
		f.setLocationRelativeTo(this);
		f.setVisible(true);
	}
	
	protected void actionPerformedMntmGenero(ActionEvent e) {
		FrmMantenimientoGenero f = new FrmMantenimientoGenero();
		f.setLocationRelativeTo(this);
		f.setVisible(true);
	}
	
	protected void actionPerformedMntmArtista(ActionEvent e) {
		FrmMantenimientoArtista f = new FrmMantenimientoArtista();
		f.setLocationRelativeTo(this);
		f.setVisible(true);
	}
	
	protected void actionPerformedMntmCancion(ActionEvent e) {
		FrmMantenimientoCancion f = new FrmMantenimientoCancion();
		f.setLocationRelativeTo(this);
		f.setVisible(true);
	}
	
	protected void actionPerformedMntmBebida(ActionEvent e) {
		FrmMantenimientoBebida f = new FrmMantenimientoBebida();
		f.setLocationRelativeTo(this);
		f.setVisible(true);
	}
	
	protected void actionPerformedMntmPiqueo(ActionEvent e) {
		FrmMantenimientoPiqueo f = new FrmMantenimientoPiqueo();
		f.setLocationRelativeTo(this);
		f.setVisible(true);
	}
	
	protected void actionPerformedMntmCancionesMasPedidas(ActionEvent e) {
		FrmCancionesMasPedidas f = new FrmCancionesMasPedidas();
		f.setLocationRelativeTo(this);
		f.setVisible(true);
	}
	
	protected void actionPerformedMntmPedidosCliente(ActionEvent e) {
		FrmPedidosPorCliente f = new FrmPedidosPorCliente();
		f.setLocationRelativeTo(this);
		f.setVisible(true);
	}
	
	protected void actionPerformedMntmPedidosRangoFechas(ActionEvent e) {
		FrmPedidosPorRangoDeFechas f = new FrmPedidosPorRangoDeFechas();
		f.setLocationRelativeTo(this);
		f.setVisible(true);
	}
	
	protected void actionPerformedMntmUsuariosMasPedidos(ActionEvent e) {
		FrmUsuariosConMasPedidos f = new FrmUsuariosConMasPedidos();
		f.setLocationRelativeTo(this);
		f.setVisible(true);
	}
	
	protected void actionPerformedMntmConsumosRegistrados(ActionEvent e) {
		FrmConsumosRegistrados f = new FrmConsumosRegistrados();
		f.setLocationRelativeTo(this);
		f.setVisible(true);
	}
	protected void actionPerformedMntmRegistroDePedido(ActionEvent e) {
		FrmRegistroDePedido f = new FrmRegistroDePedido(usuario);
		f.setLocationRelativeTo(this);
		f.setVisible(true);
	}
	protected void actionPerformedMntmRegistroDeConsumo(ActionEvent e) {
		FrmRegistroDeConsumo f = new FrmRegistroDeConsumo();
		f.setLocationRelativeTo(this);
		f.setVisible(true);
	}
	protected void actionPerformedMntmCerrarSesion(ActionEvent e) {
		Login f = new Login();
		f.setLocationRelativeTo(this);
		f.setVisible(true);

		dispose();
	}
}
