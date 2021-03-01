package Trabalho_Software;

import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;

import javax.swing.AbstractAction;
import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPopupMenu;
import javax.swing.KeyStroke;
import javax.swing.SwingConstants;

import Atendente.Conexao;
import Atendente.Gerenciamento_de_clientes;
import Atendente.Informacoes_dos_produtos;
import Atendente.Menu2;
import Atendente.Venda;
import Relatorios.GerarFuncionarioRelatorio;
import Relatorios.teste;

public class Menu extends javax.swing.JFrame {
	
	private JLabel labelUsuario; 
	Funcionario var = new Funcionario();
	
	Menu2 log = new Menu2(); 
	
	public void menu() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Menu frame = new Menu();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}


	/**
	 * Create the frame.
	 * @param string 
	 */
		
	public Menu() {
		setTitle("Sistema de vendas - Menu");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 972, 900);
		setLocationRelativeTo(null);
		getContentPane().setLayout(null);
		
		labelUsuario = new JLabel(log.getUserLogin());
		labelUsuario.setBounds(853, 80, 185, 16);
		labelUsuario.setBackground(Color.WHITE);
		labelUsuario.setForeground(new Color(70, 130, 180));
		labelUsuario.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 22));
		
		getContentPane().add(labelUsuario);
		
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setForeground(Color.PINK);
		menuBar.setBounds(0, 0, 1082, 56);
		getContentPane().add(menuBar);
		menuBar.setBackground(new Color(247,144,139));
	
		
		JMenu mnHistrico = new JMenu("Gerenciamento");
		mnHistrico.setBackground(new Color(247, 144, 139));
		mnHistrico.setHorizontalAlignment(SwingConstants.CENTER);
		mnHistrico.setForeground(Color.WHITE);
		mnHistrico.setFont(new Font("Cheap Potatoes Black Thin", Font.BOLD, 15));
		menuBar.add(mnHistrico);
		

		JMenuItem mntmGerente = new JMenuItem("Cadastrar gerente F1");
		mntmGerente.setHorizontalAlignment(SwingConstants.CENTER);
		mntmGerente.setForeground(Color.WHITE);
		mntmGerente.setFont(new Font("Cheap Potatoes Black Thin", Font.BOLD, 15));
		mntmGerente.setBackground(Color.PINK);
		mntmGerente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				if(log.getSetorLogin().equals("1")) {
					
						CadastroGerente cade = new CadastroGerente();
			    		cade.cadastro();
						dispose();
					
					
				}else {
					JOptionPane.showMessageDialog(null,"Você não tem autorização para está função");
				}
				
			}
		});
		getRootPane().getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(
			    KeyStroke.getKeyStroke(KeyEvent.VK_F1, 0), "Cadastrar gerente"
			);     

		getRootPane().getActionMap().put("Cadastrar gerente", new AbstractAction() {
		    public void actionPerformed(ActionEvent e) {
		    	
		    	if(log.getSetorLogin().equals("1")) {
					
		    		CadastroGerente cade = new CadastroGerente();
		    		cade.cadastro();
		    		dispose();
		    		
				}else {
					JOptionPane.showMessageDialog(null,"Você não tem autorização para está função");
				}
				    	
		    }
		});
		mnHistrico.add(mntmGerente);
		
		JMenuItem mntClientes = new JMenuItem("Clientes F9");
		mntClientes.setForeground(Color.WHITE);
		mntClientes.setBackground(new Color(247, 144, 139));
		mntClientes.setFont(new Font("Cheap Potatoes Black Thin", Font.BOLD, 15));
		mntClientes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
					Gerenciamento_de_clientes rela = new Gerenciamento_de_clientes();
					rela.gerenciar();
					dispose();			
				
			}
		});
		getRootPane().getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(
			    KeyStroke.getKeyStroke(KeyEvent.VK_F9, 0), "Clientes"
			);     

		getRootPane().getActionMap().put("Clientes", new AbstractAction() {
		    public void actionPerformed(ActionEvent e) {
		    	Gerenciamento_de_clientes rela = new Gerenciamento_de_clientes();
				rela.gerenciar();
				dispose();
		    }
		});
		mnHistrico.add(mntClientes);
		
		
		
		JMenu mntmCadastrarFuncionrio = new JMenu("Funcionarios");
		mntmCadastrarFuncionrio.setBackground(new Color(247,144,139));
		mntmCadastrarFuncionrio.setHorizontalAlignment(SwingConstants.CENTER);
		mntmCadastrarFuncionrio.setForeground(Color.WHITE);
		mntmCadastrarFuncionrio.setFont(new Font("Cheap Potatoes Black Thin", Font.BOLD, 15));
	
		menuBar.add(mntmCadastrarFuncionrio);
		
		JMenuItem mntmCadastrarFuncionrios = new JMenuItem("Cadastrar Funcion\u00E1rios F2");
		mntmCadastrarFuncionrios.setForeground(Color.WHITE);
		mntmCadastrarFuncionrios.setBackground(new Color(247, 144, 139));
		mntmCadastrarFuncionrios.setFont(new Font("Cheap Potatoes Black Thin", Font.BOLD, 15));
		mntmCadastrarFuncionrios.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				if(log.getSetorLogin().equals("1")) {
					
					CadastroFuncionario fun = new CadastroFuncionario();
					fun.cadastrofuncionario();
					dispose();
					
				}else {
					JOptionPane.showMessageDialog(null,"Você não tem autorização para está função");
				}
				
			}
		});
		getRootPane().getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(
			    KeyStroke.getKeyStroke(KeyEvent.VK_F2, 0), "Cadastrar funcionários"
			);     

		getRootPane().getActionMap().put("Cadastrar funcionários", new AbstractAction() {
		    public void actionPerformed(ActionEvent e) {
		    	if(log.getSetorLogin().equals("1")) {
					
					CadastroFuncionario fun = new CadastroFuncionario();
					fun.cadastrofuncionario();
					dispose();
					
				}else {
					JOptionPane.showMessageDialog(null,"Você não tem autorização para está função");
				}
		    }
		});
		mntmCadastrarFuncionrio.add(mntmCadastrarFuncionrios);
		
		JMenuItem mntmVisualizarFuncionrios = new JMenuItem("Visualizar funcion\u00E1rios F3");
		mntmVisualizarFuncionrios.setForeground(Color.WHITE);
		mntmVisualizarFuncionrios.setBackground(new Color(247, 144, 139));
		mntmVisualizarFuncionrios.setFont(new Font("Cheap Potatoes Black Thin", Font.BOLD, 15));
		mntmVisualizarFuncionrios.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				if(log.getSetorLogin().equals("1")) {
					
					Informacoes_dos_funcionarios fun = new Informacoes_dos_funcionarios();
					fun.Informacoes();
					dispose();
				}else {
					JOptionPane.showMessageDialog(null,"Você não tem autorização para está função");
				}
				
				
			}
		});
		getRootPane().getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(
			    KeyStroke.getKeyStroke(KeyEvent.VK_F3, 0), "Visualizar funcionários"
			);     

		getRootPane().getActionMap().put("Visualizar funcionários", new AbstractAction() {
		    public void actionPerformed(ActionEvent e) {
		    	if(log.getSetorLogin().equals("1")) {
					
					Informacoes_dos_funcionarios fun = new Informacoes_dos_funcionarios();
					fun.Informacoes();
					dispose();
				}else {
					JOptionPane.showMessageDialog(null,"Você não tem autorização para está função");
				}
				
		    }
		});
		mntmCadastrarFuncionrio.add(mntmVisualizarFuncionrios);
		
		
		
		JMenu mnFornecedor_1 = new JMenu("Fornecedor");
		mnFornecedor_1.setBackground(new Color(247,144,139));
		mnFornecedor_1.setHorizontalAlignment(SwingConstants.CENTER);
		mnFornecedor_1.setForeground(Color.WHITE);
		mnFornecedor_1.setFont(new Font("Cheap Potatoes Black Thin", Font.BOLD, 15));
		menuBar.add(mnFornecedor_1);
		
		JMenuItem mntmCadastrarFornecedor = new JMenuItem("Cadastrar Fornecedor F4");
		mntmCadastrarFornecedor.setForeground(Color.WHITE);
		mntmCadastrarFornecedor.setBackground(new Color(247, 144, 139));
		mntmCadastrarFornecedor.setFont(new Font("Cheap Potatoes Black Thin", Font.BOLD, 15));
		getRootPane().getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(
			    KeyStroke.getKeyStroke(KeyEvent.VK_F4, 0), "Cadastrar fornecedor"
			);     

		getRootPane().getActionMap().put("Cadastrar fornecedor", new AbstractAction() {
		    public void actionPerformed(ActionEvent e) {
		    	try {
					Conexao con = new Conexao();
					
					if(log.getSetorLogin().equals("1")) {
						Fornecedor rela = new Fornecedor();
						rela.fornecedor();
						dispose();
					}else {
						JOptionPane.showMessageDialog(null, "Você não tem autorização para está função");
					}
					
				} catch (SQLException er) {
					// TODO Auto-generated catch block
					er.printStackTrace();
				}
		    }
		});
		mntmCadastrarFornecedor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				try {
					Conexao con = new Conexao();
					
					if(log.getSetorLogin().equals("1")) {
						Fornecedor rela = new Fornecedor();
						rela.fornecedor();
						dispose();
					}else {
						JOptionPane.showMessageDialog(null, "Você não tem autorização para está função");
					}
					
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
		});
		mnFornecedor_1.add(mntmCadastrarFornecedor);
		
		JMenu mnProduto = new JMenu("Produtos");
		mnProduto.setBackground(new Color(247, 144, 139));
		mnProduto.setHorizontalAlignment(SwingConstants.CENTER);
		mnProduto.setForeground(Color.WHITE);
		mnProduto.setFont(new Font("Cheap Potatoes Black Thin", Font.BOLD, 15));
		menuBar.add(mnProduto);
		
		JMenuItem mntmVisualizarProdutos = new JMenuItem("Visualizar produtos F6");
		mntmVisualizarProdutos.setForeground(Color.WHITE);
		mntmVisualizarProdutos.setBackground(new Color(247, 144, 139));
		mntmVisualizarProdutos.setFont(new Font("Cheap Potatoes Black Thin", Font.BOLD, 15));
		mntmVisualizarProdutos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				if(log.getSetorLogin().equals("1")) {
					
					Informacoes_dos_produtos rela = new Informacoes_dos_produtos();
					rela.produtos();
					dispose();
					
				}else {
					JOptionPane.showMessageDialog(null,"Você não tem autorização para está função");
				}
				
				
			}
		});
		getRootPane().getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(
			    KeyStroke.getKeyStroke(KeyEvent.VK_F6, 0), "Visualizar produto"
			);     

		getRootPane().getActionMap().put("Visualizar produto", new AbstractAction() {
		    public void actionPerformed(ActionEvent e) {
		    	if(log.getSetorLogin().equals("1")) {
					
					Informacoes_dos_produtos rela = new Informacoes_dos_produtos();
					rela.produtos();
					dispose();
					
				}else {
					JOptionPane.showMessageDialog(null,"Você não tem autorização para está função");
				}
		    }
		});
		mnProduto.add(mntmVisualizarProdutos);
		
		JMenuItem mntmCadastrarProduto = new JMenuItem("Cadastrar produto F7");
		mntmCadastrarProduto.setForeground(Color.WHITE);
		mntmCadastrarProduto.setBackground(new Color(247, 144, 139));
		mntmCadastrarProduto.setFont(new Font("Cheap Potatoes Black Thin", Font.BOLD, 15));
		mntmCadastrarProduto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				if(log.getSetorLogin().equals("1")) {
					
					CadastroProduto p = new CadastroProduto();
					p.cadastroProduto();
					dispose();
					
				}else {
					JOptionPane.showMessageDialog(null,"Você não tem autorização para está função");
				}
				
			}
		});
		getRootPane().getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(
			    KeyStroke.getKeyStroke(KeyEvent.VK_F7, 0), "Cadastrar produto"
			);     

		getRootPane().getActionMap().put("Cadastrar produto", new AbstractAction() {
		    public void actionPerformed(ActionEvent e) {
		    	if(log.getSetorLogin().equals("1")) {
					
					CadastroProduto p = new CadastroProduto();
					p.cadastroProduto();
					dispose();
					
				}else {
					JOptionPane.showMessageDialog(null,"Você não tem autorização para está função");
				}
		    }
		});
		mnProduto.add(mntmCadastrarProduto);
		
		JMenu mnComprar = new JMenu("Comprar");
		mnComprar.setBackground(new Color(247, 144, 139));
		mnComprar.setHorizontalAlignment(SwingConstants.CENTER);
		mnComprar.setForeground(Color.WHITE);
		mnComprar.setFont(new Font("Cheap Potatoes Black Thin", Font.BOLD, 15));
		menuBar.add(mnComprar);
		
		
		JMenuItem mntmEfetuarCompra = new JMenuItem("Efetuar compra F8");
		mntmEfetuarCompra.setForeground(Color.WHITE);
		mntmEfetuarCompra.setBackground(new Color(247, 144, 139));
		mntmEfetuarCompra.setFont(new Font("Cheap Potatoes Black Thin", Font.BOLD, 15));
		mntmEfetuarCompra.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
							
					Venda vend = new Venda();
					vend.vender();
					dispose();	
				
			}
		});
		getRootPane().getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(
			    KeyStroke.getKeyStroke(KeyEvent.VK_F8, 0), "Venda"
			);     

		getRootPane().getActionMap().put("Venda", new AbstractAction() {
		    public void actionPerformed(ActionEvent e) {
		    	Venda vend = new Venda();
				vend.vender();
				dispose();
		    }
		});
		mnComprar.add(mntmEfetuarCompra);
		
		JMenu mnHistrico_1 = new JMenu("Hist\u00F3rico");
		mnHistrico_1.setBackground(new Color(247,144,139));
		mnHistrico_1.setHorizontalAlignment(SwingConstants.CENTER);
		mnHistrico_1.setForeground(Color.WHITE);
		mnHistrico_1.setFont(new Font("Cheap Potatoes Black Thin", Font.BOLD, 15));
		menuBar.add(mnHistrico_1);
	
		
		
		JMenuItem mntmHistricoDeAcesso = new JMenuItem("Hist\u00F3rico de Acesso F10");
		mntmHistricoDeAcesso.setHorizontalAlignment(SwingConstants.CENTER);
		mntmHistricoDeAcesso.setBackground(Color.PINK);
		mntmHistricoDeAcesso.setForeground(Color.WHITE);
		mntmHistricoDeAcesso.setFont(new Font("Cheap Potatoes Black Thin", Font.BOLD, 15));
		mntmHistricoDeAcesso.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				if(log.getSetorLogin().equals("1")) {
					
					teste rela = new teste();
					rela.Teste();
					dispose();
					
				}else {
					JOptionPane.showMessageDialog(null,"Você não tem autorização para está função");
				}
				
			}
		});
		getRootPane().getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(
			    KeyStroke.getKeyStroke(KeyEvent.VK_F10, 0), "Histórico de acesso"
			);     

		getRootPane().getActionMap().put("Histórico de acesso", new AbstractAction() {
		    public void actionPerformed(ActionEvent e) {
		    	if(log.getSetorLogin().equals("1")) {
					
					teste rela = new teste();
					rela.Teste();
					dispose();
					
				}else {
					JOptionPane.showMessageDialog(null,"Você não tem autorização para está função");
				}
		    }
		});
				mnHistrico_1.add(mntmHistricoDeAcesso);
				
				JMenuItem mntmHistricofuncionarios = new JMenuItem("Hist\u00F3rico de funcionários F11");
				mntmHistricofuncionarios.setHorizontalAlignment(SwingConstants.CENTER);
				mntmHistricofuncionarios.setBackground(Color.PINK);
				mntmHistricofuncionarios.setForeground(Color.WHITE);
				mntmHistricofuncionarios.setFont(new Font("Cheap Potatoes Black Thin", Font.BOLD, 15));
				getRootPane().getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(
					    KeyStroke.getKeyStroke(KeyEvent.VK_F11, 0), "Histórico de funcionários"
					);     

				getRootPane().getActionMap().put("Histórico de funcionários", new AbstractAction() {
				    public void actionPerformed(ActionEvent e) {
				    	if(log.getSetorLogin().equals("1")) {
							
				    		GerarFuncionarioRelatorio rela = new GerarFuncionarioRelatorio();
							rela.gerar();
							dispose();
							
						}else {
							JOptionPane.showMessageDialog(null,"Você não tem autorização para está função");
						}
				    }
				});
				mntmHistricofuncionarios.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						
						if(log.getSetorLogin().equals("1")) {
							
							GerarFuncionarioRelatorio rela = new GerarFuncionarioRelatorio();
							rela.gerar();
							dispose();
							
						}else {
							JOptionPane.showMessageDialog(null,"Você não tem autorização para está função");
						}
						
					}
				});
				
						mnHistrico_1.add(mntmHistricofuncionarios);
				
				
				
				JMenu mnOpes_1 = new JMenu("Sobre o sistema");
				mnOpes_1.setBackground(new Color(247, 144, 139));
				mnOpes_1.setHorizontalAlignment(SwingConstants.CENTER);
				mnOpes_1.setForeground(Color.WHITE);
				mnOpes_1.setFont(new Font("Cheap Potatoes Black Thin", Font.BOLD, 15));
				menuBar.add(mnOpes_1);
				
				JMenuItem mntmSair = new JMenuItem("Sair");
				mntmSair.setForeground(Color.WHITE);
				mntmSair.setBackground(new Color(247, 144, 139));
				mntmSair.setFont(new Font("Cheap Potatoes Black Thin", Font.BOLD, 15));
				mntmSair.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						try {
							Conexao con = new Conexao();
							
							
							String comportamento = "Saída";
							
							con.setSql("INSERT INTO acessologin(usuario,tipoComportamento,idFuncionario) VALUES('"+log.getUserLogin()+"','"+comportamento+"','"+log.getIdLoginUser()+"')");
							con.setAcao(con.getConexao().prepareStatement(con.getSql()));
							con.getAcao().executeUpdate();
							
							Login login = new Login();
							login.Login();
							dispose();
							
						}catch(Exception erro) {
							JOptionPane.showMessageDialog(null,erro);
						}
					}
				});
				getRootPane().getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(
					    KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), "Logar"
					);     

				getRootPane().getActionMap().put("Logar", new AbstractAction() {
				    public void actionPerformed(ActionEvent e) {
				    	try {
							Conexao con = new Conexao();
							
							
							String comportamento = "Saída";
							
							con.setSql("INSERT INTO acessologin(usuario,tipoComportamento,idFuncionario) VALUES('"+log.getUserLogin()+"','"+comportamento+"','"+log.getIdLoginUser()+"')");
							con.setAcao(con.getConexao().prepareStatement(con.getSql()));
							con.getAcao().executeUpdate();
							
							Login login = new Login();
							login.Login();
							dispose();
							
						}catch(Exception erro) {
							JOptionPane.showMessageDialog(null,erro);
						}
				    }
				});
				mnOpes_1.add(mntmSair);
				
		
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon("C:\\Users\\Thiago\\workspace\\bird_shoes\\src\\Trabalho_Software\\Imagens\\menu2.png"));
		label.setBounds(0, -66, 1082, 839);
		getContentPane().add(label);
		
		
	}

	private static void addPopup(Component component, final JPopupMenu popup) {
		component.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			public void mouseReleased(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			private void showMenu(MouseEvent e) {
				popup.show(e.getComponent(), e.getX(), e.getY());
			}
		});
	}
}
