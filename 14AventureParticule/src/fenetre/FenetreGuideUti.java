package fenetre;


import java.applet.Applet;
import java.applet.AudioClip;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import ressources.ImageAvecDefilement;

/**
 * 
 * @author Louis Roberge
 * fenêtre du Guide d'utilisation 
 *
 */
public class FenetreGuideUti extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private java.net.URL urlFichier= getClass().getClassLoader().getResource( "clic.wav" ); 
	private AudioClip clic = Applet.newAudioClip( urlFichier);

	/**
	 * Lancement de la fenetre
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {	
					FenetreGuideUti frame = new FenetreGuideUti();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Creation du Jfram
	 */
	public FenetreGuideUti() {
		setTitle("Guide d'utilisation ");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 900, 1000);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(135, 206, 235));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		ImageAvecDefilement panConcepts = new ImageAvecDefilement();
		
		panConcepts.setBounds(12, 13, 858, 893);
		contentPane.add(panConcepts);
		panConcepts.setBackground(new Color(135, 206, 235));
		panConcepts.setLargeurCadre(10);
		panConcepts.setFichierImage("guide d'utilisation.jpg");
		
		JButton btnNewButton = new JButton("Quitter\r\n");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//d		
				clic.play();
				dispose();
				//f
			}
		});
		btnNewButton.setFont(new Font("Yu Gothic Medium", Font.BOLD, 13));
		btnNewButton.setBounds(761, 919, 97, 25);
		contentPane.add(btnNewButton);
	}
}
