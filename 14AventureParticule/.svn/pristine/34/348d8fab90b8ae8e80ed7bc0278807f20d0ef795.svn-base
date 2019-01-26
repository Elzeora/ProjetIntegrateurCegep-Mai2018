package composant;

import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JSlider;
import javax.swing.event.EventListenerList;

import ressources.PanelSPListener;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;


/**
 * 
 * @author Louis Roberge
 * panel qui contient les options de l'objet SystemDePlaque.
 *
 */
public class PanelOptionSystemDePlaque extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private final EventListenerList OBJETS_ENREGISTRES = new EventListenerList();

	/**
	 * Creation du panel
	 */
	public PanelOptionSystemDePlaque() {
		setBackground(new Color(135, 206, 235));
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Direction du champ \u00E9lectrique :");
		lblNewLabel.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 14));
		lblNewLabel.setBounds(24, 26, 219, 16);
		add(lblNewLabel);
		
		JRadioButton btnRHaut = new JRadioButton("Haut\r\n");
		btnRHaut.addChangeListener(new ChangeListener() {
			/**
			 * permet de savoir quand le bouton radio change d'état
			 */
			public void stateChanged(ChangeEvent arg0) {
				//d
				if(btnRHaut.isSelected()) {
					leverEvenChangerDirectionSP(true);
				}else {
					leverEvenChangerDirectionSP(false);
				}
				//f
			}
		});
		btnRHaut.setBackground(new Color(135, 206, 235));
		btnRHaut.setSelected(true);
		buttonGroup.add(btnRHaut);
		btnRHaut.setBounds(34, 51, 68, 25);
		add(btnRHaut);
		
		JRadioButton btnRBas = new JRadioButton("Bas\r\n");
		btnRBas.setBackground(new Color(135, 206, 235));
		buttonGroup.add(btnRBas);
		btnRBas.setBounds(148, 51, 68, 25);
		add(btnRBas);
		
		JLabel lblLaValeurDu = new JLabel("la valeur du champ \u00E9lectrique :");
		lblLaValeurDu.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 14));
		lblLaValeurDu.setBounds(24, 106, 219, 16);
		add(lblLaValeurDu);
		
		JSlider sldChampE = new JSlider();
		sldChampE.setValue(5);
		sldChampE.addChangeListener(new ChangeListener() {
			/**
			 * permet de savoir quand la valeur du slider change de la valeur
			 */
			public void stateChanged(ChangeEvent e) {
				//d
				leverEvenChampElectriqueSP(sldChampE.getValue()*Math.pow(10, 5));
				//f
			}
		});
		sldChampE.setBackground(new Color(135, 206, 235));
		sldChampE.setForeground(new Color(0, 0, 0));
		sldChampE.setSnapToTicks(true);
		sldChampE.setPaintTicks(true);
		sldChampE.setPaintLabels(true);
		sldChampE.setMajorTickSpacing(1);
		sldChampE.setMinimum(1);
		sldChampE.setMaximum(10);
		sldChampE.setBounds(24, 135, 200, 74);
		add(sldChampE);
		
		JLabel lblNc = new JLabel("N/C");
		lblNc.setFont(new Font("Arial", lblNc.getFont().getStyle(), lblNc.getFont().getSize()));
		lblNc.setBounds(236, 179, 56, 16);
		add(lblNc);

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
	 * permet d'ajouter les objets aux evenement 
	 * @param panelSPListener le nom de la variable
	 */
	public void addPanelListener(PanelSPListener panelSPListener) {
		OBJETS_ENREGISTRES.add(PanelSPListener.class, panelSPListener);
		
	}
	
}
