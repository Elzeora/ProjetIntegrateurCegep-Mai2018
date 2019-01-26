package ressources;

import java.util.EventListener;
/**
 * 
 * @author louis et rostislav
 * ecouteur pour changer les panels
 */
public interface ClicListener  extends EventListener  {
	//louis
	/**
	 * permet de changer de panel selon le numéro choisit
	 * @param i le numéro du panel
	 */
	public void changerPanel(int i);
	//Louis
	/**
	 * permet de savoir s'il y a un cyclotron ou pas dans la zone animation
	 * @param oui true il y a un cyclotron, false il n'y a pas de cyclotron
	 */
	public void cyclotronPlace(boolean oui);
	//Louis
	/**
	 * permet de savoir s'il y a une zone d'arrivee ou pas dans la zone animation
	 * @param oui true il y a une zone d'arrivee,false il n'y a pas de zone d'arrivee
	 */
	public void zoneArriveePlace(boolean oui);
	//Louis
	/**
	 * permet de savoir s'il y a un systeme de plaque ou pas dans la zone animation
	 * @param oui true il y a un systeme de plaque, false il n'y a pas de systeme de plaque
	 */
	public void spPlace(boolean oui);
	//Louis
	/**
	 * permet de savoir s'il y a une zone magnetique ou pas dans la zone animation
	 * @param oui true il y a une zone magnetique,false il n'y a pas de zone magnetique
	 */
	public void zmPlace(boolean oui);
	//Louis
	/**
	* permet de savoir s'il y a un fil ou pas dans la zone animation
	* @param oui true il y a un fil,false il n'y a pas de fil
	* 
	*/
	public void filPlace(boolean oui);
	//Louis
	/**
	 * permet de savoir s'il y a une tige ou pas dans la zone animation
	 * @param oui true il y a une  tige ,false il n'y a pas de tige
	 */
	public void tigePlace(boolean oui);
	//Rostislav
	/**
	 * permet de savoir si les objets minimum ont été placé
	 * @param objetMinimum true si il y a tout les objet , false si il sont pas placé
	 */
	public void cyclotronEtZoneAriveCree(boolean objetMinimum);
	//Rostislav
	/**
	 * permet de savoir si la zone d'arrivé a été placé
	 * @param ZoneArrive true si il y a tout les objet , false si il sont pas placé
	 */
	
	public void cyclotronInterieurZoneArrive(boolean ZoneArrive);
	//Rostislav
	/**
	 * permet d'enregistre les valeurs lors d'une iteration
	 * 
	 * @param vitesse la vitesse de la particule
	 * @param forceMg la force magnétique qu'elle subi
	 * @param forceE  la force électrique qu'elle subi
	 * @param accel   l'acceleration
	 * @param temps   le temps de la simulation
	 */
	public void particuleIteration(double vitesse, double forceMg,double forceE,double accel,double temps);
	//Rostislav
	/**
	 * permet d'activé un button en question
	 */
	public void enableBtnSP();
	//Rostislav
	/**
	 * permet d'activé un button en question
	 */
	public void enableBtnC();
	//Rostislav
	/**
	 * permet d'activé un button en question
	 */
	public void enableBtnZM();
	//Rostislav
	/**
	 * permet d'activé un button en question
	 */
	public void enableBtnT();
	//Rostislav
	/**
	 * permet d'activé un button en question
	 */
	public void enableBtnF();
	//Rostislav
	/**
	 * permet d'activé un button en question
	 */
	public void enableBtnZA();
	//Rostislav
	/**
	 * permet de desactivé les buttons en question
	 */
	public void disableBtnAnimation();
}
