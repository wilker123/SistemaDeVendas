package Trabalho_Software;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;

public class MenuAtendente extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void MenuAtendente() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MenuAtendente frame = new MenuAtendente();
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
	public MenuAtendente() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblAtendente = new JLabel("Atendente");
		lblAtendente.setFont(new Font("Tahoma", Font.PLAIN, 21));
		lblAtendente.setBounds(160, 110, 160, 47);
		contentPane.add(lblAtendente);
	}

}
