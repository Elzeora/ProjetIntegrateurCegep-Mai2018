package ressources;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.awt.geom.Area;
import java.awt.geom.Path2D;

/**
 * 
 * @author louis Roberge
 * permet de créer un quadriller dans une certaine largeur et hauteur
 *
 */
public class Quadriller implements Dessinable {

	private double largeurMonde, hauteurMonde;
	private Path2D.Double quadrillerX;
	private Path2D.Double quadrillerY;

	/**
	 * constructeur du quadriller
	 * @param largeurMonde la largeur du composant dans le monde reel
	 * @param hauteurMonde la hauteur du composant dans le monde reel
	 */
	public Quadriller(double largeurMonde, double hauteurMonde) {
		this.largeurMonde = largeurMonde;
		this.hauteurMonde = hauteurMonde;

	}

	/**
	 *permet de dessiner un quadriller selon une certaine matrice 
	 */
	public void dessiner(Graphics2D g2d, AffineTransform mat) {
		AffineTransform matLocale = new AffineTransform(mat);

		quadrillerX = new Path2D.Double();
		quadrillerY = new Path2D.Double();
		g2d.setStroke(new BasicStroke(0.5f));

		for (double i = 0; i < 100; i++) {
			quadrillerX.moveTo(i / 100, 0);
			quadrillerX.lineTo(i / 100, hauteurMonde);
			g2d.setColor(Color.LIGHT_GRAY);
			g2d.draw(matLocale.createTransformedShape(quadrillerX));

		}
		for (double i = 0; i < 60; i++) {
			quadrillerY.moveTo(0, i / 100);
			quadrillerY.lineTo(largeurMonde, i / 100);
			g2d.setColor(Color.LIGHT_GRAY);
			g2d.draw(matLocale.createTransformedShape(quadrillerY));

		}

	}

	@Override
	/**
	 * permet de retourner l'area du quadrillage.... 
	 */
	public Area aireEnPosition(AffineTransform matAutre) {
		// TODO Auto-generated method stub
		return null;
	}

	

}
