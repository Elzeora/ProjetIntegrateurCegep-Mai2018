package composant;

import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.event.EventListenerList;
import ressources.PanelZMListener;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;

/**
 * 
 * @author Louis Roberge
 *panel qui contient les options de l'objet ZoneMagnetique.
 */
public class PanelOptionZoneMagnetique extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final EventListenerList OBJETS_ENREGISTRES = new EventListenerList();
	private final ButtonGroup buttonGroup = new ButtonGroup();

	/**
	 * Creation du panel
	 */
	public PanelOptionZoneMagnetique() {
		setBackground(new Color(135, 206, 235));
		setLayout(null);
		
		JSlider sldCMagnetique = new JSlider();
		sldCMagnetique.setValue(5);
		sldCMagnetique.addChangeListener(new ChangeListener() {
			/**
			 * permet de savoir quand la valeur du slider change
			 */
			public void stateChanged(ChangeEvent e) {
				//d
				leverEvenChampMagnetiqueZM(sldCMagnetique.getValue()*Math.pow(10, -2));
				//f
			}
		});
		sldCMagnetique.setSnapToTicks(true);
		sldCMagnetique.setPaintTicks(true);
		sldCMagnetique.setPaintLabels(true);
		sldCMagnetique.setMinimum(1);
		sldCMagnetique.setMaximum(10);

		sldCMagnetique.setMajorTickSpacing(1);
		sldCMagnetique.setForeground(Color.BLACK);
		sldCMagnetique.setBackground(new Color(135, 206, 235));
		sldCMagnetique.setBounds(24, 135, 200, 74);
		add(sldCMagnetique);
		
		JLabel lblT = new JLabel("E-2 T");
		lblT.setBounds(235, 179, 56, 16);
		add(lblT);
		
		JLabel lblLaValeurDu = new JLabel("La valeur du champ magn\u00E9tique\r\n :");
		lblLaValeurDu.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 14));
		lblLaValeurDu.setBounds(24, 106, 237, 16);
		add(lblLaValeurDu);
		
		JRadioButton btnRBas = new JRadioButton("Bas\r\n");
		buttonGroup.add(btnRBas);
		btnRBas.setBackground(new Color(135, 206, 235));
		btnRBas.setBounds(147, 51, 68, 25);
		add(btnRBas);
		
		JRadioButton btnRH = new JRadioButton("Haut\r\n");
		btnRH.addChangeListener(new ChangeListener() {
			/**
			 * permet de savoir quand l'état du bouton radio change
			 */
			public void stateChanged(ChangeEvent e) {
				//d
				if(btnRH.isSelected()) {
					leverEvenChangerDirectionZM(true);
				}else {
					leverEvenChangerDirectionZM(false);
				}
				
				//f
			}
		});
		buttonGroup.add(btnRH);
		btnRH.setSelected(true);
		btnRH.setBackground(new Color(135, 206, 235));
		btnRH.setBounds(34, 51, 68, 25);
		add(btnRH);
		
		JLabel lblDirectionDuChamp = new JLabel("Direction du champ magn\u00E9tique :");
		lblDirectionDuChamp.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 14));
		lblDirectionDuChamp.setBounds(24, 26, 237, 16);
		add(lblDirectionDuChamp);

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
	 * permet d'ajouter les objets aux evenement 
	 * @param panelZMListener le nom de la variable
	 */
	public void addPanelListener(PanelZMListener panelZMListener) {
		OBJETS_ENREGISTRES.add(PanelZMListener.class, panelZMListener);
		
	}

}
