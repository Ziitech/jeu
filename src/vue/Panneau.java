package vue;

import java.awt.Graphics;
import java.awt.Image;
import javax.swing.JPanel;

public class Panneau extends JPanel {

	private static final long serialVersionUID = 1L;
	/**
	 * Image du fractale
	 */
	private Image img;
	
	/**
	 * Initialisation du panel
	 */
	public Panneau()
	{
		setVisible(true);
		img = null;
	}
	
	/**
	 * Affichage de l'image 
	 */
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		g.drawImage(img, 0, 0, null);
	}
	/**
	 * Attribution de l'image pour que le panel puisse l'afficher
	 * @param image image
	 */
	public void setImage(Image image){img = image;}
}
