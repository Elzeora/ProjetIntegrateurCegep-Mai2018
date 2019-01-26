package objets;

import java.awt.geom.AffineTransform;
import java.awt.geom.Area;

/**
 * 
 * @author louis Roberge
 *
 */
public class ObjetGeneral {

	/**
	 * permet de savoir si l'objet1 est en intersection avec l'objet2
	 * @param objet1 l'objet1 qu'on souhaite savoir s'il y a une intersection a l'objet2
	 * @param objet2 l'objet2 qu'on souhaite savoir s'il y a une intersection a l'objet1
	 * @return false, s'il n'y a pas d'intersection. True, s'il y a intersection.
	 */
	public boolean intersection(Area objet1, Area objet2) {
		Area zone1 = new Area(objet1);
		Area zone2 = new Area(objet2);
		Area zone3 = new Area(objet1);

		zone2.intersect(zone1);
		zone3.subtract(zone2);
		if (zone2.isEmpty()) {
			return false;
		} else {
			if (zone3.isEmpty()) {
				return true;
			} else {
				return true;
			}

		}
	}
	public boolean contient(ObjetGeneral objet,double xPosition, double yPosition, AffineTransform mat) {
		if (objet.getArea(objet, mat).contains(xPosition, yPosition)) {
			return (true);
		}
		return (false);
	}

	/**
	 * permet de retourner l'area d'un objet
	 * @param objet l'objet qu'on souhaite savoir son area 
	 * @param mat matrice dans lequel l'objet est dessiné
	 * @return retourne l'area de l'objet
	 */
	public Area getArea(ObjetGeneral objet, AffineTransform mat) {
		if (objet instanceof Cyclotron) {
			return ((Cyclotron) objet).aireEnPosition(mat);
		}
		if (objet instanceof Fil) {
			return ((Fil) objet).aireEnPosition(mat);
		}	
		if (objet instanceof Tige) {
			return ((Tige) objet).aireEnPosition(mat);
		}
		if (objet instanceof SystemPlaque) {
			return ((SystemPlaque) objet).aireEnPosition(mat);
		}
		if (objet instanceof ZoneMagnetique) {
			return ((ZoneMagnetique) objet).aireEnPosition(mat);
		}
		if (objet instanceof ZoneArriver) {
			return ((ZoneArriver) objet).aireEnPosition(mat);
		}
		return null;
	}
	/**
	 * permet de retourner l'area de colision d'un objet
	 * @param objet l'objet qu'on souhaite savoir l'area de collison
	 * @param mat matrice dans lequel l'objet est dessiné
	 * @return  retourne l'area de l'objet de collision
	 */
	public Area getAreaCollision(ObjetGeneral objet, AffineTransform mat) {
		if(objet instanceof Cyclotron) {
			return((Cyclotron) objet).aireDeCollision(mat);
		}if (objet instanceof Fil) {
			return ((Fil) objet).aireDeCollision(mat);
		}	if (objet instanceof Tige) {
			return ((Tige) objet).aireDeCollision(mat);
		}
		if (objet instanceof SystemPlaque) {
			return ((SystemPlaque) objet).aireDeCollision(mat);
		}
		
	return null;
	}

}
