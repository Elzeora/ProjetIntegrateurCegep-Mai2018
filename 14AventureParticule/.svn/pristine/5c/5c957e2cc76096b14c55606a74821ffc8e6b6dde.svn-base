package objets;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.awt.geom.Arc2D;
import java.awt.geom.Area;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.awt.geom.Rectangle2D;

import ressources.Dessinable;

/**
 * 
 * @author Louis Roberge et Rostislav
 * classe qui permet gérer l'objet cyclotron
 *
 */
public class Cyclotron extends ObjetGeneral implements Dessinable {

	private double xPos, yPos;
	private double diametre = 0.05;
	private Ellipse2D.Double cercle1;
	private Ellipse2D.Double cercle2;
	private Area aireTotale,aireColision;
	private	Color c = new Color(0.5f, 0.1f, 0.7f, 0.5f);
	private Arc2D arc1,arc2;
	private Line2D ligne1,ligne2,ligne3,ligne4;

	
	

	
	//Louis
	/**le constructeur du Cyclotron
	 * 
	 * @param xPos Position en x du coin superieur gauche du cyclotron
	 * @param yPos Position en y du coin superieur gauche du cyclotron
	 */
	public Cyclotron(double xPos, double yPos,AffineTransform mat) {
		this.xPos = xPos;
		this.yPos = yPos;
		creerRepresentationGeometrique();
		 aireEnPosition(mat);
	     aireDeCollision(mat);
	}
	// Louis
	/** permets la représentation géométrique du cyclotron
	 */
	private void creerRepresentationGeometrique() {

		cercle1 = new Ellipse2D.Double(xPos, yPos, diametre, diametre);
		cercle2 = new Ellipse2D.Double(xPos, yPos, diametre, diametre);
		arc1 = new Arc2D.Double(xPos+0.005,yPos+0.005,0.035,0.04,90,180,Arc2D.OPEN);
		arc2 = new Arc2D.Double(xPos+0.01,yPos+0.005,0.035,0.04,90,-180,Arc2D.OPEN);
		ligne1 = new Line2D.Double(xPos+0.023,yPos+0.005,xPos+0.023,yPos+0.045);
		ligne2 = new Line2D.Double(xPos+0.027,yPos+0.005,xPos+0.027,yPos+0.045);
		ligne3 = new Line2D.Double(xPos+0.03,yPos+0.05,xPos+0.05,yPos+0.05);
		ligne4 = new Line2D.Double(xPos+0.05,yPos+0.05,xPos+0.045,yPos+0.045);
		

	}

	//Louis
	@Override
	/**
	 * permets de dessiner la représentation géométrique de façons qui respecte la
	 * réalité
	 */
	public void dessiner(Graphics2D g2d, AffineTransform mat) {
		AffineTransform matLocale = new AffineTransform(mat);
		
		// une "belle" couleur
		g2d.setStroke(new BasicStroke(1.5f));
		g2d.setColor(c);
		g2d.fill(matLocale.createTransformedShape(cercle2));
		g2d.setColor(Color.black);
		g2d.draw(matLocale.createTransformedShape(cercle1));
		g2d.draw(matLocale.createTransformedShape(arc1));
		g2d.draw(matLocale.createTransformedShape(arc2));
		g2d.draw(matLocale.createTransformedShape(ligne1));
		g2d.draw(matLocale.createTransformedShape(ligne2));
		g2d.draw(matLocale.createTransformedShape(ligne3));
		g2d.draw(matLocale.createTransformedShape(ligne4));
		g2d.setStroke(new BasicStroke(1.0f));
		

	}
	//Rostislav
	// les getters et les setters
	public double getDiametre() {
		return diametre;
	}

	public double getxPos() {
		return xPos;
	}

	public double getyPos() {
		return yPos;
	}
	public Area getArea() {
		return aireTotale;
	}

	public void setxPos(double xPos) {
		this.xPos = xPos;
	}

	public void setyPos(double yPos) {
		this.yPos = yPos;
	}

	@Override
	//Rostislav
	/**
	 *  Generer une aire unique qui represente l'ensemble de la
	 *         geometrie incluant ses transformations
	  *@param mat
	 * @return aire en question
	 */
	public Area aireEnPosition(AffineTransform mat) {
		AffineTransform matLocale = new AffineTransform(mat);
		Area zoneCercle = new Area(matLocale.createTransformedShape(cercle1));
		aireTotale = new Area();
		aireTotale.add(zoneCercle);
		return aireTotale;
	}
	//Rostislav
	/**
	 *  Generer une aire unique qui represente l'ensemble de la
	 *         geometrie incluant ses transformations
	 * @param mat
	 * @return aire en question
	 */
	public Area aireDeCollision(AffineTransform mat) {
		AffineTransform matLocale = new AffineTransform(mat);
		Area zoneColision = new Area(matLocale.createTransformedShape(cercle1));
		aireColision = new Area();
		aireColision.add(zoneColision);
		return aireColision;
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
public Area getAireColision() {
	return aireColision;
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
	this.c = new Color(0.5f, 0.1f, 0.7f, .5f);
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
