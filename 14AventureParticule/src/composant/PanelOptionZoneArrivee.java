package composant;

import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.event.EventListenerList;
import ressources.PanelZAListener;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;
/**
 * 
 * @author Louis Roberge
 *panel qui contient les options de l'objet ZoneArrivee
 */
public class PanelOptionZoneArrivee extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final EventListenerList OBJETS_ENREGISTRES = new EventListenerList();

	/**
	 * Creation du panel
	 */
	public PanelOptionZoneArrivee() {
		setBackground(new Color(135, 206, 235));
		setLayout(null);
		
		JSlider sldLargeur = new JSlider();
		sldLargeur.setMinimum(1);
		sldLargeur.addChangeListener(new ChangeListener() {
			/**
			 * permet de savoir quand la valeur du slider change
			 */
			public void stateChanged(ChangeEvent e) {
				//d
				leverEvenChangerLargeurZA(sldLargeur.getValue());			
				//f
			}
		});
		sldLargeur.setValue(15);
		sldLargeur.setSnapToTicks(true);
		sldLargeur.setPaintTicks(true);
		sldLargeur.setPaintLabels(true);
		sldLargeur.setMaximum(15);
		sldLargeur.setMajorTickSpacing(2);
		sldLargeur.setForeground(Color.BLACK);
		sldLargeur.setBackground(new Color(135, 206, 235));
		sldLargeur.setBounds(24, 42, 200, 74);
		add(sldLargeur);
		
		JLabel lblLargeurDeLa = new JLabel("Largeur de la zone d'arriv\u00E9e :");
		lblLargeurDeLa.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 14));
		lblLargeurDeLa.setBounds(24, 13, 245, 16);
		add(lblLargeurDeLa);
		
		JSlider sldHauteur = new JSlider();
		sldHauteur.setMinimum(1);
		sldHauteur.addChangeListener(new ChangeListener() {
			/**
			 * permet de savoir quand la valeur du slider change
			 */
			public void stateChanged(ChangeEvent e) {
				//		
				leverEvenChangerHauteurZA(sldHauteur.getValue());		
				//f
			}
		});
		sldHauteur.setValue(10);
		sldHauteur.setSnapToTicks(true);
		sldHauteur.setPaintTicks(true);
		sldHauteur.setPaintLabels(true);
		sldHauteur.setMaximum(15);
		sldHauteur.setMajorTickSpacing(2);
		sldHauteur.setForeground(Color.BLACK);
		sldHauteur.setBackground(new Color(135, 206, 235));
		sldHauteur.setBounds(24, 158, 200, 74);
		add(sldHauteur);
		
		JLabel lblLargeurDeLa_1 = new JLabel("Hauteur de la zone d'arriv\u00E9e :");
		lblLargeurDeLa_1.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 14));
		lblLargeurDeLa_1.setBounds(24, 129, 245, 16);
		add(lblLargeurDeLa_1);
		
		JLabel lblNewLabel = new JLabel("1E-10 m");
		lblNewLabel.setBounds(231, 202, 56, 16);
		add(lblNewLabel);
		
		JLabel lbleM = new JLabel("1E-10 m");
		lbleM.setBounds(231, 86, 56, 16);
		add(lbleM);

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
	 * @param panelZAListener le nom de la variable
	 */
	public void addPanelListener(PanelZAListener panelZAListener) {
		OBJETS_ENREGISTRES.add(PanelZAListener.class, panelZAListener);
		
	}

}
