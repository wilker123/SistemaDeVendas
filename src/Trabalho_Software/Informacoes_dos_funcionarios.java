


package Trabalho_Software;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import Atendente.Conexao;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.JTextField;
import java.awt.List;
import java.awt.Panel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.UIManager;

public class Informacoes_dos_funcionarios extends JFrame {
	
	Funcionario var = new Funcionario();

	private JPanel contentPane;
	private JTable table;
	private JTextField id;
	private JTextField eNome;
	private JTextField eCpf;
	private JTextField eSalario;
	private JTextField eEmail;
	private JTextField eUsuario;
	private JTextField eNumeroVendas;
	private JTextField eSenha;

	/**
	 * Launch the application.
	 */
	public void Informacoes() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Informacoes_dos_funcionarios frame = new Informacoes_dos_funcionarios();
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
	public Informacoes_dos_funcionarios() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1110, 800);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 495, 1092, 234);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.setFont(new Font("Tahoma", Font.PLAIN, 14));
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null, null, null, null, null, null},
			},
			new String[] {
				"Id", "Nome", "Email", "CPF", "Sal\u00E1rio", "Meta", "N\u00BA de vendas ", "idLogin", "Usu\u00E1rio", "Senha"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				true, false, true, true, true, true, true, true, true, true
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		table.getColumnModel().getColumn(0).setPreferredWidth(31);
		table.getColumnModel().getColumn(1).setPreferredWidth(259);
		table.getColumnModel().getColumn(2).setPreferredWidth(267);
		table.getColumnModel().getColumn(3).setPreferredWidth(189);
		table.getColumnModel().getColumn(4).setPreferredWidth(114);
		table.getColumnModel().getColumn(5).setPreferredWidth(136);
		table.getColumnModel().getColumn(6).setPreferredWidth(116);
		table.getColumnModel().getColumn(7).setPreferredWidth(68);
		table.getColumnModel().getColumn(8).setPreferredWidth(125);
		table.getColumnModel().getColumn(9).setPreferredWidth(146);
		scrollPane.setViewportView(table);
		
		JButton btnListarFuncionrios = new JButton("Listar Funcion\u00E1rios");
		btnListarFuncionrios.setBackground(new Color(247, 144, 139));
		btnListarFuncionrios.setForeground(Color.WHITE);
		btnListarFuncionrios.setFont(new Font("Cheap Potatoes Black Thin", Font.BOLD, 12));
		btnListarFuncionrios.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					
					listarDados();
					
				}catch(Exception erro) {
					
					System.out.println(erro);
				}
			}
		});
		btnListarFuncionrios.setBounds(363, 439, 231, 33);
		contentPane.add(btnListarFuncionrios);
		
		id = new JTextField();
		id.setBounds(102, 235, 116, 33);
		contentPane.add(id);
		id.setColumns(10);
		
		eNome = new JTextField();
		eNome.setBounds(142, 294, 435, 33);
		contentPane.add(eNome);
		eNome.setColumns(10);
		
		eCpf = new JTextField();
		eCpf.setBounds(501, 355, 255, 32);
		contentPane.add(eCpf);
		eCpf.setColumns(10);
		
		eSalario = new JTextField();
		eSalario.setBounds(866, 355, 151, 33);
		contentPane.add(eSalario);
		eSalario.setColumns(10);
		
		eEmail = new JTextField();
		eEmail.setBounds(655, 294, 362, 33);
		contentPane.add(eEmail);
		eEmail.setColumns(10);
		
		eUsuario = new JTextField();
		eUsuario.setBounds(716, 235, 301, 33);
		contentPane.add(eUsuario);
		eUsuario.setColumns(10);
		
		JButton btnListar = new JButton("Listar");
		btnListar.setBackground(new Color(247,144, 139));
		btnListar.setForeground(Color.WHITE);
		btnListar.setFont(new Font("Cheap Potatoes Black Thin", Font.BOLD, 12));
		btnListar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					Exibicao();
				}catch(Exception erro) {
					
				}
			}
		});
		btnListar.setBounds(245, 439, 106, 33);
		contentPane.add(btnListar);
		
		eNumeroVendas = new JTextField();
		eNumeroVendas.setBounds(297, 355, 145, 33);
		contentPane.add(eNumeroVendas);
		eNumeroVendas.setColumns(10);
		
		eSenha = new JTextField();
		eSenha.setBounds(299, 235, 309, 33);
		contentPane.add(eSenha);
		eSenha.setColumns(10);
		
		JButton btnAtualizar = new JButton("Atualizar");
		btnAtualizar.setBackground(new Color(247, 144, 139));
		btnAtualizar.setForeground(Color.WHITE);
		btnAtualizar.setFont(new Font("Cheap Potatoes Black Thin", Font.BOLD, 12));
		btnAtualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				switch(JOptionPane.showConfirmDialog(null, "Deseja realmente atualizar as informações do funcionário?", "Atualizar funcionário?", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE)){
					case 0: 
						atualizar();
						JOptionPane.showMessageDialog(null,"Atualizado com sucesso com sucesso");
					break;
					case 1:
						JOptionPane.showMessageDialog(null, "Nenhum funcionário foi atualizado", "Nenhum funcionário atualizado", JOptionPane.INFORMATION_MESSAGE);
					break;
				}
			
		
			}
		});
		btnAtualizar.setBounds(724, 439, 129, 33);
		contentPane.add(btnAtualizar);
		
		JButton btnDemitir = new JButton("Demitir");
		btnDemitir.setForeground(Color.WHITE);
		btnDemitir.setFont(new Font("Cheap Potatoes Black Thin", Font.BOLD, 12));
		btnDemitir.setBackground(new Color(247, 144, 139));
		btnDemitir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					
					switch(JOptionPane.showConfirmDialog(null, "Deseja realmente deletar as informações do funcionário?", "Deletar funcionário?", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE)){
					case 0: 
						demite();
						JOptionPane.showMessageDialog(null,"Deletado com sucesso");
					break;
					case 1:
						JOptionPane.showMessageDialog(null, "Nenhum funcionário foi deletado", "Nenhum funcionário deletado", JOptionPane.INFORMATION_MESSAGE);
					break;
				}
					
				}catch(Exception erro) {
					
				}
			}
		});
		btnDemitir.setBounds(606, 439, 106, 33);
		contentPane.add(btnDemitir);
		
		JButton btnVoltarAoMenu = new JButton("Voltar ao Menu");
		btnVoltarAoMenu.setBackground(new Color(247, 144, 139));
		btnVoltarAoMenu.setForeground(Color.WHITE);
		btnVoltarAoMenu.setFont(new Font("Cheap Potatoes Black Thin", Font.BOLD, 12));
		btnVoltarAoMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					Menu menu = new Menu();
					menu.menu();
					dispose();
				}catch(Exception erro) {
					System.out.println(erro);
				}
			}
		});
		btnVoltarAoMenu.setBounds(904, 13, 188, 33);
		contentPane.add(btnVoltarAoMenu);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon("C:\\Users\\Thiago\\workspace\\bird_shoes\\src\\Trabalho_Software\\Imagens\\infofunc.png"));
		label.setBounds(0, 0, 1100, 752);
		contentPane.add(label);
	}
	//aqui acontece a atualização das informações do usuario
	public void atualizar() {
		try {
			Conexao con = new Conexao();
			String cpfAux = "";
			var.setId(id.getText());
			
			con.setSql("SELECT *FROM atendente WHERE id = '"+var.getId()+"'");
			con.setAcao(con.getConexao().prepareStatement(con.getSql()));
			con.setResultado(con.getAcao().executeQuery());
			while(con.getResultado().next()) {
				cpfAux = con.getResultado().getString("cpf");
			}
			
			var.setId(id.getText());
			var.setNome(eNome.getText());
			var.setCpf(eCpf.getText());
			var.setSalario(eSalario.getText());
			var.setEmail(eEmail.getText());
			var.setUsuario(eUsuario.getText());
			var.setNumeroVendas(eNumeroVendas.getText());
			var.setSenha(eSenha.getText());
			
			//System.out.println(rgAux);
			//System.out.println(var.getRg());
			
				
			
				con.setSql("UPDATE atendente SET nome = '" + var.getNome() + "', cpf = '" + var.getCpf() + "', email = '"+var.getEmail()+"',"
						+ "salario = '"+var.getSalario()+"', numeroVendas = '"+var.getNumeroVendas()+"' WHERE id = '" + var.getId() + "'");
				con.setAcao(con.getConexao().prepareStatement(con.getSql()));
				con.getAcao().executeUpdate();
				
				con.setSql("UPDATE login SET cpfFuncionario = '"+var.getCpf()+"' WHERE cpfFuncionario = '"+cpfAux+"' ");
				con.setAcao(con.getConexao().prepareStatement(con.getSql()));
				con.getAcao().executeUpdate();
				
				con.setSql("UPDATE login SET usuario = '"+var.getUsuario()+"', senha = '"+var.getSenha()+"' WHERE cpfFuncionario = '"+var.getCpf()+"'");
				con.setAcao(con.getConexao().prepareStatement(con.getSql()));
				con.getAcao().executeUpdate();
				
					
				
		}catch(Exception erro) {
			System.out.println(erro);
		}
	}
	//aqui ocorre a operação de deletar o usuário
	public void demite() {
		try {
			Conexao con = new Conexao();
			
			var.setCpf(eCpf.getText());
			var.setId(id.getText());
			
			con.setSql("DELETE FROM atendente WHERE id = '"+var.getId()+"'");
			con.setAcao(con.getConexao().prepareStatement(con.getSql()));
			con.getAcao().executeUpdate();
			
			con.setSql("DELETE FROM login WHERE cpfFuncionario = '"+var.getCpf()+"'");
			con.setAcao(con.getConexao().prepareStatement(con.getSql()));
			con.getAcao().executeUpdate();
			
			
		}catch(Exception erro) {
			System.out.println(erro);
		}
	}
	
	//aqui é o metódo que exibe as informações nos JtextField
	public void Exibicao() {
		
		var.setId(id.getText());
		var.setNome(eNome.getText());
		var.setCpf(eCpf.getText());
		var.setSalario(eSalario.getText());
		var.setEmail(eEmail.getText());
		var.setUsuario(eUsuario.getText());
		var.setNumeroVendas(eNumeroVendas.getText());
		var.setSenha(eSenha.getText());
		
		
		try {
		
			Conexao con = new Conexao();
			
			con.setSql("SELECT * FROM atendente WHERE id='"+var.getId()+"'");
			con.setAcao(con.getConexao().prepareStatement(con.getSql()));
			con.setResultado(con.getAcao().executeQuery());
	
			String nome = "";
			String email = "";
			String cpf = "";
			String salario = "";
			String numeroVendas = "";
			String idLogin = "";
			String idf = "";
			while (con.getResultado().next()) {
				
				nome = con.getResultado().getString("nome");
				cpf = con.getResultado().getString("cpf");
				email = con.getResultado().getString("email");
				salario = con.getResultado().getString("salario");
				numeroVendas = con.getResultado().getString("numeroVendas");
				idLogin = con.getResultado().getString("idLogin");
				idf = con.getResultado().getString("id");
			}
			String usuario = "";
			String senha = "";
			
			
			con.setSql("SELECT usuario,senha FROM login as l inner join atendente as at where l.id = '"+idLogin+"'");
			con.setAcao(con.getConexao().prepareStatement(con.getSql()));
			con.setResultado(con.getAcao().executeQuery());
			
			while(con.getResultado().next()) {
				usuario = con.getResultado().getString("usuario");
				senha = con.getResultado().getString("senha");
			}
			id.setText(idf);
			eUsuario.setText(usuario);
			eNome.setText(nome);
			eCpf.setText(cpf);
			eSalario.setText(salario);
			eEmail.setText(email);
			eNumeroVendas.setText(numeroVendas);
			eSenha.setText(senha);
			
		} catch (Exception erro) {
			System.out.println(erro);
		}
	}

	
	
	//Aqui lista os dados do Jtable, com as informações das tabelas atendente e login
	public void listarDados() {
		try {
			
			Conexao con = new Conexao();
			
			con.setSql("Select at.id,at.nome,at.email,at.cpf,at.salario,at.meta,at.numeroVendas,at.idLogin,l.usuario,l.senha from "
					+ "atendente as at inner join login as l where at.idLogin = l.id");
			con.setAcao(con.getConexao().prepareStatement(con.getSql()));
			con.setResultado(con.getAcao().executeQuery());
			
			DefaultTableModel modelo = (DefaultTableModel) table.getModel();
			modelo.setNumRows(0);
			
			while(con.getResultado().next()) {
				
				modelo.addRow(new Object[] {con.getResultado().getString("id"),con.getResultado().getString("nome"),
						con.getResultado().getString("email"),con.getResultado().getString("cpf"),con.getResultado().getString("salario"),
						con.getResultado().getString("meta"),con.getResultado().getString("numeroVendas"),con.getResultado().getString("idLogin"),
						con.getResultado().getString("usuario"),con.getResultado().getString("senha")});
			}
			
			con.getResultado().close();
			
		}catch(Exception erro) {
			
		}
		
	}
}
