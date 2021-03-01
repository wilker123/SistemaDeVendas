package Atendente;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import Trabalho_Software.Menu;

public class Gerenciamento_de_clientes extends JFrame {

	private JPanel contentPane;
	private JTextField tf_nome;
	private JTextField tf_cpf;
	private JTextField tf_email;
	private JTextField tf_telefone1;
	private JTextField tf_telefone2;
	private JTextField tf_inserir;
	private JTable table;
	private JTextField tf_rua;
	private JTextField tf_numero;
	private JTextField tf_cep;
	Cliente var = new Cliente();
	Telefone t = new Telefone();
	Endereco e = new Endereco();
	private JTextField tf_rg;
	private JTextField tf_bairro;
	private JTextField tf_cidade;
	/**
	 * Launch the application.
	 */
	public void gerenciar() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Gerenciamento_de_clientes frame = new Gerenciamento_de_clientes();
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
	public Gerenciamento_de_clientes() {
		setTitle("Gerenciar clientes");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 1100, 800);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(5, 5, 1077, 748);
		contentPane.add(panel);
		panel.setLayout(null);
		  
		JButton btnVisualizarClientes = new JButton("Visualizar clientes");
		btnVisualizarClientes.setBackground(SystemColor.activeCaption);
		btnVisualizarClientes.setForeground(Color.WHITE);
		btnVisualizarClientes.setFont(new Font("Cheap Potatoes", Font.PLAIN, 11));
		btnVisualizarClientes.setBounds(297, 707, 217, 28);
		panel.add(btnVisualizarClientes);
		
		JButton btnEditarCliente = new JButton("Editar cliente");
		btnEditarCliente.setBackground(SystemColor.activeCaption);
		btnEditarCliente.setForeground(Color.WHITE);
		btnEditarCliente.setFont(new Font("Cheap Potatoes", Font.PLAIN, 11));
		btnEditarCliente.setBounds(541, 707, 173, 28);
		panel.add(btnEditarCliente);
		
		JButton btnCadastrarCliente = new JButton("Cadastrar cliente");
		btnCadastrarCliente.setBackground(SystemColor.activeCaption);
		btnCadastrarCliente.setForeground(Color.WHITE);
		btnCadastrarCliente.setFont(new Font("Cheap Potatoes", Font.PLAIN, 11));
		btnCadastrarCliente.setBounds(741, 707, 189, 28);
		panel.add(btnCadastrarCliente);
		
		tf_nome = new JTextField();
		tf_nome.setBackground(Color.WHITE);
		tf_nome.setBounds(155, 193, 320, 33);
		tf_nome.setEnabled(false);
		panel.add(tf_nome);
		tf_nome.setColumns(10);
		
		tf_cpf = new JTextField();
		tf_cpf.setBackground(Color.WHITE);
		tf_cpf.setBounds(537, 137, 189, 33);
		tf_cpf.setEnabled(false);
		tf_cpf.setColumns(10);
		panel.add(tf_cpf);
		
		tf_email = new JTextField();
		tf_email.setBackground(Color.WHITE);
		tf_email.setBounds(556, 193, 422, 33);
		tf_email.setEnabled(false);
		tf_email.setColumns(10);
		panel.add(tf_email);
		
		tf_telefone1 = new JTextField();
		tf_telefone1.setBackground(Color.WHITE);
		tf_telefone1.setBounds(232, 253, 243, 33);
		tf_telefone1.setEnabled(false);
		tf_telefone1.setColumns(10);
		panel.add(tf_telefone1);
		
		tf_telefone2 = new JTextField();
		tf_telefone2.setBackground(Color.WHITE);
		tf_telefone2.setBounds(240, 310, 235, 33);
		tf_telefone2.setEnabled(false);
		tf_telefone2.setColumns(10);
		panel.add(tf_telefone2);
		
		JCheckBox habilitaEdicao = new JCheckBox("Habilitar edi\u00E7\u00E3o");
		habilitaEdicao.setForeground(SystemColor.inactiveCaptionBorder);
		habilitaEdicao.setFont(new Font("Cheap Potatoes", Font.BOLD, 9));
		habilitaEdicao.setBackground(SystemColor.activeCaption);
		habilitaEdicao.setBounds(391, 21, 161, 29);
		panel.add(habilitaEdicao);
		
