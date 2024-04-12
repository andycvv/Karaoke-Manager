package vista;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controlador.ArregloUsuario;
import entidad.Usuario;
import utils.Alertas;

import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.UIManager;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.JPasswordField;

public class Login extends JFrame implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JLabel lblLoginIcon;
	private JLabel lblIniciarSesion;
	private JTextField txtLogin;
	private JLabel lblLogin;
	private JLabel lblContrasena;
	private JButton btnIngresar;
	private JButton btnSalir;
	private JPasswordField txtPassword;
	// instanciar ArrayList
	ArregloUsuario arUsuario = new ArregloUsuario();

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
					Login frame = new Login();
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
	public Login() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 604, 413);
		contentPane = new JPanel();
		contentPane.setBackground(Color.ORANGE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblLoginIcon = new JLabel("");
		lblLoginIcon.setIcon(new ImageIcon("img\\logoLogin.png"));
		lblLoginIcon.setBounds(3, 0, 257, 374);
		contentPane.add(lblLoginIcon);
		
		lblIniciarSesion = new JLabel("Iniciar Sesi\u00F3n");
		lblIniciarSesion.setFont(new Font("Arial", lblIniciarSesion.getFont().getStyle() | Font.BOLD, 30));
		lblIniciarSesion.setHorizontalAlignment(SwingConstants.CENTER);
		lblIniciarSesion.setBounds(270, 43, 291, 50);
		contentPane.add(lblIniciarSesion);
		
		txtLogin = new JTextField();
		txtLogin.setFont(new Font("Tahoma", Font.PLAIN, 13));	
		txtLogin.setBounds(270, 132, 291, 29);
		contentPane.add(txtLogin);
		txtLogin.setColumns(10);
		
		lblLogin = new JLabel("Login");
		lblLogin.setHorizontalAlignment(SwingConstants.LEFT);
		lblLogin.setFont(new Font("Arial", Font.PLAIN, 16));
		lblLogin.setBounds(270, 104, 90, 20);
		contentPane.add(lblLogin);
		
		lblContrasena = new JLabel("Contrase\u00F1a");
		lblContrasena.setHorizontalAlignment(SwingConstants.LEFT);
		lblContrasena.setFont(new Font("Arial", Font.PLAIN, 16));
		lblContrasena.setBounds(270, 181, 89, 14);
		contentPane.add(lblContrasena);
		
		btnIngresar = new JButton("Ingresar");
		btnIngresar.addActionListener(this);
		btnIngresar.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnIngresar.setIcon(new ImageIcon("img\\iconoIngresar.png"));
		btnIngresar.setBounds(270, 258, 155, 57);
		contentPane.add(btnIngresar);
		
		btnSalir = new JButton("Salir");
		btnSalir.addActionListener(this);
		btnSalir.setIcon(new ImageIcon("img\\iconoSalir.png"));
		btnSalir.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnSalir.setBounds(438, 258, 123, 57);
		contentPane.add(btnSalir);
		
		txtPassword = new JPasswordField();
		txtPassword.setBounds(270, 202, 291, 29);
		contentPane.add(txtPassword);
		setLocationRelativeTo(null);
		
		
			
	}
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnIngresar) {
			actionPerformedBtnNewButton(e);
		}
		if (e.getSource() == btnSalir) {
			actionPerformedBtnNewButton_1(e);
		}
	}
	
	protected void actionPerformedBtnNewButton_1(ActionEvent e) {
		dispose();
	}
	
	protected void actionPerformedBtnNewButton(ActionEvent e) {
		// Declaracion de variables
		String login, password;
		
		// Entrada de datos
		login = getLogin();
		password = getPassword();
		
		// validacion
		if(login == null || password == null) {
			Alertas.mensajeError("Este usuario no existe");
			return;
		} else {
			Usuario u = arUsuario.buscarUsuarioLogin(login);
			// Validamos que coincidan los datos
			
			if(u.getPassword().equals(password)) {
				Principal principal = new Principal(u);
				principal.setVisible(true);
				dispose();
			} else {
				Alertas.mensajeError("Este usuario no existe");
				return;
			}
		}
		
		
	}
	
    private String getPassword() {
    	String contrasena = String.valueOf(txtPassword.getPassword());
		String password = arUsuario.encontrarPassword(contrasena);
		return password;
	}

	private String getLogin() {
		String login = arUsuario.encontrarLogin(txtLogin.getText());
		return login;
	}


}
