package objets;

import javax.swing.JPanel;
import javax.swing.ToolTipManager;

import composant.PanelOption;
import composant.ZoneAnimation;
import controleAnimation.BoutonAnim;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JOptionPane;

import java.applet.Applet;
import java.applet.AudioClip;
import java.awt.Color;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * 
 * @author Louis et Rostislav
 */
public class BoutonObjets extends JPanel {
/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
private ZoneAnimation zone;
private BoutonAnim btnA;
private PanelOption panelOption;
private JButton btnCyclotron;
private JButton btnSystemePlaque;
private JButton btnZoneChampMag;
private JButton btnFil;
private JButton btnZoneDarrivee;
private JButton btnTige;
private boolean cycloCree,zoneArCree;
private JCheckBox chckbxColision;
private java.net.URL urlFichier= getClass().getClassLoader().getResource( "clic.wav" ); 
private AudioClip clic = Applet.newAudioClip( urlFichier);
private JCheckBox chckbxVecteur;




/**
 * création du panel
 * @param zone la zone d'animation
 * @param panelOption le panel option
 * @param btn les boutons d'animation
 */
	public BoutonObjets(ZoneAnimation zone,PanelOption panelOption,BoutonAnim btn ) {
		setLayout(null);
		this.zone=zone;
		this.panelOption = panelOption;
		this.btnA=btn;
		ToolTipManager.sharedInstance().setInitialDelay(0);
		
		btnCyclotron = new JButton("Cyclotron");                 
		btnCyclotron.addMouseListener(new MouseAdapter() {
			//Louis 
			/**
			 * 
			 */
			@Override
			/**
			 * permet de savoir quand le pointeur de la souris touche au bouton
			 */
			public void mouseEntered(MouseEvent arg0) {
				associerBoutonAvecImage(btnCyclotron, "boutonCyclotron2.png");		
			}
			@Override
			/**
			 * permet de savoir quand le pointeur de la souris exite le bouton
			 */
			public void mouseExited(MouseEvent e) {
				associerBoutonAvecImage(btnCyclotron, "boutonCyclotron.png");		
			}
		});
		btnCyclotron.setBounds(28, 26, 108, 62);
		btnCyclotron.addActionListener(new ActionListener() {
		//Rostislav
			/**
			 * Permet de cree le cyclotron
			 */
			@Override
			public void actionPerformed(ActionEvent e) {
			clic.play();
			zone.setDessiner(1);
			panelOption.setPanel(1);
		cycloCree=true;
			
				
			}
		});
		add(btnCyclotron);
		associerBoutonAvecImage(btnCyclotron, "boutonCyclotron.png");
		btnCyclotron.setToolTipText("Un cyclotron");
	
		
		
		btnSystemePlaque = new JButton("Syst\u00E8meDePlaques");
		btnSystemePlaque.addMouseListener(new MouseAdapter() {
			@Override
			/**
			 * permet de savoir quand le pointeur de la souris touche au bouton
			 */
			public void mouseEntered(MouseEvent e) {
				associerBoutonAvecImage(btnSystemePlaque, "sp2.png");		
			}
			@Override
			/**
			 * permet de savoir quand le pointeur de la souris exite le bouton
			 */
			public void mouseExited(MouseEvent e) {
				associerBoutonAvecImage(btnSystemePlaque, "sp.png");	
			}
		});
		btnSystemePlaque.setBounds(164, 26, 108, 62);
		btnSystemePlaque.addActionListener(new ActionListener() {
			//Rostislav
			/**
			 * Permet de cree les plauqes
			 */
			@Override
			public void actionPerformed(ActionEvent e) {
			clic.play();
			zone.setDessiner(2);
			panelOption.setPanel(2);
			
			}
		});
		add(btnSystemePlaque);
		associerBoutonAvecImage(btnSystemePlaque, "sp.png");	
		btnSystemePlaque.setToolTipText("Un système de plaques");
		
		btnZoneDarrivee = new JButton("Zone d'arriv\u00E9e");
		btnZoneDarrivee.addMouseListener(new MouseAdapter() {
			@Override
			/**
			 * permet de savoir quand le pointeur de la souris touche au bouton
			 */
			public void mouseEntered(MouseEvent e) {
				associerBoutonAvecImage(btnZoneDarrivee, "za2.png");	
			}
			@Override
			/**
			 * permet de savoir quand le pointeur de la souris exite le bouton
			 */
			public void mouseExited(MouseEvent e) {
				associerBoutonAvecImage(btnZoneDarrivee, "za.png");	
			}
		});
		btnZoneDarrivee.setBounds(164, 202, 108, 62);
		btnZoneDarrivee.addActionListener(new ActionListener() {
			//Rostislav
			/**
			 * Permet de creer la zone d'arrive
			 */
			@Override
			public void actionPerformed(ActionEvent e) {
			clic.play();
			zone.setDessiner(3);
			panelOption.setPanel(6);
			zoneArCree=true;
			}
		});
		add(btnZoneDarrivee);
		associerBoutonAvecImage(btnZoneDarrivee, "za.png");	
		btnZoneDarrivee.setToolTipText("Une zone d'arrivée");
		btnFil = new JButton("Fil");
		btnFil.addMouseListener(new MouseAdapter() {
			@Override
			/**
			 * permet de savoir quand le pointeur de la souris touche au bouton
			 */
			public void mouseEntered(MouseEvent e) {
				associerBoutonAvecImage(btnFil, "fil2.png");	
			}
			@Override
			/**
			 * permet de savoir quand le pointeur de la souris exite le bouton
			 */
			public void mouseExited(MouseEvent e) {
				associerBoutonAvecImage(btnFil, "fil.png");	
			}
		});
		btnFil.addActionListener(new ActionListener() {
		//Rostislav
			/**
			 * Permet de cree le btn fil
			 */
			public void actionPerformed(ActionEvent arg0) {
				clic.play();
				zone.setDessiner(6);
				panelOption.setPanel(5);
			}
		});
		btnFil.setBounds(28, 202, 108, 62);
		add(btnFil);
		associerBoutonAvecImage(btnFil, "fil.png");	
		btnFil.setToolTipText("Un fil");
		
		
		
		btnZoneChampMag = new JButton("Zone de champ magn\u00E9tique");
		btnZoneChampMag.addMouseListener(new MouseAdapter() {
			@Override
			/**
			 * permet de savoir quand le pointeur de la souris touche au bouton
			 */
			public void mouseEntered(MouseEvent e) {
				associerBoutonAvecImage(btnZoneChampMag, "zm2.png");	
			}
			@Override
			/**
			 * permet de savoir quand le pointeur de la souris exite le bouton
			 */
			public void mouseExited(MouseEvent e) {
				associerBoutonAvecImage(btnZoneChampMag, "zm.png");	
			}
		});
		btnZoneChampMag.setBounds(28, 114, 108, 62);
		btnZoneChampMag.addActionListener(new ActionListener() {
			//Rostislav
			/**
			 * Permet de cree un  champ magnetique
			 */
			@Override
			
			public void actionPerformed(ActionEvent e) {
				clic.play();
				panelOption.setPanel(3);
				zone.setDessiner(4);	
				
			}
		});
		add(btnZoneChampMag);
		associerBoutonAvecImage(btnZoneChampMag, "zm.png");	
		btnZoneChampMag.setToolTipText("Une zone de champ magnétique");
		btnTige = new JButton("Tige");
		btnTige.addMouseListener(new MouseAdapter() {
			@Override
			/**
			 * permet de savoir quand le pointeur de la souris touche au bouton
			 */
			public void mouseEntered(MouseEvent e) {
				associerBoutonAvecImage(btnTige, "tige2.png");	
			}
			@Override
			/**
			 * permet de savoir quand le pointeur de la souris exite le bouton
			 */
			public void mouseExited(MouseEvent e) {
				associerBoutonAvecImage(btnTige, "tige.png");	
			}
		});
		btnTige.setBounds(164, 114, 108, 62);
		btnTige.addActionListener(new ActionListener() {
			//Rostislav
			/**
			 * Permet de cree un tige
			 */
			@Override
			public void actionPerformed(ActionEvent e) {
			clic.play();
			zone.setDessiner(5);
			panelOption.setPanel(4);
				
			}
		});
		add(btnTige);
		associerBoutonAvecImage(btnTige, "tige.png");	
		btnTige.setToolTipText("Une tige");
		JCheckBox chckbxQuadrillage = new JCheckBox("Quadrillage");
		chckbxQuadrillage.addActionListener(new ActionListener() {
			/**
			 * permet de savoir si la combobox est coché ou pas
			 */
			public void actionPerformed(ActionEvent e) {
				if (chckbxQuadrillage.isSelected()){
					zone.setQuadrillage(true);
				}else {
					zone.setQuadrillage(false);
				}
				
				
			}
		});
		chckbxQuadrillage.setSelected(true);
		chckbxQuadrillage.setBackground(new Color(135, 206, 235));
		chckbxQuadrillage.setBounds(16, 290, 99, 25);
		add(chckbxQuadrillage);
		
		chckbxColision = new JCheckBox("Collision");
		chckbxColision.addActionListener(new ActionListener() {
			//Rostislav
			/**
			 * Permet d'enlever les collision dans l'animation
			 */
			public void actionPerformed(ActionEvent arg0) {
				if (chckbxColision.isSelected()){
					zone.setAvecCollision(true);
				}else {
					zone.setAvecCollision(false);
				}
				
			}
		});
		chckbxColision.setSelected(true);
		chckbxColision.setBackground(new Color(135, 206, 235));
		chckbxColision.setBounds(112, 290, 83, 25);
		add(chckbxColision);
		
		chckbxVecteur = new JCheckBox("Vecteur");
		chckbxVecteur.setSelected(true);
		chckbxVecteur.addActionListener(new ActionListener() {
			//Rostislav
			/**
			 * Permet d'enlever l'affichage du vecteur
			 */
			public void actionPerformed(ActionEvent arg0) {
			
				
				if (chckbxVecteur.isSelected()){
					zone.setVecteurAF(true);
				} else {
				
					zone.setVecteurAF(false);
				}
				
			}
		});
		chckbxVecteur.setBackground(new Color(135, 206, 235));
		chckbxVecteur.setBounds(205, 290, 113, 25);
		add(chckbxVecteur);

	}

//Rostislav
/**
 * methode qui ouvre les buttons
 * 
 */
public void enableButton() {
	btnCyclotron.setEnabled(true);
	btnFil.setEnabled(true);
	btnSystemePlaque.setEnabled(true);
btnTige.setEnabled(true);
btnZoneChampMag.setEnabled(true);
btnZoneDarrivee.setEnabled(true);
}
//Rostislav
/**
 * methode qui ferme les buttons
 * 
 */
public void disableButton() {
	btnCyclotron.setEnabled(false);
	btnFil.setEnabled(false);
	btnSystemePlaque.setEnabled(false);
btnTige.setEnabled(false);
btnZoneChampMag.setEnabled(false);
btnZoneDarrivee.setEnabled(false);
}
public void enableSP() {
	btnSystemePlaque.setEnabled(true);
}
public void enableTige() {
	btnTige.setEnabled(true);
	
}public void enableFil() {
	btnFil.setEnabled(true);
	
}public void enableZM() {
	btnZoneChampMag.setEnabled(true);
	
}
public void enableC() {
	btnCyclotron.setEnabled(true);
}
public void enableZA() {
	btnZoneDarrivee.setEnabled(true);
}
//Rostislav
public  boolean getZoneArCree() {
	return zoneArCree;
}
//Rostislav
public  boolean getCycloCree() {
	return zoneArCree;
}
//Louis 
/**
 * permet de changer l'etat du bouton cyclotron
 * @param etat true active,false desactive
 */
public void EtatCyclotron(boolean etat) {
	btnCyclotron.setEnabled(etat);
}
//Louis 
/**
* permet de changer l'etat du bouton zm
* @param etat true active,false desactive
*/
public void EtatZM(boolean etat) {
	btnZoneChampMag.setEnabled(etat);
}
//Louis 
/**
* permet de changer l'etat du bouton SP
* @param etat true active,false desactive
*/
public void EtatSP(boolean etat) {
	btnSystemePlaque.setEnabled(etat);
}
//Louis 
/**
* permet de changer l'etat du bouton Tige
* @param etat true active,false desactive
*/
public void EtatTige(boolean etat) {
	btnTige.setEnabled(etat);
}
//Louis 
/**
* permet de changer l'etat du bouton Fil
* @param etat true active,false desactive
*/
public void EtatFil(boolean etat) {
	btnFil.setEnabled(etat);
}
//Louis 
/**
* permet de changer l'etat du bouton ZA
* @param etat true active,false desactive
*/
public void EtatZA(boolean etat) {
	btnZoneDarrivee.setEnabled(etat);
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
}