		tf_inserir = new JTextField();
		tf_inserir.setBounds(232, 21, 151, 29);
		tf_inserir.setColumns(10);
		panel.add(tf_inserir);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 421, 1077, 276);
		panel.add(scrollPane);
		
		table = new JTable();
		table.setBounds(20, 398, 687, -181);
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null, null, null, null, null, null, null, null},
			},
			new String[] {
				"Id", "Nome", "Cpf", "Email", "Rg", "Telefone1", "Telefone2", "Rua", "Numero", "Cep", "Cidade", "Bairro"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false, false, false, false, false, false, false, false, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		table.getColumnModel().getColumn(0).setPreferredWidth(30);
		table.getColumnModel().getColumn(1).setPreferredWidth(100);
		table.getColumnModel().getColumn(2).setPreferredWidth(100);
		table.getColumnModel().getColumn(3).setPreferredWidth(150);
		table.getColumnModel().getColumn(4).setPreferredWidth(100);
		table.getColumnModel().getColumn(5).setPreferredWidth(100);
		table.getColumnModel().getColumn(6).setPreferredWidth(100);
		table.getColumnModel().getColumn(7).setPreferredWidth(80);
		table.getColumnModel().getColumn(8).setPreferredWidth(70);
		table.getColumnModel().getColumn(9).setPreferredWidth(100);
		table.getColumnModel().getColumn(10).setPreferredWidth(100);
		table.getColumnModel().getColumn(11).setPreferredWidth(100);
		scrollPane.setViewportView(table);
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.setBackground(SystemColor.activeCaption);
		btnVoltar.setForeground(Color.WHITE);
		btnVoltar.setFont(new Font("Cheap Potatoes", Font.PLAIN, 11));
		btnVoltar.setBounds(138, 707, 132, 28);
		panel.add(btnVoltar);
		
		tf_rua = new JTextField();
		tf_rua.setBackground(Color.WHITE);
		tf_rua.setBounds(538, 253, 188, 33);
		tf_rua.setEnabled(false);
		tf_rua.setColumns(10);
		panel.add(tf_rua);
		
		tf_numero = new JTextField();
		tf_numero.setBackground(Color.WHITE);
		tf_numero.setBounds(837, 253, 141, 33);
		tf_numero.setEnabled(false);
		tf_numero.setColumns(10);
		panel.add(tf_numero);
		
		tf_cep = new JTextField();
		tf_cep.setBackground(Color.WHITE);
		tf_cep.setBounds(537, 310, 189, 33);
		tf_cep.setEnabled(false);
		tf_cep.setColumns(10);
		panel.add(tf_cep);
		
		tf_rg = new JTextField();
		tf_rg.setBackground(Color.WHITE);
		tf_rg.setBounds(132, 137, 343, 33);
		tf_rg.setEnabled(false);
		tf_rg.setColumns(10);
		panel.add(tf_rg);
		
		tf_bairro = new JTextField();
		tf_bairro.setBackground(Color.WHITE);
		tf_bairro.setBounds(817, 137, 161, 33);
		tf_bairro.setEnabled(false);
		tf_bairro.setColumns(10);
		panel.add(tf_bairro);
		
		tf_cidade = new JTextField();
		tf_cidade.setBackground(Color.WHITE);
		tf_cidade.setBounds(817, 310, 161, 33);
		tf_cidade.setEnabled(false);
		tf_cidade.setColumns(10);
		panel.add(tf_cidade);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon("C:\\Users\\Thiago\\workspace\\bird_shoes\\src\\Trabalho_Software\\imagens\\gerenciamentoCli.png"));
		label.setBounds(0, 0, 1077, 748);
		panel.add(label);
		
		habilitaEdicao.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(habilitaEdicao.isSelected()){
						tf_nome.setEnabled(true);
						tf_cpf.setEnabled(true);
						tf_rg.setEnabled(true);
						tf_email.setEnabled(true);
						tf_telefone1.setEnabled(true);
						tf_telefone2.setEnabled(true);
						tf_rua.setEnabled(true);
						tf_numero.setEnabled(true);
						tf_cep.setEnabled(true);
						tf_cidade.setEnabled(true);
						tf_bairro.setEnabled(true);
						try {
							if(tf_inserir.getText().equals("")){
							
							}else{
								inserirDados();
							}
						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
				}else{
					tf_nome.setEnabled(false);
					tf_cpf.setEnabled(false);
					tf_rg.setEnabled(false);
					tf_email.setEnabled(false);
					tf_telefone1.setEnabled(false);
					tf_telefone2.setEnabled(false);
					tf_rua.setEnabled(false);
					tf_numero.setEnabled(false);
					tf_cep.setEnabled(false);
					tf_cidade.setEnabled(false);
					tf_bairro.setEnabled(false);
				}
			}
		});
		
		btnEditarCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					switch(JOptionPane.showConfirmDialog(null, "Deseja realmente modificar esse cliente?", "Modificar cliente?", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE)){
						case 0: 
							try{
							editarCliente();
							}catch(Exception erro){
								System.out.println(erro);
							}
						break;
						case 1:
							JOptionPane.showMessageDialog(null, "Nenhum cliente foi modificado", "Nenhum cliente modificado", JOptionPane.INFORMATION_MESSAGE);
						break;
					}
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					System.out.println("FDS");
				}
			}
		});
		
		btnVisualizarClientes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					
					listarDados();
					
				}catch(Exception erro) {
					
					System.out.println(erro);
				}
			}
		});
		
		btnCadastrarCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					
					cadastrarCliente();
					
				}catch(Exception erro) {
					
					System.out.println(erro);
				}
			}
		});
		
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Menu m = new Menu();
				m.menu();
				setVisible(false);
			}
		});
		
		tf_inserir.addKeyListener(new java.awt.event.KeyAdapter(){
			
			public void keyReleased(java.awt.event.KeyEvent e){
				if(tf_inserir.getText().length()>=1);
				pesquisar();
			}
		});
	}
	
	public void pesquisar() {
		try {
			Conexao con = new Conexao();
			var.setCpf(tf_inserir.getText());
			con.setSql("Select c.id, c.nome, c.cpf, c.email, c.rgCliente, t.telefone1, t.telefone2, e.rua, e.numero, e.cep, e.cidade, e.bairro from cliente as c inner join"
					+ " telefone as t inner join endereco as e where c.cpf = t.cpfCliente && c.cpf = e.cpfCliente && c.cpf like '"+var.getCpf()+"%' order by c.nome");
			con.setAcao(con.getConexao().prepareStatement(con.getSql()));
			con.setResultado(con.getAcao().executeQuery());
			
			DefaultTableModel modelo = (DefaultTableModel) table.getModel();
			modelo.setNumRows(0);
			while(con.getResultado().next()) {
				modelo.addRow(new Object[] {con.getResultado().getString("id"),con.getResultado().getString("nome"), con.getResultado().getString("cpf"),
						con.getResultado().getString("email"),con.getResultado().getString("rgCliente"), con.getResultado().getString("telefone1"),
						con.getResultado().getString("telefone2"),con.getResultado().getString("rua"), con.getResultado().getString("numero"),
						con.getResultado().getString("cep"),con.getResultado().getString("cidade"),con.getResultado().getString("bairro")});
			}
			if(modelo.getRowCount() == 0){
				JOptionPane.showMessageDialog(null, "Cliente não existe no sistema", "Cliente inexistente", JOptionPane.WARNING_MESSAGE);
			}
			con.getResultado().close();
		}catch(Exception erro) {
			System.out.println(erro);
		}
	}
	
	public void pedido(){
		try {
			Conexao con = new Conexao();
			var.setCpf(tf_inserir.getText());
			if(var.getCpf().equals("")){
				JOptionPane.showMessageDialog(null, "Insira um cpf", "Insira um cpf", JOptionPane.WARNING_MESSAGE);
			}else{
				ArrayList<String> cpfs = new ArrayList<>();
				
				con.setSql("SELECT cpf FROM cliente where cpf = "+var.getCpf());
				con.setAcao(con.getConexao().prepareStatement(con.getSql()));
				con.setResultado(con.getAcao().executeQuery());
				
				while (con.getResultado().next()) {
					cpfs.add(con.getResultado().getString("cpf"));
				}
	
				int aux = cpfs.indexOf(var.getCpf());
	
				if (aux == 0) {
					dispose();
					new Venda();
				}else{
					JOptionPane.showMessageDialog(null, "O cliente não está cadastrado", "Cpf inexistente", JOptionPane.WARNING_MESSAGE);
				}
			}
		}catch(Exception erro){
			JOptionPane.showMessageDialog(null, "Digite apenas números", "Valor inválido", JOptionPane.WARNING_MESSAGE);
		}
	}
	
	public void cadastrarCliente(){
		try {
			Conexao con = new Conexao();
			var.setNome(tf_nome.getText());
			var.setCpf(tf_cpf.getText());
			var.setRg(tf_rg.getText());
			var.setEmail(tf_email.getText());
			t.setTelefone1(tf_telefone1.getText());
			t.setTelefone2(tf_telefone2.getText());
			e.setRua(tf_rua.getText());
			e.setNumero(tf_numero.getText());
			e.setCep(tf_cep.getText());
			e.setCidade(tf_cidade.getText());
			e.setBairro(tf_bairro.getText());
			if(var.getNome().equals("") || var.getCpf().equals("") || var.getRg().equals("") || var.getEmail().equals("") || t.getTelefone1().equals("")
				|| e.getRua().equals("") || e.getNumero().equals("") || e.getCep().equals("") || e.getCidade().equals("") || e.getBairro().equals("")) {
				JOptionPane.showMessageDialog(null, "Preencha todos os campos obrigatórios", "Preencha todos os campos", JOptionPane.WARNING_MESSAGE);
			}else{
				ArrayList<String> cpfs = new ArrayList<>();
				
				con.setSql("SELECT *FROM cliente WHERE cpf = '" + var.getCpf() + "'");
				con.setAcao(con.getConexao().prepareStatement(con.getSql()));
				con.setResultado(con.getAcao().executeQuery());
	
				while (con.getResultado().next()) {
					cpfs.add(con.getResultado().getString("cpf"));
				}
	
				int aux = cpfs.indexOf(var.getCpf());
	
				if (aux == 0) {
					JOptionPane.showMessageDialog(null, "Cliente já existe no sistema", "Cliente já está cadastrado", 0);
				}else {
						
					con.setSql("INSERT INTO cliente(nome,cpf,email, rgCliente) VALUES('"+var.getNome()+"',"+var.getCpf()+",'"+var.getEmail()+"','"+var.getRg()+"') ");
					con.setAcao(con.getConexao().prepareStatement(con.getSql()));
					con.getAcao().executeUpdate();
							
					con.setSql("INSERT INTO telefone(telefone1, telefone2, cpfCliente) VALUES('"+t.getTelefone1()+"','"+t.getTelefone2()+"',"+var.getCpf()+")");
					con.setAcao(con.getConexao().prepareStatement(con.getSql()));
					con.getAcao().executeUpdate();
					
					con.setSql("INSERT INTO endereco(rua, numero, cep, cidade, bairro, cpfCliente) VALUES('"+e.getRua()+"','"+e.getNumero()+"' ,'"+e.getCep()+"','"+e.getCidade()+"',"
							+ "'"+e.getBairro()+"',"+var.getCpf()+")");
					con.setAcao(con.getConexao().prepareStatement(con.getSql()));
					con.getAcao().executeUpdate();
					listarDados();
					JOptionPane.showMessageDialog(null, "Cliente cadastrado com sucesso!", "Cadastro realizado com sucesso!", 0);
				}
			}
		}catch(Exception erro){
			JOptionPane.showMessageDialog(null, "Digite apenas números", "Valor inválido", JOptionPane.WARNING_MESSAGE);
		}
	}
	
	public void listarDados(){
		try {
			Conexao con = new Conexao();
			con.setSql("Select c.id, c.nome, c.cpf, c.email, c.rgCliente, t.telefone1, t.telefone2, e.rua, e.numero, e.cep, e.cidade, e.bairro from cliente as c inner join"
					+ " telefone as t inner join endereco as e where c.cpf = t.cpfCliente && c.cpf = e.cpfCliente order by c.nome");
			con.setAcao(con.getConexao().prepareStatement(con.getSql()));
			con.setResultado(con.getAcao().executeQuery());
			
			DefaultTableModel modelo = (DefaultTableModel) table.getModel();
			modelo.setNumRows(0);
			while(con.getResultado().next()) {
				modelo.addRow(new Object[] {con.getResultado().getString("id"),con.getResultado().getString("nome"), con.getResultado().getString("cpf"),
						con.getResultado().getString("email"),con.getResultado().getString("rgCliente"), con.getResultado().getString("telefone1"),
						con.getResultado().getString("telefone2"),con.getResultado().getString("rua"), con.getResultado().getString("numero"),
						con.getResultado().getString("cep"),con.getResultado().getString("cidade"),con.getResultado().getString("bairro")});
			}
			inserirDados();
			con.getResultado().close();
		}catch(Exception erro) {
			System.out.println(erro);
		}
	}
	
	public void inserirDados() throws SQLException{
		try {
			Conexao con = new Conexao();
			var.setCpf(tf_inserir.getText());
			
			con.setSql("Select c.id, c.nome, c.cpf, c.email, c.rgCliente, t.telefone1, t.telefone2, e.rua, e.numero, e.cep, e.cidade, e.bairro from cliente as c inner join"
					+ " telefone as t inner join endereco as e where c.cpf = '" + var.getCpf()+"' && e.cpfCliente = '" + var.getCpf()+"' && t.cpfCliente = '" + var.getCpf() + "'");
			con.setAcao(con.getConexao().prepareStatement(con.getSql()));
			con.setResultado(con.getAcao().executeQuery());
			
			con.getResultado().first();
			tf_nome.setText(con.getResultado().getString("nome"));
			tf_cpf.setText(con.getResultado().getString("cpf"));
			tf_rg.setText(con.getResultado().getString("rgCliente"));
			tf_email.setText(con.getResultado().getString("email"));
			tf_telefone1.setText(con.getResultado().getString("telefone1"));
			tf_telefone2.setText(con.getResultado().getString("telefone2"));
			tf_rua.setText(con.getResultado().getString("rua"));
			tf_numero.setText(con.getResultado().getString("numero"));
			tf_cep.setText(con.getResultado().getString("cep"));
			tf_cidade.setText(con.getResultado().getString("cidade"));
			tf_bairro.setText(con.getResultado().getString("bairro"));
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void editarCliente() throws SQLException{
		try{
			Conexao con = new Conexao();
			Cliente c = new Cliente();
			c.setCpf(tf_inserir.getText());
			var.setNome(tf_nome.getText());
			var.setCpf(tf_cpf.getText());
			var.setRg(tf_rg.getText());
			var.setEmail(tf_email.getText());
			t.setTelefone1(tf_telefone1.getText());
			t.setTelefone2(tf_telefone2.getText());
			e.setRua(tf_rua.getText());
			e.setNumero(tf_numero.getText());
			e.setCep(tf_cep.getText());
			e.setCidade(tf_cidade.getText());
			e.setBairro(tf_bairro.getText());
			if(c.getCpf().equals("")){
				JOptionPane.showMessageDialog(null, "Insira um cpf", "Insira um cpf", JOptionPane.WARNING_MESSAGE);
			}else{
				if(var.getNome().equals("") || var.getCpf().equals("") || var.getRg().equals("") || var.getEmail().equals("") || t.getTelefone1().equals("")
						|| e.getRua().equals("") || e.getNumero().equals("") || e.getCep().equals("") || e.getCidade().equals("") || e.getBairro().equals("")) {
					JOptionPane.showMessageDialog(null, "Preencha todos os campos obrigatórios", "Preencha todos os campos", JOptionPane.WARNING_MESSAGE);
				}else{
					ArrayList<String> cpfs = new ArrayList<>();
					
					con.setSql("select cpf from cliente where cpf = '" +c.getCpf()+"'");
					con.setAcao(con.getConexao().prepareStatement(con.getSql()));
					con.setResultado(con.getAcao().executeQuery());
					
					while (con.getResultado().next()) {
						cpfs.add(con.getResultado().getString("cpf"));
					}
	
					int aux = cpfs.indexOf(c.getCpf());
	
					if (aux == 0) {
					
						con.setSql("update cliente set nome = '" + var.getNome()+ "', cpf= " + var.getCpf() + ", email = " + "'" + var.getEmail() +
								"', rgCliente = '" + var.getRg() + "' where cpf = '"+c.getCpf()+"'");
						con.setAcao(con.getConexao().prepareStatement(con.getSql()));
						con.getAcao().executeUpdate();
						
						con.setSql("update telefone set telefone1 = '" + t.getTelefone1() + "', telefone2 = '" + t.getTelefone2() + "', cpfCliente = '" + var.getCpf()+
								"' where cpfCliente = '"+c.getCpf()+"'");
						con.setAcao(con.getConexao().prepareStatement(con.getSql()));
						con.getAcao().executeUpdate();
						
						con.setSql("update endereco set rua = '" + e.getRua() + "', numero = '" + e.getNumero() + "', cep = '" + e.getCep() + "', cidade = '" + e.getCidade() + 
								"', bairro = '" + e.getBairro() + "', cpfCliente = '" + var.getCpf()+"' where cpfCliente = '"+c.getCpf()+"'");
						con.setAcao(con.getConexao().prepareStatement(con.getSql()));
						con.getAcao().executeUpdate();
						JOptionPane.showMessageDialog(null, "Cliente atualizado com sucesso", "Cliente atualizado!", JOptionPane.PLAIN_MESSAGE);
						listarDados();
					}else{
						JOptionPane.showMessageDialog(null, "Digite um  cpf existente", "Cpf inexistente", JOptionPane.WARNING_MESSAGE);
					}
				}
			}
		}catch(Exception erro){
			JOptionPane.showMessageDialog(null, "Digite apenas números", "Valor inválido", JOptionPane.WARNING_MESSAGE);
		}
	}
}