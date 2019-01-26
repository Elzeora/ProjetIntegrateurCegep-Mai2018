package objets;

import java.awt.BasicStroke;
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
 * classe qui permet de gérer l'objet fil
 *
 */
public class Fil extends ObjetGeneral implements Dessinable {

	private double xPos, yPos, courantElectrique;
	private double diametre = 0.01;
	private double longueur = 0.1;
	private boolean direction;
	private Rectangle2D fil;
	private Ellipse2D.Double boutDuFil1;
	private Ellipse2D.Double boutDuFil2;
	private Rectangle2D zoneActionH;
	private Rectangle2D zoneActionB;
	private Rectangle2D zoneGlobal;
	private Area aireTotale,aireColision;
	private Area aireSuperieure;
	private Area aireInferieure;
	private Color c = new Color(1f, 0.54f, 0f, 0.80f);
	private float dash1[] = {10.0f};
    private BasicStroke dashed =   new BasicStroke(1.0f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER,10.0f, dash1, 0.0f);
    private BasicStroke full =   new BasicStroke(1.0f);
    private Line2D ligne1,ligne2,ligne3;
  
	//Louis 
	/**
	 * constructeur du fil
	 * @param xPos Position en x du coin superieur gauche du fil
	 * @param yPos Position en y du coin superieur gauche du fil
	 * @param direction  
	 * @param courantElectrique valeur du courantElectriquew
	 * @param mat la matrice
	 */
	public Fil(double xPos, double yPos, boolean direction, double courantElectrique, AffineTransform mat) {
		this.xPos = xPos;
		this.yPos = yPos;
		this.direction = direction;
		this.courantElectrique = courantElectrique;
		creerRepresentationGeometrique();
		aireEnPosition(mat);
	    aireDeCollision(mat);
	}
	
	//Louis 
	/**
	 * création géométrique du fil
	 */
	private void creerRepresentationGeometrique() {

		fil = new Rectangle2D.Double(xPos + diametre / 2, yPos, longueur, diametre);
		boutDuFil1 = new Ellipse2D.Double(xPos, yPos, diametre, diametre);
		boutDuFil2 = new Ellipse2D.Double(xPos + longueur, yPos, diametre, diametre);
		zoneActionH= new Rectangle2D.Double(xPos, yPos-6*diametre, longueur+diametre, 6*diametre);
		zoneActionB= new Rectangle2D.Double(xPos, yPos+diametre, longueur+diametre, 6*diametre);
		zoneGlobal= new Rectangle2D.Double(xPos, yPos-6*diametre, longueur+diametre, 13*diametre);
		if(direction) {
			ligne1 = new Line2D.Double(xPos+0.03,yPos+0.005,xPos+0.08,yPos+0.005);
			ligne2 = new Line2D.Double(xPos+0.08,yPos+0.005,xPos+0.068,yPos+0.0020);
			ligne3 = new Line2D.Double(xPos+0.08,yPos+0.005,xPos+0.068,yPos+0.0080);
		}else {
			ligne1 = new Line2D.Double(xPos+0.03,yPos+0.005,xPos+0.08,yPos+0.005);
			ligne2 = new Line2D.Double(xPos+0.03,yPos+0.005,xPos+0.042,yPos+0.0020);
			ligne3 = new Line2D.Double(xPos+0.03,yPos+0.005,xPos+0.042,yPos+0.0080);
		}
		

	}

	@Override
	
