package fenetre;

import java.awt.Color;
import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;


/**
 * 
 * @author louis avec l'aide d'Ayoub Bouisri pour la méthode creerReperesentationGeometrique
 *permet de générer des bulles aléatoire 
 */
public class Bulles  {
	

	private double largeur,hauteur;
	private Color c;
	private Bulle bulle;
	private boolean ft=false;
	private int nbParticules = 35;
	private double deltaT;
	private ArrayList<Bulle> listP = new ArrayList<Bulle>();


	/**
	 * constructeur de l'objet bulles
	 * @param c couleur des bulles
	 * @param largeur largeur du composant
	 * @param hauteur hauteur du composant
	 */
	public Bulles(Color c,double largeur,double hauteur,double deltaT ) {
		this.largeur=largeur;
		this.hauteur=hauteur;
		this.deltaT=deltaT;
		this.c=c;
	}
	
	/**
	 * permet de créés les bulles
	 */
	private void creerRepresentationGeometrique( ){
		    for (int i = 0; i < nbParticules; i++) {
				double posX = ThreadLocalRandom.current().nextDouble(-10, largeur);
				double posY = ThreadLocalRandom.current().nextDouble(-10, hauteur);
				double rayon = ThreadLocalRandom.current().nextDouble(15, 50);
						

				double vitX = ThreadLocalRandom.current().nextDouble(-4, 4);
				double vitY = ThreadLocalRandom.current().nextDouble(-4, 4);
				
				listP.add(bulle= new Bulle(posX,posY, rayon, vitX,vitY,deltaT,largeur,hauteur));
			}
	}
	  
	
	/**
	 * permet de dessiner les bulles
	 * @param g2d l'endroit ou dessiner les bulles
	 */
	public void dessiner(Graphics2D g2d) {
		g2d.setColor(c);
		if(!ft) {
			creerRepresentationGeometrique();
			ft=true;
		}
		for(Bulle bulle: listP) {
			bulle.dessiner(g2d);
		}
	}
	/**
	 * permet d'associer une couleur aux bulles
	 * @param c
	 */
	public void setColor(Color c) {
		this.c=c;
	}
	/**
	 * permet de retourner la liste des bulles
	 * @return listP la liste des bulles
	 */
	public ArrayList<Bulle> getListP() {
		return listP;
	}
	
	
	
	
	
	



}
