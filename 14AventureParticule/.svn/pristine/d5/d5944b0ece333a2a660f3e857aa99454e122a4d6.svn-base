package composant;

import javax.swing.JPanel;
import javax.swing.event.EventListenerList;

import aaplication.App14AventureParticule;
import ressources.PanelCyclotronListener;
import ressources.PanelFilListener;
import ressources.PanelSPListener;
import ressources.PanelTigeListener;
import ressources.PanelZAListener;
import ressources.PanelZMListener;


/**
 * 
 * @author louis Roberge
 * panel qui contient tout les autres panels qui concerne les options des objets
 *
 */
public class PanelOption extends JPanel {

	
	private static final long serialVersionUID = 1L;
	private PanelOptionCyclotron panelOptionCyclotron;
	private PanelOptionSystemDePlaque panelOptionSystemDePlaque;
	private PanelOptionZoneMagnetique panelOptionZoneMagnetique;
	private PanelOptionFil panelOptionFil;
	private PanelOptionTige panelOptionTige;
	private PanelOptionZoneArrivee panelOptionZoneArrivee;
	private boolean p1=true,p2=false, p3=false, p4=false, p5=false, p6=false;
	private final EventListenerList OBJETS_ENREGISTRES = new EventListenerList();

	
	/**
	 * création du panel
	 * @param parent l'application
	 */
	public PanelOption(App14AventureParticule parent) {
		setLayout(null);

		panelOptionCyclotron = new PanelOptionCyclotron(this);
		panelOptionCyclotron.setBounds(0, 0, 296, 258);
		add(panelOptionCyclotron);		
		panelOptionCyclotron.addPanelListener(new PanelCyclotronListener() {
			@Override
			/**
			 * permet de changer le pourcentage de la vitesse de la lumière de la particule
			 */
			public void changerVitesse(double i) {
				leverEvenChangerVitesse(i);	
			}						
		});
		panelOptionSystemDePlaque = new PanelOptionSystemDePlaque();
		panelOptionSystemDePlaque.setBounds(0, 0, 296, 258);
		add(panelOptionSystemDePlaque);
		panelOptionSystemDePlaque.addPanelListener(new PanelSPListener() {
			@Override
			/**
			 * permet de changer la direction des plaques du systeme de plaques
			 */
			public void changerDirectionSP(boolean direction) {
				leverEvenChangerDirectionSP(direction);		
			}
			@Override
			/**
			 * permet de changer le champ électrique du systeme de plaques
			 */
			public void changerChampElectriqueSP(double valeur) {
				leverEvenChampElectriqueSP(valeur);						
			}			
		});
		panelOptionSystemDePlaque.setVisible(p2);
		panelOptionZoneMagnetique = new PanelOptionZoneMagnetique();
		panelOptionZoneMagnetique.setBounds(0, 0, 296, 258);
		add(panelOptionZoneMagnetique);
		panelOptionZoneMagnetique.addPanelListener(new PanelZMListener() {
			@Override
			/**
			 * permet de changer la direction de la zone magnétique
			 */
			public void changerDirectionZM(boolean direction) {
				leverEvenChangerDirectionZM(direction);		
			}
			@Override
			/**
			 * permet de changer la valeur du champ magnétique de la zone magnétique 
			 */
			public void changerChampMagnetiqueZM(double valeur) {
				leverEvenChampMagnetiqueZM(valeur);						
			}			
		});
		panelOptionZoneMagnetique.setVisible(p3);

		panelOptionFil = new PanelOptionFil();
		panelOptionFil.setBounds(0, 0, 296, 258);
		add(panelOptionFil);
		panelOptionFil.addPanelListener(new PanelFilListener() {
			@Override
			/**
			 * permet de changer la direction du fil
			 */
			public void changerDirectionFil(boolean direction) {
				leverEvenChangerDirectionFil(direction);		
			}
			@Override
			/**
			 * permet de changer la valeur du courant du fil 
			 */
			public void changerChampMagnetiqueFil(double valeur) {
				leverEvenChampMagnetiqueFil(valeur);		
				
			}		
		});
		panelOptionFil.setVisible(p4);
		
		panelOptionTige = new PanelOptionTige();
		panelOptionTige.setBounds(0, 0, 296, 258);
		add(panelOptionTige);
		panelOptionTige.addPanelListener(new PanelTigeListener() {
			@Override
			/**
			 * permet de changer la densite de la tige
			 */
			public void changerDensiteTige(double valeur) {
			leverEvenDensiteTige(valeur);
			}						
		});
		panelOptionTige.setVisible(p5);

		panelOptionZoneArrivee = new PanelOptionZoneArrivee();
		panelOptionZoneArrivee.setBounds(0, 0, 296, 258);
		add(panelOptionZoneArrivee);
		panelOptionZoneArrivee.addPanelListener(new PanelZAListener() {

			@Override
			/**
			 * permet de changer la largeur de la zone d'arrivée 
			 */
			public void changerLargeurZA(double valeur) {
				leverEvenChangerLargeurZA(valeur);			
			}
			@Override
			/**
			 * permet de changer la hauteur de la zone d'arrivée
			 */
			public void changerhauteurZA(double valeur) {
				leverEvenChangerHauteurZA(valeur);		
				
			}
								
		});
		panelOptionZoneArrivee.setVisible(p6);

	}

