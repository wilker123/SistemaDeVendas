package Relatorios;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import Trabalho_Software.Menu;

public class TelaNotaFiscal extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public void gerarNota() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaNotaFiscal frame = new TelaNotaFiscal();
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
	public TelaNotaFiscal() {
		setTitle("Retornar ao menu");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 1100, 800);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnVoltar = new JButton("Voltar para o menu");
		btnVoltar.setForeground(Color.WHITE);
		btnVoltar.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnVoltar.setBackground(new Color(247, 139, 144));
		btnVoltar.setBounds(440, 400, 208, 36);
		contentPane.add(btnVoltar);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\Thiago\\workspace\\bird_shoes\\src\\Trabalho_Software\\Imagens\\telanotafiscal.png"));
		lblNewLabel.setBounds(0, 0, 1082, 753);
		contentPane.add(lblNewLabel);
		
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					dispose();
					Menu m = new Menu();
					m.menu();
				}catch(Exception erro) {
					
					System.out.println(erro);
				}
			}
		});
	}
}
