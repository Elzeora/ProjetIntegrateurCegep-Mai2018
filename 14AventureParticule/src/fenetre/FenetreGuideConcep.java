package fenetre;


import java.applet.Applet;
import java.applet.AudioClip;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import ressources.ImageAvecDefilement;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


/**
 * 
 * @author Louis Roberge
 * fenêtre du guide des Concepts scientifiques 
 *
 */
public class FenetreGuideConcep extends JFrame {

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
					FenetreGuideConcep frame = new FenetreGuideConcep();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Creation du Jframe
	 */
	public FenetreGuideConcep() {
		setTitle("Concepts scientifiques");
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
		panConcepts.setFichierImage("ImageConceptsScientifiques.jpg");
		
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
