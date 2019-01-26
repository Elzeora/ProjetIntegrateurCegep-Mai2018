package objets;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.awt.geom.Area;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;

import ressources.Dessinable;

/**
 * 
 * @author louis Roberge et Rostislav
 *classe qui permet de gérer l'objet tige
 */
public class Tige extends ObjetGeneral implements Dessinable {
	private double xPos, yPos, densite;
	private Rectangle2D tige;
	private Ellipse2D cercle;
	private Area aireTotale,aireReaction,aireColision;
	private Color c = new Color(0.66f, 0.66f, 0.66f, 0.80f);
	
	//Louis Roberge
	/**
	 * le construteur d'une tige
	 * @param xPosition position en x du coin superieur gauche de la tige
	 * @param yPosition position en y du coin superieur gauche de la tige
	 * @param densite la densite de la tige
	 */
	public Tige(double xPosition, double yPosition, double densite, AffineTransform mat) {
		this.xPos = xPosition;
		this.yPos = yPosition;
		this.densite = densite;
		creerRepresentationGeometrique();
		aireEnPosition(mat);
		
	aireDeCollision(mat);
	}
	//Louis Roberge
	/**
	 * permet de créer la représation géométrique d'une tige
	 */
	private void creerRepresentationGeometrique() {

		tige = new Rectangle2D.Double(xPos, yPos, 0.02, 0.02);
      
			
			
	}

	//Louis Roberge
	/**
	 * permet de dessiner une tige selon une certaine matrice
	 */
	public void dessiner(Graphics2D g2d, AffineTransform mat) {

		
		AffineTransform matLocale = new AffineTransform(mat);
		
		
		g2d.setColor(c);
		g2d.fill(matLocale.createTransformedShape(tige));

		g2d.setColor(Color.black);
		g2d.draw(matLocale.createTransformedShape(tige));
		//g2d.draw(matLocale.createTransformedShape(cercle));

	}
	//Louis Roberge
	/**
	 * permet de retourner la positon en x de la tige
	 * @return xPos position en x de la tige
	 */
	public double getxPos() {
		return xPos;
	}
	//Louis Roberge
	/**
	 * permet de retourner la position en y de la tige
	 * @return yPos position en y de la tige
	 */
	public double getyPos() {
		return yPos;
	}
	public void setDensite(double densite) {
		this.densite = densite;
	}
public double getDensite() {
	return densite;
}

	//Rostislav
	/**
	 * 
	 * Generer une aire unique qui represente l'ensemble de la geometrie incluant ses transformations
	 * @param mat la matrice
	 */
	public Area aireDeReaction(AffineTransform mat) {
		AffineTransform matLocale = new AffineTransform(mat);
		Area zoneRaction = new Area(matLocale.createTransformedShape(cercle));
		
		
		aireReaction=new Area();
		aireReaction.add(zoneRaction);
		
		return aireReaction;
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
		public Area getAireTotale() {
			return aireTotale;
		}
	public Area getAireReaction() {
		return aireReaction;
	}
	//Rostislav
		/**
		 * Generer une aire unique qui represemte les objets avec les quelles la particule peut entre en collision 
			 * @param mat
	 * @return aire en question
		 */
public Area aireDeCollision(AffineTransform mat) {
		AffineTransform matLocale = new AffineTransform(mat);
		Area zoneTige = new Area(matLocale.createTransformedShape(tige));
		
		
		aireColision=new Area();
		aireColision.add(zoneTige);
		
		return aireColision;
	}
public Area getAireColision() {
	return aireColision;
}
//Rostislav
/**
 * 
 * Generer une aire unique qui represente l'ensemble de la geometrie incluant ses transformations
 	 * @param mat
	 * @return aire en question
 */
public Area aireEnPosition(AffineTransform mat) {
	AffineTransform matLocale = new AffineTransform(mat);
	Area zoneTotal = new Area(matLocale.createTransformedShape(tige));
	
	
	aireTotale=new Area();
	aireTotale.add(zoneTotal);
	
	return aireTotale;
	
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
	this.c = new Color(0.66f, 0.66f, 0.66f, 0.80f);
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
 */
public Color getColor() {
	return c;
}

}


