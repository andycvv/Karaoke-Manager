package vista;

import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

import controlador.ArregloCliente;
import controlador.ArregloConsumo;
import entidad.Consumo;
import utils.Alertas;
import utils.Formatear;

import javax.swing.JComboBox;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.RowSorter;
import javax.swing.SortOrder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.Date;
import java.util.List;
import java.text.SimpleDateFormat;
import java.util.Comparator;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import java.awt.SystemColor;
import javax.swing.UIManager;

public class FrmConsumosRegistrados extends JFrame implements ActionListener {
	private Image imagenDeFondo;
	private JPanel contentPane;
	private JLabel lblConsumosRegistrados;
	private JTable tblConsumosRegistrados;
	private JScrollPane scrollPane;

	// Instanciar la tabla
	DefaultTableModel model = new DefaultTableModel();

	// Instanciar los ArrayList
	ArregloConsumo arConsumo = new ArregloConsumo();
	ArregloCliente arCliente = new ArregloCliente();

	// Parsear fechas
	SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
	private JLabel lblBuscarPorIdconsumo;
	private JTextField txtIdConsumo;
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
					FrmConsumosRegistrados frame = new FrmConsumosRegistrados();
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
	public FrmConsumosRegistrados() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 924, 621);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		lblConsumosRegistrados = new JLabel(" Consumos registrados");
		lblConsumosRegistrados.setHorizontalAlignment(SwingConstants.CENTER);
		lblConsumosRegistrados.setFont(new Font("Arial", Font.BOLD, 32));
		lblConsumosRegistrados.setBounds(0, 0, 908, 74);
		contentPane.add(lblConsumosRegistrados);

		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 169, 888, 402);
		contentPane.add(scrollPane);

		tblConsumosRegistrados = new JTable();
		scrollPane.setViewportView(tblConsumosRegistrados);
		tblConsumosRegistrados.setFillsViewportHeight(true);

		// Crear la tabla
		model.addColumn("Id Consumo");
		model.addColumn("Id Cliente");
		model.addColumn("Nombre");
		model.addColumn("Importe Total");
		model.addColumn("Fecha de consumo");
		tblConsumosRegistrados.setModel(model);

        // Configurar el ordenador de filas
        TableRowSorter<DefaultTableModel> sorter = new TableRowSorter<>(model);
        tblConsumosRegistrados.setRowSorter(sorter);
        
        lblBuscarPorIdconsumo = new JLabel("Buscar por IdConsumo:");
        lblBuscarPorIdconsumo.setHorizontalAlignment(SwingConstants.LEFT);
        lblBuscarPorIdconsumo.setFont(new Font("Arial", Font.PLAIN, 16));
        lblBuscarPorIdconsumo.setBounds(91, 102, 171, 20);
        contentPane.add(lblBuscarPorIdconsumo);
        
        txtIdConsumo = new JTextField();
        txtIdConsumo.setFont(new Font("Tahoma", Font.PLAIN, 13));
        txtIdConsumo.setColumns(10);
        txtIdConsumo.setBounds(272, 94, 140, 37);
        contentPane.add(txtIdConsumo);
        
        btnBuscar = new JButton("Buscar");
        btnBuscar.addActionListener(this);
        btnBuscar.setIcon(new ImageIcon("img\\iconoBuscar.png"));
        btnBuscar.setFont(new Font("Arial", Font.BOLD, 16));
        btnBuscar.setBounds(437, 85, 162, 55);
        contentPane.add(btnBuscar);
        
        btnMostrarTodo = new JButton("Mostrar");
        btnMostrarTodo.addActionListener(this);
        btnMostrarTodo.setIcon(new ImageIcon("img\\iconoMostrarTodo.png"));
        btnMostrarTodo.setFont(new Font("Arial", Font.BOLD, 16));
        btnMostrarTodo.setBounds(609, 85, 162, 55);
        contentPane.add(btnMostrarTodo);

        // Establecer el comparador para ordenar en orden descendente respecto a la fecha de consumo
        Comparator<Object> dateComparator = (o1, o2) -> {
            try {
                Date date1 = dateFormat.parse(o1.toString());
                Date date2 = dateFormat.parse(o2.toString());
                return date1.compareTo(date2);
            } catch (Exception e) {
                return 0;
            }
        };

        sorter.setComparator(4, dateComparator); // El número 4 indica la columna "Fecha de consumo"

        // Ordenar visualmente la tabla en función de la columna "Fecha de consumo"
        sorter.setSortKeys(List.of(new RowSorter.SortKey(4, SortOrder.DESCENDING)));

        // Listar los datos
        listar();
	}

	private void listar() {
		model.setRowCount(0);
		for (int i = 0; i < arConsumo.tamanio(); i++) {
			String idConsumo = arConsumo.obtener(i).getCodigoConsumo();
			Object[] fila = { arConsumo.buscarConsumo(idConsumo).getCodigoConsumo(), arConsumo.buscarConsumo(idConsumo).getIdCliente(),
					arCliente.buscarCliente(arConsumo.buscarConsumo(idConsumo).getIdCliente()).getNombres(),
					arConsumo.buscarConsumo(idConsumo).getImporteTotal(),
					dateFormat.format(arConsumo.buscarConsumo(idConsumo).getFechaConsumo()) };
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
		buscarConsumo();
	}

	private void buscarConsumo() {
		try {
			// Declaracion de variables
			String idConsumo;
			// Entrada de datos
			idConsumo = txtIdConsumo.getText().trim();
			// Validacion
			if(idConsumo == null) {
				return;
			} else {
				// Validar si existe el consumo
				Consumo bean = arConsumo.buscarConsumo(idConsumo);
				if(bean != null) {
					listarEncontrar(idConsumo);
				} else {
					Alertas.mensajeAlerta("Este consumo no existe");
				}
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	private void listarEncontrar(String idConsumo) {
		model.setRowCount(0);
		for(int i = 0; i<arConsumo.tamanio(); i++) {
			if(arConsumo.obtener(i).getCodigoConsumo().equals(idConsumo)) {
				Object[] fila = { arConsumo.buscarConsumo(idConsumo).getCodigoConsumo(), arConsumo.buscarConsumo(idConsumo).getIdCliente(),
						arCliente.buscarCliente(arConsumo.buscarConsumo(idConsumo).getIdCliente()).getNombres(),
						arConsumo.buscarConsumo(idConsumo).getImporteTotal(),
						dateFormat.format(arConsumo.buscarConsumo(idConsumo).getFechaConsumo()) };
				model.addRow(fila);
			}
		}
	}
	protected void actionPerformedBtnMostrarTodo(ActionEvent e) {
		listar();
	}
}
