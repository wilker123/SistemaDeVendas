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
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import Trabalho_Software.Menu;

public class Informacoes_dos_produtos extends JFrame {

	private JPanel contentPane;
	private JTextField tf_inserir;

	Produto var = new Produto();
	private JTextField tf_nome;
	private JTextField tf_quantidade;
	private JTextField tf_preco;
	private JTextField tf_marca;
	private JTextField tf_descricao;
	private JTextField tf_tamanho;
	
	private JTable table;
	private JTextField tf_unidade;
	/**
	 * Launch the application.
	 */
	public void produtos() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Informacoes_dos_produtos frame = new Informacoes_dos_produtos();
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
	public Informacoes_dos_produtos() {
		setTitle("Informa\u00E7\u00F5es dos produtos");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 1100, 800);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 1082, 753);
		contentPane.add(panel);
		panel.setLayout(null);
		
		tf_inserir = new JTextField();
		tf_inserir.setBackground(Color.WHITE);
		tf_inserir.setBounds(264, 49, 116, 23);
		panel.add(tf_inserir);
		tf_inserir.setColumns(10);
		
		JButton btnVisualizarProdutos = new JButton("Visualizar produtos");
		btnVisualizarProdutos.setBackground(SystemColor.activeCaption);
		btnVisualizarProdutos.setForeground(Color.WHITE);
		btnVisualizarProdutos.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnVisualizarProdutos.setBounds(523, 712, 160, 28);
		panel.add(btnVisualizarProdutos);
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.setBackground(SystemColor.activeCaption);
		btnVoltar.setForeground(Color.WHITE);
		btnVoltar.setFont(new Font("Tahoma", Font.BOLD, 13));
	
		btnVoltar.setBounds(693, 712, 160, 28);
		panel.add(btnVoltar);
		
		JButton btnEditarProdutos = new JButton("Editar produtos");
		btnEditarProdutos.setBackground(SystemColor.activeCaption);
		btnEditarProdutos.setForeground(Color.WHITE);
		btnEditarProdutos.setFont(new Font("Tahoma", Font.BOLD, 13));
		
		btnEditarProdutos.setBounds(353, 712, 160, 28);
		panel.add(btnEditarProdutos);
		
		JButton btnDeletarProduto = new JButton("Deletar produto");
		btnDeletarProduto.setBackground(SystemColor.activeCaption);
		btnDeletarProduto.setForeground(Color.WHITE);
		btnDeletarProduto.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnDeletarProduto.setBounds(178, 712, 160, 28);
		panel.add(btnDeletarProduto);
		
		tf_nome = new JTextField();
		tf_nome.setEnabled(false);
		tf_nome.setColumns(10);
		tf_nome.setBackground(Color.WHITE);
		tf_nome.setBounds(157, 183, 308, 28);
		panel.add(tf_nome);
		
		tf_quantidade = new JTextField();
		tf_quantidade.setEnabled(false);
		tf_quantidade.setColumns(10);
		tf_quantidade.setBackground(Color.WHITE);
		tf_quantidade.setBounds(613, 183, 141, 28);
		panel.add(tf_quantidade);
		
		tf_preco = new JTextField();
		tf_preco.setEnabled(false);
		tf_preco.setColumns(10);
		tf_preco.setBackground(Color.WHITE);
		tf_preco.setBounds(840, 183, 149, 28);
		panel.add(tf_preco);
		
		tf_marca = new JTextField();
		tf_marca.setEnabled(false);
		tf_marca.setColumns(10);
		tf_marca.setBackground(Color.WHITE);
		tf_marca.setBounds(167, 242, 298, 28);
		panel.add(tf_marca);
		
		tf_descricao = new JTextField();
		tf_descricao.setEnabled(false);
		tf_descricao.setColumns(10);
		tf_descricao.setBackground(Color.WHITE);
		tf_descricao.setBounds(596, 242, 393, 28);
		panel.add(tf_descricao);
		
		tf_tamanho = new JTextField();
		tf_tamanho.setEnabled(false);
		tf_tamanho.setColumns(10);
		tf_tamanho.setBackground(Color.WHITE);
		tf_tamanho.setBounds(199, 298, 266, 26);
		panel.add(tf_tamanho);
		
		JCheckBox habilitaEdicao = new JCheckBox("Habilitar edi\u00E7\u00E3o");
		habilitaEdicao.setFont(new Font("Tahoma", Font.BOLD, 13));
		habilitaEdicao.setForeground(Color.WHITE);
		habilitaEdicao.setBackground(SystemColor.activeCaption);
		habilitaEdicao.setBounds(384, 48, 129, 25);
		panel.add(habilitaEdicao);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 442, 1082, 264);
		panel.add(scrollPane);
		
		table = new JTable();
		table.setFont(new Font("Tahoma", Font.PLAIN, 14));
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null, null, null, null},
			},
			new String[] {
				"Id", "Nome", "Quantidade", "Preco", "Marca", "Descricao", "Tamanho", "Unidade de Medida"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false, false, false, false, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		table.getColumnModel().getColumn(0).setPreferredWidth(31);
		table.getColumnModel().getColumn(1).setPreferredWidth(330);
		table.getColumnModel().getColumn(2).setPreferredWidth(335);
		table.getColumnModel().getColumn(3).setPreferredWidth(189);
		table.getColumnModel().getColumn(4).setPreferredWidth(114);
		table.getColumnModel().getColumn(5).setPreferredWidth(136);
		table.getColumnModel().getColumn(6).setPreferredWidth(100);
		table.getColumnModel().getColumn(7).setPreferredWidth(100);
		scrollPane.setViewportView(table);
		
		JRadioButton pesquisaNome = new JRadioButton("Pesquisar por nome");
		pesquisaNome.setFont(new Font("Tahoma", Font.BOLD, 13));
		pesquisaNome.setBackground(SystemColor.activeCaption);
		pesquisaNome.setForeground(Color.WHITE);
		pesquisaNome.setBounds(189, 9, 192, 27);
		panel.add(pesquisaNome);
		
		JRadioButton pesquisaId = new JRadioButton("Pesquisar por id");
		pesquisaId.setFont(new Font("Tahoma", Font.BOLD, 13));
		pesquisaId.setBackground(SystemColor.activeCaption);
		pesquisaId.setForeground(Color.WHITE);
		pesquisaId.setSelected(true);
		pesquisaId.setBounds(28, 9, 163, 27);
		panel.add(pesquisaId);
		
		tf_unidade = new JTextField();
		tf_unidade.setEnabled(false);
		tf_unidade.setColumns(10);
		tf_unidade.setBackground(Color.WHITE);
		tf_unidade.setBounds(689, 298, 300, 26);
		panel.add(tf_unidade);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon("C:\\Users\\Thiago\\workspace\\bird_shoes\\src\\Trabalho_Software\\Imagens\\informacoesdosprodutos2.png"));
		label.setBounds(0, 0, 1082, 753);
		panel.add(label);
		
		
		habilitaEdicao.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(tf_inserir.getText().equals("")){
					JOptionPane.showMessageDialog(null, "Insira um nome ou id", "Insira um nome ou id", JOptionPane.WARNING_MESSAGE);
					habilitaEdicao.setSelected(false);
				}else{
					if(habilitaEdicao.isSelected()){
						tf_nome.setEnabled(true);
						tf_quantidade.setEnabled(true);
						tf_preco.setEnabled(true);
						tf_marca.setEnabled(true);
						tf_descricao.setEnabled(true);
						tf_tamanho.setEnabled(true);
						tf_unidade.setEnabled(true);
						try {
							if(pesquisaId.isSelected()){
								Conexao con = new Conexao();
								var.setId(tf_inserir.getText());
								
								ArrayList<String> ids = new ArrayList<>();
								
								con.setSql("SELECT idProduto FROM PRODUTO where idProduto = " + var.getId());
								con.setAcao(con.getConexao().prepareStatement(con.getSql()));
								con.setResultado(con.getAcao().executeQuery());
								
								while (con.getResultado().next()) {
									ids.add(con.getResultado().getString("idProduto"));
								}

								int idAux = ids.indexOf(var.getId());

								if (idAux == 0) {
									inserirDadosId();
								}else{
									JOptionPane.showMessageDialog(null, "Digite um  id ou nome existente", "Nome ou id inexistente", JOptionPane.WARNING_MESSAGE);
									habilitaEdicao.setSelected(false);
									tf_nome.setEnabled(false);
									tf_quantidade.setEnabled(false);
									tf_preco.setEnabled(false);
									tf_marca.setEnabled(false);
									tf_descricao.setEnabled(false);
									tf_tamanho.setEnabled(false);
									tf_unidade.setEnabled(false);
								}
							}else if(pesquisaNome.isSelected()){
								Conexao con;
								try {
									con = new Conexao();
								
									var.setNome(tf_inserir.getText());
									
									ArrayList<String> nomes = new ArrayList<>();
									
									con.setSql("select nomeProduto from produto where nomeProduto = '" + var.getNome()+"'");
									con.setAcao(con.getConexao().prepareStatement(con.getSql()));
									con.setResultado(con.getAcao().executeQuery());
									
									while (con.getResultado().next()) {
										nomes.add(con.getResultado().getString("nomeProduto"));
									}
							
									int nomeAux = nomes.indexOf(var.getNome());
							
									if (nomeAux == 0) {
										inserirDadosNome();
									}else{
										JOptionPane.showMessageDialog(null, "Digite um  id ou nome existente", "Nome ou id inexistente", JOptionPane.WARNING_MESSAGE);
										habilitaEdicao.setSelected(false);
										tf_nome.setEnabled(false);
										tf_quantidade.setEnabled(false);
										tf_preco.setEnabled(false);
										tf_marca.setEnabled(false);
										tf_descricao.setEnabled(false);
										tf_tamanho.setEnabled(false);
										tf_unidade.setEnabled(false);
									}
								} catch (SQLException e1) {
									// TODO Auto-generated catch block
									e1.printStackTrace();
								}
							}
						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
				}
			}
		});
		
		pesquisaId.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pesquisaNome.setSelected(false);
				pesquisaId.setSelected(true);
			}
		});
		
		pesquisaNome.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pesquisaId.setSelected(false);
				pesquisaNome.setSelected(true);
			}
		});
		
		btnDeletarProduto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {	
				if(pesquisaId.isSelected()){
					try {
						switch(JOptionPane.showConfirmDialog(null, "Deseja realmente deletar o produto?", "Deletar produto?", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE)){
						case 0: 
							deletarProdutoId();
						break;
						case 1:
							JOptionPane.showMessageDialog(null, "Nenhum produto foi deletado", "Nenhum produto deletado", JOptionPane.INFORMATION_MESSAGE);
						break;
						}
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						System.out.println("FDS");
					}
				}else if(pesquisaNome.isSelected()){
					try {
						switch(JOptionPane.showConfirmDialog(null, "Deseja realmente deletar o produto?", "Deletar produto?", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE)){
							case 0: 
								deletarProdutoNome();
							break;
							case 1:
								JOptionPane.showMessageDialog(null, "Nenhum produto foi deletado", "Nenhum produto deletado", JOptionPane.INFORMATION_MESSAGE);
							break;
						}
					} catch (SQLException e1) {
					// TODO Auto-generated catch block
						System.out.println("não");
					}
				}
			}
		});
		
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Menu m = new Menu();
				m.menu();
				setVisible(false);
				
			}
		});
		
		btnEditarProdutos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(pesquisaId.isSelected()){
					try {
						switch(JOptionPane.showConfirmDialog(null, "Deseja realmente alterar o produto?", "Alterar produto?", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE)){
							case 0: 
								editarProdutoId();
							break;
							case 1:
								JOptionPane.showMessageDialog(null, "Nenhum produto foi alterado", "Nenhum produto alterado", JOptionPane.INFORMATION_MESSAGE);
							break;
						}
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						System.out.println("FDS");
					}
				}else if(pesquisaNome.isSelected()){
					try {
						switch(JOptionPane.showConfirmDialog(null, "Deseja realmente alterar o produto?", "Alterar produto?", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE)){
							case 0: 
								editarProdutoNome();
							break;
							case 1:
								JOptionPane.showMessageDialog(null, "Nenhum produto foi alterado", "Nenhum produto alterado", JOptionPane.INFORMATION_MESSAGE);
							break;
						}
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						System.out.println("FDS");
					}
				}
			}
		});
		
		btnVisualizarProdutos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					listarDados();	
				}catch(Exception erro) {
					System.out.println(erro);
				}
			}
		});
		
		tf_inserir.addKeyListener(new java.awt.event.KeyAdapter(){			
			public void keyReleased(java.awt.event.KeyEvent e){
				if(tf_inserir.getText().length()>=1);
				if(pesquisaId.isSelected()){
					listarDadosId();
				}else if(pesquisaNome.isSelected()){
					listarDadosNome();
				}
			}
		});
	}
	
	public void listarDados() {
		try {
			Conexao con = new Conexao();
			con.setSql("Select * from produto order by idProduto");
			con.setAcao(con.getConexao().prepareStatement(con.getSql()));
			con.setResultado(con.getAcao().executeQuery());
			
			DefaultTableModel modelo = (DefaultTableModel) table.getModel();
			modelo.setNumRows(0);
			while(con.getResultado().next()) {
				modelo.addRow(new Object[] {con.getResultado().getString("idProduto"),con.getResultado().getString("nomeProduto"),
						con.getResultado().getString("quantidade"),con.getResultado().getString("preco"),con.getResultado().getString("marca"),
						con.getResultado().getString("descricao"),con.getResultado().getString("tamanho"),con.getResultado().getString("unidade")});
			}
			con.getResultado().close();
		}catch(Exception erro) {
			System.out.println(erro);
		}
	}
	public void listarDadosId() {
		try {
			Conexao con = new Conexao();
			var.setId(tf_inserir.getText());
			con.setSql("Select * from produto where idProduto like '"+var.getId()+"%' order by idProduto");
			con.setAcao(con.getConexao().prepareStatement(con.getSql()));
			con.setResultado(con.getAcao().executeQuery());
			
			DefaultTableModel modelo = (DefaultTableModel) table.getModel();
			modelo.setNumRows(0);
			while(con.getResultado().next()) {
				modelo.addRow(new Object[] {con.getResultado().getString("idProduto"),con.getResultado().getString("nomeProduto"),
						con.getResultado().getString("quantidade"),con.getResultado().getString("preco"),con.getResultado().getString("marca"),
						con.getResultado().getString("descricao"),con.getResultado().getString("tamanho"),con.getResultado().getString("tamanho")});
			}
			con.getResultado().close();
		}catch(Exception erro) {
			System.out.println(erro);
		}
	}
	
	public void listarDadosNome() {
		try {
			Conexao con = new Conexao();
			var.setNome(tf_inserir.getText());
			con.setSql("Select * from produto where nomeProduto like '"+var.getNome()+"%' order by idProduto");
			con.setAcao(con.getConexao().prepareStatement(con.getSql()));
			con.setResultado(con.getAcao().executeQuery());
			
			DefaultTableModel modelo = (DefaultTableModel) table.getModel();
			modelo.setNumRows(0);
			while(con.getResultado().next()) {
				modelo.addRow(new Object[] {con.getResultado().getString("idProduto"),con.getResultado().getString("nomeProduto"),
						con.getResultado().getString("quantidade"),con.getResultado().getString("preco"),con.getResultado().getString("marca"),
						con.getResultado().getString("descricao"),con.getResultado().getString("tamanho"),con.getResultado().getString("tamanho")});
			}
			con.getResultado().close();
		}catch(Exception erro) {
			System.out.println(erro);
		}
	}
	
	public void inserirDadosId() throws SQLException{
		Conexao con = new Conexao();
		var.setId(tf_inserir.getText());

		con.setSql("select * from produto where idProduto = " + var.getId());
		con.setAcao(con.getConexao().prepareStatement(con.getSql()));
		con.setResultado(con.getAcao().executeQuery());
		try {
			con.getResultado().first();
			tf_nome.setText(con.getResultado().getString("nomeProduto"));
			tf_quantidade.setText(con.getResultado().getString("quantidade"));
			tf_preco.setText(con.getResultado().getString("preco"));
			tf_marca.setText(con.getResultado().getString("marca"));
			tf_descricao.setText(con.getResultado().getString("descricao"));
			tf_tamanho.setText(con.getResultado().getString("tamanho"));
			tf_unidade.setText(con.getResultado().getString("unidade"));
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Digite apenas números inteiros", "Valor inválido", JOptionPane.WARNING_MESSAGE);
		}
	}
	
	public void inserirDadosNome() throws SQLException{
		try {
			Conexao con = new Conexao();
			var.setNome(tf_inserir.getText());
				
			con.setSql("select * from produto where nomeProduto = '" + var.getNome()+"'");
			con.setAcao(con.getConexao().prepareStatement(con.getSql()));
			con.setResultado(con.getAcao().executeQuery());
			
			con.getResultado().first();
			tf_nome.setText(con.getResultado().getString("nomeProduto"));
			tf_quantidade.setText(con.getResultado().getString("quantidade"));
			tf_preco.setText(con.getResultado().getString("preco"));
			tf_marca.setText(con.getResultado().getString("marca"));
			tf_descricao.setText(con.getResultado().getString("descricao"));
			tf_tamanho.setText(con.getResultado().getString("tamanho"));
			tf_unidade.setText(con.getResultado().getString("unidade"));
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	public void deletarProdutoId() throws SQLException{
		try{	
			Conexao con = new Conexao();
			var.setId(tf_inserir.getText());
			if(var.getId().equals("")){
				JOptionPane.showMessageDialog(null, "Insira um id", "Insira um id", JOptionPane.WARNING_MESSAGE);
			}else{
				ArrayList<String> ids = new ArrayList<>();
				
				con.setSql("SELECT idProduto FROM PRODUTO where idProduto = " + var.getId());
				con.setAcao(con.getConexao().prepareStatement(con.getSql()));
				con.setResultado(con.getAcao().executeQuery());
				
				while (con.getResultado().next()) {
					ids.add(con.getResultado().getString("idProduto"));
				}
	
				int aux = ids.indexOf(var.getId());
	
				if (aux == 0) {
	
					con.setSql("delete from produto where idProduto = " + var.getId());
					con.setAcao(con.getConexao().prepareStatement(con.getSql()));
					con.getAcao().executeUpdate();
					JOptionPane.showMessageDialog(null, "Produto deletado com sucesso", "Produto deletado!", JOptionPane.PLAIN_MESSAGE);
					listarDados();
				}else{
					JOptionPane.showMessageDialog(null, "Digite um  id existente", "Id inexistente", JOptionPane.WARNING_MESSAGE);
				}
			}
		}catch(Exception e){
			JOptionPane.showMessageDialog(null, "Digite apenas números inteiros", "Valor inválido", JOptionPane.WARNING_MESSAGE);
		}
	}
	public void deletarProdutoNome() throws SQLException{
		Conexao con = new Conexao();
		var.setNome(tf_inserir.getText());
		if(var.getNome().equals("")){
			JOptionPane.showMessageDialog(null, "Insira um nome", "Insira um nome", JOptionPane.WARNING_MESSAGE);
		}else{
			ArrayList<String> nomes = new ArrayList<>();
			
			con.setSql("select nomeProduto from produto where nomeProduto = '" + var.getNome()+"'");
			con.setAcao(con.getConexao().prepareStatement(con.getSql()));
			con.setResultado(con.getAcao().executeQuery());
			
			while (con.getResultado().next()) {
				nomes.add(con.getResultado().getString("nomeProduto"));
			}

			int aux = nomes.indexOf(var.getNome());

			if (aux == 0) {

				con.setSql("delete from produto where nomeProduto = '"+var.getNome()+"'");
				con.setAcao(con.getConexao().prepareStatement(con.getSql()));
				con.getAcao().executeUpdate();
				JOptionPane.showMessageDialog(null, "Produto deletado com sucesso", "Produto deletado!", JOptionPane.PLAIN_MESSAGE);
				listarDados();
			}else{
				JOptionPane.showMessageDialog(null, "Digite um  nome existente", "Nome inexistente", JOptionPane.WARNING_MESSAGE);
			}
		}
	}
	
	public void editarProdutoId() throws SQLException{
		try{	
			Conexao con = new Conexao();
			var.setId(tf_inserir.getText());
			var.setNome(tf_nome.getText());
			var.setQuantidade(tf_quantidade.getText());
			var.setPreco(tf_preco.getText());
			var.setMarca(tf_marca.getText());
			var.setDescricao(tf_descricao.getText());
			var.setTamanho(tf_tamanho.getText());
			var.setUnidade(tf_unidade.getText());
			if(var.getId().equals("")){
				JOptionPane.showMessageDialog(null, "Insira um id", "Insira um id", JOptionPane.WARNING_MESSAGE);
			}else{
				if(var.getNome().equals("") || var.getQuantidade().equals("") || var.getPreco().equals("") || var.getMarca().equals("") 
						|| var.getDescricao().equals("") || var.getTamanho().equals("")) {
					JOptionPane.showMessageDialog(null, "Preencha todos os campos", "Preencha todos os campos", JOptionPane.WARNING_MESSAGE);
				} else{
					ArrayList<String> ids = new ArrayList<>();
					
					con.setSql("SELECT idProduto FROM PRODUTO where idProduto = " + var.getId());
					con.setAcao(con.getConexao().prepareStatement(con.getSql()));
					con.setResultado(con.getAcao().executeQuery());
					
					while (con.getResultado().next()) {
						ids.add(con.getResultado().getString("idProduto"));
					}
		
					int aux = ids.indexOf(var.getId());
		
					if (aux == 0) {
					
						con.setSql("update produto set nomeProduto = '" + var.getNome()+ "', quantidade= '" + var.getQuantidade() + "', preco = '" + var.getPreco() + "', marca = "
									+ "'" + var.getMarca() + "', descricao = '" + var.getDescricao() + "', tamanho = '" + var.getTamanho() + "',"
									+ " unidade = '"+var.getUnidade()+"' where idProduto ='"+var.getId()+"'");
						con.setAcao(con.getConexao().prepareStatement(con.getSql()));
						con.getAcao().executeUpdate();
						JOptionPane.showMessageDialog(null, "Produto atualizado com sucesso", "Produto atualizado!", JOptionPane.PLAIN_MESSAGE);
						listarDados();
					}else{
						JOptionPane.showMessageDialog(null, "Digite um  id existente", "Id inexistente", JOptionPane.WARNING_MESSAGE);
					}
				}
			}
		}catch(Exception e){
			JOptionPane.showMessageDialog(null, "Digite apenas números inteiros", "Valor inválido", JOptionPane.WARNING_MESSAGE);
		}
	}
	public void editarProdutoNome() throws SQLException{
		Conexao con = new Conexao();
		Produto p = new Produto();
		p.setNome(tf_inserir.getText());
		var.setNome(tf_nome.getText());
		var.setQuantidade(tf_quantidade.getText());
		var.setPreco(tf_preco.getText());
		var.setMarca(tf_marca.getText());
		var.setDescricao(tf_descricao.getText());
		var.setTamanho(tf_tamanho.getText());
		if(p.getNome().equals("")){
			JOptionPane.showMessageDialog(null, "Insira um nome", "Insira um nome", JOptionPane.WARNING_MESSAGE);
		}else{
			if(var.getNome().equals("") || var.getQuantidade().equals("") || var.getPreco().equals("") || var.getMarca().equals("") || var.getDescricao().equals("") || var.getTamanho().equals("")) {
				JOptionPane.showMessageDialog(null, "Preencha todos os campos", "Preencha todos os campos", JOptionPane.WARNING_MESSAGE);
			} else{
				ArrayList<String> nomes = new ArrayList<>();
				
				con.setSql("select nomeProduto from produto where nomeProduto = '" + p.getNome()+"'");
				con.setAcao(con.getConexao().prepareStatement(con.getSql()));
				con.setResultado(con.getAcao().executeQuery());
				
				while (con.getResultado().next()) {
					nomes.add(con.getResultado().getString("nomeProduto"));
				}

				int aux = nomes.indexOf(p.getNome());

				if (aux == 0) {
				
					con.setSql("update produto set nomeProduto = '" + var.getNome()+ "', quantidade= '" + var.getQuantidade() + "', preco = '" + var.getPreco() + "', marca = "
								+ "'" + var.getMarca() + "', descricao = '" + var.getDescricao() + "', tamanho = '" + var.getTamanho() + "', unidade = '"+var.getUnidade()+"'"
								+ " where nomeProduto = '"+p.getNome()+"'");
					con.setAcao(con.getConexao().prepareStatement(con.getSql()));
					con.getAcao().executeUpdate();
					JOptionPane.showMessageDialog(null, "Produto atualizado com sucesso", "Produto atualizado!", JOptionPane.PLAIN_MESSAGE);
					listarDados();
				}else{
					JOptionPane.showMessageDialog(null, "Digite um  nome existente", "Nome inexistente", JOptionPane.WARNING_MESSAGE);
				}
			}
		}
	}
}