	/**
	 * méthode très répétitive qui permet de rendre visible un panel et de cacher les autres
	 * @param numero le numero qui correspont aux panel
	 */
	public void setPanel(int numero) {
		if (numero == 1) {
			
			this.p1 = true;
			this.p2 = false;
			this.p3 = false;
			this.p4 = false;
			this.p5 = false;
			this.p6 = false;
			
			
		}
		if (numero == 2) {
			this.p1 = false;
			this.p2 = true;
			this.p3 = false;
			this.p4 = false;
			this.p5 = false;
			this.p6 = false;
		}
		if (numero == 3) {
			this.p1 = false;
			this.p2 = false;
			this.p3 = true;
			this.p4 = false;
			this.p5 = false;
			this.p6 = false;
		}
		if (numero == 4) {
			this.p1 = false;
			this.p2 = false;
			this.p3 = false;
			this.p4 = false;
			this.p5 = true;
			this.p6 = false;
		}
		if (numero == 5) {
			this.p1 = false;
			this.p2 = false;
			this.p3 = false;
			this.p4 = true;
			this.p5 = false;
			this.p6 = false;
		}
		if (numero == 6) {
			this.p1 = false;
			this.p2 = false;
			this.p3 = false;
			this.p4 = false;
			this.p5 = false;
			this.p6 = true;
		}
		panelOptionCyclotron.setVisible(p1);
		panelOptionSystemDePlaque.setVisible(p2);
		panelOptionZoneMagnetique.setVisible(p3);
		panelOptionFil.setVisible(p4);
		panelOptionTige.setVisible(p5);
		panelOptionZoneArrivee.setVisible(p6);
	}
	
