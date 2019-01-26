package objets;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.awt.geom.Area;
import java.awt.geom.Rectangle2D;

import ressources.Dessinable;

/**
 * 
 * @author louis Roberge et Rostislav
 * classe qui permet de gérer un objet zone d'arrivée
 *
 */
public class ZoneArriver extends ObjetGeneral implements Dessinable{
	
	private double xPos,yPos,hauteur,largeur;
	private Rectangle2D zoneArrivee;
	private Area aireTotale;
	private Color c = new Color(0f, 0.7f, 0.2f, .75f);
	
	//Louis
	/**
	 * le constructeur de la zone d'arrivée
	 * @param xPos la position en x
	 * @param yPos la position en y
	 * @param hauteur la hauteur
	 * @param largeur la largeur
	 * @param mat la matrice
	 */
	public ZoneArriver (double xPos, double yPos, double largeur,double hauteur,AffineTransform mat) {
		this.xPos= xPos;
		this.yPos = yPos;
		this.hauteur =hauteur;
		this.largeur = largeur;
		creerRepresentationGeometrique();
		aireEnPosition(mat);
		
	}
	
	//Louis
	/**
	 *permet de créer la representation géométrique de la zone d'arrivée
	 */
	private void creerRepresentationGeometrique(){
		
		zoneArrivee = new Rectangle2D.Double(xPos,yPos,largeur,hauteur);
		
	}

	
	//Louis
	/**
	 * permet de dessiner une zone d'arrivée selon une certaine matrice
	 */
	public void dessiner(Graphics2D g2d, AffineTransform mat) {
		
		
		AffineTransform matLocale= new AffineTransform(mat);
	
		g2d.setColor(c);
		g2d.fill(matLocale.createTransformedShape(zoneArrivee));
		g2d.setColor(Color.black);
		g2d.draw(matLocale.createTransformedShape(zoneArrivee));
		aireEnPosition(matLocale);
	
		
	}
	
	//les getters/setters
	public double getHauteur() {
		return hauteur;
	}
	public void setHauteur(double hauteur) {
		this.hauteur = hauteur;
		creerRepresentationGeometrique();
	}
	public double getLargeur() {
		return largeur;
	}
	public void setLargeur(double largeur) {
		this.largeur = largeur;
		creerRepresentationGeometrique();
	}
	public double getxPos() {
		return xPos;
	}
	public void setxPos(double xPos) {
		this.xPos = xPos;
	}
	public double getyPos() {
		return yPos;
	}
	public void setyPos(double yPos) {
		this.yPos = yPos;
	}


	//Rostislav
	@Override
	/**Generer une aire unique qui represente l'ensemble de la geometrie incluant ses transformations
	 	 * @param mat
	 * @return aire en question
	 */

	public Area aireEnPosition(AffineTransform mat) {
		// TODO Auto-generated method stub
		AffineTransform matLocale = new AffineTransform(mat);
		Area zoneArive = new Area(matLocale.createTransformedShape(zoneArrivee));
		aireTotale=new Area();
		aireTotale.add(zoneArive);
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
	
	public Area getAireTotale() {
		
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
		this.c = new Color(0f, 0.7f, 0.2f, .75f);
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
	 * @return c la coleur
	 */
	public Color getColor() {
		return c;
	}

	
	
	

}
