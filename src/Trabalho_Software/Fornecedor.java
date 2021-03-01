package Trabalho_Software;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Atendente.Conexao;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JFormattedTextField;
import javax.swing.JTextPane;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.Color;

public class Fornecedor extends JFrame {

	private JPanel contentPane;
	private JTextField eNome;
	private JTextField eEndereco;
	private JTextField eEmail;
	private JTextField eCnpj;
	private JTextField eTelefone;
	private JTextField eTipoFornecedor;
	private JTextField eCidade;
	private JTextField eBairro;
	private JTextField eUf;
	private JTextField eCep;

	private String id;
	private String nomeSocial;
	private String endereco;
	private String email;
	private String cnpj;
	private String telefone;
	private String tipoFornecedor;
	private String cidade;
	private String bairro;
	private String uf;
	private String cep;
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	public String getNomeSocial() {
		return nomeSocial;
	}

	public void setNomeSocial(String nomeSocial) {
		this.nomeSocial = nomeSocial;
	}
	
	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getTipoFornecedor() {
		return tipoFornecedor;
	}

	public void setTipoFornecedor(String tipoFornecedor) {
		this.tipoFornecedor = tipoFornecedor;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getUf() {
		return uf;
	}

	public void setUf(String uf) {
		this.uf = uf;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}


	/**
	 * Launch the application.
	 */

	public void fornecedor() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Fornecedor frame = new Fornecedor();
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
	public Fornecedor() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0,0, 1100, 800);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		eNome = new JTextField();
		eNome.setBounds(346, 256, 299, 37);
		contentPane.add(eNome);
		eNome.setColumns(10);
		
		eEndereco = new JTextField();
		eEndereco.setBounds(924, 373, 86, 36);
		contentPane.add(eEndereco);
		eEndereco.setColumns(10);
		
		eEmail = new JTextField();
		eEmail.setBounds(696, 317, 314, 37);
		contentPane.add(eEmail);
		eEmail.setColumns(10);
		
		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.setForeground(Color.WHITE);
		btnCadastrar.setBackground(new Color(247, 144, 139));
		btnCadastrar.setFont(new Font("Cheap Potatoes Black Thin", Font.PLAIN, 14));
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					Cadastrar();
					
				}catch(Exception erro) {
					System.out.println(erro);
				}
			}
		});
		btnCadastrar.setBounds(481, 529, 137, 43);
		contentPane.add(btnCadastrar);
		
		eCnpj = new JTextField();
		eCnpj.setBounds(710, 256, 300, 37);
		contentPane.add(eCnpj);
		eCnpj.setColumns(10);
		
		eTelefone = new JTextField();
		eTelefone.setBounds(233, 317, 384, 37);
		contentPane.add(eTelefone);
		eTelefone.setColumns(10);
		
		eTipoFornecedor = new JTextField();
		eTipoFornecedor.setBounds(314, 373, 167, 36);
		contentPane.add(eTipoFornecedor);
		eTipoFornecedor.setColumns(10);
		
		eCidade = new JTextField();
		eCidade.setBounds(196, 423, 245, 37);
		contentPane.add(eCidade);
		eCidade.setColumns(10);
		
		eBairro =new JTextField();
		eBairro.setBounds(543, 423, 287, 37);
		contentPane.add(eBairro);
		eBairro.setColumns(10);
		
		eUf = new JTextField();
		eUf.setBounds(882, 422, 128, 38);
		contentPane.add(eUf);
		eUf.setColumns(10);
		
		eCep = new JTextField();
		eCep.setBounds(543, 373, 254, 36);
		contentPane.add(eCep);
		eCep.setColumns(10);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon("C:\\Users\\Thiago\\workspace\\bird_shoes\\src\\Trabalho_Software\\Imagens\\Fornecedor.png"));
		label.setBounds(0, 0, 1082, 753);
		contentPane.add(label);
	}
	

	
	public void Cadastrar() {
		
		try {
			Conexao con = new Conexao();
			setNomeSocial(eNome.getText());
			setEmail(eEmail.getText());
			setCnpj(eCnpj.getText());
			setTelefone(eTelefone.getText());
			setTipoFornecedor(eTipoFornecedor.getText());
			setEndereco(eEndereco.getText());
			setCidade(eCidade.getText());
			setBairro(eBairro.getText());
			setUf(eUf.getText());
			setCep(eCep.getText());
			
			
			con.setSql("INSERT INTO fornecedor(denominacao_social,email,cnpj,telefone,endereco,cidade,bairro,uf,cep) VALUES('"+getNomeSocial()+"',"
					+ "'"+getEmail()+"','"+getCnpj()+"','"+getTelefone()+"','"+getEndereco()+"','"+getCidade()+"','"+getBairro()+"',"
							+ "'"+getUf()+"','"+getCep()+"'");
			con.setAcao(con.getConexao().prepareStatement(con.getSql()));
			con.getAcao().executeUpdate();
			
			Menu menu = new Menu();
			menu.menu();
			dispose();
		}catch(Exception erro) {
			System.out.println(erro);
		}
		
	}
}
