package objets;

import java.awt.Color;

import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.awt.geom.Area;
import java.awt.geom.Rectangle2D;
import ressources.Dessinable;

/**
 * 
 * @author Louis Roberge et Rostislav
 * 	classe qui permet de gérer un objet de type zone magnétique
 *
 */
public class ZoneMagnetique extends ObjetGeneral implements Dessinable {
	private double longueur, champMagnetique;
	private double xPos, yPos;
	private Rectangle2D zoneMagn;
	private Ellipse2D.Double cercle1, cercle2, cercle3, cercle4;
	private Line2D.Double ligne1, ligne2, ligne3, ligne4, ligne5, ligne6, ligne7, ligne8;
	private boolean direction;
	private Area aireTotale;
	private Color c = new Color(0.90f, 0.95f, 1f, 0.80f);

	
	//Louis
	/**
	 * le constructeur de la zoneMagnétique
	 * 
	 * @param xPos Position en x du coin superieur gauche de la zone Magnetique
	 * @param yPos Position en y du coin superieur gauche de la zone Magnetique
	 * @param longueur Longueur de la zone Magnetique
	 * @param champMagnétique la valeur du champ magnetique de la zone magnetique
	 * @param direction si le champ magnetique "sort" ou "entre" dans l'ecran
	 * @param mat la matrice 
	 */
	public ZoneMagnetique(double xPos, double yPos, double longueur, double champMagnetique, boolean direction, AffineTransform mat) {
		this.xPos = xPos;
		this.yPos = yPos;
		this.longueur = longueur;
		this.direction = direction;
		this.champMagnetique = champMagnetique;
		creerRepresentationGeometrique();
		aireEnPosition(mat);

	}
	//Louis
	/**
	 * permet la représentation géométrique de la zone de champ magnétique
	 */
	private void creerRepresentationGeometrique() {
		zoneMagn = new Rectangle2D.Double(xPos, yPos, longueur, longueur);

		cercle1 = new Ellipse2D.Double(xPos + (longueur / 6), yPos + longueur / 6, longueur / 4, longueur / 4);
		cercle2 = new Ellipse2D.Double(xPos + (longueur / 5) * 3, yPos + longueur / 6, longueur / 4, longueur / 4);
		cercle3 = new Ellipse2D.Double(xPos + (longueur / 6), yPos + (longueur / 5) * 3, longueur / 4, longueur / 4);
		cercle4 = new Ellipse2D.Double(xPos + (longueur / 5) * 3, yPos + (longueur / 5) * 3, longueur / 4,
				longueur / 4);

		// croix cercle1
		ligne1 = new Line2D.Double(xPos + (longueur / 6), yPos + longueur / 6, xPos + (longueur / 6) + longueur / 4,
				yPos + longueur / 6 + longueur / 4);
		ligne2 = new Line2D.Double(xPos + (longueur / 6) + longueur / 4, yPos + longueur / 6, xPos + (longueur / 6),
				yPos + longueur / 6 + longueur / 4);
		// croix cercle2
		ligne3 = new Line2D.Double(xPos + (longueur / 5) * 3, yPos + longueur / 6,
				xPos + (longueur / 5) * 3 + longueur / 4, yPos + longueur / 6 + longueur / 4);
		ligne4 = new Line2D.Double(xPos + (longueur / 5) * 3 + longueur / 4, yPos + longueur / 6,
				xPos + (longueur / 5) * 3, yPos + longueur / 6 + longueur / 4);
		// croix cercle3
		ligne5 = new Line2D.Double(xPos + (longueur / 6), yPos + (longueur / 5) * 3,
				xPos + (longueur / 6) + longueur / 4, yPos + (longueur / 5) * 3 + longueur / 4);
		ligne6 = new Line2D.Double(xPos + (longueur / 6) + longueur / 4, yPos + (longueur / 5) * 3,
				xPos + (longueur / 6), yPos + (longueur / 5) * 3 + longueur / 4);
		// croix cercle4
		ligne7 = new Line2D.Double(xPos + (longueur / 5) * 3, yPos + (longueur / 5) * 3,
				xPos + (longueur / 5) * 3 + longueur / 4, yPos + (longueur / 5) * 3 + longueur / 4);
		ligne8 = new Line2D.Double(xPos + (longueur / 5) * 3 + longueur / 4, yPos + (longueur / 5) * 3,
				xPos + (longueur / 5) * 3, yPos + (longueur / 5) * 3 + longueur / 4);

	}

	
	@Override
	//Louis
	/**
	 * permets de dessiner la représentation géométrique de façons qui respecte la
	 * réalité
	 */
	public void dessiner(Graphics2D g2d, AffineTransform mat) {
	
		AffineTransform matLocale = new AffineTransform(mat);
		g2d.setColor(c);
		g2d.fill(matLocale.createTransformedShape(zoneMagn));
		g2d.setColor(Color.black);
		g2d.draw(matLocale.createTransformedShape(zoneMagn));
		aireEnPosition(matLocale);
		if (direction) {
			// si la direction du champ est vers le haut
			g2d.fill(matLocale.createTransformedShape(cercle1));
			g2d.fill(matLocale.createTransformedShape(cercle2));
			g2d.fill(matLocale.createTransformedShape(cercle3));
			g2d.fill(matLocale.createTransformedShape(cercle4));

		} else {
			// si la direction du champ est vers le bas
			g2d.draw(matLocale.createTransformedShape(cercle1));
			g2d.draw(matLocale.createTransformedShape(cercle2));
			g2d.draw(matLocale.createTransformedShape(cercle3));
			g2d.draw(matLocale.createTransformedShape(cercle4));
			g2d.draw(matLocale.createTransformedShape(ligne1));
			g2d.draw(matLocale.createTransformedShape(ligne2));
			g2d.draw(matLocale.createTransformedShape(ligne3));
			g2d.draw(matLocale.createTransformedShape(ligne4));
			g2d.draw(matLocale.createTransformedShape(ligne5));
			g2d.draw(matLocale.createTransformedShape(ligne6));
			g2d.draw(matLocale.createTransformedShape(ligne7));
			g2d.draw(matLocale.createTransformedShape(ligne8));

		}

	}
	// les getters/setters
	public double getLongeur() {
		return longueur;
	}

