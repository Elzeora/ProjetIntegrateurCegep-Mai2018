package fenetre;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;


import javax.swing.JPanel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;



/**
 * 
 * @author Louis 
 *composant qui fait des jolies couleurs grâce a l'objet bulles
 */
public class FenetreTest extends JPanel implements Runnable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private boolean enCoursDAnimation=false;
	private int y=0,numBulle=-1;
	private Color c;
	Bulles bulle=new Bulles(c,1614, 904,0.75);
	private ArrayList<Color> listCouleur = new ArrayList<Color>();
	private boolean easterEgg =false;
	private EasterEgg coucou;
	/**
	 * Création du panel
	 */
	public FenetreTest() {
		
	    coucou = new EasterEgg();
	    coucou.setLocationRelativeTo(null);
	    coucou.setVisible(easterEgg);
		addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent e) {
				if(numBulle!=-1) {
					modifierPos(e);
				}
				
			}
		});
		addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				detection(e);	
				 if (e.getModifiers() == MouseEvent.BUTTON3_MASK)  {
						if(numBulle!=-1) {
							 supprimer(numBulle);
						}		
				 }
				 resteBulle();
			}
			@Override
			public void mouseReleased(MouseEvent e) {
				
			
				numBulle=-1;
			}
		});
		setBackground(new Color(135, 206, 235));

		listCouleur = couleurArcEnCiel();
		
		 if (enCoursDAnimation) {
			 arreter();
		 }else {
			 demarrer();					
		 }				
	

	}
	
	/**
	 * composant graphique
	 * @param g endroit dans lequel on dessine
	 */
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D) g;
		
		bulle.dessiner(g2d);
		
	}
	/**
	 * le run ....
	 */
	@Override
	public void run() {
		while (enCoursDAnimation) { 
			repaint();
			for(int i=0;i<bulle.getListP().size();i++) {
				y++;
				if(y>=4000) {
					y=0;
				}		
				bulle.getListP().get(i).setColor(listCouleur.get(y));				
				bulle.getListP().get(i).euler();
			}
			try {
				Thread.sleep(20); 
			}
			catch (InterruptedException e) {
				System.out.println("Processus interrompu!"); 
			}
		}	
	}
	/**
	 * permet de démarrer l'animation
	 */
	public void demarrer() {
		if (!enCoursDAnimation) {
			Thread processusAnim = new Thread(this);
			processusAnim.start();
			enCoursDAnimation = true;
		}
	}
	
	/**
	 * permet de d'arreter l'animation
	 */
	public void arreter() {
		enCoursDAnimation= false;
	}
    /**
     * permet de générer une liste des couleurs entre rouge à bleu et de bleue à rouge
     * @param colors la liste de ces couleurs
     */
    public ArrayList<Color> couleurArcEnCiel() {
    	ArrayList<Color> colors = new ArrayList<Color>();
    	for (int r=0; r<2000; r++) colors.add(new Color(r*255/2000,0,(2000-r)*255/2000));
    	for (int b=0; b<2000; b++) colors.add(new Color((2000-b)*255/2000,0,b*255/2000));
    	for (int r=2000; r<2000; r--) colors.add(new Color(r*255/2000,0,(2000-r)*255/2000));
    	

    	
    	
    	return colors;                  
    }
    /**
     * permet de détecter si on clic sur une bulle
     * @param e la position en (X,Y) du curseur de la souri
     */
    public void detection(MouseEvent e) {
    	for(int i=0;i<bulle.getListP().size();i++) {
    		if (bulle.getListP().get(i).aireTotale().contains(e.getX(),e.getY())) {
      			this.numBulle=i;
      		}
    	}
    	
    }
    /**
     * permet de modifier la position en x et en y d'une bulle
     * @param e le curseur de la souris
     */
    public void modifierPos(MouseEvent e) {
    	if(numBulle<bulle.getListP().size()) {
    	 	bulle.getListP().get(numBulle).setPosX(e.getX());
        	bulle.getListP().get(numBulle).setPosY(e.getY());
    	}
    }
    /**
     * permet d'exploser une bulle
     * @param i la bulle en question
     */
    public void supprimer(int i) {
    	bulle.getListP().remove(i);
    }
    public void resteBulle() {
    	if(bulle.getListP().size()<=0) {
    		easterEgg=true;
    	    coucou.setVisible(easterEgg);
    	}
    }
    

}
