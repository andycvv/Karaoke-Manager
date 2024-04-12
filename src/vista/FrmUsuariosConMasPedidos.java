package vista;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

import controlador.ArregloPedido;
import controlador.ArregloUsuario;
import entidad.Pedido;
import entidad.Usuario;
import utils.Alertas;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;
import java.awt.SystemColor;
import java.util.ArrayList;
import java.util.Comparator;

import javax.swing.UIManager;
import javax.swing.JComboBox;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FrmUsuariosConMasPedidos extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JTable tblUsuariosMasPedidos;
	private JScrollPane scrollPane;

	// Instanciar tabla
	DefaultTableModel model = new DefaultTableModel();
	
	// Instanciar ArrayLists
	ArregloPedido arPedido = new ArregloPedido();
	ArregloUsuario arUsuario = new ArregloUsuario();
	private JLabel lblBuscarPorId;
	private JTextField txtBuscar;
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
					FrmUsuariosConMasPedidos frame = new FrmUsuariosConMasPedidos();
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
	public FrmUsuariosConMasPedidos() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 916, 622);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.menu);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Usuarios que han atendido m\u00E1s pedidos");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(0, 0, 900, 74);
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 32));
		contentPane.add(lblNewLabel);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 162, 880, 410);
		contentPane.add(scrollPane);
		
		tblUsuariosMasPedidos = new JTable();
		scrollPane.setViewportView(tblUsuariosMasPedidos);
		tblUsuariosMasPedidos.setFillsViewportHeight(true);
		
        // Crear la tabla
        model.addColumn("Id Usuario");
        model.addColumn("Nombre");
        model.addColumn("Apellido");
        model.addColumn("Nro. de pedidos atendidos");
        tblUsuariosMasPedidos.setModel(model);

        TableRowSorter<DefaultTableModel> sorter = new TableRowSorter<>(model);
        tblUsuariosMasPedidos.setRowSorter(sorter);
        
        lblBuscarPorId = new JLabel("Buscar por IdUsuario o Nombre:");
        lblBuscarPorId.setHorizontalAlignment(SwingConstants.LEFT);
        lblBuscarPorId.setFont(new Font("Arial", Font.PLAIN, 16));
        lblBuscarPorId.setBounds(74, 102, 233, 20);
        contentPane.add(lblBuscarPorId);
        
        txtBuscar = new JTextField();
        txtBuscar.setFont(new Font("Tahoma", Font.PLAIN, 13));
        txtBuscar.setColumns(10);
        txtBuscar.setBounds(317, 94, 140, 37);
        contentPane.add(txtBuscar);
        
        btnBuscar = new JButton("Buscar");
        btnBuscar.addActionListener(this);
        btnBuscar.setIcon(new ImageIcon("img\\iconoBuscar.png"));
        btnBuscar.setFont(new Font("Arial", Font.BOLD, 16));
        btnBuscar.setBounds(482, 85, 162, 55);
        contentPane.add(btnBuscar);
        
        btnMostrarTodo = new JButton("Mostrar");
        btnMostrarTodo.addActionListener(this);
        btnMostrarTodo.setIcon(new ImageIcon("img\\iconoMostrarTodo.png"));
        btnMostrarTodo.setFont(new Font("Arial", Font.BOLD, 16));
        btnMostrarTodo.setBounds(654, 85, 162, 55);
        contentPane.add(btnMostrarTodo);

        // Ordenar visualmente la tabla en función de la columna "Nro. de pedidos atendidos"
        sorter.toggleSortOrder(3); // El número 3 indica la columna "Nro. de pedidos atendidos"
        sorter.toggleSortOrder(3); // Esto invierte el orden para que sea decreciente
        
        // Listar los datos
        listar();
	}

    private void listar() {
        model.setRowCount(0);
        ArrayList<Pedido> pedidosAtendidos = new ArrayList<Pedido>();

        for (int i = 0; i < arPedido.tamanio(); i++) {
            if (arPedido.obtener(i).getEstado() == 1)
                pedidosAtendidos.add(arPedido.obtener(i));
        }

        for (int i = 0; i < arUsuario.tamanio(); i++) {
            int contador = 0;
            for (int x = 0; x < pedidosAtendidos.size(); x++) {
                if (arUsuario.obtener(i).getIdUsuario().equals(pedidosAtendidos.get(x).getIdUsuario()))
                    contador++;
            }

            Object[] fila = { arUsuario.obtener(i).getIdUsuario(), arUsuario.obtener(i).getNombre(),
                    arUsuario.obtener(i).getApellidoPaterno(), contador };

            model.addRow(fila);
        }
    }
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnMostrarTodo) {
			actionPerformedBtnMostrarTodo(e);
		}
		if (e.getSource() == btnBuscar) {
			actionPerformedBtnBuscar(e);
		}
	}
	protected void actionPerformedBtnBuscar(ActionEvent e) {
		buscarUsuario();
	}
	
	private void buscarUsuario() {
		try {
			// Declaración de variables
			String idUserNombre;
	
			// Entrada de datos
			idUserNombre = txtBuscar.getText().trim();
	
			// Validación
			if (idUserNombre == null) {
				Alertas.mensajeAlerta("Usuario no encontrado");
				return;
			} else {
				// Validar si el usuario existe mediante el idUsuario
				Usuario bean = arUsuario.buscarUsuario(idUserNombre);
				if (bean != null) {
					
					// Proceso de cálculo
					// Establecer datos en los casilleros
					listarEncontrarIdUsuario(idUserNombre);
	
				} else {
					// Validar si el usuario existe mediante el nombre
					Usuario beanNombre = arUsuario.buscarUsuarioNombre(idUserNombre);
					if(beanNombre != null) {
						// Establecer datos en los casilleros
						listarEncontrarNombre(idUserNombre);
					} else{
						Alertas.mensajeAlerta("Usuario no encontrado");
					}
				}
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	private void listarEncontrarIdUsuario(String idUser) {
        model.setRowCount(0);
        ArrayList<Pedido> pedidosAtendidos = new ArrayList<Pedido>();
        int contador = 0;

        for (int i = 0; i < arPedido.tamanio(); i++) {
            if (arPedido.obtener(i).getEstado() == 1)
                pedidosAtendidos.add(arPedido.obtener(i));
        }
        
		Usuario u = arUsuario.buscarUsuario(idUser);
		for(int i = 0; i<pedidosAtendidos.size(); i++) {
			if(pedidosAtendidos.get(i).getIdUsuario().equals(u.getIdUsuario()))
				contador++;
		}
		
        Object[] fila = { u.getIdUsuario(), u.getNombre(),
                u.getApellidoPaterno(), contador };

        model.addRow(fila);
	}
	
	private void listarEncontrarNombre(String nombre) {
        model.setRowCount(0);
        ArrayList<Pedido> pedidosAtendidos = new ArrayList<Pedido>();
        int contador = 0;

        for (int i = 0; i < arPedido.tamanio(); i++) {
            if (arPedido.obtener(i).getEstado() == 1)
                pedidosAtendidos.add(arPedido.obtener(i));
        }
        
		Usuario u = arUsuario.buscarUsuarioNombre(nombre);
		for(int i = 0; i<pedidosAtendidos.size(); i++) {
			if(pedidosAtendidos.get(i).getIdUsuario().equals(u.getIdUsuario()))
				contador++;
		}
		
        Object[] fila = { u.getIdUsuario(), u.getNombre(),
                u.getApellidoPaterno(), contador };

        model.addRow(fila);
		
	}
	protected void actionPerformedBtnMostrarTodo(ActionEvent e) {
		listar();
	}
}
