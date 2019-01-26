package fenetre;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.Area;
import java.awt.geom.Ellipse2D;

/**
 * 
 * @author Louis
 * permet de créer une bulle
 *
 */
public class Bulle {
	
	
	private double posX,posY,rayon,vitX,vitY,deltaT,largeur,hauteur;
	private Ellipse2D.Double cercle;
	private Color c;
	private Area aireTotale;
	
	/**
	 * le constructeur d'une bulle
	 * @param posX la position en x
	 * @param posY la position en y
	 * @param rayon le rayon de la bulle
	 * @param vitX la vitesse en x de la bulle
	 * @param vitY la vitesse en y de la bulle
	 * @param deltaT le deltaT
	 * @param largeur la largeur du composant dans lequel la bulle est dessinée
	 * @param hauteur  la hauteur du composant dans lequel la bulle est dessinée
	 */
	public Bulle(double posX,double posY,double rayon,double vitX,double vitY,double deltaT,double largeur,double hauteur) {
		this.posX=posX;
		this.posY=posY;
		this.rayon=rayon;
		this.vitX=vitX;
		this.vitY=vitY;
		this.deltaT=deltaT;
		this.largeur=largeur;
		this.hauteur=hauteur;
	}
	
	/**
	 * permet de créer les bulles
	 */
	private void creerRepresentationGeometrique( ){
		cercle= new Ellipse2D.Double(posX, posY, rayon,rayon);
	}
	/**
	 * permet de dessiner les bulles
	 * @param g2d endroit dans lequel la bulles est dessinée
	 */
	public void dessiner(Graphics2D g2d){
		g2d.setColor(c);
		creerRepresentationGeometrique( );
		g2d.fill(cercle);
		g2d.setColor(Color.black);
		g2d.draw(cercle);
		
	}
	/**
	 * permet de calculer la position de la bulle selon une certaine vitesse
	 */
	public void euler() {
		this.posX = posX + (vitX * deltaT);
		this.posY = posY + (vitY * deltaT);
		if(posX>largeur) {
			posX=0;
		}
		if(posX<0) {
			posX=largeur;
		}
		if(posY>hauteur) {
			posY=0;
		}
		if(posY<0) {
			posY=hauteur;
		}
	}
	/**
	 * permet de modifier la couleur de la bulle
	 * @param c la couleur
	 */
	public void setColor(Color c) {
		this.c=c;
	}
	
	/** 
	 * permet de générer une Area de la bulle
	 * 
	 */
	public Area aireTotale() {
		Area zoneCercle = new Area(cercle);
		aireTotale = new Area();
		aireTotale.add(zoneCercle);
		return aireTotale;
	}
	/**
	 * permet de changer la valeur de la position en x de la bulle
	 * @param posX la futur position en X
	 */
	public void setPosX(double posX) {
		this.posX = posX;
	}
	/**
	 * permet de changer la valeur de la position en y de la bulle
	 * @param posY la futur position en y
	 */
	public void setPosY(double posY) {
		this.posY = posY;
	}
}
