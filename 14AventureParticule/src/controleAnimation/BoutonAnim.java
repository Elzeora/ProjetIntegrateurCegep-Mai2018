package controleAnimation;

import java.applet.Applet;
import java.applet.AudioClip;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.ToolTipManager;

import composant.ZoneAnimation;
import objets.BoutonObjets;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
/**
 * 
 * @author Louis Roberge  et Rostislav
 * classe des boutons d'animation
 *
 */
public class BoutonAnim extends JPanel {
/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
private ZoneAnimation zone ;
	private JButton btnAnim;
	private JButton btnPausee;
	private JButton btnReset;
	private JButton btnDefault;
	private java.net.URL urlFichier1= getClass().getClassLoader().getResource( "play.wav" );
	private java.net.URL urlFichier2= getClass().getClassLoader().getResource( "roxanneRawr.wav" ); 
	private java.net.URL urlFichier3= getClass().getClassLoader().getResource( "chienPorte.wav" ); 
	private java.net.URL urlFichier4= getClass().getClassLoader().getResource( "recommencer.wav" ); 
	private AudioClip play = Applet.newAudioClip( urlFichier1);
	private AudioClip reset = Applet.newAudioClip( urlFichier2);
	private AudioClip pause = Applet.newAudioClip( urlFichier3);
	private AudioClip recommencer = Applet.newAudioClip( urlFichier4);
	
	
	
	/**
	 *un panel qui contient des boutons d'animation
	 */
	public BoutonAnim(ZoneAnimation zone,BoutonObjets btnOBJET) {
	
	
		ToolTipManager.sharedInstance().setInitialDelay(0);
		setLayout(null);
		//boutton animer
	this.zone=zone;
	btnAnim = new JButton("Animer");
		btnAnim.setRolloverIcon(null);
		btnAnim.addMouseListener(new MouseAdapter() {
			@Override
			//Louis
			/**
			 * permet de changer l'image du bouton lors du suvol
			 */
			public void mouseExited(MouseEvent arg0) {
				associerBoutonAvecImage(btnAnim, "Animer.png");
			}	
			//Louis
			/**
			 * permet de changer l'image du bouton lors du survol
			 */
			@Override
			public void mouseEntered(MouseEvent e) {

				associerBoutonAvecImage(btnAnim, "Animer2.png");
			}
		});
		btnAnim.setBounds(31, 5, 50, 40);
		btnAnim.addActionListener(new ActionListener() {
			//Rostislav
			/**
			 * permet d'activé lorsque l'on clique sur le button d'animation
			 */
			public void actionPerformed(ActionEvent e) {
				play.play();
				zone.demarrer();
              btnOBJET.disableButton();
			}
		});
		add(btnAnim);
		btnAnim.setToolTipText("Animer");
		associerBoutonAvecImage(btnAnim, "Animer.png");
		
		//bouton pause
		btnPausee = new JButton("Pause");
		btnPausee.addMouseListener(new MouseAdapter() {
			//Louis
			@Override
			/**
			 * permet de savoir quand le pointeur de la souris touche au bouton
			 */
			public void mouseEntered(MouseEvent e) {
				associerBoutonAvecImage(btnPausee, "PauseProchaineImage2.png");
			}
			//Louis
			@Override
			/**
			 * permet de savoir quand le pointeur de la souris exite le bouton
			 */
			public void mouseExited(MouseEvent e) {
				associerBoutonAvecImage(btnPausee, "PauseProchaineImage.png");
			}
		});
		btnPausee.addActionListener(new ActionListener() {
			//Rostislav
			/**
			 * Permet de mettre l'animation en pause et faire une iteration a la fois
			 */
			public void actionPerformed(ActionEvent e) {
				   zone.arreter();
				   pause.play();
					if(zone.getListSP().size()<4) {
						btnOBJET.enableSP();
					}if(zone.getListTige().size()<4) {
						btnOBJET.enableTige();
					}if(zone.getListFil().size()<4) {
						btnOBJET.enableFil();
					}if(zone.getListZM().size()<4) {
						btnOBJET.enableZM();
					}if(zone.getListC().size()<1) {
						btnOBJET.enableC();
					}else {
					btnOBJET.EtatCyclotron(false);
					}
			zone.calculerUneIterationPhysique();
			}
		});
		btnPausee.setBounds(99, 5, 50, 40);
		add(btnPausee);
		btnPausee.setToolTipText("Pause et prochaine image");
		associerBoutonAvecImage(btnPausee, "PauseProchaineImage.png");

		//bouton recommencer
		btnReset = new JButton("Recommncer");
		btnReset.addMouseListener(new MouseAdapter() {
			//Louis
			@Override
			/**
			 * permet de savoir quand le pointeur de la souris touche au bouton
			 */
			public void mouseEntered(MouseEvent e) {
				associerBoutonAvecImage(btnReset, "Recommencer2.png");
			}
			//Louis
			@Override
			/**
			 * permet de savoir quand le pointeur de la souris exite le bouton
			 */
			public void mouseExited(MouseEvent e) {
				associerBoutonAvecImage(btnReset, "Recommencer.png");
			}
		});
		btnReset.setBounds(161, 5, 50, 40);
		btnReset.addActionListener(new ActionListener() {
			//Rostislav
		/**
		 * Permet de reset la particule a sa position finale
		 */
			public void actionPerformed(ActionEvent e) {
				reset.play();
		       zone.arreter();
				zone.resetPositionParticule();
				if(zone.getListSP().size()<4) {
					btnOBJET.enableSP();
				}if(zone.getListTige().size()<4) {
					btnOBJET.enableTige();
				}if(zone.getListFil().size()<4) {
					btnOBJET.enableFil();
				}if(zone.getListZM().size()<4) {
					btnOBJET.enableZM();
				}if(zone.getListC().size()<1) {
					btnOBJET.enableC();
				}else {
				btnOBJET.EtatCyclotron(false);
				}
		
			}
		});
		add(btnReset);
		btnReset.setToolTipText("Recommencer");
		associerBoutonAvecImage(btnReset, "Recommencer.png");

		//bouton defaut
		btnDefault = new JButton("Defaut");
		btnDefault.addMouseListener(new MouseAdapter() {
			//Louis
			@Override
			/**
			 * permet de savoir quand le pointeur de la souris touche au bouton
			 */
			public void mouseEntered(MouseEvent e) {
				associerBoutonAvecImage(btnDefault, "4Defaut2.png");
			}
			//Louis
			@Override
			/**
			 * permet de savoir quand le pointeur de la souris exite le bouton
			 */
			public void mouseExited(MouseEvent e) {
				associerBoutonAvecImage(btnDefault, "4Defaut.png");
			}
		});
		btnDefault.setBounds(229, 5, 50, 40);
		btnDefault.addActionListener(new ActionListener() {
			//Rostislav
			/**
			 * Permet de faire un hard reset
			 */
			public void actionPerformed(ActionEvent e) {
				recommencer.play();
				 zone.arreter();
					zone.reset();
					disableButton();
					btnOBJET.enableButton();
			}
		});
		add(btnDefault);
		btnDefault.setToolTipText("Rétablir par défaut");
		associerBoutonAvecImage(btnDefault, "4Defaut.png");

	}
	

	
	/**
	 * @author leProfesseur
	 * permet d'associer des images aux boutons
	 * @param leBouton
	 * @param fichierImage
	 */
	public void associerBoutonAvecImage(JButton leBouton, String fichierImage) {
		Image imgLue = null;
		java.net.URL urlImage = getClass().getClassLoader().getResource(fichierImage);
		if (urlImage == null) {
			JOptionPane.showMessageDialog(null, "Fichier " + fichierImage + " introuvable");
		}
		try {
			imgLue = ImageIO.read(urlImage);
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, "Erreur pendant la lecture du fichier d'image");
		}

