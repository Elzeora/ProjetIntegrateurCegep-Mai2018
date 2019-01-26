package composant;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

import ressources.ClicListener;
import ressources.ModelePhysique;
import ressources.Quadriller;
import ressources.SVector3d;

import java.applet.Applet;
import java.applet.AudioClip;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.awt.geom.Area;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;
import javax.swing.event.EventListenerList;
import objets.BoutonObjets;
import objets.Cyclotron;
import objets.Fil;
import objets.ObjetGeneral;
import objets.Particule;
import objets.SystemPlaque;
import objets.Tige;
import ressources.Vecteur;
import ressources.VecteurGraphique;
import objets.ZoneArriver;
import objets.ZoneMagnetique;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseAdapter;

/**
 * 
 * @author Louis et Rostislav
 * @param <E>
 * composant dans lequel l'animation se produit
 *
 */
public class ZoneAnimation<E> extends JPanel implements Runnable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	// valeur réelle
	
	private BoutonObjets btnO;

	private ModelePhysique modele;
	private double largeurMonde = 1;
	private double hauteurMonde = 0.6;
	private int nbIterationsPhysiques = 1;
	private double tempsTotalEcoule = 0;
	// variable de la particule
	double tempsSimulation = 0.00000000002;
	double tI = 0, tF;
	private double xPositionP;
	private double yPositionP;
	private double c = 3 * Math.pow(10, 8);
	private double pourcentageVitesse=0.2;
	private double accelerationY = 0, accelerationX = 0, acceleration, accelerationCentripede;
	private double vitesseParticuleInitialX = pourcentageVitesse * c, vitesseParticuleInitialY = 0, vitesseParticuleResultante,
			vitesseParticuleFX = pourcentageVitesse * c, vitesseParticuleFY, vitesseAngulaire;
	private double temps = 0, deltaT = 0.000000000009;
	private double electron = -1.6 * Math.pow(10, -19);
	private double masseElectron = 9.1 * Math.pow(10, -31);
	private double k=9*Math.pow(10, 9);
	
    private double charge=-1.6 * Math.pow(10, -19), masse=9.1 * Math.pow(10, -31);	
    private double courantElectrique=5000, direction=-1;
 
	
	// variable des objets
	private double xPosition;
	private double yPosition;
	private boolean directionSP=true;
	private boolean directionZM=true;
	private double champMagnetique=1*Math.pow(10, -2);
	private double champElectrique=Math.pow(10,5);
	private AffineTransform mat;
	private double densite=5*Math.pow(10, -6);
	private int numeroSP=0;
	private int numeroZM=0;
	private int numeroTige=0;
	private int numeroFil=0;
	private int numeroZA=0;

	// les objets et liste
	private Quadriller quadriller;
	private ArrayList<Cyclotron> listC = new ArrayList<Cyclotron>();
	private ArrayList<ZoneMagnetique> listZM = new ArrayList<ZoneMagnetique>();
	private ArrayList<SystemPlaque> listSP = new ArrayList<SystemPlaque>();
	private ArrayList<Fil> listFil = new ArrayList<Fil>();
	private ArrayList<Tige> listTige = new ArrayList<Tige>();
	private ArrayList<ZoneArriver> listZA = new ArrayList<ZoneArriver>();
	private ArrayList<ObjetGeneral> listObjet = new ArrayList<ObjetGeneral>();
	private ArrayList<ObjetGeneral> listColision = new ArrayList<ObjetGeneral>();
	private Cyclotron cTemporaire;
	private SystemPlaque spTemporaire;
	private ZoneArriver zaTemporaire;
	private ZoneMagnetique zmTemporaire;
	private Tige tigeTemporaire;
	private Fil filTemporaire;
	private Particule cercle = new Particule(xPositionP, yPositionP, 0.01, 0.01);;

	// les boolean des objets
	private boolean cycloExiste = false;
	private boolean cercleEnZoneMG, cercleEnSP, cercleEnZoneA, cercleEnChampSupFil, cercleEnChampInfFil;
	private boolean  collision=false;
	private boolean avecCollision=true;
	private boolean vecteurAF=true;
	// autres
	private boolean vrai = false;
	private double B, r, q, a, E, Fe, Fr, I;
	private double  denssiteLineique, distanceT, distanceF;
	private int dessiner = 0;
	private int thread = 25;
	private boolean enCoursDAnimation = false;
	private boolean quadrillage = true;
	private boolean temp1 =false,temp2=false,temp3=false,temp4=false,temp5=false,temp6=false;
	private Vecteur vitesse = new Vecteur();
	private Vecteur accel = new Vecteur();
	private Vecteur position = new Vecteur();
	private Vecteur fM = new Vecteur();
	private Vecteur fE= new Vecteur();
	private Vecteur distanceTige = new Vecteur();
	private Vecteur accelFm= new Vecteur();
	private Vecteur accelFe=new Vecteur();
	
	private final EventListenerList OBJETS_ENREGISTRES = new EventListenerList();
	private Graphics2D g2d;
	private Rectangle2D zoneAnimation = new Rectangle2D.Double(0, 0, 1, 0.6);
	private Area aireTotale;
	
//Vecteur 3d
	private SVector3d vit=new SVector3d();
	private SVector3d ac=new SVector3d();
	private SVector3d p=new SVector3d();
	private SVector3d fMag=new SVector3d();
	private SVector3d fEl=new SVector3d();
	private SVector3d acfM=new SVector3d();
	private SVector3d vecteurB= new SVector3d();
	private SVector3d acSP=new SVector3d();
	private SVector3d acFe=new SVector3d();
	private SVector3d vecteurE=new SVector3d();
	private SVector3d vecteurFeR= new SVector3d();
	private SVector3d vecteurFMR= new SVector3d();
	//Graphics
	Graphics graphics;
	
