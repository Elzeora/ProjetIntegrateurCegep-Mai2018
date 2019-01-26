package fenetre;


import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.applet.Applet;
import java.applet.AudioClip;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import image.Louis;
import image.Rostislav;

/**
 * 
 * @author Louis Roberge
 * fenetre qui permet de savoir qui a fait l'application
 */
public class FenetreAPropos extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private java.net.URL urlFichier= getClass().getClassLoader().getResource( "clic.wav" ); 
	private AudioClip clic = Applet.newAudioClip( urlFichier);

	/**
	 * lancement de l'application
	 * @param args 
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {				
					FenetreAPropos frame = new FenetreAPropos();
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
	public FenetreAPropos() {
		setTitle("\u00C0 propos");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 634, 256);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(135, 206, 235));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("Quitter");
		btnNewButton.setFont(new Font("Yu Gothic Medium", Font.BOLD, 13));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				clic.play();
				dispose();
			}
		});
		btnNewButton.setBounds(502, 170, 97, 25);
		contentPane.add(btnNewButton);
		
		JLabel lblApplicationC = new JLabel("Application cr\u00E9\u00E9e par : ");
		lblApplicationC.setFont(new Font("Yu Gothic Medium", Font.BOLD, 13));
		lblApplicationC.setBounds(29, 26, 168, 16);
		contentPane.add(lblApplicationC);
		
		JLabel lblLouisRoberge = new JLabel("Louis Roberge");
		lblLouisRoberge.setFont(new Font("Yu Gothic Medium", Font.BOLD, 13));
		lblLouisRoberge.setBounds(209, 26, 107, 16);
		contentPane.add(lblLouisRoberge);
		
		JLabel lblEt = new JLabel("et");
		lblEt.setFont(new Font("Yu Gothic Medium", Font.BOLD, 13));
		lblEt.setHorizontalAlignment(SwingConstants.CENTER);
		lblEt.setBounds(383, 26, 56, 16);
		contentPane.add(lblEt);
		
		JLabel lblRostislavSemeniuc = new JLabel("Rostislav Semeniuc");
		lblRostislavSemeniuc.setFont(new Font("Yu Gothic Medium", Font.BOLD, 13));
		lblRostislavSemeniuc.setBounds(451, 26, 165, 16);
		contentPane.add(lblRostislavSemeniuc);
		
		JLabel lblCre = new JLabel("Ann\u00E9e de cr\u00E9ation : 2018  ");
		lblCre.setFont(new Font("Yu Gothic Medium", Font.BOLD, 13));
		lblCre.setBounds(29, 96, 184, 16);
		contentPane.add(lblCre);
		
		JLabel lblNewLabel = new JLabel("R\u00E9alis\u00E9e pour le cours :\r\n\r\n\r\n");
		lblNewLabel.setFont(new Font("Yu Gothic Medium", Font.BOLD, 13));
		lblNewLabel.setBounds(29, 125, 168, 16);
		contentPane.add(lblNewLabel);
		
		JLabel lblCollgeMaisonneuve = new JLabel("Au Coll\u00E8ge Maisonneuve");
		lblCollgeMaisonneuve.setFont(new Font("Yu Gothic Medium", Font.BOLD, 13));
		lblCollgeMaisonneuve.setBounds(29, 154, 265, 16);
		contentPane.add(lblCollgeMaisonneuve);
		
		JLabel lblNewLabel_1 = new JLabel(" INT\u00C9GRATION DES APPRENTISSAGES EN SCIENCES INFOS ET MATHS");
		lblNewLabel_1.setFont(new Font("Yu Gothic Medium", Font.BOLD, 10));
		lblNewLabel_1.setBounds(197, 125, 419, 16);
		contentPane.add(lblNewLabel_1);
		
		Louis louis = new Louis();
		louis.setBounds(316, 42, 75, 75);
		contentPane.add(louis);
		
		Rostislav rostislav = new Rostislav();
		rostislav.setBounds(524, 42, 75, 75);
		contentPane.add(rostislav);
	}
}
