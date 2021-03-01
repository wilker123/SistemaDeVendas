package Trabalho_Software;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.AbstractAction;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.KeyStroke;
import javax.swing.border.EmptyBorder;

import Atendente.Conexao;
import Atendente.Menu2;

public class Login extends JFrame {

	private JPanel contentPane;
	private JTextField eUsuario;

	Menu2 log = new Menu2();
	Funcionario var = new Funcionario();
	public JPasswordField eSenha;
	private JTextField eSetor;

	/**
	 * Launch the application.
	 */
	public void Login() {
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
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(0, 0, 1100, 800);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		setLocationRelativeTo(null);
		contentPane.setLayout(null);

		eUsuario = new JTextField();
		eUsuario.setForeground(new Color(128, 128, 128));
		eUsuario.setFont(new Font("Lato", Font.BOLD, 15));
		eUsuario.setBounds(454, 374, 284, 33);
		contentPane.add(eUsuario);
		eUsuario.setColumns(10);

		JButton btnEntrar = new JButton("Entrar");
		btnEntrar.setBackground(new Color(244, 144, 139));
		btnEntrar.setForeground(Color.WHITE);
		btnEntrar.setFont(new Font("Cheap Potatoes Black Thin", Font.PLAIN, 13));
		btnEntrar.setBounds(614, 512, 124, 33);
		contentPane.add(btnEntrar);
		getRootPane().getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(
			    KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0), "Logar"
			);     

		getRootPane().getActionMap().put("Logar", new AbstractAction() {
		    public void actionPerformed(ActionEvent e) {
		    	try {
					testandoCampos();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
		    }
		});

		eSenha = new JPasswordField();
		eSenha.setForeground(new Color(128, 128, 128));
		eSenha.setFont(new Font("Lato", Font.BOLD, 15));
		eSenha.setBounds(454, 442, 284, 33);
		contentPane.add(eSenha);

		eSetor = new JTextField();
		eSetor.setForeground(new Color(128, 128, 128));
		eSetor.setFont(new Font("Lato", Font.BOLD, 15));
		eSetor.setBounds(453, 512, 149, 33);
		contentPane.add(eSetor);
		eSetor.setColumns(10);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon("C:\\Users\\Thiago\\workspace\\bird_shoes\\src\\Trabalho_Software\\Imagens\\login.png"));
		label.setBounds(0, 0, 1082, 753);
		contentPane.add(label);
	}

	public void testandoCampos() throws SQLException {

		ArrayList<String> usuarios = new ArrayList<>();
		Conexao con = new Conexao();
		String comportamento = "Entrada";
		int idLogin = 0;
		int idAcesso = 0;
		String idUserLogin = "";
		String userLogin = "";
		String setorLogin = "";
		
		
		
		var.setUsuario(eUsuario.getText());
		var.setSenha(eSenha.getText());
		var.setSetor(eSetor.getText());
	

		// Usuário não poderá deixar o campo nulo
		if (var.getUsuario().equals("")) {
			JOptionPane.showMessageDialog(null, "Digite um nome de usuário", "", 0);
		}else if(var.getSenha().equals("")) {
			JOptionPane.showMessageDialog(null,"Digite a senha do Usuário", "", 0);
		}else if(var.getSetor().equals("")) {
			JOptionPane.showMessageDialog(null,"Digite o setor do usuário","", 0);
		}
		else {
			
			//Aqui será listado tudo da lista de gerente
			
			con.setSql("select *from login where usuario='"+var.getUsuario()+"'");
			con.setAcao(con.getConexao().prepareStatement(con.getSql()));
			con.setResultado(con.getAcao().executeQuery());
			while (con.getResultado().next()) {
				usuarios.add(con.getResultado().getString("usuario"));
				var.setSenhaBanco(con.getResultado().getString("senha"));
			// Aqui será testado se o usuário digitado existe ou não

			int aux = usuarios.indexOf(var.getUsuario());

			if (aux == -1) {

				JOptionPane.showMessageDialog(null, "O usuário especificado não existe", "", 0);
				
			}
			
			else {
				
			
				con.setSql("insert into AcessoLogin(usuario,tipoComportamento) values('"+var.getUsuario()+"','"+comportamento+"')");
				con.setAcao(con.getConexao().prepareStatement(con.getSql()));
				con.getAcao().executeUpdate();
				
				con.setSql("select *from login where usuario ='"+var.getUsuario()+"'");
				con.setAcao(con.getConexao().prepareStatement(con.getSql()));
				con.setResultado(con.getAcao().executeQuery());
				while(con.getResultado().next()) {
					idLogin = Integer.valueOf(con.getResultado().getString("id"));
					idUserLogin = con.getResultado().getString("id");
				}
				con.setSql("select *from acessologin where usuario = '"+var.getUsuario()+"' ");
				con.setAcao(con.getConexao().prepareStatement(con.getSql()));
				con.setResultado(con.getAcao().executeQuery());
				while(con.getResultado().next()) {
					idAcesso = Integer.valueOf(con.getResultado().getString("id"));	
				}
				con.setSql("update acessologin set idFuncionario = '"+idLogin+"' where id = '"+idAcesso+"'");
				con.setAcao(con.getConexao().prepareStatement(con.getSql()));
				con.getAcao().executeUpdate();
				
				con.setSql("select *from login where usuario ='"+var.getUsuario()+"'");
				con.setAcao(con.getConexao().prepareStatement(con.getSql()));
				con.setResultado(con.getAcao().executeQuery());
				
				while(con.getResultado().next()) {
					
					
					var.setSenhaBanco(con.getResultado().getString("senha"));
					
						if(var.getSenha().equals(var.getSenhaBanco())) {
							log.setUserLogin(eUsuario.getText());
							log.setSetorLogin(eSetor.getText());
							log.setIdLoginUser(idUserLogin);
					
							Menu menu = new Menu();
							menu.menu();
							dispose();
						}else {
							JOptionPane.showMessageDialog(null,"Senha não confere");
						}
						
					}
				
				}
			}
		} 
	}
}