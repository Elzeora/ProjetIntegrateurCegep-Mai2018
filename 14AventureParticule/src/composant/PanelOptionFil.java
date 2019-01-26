package composant;

import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.event.EventListenerList;

import ressources.PanelFilListener;

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
 * panel qui contient les options de l'objet Fil.
 *
 */
public class PanelOptionFil extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final EventListenerList OBJETS_ENREGISTRES = new EventListenerList();
	private final ButtonGroup buttonGroup = new ButtonGroup();

	/**
	 * Creation du panel
	 */
	public PanelOptionFil() {
		setBackground(new Color(135, 206, 235));
		setLayout(null);
		
		JSlider sldCMagnetique = new JSlider();
		sldCMagnetique.addChangeListener(new ChangeListener() {
			/**
			 * permet de savoir quand la valeur du slider change
			 */
			public void stateChanged(ChangeEvent e) {
				//d
				leverEvenChampMagnetiqueFil(sldCMagnetique.getValue());
				
				//f
			}
		});
		sldCMagnetique.setSnapToTicks(true);
		sldCMagnetique.setPaintTicks(true);
		sldCMagnetique.setPaintLabels(true);
		sldCMagnetique.setMinimum(2);
		sldCMagnetique.setMaximum(8);
		sldCMagnetique.setMajorTickSpacing(1);
		sldCMagnetique.setForeground(Color.BLACK);
		sldCMagnetique.setBackground(new Color(135, 206, 235));
		sldCMagnetique.setBounds(24, 135, 200, 74);
		add(sldCMagnetique);
		
		JLabel lblT = new JLabel("kA");
		lblT.setBounds(236, 179, 44, 16);
		add(lblT);
		
		JLabel lblLaValeurDu = new JLabel("La valeur du courant  :");
		lblLaValeurDu.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 14));
		lblLaValeurDu.setBounds(24, 106, 245, 16);
		add(lblLaValeurDu);
		
		JRadioButton btnRNegatif = new JRadioButton("N\u00E9gative");
		buttonGroup.add(btnRNegatif);
		btnRNegatif.setBackground(new Color(135, 206, 235));
		btnRNegatif.setBounds(147, 51, 77, 25);
		add(btnRNegatif);
		
		JRadioButton btnRPositif = new JRadioButton("Positive");
		btnRPositif.addChangeListener(new ChangeListener() {
			/**
			 * permet de savoir quand la valeur du slider change
			 */
			public void stateChanged(ChangeEvent e) {
				//d
				if(btnRPositif.isSelected()) {
					leverEvenChangerDirectionFil(true);
				}else {
					leverEvenChangerDirectionFil(false);
				}
				
				//f
			}
		});
		buttonGroup.add(btnRPositif);
		btnRPositif.setSelected(true);
		btnRPositif.setBackground(new Color(135, 206, 235));
		btnRPositif.setBounds(24, 51, 81, 25);
		add(btnRPositif);
		
		JLabel lblDirectionDuChamp = new JLabel("Direction du champ magn\u00E9tique\r\n :");
		lblDirectionDuChamp.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 14));
		lblDirectionDuChamp.setBounds(24, 26, 228, 16);
		add(lblDirectionDuChamp);

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
	 * permet d'ajouter les objets aux evenement 
	 * @param panelFilListener le nom de la variable
	 */
	public void addPanelListener(PanelFilListener panelFilListener) {
		OBJETS_ENREGISTRES.add(PanelFilListener.class, panelFilListener);
		
	}

}
