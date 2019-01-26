package objets;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.awt.geom.Area;
import java.awt.geom.Line2D;
import java.awt.geom.Rectangle2D;

import ressources.Dessinable;

/**
 * 
 * @author louis Roberge et Rostislav
 * classe qui permet gérer l'objet systeme de plaque
 *
 */
public class SystemPlaque extends ObjetGeneral implements Dessinable {

	private double longueur, champElectrique;
	private double xPos, yPos;
	private boolean direction;
	private Rectangle2D plaque1;
	private Rectangle2D plaque2;
	private Rectangle2D zonePlaque;
	private Rectangle2D zoneReaction;
	private Line2D ligne1,ligne2,ligne3,ligne4;
	
	private Area airePosition,aireColision,aireReaction;
	private Color couleur1 = Color.red;
	private Color couleur2 = Color.blue;

	//Louis Roberge
	/**
	 *  le constructeur du système de plaque
	 * @param xPos Position en x du coin superieur gauche du Systeme de plaque
	 * @param yPos Position en y du coin superieur gauche du Systeme de plaque
	 * @param longueur Longueur des plaques
	 * @param champElectrique la valeur du champElectrique du systeme de plaque
	 * @param direction permet de choisir si la plaque positive est en ou en bas
	 */
	public SystemPlaque(double xPos, double yPos, double longueur, double champElectrique, boolean direction, AffineTransform mat) {
		this.xPos = xPos;
		this.yPos = yPos;
		this.longueur = longueur;
		this.direction = direction;
		this.champElectrique = champElectrique;
		creerRepresentationGeometrique();
		  	aireDeCollision(mat);
		    aireDeReaction(mat);
			aireEnPosition(mat);
	}

	
	//Louis Roberge
	/**
	 * permet de créer la réprensation géométrique du système de plaque
	 */
	private void creerRepresentationGeometrique(){
		plaque1= new Rectangle2D.Double(xPos,yPos,longueur,0.01);
		plaque2= new Rectangle2D.Double(xPos,yPos+0.07,longueur,0.01);
		zonePlaque= new Rectangle2D.Double(xPos,yPos+0.01,longueur,0.08);
		zoneReaction= new Rectangle2D.Double(xPos, yPos+0.01, longueur, 0.07);
		ligne1 = new Line2D.Double(xPos+0.065,yPos+0.005,xPos+0.075,yPos+0.005);
		ligne4 = new Line2D.Double(xPos+0.065,yPos+0.075,xPos+0.075,yPos+0.075); 
		ligne2 = new Line2D.Double(xPos+0.07,yPos,xPos+0.07,yPos+0.01);
		ligne3 = new Line2D.Double(xPos+0.07,yPos+0.07,xPos+0.07,yPos+0.08); 
	 
	 
		
	}

	//Louis Roberge
	/**
	 * permet de dessiner le système de plaque respectant une certaine matrice
	 */
	public void dessiner(Graphics2D g2d, AffineTransform mat) {

		
		
		AffineTransform matLocale= new AffineTransform(mat);
		  aireDeReaction(mat);
		
			g2d.setStroke(new BasicStroke(1.0f));
		  
		if (direction) {
			g2d.setColor(couleur1);
			g2d.fill(matLocale.createTransformedShape(plaque1));
			g2d.setColor(couleur2);
			g2d.fill(matLocale.createTransformedShape(plaque2));
			g2d.setColor(Color.black);
			g2d.setStroke(new BasicStroke(1.5f));
			g2d.draw(matLocale.createTransformedShape(ligne3));
			g2d.setStroke(new BasicStroke(1.0f));

		}else {
			g2d.setColor(couleur2);
			g2d.fill(matLocale.createTransformedShape(plaque1));
			g2d.setStroke(new BasicStroke(1.5f));
			g2d.setColor(Color.black);
			g2d.draw(matLocale.createTransformedShape(ligne2));
			g2d.setStroke(new BasicStroke(1.0f));
			g2d.setColor(couleur1);	
			g2d.fill(matLocale.createTransformedShape(plaque2));


		}
		g2d.setColor(Color.black);

		g2d.draw(matLocale.createTransformedShape(plaque1));
		g2d.draw(matLocale.createTransformedShape(plaque2));
		g2d.setStroke(new BasicStroke(1.5f));
		g2d.draw(matLocale.createTransformedShape(ligne1));
		g2d.draw(matLocale.createTransformedShape(ligne4));
		g2d.setStroke(new BasicStroke(1.0f));

	
	}
	
