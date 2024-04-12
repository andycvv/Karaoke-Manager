package vista;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
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
import controlador.ArregloCliente;
import controlador.ArregloConsumo;
import controlador.ArregloDetalleConsumo;
import controlador.ArregloPedido;
import controlador.ArregloPiqueo;
import controlador.ArregloUsuario;
import entidad.Bebida;
import entidad.Cancion;
import entidad.Cliente;
import entidad.Consumo;
import entidad.DetalleConsumo;
import entidad.Pedido;
import entidad.Piqueo;
import entidad.Usuario;
import utils.Alertas;

import javax.swing.JComboBox;
import javax.swing.UIManager;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;

public class FrmRegistroDeConsumo extends JFrame implements ActionListener, MouseListener {

	private JPanel contentPane;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JTable tblRegistroConsumo;
	private JScrollPane scrollPane;
	private JLabel lblBuscarUsuarioO;
	private JComboBox<String> cboClientesUsuarios;
	private JButton btnRegistrar;
	private JLabel lblCodigoDeConsumo;
	private JTextField txtIdConsumo;
	
	// Instanciar la tabla
	DefaultTableModel model = new DefaultTableModel();
	
	// Instanciar ArrayList
	ArregloCliente arCliente = new ArregloCliente();
	ArregloUsuario arUsuario = new ArregloUsuario();
	ArregloPedido arPedido = new ArregloPedido();
	ArregloConsumo arConsumo = new ArregloConsumo();
	ArregloPiqueo arPiqueo = new ArregloPiqueo();
	ArregloBebida arBebida = new ArregloBebida();
	ArregloDetalleConsumo arDetalleConsumo = new ArregloDetalleConsumo();

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
					FrmRegistroDeConsumo frame = new FrmRegistroDeConsumo();
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
	public FrmRegistroDeConsumo() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 1010, 594);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblRegistrodeconsumo = new JLabel("Registro de consumo");
		lblRegistrodeconsumo.setHorizontalAlignment(SwingConstants.CENTER);
		lblRegistrodeconsumo.setFont(new Font("Arial", Font.BOLD, 32));
		lblRegistrodeconsumo.setForeground(Color.BLACK);
		lblRegistrodeconsumo.setBackground(Color.BLACK);
		lblRegistrodeconsumo.setBounds(0, 0, 994, 74);
		contentPane.add(lblRegistrodeconsumo);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(24, 151, 944, 376);
		contentPane.add(scrollPane);
		
		tblRegistroConsumo = new JTable();
		tblRegistroConsumo.addMouseListener(this);
		scrollPane.setViewportView(tblRegistroConsumo);
		tblRegistroConsumo.setFillsViewportHeight(true);
		
		lblBuscarUsuarioO = new JLabel("Buscar usuario o cliente:");
		lblBuscarUsuarioO.setHorizontalAlignment(SwingConstants.LEFT);
		lblBuscarUsuarioO.setFont(new Font("Arial", Font.PLAIN, 16));
		lblBuscarUsuarioO.setBounds(24, 100, 184, 20);
		contentPane.add(lblBuscarUsuarioO);
		
		cboClientesUsuarios = new JComboBox();
		cboClientesUsuarios.addActionListener(this);
		cboClientesUsuarios.setFont(new Font("Tahoma", Font.PLAIN, 13));
		cboClientesUsuarios.setBounds(218, 92, 140, 37);
		contentPane.add(cboClientesUsuarios);
		
		btnRegistrar = new JButton("Registrar");
		btnRegistrar.addActionListener(this);
		btnRegistrar.setIcon(new ImageIcon("img\\iconRegister.png"));
		btnRegistrar.setFont(new Font("Arial", Font.BOLD, 16));
		btnRegistrar.setBounds(806, 85, 162, 55);
		contentPane.add(btnRegistrar);
		
		// Crear la tabla
		model.addColumn("Id Pedido");
		model.addColumn("Nombre de cliente");
		model.addColumn("Id Cliente");
		model.addColumn("Canciones");
		model.addColumn("Bebidas");
		model.addColumn("Piqueos");
		tblRegistroConsumo.setModel(model);
		
		lblCodigoDeConsumo = new JLabel("C\u00F3digo de Consumo:");
		lblCodigoDeConsumo.setFont(new Font("Arial", Font.PLAIN, 16));
		lblCodigoDeConsumo.setBounds(489, 102, 157, 20);
		contentPane.add(lblCodigoDeConsumo);
		
		txtIdConsumo = new JTextField();
		txtIdConsumo.setText("<dynamic>");
		txtIdConsumo.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txtIdConsumo.setEnabled(false);
		txtIdConsumo.setColumns(10);
		txtIdConsumo.setBounds(656, 95, 140, 37);
		contentPane.add(txtIdConsumo);
		
        // Llamar a los métodos para cargar las opciones en los JComboBox
        cargarClientesUsuarios();
        
        //
        mostrarCodigoConsumo();
	}
	
    private void mostrarCodigoConsumo() {
    	txtIdConsumo.setText(arConsumo.generarConsumo());
	}

	private void cargarClientesUsuarios() {
        // Crear las listas que van a contener los clientes y usuarios
        ArrayList<Cliente> clientes = new ArrayList<Cliente>();
        ArrayList<Usuario> usuarios = new ArrayList<Usuario>();

        // Limpiar el JComboBox
           cboClientesUsuarios.removeAllItems();
           
        // Agregar la opcion Seleccionar al combobox
           cboClientesUsuarios.addItem("Seleccionar");
           
        // bucle para recorrer el ArregloCliente
        for (int i = 0; i<arCliente.tamanio(); i++) {
        	// Agregamos cada cliente a la lista
            clientes.add(arCliente.obtener(i));
            
            // Agregamos los ids de los clientes al combobox
            cboClientesUsuarios.addItem(arCliente.obtener(i).getIdCliente());
        }
        
        // bucle para recorrer el ArregloUsuario
        for (int i = 0; i<arUsuario.tamanio(); i++) {
        	// Agregamos cada cliente a la lista
        	usuarios.add(arUsuario.obtener(i));
            
            // Agregamos los ids de los clientes al combobox
            cboClientesUsuarios.addItem(arUsuario.obtener(i).getIdUsuario());
        }
    }
    
	private void listar() {
	    model.setRowCount(0);
	    String filtro = cboClientesUsuarios.getSelectedItem().toString();
	    if (filtro.matches("^USU\\d{3}$")) {
	        for (int i = 0; i < arPedido.tamanio(); i++) {
	            if (arPedido.obtener(i).getIdUsuario().equals(filtro) && arPedido.obtener(i).getEstado() == 1) {
	                String idPedido = arPedido.obtener(i).getIdPedido();
	                if (!arConsumo.existeConsumoParaPedido(idPedido)) {
	                    Object[] fila = {
	                            idPedido,
	                            arCliente.buscarCliente(arPedido.obtener(i).getIdCliente()).getNombres(),
	                            arCliente.buscarCliente(arPedido.obtener(i).getIdCliente()).getIdCliente(),
	                            listaCanciones(arPedido.obtener(i).getCanciones()),
	                            listaBebidas(arPedido.obtener(i).getBebidas()),
	                            listaPiqueos(arPedido.obtener(i).getPiqueos())

	                    };
	                    model.addRow(fila);
	                }
	            }
	        }
	    } else {
	        for (int i = 0; i < arPedido.tamanio(); i++) {
	            if (arPedido.obtener(i).getIdCliente().equals(filtro) && arPedido.obtener(i).getEstado() == 1) {
	                String idPedido = arPedido.obtener(i).getIdPedido();
	                if (!arConsumo.existeConsumoParaPedido(idPedido)) {
	                    Object[] fila = {
	                            idPedido,
	                            arCliente.buscarCliente(arPedido.obtener(i).getIdCliente()).getNombres(),
	                            arCliente.buscarCliente(arPedido.obtener(i).getIdCliente()).getIdCliente(),
	                            listaCanciones(arPedido.obtener(i).getCanciones()),
	                            listaBebidas(arPedido.obtener(i).getBebidas()),
	                            listaPiqueos(arPedido.obtener(i).getPiqueos())

	                    };
	                    model.addRow(fila);
	                }
	            }
	        }
	    }
	}

    
	
	// Convertir ArrayList en Stings
	private String listaCanciones(ArrayList<Cancion> canciones){
		String linea = "";
		for(int i = 0; i<canciones.size(); i++) {
			linea += canciones.get(i).getIdCancion()+". ";
		}
		return linea;
	}
	
	private String listaBebidas(ArrayList<Bebida> bebidas){
		String linea = "";
		for(int i = 0; i<bebidas.size(); i++) {
			linea += bebidas.get(i).getIdBebida()+". ";
		}
		return linea;
	}
	
	private String listaPiqueos(ArrayList<Piqueo> piqueos){
		String linea = "";
		for(int i = 0; i<piqueos.size(); i++) {
			linea += piqueos.get(i).getIdPiqueo()+". ";
		}
		return linea;
	}
    
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == cboClientesUsuarios) {
			actionPerformedCboClientesUsuarios(e);
		}
		if (e.getSource() == btnRegistrar) {
			actionPerformedBtnRegistrar(e);
		}
	}
	
	// Hallar la cantidad
	private int cantidadTotal(String idPedido) {
		int total = 0;
		Pedido p = arPedido.buscarPedido(idPedido);
		for(int i = 0; i < p.getPiqueos().size(); i++) {
			total++;
		}
		for(int i = 0; i < p.getBebidas().size(); i++) {
			total++;
		}
		return total;
	}
	protected void actionPerformedBtnRegistrar(ActionEvent e) {
		try {
			// obtener la fila
			int posFila = tblRegistroConsumo.getSelectedRow();
			
			// obtener idPedido
			String idPedido = tblRegistroConsumo.getValueAt(posFila, 0).toString();
			
			// Declarar Variables
			String codigoConsumo, idCliente;
			Date fechaConsumo;
			double totalBebidas, totalPiqueos, importeTotal;
			
			// Entrada de datos
			codigoConsumo = txtIdConsumo.getText();
			idCliente = tblRegistroConsumo.getValueAt(posFila, 2).toString();
			idPedido = tblRegistroConsumo.getValueAt(posFila, 0).toString();
			fechaConsumo = new Date();
			totalBebidas = getTotalBebidas(idPedido);
			totalPiqueos = getTotalPiqueos(idPedido);
			importeTotal = totalBebidas + totalPiqueos;
			
			// Validacion
			if(codigoConsumo==null || idCliente==null || fechaConsumo==null || totalBebidas== 0.0 || totalPiqueos==0.0|| importeTotal==0.0) {
				return;
			} else {
				// Verificar que no exista el Consumo
				Consumo bean = arConsumo.buscarConsumo(codigoConsumo);
				
				if(bean == null) {
					// Creamos el consumo
					Consumo c = new Consumo(codigoConsumo, idCliente, idPedido, fechaConsumo, importeTotal);
					// Creamos el detalleconsumo
					DetalleConsumo dc = new DetalleConsumo(codigoConsumo, listaBebidas(arPedido.buscarPedido(idPedido).getBebidas())+listaPiqueos(arPedido.buscarPedido(idPedido).getPiqueos()), cantidadTotal(idPedido), importeTotal);
					// Los agregamos a los ArrayLists
					arConsumo.adicionar(c);
					arDetalleConsumo.adicionar(dc);
					// actualizar
					listar();
					// Guardar la data
					arConsumo.guardarDataConsumo();
					arDetalleConsumo.guardarDataDetalleConsumo();
					// Mensaje
					JOptionPane.showMessageDialog(this, "El consumo se registró correctamente.");
				} else {
					JOptionPane.showMessageDialog(this, "Este consumo ya fue registrado.");
				}
			}
			txtIdConsumo.setText(arConsumo.generarConsumo());
		} catch (Exception e2) {
			// TODO: handle exception
		}
		
	}
	private double getTotalPiqueos(String idPedido) {
		double total = 0.0;
		for(int i = 0; i<arPedido.buscarPedido(idPedido).getPiqueos().size(); i++) {
			total += arPedido.buscarPedido(idPedido).getPiqueos().get(i).getPrecio();
		}
		return total;
	}

	private double getTotalBebidas(String idPedido) {
		double total = 0.0;
		for(int i = 0; i<arPedido.buscarPedido(idPedido).getBebidas().size(); i++) {
			total += arPedido.buscarPedido(idPedido).getBebidas().get(i).getPrecio();
		}
		return total;
	}

	protected void actionPerformedCboClientesUsuarios(ActionEvent e) {
		listar();
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
		if (e.getSource() == tblRegistroConsumo) {
			mouseReleasedTblRegistroConsumo(e);
		}
	}
	protected void mouseReleasedTblRegistroConsumo(MouseEvent e) {
	}
}