//son
	private java.net.URL urlFichier= getClass().getClassLoader().getResource( "victoire.wav" ); 
	private AudioClip victoire = Applet.newAudioClip( urlFichier);
	private java.net.URL urlFichier2= getClass().getClassLoader().getResource( "defaite.wav" ); 
	private AudioClip defaite = Applet.newAudioClip( urlFichier2);
	// vecteur graphiques
	VecteurGraphique vitesseGraphique= new   VecteurGraphique();
	
	
	// Louis
	/**
	 * le paintComponent dans lequel on dessine
	 */
	@Override
	public void paintComponent(Graphics g) {
        this.btnO=btnO;
		super.paintComponent(g);
		g2d = (Graphics2D) g;
		g2d.setStroke(new BasicStroke(3.0f, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND));

		modele = new ModelePhysique(getWidth(), getHeight(), largeurMonde);

		mat = modele.getMatMC();
		quadriller = new Quadriller(largeurMonde, hauteurMonde);
		aireTotale = new Area(mat.createTransformedShape(zoneAnimation));
		
		
		if (quadrillage) {
			quadriller.dessiner(g2d, mat);
		}
		if(vecteurAF) {
			vitesseGraphique.setOrigineXY(cercle.getxPos(), cercle.getyPos());
			vitesseGraphique.setXY(ac.getX(),ac.getY());
			vitesseGraphique.dessiner(g2d, mat);
			
		}else {
			
		}
		//les objets temporaires
		if(temp1) {	
			dessinerCyclotronTemp(g2d);
			 vecteurAF=true;
		}
		if(temp2) {
			dessinerSystemPlaqueTemp(g2d);
		}
		if(temp3) {
			dessinerZoneArriveeTemp(g2d);
		}
		if(temp4) {

			dessinerZoneMagnetiqueTemp(g2d);
		}
		if(temp5) {
			dessinerTigeTemp(g2d);
		}
		if(temp6) {
			dessinerFilTemp(g2d);
		}
		
		
		//vrai
		dessinerSystemPlaque(g2d);
		dessinerZoneMagnetique(g2d);
		dessinerTige(g2d);
		dessinerFil(g2d);
		dessinerCyclotron(g2d);
		dessinerZoneArrivee(g2d);
		
		

		if (!listC.isEmpty()) {
			dessinerParticule(g2d);
			
			
	
		}
		g2d.setColor(Color.black);
		g2d.drawString(" 0 m", 1, (int) (getHeight() - hauteurMonde));
		g2d.drawString("1 m", (int) (getWidth() - largeurMonde - 22), (int) (getHeight() - hauteurMonde));
		g2d.setColor(Color.red);
		g2d.drawString(" 0 m", (int) (getWidth() - largeurMonde) - 26, 10);
		g2d.drawString("0.6 m", (int) (getWidth() - largeurMonde - 33), (int) (getHeight() - hauteurMonde - 10));

		}

	// Rostislav
	/**
	 * 
	 * @param g2d
	 */
	private void dessinerParticule(Graphics2D g2d) {
		cercle.dessiner(g2d, mat);

	}

	// Les méthodes pour ajouter les objets dans les arrayLists

	// Louis Roberge
	/**
	 * méthode qui crée et qui ajoute un cyclotron dans un arrayList
	 * 
	 * @param xPosition
	 *            Position initial en x du coin superieur gauche du cyclotron
	 * @param yPosition
	 *            Position initial en y du coin superieur gauche du cyclotron
	 */
	public void ajouterCyclotron(double xPosition, double yPosition) {
		if (listC.size() < 1) {
			listC.add(new Cyclotron(xPosition, yPosition, mat));
			listObjet.add(new Cyclotron(xPosition, yPosition, mat));
		    listColision.add(new Cyclotron(xPosition, yPosition, mat));
		}
	}

	// Louis Roberge
	/**
	 * méthode qui crée et qui ajoute une zone magnétique dans un arrayList
	 * 
	 * @param xPosition
	 *            Position initial en x du coin superieur gauche de la zone
	 *            Magnetique
	 * @param yPosition
	 *            Position initial en y du coin superieur gauche de la zone
	 *            Magnetique
	 */
	public void ajouterZoneMagnetique(double xPosition, double yPosition) {
		if (listZM.size() < 4) {
			listZM.add((new ZoneMagnetique(xPosition, yPosition, 0.07, champMagnetique, directionZM, mat)));
			listObjet.add((new ZoneMagnetique(xPosition, yPosition, 0.07, champMagnetique, directionZM, mat)));

		}
	}

	// Louis Roberge
	/**
	 * méthode qui crée et qui ajoute une zone d'arrivée dans un arrayList
	 * 
	 * @param xPosition
	 *            Position initial en x du coin superieur gauche de la zone
	 *            d'arrivee
	 * @param yPosition
	 *            Position initial en y du coin superieur gauche de la zone
	 *            d'arrivee
	 */
	public void ajouterZoneArrivee(double xPosition, double yPosition) {
		if (listZA.size() < 1) {
			listZA.add(new ZoneArriver(xPosition, yPosition, 0.15, 0.1, mat));
			listObjet.add(new ZoneArriver(xPosition, yPosition, 0.15, 0.1, mat));
		}
	}

	// Louis Roberge
	/**
	 * méthode qui crée et qui ajoute un système de plaque dans un arrayList
	 * 
	 * @param xPosition
	 *            Position initial en x du coin superieur gauche du systeme de
	 *            plaque
	 * @param yPosition
	 *            Position initial en y du coin superieur gauche du systeme de
	 *            plaque
	 */
	public void ajouterSystemPlaque(double xPosition, double yPosition) {
		if (listSP.size() < 4) {
			listSP.add(new SystemPlaque(xPosition, yPosition, 0.14, champElectrique,directionSP, mat));
			listObjet.add(new SystemPlaque(xPosition, yPosition, 0.14, champElectrique, directionSP, mat));
		    listColision.add(new SystemPlaque(xPosition, yPosition, 0.14, champElectrique, directionSP, mat));
		}
	}

	// Louis Roberge
	/**
	 * méthode qui crée et qui ajoute une tige dans un arrayList
	 * 
	 * @param xPosition
	 *            Position initial en x du coin superieur gauche de la tige
	 * @param yPosition
	 *            Position initial en y du coin superieur gauche de la tige
	 */
	public void ajouterTige(double xPosition, double yPosition) {
		if (listTige.size() < 4) {
			listTige.add(new Tige(xPosition, yPosition, densite, mat));
			listObjet.add(new Tige(xPosition, yPosition, densite, mat));
            listColision.add(new Tige(xPosition, yPosition, densite, mat));
		}
	}

	// Louis Roberge
	/**
	 * méthode qui crée et qui ajoute un Fil dans un arrayList
	 * 
	 * @param xPosition
	 *            Position initial en x du coin superieur gauche du fil
	 * @param yPosition
	 *            Position initial en y du coin superieur gauche du fil
	 */
	public void ajouterFil(double xPosition, double yPosition) {
		if (listFil.size() < 4) {
			listFil.add(new Fil(xPosition, yPosition, true, courantElectrique, mat));
			listObjet.add(new Fil(xPosition, yPosition, true, courantElectrique, mat));
		    listColision.add(new Fil(xPosition, yPosition, true, courantElectrique, mat));
		}
	}

	// Les méthodes pour dessiner les objets des arraylists
	// Louis Roberge
	/**
	 * méthode qui dessine les cyclotrons dans le arrayList
	 * 
	 * @param g2d
	 *            le graphics2D dans lequel on veux dessiner l'objet
	 */
	public void dessinerCyclotron(Graphics2D g2d) {
		for (int i = 0; i < listC.size(); i++) {
			listC.get(i).dessiner(g2d, mat);
		}
	}

	// Louis Roberge
	/**
	 * méthode qui dessine les zone magnétiques dans le arrayList
	 * 
	 * @param g2d
	 *            le graphics2D dans lequel on veux dessiner l'objet
	 */
	public void dessinerZoneMagnetique(Graphics2D g2d) {
		for (int i = 0; i < listZM.size(); i++) {
			listZM.get(i).dessiner(g2d, mat);
		}
	}

	// Louis Roberge
	/**
	 * méthode qui dessine les zone d'arrivées dans le arrayList
	 * 
	 * @param g2d
	 *            le graphics2D dans lequel on veux dessiner l'objet
	 */
	public void dessinerZoneArrivee(Graphics2D g2d) {
		for (int i = 0; i < listZA.size(); i++) {
			listZA.get(i).dessiner(g2d, mat);
		}
	}

	// Louis Roberge
	/**
	 * méthode qui dessine les systèmes de plaque dans le arrayList
	 * 
	 * @param g2d
	 *            le graphics2D dans lequel on veux dessiner l'objet
	 */
	public void dessinerSystemPlaque(Graphics2D g2d) {
		for (int i = 0; i < listSP.size(); i++) {
			listSP.get(i).dessiner(g2d, mat);
		}

	}

	// Louis Roberge
	/**
	 * méthode qui dessine les tiges dans le arrayList
	 * 
	 * @param g2d
	 *            le graphics2D dans lequel on veux dessiner l'objet
	 */
	public void dessinerTige(Graphics2D g2d) {
		for (int i = 0; i < listTige.size(); i++) {
			listTige.get(i).dessiner(g2d, mat);
		}
	}

	// Louis Roberge
	/**
	 * méthode qui dessine les fils dans le arrayList
	 * 
	 * @param g2d
	 *            le graphics2D dans lequel on veux dessiner l'objet
	 */
	public void dessinerFil(Graphics2D g2d) {
		for (int i = 0; i < listFil.size(); i++) {
			listFil.get(i).dessiner(g2d, mat);
		}
	}
	// Les méthodes pour dessiner les objets des arraylists
	// Louis Roberge
	/**
	 * méthode qui dessine un cyclotron temporairement
	 * 
	 * @param g2d
	 *            le graphics2D dans lequel on veux dessiner l'objet
	 */
	public void dessinerCyclotronTemp(Graphics2D g2d) {
		cTemporaire.dessiner(g2d, mat);
	}

	// Louis Roberge
	/**
	 * méthode qui dessine une zone magnétique temporairement
	 * 
	 * @param g2d
	 *            le graphics2D dans lequel on veux dessiner l'objet
	 */
	public void dessinerZoneMagnetiqueTemp(Graphics2D g2d) {
		zmTemporaire.dessiner(g2d, mat);
	}

	// Louis Roberge
	/**
	 * méthode qui dessine une zone d'arrivées temporairement
	 * 
	 * @param g2d
	 *            le graphics2D dans lequel on veux dessiner l'objet
	 */
	public void dessinerZoneArriveeTemp(Graphics2D g2d) {
		zaTemporaire.dessiner(g2d, mat);
	}

	// Louis Roberge
	/**
	 * méthode qui dessine un système de plaque  temporairement
	 * 
	 * @param g2d
	 *            le graphics2D dans lequel on veux dessiner l'objet
	 */
	public void dessinerSystemPlaqueTemp(Graphics2D g2d) {
		spTemporaire.dessiner(g2d, mat);

	}

	// Louis Roberge
	/**
	 * méthode qui dessine une tige temporairement
	 * 
	 * @param g2d
	 *            le graphics2D dans lequel on veux dessiner l'objet
	 */
	public void dessinerTigeTemp(Graphics2D g2d) {
		tigeTemporaire.dessiner(g2d,mat);
	}

	// Louis Roberge
	/**
	 * méthode qui dessine un fil  temporairement
	 * 
	 * @param g2d
	 *            le graphics2D dans lequel on veux dessiner l'objet
	 */
	public void dessinerFilTemp(Graphics2D g2d) {
		filTemporaire.dessiner(g2d, mat);
	}
	
	


	// Louis Roberge
	/**
	 * permet de prendre la position du curseur de la sourie et de garder seulement
	 * deux chiffres après la virgule
	 * 
	 * @param e
	 *            position du curseur de la souris
	 */
	public void calculPosition(MouseEvent e) {
		xPosition = (double) e.getX() / 1300;
		yPosition = (double) e.getY() / 1300;
		xPosition = (double) ((int) (xPosition * 100)) / 100;
		yPosition = (double) ((int) (yPosition * 100)) / 100;
	}

	// Louis Roberge
	/**
	 * contient les methodes des evenements consernant la souris
	 */
	public ZoneAnimation() {
		addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseMoved(MouseEvent e) {
				calculPosition(e);
				if (dessiner == 1) {
					cTemporaire = new Cyclotron(xPosition, yPosition, mat);
					if (interieur(cTemporaire)) {
						if (!intersection(cTemporaire)) {
							cTemporaire.setColorB();
						}else {								
						cTemporaire.setColorPB();
						}
					}else {
						cTemporaire.setColorPB();
					}
						
					temp1 =true;
				}
				if (dessiner == 2) {
					 spTemporaire = new SystemPlaque(xPosition, yPosition, 0.14, champElectrique, directionSP,
							mat);
						if (interieur(spTemporaire)) {
							if (!intersection(spTemporaire)) {
								spTemporaire.setColorB();
							}else {								
							spTemporaire.setColorPB();
							}
						}else {
							spTemporaire.setColorPB();
						}
						temp2 =true;
				}
				if (dessiner == 3) {
					 zaTemporaire = new ZoneArriver(xPosition, yPosition, 0.15, 0.1, mat);
						if (interieur(zaTemporaire)) {
							if (!intersection(zaTemporaire)) {
								zaTemporaire.setColorB();
							}else {								
							zaTemporaire.setColorPB();
							}
						}else {
							zaTemporaire.setColorPB();
						}
						temp3 =true;
				}
				if (dessiner == 4) {
					zmTemporaire = new ZoneMagnetique(xPosition, yPosition, 0.07, champMagnetique, directionZM,
							mat);
					if (interieur(zmTemporaire)) {
						if (!intersection(zmTemporaire)) {
							zmTemporaire.setColorB();
						}else {								
						zmTemporaire.setColorPB();
						}
					}else {
						zmTemporaire.setColorPB();
					}
					temp4 =true;
				}
				if (dessiner == 5) {
					 tigeTemporaire = new Tige(xPosition, yPosition, densite, mat);
						if (interieur(tigeTemporaire)) {
							if (!intersection(tigeTemporaire)) {
								tigeTemporaire.setColorB();
							}else {								
							tigeTemporaire.setColorPB();
							}
						}else {
							tigeTemporaire.setColorPB();
						}
						temp5 =true;
				}
				if (dessiner == 6) {
					 filTemporaire = new Fil(xPosition, yPosition, true, champMagnetique, mat);
						if (interieur(filTemporaire)) {
							if (!intersection(filTemporaire)) {
								filTemporaire.setColorB();
							}else {								
							filTemporaire.setColorPB();
							}
						}else {
							filTemporaire.setColorPB();
						}
						temp6 =true;
				}
				
				repaint();
			}
		});

		addMouseListener(new MouseAdapter() {

			@Override
			public void mousePressed(MouseEvent e) {
				calculPosition(e);
				detection(e);
				if (dessiner == 1) {
					Cyclotron cTemporaire = new Cyclotron(xPosition, yPosition, mat);
					if (interieur(cTemporaire)) {
						if (!intersection(cTemporaire)) {
							ajouterCyclotron(xPosition, yPosition);
							cercle.setxPos(listC.get(0).getxPos()+cTemporaire.getDiametre());
							cercle.setyPos(listC.get(0).getyPos()+cTemporaire.getDiametre());
							if(listC.size()>=1) {
								leverEvenCyclotronPlace(false);
							}
							
							if (!cycloExiste) {
								cercle.setxPos(listC.get(0).getxPos()+cTemporaire.getDiametre());
								cercle.setyPos(listC.get(0).getyPos()+cTemporaire.getDiametre());
								cycloExiste = true;
								repaint();
							}
						}
					}
					if (!listC.isEmpty() && !listZA.isEmpty()) {
						leverEvencCyclotronEtZoneAriveCree(true);
					}

				}
				if (dessiner == 2) {
					SystemPlaque spTemporaire = new SystemPlaque(xPosition, yPosition, 0.14, champElectrique, directionSP,
							mat);
					if (interieur(spTemporaire)) {
						if (!intersection(spTemporaire)) {
							ajouterSystemPlaque(xPosition, yPosition);
							if (listSP.size() >= 4) {
								leverEvenSPPlace(false);
							}					
						}
					}
				}
				if (dessiner == 3) {
					ZoneArriver zaTemporaire = new ZoneArriver(xPosition, yPosition, 0.15, 0.1, mat);
					if (interieur(zaTemporaire)) {
						if (!intersection(zaTemporaire)) {
							ajouterZoneArrivee(xPosition, yPosition);
							if (listZA.size() >= 1) {
								leverEvenZoneArriveePlace(false);
							}				
						}
					}
					if (!listZA.isEmpty() && !listC.isEmpty()) {
						leverEvencCyclotronEtZoneAriveCree(true);
					}
				}
				if (dessiner == 4) {
					ZoneMagnetique zmTemporaire = new ZoneMagnetique(xPosition, yPosition, 0.07, champMagnetique, directionZM,
							mat);
					if (interieur(zmTemporaire)) {
						if (!intersection(zmTemporaire)) {
							ajouterZoneMagnetique(xPosition, yPosition);
							if (listZM.size() >= 4) {
								leverEvenZMPlace(false);
							}
						}
					}
				}
				if (dessiner == 5) {
					Tige tigeTemporaire = new Tige(xPosition, yPosition, densite, mat);
					if (interieur(tigeTemporaire)) {
						if (!intersection(tigeTemporaire)) {
							ajouterTige(xPosition, yPosition);
							if (listTige.size() >= 4) {
								leverEvenTigePlace(false);
							}
						}
					}
				}
				if (dessiner == 6) {
					Fil filTemporaire = new Fil(xPosition, yPosition, true, champMagnetique, mat);
					if (interieur(filTemporaire)) {
						if (!intersection(filTemporaire)) {
							ajouterFil(xPosition, yPosition);
							if (listFil.size() >= 4) {
								leverEvenFilPlace(false);
							}
						}
					}
				}
				tempFalse();
				 if (e.getModifiers() == MouseEvent.BUTTON3_MASK)  {
					 supprimer(e);
				 }
				// f
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				dessiner = 0;

				repaint();

			}
		});

	}

	// Louis
	/**
	 * permet de savoir si le curseur de la souris detecte un objet et de savoir c'est le quel et de mettre la color dore sur l'objet detecté
	 * 
	 * @param e   position du curseur de la souris
	 *         
	 */
	public void detection(MouseEvent e) {
		for (int i = 0; i < listC.size(); i++) {
			if(listC.get(i).getColor().getRGB()== new Color(1.0f, 0.84f, 0.0f, .5f).getRGB()) {
				listC.get(i).setColorB();
			}
			if (listC.get(i).contient(e.getX(), e.getY(), mat)) {
				listC.get(i).setColorSelect();			
				leverEvenChangerPanel(1);
			}
		}
		for (int i = 0; i < listZM.size(); i++) {
			if(listZM.get(i).getColor().getRGB()== new Color(1.0f, 0.84f, 0.0f, .5f).getRGB()) {
				listZM.get(i).setColorB();
			}
			if (listZM.get(i).contient(e.getX(), e.getY(), mat)) {
				this.numeroZM=i;
				listZM.get(i).setColorSelect();
				leverEvenChangerPanel(3);
			}
		}
		for (int i = 0; i < listZA.size(); i++) {
			if(listZA.get(i).getColor().getRGB()== new Color(1.0f, 0.84f, 0.0f, .5f).getRGB()) {
				listZA.get(i).setColorB();
			}
			if (listZA.get(i).contient(e.getX(), e.getY(), mat)) {
				this.numeroZA=i;
				listZA.get(i).setColorSelect();
				leverEvenChangerPanel(6);
			}
		}
		for (int i = 0; i < listSP.size(); i++) {
			if(listSP.get(i).getColor().getRGB()== new Color(1.0f, 0.84f, 0.0f, .5f).getRGB()) {
				listSP.get(i).setColorB();
			}
			if (listSP.get(i).contient(e.getX(), e.getY(), mat)) {
				this.numeroSP=i;
				listSP.get(i).setColorSelect();
				leverEvenChangerPanel(2);
			}
		}
		for (int i = 0; i < listTige.size(); i++) {
			if(listTige.get(i).getColor().getRGB() == new Color(1.0f, 0.84f, 0.0f, .5f).getRGB()) {
				listTige.get(i).setColorB();
			}
			if (listTige.get(i).contient(e.getX(), e.getY(), mat)) {
				this.numeroTige=i;
				listTige.get(i).setColorSelect();
				leverEvenChangerPanel(4);
			}
		}
		for (int i = 0; i < listFil.size(); i++) {
			if(listFil.get(i).getColor().getRGB()== new Color(1.0f, 0.84f, 0.0f, .5f).getRGB()) {
				listFil.get(i).setColorB();
			}
			if (listFil.get(i).contient(e.getX(), e.getY(), mat)) {
				this.numeroFil = i;
				listFil.get(i).setColorSelect();
				leverEvenChangerPanel(5);
			}
		}

	}
	public void remettreCouleur() {
		for (int i = 0; i < listC.size(); i++) {
				listC.get(i).setColorB();
		}
		for (int i = 0; i < listZM.size(); i++) {
				listZM.get(i).setColorB();

		}
		for (int i = 0; i < listZA.size(); i++) {
				listZA.get(i).setColorB();
		}
		for (int i = 0; i < listSP.size(); i++) {
				listSP.get(i).setColorB();
		}
		for (int i = 0; i < listTige.size(); i++) {
				listTige.get(i).setColorB();
		}
		for (int i = 0; i < listFil.size(); i++) {
				listFil.get(i).setColorB();
		}
	}

	// Louis
	/**
	 * permet de savoir un objet est en intersection avec les autres objets
	 * 
	 * @param objet
	 *            objet qu'on souhaite savoir s'il est en intersection ou pas
	 * @return false, s'il n'y a pas d'intersection. True, s'il y a intersection.
	 */

	public boolean intersection(ObjetGeneral objet) {

		if (listObjet.isEmpty()) {
			return false;
		} else {
			for (int i = 0; i < listObjet.size(); i++) {
				if (objet.intersection(objet.getArea(objet, mat), listObjet.get(i).getArea(listObjet.get(i), mat))) {			;
					return true;
				}
			}
			return false;
		}

	}

	// Louis
	/**
	 * permet de savoir si un objet est completement a l'intérieur du composant ou
	 * non
	 * 
	 * @param objet
	 *            l'objet qu'on souhaite savoir s'il est completement a l'interieur
	 *            du composant ou pas
	 * @return true si l'objet est a l'interieur, false si l'objet est a l'exterieur
	 *         ou touche a l'exterieur.
	 */
	public boolean interieur(ObjetGeneral objet) {
		Area zone1 = new Area(objet.getArea(objet, mat));
		Area zoneAnimation = new Area(aireTotale);
		Area zone2 = new Area(objet.getArea(objet, mat));

		zoneAnimation.intersect(zone1);
		zone2.subtract(zoneAnimation);
		if (zone1.isEmpty()) {
			return false;
		} else {
			if (zone2.isEmpty()) {
				return true;
			} else {
				return false;
			}

		}
	}
	//Louis
	/**
	 * permet de supprimer un objet lors d'un clic droit..
	 * @param e position du curseur de la souris
	 */
	public void supprimer(MouseEvent e) {

		for (int i = 0; i < listColision.size(); i++) {
			if (listColision.get(i).contient(listColision.get(i), e.getX(), e.getY(), mat)) {
				listColision.remove(i);
			}
		}
		for(int i = 0;i<listObjet.size();i++) {
			if (listObjet.get(i).contient(listObjet.get(i), e.getX(), e.getY(), mat)) {	
				if(listObjet.get(i) instanceof Cyclotron||listObjet.get(i) instanceof ZoneArriver) {
					if(!enCoursDAnimation) {
						listObjet.remove(i);
					}
				}else {
					listObjet.remove(i);
				}
		
			}
		}
		for (int i = 0; i < listC.size(); i++) {
			if (listC.get(i).contient(e.getX(), e.getY(), mat)) {
				if(!enCoursDAnimation) {
					listC.remove(i);

				}			

				leverEvenEnableBtnC();
				leverEvenDisableBtnAnimation();
				vecteurAF=false;
			
			}
		}
		for (int i = 0; i < listZM.size(); i++) {
			if (listZM.get(i).contient(e.getX(), e.getY(), mat)) {
				listZM.remove(i);
				if(!enCoursDAnimation) {
					leverEvenEnableBtnZM();
				}	
			}
		}
		for (int i = 0; i < listZA.size(); i++) {
			if (listZA.get(i).contient(e.getX(), e.getY(), mat)) {
				if(!enCoursDAnimation) {
					listZA.remove(i);		
				}	
			leverEvenEnableBtnZA();
			leverEvenDisableBtnAnimation();
			}
		}
		for (int i = 0; i < listSP.size(); i++) {
			if (listSP.get(i).contient(e.getX(), e.getY(), mat)) {
				listSP.remove(i);	
				if(!enCoursDAnimation) {
					leverEvenEnableBtnSp();
				}			
			}
		}
		for (int i = 0; i < listTige.size(); i++) {
			if (listTige.get(i).contient(e.getX(), e.getY(), mat)) {
				listTige.remove(i);	
				if(!enCoursDAnimation) {
					leverEvenEnableBtnT();
				}		
			}
		}
		for (int i = 0; i < listFil.size(); i++) {
			if (listFil.get(i).contient(e.getX(), e.getY(), mat)) {
				listFil.remove(i);	
				if(!enCoursDAnimation) {
					leverEvenEnableBtnF();
				}	
			}
		}
		repaint();		
	}
	//Louis
	/**
	 * permet de mettre les variables des objet temporaire à faux
	 */
	public void tempFalse() {
		temp1=false;
		temp2=false;
		temp3=false;
		temp4=false;
		temp5=false;
		temp6=false;
	}
	// Louis
	/**
	 * ajout d'un ecouteur a un objet
	 * 
	 * @param objEcouteur
	 *            l'objet a ecouter
	 */
	public void addClicListener(ClicListener objEcouteur) {
		OBJETS_ENREGISTRES.add(ClicListener.class, objEcouteur);
	}

	// louis
	/**
	 * permet de changer de panel
	 * @param    correspondant aux numéro du panel voulu
	 */
	private void leverEvenChangerPanel(int i) {
		for (ClicListener ecout : OBJETS_ENREGISTRES.getListeners(ClicListener.class)) {
			ecout.changerPanel(i);
		}
	}
	//Louis 
	/**
	 * permet de lever s'il y a le maximum de cyclotron place
	 * @param oui
	 */
	private void leverEvenCyclotronPlace(boolean oui) {
		for (ClicListener ecout : OBJETS_ENREGISTRES.getListeners(ClicListener.class)) {
			ecout.cyclotronPlace(oui);
		}
	}
	//Louis 
	/**
	 * permet de lever s'il y a le maximum de zone d'arrivee place
	 * @param oui
	 */
	private void leverEvenZoneArriveePlace(boolean oui) {
		for (ClicListener ecout : OBJETS_ENREGISTRES.getListeners(ClicListener.class)) {
			ecout.zoneArriveePlace(oui);
		}
	}
	//Louis 
	/**
	 * permet de lever s'il y a le maximum de systeme de plaque place
	 * @param oui
	 */
	private void leverEvenSPPlace(boolean oui) {
		for (ClicListener ecout : OBJETS_ENREGISTRES.getListeners(ClicListener.class)) {
				ecout.spPlace(oui);
		}
	}
	//Louis 
	/**
	 * permet de lever s'il y a le maximum de zone magnetique place
	 * @param oui
	 */
	private void leverEvenZMPlace(boolean oui) {
		for (ClicListener ecout : OBJETS_ENREGISTRES.getListeners(ClicListener.class)) {
				ecout.zmPlace(oui);
		}
	}
	//Louis 
	/**
	 * permet de lever s'il y a le maximum de fil place
	 * @param oui
	 */
	private void leverEvenFilPlace(boolean oui) {
		for (ClicListener ecout : OBJETS_ENREGISTRES.getListeners(ClicListener.class)) {
				ecout.filPlace(oui);
		}
	}
	//Louis 
	/**
	 * permet de lever s'il y a le maximum de Tige place
	 * @param oui
	 */
	private void leverEvenTigePlace(boolean oui) {
		for (ClicListener ecout : OBJETS_ENREGISTRES.getListeners(ClicListener.class)) {
				ecout.tigePlace(oui);
		}
	}
	
	

	// Rostislav
	/**
	 * methode qui permet aux buttons d'animation d'etre ouvert lorsqu'il ya un
	 * cyclotron et une zone d'arriver de place
	 * 
	 * @param objetMinimum
	 *            boolean qui permet de dire si les objets minimum a l animation ont
	 *            ete place
	 */
	public void leverEvencCyclotronEtZoneAriveCree(boolean objetMinimum) {
		for (ClicListener ecout : OBJETS_ENREGISTRES.getListeners(ClicListener.class)) {
			ecout.cyclotronEtZoneAriveCree(objetMinimum);
		}
	}

	// Rostislav
	/**
	 * methode qui permet aux buttons objets d etre ouvert lorsque la particule est
	 * arriver au point finale
	 * 
	 * @param ZoneArrive la zone arrivee
	 */
	public void leverEvenCyclotronInterieurZoneArrive(boolean ZoneArrive) {
		for (ClicListener ecout : OBJETS_ENREGISTRES.getListeners(ClicListener.class)) {
			ecout.cyclotronEtZoneAriveCree(ZoneArrive);
		}
	}
	//Rostislav
	/**
	 * Methode qui permet de lever de prendre les valeurs de la particule et les transmettre au etiquettes
	 * @param vitesse
	 *            le module de la vitesse
	 * @param forceMg
	 *             le module de la force magnetique
	 * @param forceE
	 *            le module de la force electrique 
	 * @param accel
	 *            le module de l'acceleration
	 * @param temps
	 *            le temps
	 */
	public void leverEvenParticuleIteration(double vitesse, double forceMg,double forceE,double accel,double temps) {
		for (ClicListener ecout : OBJETS_ENREGISTRES.getListeners(ClicListener.class)) {
			ecout.particuleIteration(vitesse, forceMg, forceE, accel, temps);
		}
	}
	//Rostislav
	/**
	 * Permet de lever l'activation des buttons plaques
	 */
	public void leverEvenEnableBtnSp() {
		for (ClicListener ecout : OBJETS_ENREGISTRES.getListeners(ClicListener.class)) {
		ecout.enableBtnSP();
		}
		}
	//Rostislav
	/**
	 * Permet de lever l'activation du button zone magnetique
	 */
	public void leverEvenEnableBtnZM() {
		for (ClicListener ecout : OBJETS_ENREGISTRES.getListeners(ClicListener.class)) {
		ecout.enableBtnZM();
		}
		}
	//Rostislav
	/**
	 * Permet de lever l'activation du button zone d'arrive
	 */
	public void leverEvenEnableBtnZA() {
		for (ClicListener ecout : OBJETS_ENREGISTRES.getListeners(ClicListener.class)) {
		ecout.enableBtnZA();
		}
		}
	//Rostislav
	/**
	 * Permet de lever l'activation du button tige
	 */
	public void leverEvenEnableBtnT() {
		for (ClicListener ecout : OBJETS_ENREGISTRES.getListeners(ClicListener.class)) {
		ecout.enableBtnT();
		}
		}
	//Rostislav
	/**
	 * Permet de lever l'activation du button fil
	 */
	public void leverEvenEnableBtnF() {
		for (ClicListener ecout : OBJETS_ENREGISTRES.getListeners(ClicListener.class)) {
		ecout.enableBtnF();
		}
		}
	//Rostislav
	/**
	 * Permet de lever l'activation du button cyclotron
	 */
	public void leverEvenEnableBtnC() {
		for (ClicListener ecout : OBJETS_ENREGISTRES.getListeners(ClicListener.class)) {
		ecout.enableBtnC();
		}
		}
	//Rostislav
	/**
	 * Permet de lever la désactivation des buttons d'animation
	 */
	public void leverEvenDisableBtnAnimation() {
		for (ClicListener ecout : OBJETS_ENREGISTRES.getListeners(ClicListener.class)) {
			ecout.disableBtnAnimation();
			}
	}
	
	// Rostislav
	/**
	 * Methode qui permet l'animation
	 *
	 */
	@Override
	public void run() {

		while (enCoursDAnimation) {
		

			for (int k = 0; k < nbIterationsPhysiques; k++) {
				calculerUneIterationPhysique();
				if(cercle.getxPos()>1) {
					cercle.setxPos(0);
					
				}else if(cercle.getxPos()<0) {
					cercle.setxPos(1);
				}else if(cercle.getyPos()>0.6) {
					cercle.setyPos(0);
				}else if(cercle.getyPos()<0) {
					cercle.setyPos(0.6);
				}
			}
			repaint();
			try {
				Thread.sleep(thread); // petit delai pour ralentir
			} catch (InterruptedException e) {
				System.out.println("Processus interrompu!");
			}
		}

	}

	// Rostislav
	/**
	 * @return le thread
	 */
	public int getThread() {
		return thread;
	}

	// Rostislav
	/**
	 * @param thread
	 */
	public void setThread(int thread) {
		this.thread = thread;
	}

	// Rostislav
	public void setCyclotron() {

		repaint();
		vrai = true;
	}

	



	


	
	

	
	// Rostislav
	/**
	 * permet de calcule l'acceleration à partir de la force électrique d'une tige
	 */
	public void calculForceEletriquetTige() {
		E = 2 * k * denssiteLineique / distanceT * masseElectron;
		Fe = q * E;
		acceleration = Fe / masseElectron;

	}

	



	// Rostislav
	/**
	 * permet de detecte si la particule est dans la zone arriver
	 */
	public void particuleDansZoneArriver() {
		if (!listZA.isEmpty()) {
			for (int i = 0; i < listZA.size(); i++) {
				if (cercle.enIntersectionAvec(listZA.get(i).getAireTotale())) {
					cercleEnZoneA = true;
					victoire.play();
					JOptionPane.showMessageDialog(null,
							"Victoire !" + "\n" + "La particule a atteint la zone d'arrivée.");
					;

				}
			}
		}
	}
	// Rostislav
	/**
	 * @return vrai
	 */
	public boolean getvrai() {
		return vrai;

	}

	// Rostislav
	/**
	 * Methode permetant de detecte si la particule est dans une des zones
	 * magentique
	 * 
	 */
	public void particuleDansZM() {

		if (!listZM.isEmpty()) {
			for (int i = 0; i < listZM.size(); i++) {

				if (cercle.enIntersectionAvec(listZM.get(i).getAireTotale())) {
					cercleEnZoneMG = true;
					vecteurB.setX(0);
					vecteurB.setY(0);
					
					double b=listZM.get(i).getChampMagnetique();
					if(listZM.get(i).getDirection()) {
						b=-b;
					}else {
						b=b;
					}
					
					vecteurB.setZ(b);

					repaint();

				} else {
	

				}

			}
		}

	}

	// Rostislav
	/**
	 * Methode permetant de detecte si la particule est a l'interieur du syteme de
	 * plaque
	 * 
	 */
	public void particuleDansSystemePlaque() {
		if (!listSP.isEmpty()) {
			for (int i = 0; i < listSP.size(); i++) {	
				if (cercle.enIntersectionAvec(listSP.get(i).getAireReaction())) {
					champElectrique=listSP.get(i).getChampElectrique();
					if(listSP.get(i).getDirection()) {
						champElectrique=-champElectrique;
					}else {
						champElectrique=champElectrique;
					}
					cercleEnSP = true;
			
				} else {
			
				}

			}
		}
	}

	// Rostislav
	/**
	 * Methode permetant de detecte si la particule est dans une des zones genere
	 * par le fil supperieure
	 * 
	 */
	public void particuleDansFilSup() {
		if (!listFil.isEmpty()) {
			for (int i = 0; i < listFil.size(); i++) {
				if (cercle.enIntersectionAvec(listFil.get(i).getAireSuperieure())) {

				System.out.println(	"la particule est a l'interieur du champ superieure  genere par le fil  nr " + (i + 1));
				cercleEnChampSupFil = true;
				calculDistanceFil(listFil.get(i));
				System.out.println("La distance entre la paritcule et le fil " + distanceF);
			   
				courantElectrique=listFil.get(i).getCourantElectrique();
			System.out.println("le courant electrique " +courantElectrique);
			if(listFil.get(i).getDirection()) {
								
						direction=1;
						}else{
						
					direction=-1;
						}
				
				} else {

				

				}

			}

		}
	}
	// Rostislav
