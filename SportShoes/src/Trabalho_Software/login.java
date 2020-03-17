package Trabalho_Software;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.border.EmptyBorder;



import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class login extends JFrame {

	private JPanel contentPane;
	private JTextField eUsuario;
	private JLabel lblSen;

	Funcionario var = new Funcionario();
	public JPasswordField eSenha;
	private JTextField eSetor;

	/**
	 * Launch the application.
	 */
	public static void main(String argc[]) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					login frame = new login();
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
	public login() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);

		JLabel lblLo = new JLabel("Login");
		lblLo.setFont(new Font("Arial", Font.PLAIN, 24));
		lblLo.setBounds(179, 50, 88, 30);
		contentPane.add(lblLo);

		eUsuario = new JTextField();
		eUsuario.setBounds(136, 106, 145, 20);
		contentPane.add(eUsuario);
		eUsuario.setColumns(10);

		JLabel lblUsurio = new JLabel("Usu\u00E1rio");
		lblUsurio.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblUsurio.setBounds(77, 109, 68, 14);
		contentPane.add(lblUsurio);

		lblSen = new JLabel("senha");
		lblSen.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblSen.setBounds(87, 143, 46, 14);
		contentPane.add(lblSen);

		JButton btnEntrar = new JButton("Entrar");
		btnEntrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {

					testandoCampos();
				} catch (SQLException e) {
					System.out.println(e);
				}
			}
		});
		btnEntrar.setBounds(165, 200, 89, 23);
		contentPane.add(btnEntrar);

		eSenha = new JPasswordField();
		eSenha.setBounds(136, 137, 145, 20);
		contentPane.add(eSenha);

		JLabel lblSetor = new JLabel("Setor");
		lblSetor.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblSetor.setBounds(97, 168, 46, 14);
		contentPane.add(lblSetor);

		eSetor = new JTextField();
		eSetor.setBounds(136, 168, 32, 20);
		contentPane.add(eSetor);
		eSetor.setColumns(10);
	}

	public void testandoCampos() throws SQLException {

		ArrayList<String> usuarios = new ArrayList<>();
		Conexao con = new Conexao();

		var.setUsuario(eUsuario.getText());
		var.setSenha(eSenha.getText());
		var.setSetor(eSetor.getText());

		// Usuário não poderá deixar o campo nulo
		if (var.getUsuario().equals("")) {
			JOptionPane.showMessageDialog(null, "Digite um nome de usuário", "", 0);
		} else {
			
			//Aqui será listado tudo da lista de gerente
			
			con.setSql("select *from login where usuario='"+var.getUsuario()+"'");
			con.setAcao(con.getConexao().prepareStatement(con.getSql()));
			con.setResultado(con.getAcao().executeQuery());
			while (con.getResultado().next()) {
				usuarios.add(con.getResultado().getString("usuario"));

				
			// Aqui será testado se o usuário digitado existe ou não

			int aux = usuarios.indexOf(var.getUsuario());

			if (aux == -1) {

				JOptionPane.showMessageDialog(null, "O usuário especificado não existe", "", 0);
			} else {
				
				con.setSql("select *from login where usuario='" + var.getUsuario() + "'");
				con.setAcao(con.getConexao().prepareStatement(con.getSql()));
				con.setResultado(con.getAcao().executeQuery());

				while (con.getResultado().next()) {
					
					//Aqui será pegue e testada a senha de acordo com o usuário especificado

					var.setSenhaBanco(con.getResultado().getString("senha"));
					
					if(var.getSenha().equals(var.getSenhaBanco())) {
						Menu menu = new Menu();
						menu.Menu();
						dispose();
					}else {
						JOptionPane.showMessageDialog(null, "Senhas incorreta!", "", 0);
					}

					}
				}
			}
		}
	}
}