	//les getters/setters
	public void setChampElectrique(double champElectrique) {
		this.champElectrique = champElectrique;
	}

	public double getChampElectrique() {
		return champElectrique;
	}

	public double getLongueur() {
		return longueur;
	}

	public void setLongueur(double longueur) {
		this.longueur = longueur;
	}

	public double getxPos() {
		return xPos;
	}

	public void setxPos(double xPos) {
		this.xPos = xPos;
	}
public boolean getDirection() {
	return direction;
}

	public double getyPos() {
		return yPos;
	}
	public void setDirection(boolean direction) {
		this.direction = direction;
	}

	public void setyPos(double yPos) {
		this.yPos = yPos;
	}
	public Area getAirePosition() {
		return airePosition;
	}

	@Override
	//Rostislav
	/**
	 * Generer une aire unique qui represente l'ensemble de la geometrie incluant ses transformations
	 * @param mat
	 * @return aire en question
	 */

	public Area aireEnPosition(AffineTransform mat) {
		AffineTransform matLocale = new AffineTransform(mat);
		Area zonePlaqueTotale = new Area(matLocale.createTransformedShape(zonePlaque));	
		Area zoneCollision1 = new Area(matLocale.createTransformedShape(plaque2));
		Area zoneCollision2 = new Area(matLocale.createTransformedShape(plaque1));
		airePosition=new Area();
		airePosition.add(zonePlaqueTotale);
		airePosition.add(zoneCollision1);
	    airePosition.add(zoneCollision2);
		return airePosition;
	}
	//Rostislav
	/**
	 * Generer une aire unique qui represemte les objets avec les quelles la particule peut entre en collision 
	 * @param mat
	 * @return aire en question
	 */
	public Area aireDeCollision(AffineTransform mat) {
		AffineTransform matLocale = new AffineTransform(mat);
		Area zoneCollision1 = new Area(matLocale.createTransformedShape(plaque2));
		Area zoneCollision2 = new Area(matLocale.createTransformedShape(plaque1));
	aireColision=new Area();
	aireColision.add(zoneCollision1);
    aireColision.add(zoneCollision2);
	return aireColision;
	}
	//Rostislav
	/**
	 * Genere une aire unique qui represente la zone de reaction de l'objet
		 * @param mat
	 * @return aire en question
	 */
	public Area aireDeReaction(AffineTransform mat) {
		AffineTransform matLocale = new AffineTransform(mat);
		Area zoneReactionT= new Area(matLocale.createTransformedShape(zoneReaction));	
		aireReaction= new Area();
		aireReaction.add(zoneReactionT);
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
		//Rostislav
	public Area getAireColision() {
		return aireColision;
	}
	//Rostislav
	public Area getAireReaction() {
		return aireReaction;
	}

	//louis
	/**
	* permet de mettre la couleur rouge lorsque l'objet ne peux pas etre place
	*/
	public void setColorPB() {
		this.couleur1 = Color.red;
		this.couleur2 = Color.red;
	}
	//Louis 
	/**
	* permet de mettre la couleur original lorsque l'objet ne peux pas etre place
	*/
	public void setColorB() {
		this.couleur1 = Color.red;
		this.couleur2 = Color.blue;
	}
	//Louis
	/**
	 * permet de mettre la couleur doree lorsqu'un objet est selectionne
	 */
	public void setColorSelect() {
		this.couleur1 = new Color(1.0f, 0.84f, 0.0f, .5f);
		this.couleur2 = new Color(1.0f, 0.84f, 0.0f, .5f);
	}
	//Louis
	/**
	 * permet de retourner la couleur actuelle de l'objet
	 */
	public Color getColor() {
		return couleur1;
	}
	



}
