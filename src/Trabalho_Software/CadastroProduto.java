package Trabalho_Software;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Atendente.Conexao;
import Atendente.Produto;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.HeadlessException;

import javax.swing.JTextField;
import javax.swing.KeyStroke;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.AbstractAction;
import javax.swing.ImageIcon;
import java.awt.Color;

public class CadastroProduto extends JFrame {

	Produto p = new Produto();
	private JPanel contentPane;
	private JTextField eNome;
	private JTextField eQuantidade;
	private JTextField ePreco;
	private JTextField eDescricao;
	private JTextField eTamanho;
	private JTextField eMarca;
	private JTextField eUnidade;
	private JLabel lblNewLabel_1;
	private JLabel quantidadeVazio;
	private JLabel marcaVazio;
	private JLabel tamanhoVazio;
	private JLabel uniVazio;
	private JLabel descricaoVazio;
	private JLabel nomeVazio;
	private JLabel precoVazio;
	/**
	 * Launch the application.
	 */
	public void cadastroProduto() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CadastroProduto frame = new CadastroProduto();
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
	public CadastroProduto() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1100, 780);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);
		
		JButton btnVoltarAoMenu = new JButton("Voltar ao menu");
		btnVoltarAoMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Menu menu = new Menu();
				menu.menu();
				dispose();
			}
		});
		btnVoltarAoMenu.setBackground(Color.PINK);
		btnVoltarAoMenu.setBounds(905, 48, 134, 23);
		contentPane.add(btnVoltarAoMenu);
		
		
		
		uniVazio = new JLabel("");
		uniVazio.setForeground(Color.RED);
		uniVazio.setBounds(859, 430, 147, 14);
		contentPane.add(uniVazio);
		
		tamanhoVazio = new JLabel("");
		tamanhoVazio.setForeground(Color.RED);
		tamanhoVazio.setBounds(581, 430, 174, 14);
		contentPane.add(tamanhoVazio);
		
		marcaVazio = new JLabel("");
		marcaVazio.setForeground(Color.RED);
		marcaVazio.setBounds(648, 369, 358, 14);
		contentPane.add(marcaVazio);
		
		quantidadeVazio = new JLabel("");
		quantidadeVazio.setForeground(Color.RED);
		quantidadeVazio.setBounds(755, 315, 251, 14);
		contentPane.add(quantidadeVazio);
		
		descricaoVazio = new JLabel("");
		descricaoVazio.setForeground(Color.RED);
		descricaoVazio.setBounds(198, 430, 269, 14);
		contentPane.add(descricaoVazio);
		
		precoVazio = new JLabel("");
		precoVazio.setForeground(Color.RED);
		precoVazio.setBounds(159, 369, 403, 14);
		contentPane.add(precoVazio);
		
		nomeVazio = new JLabel("");
		nomeVazio.setForeground(Color.RED);
		nomeVazio.setBounds(147, 315, 439, 14);
		contentPane.add(nomeVazio);
		
		eNome = new JTextField();
		eNome.setBounds(147, 290, 459, 25);
		contentPane.add(eNome);
		eNome.setColumns(10);
		
		eQuantidade = new JTextField();
		eQuantidade.setBounds(755, 290, 251, 25);
		contentPane.add(eQuantidade);
		eQuantidade.setColumns(10);
		
		ePreco = new JTextField();
		ePreco.setBounds(155, 345, 407, 25);
		contentPane.add(ePreco);
		ePreco.setColumns(10);
		
		eDescricao = new JTextField();
		eDescricao.setBounds(198, 407, 269, 25);
		contentPane.add(eDescricao);
		eDescricao.setColumns(10);
		
		JButton btnCadastrar = new JButton("Cadastrar ");
		btnCadastrar.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnCadastrar.setForeground(Color.WHITE);
		btnCadastrar.setBackground(new Color(247, 144, 139));
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					cadastro();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		getRootPane().getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(
			    KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0), "Cadastrar"
			);     

		getRootPane().getActionMap().put("Cadastrar", new AbstractAction() {
		    public void actionPerformed(ActionEvent e) {
		    	try {
					switch(JOptionPane.showConfirmDialog(null, "Deseja realmente cadastrar o produto?", "Cadastrar produto?", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE)){
					case 0:
							
						cadastro();			
						
					break;
					case 1:
						JOptionPane.showMessageDialog(null, "Nenhum produto foi cadastrado", "Nenhum produto cadastrado", JOptionPane.INFORMATION_MESSAGE);
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
		btnCadastrar.setBounds(493, 476, 134, 30);
		contentPane.add(btnCadastrar);
		
		eTamanho = new JTextField();
		eTamanho.setBounds(583, 407, 172, 25);
		contentPane.add(eTamanho);
		eTamanho.setColumns(10);
		
		eMarca = new JTextField();
		eMarca.setBounds(648, 345, 358, 25);
		contentPane.add(eMarca);
		eMarca.setColumns(10);
		
		eUnidade = new JTextField();
		eUnidade.setBounds(859, 407, 147, 25);
		contentPane.add(eUnidade);
		eUnidade.setColumns(10);
		
		lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\Thiago\\workspace\\bird_shoes\\src\\Trabalho_software\\Imagens\\cadastrodeproduto2.png"));
		lblNewLabel_1.setBounds(0, 0, 1082, 753);
		contentPane.add(lblNewLabel_1);
		
	}
	
	
	public void cadastro() throws SQLException {
		Conexao con = new Conexao();
		
		p.setNome(eNome.getText());
		p.setQuantidade(eQuantidade.getText());
		p.setTamanho(eTamanho.getText());
		p.setDescricao(eDescricao.getText());
		p.setPreco(ePreco.getText());
		p.setMarca(eMarca.getText());
		p.setUnidade(eUnidade.getText());
		
		if(p.getNome().equals("")) {
			nomeVazio.setText("Digite o nome do produto");
		}else {
			nomeVazio.setText("");
			if(p.getQuantidade().equals("")) {
				quantidadeVazio.setText("Diga a quantidade desejada");
			}else {
				quantidadeVazio.setText("");
			if(p.getPreco().equals("")) {
				precoVazio.setText("Diga quanto irá custar o produto");
			}else {
				precoVazio.setText("");
			if(p.getMarca().equals("")) {
				marcaVazio.setText("Digite a marca do produto");
			}else {
				marcaVazio.setText("");
			if(p.getDescricao().equals("")) {
				descricaoVazio.setText("Digite uma descrição para o produto");
			}else {
				descricaoVazio.setText("");
			if(p.getTamanho().equals("")) {
				tamanhoVazio.setText("Digite o tamanho do produto");
			}else {
				tamanhoVazio.setText("");
			if(p.getUnidade().equals("")) {
				uniVazio.setText("Digite a unidade do produto");
			}else {
				uniVazio.setText("");
		try {
				
			con.setSql("INSERT INTO produto(nomeProduto	,quantidade,tamanho,descricao,preco,marca,unidade) VALUES('"+p.getNome()+"','"+p.getQuantidade()+"','"+p.getTamanho()+"','"+p.getDescricao()+"','"+p.getPreco()+"','"+p.getMarca()+"','"+p.getUnidade()+"')");
			con.setAcao(con.getConexao().prepareStatement(con.getSql()));
			con.getAcao().executeUpdate();
			
			JOptionPane.showMessageDialog(null,"Cadastrado com sucesso");
			Menu menu = new Menu();
			menu.menu();
			dispose();
			
		}catch(Exception erro) {
			System.out.println(erro);
		}
			}
		}
	}}}}}}	
}
	

