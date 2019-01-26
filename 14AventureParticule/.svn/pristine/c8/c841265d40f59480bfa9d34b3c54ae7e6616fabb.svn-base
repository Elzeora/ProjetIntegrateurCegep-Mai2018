package aaplication;

import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.io.IOException;
import java.awt.event.ActionEvent;
import composant.ZoneAnimation;

import java.applet.Applet;
import java.applet.AudioClip;
import java.awt.Color;

import javax.imageio.ImageIO;
import javax.swing.JSeparator;
import javax.swing.border.LineBorder;
import javax.swing.JButton;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;

import controleAnimation.BoutonAnim;
import fenetre.FenetreInstruction;
import fenetre.FenetrePrincipale;
import objets.BoutonObjets;
import ressources.ClicListener;
import ressources.PanelCyclotronListener;
import ressources.PanelFilListener;
import ressources.PanelSPListener;
import ressources.PanelTigeListener;
import ressources.PanelZAListener;
import ressources.PanelZMListener;
import composant.PanelOption;
import javax.swing.SwingConstants;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import javax.swing.JSlider;

import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;

import javax.swing.UIManager;

/**
 * @author Louis
 * fenetre de l'application
 *
 */
public class App14AventureParticule extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private FenetreInstruction instruction;
	private BoutonObjets boutonObjets;
	private PanelOption panelOption;
	private ZoneAnimation zoneAnimation;
	private BoutonAnim boutonAnim;
	private JComboBox<?> comboBox;
	private boolean boutonAnimBoolean = false;
	private double v,a,fE,fM,t;
	private JLabel lblMs;
	private JLabel lblNewLabel;
    private JLabel  label;
	private JLabel lblMs_1;
	private JLabel lblS;
	private java.net.URL urlFichier= getClass().getClassLoader().getResource( "clic.wav" ); 
	private AudioClip clic = Applet.newAudioClip( urlFichier);

	/**
	 *
	 * Lancement de l'Application
	 */
	public static void main(String[] args) {
		try {
		} catch (Throwable e) {
			e.printStackTrace();
		}
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ImageIcon img = new ImageIcon(getClass().getClassLoader().getResource("Particule.png"));
					FenetrePrincipale frame = new FenetrePrincipale();
					frame.setIconImage(img.getImage());
					frame.setLocationRelativeTo(null);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public App14AventureParticule(BoutonObjets btnOBJETS) {
		
		this.boutonObjets = btnOBJETS;

		setTitle("Les Aventures D'une Particule");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1632, 964);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(135, 206, 235));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		/**
		 * Creation du panel des instructions
		 */
		ImageIcon img = new ImageIcon(getClass().getClassLoader().getResource("Particule.png"));	
		instruction = new FenetreInstruction();
		instruction.setIconImage(img.getImage());
		instruction.setVisible(false);

		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 1614, 19);
		contentPane.add(menuBar);

		JMenu mnNewMenu = new JMenu("Aide");
		menuBar.add(mnNewMenu);

		JMenuItem mntmNewMenuItem = new JMenuItem("Les Guides");
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				clic.play();			
				instruction.setLocationRelativeTo(null);
				instruction.setVisible(true);
			}
		});

		JMenuItem mntmRetourMenuPrincipale = new JMenuItem("Retour menu principal");
		mntmRetourMenuPrincipale.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// d
				clic.play();
				FenetrePrincipale menu = new FenetrePrincipale();
				menu.setIconImage(img.getImage());
				menu.setLocationRelativeTo(null);
				menu.setVisible(true);
				dispose();
				// f
			}
		});
		mnNewMenu.add(mntmRetourMenuPrincipale);
		mnNewMenu.add(mntmNewMenuItem);

		JMenuItem mntmQuitter = new JMenuItem("Quitter");
		mntmQuitter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				// d
				clic.play();
				dispose();
				// f
			}
		});
		mnNewMenu.add(mntmQuitter);

		zoneAnimation = new ZoneAnimation<Object>();
		zoneAnimation.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		zoneAnimation.setBounds(0, 32, 1300, 780);
		contentPane.add(zoneAnimation);
		this.setZoneAnimation(zoneAnimation);
		//Rostislav
		/**
		 * permet d'ajouter l'evenement personaliser a la zone d'animation
		 */
		zoneAnimation.addClicListener(new ClicListener() {

			@Override
			public void changerPanel(int i) {
				panelOption.setPanel(i);
			}
//Rostislav
			/**
			 * permet d'activer ou desactive les buttons d'animation si le cyclotron et la zone d'arriver ont ete placer
			 */
			@Override
			public void cyclotronEtZoneAriveCree(boolean objetMinimum) {
				if (objetMinimum) {
					boutonAnim.enableButton();
				} else {
					boutonAnim.disableButton();
				}

			}
			//Rostislav
			/**
			 * permet d'activer ou desactive les buttons objets si le cyclotron et la zone d'arriver ont ete placer
			 */
			@Override
			public void cyclotronInterieurZoneArrive(boolean ZoneArrive) {
				if (ZoneArrive) {
					boutonObjets.enableButton();
				} else {
					boutonObjets.disableButton();
				}

			}
			//Rostislav
			/**
			 * Permet d'afficher l'information sur les etiquettes
			 */

			@Override
			public void particuleIteration(double vitesse, double forceMg, double forceE, double accel, double temps) {
			lblMs.setText(String.format("%.2f E7 m/s",vitesse/10000000)+ "");
			lblS.setText(String.format("%.10f s",temps)+"");
			lblMs_1.setText(String.format("%.2f E18  m/s\u00b2",(accel/1000000000)/1000000000)+"");
			lblNewLabel.setText(String.format("%.6f E-19N",forceE*10000000)+"");
			label.setText(String.format("%.6f E-23 N",forceMg*1000000000)+"");
			
			}
			
			//Louis
			@Override
			/**
			 * permet de savoir s'il y a un cyclotron ou non sur la zone d'animation
			 */
			public void cyclotronPlace(boolean oui) {
			boutonObjets.EtatCyclotron(oui);
				
			}
			//Louis
			@Override
			/**
			 * permet de savoir s'il y a une zone d'arrivée ou non sur la zone d'animation
			 */
			public void zoneArriveePlace(boolean oui) {
				boutonObjets.EtatZA(oui);
				
			}
			//Louis
			@Override
			/**
			 * permet de savoir s'il y a un syteme de plaques ou non sur la zone d'animation
			 */
			public void spPlace(boolean oui) {
				boutonObjets.EtatSP(oui);
				
			}
			//Louis
			@Override
			/**
			 * permet de savoir s'il y a une zone magnétique ou non sur la zone d'animation
			 */
			public void zmPlace(boolean oui) {
				boutonObjets.EtatZM(oui);
				
			}
			//Louis
			@Override
			/**
			 * permet de savoir s'il y a un fil ou non sur la zone d'animation
			 */
			public void filPlace(boolean oui) {
				boutonObjets.EtatFil(oui);
				
			}
			//Louis
			@Override
			/**
			 * permet de savoir s'il y a une tige ou non sur la zone d'animation
			 */
			public void tigePlace(boolean oui) {
				boutonObjets.EtatTige(oui);
				
			}
//Rostislav
			/**
			 * permet d'activé le buton des plaques
			 */
			@Override
			public void enableBtnSP() {
				boutonObjets.enableSP();
				
			}
			//Rostislav
			/**
			 * permet d'activé le button du cyclotron
			 */
			@Override
			public void enableBtnC() {
				boutonObjets.enableC();
				
			}
			//Rostislav
			/**
			 * permet d'activé la zone magnétique
			 */
			@Override
			public void enableBtnZM() {
				// TODO Auto-generated method stub
				boutonObjets.enableZM();
			}
			//Rostislav
			/**
			 * permet d'activé le button tige
			 */
			@Override
			public void enableBtnT() {
				// TODO Auto-generated method stub
				boutonObjets.enableTige();
			}
			//Rostislav
			/**
			 * permet d'activé le button fil
			 */
			@Override
			public void enableBtnF() {
				// TODO Auto-generated method stub
				boutonObjets.enableFil();
			}
			//Rostislav
			/**
			 * permet d'activé le button zone d'arrivé
			 */
			@Override
			public void enableBtnZA() {
				// TODO Auto-generated method stub
				boutonObjets.enableZA();
			}
			//Rostislav
			/**
			 * permet de desactivé les buttons d'animation
			 */
			@Override
			public void disableBtnAnimation() {
			boutonAnim.disableButton();
				
			}

		});
		
		

		JLabel lblVitesseParticule = new JLabel("La vitesse de la particule: ");
		lblVitesseParticule.setFont(new Font("Yu Gothic Medium", Font.BOLD, 19));
		lblVitesseParticule.setBounds(10, 825, 266, 32);
		contentPane.add(lblVitesseParticule);

		JLabel lblAccelerationParticule = new JLabel("L'acc\u00E9l\u00E9ration de la particule :");
		lblAccelerationParticule.setFont(new Font("Yu Gothic", Font.BOLD, 19));
		lblAccelerationParticule.setBounds(10, 876, 277, 30);
		contentPane.add(lblAccelerationParticule);

		JLabel lblTempsParticule = new JLabel("L\r\n\r\n\r\n\r\n\r\ne temps de l'aventure de la particule :");
		lblTempsParticule.setFont(new Font("Yu Gothic Medium", Font.BOLD, 19));
		lblTempsParticule.setBounds(985, 874, 406, 32);
		contentPane.add(lblTempsParticule);

		JLabel lblForceElectrique = new JLabel("La force \u00E9lectrique sur la particule :");
		lblForceElectrique.setFont(new Font("Yu Gothic Medium", Font.BOLD, 19));
		lblForceElectrique.setBounds(497, 829, 371, 32);
		contentPane.add(lblForceElectrique);

		JLabel lblLaForceMagntique = new JLabel("L\r\na force magn\u00E9tique sur la particule :");
		lblLaForceMagntique.setFont(new Font("Yu Gothic Medium", Font.BOLD, 19));
		lblLaForceMagntique.setBounds(497, 874, 382, 32);
		contentPane.add(lblLaForceMagntique);

		JSeparator separator = new JSeparator();
		separator.setBackground(new Color(0, 0, 0));
		separator.setBounds(1294, 810, 330, 2);
		contentPane.add(separator);

		comboBox = new JComboBox();
		comboBox.addItemListener(new ItemListener() {
			//Rostislav 
			/**
			 * permet de changer entre le particule
			 */
			public void itemStateChanged(ItemEvent arg0) {
				if(	comboBox.getSelectedItem().toString() == "Électron (e-)") {
					zoneAnimation.setCharge(-1.6 * Math.pow(10, -19));
					zoneAnimation.setMasse(9.1 * Math.pow(10, -31));
				}
				if(comboBox.getSelectedItem().toString()== "Gros électron (2e-)") {
					zoneAnimation.setCharge(2*-1.6 * Math.pow(10, -19));
					zoneAnimation.setMasse(9.1 * Math.pow(10, -31));
				}
				if(comboBox.getSelectedItem().toString()== "Particule spéciale (e)") {
					zoneAnimation.setCharge(1.6 * Math.pow(10, -19));
					zoneAnimation.setMasse(9.1 * Math.pow(10, -31));
				}
				if(comboBox.getSelectedItem().toString()== "Grosse particule spéciale (2e)") {
					zoneAnimation.setCharge(2*1.6 * Math.pow(10, -19));
					zoneAnimation.setMasse(9.1 * Math.pow(10, -31));
				}
				zoneAnimation.setCouleurP(comboBox.getSelectedItem().toString());
				repaint();
			}
		});
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"\u00C9lectron (e-)", "Gros \u00E9lectron (2e-)", "Particule sp\u00E9ciale (e)", "Grosse particule sp\u00E9ciale (2e)"}));
		comboBox.setBounds(1357, 721, 211, 22);
		contentPane.add(comboBox);

		JLabel lblTypeParticule = new JLabel("Type de particule :");
		lblTypeParticule.setFont(new Font("Yu Gothic Medium", Font.BOLD, 13));
		lblTypeParticule.setBounds(1386, 686, 140, 32);
		contentPane.add(lblTypeParticule);

		panelOption = new PanelOption(this);
		panelOption.setBounds(1312, 93, 290, 240);
		contentPane.add(panelOption);
		
		//Louis
		/**
		 * permet d'ajouter les ecouteurs perso
		 */
		panelOption.addPanelListener(new PanelCyclotronListener() {
			@Override//Louis
			/**
			 * permet de set la vitesse de sortir du cyclotron
			 */
			public void changerVitesse(double i) {
				zoneAnimation.setVitesse(i/100);
			}
		});
		//Louis
		/**
		 * permet d'ajouter les ecouteurs perso
		 */
		panelOption.addPanelListener(new PanelSPListener() {
			@Override
			//Louis
			/**
			 * permet de set la direction du systeme de plaque
			 */
			public void changerDirectionSP(boolean direction) {
				zoneAnimation.setDirectionSP(direction);
			}
			@Override
			//Louis
			/**
			 * permet de set la valeur du champ electrique du systeme de plaque
			 */
			public void changerChampElectriqueSP(double valeur) {
				zoneAnimation.setESP(valeur);
			}		
		});
		//Louis
		/**
		 * permet d'ajouter les ecouteurs perso
		 */
		panelOption.addPanelListener(new PanelZMListener() {
			@Override
			//Louis
			/**
			 * permet de set la direction de la zone magnetique
			 */
			public void changerDirectionZM(boolean direction) {
				zoneAnimation.setDirectionZM(direction);				
			}
			@Override
			//Louis
			/**
			 * permet de set la valeur du champ magnetique de la zone magnetique
			 */
			public void changerChampMagnetiqueZM(double valeur) {
				zoneAnimation.setBZM(valeur);			
			}
			
		});
		//Louis
		/**
		 * permet d'ajouter les ecouteurs perso
		 */
		panelOption.addPanelListener(new PanelTigeListener() {
			@Override
			//Louis 
			/**
			 * permet de set la densite de la tige
			 */
			public void changerDensiteTige(double valeur) {
				zoneAnimation.setDensiteTige(valeur);		
			}			
		});
		//Louis
		/**
		 * permet d'ajouter les ecouteurs perso
		 */
		panelOption.addPanelListener(new PanelFilListener() {
			@Override
			//Louis
			/**
			 * permet de set la direction du courant dans le fil
			 */
			public void changerDirectionFil(boolean direction) {
				zoneAnimation.setDirectionFil(direction);
				
			}
			@Override
			//Louis
			/**
			 * permet de set la valeur du champ magnetique du fil
			 */
			public void changerChampMagnetiqueFil(double valeur) {
				zoneAnimation.setBFil(valeur*1000);		
			}		
		});
		//Louis
		/**
		 * permet d'ajouter les ecouteurs perso
		 */
		panelOption.addPanelListener(new PanelZAListener() {
			@Override
			//louis
			/**
			 * permet de set la largeur de la zone d'arrivee
			 */
			public void changerLargeurZA(double valeur) {
				zoneAnimation.setLargeurZA(valeur/100);
			}
			@Override
			//Louis
			/**
			 * permet de set la hauteur de la zone d'arrivee
			 */
			public void changerhauteurZA(double valeur) {
				zoneAnimation.setHauteurZA(valeur/100);
				
			}

			
		
			
		});
		
		boutonObjets = new BoutonObjets(zoneAnimation, panelOption, boutonAnim);
		boutonObjets.setBackground(new Color(135, 206, 235));
		boutonObjets.setBounds(1307, 366, 300, 318);
		contentPane.add(boutonObjets);
		boutonObjets.setLayout(null);

		boutonAnim = new BoutonAnim(zoneAnimation, boutonObjets);
		boutonAnimActivee(zoneAnimation);

		boutonAnim.setBackground(new Color(135, 206, 235));
		boutonAnim.setBounds(1306, 32, 300, 48);
		contentPane.add(boutonAnim);

		BoutonAnim boutonAnim_1 = new BoutonAnim(zoneAnimation, boutonObjets);
		boutonAnim_1.setBounds(247, 208, -207, -71);

		JSeparator separator_2 = new JSeparator();
		separator_2.setBackground(Color.BLACK);
		separator_2.setBounds(1284, 340, 330, 2);
		contentPane.add(separator_2);

		JSeparator separator_1 = new JSeparator();
		separator_1.setBackground(Color.BLACK);
		separator_1.setBounds(1284, 82, 330, 2);
		contentPane.add(separator_1);

		boutonAnimActivee(zoneAnimation);

		lblMs = new JLabel(v+" m/s");
		
		lblMs.setBounds(299, 835, 118, 16);
		
		contentPane.add(lblMs);

	 lblMs_1 = new JLabel("0.0 m/s\u00B2");
		lblMs_1.setBounds(299, 885, 187, 16);
		contentPane.add(lblMs_1);

		lblNewLabel = new JLabel(fE+" N");
		lblNewLabel.setBounds(880, 841, 101, 16);
		contentPane.add(lblNewLabel);

	    label = new JLabel(fM+" N");
		
		label.setBounds(880, 885, 101, 16);
		contentPane.add(label);

		 lblS = new JLabel(t+" s");
		lblS.setBounds(1403, 885, 147, 16);
		contentPane.add(lblS);
		
		JLabel lblLesBoutonsPour = new JLabel("Les boutons pour placer les objets");
		lblLesBoutonsPour.setHorizontalAlignment(SwingConstants.CENTER);
		lblLesBoutonsPour.setFont(new Font("Yu Gothic Medium", Font.BOLD, 13));
		lblLesBoutonsPour.setBounds(1322, 346, 266, 16);
		contentPane.add(lblLesBoutonsPour);
		
		JSlider slider = new JSlider();
		slider.setBackground(new Color(135, 206, 235));
		slider.setBounds(1208, 829, 283, 26);
		slider.setValue(10);
		slider.addChangeListener(new ChangeListener() {
	//Rostislav
			/**
			 * permet de modifier le thread
			 */
			public void stateChanged(ChangeEvent arg0) {
				zoneAnimation.setThread(slider.getValue());
				repaint();
			}
		});
		slider.setMinimum(5);
		slider.setMaximum(55);
		slider.setMajorTickSpacing(10);
		contentPane.add(slider);

		
		JLabel lblVitesseDanimation = new JLabel("Vitesse d'animation :");
		lblVitesseDanimation.setFont(new Font("Yu Gothic Medium", Font.BOLD, 19));
		lblVitesseDanimation.setBounds(985, 833, 211, 32);
		contentPane.add(lblVitesseDanimation);
		
		JLabel lblRapide = new JLabel("Rapide\r\n");
		lblRapide.setBounds(1202, 856, 47, 16);
		contentPane.add(lblRapide);
		
		JLabel lblLente = new JLabel("Lente\r\n");
		lblLente.setBounds(1473, 856, 47, 16);
		contentPane.add(lblLente);

	
	    zoneAnimation.leverEvenParticuleIteration(v, fM, fE, a , t);
	    

	}

	// leProfesseur
	/**
	 * 
	 * @param leBouton
	 *            le bouton qui recoit l'image
	 * @param fichierImage
	 *            l'image qui est envoyer sur le bouton
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
		imgLue.flush();
		// imgRedim.flush();

	}
	
	//Rostislav
	/**
	 * permet d'active ou desactive les buttons d'animations
	 * @param zoneAnimation
	 */
	private void boutonAnimActivee(ZoneAnimation zoneAnimation) {

		if (!zoneAnimation.getListC().isEmpty() && !zoneAnimation.getListZA().isEmpty()) {
			boutonAnim.enableButton();
		} else {
			boutonAnim.disableButton();
		}
	}
	//Rostislav
	public ZoneAnimation getZoneAnimation() {
		return zoneAnimation;
	}
	//Rostislav
	public void setZoneAnimation(ZoneAnimation zoneAnimation) {
		this.zoneAnimation = zoneAnimation;
	}
}
