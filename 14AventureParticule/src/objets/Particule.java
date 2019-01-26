 package objets;

import java.awt.Color;

import java.awt.Graphics2D;
import java.awt.Shape;
import java.awt.geom.AffineTransform;
import java.awt.geom.Area;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;

import ressources.Dessinable;
/**
 * 
 * @author Rostislav
 * 
 */

public class Particule extends ObjetGeneral implements Dessinable {
private double diametre;
private double x,y,xPos,yPos;
private double vitesseParticule;
private double largeurMonde,hauteurMonde;
private Ellipse2D.Double cercle;
private Shape cercleTransfo;
private double acceleration;
private Area aireTotale;
private Color couleurParticule = Color.red;
private boolean cercleEnZone;
/**
 *Le constructeur de la classe particule
 *
 * @author Rostislav
 * @param diametre
 * @param xPos
 * @param yPos
 * @param largeurMonde
 * @param hauteurMonde
 * @param vitesseParticule
 * @param acceleration
 */

	public Particule( double xPos, double yPos, double diametre,double diametre2 ) {
		this.diametre=diametre;
		this.diametre=diametre2;
		this.xPos=xPos;
		this.yPos=yPos;
		
}
//Les getters et les setters
	
	public Area getAireTotale() {
		return aireTotale;
	}
	public void setCouleurParticule(Color couleurParticule) {
		this.couleurParticule = couleurParticule;
	}
public void setAcceleration(double acceleration) {
	this.acceleration = acceleration;
}

public double getAcceleration() {
	return acceleration;
}
public void setCercleEnZoneMg(boolean cercleEnZoneMg) {
	this.cercleEnZone = cercleEnZoneMg;
}
public boolean getCercleEnZoneMg() {
	return cercleEnZone;
}
	public void setDiametre(double diametre) {
		this.diametre = diametre;
	}
	public double getDiametre() {
		return diametre;
	}
	public double getVitesseParticule() {
		return vitesseParticule;
	}
	public void setVitesseParticule(double vitesseParticule) {
		this.vitesseParticule = vitesseParticule;
	}
	public double getX() {
		return x;
	}
	public double getY() {
		return y;
	}
	public double getxPos() {
		return xPos;
	}
	public double getyPos() {
		return yPos;
	}

	public void setxPos(double xPos) {
		this.xPos = xPos;
	}
	
	
	public void setyPos(double yPos) {
		this.yPos = yPos;
	}
	/**
	 *Permet de cree sa répresentation geometrique
	 * 
	 */
	private void creerRepresentationGeometrique( ){
	    cercle= new Ellipse2D.Double(xPos, yPos, diametre, diametre);
		
		}
/**
 * Permet de dessiner la particule
 */
	@Override
	public void dessiner(Graphics2D g2d, AffineTransform mat) {
		// TODO Auto-generated method stub

	AffineTransform matLocale=new AffineTransform(mat);
	creerRepresentationGeometrique();
    aireEnPosition(matLocale);
	g2d.setColor(couleurParticule);
    g2d.fill(matLocale.createTransformedShape(cercle));
    g2d.setColor(Color.black);
    g2d.draw(matLocale.createTransformedShape(cercle));
    cercleTransfo=matLocale.createTransformedShape(cercle);
	aireEnPosition(matLocale);
	}
	
	/**
	 * @return
	 */
	public Shape Cercle() {
		return cercleTransfo;
	}
	@Override
	/**
	 * 
	 * 
	 *Generer une aire unique qui represente l'ensemble de la geometrie incluant ses transformations
	 */
	public Area aireEnPosition(AffineTransform mat) {
		AffineTransform matLocale = new AffineTransform(mat);
		Area zoneCercle = new Area(matLocale.createTransformedShape(cercle));
		aireTotale=new Area();
		aireTotale.add(zoneCercle);
		return aireTotale;
	}
	/**
	 * 
	 * Permet de savoir si la particule contient les cordonne suivant
	 *
	 */
	public  boolean contient(double xPosition, double yPosition,AffineTransform mat) {
		if(aireEnPosition(mat).contains(xPosition,yPosition)) {
			return(false);
		}
		return(true);
	}


	/**
	 * 
	 * 
	 * Permet de savoir si la particule est en intersection avec une autre quelqu'on que area
	 */
	public boolean enIntersectionAvec(Area area ) {
		Area zone1=aireTotale;
		Area zone2=aireTotale;
		Area zone3=area;
		zone3.intersect(zone1);
		zone2.subtract(zone3);
		if (zone3.isEmpty()) {
			
			cercleEnZone=false;
		}else {
			if(zone2.isEmpty()) {
				
			cercleEnZone=true;
				
			}else {
				cercleEnZone=true;
			}
		}
		
		return cercleEnZone;
	}
}	


