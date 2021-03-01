package Atendente;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.AbstractAction;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.KeyStroke;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import Relatorios.NotaFiscal;
import Relatorios.TelaNotaFiscal;
import Trabalho_Software.Funcionario;
import Trabalho_Software.Menu;

public class Venda extends JFrame {

	private JPanel contentPane;
	private static JTextField tf_cpfCliente;
	private JTextField tf_nomeCliente;
	private JTextField tf_nomeVendedor;
	private JTextField tf_numeroVendas;
	private JTextField tf_meta;
	private static JTextField tf_idProduto;
	private JTextField tf_nomeProduto;
	private JTextField tf_preco;
	private JTextField tf_estoque;
	private JTextField tf_quantidade;
	private JTextField tf_dataCompra;
	private JTextField tf_valorTotal;
	private JTable table;
	Produto p = new Produto();
	Cliente c = new Cliente();
	Funcionario f = new Funcionario();
	ItensNotaFiscal nf = new ItensNotaFiscal();
	private JTextField tf_numCompra;
	private JTextField tf_unidade;
	private static JTextField tf_cpfVendedor;
	String [] id;
	int enter = 0;
	private static JTextField tf_sessao;

	/**
	 * Launch the application.
	 */
	public void vender() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Venda frame = new Venda();
					frame.setVisible(true);
					iniciaSessao();
				} catch (Exception e) {
					System.out.println("erro: " + e);
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Venda() {
		setTitle("Venda de produtos");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 1100, 800);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 1082, 753);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnVoltar.setForeground(Color.WHITE);
		btnVoltar.setBackground(SystemColor.activeCaption);
		btnVoltar.setBounds(21, 716, 142, 24);
		panel.add(btnVoltar);
		
		JButton btnEfetuarCompra = new JButton("Efetuar compra");
		btnEfetuarCompra.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnEfetuarCompra.setForeground(Color.WHITE);
		btnEfetuarCompra.setBackground(SystemColor.activeCaption);
		btnEfetuarCompra.setBounds(881, 716, 142, 24);
		panel.add(btnEfetuarCompra);
		
		tf_cpfCliente = new JTextField();
		tf_cpfCliente.setBounds(336, 130, 90, 20);
		panel.add(tf_cpfCliente);
		tf_cpfCliente.setColumns(10);
		
		tf_nomeCliente = new JTextField();
		tf_nomeCliente.setEditable(false);
		tf_nomeCliente.setForeground(Color.BLACK);
		tf_nomeCliente.setBounds(554, 130, 498, 20);
		tf_nomeCliente.setBackground(Color.WHITE);
		tf_nomeCliente.setColumns(10);
		panel.add(tf_nomeCliente);
		
		tf_nomeVendedor = new JTextField();
		tf_nomeVendedor.setEditable(false);
		tf_nomeVendedor.setForeground(Color.BLACK);
		tf_nomeVendedor.setBounds(564, 179, 90, 20);
		tf_nomeVendedor.setColumns(10);
		tf_nomeVendedor.setBackground(Color.WHITE);
		panel.add(tf_nomeVendedor);
		
		tf_numeroVendas = new JTextField();
		tf_numeroVendas.setEditable(false);
		tf_numeroVendas.setBounds(747, 179, 105, 20);
		tf_numeroVendas.setForeground(Color.BLACK);
		tf_numeroVendas.setColumns(10);
		tf_numeroVendas.setBackground(Color.WHITE);
		panel.add(tf_numeroVendas);
		
		tf_meta = new JTextField();
		tf_meta.setEditable(false);
		tf_meta.setForeground(Color.BLACK);
		tf_meta.setBounds(962, 179, 90, 20);
		tf_meta.setColumns(10);
		tf_meta.setBackground(Color.WHITE);
		panel.add(tf_meta);
		
		tf_idProduto = new JTextField();
		tf_idProduto.setBounds(336, 227, 90, 20);
		tf_idProduto.setColumns(10);
		panel.add(tf_idProduto);
		
		tf_nomeProduto = new JTextField();
		tf_nomeProduto.setEditable(false);
		tf_nomeProduto.setForeground(Color.BLACK);
		tf_nomeProduto.setBounds(554, 228, 96, 20);
		tf_nomeProduto.setColumns(10);
		tf_nomeProduto.setBackground(Color.WHITE);
		panel.add(tf_nomeProduto);
		
		tf_preco = new JTextField();
		tf_preco.setEditable(false);
		tf_preco.setBounds(702, 228, 81, 20);
		tf_preco.setColumns(10);
		tf_preco.setBackground(Color.WHITE);
		panel.add(tf_preco);
		
		tf_estoque = new JTextField();
		tf_estoque.setEditable(false);
		tf_estoque.setForeground(Color.BLACK);
		tf_estoque.setBounds(962, 228, 90, 20);
		tf_estoque.setColumns(10);
		tf_estoque.setBackground(Color.WHITE);
		panel.add(tf_estoque);
		
		tf_quantidade = new JTextField();
		tf_quantidade.setBounds(336, 280, 90, 20);
		tf_quantidade.setColumns(10);
		panel.add(tf_quantidade);
		
		tf_dataCompra = new JTextField();
		tf_dataCompra.setEditable(false);
		tf_dataCompra.setForeground(Color.BLACK);
		tf_dataCompra.setBounds(546, 280, 148, 20);
		tf_dataCompra.setColumns(10);
		tf_dataCompra.setBackground(Color.WHITE);
		panel.add(tf_dataCompra);
		
		tf_valorTotal = new JTextField();
		tf_valorTotal.setEditable(false);
		tf_valorTotal.setForeground(Color.BLACK);
		tf_valorTotal.setBounds(786, 280, 266, 20);
		tf_valorTotal.setColumns(10);
		tf_valorTotal.setBackground(Color.WHITE);
		panel.add(tf_valorTotal);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 415, 1082, 288);
		panel.add(scrollPane);
		
		table = new JTable();
		table.setFont(new Font("Tahoma", Font.PLAIN, 14));
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null, null, null},
			},
			new String[] {
				"Id", "Cliente", "Vendedor", "Nome do produto", "Qtd comprada", "Valor total", "Data da compra"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false, false, false, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		table.getColumnModel().getColumn(0).setPreferredWidth(31);
		table.getColumnModel().getColumn(1).setPreferredWidth(190);
		table.getColumnModel().getColumn(2).setPreferredWidth(190);
		table.getColumnModel().getColumn(3).setPreferredWidth(189);
		table.getColumnModel().getColumn(4).setPreferredWidth(114);
		table.getColumnModel().getColumn(5).setPreferredWidth(136);
		table.getColumnModel().getColumn(6).setPreferredWidth(245);
		scrollPane.setViewportView(table);
		
		JButton btnInserirItem = new JButton("Inserir item");
		btnInserirItem.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnInserirItem.setForeground(Color.WHITE);
		btnInserirItem.setBackground(SystemColor.activeCaption);
		btnInserirItem.setBounds(583, 716, 142, 24);
		panel.add(btnInserirItem);
		
		JButton btnExcluirItem = new JButton("Excluir item");
		btnExcluirItem.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnExcluirItem.setForeground(Color.WHITE);
		btnExcluirItem.setBackground(SystemColor.activeCaption);
		btnExcluirItem.setBounds(336, 716, 142, 24);
		panel.add(btnExcluirItem);
		
		tf_numCompra = new JTextField();
		tf_numCompra.setEditable(false);
		tf_numCompra.setForeground(Color.BLACK);
		tf_numCompra.setColumns(10);
		tf_numCompra.setBackground(Color.WHITE);
		tf_numCompra.setBounds(174, 341, 116, 20);
		panel.add(tf_numCompra);
		
		tf_unidade = new JTextField();
		tf_unidade.setEditable(false);
		tf_unidade.setForeground(Color.BLACK);
		tf_unidade.setColumns(10);
		tf_unidade.setBackground(Color.WHITE);
		tf_unidade.setBounds(815, 228, 75, 20);
		panel.add(tf_unidade);
		
		tf_cpfVendedor = new JTextField();
		tf_cpfVendedor.setColumns(10);
		tf_cpfVendedor.setBounds(336, 181, 90, 20);
		panel.add(tf_cpfVendedor);

		tf_sessao= new JTextField();
		tf_sessao.setEditable(false);
		tf_sessao.setForeground(Color.BLACK);
		tf_sessao.setBackground(Color.WHITE);
		tf_sessao.setBounds(936, 341, 116, 20);
		panel.add(tf_sessao);
		tf_sessao.setColumns(10);		
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon("C:\\Users\\Thiago\\workspace\\bird_shoes\\src\\Trabalho_Software\\Imagens\\VENDAS8.png"));
		label.setBounds(0, 0, 1082, 753);
		panel.add(label);
		
		btnEfetuarCompra.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					comprar(arg0);
				}catch(Exception erro) {
					
					System.out.println(erro);
				}
			}
		});
		
		btnInserirItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				switch(JOptionPane.showConfirmDialog(null, "Deseja realmente incluir esse produto?", "Incluir produto?", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE)){
					case 0: 
						try{
							inserirItem();
						}catch(Exception erro){
							System.out.println(erro);
						}
					break;
					case 1:
						JOptionPane.showMessageDialog(null, "Nenhum item foi inserido - qtd: " + p.getQuantidade(), "Nenhum produto inserido", JOptionPane.INFORMATION_MESSAGE);
					break;
				}
			}
		});
		
		btnExcluirItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					excluirItem();
				}catch(Exception erro) {
					
					System.out.println(erro);
				}
			}
		});
		
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					apagaSessao();
					dispose();
					Menu m = new Menu();
					m.menu();
				}catch(Exception erro) {
					
					System.out.println(erro);
				}
			}
		});
		
		getRootPane().getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(
			    KeyStroke.getKeyStroke(KeyEvent.VK_F1, 0), "pesquisaClientes"
			);     

		getRootPane().getActionMap().put("pesquisaClientes", new AbstractAction() {
		    @Override
		    public void actionPerformed(ActionEvent e) {
		    	Pesquisa_de_clientes cliente = new Pesquisa_de_clientes();
		    	cliente.recebeCampos(tf_cpfCliente.getText(), tf_cpfVendedor.getText(), tf_idProduto.getText(), tf_sessao.getText());
            	setCpfCliente(tf_cpfCliente.getText());
            	setCpfVendedor(tf_cpfVendedor.getText());
            	setIdProduto(tf_idProduto.getText());
            	setSessao(tf_sessao.getText());
				cliente.setVisible(true);
		    	dispose();
		    }
		});
		
		getRootPane().getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(
			    KeyStroke.getKeyStroke(KeyEvent.VK_F2, 0), "pesquisaVendedor"
			);     

		getRootPane().getActionMap().put("pesquisaVendedor", new AbstractAction() {
		    @Override
		    public void actionPerformed(ActionEvent e) {
		    	Pesquisa_de_vendedores vendedor = new Pesquisa_de_vendedores();
		    	vendedor.recebeCampos(tf_cpfCliente.getText(), tf_cpfVendedor.getText(), tf_idProduto.getText(), tf_sessao.getText());
            	setCpfCliente(tf_cpfCliente.getText());
            	setCpfVendedor(tf_cpfVendedor.getText());
            	setIdProduto(tf_idProduto.getText());
            	setSessao(tf_sessao.getText());
				vendedor.setVisible(true);
		    	dispose();
		    }
		});
		
		getRootPane().getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(
			    KeyStroke.getKeyStroke(KeyEvent.VK_F3, 0), "pesquisaProduto"
			);     

		getRootPane().getActionMap().put("pesquisaProduto", new AbstractAction() {
		    @Override
		    public void actionPerformed(ActionEvent e) {
		    	Pesquisa_de_produtos produto = new Pesquisa_de_produtos();
            	produto.recebeCampos(tf_cpfCliente.getText(), tf_cpfVendedor.getText(), tf_idProduto.getText(), tf_sessao.getText());
            	setCpfCliente(tf_cpfCliente.getText());
            	setCpfVendedor(tf_cpfVendedor.getText());
            	setIdProduto(tf_idProduto.getText());
            	setSessao(tf_sessao.getText());
				produto.setVisible(true);
		    	dispose();
		    }
		});
		
	}
	public void setCpfCliente(String cpf) {
	    this.tf_cpfCliente.setText(cpf);
	}
	public String getCpfCliente() {
	    return tf_cpfCliente.getText();
	}
	public void setCpfVendedor(String cpf) {
		this.tf_cpfVendedor.setText(cpf);
	}
	public String getCpfVendedor() {
	    return tf_cpfVendedor.getText();
	}
	public void setIdProduto(String id) {
		this.tf_idProduto.setText(id);
	}
	public String getIdProduto() {
	    return tf_idProduto.getText();
	}
	public void setSessao(String sessao) {
		this.tf_sessao.setText(sessao);
	}
	public String getSessao() {
	    return tf_sessao.getText();
	}
	
	public void iniciaSessao() {
		try {
			Conexao con = new Conexao();
			con.setSql("INSERT INTO sessaoCompra(dataEntrada) VALUES(now())");
			con.setAcao(con.getConexao().prepareStatement(con.getSql()));
			con.getAcao().executeUpdate();
			con.setSql("SELECT * FROM sessaoCompra WHERE dataEntrada = now()");
			con.setAcao(con.getConexao().prepareStatement(con.getSql()));
			con.setResultado(con.getAcao().executeQuery());
			while(con.getResultado().next()) {
				tf_sessao.setText(con.getResultado().getString("id"));  
			}
			con.getResultado().close();
		}catch(Exception erro) {
			System.out.println(erro);
		}
	}
	
	public void pesquisarProduto() {
		try {
			Conexao con = new Conexao();
			p.setId(tf_idProduto.getText());
			con.setSql("Select nomeProduto, preco, quantidade from produto where idproduto = '"+p.getId()+"'");
			con.setAcao(con.getConexao().prepareStatement(con.getSql()));
			con.setResultado(con.getAcao().executeQuery());
			
			while(con.getResultado().next()) {
				tf_nomeProduto.setText(con.getResultado().getString("nomeProduto"));  
				tf_preco.setText(con.getResultado().getString("preco")); 
				tf_estoque.setText(con.getResultado().getString("quantidade"));
			}
			con.getResultado().close();
		}catch(Exception erro) {
			System.out.println(erro);
		}
	}
	
	public void listarDados() {
		try {
			Conexao con = new Conexao();
			con.setSql("Select pc.id, c.nome, a.nome, p.nomeProduto, pc.qtdComprada, pc.precoTotal, pc.dataCompra, s.dataEntrada from produtosComprados as pc "
					+ "inner join produto as p inner join cliente as c inner join atendente as a inner join sessaoCompra as s where pc.idProduto = p.idProduto && pc.idCliente = c.id "
					+ "&& pc.idVendedor = a.id && s.id = pc.idSessaoCompra && s.id = '"+getSessao()+"'");	
			con.setAcao(con.getConexao().prepareStatement(con.getSql()));
			con.setResultado(con.getAcao().executeQuery());
			
			DefaultTableModel modelo = (DefaultTableModel) table.getModel();
			modelo.setNumRows(0);
			while(con.getResultado().next()) {
				modelo.addRow(new Object[] {con.getResultado().getString("pc.id"),con.getResultado().getString("c.nome"),
						con.getResultado().getString("a.nome"),con.getResultado().getString("p.nomeProduto"),con.getResultado().getString("pc.qtdComprada"),
						con.getResultado().getString("pc.precoTotal"),con.getResultado().getString("pc.dataCompra")});
			}
			con.getResultado().close();
		}catch(Exception erro) {
			System.out.println(erro);
		}
	}
	
	public void inserirItem(){
		try {
			Conexao con = new Conexao();
			c.setCpf(tf_cpfCliente.getText());
			f.setCpf(tf_cpfVendedor.getText());
			p.setId(tf_idProduto.getText());
			nf.setQtdComprada(tf_quantidade.getText());
			if(c.getCpf().equals("") || f.getCpf().equals("") || nf.getQtdComprada().equals("")) {
				JOptionPane.showMessageDialog(null, "Preencha todos os campos obrigatórios", "Preencha todos os campos", JOptionPane.WARNING_MESSAGE);
			}else{
				ArrayList<String> cpfCliente = new ArrayList<>();
				
				con.setSql("SELECT cpf FROM cliente WHERE cpf = '" + c.getCpf() + "'");
				con.setAcao(con.getConexao().prepareStatement(con.getSql()));
				con.setResultado(con.getAcao().executeQuery());
	
				while (con.getResultado().next()) {
					cpfCliente.add(con.getResultado().getString("cpf"));
				}
	
				int auxC = cpfCliente.indexOf(c.getCpf());
				
				if (auxC == 0) {
					
					ArrayList<String> cpfVendedor = new ArrayList<>();
					
					con.setSql("SELECT cpf FROM atendente WHERE cpf = '" + f.getCpf() + "'");
					con.setAcao(con.getConexao().prepareStatement(con.getSql()));
					con.setResultado(con.getAcao().executeQuery());
					
					while (con.getResultado().next()) {
						cpfVendedor.add(con.getResultado().getString("cpf"));
					}
					int auxV = cpfVendedor.indexOf(f.getCpf());
					if(auxV == 0) {
					
						ArrayList<String> idProduto = new ArrayList<>();
						
						con.setSql("SELECT idProduto FROM produto WHERE idProduto = '" + p.getId() + "'");
						con.setAcao(con.getConexao().prepareStatement(con.getSql()));
						con.setResultado(con.getAcao().executeQuery());
						
						while (con.getResultado().next()) {
							idProduto.add(con.getResultado().getString("idProduto"));
						}
						int auxP = idProduto.indexOf(p.getId());
						if(auxP == 0) {
							try {
								con.setSql("SELECT c.id, c.nome, a.id, a.nome, a.meta, a.numeroVendas, p.nomeProduto, p.preco, p.quantidade, p.unidade FROM cliente as c, atendente as a, "
										+ "produto as p WHERE c.cpf = '" + c.getCpf() + "' && a.cpf = '" + f.getCpf() + "' && p.idProduto = '"+p.getId()+"'");
								con.setAcao(con.getConexao().prepareStatement(con.getSql()));
								con.setResultado(con.getAcao().executeQuery());
		
								while (con.getResultado().next()) {
									c.setId(con.getResultado().getString("c.id"));
									c.setNome(con.getResultado().getString("c.nome"));
									f.setId(con.getResultado().getString("a.id"));
									f.setNome(con.getResultado().getString("a.nome"));
									f.setMeta(con.getResultado().getString("a.meta"));
									f.setNumeroVendas(String.valueOf(con.getResultado().getString("a.numeroVendas")));
									p.setNome(con.getResultado().getString("p.nomeProduto"));
									p.setPreco(con.getResultado().getString("p.preco"));
									p.setQuantidade(con.getResultado().getString("p.quantidade"));
									p.setUnidade(con.getResultado().getString("p.unidade"));
									
									int quantidadeAux = Integer.parseInt(con.getResultado().getString("p.quantidade")) - (Integer.parseInt(nf.getQtdComprada()));
									con.setSql("update produto set quantidade = '"+quantidadeAux+ "' where idProduto = '"+p.getId()+"'");
									con.setAcao(con.getConexao().prepareStatement(con.getSql()));
									con.getAcao().executeUpdate();
									
									float precoTotalAux = Float.valueOf(p.getPreco()) * Integer.parseInt(nf.getQtdComprada());
									nf.setPrecoTotal(String.valueOf(precoTotalAux));
								} 
								try{
									if(Integer.parseInt(nf.getQtdComprada()) > Integer.parseInt(p.getQuantidade())){
										JOptionPane.showMessageDialog(null, "Existem apenas "+p.getQuantidade()+" "+p.getNome()+" no estoque", "Estoque insuficiente", 
										JOptionPane.WARNING_MESSAGE);
									}else{
										tf_nomeCliente.setText(c.getNome());
										tf_nomeVendedor.setText(f.getNome());
										tf_numeroVendas.setText(f.getNumeroVendas());
										tf_meta.setText(f.getMeta());
										tf_nomeProduto.setText(p.getNome());
										tf_preco.setText(p.getPreco());
										tf_estoque.setText(p.getQuantidade());
										tf_unidade.setText(p.getUnidade());
										tf_valorTotal.setText(nf.getPrecoTotal());
										DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss:00"); 
										Date data = new Date(System.currentTimeMillis());
										tf_dataCompra.setText(String.valueOf(dateFormat.format(data)));
										setSessao(tf_sessao.getText());
										
										con.setSql("INSERT INTO produtoscomprados(idProduto, qtdComprada, idCliente, idVendedor, precoTotal, idSessaoCompra) VALUES('"+p.getId()+"',"
												+ " '"+nf.getQtdComprada()+"','"+c.getId()+"','"+f.getId()+"','"+nf.getPrecoTotal()+"','"+getSessao()+"')");
										con.setAcao(con.getConexao().prepareStatement(con.getSql()));
										con.getAcao().executeUpdate();
										
										con.setSql("update produto as p, sessaoCompra as s set p.quantidade = '"+p.getQuantidade()+"', s.dataSaida = now() where p.idProduto = '"
										+p.getId()+"' && s.id = '"+tf_sessao.getText()+"'");
										con.setAcao(con.getConexao().prepareStatement(con.getSql()));
										con.getAcao().executeUpdate();
										
										con.setSql("SELECT id FROM produtoscomprados WHERE dataCompra = NOW()");
										con.setAcao(con.getConexao().prepareStatement(con.getSql()));
										con.setResultado(con.getAcao().executeQuery());
										
										while (con.getResultado().next()) {
											tf_numCompra.setText(con.getResultado().getString("id"));
										}
										listarDados();
										JOptionPane.showMessageDialog(null, "Produto incluído com sucesso!", "Produto incluído!", JOptionPane.INFORMATION_MESSAGE);
									}
								}catch(Exception erro){
									System.out.println(erro);
								}
							}catch(Exception erro){
								System.out.println(erro);
							}
						}else{
							JOptionPane.showMessageDialog(null, "Produto não existe no sistema", "Produto não está cadastrado", JOptionPane.WARNING_MESSAGE);
						}
					}else{
						JOptionPane.showMessageDialog(null, "Vendedor não existe no sistema", "Vendedor não está cadastrado", JOptionPane.WARNING_MESSAGE);
					}
				}else{
					JOptionPane.showMessageDialog(null, "Cliente não existe no sistema", "Cliente não está cadastrado", JOptionPane.WARNING_MESSAGE);
				}
			}
		}catch(Exception erro){
			JOptionPane.showMessageDialog(null, "Digite apenas números", "Valor inválido", JOptionPane.WARNING_MESSAGE);
			System.out.println("erro "+erro);
		}
	}
	
	public void comprar(ActionEvent arg0){
		switch(JOptionPane.showConfirmDialog(null, "Deseja realmente comprar esse(s) produto(s)?", "Comprar produto(s)?", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE)){
			case 0: 
				JOptionPane.showMessageDialog(null, "Compra efetuada com sucesso!", "Compra realizada", JOptionPane.INFORMATION_MESSAGE);
				try{
					Conexao con = new Conexao();
					con.setSql("SELECT numeroVendas FROM atendente WHERE cpf = '"+tf_cpfVendedor.getText()+"'");
					con.setAcao(con.getConexao().prepareStatement(con.getSql()));
					con.setResultado(con.getAcao().executeQuery());
					while(con.getResultado().next()){
						int numVendas = Integer.parseInt(con.getResultado().getString("numeroVendas")) + 1;
						con.setSql("update atendente set numeroVendas = '"+numVendas+ "' where cpf = '"+tf_cpfVendedor.getText()+"'");
						con.setAcao(con.getConexao().prepareStatement(con.getSql()));
						con.getAcao().executeUpdate();
					}
					con.getResultado().close();
					TelaNotaFiscal nota = new TelaNotaFiscal();
					nota.gerarNota();
					NotaFiscal notaFiscal = new NotaFiscal(tf_sessao);
					notaFiscal.actionPerformed(arg0);
					dispose();
				}catch(Exception e){
					System.out.println("erro: " + e);
				}
			break;
			case 1:
				JOptionPane.showMessageDialog(null, "Nenhum produto foi comprado", "Nenhum produto comprado", JOptionPane.INFORMATION_MESSAGE);
			break;
		}
	}
	
	public void excluirItem(){
		try{	
			Conexao con = new Conexao();
			switch(JOptionPane.showConfirmDialog(null, "Deseja realmente remover esse produto?", "remover produto?", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE)){
				case 0: 
					try{	
						int linha = table.getSelectedRow();
						if(linha > -1){;
							String id = String.valueOf(table.getValueAt(linha, 0));
							con.setSql("SELECT * FROM produtoscomprados WHERE id = '"+id+"'");
							con.setAcao(con.getConexao().prepareStatement(con.getSql()));
							con.setResultado(con.getAcao().executeQuery());
							
							while (con.getResultado().next()) {
								p.setId(con.getResultado().getString("idProduto"));
								nf.setQtdComprada(con.getResultado().getString("qtdComprada"));
							}
							con.getResultado().close();
							con.setSql("SELECT * FROM produto WHERE idProduto = '"+p.getId()+"'");
							con.setAcao(con.getConexao().prepareStatement(con.getSql()));
							con.setResultado(con.getAcao().executeQuery());
							
							while (con.getResultado().next()) {
								int quantidadeAux = Integer.parseInt(con.getResultado().getString("quantidade")) + (Integer.parseInt(nf.getQtdComprada()));
								con.setSql("update produto set quantidade = '"+quantidadeAux+ "' where idProduto = '"+p.getId()+"'");
								con.setAcao(con.getConexao().prepareStatement(con.getSql()));
								con.getAcao().executeUpdate();
							}
							con.setSql("delete from produtoscomprados where id = '"+id+"'");
							con.setAcao(con.getConexao().prepareStatement(con.getSql()));
							con.getAcao().executeUpdate();
							con.getResultado().close();
							JOptionPane.showMessageDialog(null, "Produto removido com sucesso", "Produto removido!", JOptionPane.PLAIN_MESSAGE);
							listarDados();
						}else{
							JOptionPane.showMessageDialog(null, "Selecione uma linha da tabela", "Selecione a linha", JOptionPane.WARNING_MESSAGE);	
						}
					}catch(Exception erro){
						System.out.println(erro);
					}
				break;
				case 1:
					JOptionPane.showMessageDialog(null, "Nenhum produto foi removido", "Nenhum produto removido", JOptionPane.INFORMATION_MESSAGE);
				break;
			}
		}catch(Exception erro){
			System.out.println(erro);
		}
	}
	public void apagaSessao(){
		try {
			Conexao con = new Conexao();
			con.setSql("delete from sessaoCompra where id = '"+tf_sessao.getText()+"'");
			con.setAcao(con.getConexao().prepareStatement(con.getSql()));
			con.getAcao().executeUpdate();
		}catch(Exception erro) {
			System.out.println(erro);
		}
	}
}
