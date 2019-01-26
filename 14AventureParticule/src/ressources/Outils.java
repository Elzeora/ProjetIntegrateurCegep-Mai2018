package ressources;

public class Outils {

	/**
	 * Calcule et retourne le nombre, arrondi au nombre de décimales désirées
	 * 
	 * @param nombre  Nombre original à ajuster
	 * @param nbDecim Nombre de décimales de précision désirée
	 * @return Le nombre arrondi au nombre de décimales demandées
	 */
	public static double ajusterPrecision(double nombre, int nbDecim) {
		double facteur = Math.pow(10,  nbDecim);
		return ( Math.round(nombre * facteur) )/facteur ;
	}
}