		// redimensionner l'image de la même grandeur que le bouton
		Image imgRedim = imgLue.getScaledInstance(leBouton.getWidth(), leBouton.getHeight(), Image.SCALE_SMOOTH);
		// au cas où le fond de l’image serait transparent
		leBouton.setOpaque(false);
		leBouton.setContentAreaFilled(false);
		leBouton.setBorderPainted(false);

		// associer l'image au bouton
		leBouton.setText("");
		leBouton.setIcon(new ImageIcon(imgRedim));
		// on se débarrasse des images intermédiaires
		imgLue.flush();
		imgRedim.flush();

	}
	//Rostislav
	/**
	 * 
	 * @return
	 */
public JButton getBtnAnim() {
	return btnAnim;
}
//Rostislav
/**
 * 
 * @return
 */
public JButton getBtnPausee() {
	return btnPausee;
}
//Rostislav
/**
 * 
 * @return
 */
public JButton getBtnDefault() {
	return btnDefault;
}
//Rostislav
/**
 * 
 * @return
 */
public JButton getBtnReset() {
	return btnReset;
}
//Rostislav
/**
 * Permet de disable les buttons d'animation
 */
public void disableButton() {
	btnAnim.setEnabled(false);
    btnPausee.setEnabled(false);
    btnReset.setEnabled(false);
}
//Rostislav
/**
 * Permet d'activé les buttons de l'animation
 */
public void enableButton() {
	btnAnim.setEnabled(true); 
	btnPausee.setEnabled(true);
	   btnReset.setEnabled(true);
	  
}
}
