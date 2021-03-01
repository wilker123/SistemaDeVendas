package Relatorios;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.ImageIcon;
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

public class teste extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public void Teste() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					teste frame = new teste();
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
	public teste() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 1100, 800);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);
		
		JButton btnGerar = new JButton("Gerar");
		btnGerar.setBackground(new Color(237, 144, 139));
		btnGerar.setForeground(Color.WHITE);
		btnGerar.setFont(new Font("Cheap Potatoes", Font.PLAIN, 13));
		btnGerar.setBounds(654, 340, 112, 30);
		contentPane.add(btnGerar);
		
		JTextField relatorio = new JTextField();
		relatorio.setFont(new Font("Lato", Font.BOLD, 16));
		relatorio.setBounds(503, 340, 145, 30);
		contentPane.add(relatorio);
		relatorio.setColumns(10);
		
		HistoricoAcesso hd = new HistoricoAcesso(relatorio);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 397, 1082, 330);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null},
			},
			new String[] {
				"Id", "Usu\u00E1rio", "Data de acesso", "Comportamento", "IdFuncionario"
			}
		));
		scrollPane.setViewportView(table);
		
		

		JButton btnExibir = new JButton("exibir");
		btnExibir.setForeground(Color.WHITE);
		btnExibir.setFont(new Font("Cheap Potatoes Black Thin", Font.BOLD, 12));
		btnExibir.setBackground(new Color(247, 144, 139));
		btnExibir.setBounds(27, 12, 188, 33);
		btnExibir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				listarDados();
			}
		});
		contentPane.add(btnExibir);
		
		
		btnGerar.addActionListener(hd);
		JButton button = new JButton("Voltar ao Menu");
		button.setForeground(Color.WHITE);
		button.setFont(new Font("Cheap Potatoes Black Thin", Font.BOLD, 12));
		button.setBackground(new Color(247, 144, 139));
		button.setBounds(871, 13, 188, 33);
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Menu menu = new Menu();
				menu.menu();
				dispose();
			}
		});
		contentPane.add(button);

		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon("C:\\Users\\Thiago\\workspace\\bird_shoes\\src\\Trabalho_Software\\Imagens\\historicoacesso1.png"));
		label.setBounds(0, 0, 1082, 753);
		contentPane.add(label);
		
		
	}
	public void listarDados() {
		try {
			
			Conexao con = new Conexao();
			
			con.setSql("Select *from acessologin");
			con.setAcao(con.getConexao().prepareStatement(con.getSql()));
			con.setResultado(con.getAcao().executeQuery());
			
			DefaultTableModel modelo = (DefaultTableModel) table.getModel();
			modelo.setNumRows(0);
			
			while(con.getResultado().next()) {
				
				modelo.addRow(new Object[] {con.getResultado().getString("id"),con.getResultado().getString("usuario"),
				con.getResultado().getString("dataAcesso"),con.getResultado().getString("tipoComportamento"),con.getResultado().getString("idFuncionario")});
			}
			
			con.getResultado().close();
			
		}catch(Exception erro) {
			
		}
		
	}
}