/**
 * Methode qui permet de detecte si la particule est dans une des zones genere par le fil
 * inferieure
 */
	public void particuleDansFilInf() {
		if (!listFil.isEmpty()) {
			for (int i = 0; i < listFil.size(); i++) {
				if (cercle.enIntersectionAvec(listFil.get(i).getAireInferieure())) {

				
					cercleEnChampInfFil = true;
					
						calculDistanceFil(listFil.get(i));
						System.out.println("La distance entre la paritcule et le fil " + distanceF);
						
						courantElectrique=listFil.get(i).getCourantElectrique();
						if(listFil.get(i).getDirection()) {
						
							direction=-1;
						}else {
						direction=1;
						}
					
					
				} else {
	

				}
			}
		}
	}
	//Rostislav
	/**
	 * Methode qui permet de detecte si la particule est dans entre en collision avec un des objets
	 */
	
	 public void particuleEnCollisionAvecObjet() {
		 if(!listColision.isEmpty()) {
			 for(int i=0; i<listColision.size();i++) {
				 if(cercle.enIntersectionAvec(listColision.get(i).getAreaCollision(listColision.get(i), mat))) {
					collision=true;
					
				 }else {
					 
				 }
			 }
		 }
	 }

	// Rostislav
	/**
	 * return la valeur vrai
	 * @param vrai
	 */
	public void setvrai(boolean vrai) {
		this.vrai = vrai;
	}

	/**
	 * 
	 * @param dessiner
	 */
	public void setDessiner(int dessiner) {
		this.dessiner = dessiner;
	}
	//Louis 
	/**
	 * permet de rendre visible ou pas le quadrillage
	 * @param quadrillage si true le quadrillage est visible,false non visible 
	 */
	public void setQuadrillage(boolean quadrillage) {
		this.quadrillage = quadrillage;
		repaint();
	}

	

	// Rostislav
	/**
	 * Methode permettant de demare l'animation
	 */
	public void demarrer() {
		if (!enCoursDAnimation) {
			Thread processusAnim = new Thread(this);
			processusAnim.start();
			remettreCouleur();
			enCoursDAnimation = true;
		}
	}

	// Rostislav
	/**
	 * 
	 * @return si l'animation est en cours ou pas
	 * 
	 */
	public boolean getAnimation() {
		if (enCoursDAnimation) {
			return true;
		} else {
			return false;
		}
	}

	// Rostislav
	/**
	 * Methode permetant l'arret de l'animation
	 */
	public void arreter() {
		enCoursDAnimation = false;
	}

	// Rostislav
	/**
	 * Methode permetant d assigner le vecteur de vitesse
	 */
	public void assignerLeVecteurVitesse() {

		vitesse.setXY(vitesseParticuleFX, vitesseParticuleFY);
	
	}

	// Rostislav
	/**
	 * Methode permetant d assigner le vecteur d acceleration
	 */
	public void assignerLeVecteurAcceleration() {
		accel.setXY(accelerationX, accelerationY);
	}

	// Rostislav
	/**
	 * Methode permetant d assigner le vecteur de position
	 */
	public void assignerLeVecteurPosition() {
		position.setXY(cercle.getxPos(), cercle.getyPos());
	}

	
	
	

	

	// Rostislav
	/**
	 * permet le calcul d<une iteration physique 
	 */
	public void calculerUneIterationPhysique() {
 courantElectrique=5000;
		assignerVecteurVitesse3d();
  assignerVecteurPosition3d();
  particuleDansZM();
  Euler3D(deltaT, p, vit, ac);
  particuleDansFilInf();
  particuleDansFilSup();
  particuleEnCollisionAvecObjet();
  particuleDansSystemePlaque();
  particuleDansZoneArriver();
  if(cercleEnZoneMG) {
	  calculDeLaForceMagnetique3D(vit, vecteurB, masse, charge);
      
  }if (cercleEnSP) {
		
		calculDeLaForceElectriqueSystemePlaque(charge, champElectrique, masse);
  }
  if(!listTige.isEmpty()) {
  for(int i = 0; i < listTige.size(); i++) {
	  densite=listTige.get(i).getDensite();
	  calculDistance(listTige.get(i));
		calculDeLaForceElectriqueTige(distanceT, charge, masse,densite);
	}
    }if (cercleEnChampSupFil) {
		calculDuChampMagnetique(-courantElectrique, distanceF,direction);
	    calculDeLaForceMagnetique3D(vit, vecteurB, masse, charge);
	}
    
	if (cercleEnChampInfFil) {

		calculDuChampMagnetique(courantElectrique, distanceF,direction);
	    calculDeLaForceMagnetique3D(vit, vecteurB, masse, charge);
	}
	if(cercleEnZoneA) {
		arreter();
	}
	if(avecCollision) {
	if(collision) {
		arreter();
		defaite.play();
		 JOptionPane.showMessageDialog(null,
					"Défaite !" + "\n" + "La particule est entrée en collision avec un objet.");
	}}else {
		
	}


	 Euler3D(deltaT, p, vit, ac);
	
	cercleEnZoneA = false;
  cercleEnZoneMG = false;
	cercleEnSP = false;
cercleEnChampInfFil=false;
cercleEnChampSupFil=false;
collision=false;


	
tempsTotalEcoule += deltaT;


	leverEvenParticuleIteration(vit.modulus(), fMag.modulus(), vecteurFeR.modulus(), ac.modulus(), tempsTotalEcoule);
	repaint();
	}

	// Rostislav
	/**
	 * Methode permettant de revenir a l etat initial de l application
	 */
	public void reset() {
		arreter();
		listC.clear();
		listFil.clear();
		listSP.clear();
		listTige.clear();
		listZA.clear();
		listZM.clear();

       assignerLeVecteurVitesse();
       assignerVecteurPosition3d();
     resetInitial(ac);
     resetInitial(vecteurB);
     resetInitial(vecteurE);
     resetInitial(vecteurFMR);
     resetInitial(vecteurFeR);
     resetInitial(acFe);
     resetInitial(acSP);
     resetInitial(acfM);
     resetInitial(fEl);
     resetInitial(fMag);
     
       cycloExiste = false;

		accelerationY = 0;
		accelerationX = 0;
		acceleration = 0;
		pourcentageVitesse = 0.2;
		vitesseParticuleFX = pourcentageVitesse * c;
		vitesseParticuleFY = 0;
		
		cycloExiste = false;
tempsTotalEcoule=0;
		listObjet.clear();
	    listColision.clear();
		repaint();
		leverEvenCyclotronInterieurZoneArrive(true);
		leverEvenParticuleIteration(vit.modulus(), fMag.modulus(), vecteurFeR.modulus(), ac.modulus(), tempsTotalEcoule);
	if(vit.modulus()>c) {
		vitesseParticuleFX = pourcentageVitesse * c;
		vitesseParticuleFY = 0;
	}
	}
	//Rostislav
	/**
	 * Methode permettant de replace la particule a la position intial est reinisialiser ses parametres de forces
	 */
	public void resetPositionParticule() {
		arreter();

	   
	     resetInitial(ac);
	     resetInitial(p);
	     resetInitial(vecteurB);
	     resetInitial(vecteurE);
	     resetInitial(vecteurFMR);
	     resetInitial(vecteurFeR);
	     resetInitial(acFe);
	     resetInitial(acSP);
	     resetInitial(acfM);
	     resetInitial(fEl);
	     resetInitial(fMag);
	     cercle.setxPos(listC.get(0).getxPos()+cTemporaire.getDiametre());
			cercle.setyPos(listC.get(0).getyPos()+cTemporaire.getDiametre());
	     accelerationY = 0;
			accelerationX = 0;
			acceleration = 0;
			pourcentageVitesse = 0.2;
			vitesseParticuleFX = pourcentageVitesse * c;
			vitesseParticuleFY = 0;
			accelerationCentripede = 0;
		    assignerLeVecteurVitesse();
		       assignerVecteurPosition3d();	
	repaint();
	leverEvenParticuleIteration(vit.modulus(), fMag.modulus(), vecteurFeR.modulus(), ac.modulus(), tempsTotalEcoule);
	}

	// Rostislav
	/**
	 * 
	 * @return la liste de tige
	 */
	public ArrayList<Tige> getListTige() {
		return listTige;
	}
	//Rostislav
	/**
	 * 
	 * @return la list de cyclotron
	 */
	public ArrayList<Cyclotron> getListC() {
		return listC;
	}
	//Rostislav
	/**
	 * 
	 * @return la list de fil
	 */
	public ArrayList<Fil> getListFil() {
		return listFil;
	}
	//Rostislav
	/**
	 * 
	 * @return la liste de plaque
	 */
	public ArrayList<SystemPlaque> getListSP() {
		return listSP;
	}
	//Rostislav
	/**
	 * 
	 * @return la liste de zone d'arriver
	 */
	public ArrayList<ZoneArriver> getListZA() {
		return listZA;
	}
	//Rostislav
	/**
	 * 
	 * @return la liste de zone magnetique
	 */
	public ArrayList<ZoneMagnetique> getListZM() {
		return listZM;
	}
	//Louis
	/**
	 * permet de changer la vitesse grâce au curseur du panelCyclotron
	 * @param pourcentageVitesse un pourcentage ^^'
	 */
	public void setVitesse(double pourcentageVitesse) {
		this.pourcentageVitesse = pourcentageVitesse;
		this.vitesseParticuleFX = pourcentageVitesse * c;
	}
	//Louis
	/**
	 * permet de changer la direction du Systeme de plaque sois la plaque positive en haut ou en bas..
	 * @param direction si true plaque negative en haut, false plaque negative en bas
	 */
	public void setDirectionSP(boolean direction) {		
		if(!listSP.isEmpty()) {
			listSP.get(numeroSP).setDirection(direction);
			repaint();
		}
	}
	//Louis
	/**
	 * permet de changer la valeur du champ electrique du systeme de plaque 
	 * @param e la valeur du champ electrique
	 */
	public void setESP(double e) {
		if(!listSP.isEmpty()) {
			listSP.get(numeroSP).setChampElectrique(e);
		}
	}
	//Louis
	/**
	 * permet de changer la direction du champ magnetique sois entrant ou sortant de la zone magnetique 
	 * @param direction si true alors le champ sort, false le champ entre
	 */
	public void setDirectionZM(boolean direction) {
		if(!listZM.isEmpty()) {
			listZM.get(numeroZM).setDirection(direction);
			repaint();
		}
	}
	//Louis
	/**
	 * permet de changer la valeur du champ magnetique de la zone magnetique
	 * @param b la valeur du champ magnetique
	 */
	public void setBZM(double b) {
		if(!listZM.isEmpty()) {
			listZM.get(numeroZM).setChampMagnetique(b);
		}	
	}
	//Louis
	/**
	 * permet de changer la densite de la tige
	 * @param d la valeur de la densite
	 */
	public void setDensiteTige(double d) {
		if(!listTige.isEmpty()) {
			listTige.get(numeroTige).setDensite(d);
		}	
	}
	//Louis
	/**
	 * 
	 * permet de changer la direction du sens du courant du fil
	 * @param direction true gauche a droite, false droite a gauche
	 */
	public void setDirectionFil(boolean direction) {
		if(!listFil.isEmpty()) {
			listFil.get(numeroFil).setDirection(direction);
			repaint();
		}	
	}
	//Louis
	/**
	 * permet de changer la valeur du champ Magnetique du fil
	 * @param b la valeur du champ magnetique
	 */
	public void setBFil(double b) {	
		if(!listFil.isEmpty()) {
			listFil.get(numeroFil).setCourantElectrique(b);;
		}	
	}
	//Louis
	/**
	 * permet de changer la largeur de la zone d'arrivee
	 * @param largeur la valeur de la largeur de la zone d'arrivee
	 */
	public void setLargeurZA(double largeur) {
		if(!listZA.isEmpty()) {
			listZA.get(numeroZA).setLargeur(largeur);
			for (int i = 0; i < listObjet.size(); i++) {
				if (listObjet.get(i) instanceof ZoneArriver) {
					listObjet.remove(i);
					listObjet.add(listZA.get(numeroZA));
				}
			}
			repaint();
		}
	}
	//Louis
	/**
	 * permet de changer la hauteur de la zone d'arrivee
	 * @param hauteur la valeur de la hauteur de la zone d'arrivee
	 */
	public void setHauteurZA(double hauteur) {
		if(!listZA.isEmpty()) {
			listZA.get(numeroZA).setHauteur(hauteur);
			for (int i = 0; i < listObjet.size(); i++) {
				if (listObjet.get(i) instanceof ZoneArriver) {
					listObjet.remove(i);
					listObjet.add(listZA.get(numeroZA));
				}
			}
			repaint();
		}
		
	}
	//Louis
	public void setCouleurP(String type) {
		if(type == "Électron (e-)") {
			cercle.setCouleurParticule(Color.red);
		}
		if(type == "Gros électron (2e-)") {
			cercle.setCouleurParticule(new Color(1.0f, 0.28f, 0.59f, 1.0f));
		}
		if(type == "Particule spéciale (e)") {
			cercle.setCouleurParticule(Color.blue);
		}
		if(type == "Grosse particule spéciale (2e)") {
			cercle.setCouleurParticule(new Color(0.28f, 0.59f, 1.0f, 1.0f));
		}
	}
	
	//Rostislav
	/**
	 * Methode permettant d assigner le vecteur de vitesse
	 */
	
	public void assignerVecteurVitesse3d() {
	vit.setX(vitesseParticuleFX);
	vit.setY(vitesseParticuleFY);
	vit.setZ(0);
	}
	//Rostislav
	/**
	 * Methode permettant d assigner le vecteur de position
	 */
	public void assignerVecteurPosition3d() {
		p.setX(cercle.getxPos());
		p.setY(cercle.getyPos());
		p.setZ(0);	
	}
	//Rostislav
	/**
	 * Methode permettat d'effectuer le deplacement de la particule dans l espace à l'aide d'euler
	 * @param deltaT 
	 *              le temps pour le quelle on calcul un deplacement
	 * @param position
	 *               le vecteur de position de la particule 
	 * @param vitesse
	 *               le vecteur de vitesse de la particule
	 * @param accel
	 *               le vecteur d'acceleration de la particule
	 */
		public void Euler3D(double deltaT, SVector3d position, SVector3d vitesse, SVector3d accel) {
	
		SVector3d deltaVitesse =accel.multiply(deltaT);
		SVector3d resultV = vitesse.add(deltaVitesse);
		vitesse.setX(resultV.getX());
		vitesse.setY(resultV.getY());
	    vitesse.setZ(resultV.getZ());
	    SVector3d deltaPosition = vitesse.multiply(deltaT);
		SVector3d resultP = position.add(deltaPosition);
		position.setX(resultP.getX());
		position.setY(resultP.getY());
		cercle.setxPos(position.getX());
		cercle.setyPos(position.getY());
	}
		//Rostislav
		/**
		 * Methode permettant le calcul  de la force magnetique en foction du champ et de la particule en question
		 * @param vitesse
		 *              le vecteur de vitesse
		 * @param B
		 *              le vecteur du champ magnetique
		 * @param masseElectron
		 *               la masse de la particule
		 * @param electron
		 *                la charge de la particule
		 */
		public void calculDeLaForceMagnetique3D(SVector3d vitesse, SVector3d B, double masseElectron, double electron) {
			fMag = (vitesse.cross(B));
			fMag = (fMag.multiply(electron));
			vecteurFMR=vecteurFMR.add(fMag);
			acfM=fMag.multiply(1/masseElectron);
		 
			ac=ac.add(acfM);
//           System.out.println("la force magnetique " +fMag.modulus());
//           System.out.println("L acceleration " +ac.modulus());
		}
		//Rostislav
		/**
		 * Methode qui permet de calculer la force electrique et l'acceleration subi 
		 * @param q
		 *         la charge de la particule
		 * @param E
		 *         le champ electrique de la particule
		 * @param masse
		 *         la masse de la particule
		 */
		
		public void calculDeLaForceElectriqueSystemePlaque(double q, double E, double masse) {
		SVector3d f= new SVector3d();
		f.setY(q*E);
			vecteurFeR.add(f);
			a=(q*E)/masse;
			acSP.setX(0);
			acSP.setY(a);
			acSP.setZ(0);
			ac=ac.add(acSP);
		}
		// Rostislav
		/**
		 * permet de calculer la distance entre la particule et la tige
		 * @param tige
		 *            l'objet en question tige
		 */
		public void calculDistance(Tige tige) {
			double x=tige.getxPos()-cercle.getxPos();
	        double y=tige.getyPos()-cercle.getxPos();
//	        System.out.println(" le x "+x);
//	        System.out.println(" le y "+y);
//	        System.out.println(Math.tan(y/x));
	  distanceTige.setXY(x, y);
	     
	       distanceT=distanceTige.module();
	//	  System.out.println("La distance entre la particule et la tige "+ distanceT);
		}
		//Rostislav
		/**
		 * Perme le calcul de la force electrique en foction des tiges
		 *  
		 * @param distanceT
		 *                la distance entra la tige et la particule
		 * @param electron
		 *                la charge de la particule
		 * @param masseElectron
		 *                la masse de la particule
		 * @param denssiteLineique
		 *                la densite lineique de la tige
		 */
		public void calculDeLaForceElectriqueTige(double distanceT,double electron,double masseElectron,double denssiteLineique) {
			
			double particule;
			if(distanceTige.getX()<0) {
				particule = -electron;
			}else {
				particule =electron;
			}
			
			E=(2*k*Math.abs(denssiteLineique))/(Math.abs(distanceT));
		 //   System.out.println("le champ elecetrique a ce point la "+ E);
		 vecteurE.setX(-E*Math.cos(Math.tan(distanceTige.getY()/distanceTige.getX())));
		 vecteurE.setY(-E*Math.sin(Math.tan(distanceTige.getY()/distanceTige.getX())));	
		 vecteurE.setZ(0);
		 
		fEl=vecteurE.multiply(particule);
		 vecteurFeR=vecteurFeR.add(fEl);
	//	System.out.println(" La force Electrique est de "+ fEl.modulus());
		  acFe=fEl.multiply(1/masseElectron);
	//	 System.out.println(" le acFe "+acFe);
		  ac=ac.add(acFe);
		
		}
		//Rostislav
		/**
		 * La distance entre le fil  et la particule
		 * @param fil
		 *       l'objet fil en question
		 * @return distanceF
		 *          la distance entre l'objet et la particule
		 */
		public double calculDistanceFil(Fil fil) {
			distanceF = fil.getyPos() - cercle.getyPos();
	//		System.out.println("La distance "+distanceF);
			return distanceF;
		}
		//Rostislav
		/**
		 * Calcul du champ magnetique en foction de la position de la particule
		 * @param I    l'intesite du courant
		 *     
		 * @param distanceF    la distance entre la particule et le fil
		 *       
		 * @return B   le champ magnetique en foction de la distance
		 *         
		 */
		public double calculDuChampMagnetique(double I, double distanceF,double direction) {
			B = direction*(((4 * Math.PI) * Math.pow(10, -7)) * I) / (2 * Math.PI * Math.abs(distanceF));
			vecteurB.setZ(B);
	//		System.out.println("le champ magnetique genere " + B);
			return B;
		}
		//Rostislav
		/**
		 *  permet de reset les vecteur
		 * @param v
		 */
		public void resetInitial(SVector3d v) {
			v.setX(0);
			v.setY(0);
			v.setZ(0);
		}
		//Rostislav
		/**
		 * Permet de modifier le boolean
		 * @param avecCollision
		 *                boolean des collisions
		 */
	public void setAvecCollision(boolean avecCollision) {
		this.avecCollision = avecCollision;
	}
	//Rostislav
	/**
	 * Returne charge
	 * @return charge
	 */
	public double getCharge() {
		return charge;
	}
	//Rostislav
	/**
	 * permet de modifier la valeur de charge
	 * @param charge
	 */
	public void setCharge(double charge) {
		this.charge = charge;
	}
	//Rostislav
	/**
	 * permet de modifier la masse
	 * @param masse
	 */
	public void setMasse(double masse) {
		this.masse = masse;
	}
	//Rostislav
	/**
	 * permet de modifier le courant electrique
	 * @param courantElectrique 
	 */
public void setCourantElectrique(double courantElectrique) {
	this.courantElectrique = courantElectrique;
}
//Rostislav
/**
 * permet de modifier  le boolean vecteurAF
 * @param vecteurAF
 *            boolean qui dit si le vecteur s'afficher ou pas
 */
public void setVecteurAF(boolean vecteurAF) {
	this.vecteurAF = vecteurAF;
	repaint();
}
}
