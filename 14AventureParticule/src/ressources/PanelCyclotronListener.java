package ressources;

import java.util.EventListener;

/***
 * 
 * @author Louis Roberge
 *
 */
public interface PanelCyclotronListener  extends EventListener {
	/**
	 * permet de changer la vitesse du cyclotron
	 * @param i
	 */
	public void changerVitesse(double i );
	
		
	
}
