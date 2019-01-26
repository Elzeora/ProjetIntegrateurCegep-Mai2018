package fenetre;



import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.applet.Applet;
import java.applet.AudioClip;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.Rectangle;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 * @author Louis Roberge
 * JFrame conteant les instructions a propos de l'application
 *
 */
public class FenetreInstruction extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private FenetreGuideConcep guideConcep;
	private FenetreGuideUti guideUti;
	private java.net.URL urlFichier= getClass().getClassLoader().getResource( "clic.wav" ); 
	private AudioClip clic = Applet.newAudioClip( urlFichier);

	

	
	/**
	 * Création du JFrame
	 */
	public FenetreInstruction() {
		ImageIcon img = new ImageIcon(getClass().getClassLoader().getResource("Particule.png"));
		setTitle("Les Guides");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 547, 354);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(135, 206, 235));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
	    guideConcep = new FenetreGuideConcep();
	    guideConcep.setIconImage(img.getImage());
	    guideConcep.setVisible(false);
	    guideUti = new FenetreGuideUti();
	    guideUti.setIconImage(img.getImage());
	    guideUti.setVisible(false); 
		
		JButton btnNewButton = new JButton("Quitter");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//d
				clic.play();

				dispose();			
				//f
			}
		});
		btnNewButton.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 14));
		btnNewButton.setBounds(408, 262, 109, 32);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Guide d'utilisation ");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			//d
				clic.play();
			    int x = 0;
	            int y = 0;
	            guideUti.setLocation(x, y);           
	            guideUti.setVisible(true); 
				
			//f
			}
		});
		btnNewButton_1.setFont(new Font("Yu Gothic Medium", Font.BOLD, 20));
		btnNewButton_1.setBounds(46, 30, 439, 68);
		contentPane.add(btnNewButton_1);
		
		

    
		
		
		JButton btnConceptsScientifiques = new JButton("Concepts scientifiques ");
		btnConceptsScientifiques.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//d
				clic.play();
				GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
	            GraphicsDevice defaultScreen = ge.getDefaultScreenDevice();
	            Rectangle rect = defaultScreen.getDefaultConfiguration().getBounds();
	            int x = (int) rect.getMaxX() - guideConcep.getWidth();
	            int y = 0;
	            guideConcep.setLocation(x, y);           
				guideConcep.setVisible(true); 
				//f
			}
		});
		btnConceptsScientifiques.setFont(new Font("Yu Gothic Medium", Font.BOLD, 20));
		btnConceptsScientifiques.setBounds(46, 127, 439, 68);
		contentPane.add(btnConceptsScientifiques);
	}
	public Dimension getPreferredSize() {
        return new Dimension(320, 240);
    }

}
