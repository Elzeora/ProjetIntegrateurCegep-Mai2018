package image;






import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
/**
 * 
 * @author louis
 * Particule créé grâce a Paint.net par louis
 *
 */
public class ImageParticule  extends JPanel {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Image img = null;


	/**
	 * permet de chercher l'image
	 */
	public ImageParticule() {	
			URL fich = getClass().getClassLoader().getResource("Particule.png");
			if (fich == null) {
				JOptionPane.showMessageDialog(null,	"Fichier d'image introuvable!");
			} else {
				try {
					img = ImageIO.read(fich);
				} catch (IOException e) {
					e.printStackTrace();
				}

	}

}
	/**
	 * permet de dessiner l'image
	 */
	public void paintComponent(Graphics g) {
	super.paintComponent(g);
	Graphics2D g2d = (Graphics2D) g;
	g2d.drawImage(img, 0, 0, null); 
}
	}
