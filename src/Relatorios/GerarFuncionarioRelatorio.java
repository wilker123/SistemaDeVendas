package Relatorios;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;
import java.awt.ScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import Atendente.Conexao;
import Trabalho_Software.Menu;

import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.ImageIcon;
import java.awt.Color;

public class GerarFuncionarioRelatorio extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public void gerar() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GerarFuncionarioRelatorio frame = new GerarFuncionarioRelatorio();
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
	public GerarFuncionarioRelatorio() {
		setTitle("Relat\u00F3rio de funcionário");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 1100, 800);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);
		
		JButton btnGerar = new JButton("Gerar");
		btnGerar.setForeground(Color.WHITE);
		btnGerar.setBackground(new Color(247, 144, 139));
		btnGerar.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnGerar.setBounds(692, 312, 89, 27);
		contentPane.add(btnGerar);
		
		JTextField relatorio = new JTextField();
		relatorio.setBounds(496, 312, 190, 27);
		contentPane.add(relatorio);
		relatorio.setColumns(10);
		
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 397, 1082, 330);
		contentPane.add(scrollPane);
		RelatorioFuncionarios hcd = new RelatorioFuncionarios(relatorio);
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, "", null, null, null, null},
			},
			new String[] {
				"Id", "Nome", "Email", "CPF", "Sal\u00E1rio", "Meta", "N\u00FAmeroVendas", "idLogin", "Usu\u00E1rio"
			}
		));
		scrollPane.setViewportView(table);
		
		JButton btnExibir = new JButton("Exibir");
		btnExibir.setForeground(Color.WHITE);
		btnExibir.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnExibir.setBackground(new Color(247, 144, 139));
		btnExibir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				listarDados();
			}
		});
		btnExibir.setBounds(25, 11, 112, 23);
		contentPane.add(btnExibir);
		
		btnGerar.addActionListener(hcd);
		JButton btnRetornarAoMenu = new JButton("Retornar ao menu");
		btnRetornarAoMenu.setForeground(Color.WHITE);
		btnRetornarAoMenu.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnRetornarAoMenu.setBackground(new Color(247, 144, 139));
		btnRetornarAoMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Menu menu = new Menu();
				menu.menu();
				dispose();
			}
		});
		btnRetornarAoMenu.setBounds(890, 9, 161, 27);
		contentPane.add(btnRetornarAoMenu);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon("C:\\Users\\Thiago\\workspace\\bird_shoes\\src\\Trabalho_Software\\Imagens\\gerarrelatoriofunc.png"));
		label.setBounds(0, 0, 1082, 753);
		contentPane.add(label);
		
	}
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