	public double getChampMagnetique() {
		return champMagnetique;
	}

	public void setChampMagnetique(double champMagnetique) {
		this.champMagnetique = champMagnetique;
	}

	public void setLongeur(double longeur) {
		this.longueur = longeur;
	}
	public void setDirection(boolean direction) {
		this.direction = direction;
	}
public boolean getDirection() {
	return direction;
}
	
	public Area getAireTotale() {
		return aireTotale;
	}
	// Rostislav
		/**
		 * Generer une aire unique qui represente l'ensemble de la geometrie incluant
		 * ses transformations
	     * @param mat
	     * @return aire en question
		 */

	@Override
	public Area aireEnPosition(AffineTransform mat) {
		// TODO Auto-generated method stub
		AffineTransform matLocale = new AffineTransform(mat);
		Area zoneMagnetique = new Area(matLocale.createTransformedShape(zoneMagn));
		aireTotale = new Area();
		aireTotale.add(zoneMagnetique);
		return aireTotale;
	}
	
	//Louis
		/**
		 * permet de savoir si une position est contenue dans une area
		 * @param xPosition la valeur en x de la position
		 * @param yPosition la valeur en y de la positon
		 * @param mat la matrice de transformation
		 * @return si oui ou non, la position est contenue dans l'area
		 */
		public boolean contient(double xPosition, double yPosition, AffineTransform mat) {
			if (aireEnPosition(mat).contains(xPosition, yPosition)) {
				return (true);
			}
			return (false);
		}
		//louis
		/**
		* permet de mettre la couleur rouge lorsque l'objet ne peux pas etre place
		*/
		public void setColorPB() {
			this.c = Color.red;
		}
		//Louis 
		/**
		* permet de mettre la couleur original lorsque l'objet ne peux pas etre place
		*/
		public void setColorB() {
			this.c =  new Color(0.90f, 0.95f, 1f, 0.80f);
		}
		//Louis
		/**
		 * permet de mettre la couleur doree lorsqu'un objet est selectionne
		 */
		public void setColorSelect() {
			this.c = new Color(1.0f, 0.84f, 0.0f, .5f);
		}
		//Louis
		/**
		 * permet de retourner la couleur actuelle de l'objet
		 * @return c la couleur
		 */
		public Color getColor() {
			return c;
		}
		


}