	//Louis 
	/**
	 * permets de dessiner la représentation géométrique de façons qui respecte la
	 * réalité
	 */
	public void dessiner(Graphics2D g2d, AffineTransform mat) {

		
		AffineTransform matLocale = new AffineTransform(mat);

		g2d.setColor(Color.black);

		g2d.setStroke(dashed);
		g2d.draw(matLocale.createTransformedShape(zoneGlobal));
		g2d.setStroke(full);
		g2d.draw(matLocale.createTransformedShape(fil));
		g2d.draw(matLocale.createTransformedShape(boutDuFil1));
		g2d.draw(matLocale.createTransformedShape(boutDuFil2));


	
		g2d.setColor(c);
		g2d.fill(matLocale.createTransformedShape(boutDuFil1));
		g2d.fill(matLocale.createTransformedShape(boutDuFil2));
		g2d.fill(matLocale.createTransformedShape(fil));
		g2d.setColor(Color.black);
		g2d.setStroke(new BasicStroke(1.5f));
		g2d.draw(matLocale.createTransformedShape(ligne1));
		g2d.draw(matLocale.createTransformedShape(ligne2));
		g2d.draw(matLocale.createTransformedShape(ligne3));
		g2d.setStroke(new BasicStroke(1.0f));
		aireEnPosition(matLocale);
		aireInferieure(matLocale);
		aireSuperieure(matLocale);
	}
	//Rostislav
	/**
	 *Generer une aire unique qui represente l'ensemble de la geometrie incluant ses transformations
	 * @param mat
	 * @return aire en question
	 */
	@Override
	public Area aireEnPosition(AffineTransform mat) {
		// TODO Auto-generated method stub
		AffineTransform matLocale = new AffineTransform(mat);
		Area zoneFile = new Area(matLocale.createTransformedShape(zoneGlobal));
		aireTotale=new Area();
		aireTotale.add(zoneFile);
		
		return aireTotale;
	}
	//Rostislav
	/**
	 * Generer une aire unique qui represente la partie superieure de la geometrie
	 * @param mat
	 * @return aire en question
	 */
	public Area aireSuperieure(AffineTransform mat) {
		// TODO Auto-generated method stub
		AffineTransform matLocale = new AffineTransform(mat);
		Area zoneFile = new Area(matLocale.createTransformedShape(zoneActionH));
		aireSuperieure=new Area();
		aireSuperieure.add(zoneFile);
		
		return aireSuperieure;
	}
	//Rostislav
	/**
	 * Generer une aire unique qui represente la partie inferieure de la geometrie
	 * @param mat
	 * @return aire en question
	 */
	public Area aireInferieure(AffineTransform mat) {
		// TODO Auto-generated method stub
		AffineTransform matLocale = new AffineTransform(mat);
		Area zoneFile = new Area(matLocale.createTransformedShape(zoneActionB));
		aireInferieure=new Area();
		aireInferieure.add(zoneFile);
		
		return aireInferieure;
	}
	//Rostislav
	/**
	 * Generer une aire unique qui represente le fil 
	 * @param mat
	 * @return aire en question
	 */
	public Area aireDeCollision(AffineTransform mat) {
		// TODO Auto-generated method stub
		AffineTransform matLocale = new AffineTransform(mat);
		Area zoneFile = new Area(matLocale.createTransformedShape(fil));
		Area zoneFile2= new Area(matLocale.createTransformedShape(boutDuFil1));
		Area zoneFile3= new Area( matLocale.createTransformedShape(boutDuFil2));
		aireColision=new Area();
		aireColision.add(zoneFile);
		aireColision.add(zoneFile2);
		aireColision.add(zoneFile3);
		return aireColision;
	}
//Rostislav
	/**
 * 
 * @return aireTotale
 */
	public Area getAireTotale() {
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
		//Rostislav
public Area getAireInferieure() {
	return aireInferieure;
}



//Rostislav
public Area getAireSuperieure() {
	// TODO Auto-generated method stub
	return aireSuperieure;
}
//Rostislav
public double getxPos() {
	return xPos;
}

//Rostislav
public double getyPos() {
	// TODO Auto-generated method stub
	return yPos;
}
//Rostislav
public void setDirection(boolean direction) {
	this.direction = direction;
	creerRepresentationGeometrique();
}
//Rostislav
public boolean getDirection() {
	return direction;
}
//Rostislav
public void setCourantElectrique(double courantElectrique) {
	this.courantElectrique = courantElectrique;
} 
//Rostislav
public double getCourantElectrique() {
	return courantElectrique;
}
//Rostislav
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
	this.c = new Color(1f, 0.54f, 0f, 0.80f);
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