	/**
	 * permet de lever l'evenement du changement de vitesse
	 * @param vitesse la valeur de la vitesse lever
	 */
	private void leverEvenChangerVitesse(double vitesse) {
		for (PanelCyclotronListener ecout : OBJETS_ENREGISTRES.getListeners(PanelCyclotronListener.class)) {
			ecout.changerVitesse(vitesse);
		}
	}
	/**
	 * permet de lever l'evenement du changement de direction du Systeme de plaque
	 * @param direction la direction du systeme de plaque
	 */
	private void leverEvenChangerDirectionSP(boolean direction) {
		for (PanelSPListener ecout : OBJETS_ENREGISTRES.getListeners(PanelSPListener.class)) {
			ecout.changerDirectionSP(direction);
		}
	}
	/**
	 *  permet de lever l'evenement du changement de la valeur du champ electrique du Systeme de plaque
	 * @param valeur la valeur du champ electrique
	 */
	private void leverEvenChampElectriqueSP(double valeur) {
		for (PanelSPListener ecout : OBJETS_ENREGISTRES.getListeners(PanelSPListener.class)) {
			ecout.changerChampElectriqueSP(valeur);
		}
	}
	/**
	 *  permet de lever l'evenement du changement de direction de la zone magnetique
	 * @param direction la direction de la zone magnetique
	 */
	private void leverEvenChangerDirectionZM(boolean direction) {
		for (PanelZMListener ecout : OBJETS_ENREGISTRES.getListeners(PanelZMListener.class)) {
			ecout.changerDirectionZM(direction);
		}
	}
	/**
	 * permet de lever l'evenement du changement de la valeur du champ magnetique de la zone magnetique
	 * @param valeur la valeur du champ magnetique
	 */
	private void leverEvenChampMagnetiqueZM(double valeur) {
		for (PanelZMListener ecout : OBJETS_ENREGISTRES.getListeners(PanelZMListener.class)) {
			ecout.changerChampMagnetiqueZM(valeur);
		}
	}
	/**
	 * permet de lever l'evenement du changement de la valeur de la densite de la tige
	 * @param valeur la valeur de la tige
	 */
	private void leverEvenDensiteTige(double valeur) {
		for (PanelTigeListener ecout : OBJETS_ENREGISTRES.getListeners(PanelTigeListener.class)) {
			ecout.changerDensiteTige(valeur);
		}
	}
	/**
	 * permet de lever l'evenement du changement de la direction du fil 
	 * @param direction la direction du sens du courant du fil
	 */
	private void leverEvenChangerDirectionFil(boolean direction) {
		for (PanelFilListener ecout : OBJETS_ENREGISTRES.getListeners(PanelFilListener.class)) {
			ecout.changerDirectionFil(direction);
		}
	}
	/**
	 * permet de lever l'evenement du changement de la valeur du champ Magnetique du fil
	 * @param valeur la valeur du champ magnetique
	 */
	private void leverEvenChampMagnetiqueFil(double valeur) {
		for (PanelFilListener ecout : OBJETS_ENREGISTRES.getListeners(PanelFilListener.class)) {
			ecout.changerChampMagnetiqueFil(valeur);
		}
	}
	/**
	 * permet de lever l'evenement du changement de la largeur de la zone d'arrivee 
	 * @param valeur la valeur de la largeur
	 */
	private void leverEvenChangerLargeurZA(double valeur) {
		for (PanelZAListener ecout : OBJETS_ENREGISTRES.getListeners(PanelZAListener.class)) {
			ecout.changerLargeurZA(valeur);
		}
	}
	/**
	 * permet de lever l'evenement du changement de la hauteur de la zone d'arrivee
	 * @param valeur la valeur de la hauteur
	 */
	private void leverEvenChangerHauteurZA(double valeur) {
		for (PanelZAListener ecout : OBJETS_ENREGISTRES.getListeners(PanelZAListener.class)) {
			ecout.changerhauteurZA(valeur);
		}
	}
	/**
	 * permet d'ajouter les objets aux evenement 
	 * @param panelListener le nom de la variable
	 */
	public void addPanelListener(PanelCyclotronListener panelListener) {
		OBJETS_ENREGISTRES.add(PanelCyclotronListener.class, panelListener);
	}
	/**
	 * permet d'ajouter les objets aux evenement 
	 * @param panelListener le nom de la variable
	 */
	public void addPanelListener(PanelSPListener panelListener) {
		OBJETS_ENREGISTRES.add(PanelSPListener.class, panelListener);
	}
	/**
	 * permet d'ajouter les objets aux evenement 
	 * @param panelListener le nom de la variable
	 */
	public void addPanelListener(PanelZMListener panelListener) {
		OBJETS_ENREGISTRES.add(PanelZMListener.class, panelListener);
	}
	/**
	 * permet d'ajouter les objets aux evenement 
	 * @param panelListener le nom de la variable
	 */
	public void addPanelListener(PanelTigeListener panelListener) {
		OBJETS_ENREGISTRES.add(PanelTigeListener.class, panelListener);
	}
	/**
	 * permet d'ajouter les objets aux evenement 
	 * @param panelFilListener le nom de la variable
	 */
	public void addPanelListener(PanelFilListener panelFilListener) {
		OBJETS_ENREGISTRES.add(PanelFilListener.class, panelFilListener);		
	}
	/**
	 * permet d'ajouter les objets aux evenement 
	 * @param panelZAListener le nom de la variable
	 */
	public void addPanelListener(PanelZAListener panelZAListener) {
		OBJETS_ENREGISTRES.add(PanelZAListener.class, panelZAListener);
		
	}

}
