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
import java.util.TimerTask;
import java.awt.event.ActionEvent;


/**
 * 
 * @author Louis Roberge
 * fenêtre cachée qui permet d'afficher un easter egg, donc du bonus 
 *
 */
public class EasterEgg extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private java.net.URL urlFichier= getClass().getClassLoader().getResource( "roxanne.wav" ); 
	private AudioClip roxanne = Applet.newAudioClip( urlFichier);

	
	

	/**
	 * Lancement de la fenetre
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EasterEgg frame = new 	EasterEgg();
					
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
	public EasterEgg() {
		setTitle("Easter Egg");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 726, 520);
		contentPane = new JPanel();
		contentPane.setBackground(Color.GREEN);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		ImageAvecDefilement panConcepts = new ImageAvecDefilement();

		
		panConcepts.setBounds(-13, -11, 759, 433);
		contentPane.add(panConcepts);
		panConcepts.setBackground(Color.GREEN);
		panConcepts.setLargeurCadre(10);
		panConcepts.setFichierImage("dino2.png");
		
		JButton btnRawwr = new JButton("Rawwr");
		btnRawwr.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {	
				
				panConcepts.setFichierImage("dino3.png");
				roxanne.play();
			     new java.util.Timer().schedule(new TimerTask(){
			        public void run() {
			        	panConcepts.setFichierImage("dino2.png");
			        	cancel();
			        }
			    },1000*1,1000*1); 



			
				    
			
				
			}
		});
		btnRawwr.setBackground(Color.GREEN);
		btnRawwr.setForeground(Color.DARK_GRAY);
		btnRawwr.setFont(new Font("Yu Gothic Medium", Font.BOLD | Font.ITALIC, 18));
		btnRawwr.setBounds(314, 435, 97, 25);
		contentPane.add(btnRawwr);
		
		
	}
	
}
