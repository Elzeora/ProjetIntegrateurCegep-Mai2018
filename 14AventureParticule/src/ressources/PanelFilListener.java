package ressources;

import java.util.EventListener;
/**
 * 
 * @author Louis Roberge
 *
 */
public interface PanelFilListener  extends EventListener{
	
	/**
	 * permet de changer la direction du courant du  fil
	 * @param direction true vers la droite,false vers la gauche
	 */
	public void changerDirectionFil(boolean direction);
	/**
	 * permet de changer la valeur du courant dans le fil
	 * @param valeur valeur du courant
	 */
	public void changerChampMagnetiqueFil(double valeur);

}
