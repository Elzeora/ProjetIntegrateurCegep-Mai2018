package ressources;

import java.util.EventListener;
/**
 * 
 * @author Louis Roberge
 */
public interface PanelZAListener extends EventListener {
	
	/**
	 * permet de changer la largeur de la zone d'arrivée
	 * @param valeur la valeur de la largeur
	 */
	public void changerLargeurZA(double valeur);
	/**
	 * permet de changer la hauteur de la zone d'arrivée
	 * @param valeur la valeur de la hauteur
	 */
	public void changerhauteurZA(double valeur);
}
