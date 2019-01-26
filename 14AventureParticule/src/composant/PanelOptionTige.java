package composant;

import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.event.EventListenerList;

import ressources.PanelTigeListener;

import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;

/**
 * 
 * @author Louis Roberge
 * panel qui contient les options de l'objet Tige.
 *
 */
public class PanelOptionTige extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final EventListenerList OBJETS_ENREGISTRES = new EventListenerList();

	/**
	 * Creation du panel
	 */
	public PanelOptionTige() {
		setBackground(new Color(135, 206, 235));
		setLayout(null);
		
		JSlider sldDensite = new JSlider();
		sldDensite.setValue(5);
		sldDensite.addChangeListener(new ChangeListener() {
			/**
			 * permet de savoir quand la valeur du slider change
			 */
			public void stateChanged(ChangeEvent e) {
				//d
				leverEvenDensiteTige(sldDensite.getValue()*Math.pow(10, -6));				
				//f
			}
		});
		sldDensite.setSnapToTicks(true);
		sldDensite.setPaintTicks(true);
		sldDensite.setPaintLabels(true);
		sldDensite.setMinimum(1);
		sldDensite.setMaximum(9);
		sldDensite.setMajorTickSpacing(1);
		sldDensite.setForeground(Color.BLACK);
		sldDensite.setBackground(new Color(135, 206, 235));
		sldDensite.setBounds(24, 54, 200, 74);
		add(sldDensite);
		
		JLabel lblLaValeurDe = new JLabel("La valeur de la densit\u00E9 de charge :");
		lblLaValeurDe.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 14));
		lblLaValeurDe.setBounds(24, 26, 245, 19);
		add(lblLaValeurDe);
		
		JLabel lblCm = new JLabel("\u03BCC/m");
		lblCm.setBounds(237, 98, 56, 16);
		add(lblCm);

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
	 * permet d'ajouter les objets aux evenement 
	 * @param  panelTigeListener le nom de la variable
	 */
	public void addPanelListener(PanelTigeListener panelTigeListener) {
		OBJETS_ENREGISTRES.add(PanelTigeListener.class, panelTigeListener);
		
	}

}
