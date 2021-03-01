package Trabalho_Software;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import Atendente.Conexao;

public class Informacoes_do_fornecedor extends JFrame {
	
	Funcionario var = new Funcionario();

	private JPanel contentPane;
	private JTable table;
	private JTextField id;
	private JTextField eEndereco;
	private JTextField eCidade;
	private JTextField eUf;
	private JTextField eEmail;
	private JTextField eTelefone;
	private JTextField eBairro;
	private JTextField eDenominacao_social;
	private JTextField eCnpj;
	private JTextField eTipoFornecedor;
	private JTextField eCep;
	Fornecedor f = new Fornecedor();

	/**
	 * Launch the application.
	 */
	public void InformacoesFornecedor() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Informacoes_do_fornecedor frame = new Informacoes_do_fornecedor();
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
	public Informacoes_do_fornecedor() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1110, 800);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(38, 504, 1092, 234);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.setFont(new Font("Tahoma", Font.PLAIN, 14));
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null, null, null, null, null, null},
			},
			new String[] {
				"Id", "Denomina\u00E7\u00E3o social", "Email", "CNPJ", "TipoFornecedor", "Cidade", "Bairro", "CEP", "Telefone", "UF"
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
		
		eEndereco = new JTextField();
		eEndereco.setBounds(142, 294, 435, 33);
		contentPane.add(eEndereco);
		eEndereco.setColumns(10);
		
		eCidade = new JTextField();
		eCidade.setBounds(501, 355, 255, 32);
		contentPane.add(eCidade);
		eCidade.setColumns(10);
		
		eUf = new JTextField();
		eUf.setBounds(866, 355, 151, 33);
		contentPane.add(eUf);
		eUf.setColumns(10);
		
		eEmail = new JTextField();
		eEmail.setBounds(655, 294, 362, 33);
		contentPane.add(eEmail);
		eEmail.setColumns(10);
		
		eTelefone = new JTextField();
		eTelefone.setBounds(716, 235, 301, 33);
		contentPane.add(eTelefone);
		eTelefone.setColumns(10);
		
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
		
		eBairro = new JTextField();
		eBairro.setBounds(297, 355, 145, 33);
		contentPane.add(eBairro);
		eBairro.setColumns(10);
		
		eDenominacao_social = new JTextField();
		eDenominacao_social.setBounds(299, 235, 309, 33);
		contentPane.add(eDenominacao_social);
		eDenominacao_social.setColumns(10);
		
		JButton btnAtualizar = new JButton("Atualizar");
		btnAtualizar.setBackground(new Color(247, 144, 139));
		btnAtualizar.setForeground(Color.WHITE);
		btnAtualizar.setFont(new Font("Cheap Potatoes Black Thin", Font.BOLD, 12));
		btnAtualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				switch(JOptionPane.showConfirmDialog(null, "Deseja realmente atualizar as informações do fornecedor?", "Atualizar fornecedor?", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE)){
					case 0: 
						atualizar();
					break;
					case 1:
						JOptionPane.showMessageDialog(null, "Nenhum fornecedor foi atualizado", "Nenhum fornecedor atualizado", JOptionPane.INFORMATION_MESSAGE);
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
					demite();
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
		
		eCnpj = new JTextField();
		eCnpj.setBounds(592, 412, 86, 20);
		contentPane.add(eCnpj);
		eCnpj.setColumns(10);
		
		eTipoFornecedor = new JTextField();
		eTipoFornecedor.setBounds(735, 398, 86, 20);
		contentPane.add(eTipoFornecedor);
		eTipoFornecedor.setColumns(10);
		
		eCep = new JTextField();
		eCep.setBounds(501, 398, 86, 20);
		contentPane.add(eCep);
		eCep.setColumns(10);
		
		
	}
	//aqui acontece a atualização das informações do usuario
	public void atualizar() {
		try {
			Conexao con = new Conexao();
			String cpfAux = "";
			f.setId(id.getText());
			
			con.setSql("SELECT *FROM fornecedor WHERE id = '"+var.getId()+"'");
			con.setAcao(con.getConexao().prepareStatement(con.getSql()));
			con.setResultado(con.getAcao().executeQuery());
			while(con.getResultado().next()) {
				cpfAux = con.getResultado().getString(("cnpj"));
			}
			
			f.setId(id.getText());
			f.setNomeSocial(eDenominacao_social.getText());
			f.setCnpj(eCnpj.getText());
			f.setUf(eUf.getText());
			f.setEmail(eEmail.getText());
			f.setTelefone((eTelefone.getText()));
			f.setBairro(eBairro.getText());
			f.setCep(eCep.getText());
			f.setTipoFornecedor(eTipoFornecedor.getText());
			f.setCidade(eCidade.getText());
			f.setEndereco(eEndereco.getText());

			
			//System.out.println(rgAux);
			//System.out.println(var.getRg());
			
				
			
				con.setSql("UPDATE fornecedor SET denominacao_social = '" + f.getNomeSocial() + "', cnpj = '" + f.getCnpj() + "', email = '"+f.getEmail()+"',"
						+ "uf = '"+f.getUf()+"', cidade = '"+f.getCidade()+"', telefone = '"+f.getTelefone()+"',"
								+ "bairro = '"+f.getBairro()+"', cep = '"+f.getCep()+"', tipoFornecedor = '"+f.getTipoFornecedor()+"',endereco = '"+f.getEndereco()+"' WHERE id = '"+ f.getId() +"'");
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
			

			f.setId(id.getText());
			
			con.setSql("DELETE FROM fornecedor WHERE id = '"+var.getId()+"'");
			con.setAcao(con.getConexao().prepareStatement(con.getSql()));
			con.getAcao().executeUpdate();
			
			
			
			
		}catch(Exception erro) {
			System.out.println(erro);
		}
	}
	
	//aqui é o metódo que exibe as informações nos JtextField
	public void Exibicao() {
		
		f.setId(id.getText());
		f.setNomeSocial(eDenominacao_social.getText());
		f.setCnpj(eCnpj.getText());
		f.setUf(eUf.getText());
		f.setEmail(eEmail.getText());
		f.setTelefone((eTelefone.getText()));
		f.setBairro(eBairro.getText());
		f.setCep(eCep.getText());
		f.setTipoFornecedor(eTipoFornecedor.getText());
		f.setCidade(eCidade.getText());
		f.setEndereco(eEndereco.getText());

		
		
		try {
		
			Conexao con = new Conexao();
			//aqui seleciona o vendedor pelo id informado
			con.setSql("SELECT *FROM fornecedor WHERE id='" + var.getId() + "'");
			con.setAcao(con.getConexao().prepareStatement(con.getSql()));
			con.setResultado(con.getAcao().executeQuery());
			//variaveis para receber o valor do banco de dados
			String nomeSocial = "";
			String email = "";
			String cnpj = "";
			String telefone = "";
			String bairro = "";
			String cep = "";
			String tipoFornecedor = "";
			String cidade = "";
			String uf = "";
			String endereco = "";
		
			while (con.getResultado().next()) {
				//aqui está chamando as variaveis criadas acima para elas receberem os valores da tabela vendedor
				nomeSocial = con.getResultado().getString("denominacao_social");
				cnpj = con.getResultado().getString("cnpj");
				email = con.getResultado().getString("email");
				tipoFornecedor = con.getResultado().getString("tipoFornecedor");
				cidade = con.getResultado().getString("cidade");
				bairro = con.getResultado().getString("bairro");
				cep = con.getResultado().getString("cep");
				endereco = con.getResultado().getString("endereco");
				uf = con.getResultado().getString("uf");
				telefone = con.getResultado().getString("telefone");
			}
		
			
			eTelefone.setText(telefone);
			eEndereco.setText(endereco);
			eCidade.setText(cidade);
			eUf.setText(uf);
			eEmail.setText(email);
			eBairro.setText(bairro);
			eDenominacao_social.setText(nomeSocial);
			eTipoFornecedor.setText(tipoFornecedor);
			eCep.setText(cep);
			eCnpj.setText(cnpj);
			
		} catch (Exception erro) {
			System.out.println(erro);
		}
	}

	
	
	//Aqui lista os dados do Jtable, com as informações das tabelas vendedor e login
	public void listarDados() {
		try {
			
			Conexao con = new Conexao();
			
			con.setSql("Select *from fornecedor");
			con.setAcao(con.getConexao().prepareStatement(con.getSql()));
			con.setResultado(con.getAcao().executeQuery());
			
			DefaultTableModel modelo = (DefaultTableModel) table.getModel();
			modelo.setNumRows(0);
			
			while(con.getResultado().next()) {
				
				modelo.addRow(new Object[] {con.getResultado().getString("id"),con.getResultado().getString("denominacao_social"),
						con.getResultado().getString("email"),con.getResultado().getString("cnpj"),con.getResultado().getString("tipoFornecedor"),
						con.getResultado().getString("cidade"),con.getResultado().getString("bairro"),con.getResultado().getString("cep"),
						con.getResultado().getString("telefone"),con.getResultado().getString("uf")});
			}
			
			con.getResultado().close();
			
		}catch(Exception erro) {
			
		}
		
	}
}
