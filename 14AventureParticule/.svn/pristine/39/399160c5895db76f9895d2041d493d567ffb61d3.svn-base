package ressources;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.geom.AffineTransform;
import java.awt.geom.Area;
import java.awt.geom.Line2D;
/**
 * 
 * @author Rostislav
 *
 */
public class VecteurGraphique extends Vecteur implements Dessinable {
	
	//caractéristiques supplemetaires utiles pour le dessin
	private double origX=0, origY=0;//originep our dessiner le vecteur
	private Line2D.Double corps, traitDeTete1;    //pour tracer la flèche
	private double angleTete = 0.3;//angle entre les deux segments formant la tete de fleche
	           //longueur des segments formant la tete (en pixels)

	
	public VecteurGraphique() {
		super();
	}
	
	public VecteurGraphique(double x, double y) {
		super(x, y);
	}
	
	public VecteurGraphique(Vecteur v) {
		super(v.x, v.y);
	}
	
	public VecteurGraphique (double x, double y, double origX, double origY) {
		super(x, y);
		this.origX = origX;
		this.origY = origY;
	}
	
	/**
	 * Cree les formes geometriques qui constituent le vecteur 
	 */
	private void creerRepresentationGeometrique() {
		//on cree la geometriea l'origine. Le tout sera dessiné avec une translation si son origine est ailleurs
		corps = new Line2D.Double(origX, origY, origX+x/Math.pow(10,20),origY+y/Math.pow(10,20));
		traitDeTete1 = new Line2D.Double( origX+x/Math.pow(10,20)/2, origY+y/Math.pow(10,20)/2,origX+x/Math.pow(10,20), origY+y/Math.pow(10,20));
	}
	
	/**
	 * Dessine le vecteur sous la forme d'une flèche orientée
	 * @param g2d Le contexte graphique
	 */
	@Override
	public void dessiner(Graphics2D g2d, AffineTransform mat) {	
		AffineTransform matLocale = new AffineTransform(mat);
		
		creerRepresentationGeometrique();
			g2d.setColor(Color.red);
	g2d.setStroke(new BasicStroke(2.0f));
	g2d.draw(matLocale.createTransformedShape(corps));
	 matLocale.rotate(angleTete/2, origX+x/Math.pow(10,20), origY+y/Math.pow(10,20));

	 g2d.draw(matLocale.createTransformedShape(traitDeTete1));
	  matLocale.rotate(-angleTete, origX+x/Math.pow(10,20),  origY+y/Math.pow(10,20));
	  g2d.draw(matLocale.createTransformedShape(traitDeTete1));
	  matLocale.rotate(angleTete/2, origX+x/Math.pow(10,20), origY+y/Math.pow(10,20));
	
	  g2d.setStroke(new BasicStroke(1.0f));

	}// fin
	
	/**
	 * Modifie l'origine du vecteur pour son dessin
	 * @param origX origine en x
	 * @param origY origine en y
	 */
	public void setOrigineXY(double origX, double origY) {
		this.origX = origX;
		this.origY = origY;
	}
	
	

	
	

	@Override
	public Area aireEnPosition(AffineTransform matAutre) {
		// TODO Auto-generated method stub
		return null;
	}


}
