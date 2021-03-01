package Trabalho_Software;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Atendente.Conexao;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.ActionEvent;
import javax.swing.JScrollBar;
import javax.swing.JToggleButton;
import javax.swing.KeyStroke;

import java.awt.Choice;
import java.awt.Label;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.AbstractAction;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import java.awt.Font;

public class CadastroFuncionario extends JFrame {

	private JPanel contentPane;
	private JTextField vNome;
	private JTextField vEmail;
	private JTextField vCpf;
	private JTextField vSalario;

	

	
	private JTextField vUsuario;
	private JTextField vSetor;
	private JPasswordField vSenha;
	JLabel usuarioVazio;
	JLabel emailVazio;
	JLabel cpfVazio;
	JLabel salarioVazio;
	JLabel erroNome;
	JLabel senhaVazio;
	JLabel setorVazio;


	/**
	 * Launch the application.
	 */
	public void cadastrofuncionario() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CadastroFuncionario frame = new CadastroFuncionario();
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
	public CadastroFuncionario() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 1100, 800);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		setLocationRelativeTo(null);
		contentPane.setLayout(null);
		
		JButton btnVoltarAoMenu = new JButton("Voltar ao menu");
		btnVoltarAoMenu.setBackground(Color.PINK);
		btnVoltarAoMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Menu menu = new Menu();
				menu.menu();
				dispose();
			}
		});
		btnVoltarAoMenu.setBounds(895, 39, 143, 23);
		contentPane.add(btnVoltarAoMenu);

		vNome = new JTextField();
		vNome.setForeground(new Color(128, 128, 128));
		vNome.setFont(new Font("Lato", Font.BOLD, 15));
		vNome.setBounds(147, 318, 423, 29);
		contentPane.add(vNome);
		vNome.setColumns(10);

		vEmail = new JTextField();
		vEmail.setForeground(new Color(128, 128, 128));
		vEmail.setFont(new Font("Lato", Font.BOLD, 15));
		vEmail.setBounds(661, 318, 339, 29);
		contentPane.add(vEmail);
		vEmail.setColumns(10);

		vCpf = new JTextField();
		vCpf.setForeground(new Color(128, 128, 128));
		vCpf.setFont(new Font("Lato", Font.BOLD, 15));
		vCpf.setBounds(506, 376, 245, 29);
		contentPane.add(vCpf);
		vCpf.setColumns(10);

		vSalario = new JTextField();
		vSalario.setForeground(new Color(128, 128, 128));
		vSalario.setFont(new Font("Lato", Font.BOLD, 15));
		vSalario.setBounds(867, 376, 133, 29);
		contentPane.add(vSalario);
		vSalario.setColumns(10);
		
		JButton btnTestar = new JButton("Cadastrar Atendente");
		btnTestar.setBackground(new Color(247, 139, 144));
		btnTestar.setForeground(Color.WHITE);
		btnTestar.setFont(new Font("Cheap Potatoes", Font.PLAIN, 12));
		btnTestar.setBounds(405, 456, 258, 37);
		btnTestar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					switch(JOptionPane.showConfirmDialog(null, "Deseja realmente cadastrar esse funcionario?", "Cadastrar funcionário?", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE)){
						case 0: 
							try{
							Insercao();
							}catch(Exception erro){
								System.out.println(erro);
							}
						break;
						case 1:
							JOptionPane.showMessageDialog(null, "Nenhum funcionário foi cadastrado", "Nenhum funcionário foi cadastrado", JOptionPane.INFORMATION_MESSAGE);
						break;
					}
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					System.out.println("FDS");
				}
			}
		});
		getRootPane().getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(
			    KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0), "Cadastrar"
			);     

		getRootPane().getActionMap().put("Cadastrar", new AbstractAction() {
		    public void actionPerformed(ActionEvent e) {
		    	try {
					switch(JOptionPane.showConfirmDialog(null, "Deseja realmente cadastrar esse funcionario?", "Cadastrar funcionário?", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE)){
					case 0: 
						try{
						Insercao();
						}catch(Exception erro){
							System.out.println(erro);
						}
					break;
					case 1:
						JOptionPane.showMessageDialog(null, "Nenhum funcionário foi cadastrado", "Nenhum funcionário foi cadastrado", JOptionPane.INFORMATION_MESSAGE);
					break;
				}
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				System.out.println("FDS");
			}
		    }
		});
		contentPane.add(btnTestar);
		
		vUsuario = new JTextField();
		vUsuario.setForeground(new Color(128, 128, 128));
		vUsuario.setFont(new Font("Lato", Font.BOLD, 15));
		vUsuario.setBounds(177, 258, 393, 29);
		contentPane.add(vUsuario);
		vUsuario.setColumns(10);
		
		vSetor = new JTextField();
		vSetor.setForeground(new Color(128, 128, 128));
		vSetor.setFont(new Font("Lato", Font.BOLD, 15));
		vSetor.setBounds(157, 376, 276, 29);
		contentPane.add(vSetor);
		vSetor.setColumns(10);
		
		usuarioVazio = new JLabel("");
		usuarioVazio.setBounds(179, 290, 198, 14);
		usuarioVazio.setForeground(new Color(220, 20, 60));
		contentPane.add(usuarioVazio);
		
		vSenha = new JPasswordField();
		vSenha.setForeground(new Color(128, 128, 128));
		vSenha.setFont(new Font("Lato", Font.BOLD, 15));
		vSenha.setBounds(661, 258, 339, 29);
		contentPane.add(vSenha);
		
		emailVazio = new JLabel("");
		emailVazio.setBounds(661, 351, 196, 14);
		emailVazio.setForeground(Color.RED);
		contentPane.add(emailVazio);
		
		cpfVazio = new JLabel("");
		cpfVazio.setBounds(506, 406, 198, 14);
		cpfVazio.setForeground(Color.RED);
		contentPane.add(cpfVazio);
		
		salarioVazio = new JLabel("");
		salarioVazio.setBounds(867, 406, 282, 14);
		salarioVazio.setForeground(Color.RED);
		contentPane.add(salarioVazio);
		
		erroNome = new JLabel("");
		erroNome.setBounds(149, 351, 211, 14);
		erroNome.setForeground(Color.RED);
		contentPane.add(erroNome);
		
		senhaVazio = new JLabel("");
		senhaVazio.setBounds(661, 290, 258, 14);
		senhaVazio.setForeground(Color.RED);
		contentPane.add(senhaVazio);
		
		setorVazio = new JLabel("");
		setorVazio.setBounds(158, 406, 258, 14);
		setorVazio.setForeground(Color.RED);
		contentPane.add(setorVazio);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon("C:\\Users\\Thiago\\workspace\\bird_shoes\\src\\Trabalho_Software\\Imagens\\cadastrofunc.png"));
		label.setBounds(10, 0, 1082, 753);
		contentPane.add(label);
		
		
	}

	public void Insercao() throws SQLException{
		Funcionario var = new Funcionario();
		Conexao con = new Conexao();
		
		var.setNome(vNome.getText());
		var.setEmail(vEmail.getText());
		var.setCpf(vCpf.getText());
		var.setSalario(vSalario.getText());
		var.setUsuario(vUsuario.getText());
		var.setSenha(vSenha.getText());
		var.setSetor(vSetor.getText());

		String cpfAux;
		int idFuncionario = 0;
		int idLogin = 0;
		String setor;
		
		if(var.getUsuario().equals("")) {
			usuarioVazio.setText("Digite o nome do Usuário");
		}else {
			usuarioVazio.setText("");
			if(var.getSenha().equals("")) {			
				senhaVazio.setText("Digite a senha do usuário");
			}else {
				senhaVazio.setText("");
			if(var.getNome().equals("")) {
				erroNome.setText("Digite o nome do funcionário");
			}else {
				erroNome.setText("");
			if(var.getEmail().equals("")) {
				emailVazio.setText("Digite o email do usuário");
			}else {
				emailVazio.setText("");
			if(var.getSetor().equals("")) {
				setorVazio.setText("Digite o setor do usuário");
			}else {
				setorVazio.setText("");
			if(var.getCpf().equals("")) {
				cpfVazio.setText("Digite a cpf do usuário");
			}else {
				cpfVazio.setText("");
			if(var.getSalario().equals("")) {
				salarioVazio.setText("Digite quanto esse funcionário irá ganhar");
			}else {
				salarioVazio.setText("");
				
		try {
			ArrayList<String> cpfs = new ArrayList<>();
			
			con.setSql("SELECT *FROM atendente WHERE cpf = '" + var.getCpf() + "'");
			con.setAcao(con.getConexao().prepareStatement(con.getSql()));
			con.setResultado(con.getAcao().executeQuery());

			while (con.getResultado().next()) {
				cpfs.add(con.getResultado().getString("cpf"));
			}

			int aux = cpfs.indexOf(var.getCpf());

			if (aux == 0) {
				JOptionPane.showMessageDialog(null, "Funcionário já existe no Sistema", "", 0);
			}else {
				
			con.setSql("INSERT INTO atendente(nome,email,cpf,salario) VALUES('"+var.getNome()+"','"+var.getEmail()+"','"+var.getCpf()+"','"+var.getSalario()+"') ");
			con.setAcao(con.getConexao().prepareStatement(con.getSql()));
			con.getAcao().executeUpdate();
					
			con.setSql("INSERT INTO login(usuario,senha,nivel) VALUES('"+var.getUsuario()+"','"+var.getSenha()+"','"+var.getSetor()+"')");
			con.setAcao(con.getConexao().prepareStatement(con.getSql()));
			con.getAcao().executeUpdate();
			
			
			con.setSql("SELECT *FROM atendente WHERE cpf  = '"+var.getCpf()+"'");
			con.setAcao(con.getConexao().prepareStatement(con.getSql()));
			con.setResultado(con.getAcao().executeQuery());
			while(con.getResultado().next()) {
				cpfAux = con.getResultado().getString("cpf");
				idFuncionario = Integer.valueOf(con.getResultado().getString("id"));
			}
			
			con.setSql("SELECT *FROM login WHERE usuario = '"+var.getUsuario()+"'");
			con.setAcao(con.getConexao().prepareStatement(con.getSql()));
			con.setResultado(con.getAcao().executeQuery());
			while(con.getResultado().next()) {
				idLogin = Integer.valueOf(con.getResultado().getString("id"));
			}
			
			con.setSql("update atendente set idLogin = '"+idLogin+"' where id = '"+idFuncionario+"'");
			con.setAcao(con.getConexao().prepareStatement(con.getSql()));
			con.getAcao().executeUpdate();
			
			
			System.out.println("Cadastro feito com sucesso");
			Menu menu = new Menu();
			menu.menu();
			dispose();
		}
			
		}catch(Exception erro) {
			
			System.out.println(erro);
		}
				}
		}
	}
		
	}
}
}
}
}
}