package composant;

import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.Color;
import javax.swing.event.ChangeListener;
import javax.swing.event.EventListenerList;
import ressources.PanelCyclotronListener;

import javax.swing.event.ChangeEvent;

/**
 * 
 * @author Louis Roberge 
 * panel qui contient les options de l'objet cyclotron
 *
 */
public class PanelOptionCyclotron extends JPanel {

	private static final long serialVersionUID = 1L;
	private final EventListenerList OBJETS_ENREGISTRES = new EventListenerList();
	
	

	/**
	 * création du panel
	 * @param parent le panelOption 
	 */
	public PanelOptionCyclotron(PanelOption parent) {
		setBackground(new Color(135, 206, 235));
		setLayout(null);

		JSlider slider = new JSlider();
		slider.addChangeListener(new ChangeListener() {
			/**
			 * permet de savoir quand la valeur du slider change
			 */
			public void stateChanged(ChangeEvent arg0) {
				//d			
				leverEvenChangerVitesse(slider.getValue());
				//f
			}
		});
		slider.setSnapToTicks(true);
		slider.setPaintLabels(true);
		slider.setPaintTicks(true);
		slider.setForeground(new Color(0, 0, 0));
		slider.setBackground(new Color(135, 206, 235));
		slider.setFont(new Font("Arial", Font.BOLD, 13));
		slider.setMinorTickSpacing(5);
		slider.setValue(20);
		slider.setMajorTickSpacing(10);
		slider.setMaximum(50);
		slider.setBounds(22, 95, 220, 61);
		add(slider);

		JLabel lblNewLabel = new JLabel(
				"<html>Pourcentage de la vitesse de la lumi\u00E8re <br/> \u00E0 la sortie du cyclotron :</html>");
		lblNewLabel.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 14));
		lblNewLabel.setBounds(12, 13, 390, 72);
		add(lblNewLabel);

		JLabel label = new JLabel("%");
		label.setBounds(254, 132, 56, 16);
		add(label);

	}
	/**
	 * permet de lever l'evenement du changement de vitesse
	 * @param vitesse la valeur de la vitesse lever
	 */
	private void leverEvenChangerVitesse(int i) {
		for (PanelCyclotronListener ecout : OBJETS_ENREGISTRES.getListeners(PanelCyclotronListener.class)) {
			ecout.changerVitesse(i);
		}
	}
	/**
	 * permet d'ajouter les objets aux evenement 
	 * @param panelListener le nom de la variable
	 */
	public void addPanelListener(PanelCyclotronListener panelListener) {
		OBJETS_ENREGISTRES.add(PanelCyclotronListener.class, panelListener);
	}
}
