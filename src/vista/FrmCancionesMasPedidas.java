package vista;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
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
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

import javax.swing.RowFilter;
import controlador.ArregloArtista;
import controlador.ArregloCancion;
import controlador.ArregloPedido;
import entidad.Cancion;

import javax.swing.UIManager;
import javax.swing.ImageIcon;

public class FrmCancionesMasPedidas extends JFrame {

	private JPanel contentPane;
	private JLabel lblNewLabel;
	private JLabel lblNombre;
	private JTextField txtNombre;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JTable tblCancionesMasPedidas;
	private JScrollPane scrollPane;
	
	// Instanciar la tabla
	DefaultTableModel model = new DefaultTableModel();
	
	// Instancias el ArrayList
	ArregloCancion arCancion = new ArregloCancion();
	ArregloArtista arArtista = new ArregloArtista();
	ArregloPedido arPedido = new ArregloPedido();
	
	// formatear la fecha
	SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
	
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
					FrmCancionesMasPedidas frame = new FrmCancionesMasPedidas();
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
	public FrmCancionesMasPedidas() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 855, 614);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblNewLabel = new JLabel("Canciones m\u00E1s pedidas del d\u00EDa");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 32));
		lblNewLabel.setForeground(Color.BLACK);
		lblNewLabel.setBackground(Color.DARK_GRAY);
		lblNewLabel.setBounds(0, 0, 839, 74);
		contentPane.add(lblNewLabel);
		
		lblNombre = new JLabel("Nombre:");
		lblNombre.setFont(new Font("Arial", Font.PLAIN, 16));
		lblNombre.setBounds(277, 104, 73, 20);
		contentPane.add(lblNombre);
		
		txtNombre = new JTextField();
		txtNombre.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txtNombre.setBounds(360, 96, 195, 37);
		contentPane.add(txtNombre);
		txtNombre.setColumns(10);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(32, 173, 774, 370);
		contentPane.add(scrollPane);
		
		tblCancionesMasPedidas = new JTable();
		scrollPane.setViewportView(tblCancionesMasPedidas);
		tblCancionesMasPedidas.setFillsViewportHeight(true);
		
		// Crear la tabla
		model.addColumn("Código");
		model.addColumn("Canción");
		model.addColumn("Artista");
		model.addColumn("Género");
		model.addColumn("Nro. Reproducciones totales");
		tblCancionesMasPedidas.setModel(model);
		
		//
		listar();
		
		//
		txtNombre.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                filtrarTabla();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                filtrarTabla();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                filtrarTabla();
            }
        });
	}
	
	private void filtrarTabla() {
		try {
			TableRowSorter<DefaultTableModel> sorter = new TableRowSorter<>(model);
	        tblCancionesMasPedidas.setRowSorter(sorter);
	
	        String text = txtNombre.getText();
	        if (text.trim().length() == 0) {
	            sorter.setRowFilter(null);
	        } else {
	            sorter.setRowFilter(RowFilter.regexFilter("(?i)" + text, 1)); // Filtrar por la columna "Canción"
	        }
		} catch (Exception e) {
			// TODO: handle exception
		}
   
    }
	
//	private void listar() {
//		ArrayList<Cancion> canciones = new ArrayList<Cancion>();
//		model.setRowCount(0);
//		
//		for(int i = 0; i<arPedido.tamanio(); i++) {
//			if(dateFormat.format(arPedido.obtener(i).getFechaPedido()).equals(dateFormat.format(new Date()))) {
//				for(int x = 0; x<arPedido.obtener(i).getCanciones().size(); x++) {
//					System.out.println("hola");
//					for(int y = 0; y<canciones.size(); y++) {
//						System.out.println("hola");
//						if(!canciones.get(y).equals(arPedido.obtener(i).getCanciones().get(x))) {
//							canciones.add(arPedido.obtener(i).getCanciones().get(x));
//						}
//					}
//				}
//			}
//		}
//		System.out.println(canciones);
//
//	}
	
	private void listar() {
	    ArrayList<Cancion> canciones = new ArrayList<Cancion>();
	    model.setRowCount(0);

	    for (int i = 0; i < arPedido.tamanio(); i++) {
	        if (dateFormat.format(arPedido.obtener(i).getFechaPedido()).equals(dateFormat.format(new Date()))) {
	            for (int x = 0; x < arPedido.obtener(i).getCanciones().size(); x++) {
	                boolean cancionYaAgregada = false;
	                for (int y = 0; y < canciones.size(); y++) {
	                    if ((canciones.get(y).getIdCancion()).equals(arPedido.obtener(i).getCanciones().get(x).getIdCancion())) {
	                        cancionYaAgregada = true;
	                        break; // Salir del bucle interno si ya se encontró la canción
	                    }
	                }
	                if (!cancionYaAgregada) {
	                    canciones.add(arPedido.obtener(i).getCanciones().get(x));
	                }
	            }
	        }
	    }
	    
	    for(int i = 0; i<canciones.size(); i++) {
	    	Object[] fila = {
	    		canciones.get(i).getIdCancion(),
	    		canciones.get(i).getNombre(),
	    		canciones.get(i).getIdArtista(),
	    		arArtista.buscarArtista(canciones.get(i).getIdArtista()).getIdGenero(),
	    		canciones.get(i).getNumReprod()
	    	};
	    	model.addRow(fila);
	    }
	}
	
	
}

