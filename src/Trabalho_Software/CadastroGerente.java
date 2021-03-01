package Trabalho_Software;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Atendente.Conexao;
import Relatorios.GerarFuncionarioRelatorio;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.AbstractAction;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.KeyStroke;
import javax.swing.JButton;
import javax.swing.JComponent;

import java.awt.Font;
import java.awt.HeadlessException;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class CadastroGerente extends JFrame {

	private JPanel contentPane;
	private JTextField eNome;
	private JTextField eEmail;
	private JTextField eCpf;
	private JTextField eUsuario;
	private JTextField eSenha;
	private JTextField eSetor;
	
	Funcionario var = new Funcionario();
	private JLabel cpfVazio;
	private JLabel senhaVazio;
	private JLabel emailVazio;
	private JLabel usuarioVazio;
	private JLabel setorVazio;
	private JLabel nomeVazio;
	private JButton btnVoltarAoMenu;



	/**
	 * Launch the application.
	 */
	public void cadastro() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CadastroGerente frame = new CadastroGerente();
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
	public CadastroGerente() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1100, 800);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);
		
		btnVoltarAoMenu = new JButton("Voltar ao menu");
		btnVoltarAoMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Menu m = new Menu();
				m.menu();
				dispose();
			}
		});
		btnVoltarAoMenu.setBackground(Color.PINK);
		btnVoltarAoMenu.setBounds(876, 53, 138, 23);
		contentPane.add(btnVoltarAoMenu);
		
		setorVazio = new JLabel("");
		setorVazio.setForeground(Color.RED);
		setorVazio.setBounds(647, 430, 298, 14);
		contentPane.add(setorVazio);
		
		usuarioVazio = new JLabel("");
		usuarioVazio.setForeground(Color.RED);
		usuarioVazio.setBounds(663, 369, 282, 14);
		contentPane.add(usuarioVazio);
		
		emailVazio = new JLabel("");
		emailVazio.setForeground(Color.RED);
		emailVazio.setBounds(637, 307, 308, 14);
		contentPane.add(emailVazio);
		
		senhaVazio = new JLabel("");
		senhaVazio.setForeground(Color.RED);
		senhaVazio.setBounds(253, 427, 295, 14);
		contentPane.add(senhaVazio);
		
		cpfVazio = new JLabel("");
		cpfVazio.setForeground(Color.RED);
		cpfVazio.setBounds(225, 369, 323, 14);
		contentPane.add(cpfVazio);
		
		nomeVazio = new JLabel("");
		nomeVazio.setForeground(Color.RED);
		nomeVazio.setBounds(239, 307, 309, 14);
		contentPane.add(nomeVazio);
		
		eNome = new JTextField();
		eNome.setForeground(Color.DARK_GRAY);
		eNome.setFont(new Font("Lato", Font.PLAIN, 15));
		eNome.setBounds(239, 279, 309, 28);
		contentPane.add(eNome);
		eNome.setColumns(10);
		
		eEmail = new JTextField();
		eEmail.setForeground(Color.DARK_GRAY);
		eEmail.setFont(new Font("Lato", Font.PLAIN, 15));
		eEmail.setColumns(10);
		eEmail.setBounds(636, 279, 309, 28);
		contentPane.add(eEmail);
		
		eCpf = new JTextField();
		eCpf.setForeground(Color.DARK_GRAY);
		eCpf.setFont(new Font("Lato", Font.PLAIN, 15));
		eCpf.setColumns(10);
		eCpf.setBounds(225, 340, 323, 28);
		contentPane.add(eCpf);
		
		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					switch(JOptionPane.showConfirmDialog(null, "Deseja realmente cadastrar o gerente?", "Cadastrar gerente?", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE)){
					case 0:
							
						cadastroGere();			
						
					break;
					case 1:
						JOptionPane.showMessageDialog(null, "Nenhum gerente foi cadastrado", "Nenhum gerente cadastrado", JOptionPane.INFORMATION_MESSAGE);
					break;
}

				} catch (HeadlessException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

				
			}
		});
		getRootPane().getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(
			    KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0), "Cadastrar"
			);     

		getRootPane().getActionMap().put("Cadastrar", new AbstractAction() {
		    public void actionPerformed(ActionEvent e) {
		    	try {
					switch(JOptionPane.showConfirmDialog(null, "Deseja realmente cadastrar o gerente?", "Cadastrar gerente?", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE)){
					case 0:
							
						cadastroGere();			
						
					break;
					case 1:
						JOptionPane.showMessageDialog(null, "Nenhum gerente foi cadastrado", "Nenhum gerente cadastrado", JOptionPane.INFORMATION_MESSAGE);
					break;
}

				} catch (HeadlessException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
		    }
		});
		
		btnCadastrar.setBackground(new Color(247, 144, 139));
		btnCadastrar.setForeground(Color.WHITE);
		btnCadastrar.setFont(new Font("Cheap Potatoes", Font.PLAIN, 13));
		btnCadastrar.setBounds(460, 486, 151, 38);
		contentPane.add(btnCadastrar);
		
		eUsuario = new JTextField();
		eUsuario.setForeground(Color.DARK_GRAY);
		eUsuario.setFont(new Font("Lato", Font.PLAIN, 15));
		eUsuario.setColumns(10);
		eUsuario.setBounds(663, 340, 282, 28);
		contentPane.add(eUsuario);
		
		eSenha = new JTextField();
		eSenha.setForeground(Color.DARK_GRAY);
		eSenha.setFont(new Font("Lato", Font.PLAIN, 15));
		eSenha.setColumns(10);
		eSenha.setBounds(249, 397, 299, 28);
		contentPane.add(eSenha);
		
		eSetor = new JTextField();
		eSetor.setForeground(Color.DARK_GRAY);
		eSetor.setFont(new Font("Lato", Font.PLAIN, 15));
		eSetor.setColumns(10);
		eSetor.setBounds(643, 400, 302, 28);
		contentPane.add(eSetor);
		
		JLabel lblNome = new JLabel("nome");
		lblNome.setForeground(Color.RED);
		lblNome.setIcon(new ImageIcon("C:\\Users\\Thiago\\workspace\\bird_shoes\\src\\Trabalho_Software\\Imagens\\cadastrogerente.png"));
		lblNome.setBounds(0, 0, 1082, 753);
		contentPane.add(lblNome);
	}
	
	public void cadastroGere() throws SQLException {
		
		Conexao con = new Conexao();
		var.setNome(eNome.getText());
		var.setEmail(eEmail.getText());
		var.setCpf(eCpf.getText());
		var.setSenha(eSenha.getText());
		var.setSetor(eSetor.getText());
		var.setUsuario(eUsuario.getText());

		if(var.getNome().equals("")) {
			nomeVazio.setText("Digite seu nome");
		}else {
			nomeVazio.setText("");
			if(var.getEmail().equals("")) {
				emailVazio.setText("Digite o email do usuário");
			}else {
				emailVazio.setText("");
				if(var.getCpf().equals("")) {
					cpfVazio.setText("Digite o cpf do usuário");
				}else {
					cpfVazio.setText("");
					if(var.getEmail().equals("")) {
						usuarioVazio.setText("Digite um nome de usuário");
					}else {
						usuarioVazio.setText("");
						if(var.getSenha().equals("")) {
							senhaVazio.setText("Digite a senha do usuário");
						}else {
							senhaVazio.setText("");
							if(var.getSetor().equals("")) {
								setorVazio.setText("Digite o setor do usuário");
							}else {
								setorVazio.setText("");
		
		try {
			int idFuncionario = 0;
			int idLogin = 0;
		
		var.setNome(eNome.getText());
		var.setEmail(eEmail.getText());
		var.setCpf(eCpf.getText());
		var.setSenha(eSenha.getText());
		var.setSetor(eSetor.getText());
		var.setUsuario(eUsuario.getText());
		
		con.setSql("INSERT INTO gerente(nome,email,cpf) VALUES('"+var.getNome()+"',"
				+ "'"+var.getEmail()+"','"+var.getCpf()+"')");
		con.setAcao(con.getConexao().prepareStatement(con.getSql()));
		con.getAcao().executeUpdate();
		
		con.setSql("INSERT INTO login(usuario,senha,nivel) VALUES('"+var.getUsuario()+"','"+var.getSenha()+"','"+var.getSetor()+"')");
		con.setAcao(con.getConexao().prepareStatement(con.getSql()));
		con.getAcao().executeUpdate();
		
		con.setSql("SELECT *FROM gerente WHERE cpf  = '"+var.getCpf()+"'");
		con.setAcao(con.getConexao().prepareStatement(con.getSql()));
		con.setResultado(con.getAcao().executeQuery());
		while(con.getResultado().next()) {
			idFuncionario = Integer.valueOf(con.getResultado().getString("id"));
		}
		
		con.setSql("SELECT *FROM login WHERE usuario = '"+var.getUsuario()+"'");
		con.setAcao(con.getConexao().prepareStatement(con.getSql()));
		con.setResultado(con.getAcao().executeQuery());
		while(con.getResultado().next()) {
			idLogin = Integer.valueOf(con.getResultado().getString("id"));
		}
		
		con.setSql("update gerente set idLogin = '"+idLogin+"' where id = '"+idFuncionario+"'");
		con.setAcao(con.getConexao().prepareStatement(con.getSql()));
		con.getAcao().executeUpdate();
		
		JOptionPane.showMessageDialog(null,"Cadastrado com sucesso");
		Menu m = new Menu();
		m.menu();
		dispose();
		
	}catch(Exception erro) {
		System.out.println(erro);
	}
			}}}}}
		}
	}
}