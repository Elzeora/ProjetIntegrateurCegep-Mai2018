package fenetre;


import java.applet.Applet;
import java.applet.AudioClip;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import aaplication.App14AventureParticule;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import image.ImageParticule;
import objets.BoutonObjets;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.UIManager;

/**
 * 
 * @author Louis Roberge
 * Jframe de demarrage
 *
 */
public class FenetrePrincipale extends JFrame {


	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private App14AventureParticule application;
	private FenetreInstruction instruction;
	private FenetreAPropos aPropos;
	private BoutonObjets btnObjets;
	private java.net.URL urlFichier= getClass().getClassLoader().getResource( "clic.wav" ); 
	private AudioClip clic = Applet.newAudioClip( urlFichier);
	private ImageParticule imageParticule;
	private FenetreTest fenetreTest;
		
	/**
	 * Lancement de l'application
	 */
	public static void main(String[] args) {
		try {
		} catch (Throwable e) {
			e.printStackTrace();
		}
		try {
		} catch (Throwable e) {
			e.printStackTrace();
		}
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ImageIcon img = new ImageIcon(getClass().getClassLoader().getResource("Particule.png"));
					FenetrePrincipale frame = new FenetrePrincipale();
					frame.setIconImage(img.getImage());
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * création du jframe
	 */
	public  FenetrePrincipale() {
		setTitle("Les Aventures D'une Particule");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1632, 964);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(135, 206, 235));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		
	
		/*
		 * Creation du panel d'application
		 */
	    application = new App14AventureParticule(btnObjets);
	    ImageIcon img = new ImageIcon(getClass().getClassLoader().getResource("Particule.png"));
	    application.setIconImage(img.getImage());
	    application.setLocationRelativeTo(null);
		application.setVisible(false);  
		/*
		 * Creation du panel des instructions
		 */
		instruction = new FenetreInstruction();
		instruction.setIconImage(img.getImage());
		instruction.setLocationRelativeTo(null);
		instruction.setVisible(false);
		
		aPropos = new FenetreAPropos();
		aPropos.setIconImage(img.getImage());
		aPropos.setLocationRelativeTo(null);
		aPropos.setVisible(false);
		
		
	

		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 1614, 19);
		contentPane.add(menuBar);

		JMenu mnNewMenu = new JMenu("Aide");
		menuBar.add(mnNewMenu);

		JMenuItem mntmNewMenuItem = new JMenuItem("Les Guides");
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				clic.play();
				instruction.setLocationRelativeTo(null);
				instruction.setVisible(true);
			}
		});
		mnNewMenu.add(mntmNewMenuItem);

		JMenuItem mntmQuitter = new JMenuItem("Quitter");
		mntmQuitter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				// d
				clic.play();
				dispose();
				// f
			}
		});
		mnNewMenu.add(mntmQuitter);
		

		fenetreTest = new FenetreTest();
		fenetreTest.setBounds(0, 18, 1614, 904);
		contentPane.add(fenetreTest);
		fenetreTest.setLayout(null);
		
		JButton button = new JButton("Jouer");
		button.setBackground(UIManager.getColor("Button.light"));
		button.setBounds(59, 560, 607, 41);
		fenetreTest.add(button);
		button.setFont(new Font("Yu Gothic Medium", Font.BOLD, 17));
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				clic.play();
				application.setVisible(true);
				dispose();
			}
		});
		
		imageParticule = new ImageParticule();
		imageParticule.setBounds(974, 116, 607, 587);
		fenetreTest.add(imageParticule);
		imageParticule.setBackground(Color.red);
		imageParticule.setOpaque(false);
		
		JButton btnNewButton = new JButton("\u00C0 Propos");
		btnNewButton.setBounds(59, 710, 607, 41);
		fenetreTest.add(btnNewButton);
		btnNewButton.setFont(new Font("Yu Gothic Medium", Font.BOLD, 17));
		
		JButton btnInstruction = new JButton("Les Guides");
		btnInstruction.setBounds(59, 635, 607, 41);
		fenetreTest.add(btnInstruction);
		btnInstruction.setFont(new Font("Yu Gothic Medium", Font.BOLD, 17));
		
		JButton btnQuitter = new JButton("Quitter");
		btnQuitter.setBounds(59, 785, 607, 41);
		fenetreTest.add(btnQuitter);
		btnQuitter.setFont(new Font("Yu Gothic Medium", Font.BOLD, 17));
		
		JLabel label = new JLabel("Les Aventures D'une Particule");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setForeground(Color.RED);
		label.setFont(new Font("Monotype Corsiva", Font.BOLD | Font.ITALIC, 66));
		label.setBackground(Color.BLACK);
		label.setBounds(48, 81, 870, 359);
		fenetreTest.add(label);
		
		JLabel lblNewLabel = new JLabel("Les Aventures D'une Particule");
		lblNewLabel.setForeground(Color.BLACK);
		lblNewLabel.setBackground(Color.BLACK);
		lblNewLabel.setBounds(48, 82, 870, 359);
		fenetreTest.add(lblNewLabel);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Monotype Corsiva", Font.BOLD | Font.ITALIC, 67));
		btnQuitter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//d
				clic.play();
				dispose();
				//f
			}
		});
		btnInstruction.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//d
				clic.play();
				instruction.setVisible(true);
				//f
			}
		});
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				clic.play();
				aPropos.setVisible(true);
			}
		});
		
	}
}
