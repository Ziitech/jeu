package vue;

import java.awt.Graphics;

import java.awt.HeadlessException;
import java.awt.event.KeyListener;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;

import javax.swing.JFrame;

import controleur.Manager;
import vue.sprite.Sprite;

/**
 * Fenetre sur laquelle sera affiché les acteurs du jeu (carte + entites)
 * Utilise Swing
 * @author Nandaleio
 *
 */
public class Cadre extends JFrame implements Vue {
	

	/**
	 * 
	 */
	private static final long serialVersionUID = 925091389473095140L;
	
	/**
	 * Ecran qui calcule les pixels a afficher
	 */
	private Screen screen;
	
	/**
	 * l'image sur la fenetre
	 */
	private BufferedImage image;
	/**
	 * l'image sur la fenetre represente en tant que tableau de pixels (en int ex: 0xffff00ff = rose)
	 */
	private int[] pixels;

	/**
	 * initailise les dimension, la position, le titre et le tableau de pixels 
	 * @param w la largeur de le fenetre
	 * @param h la hauteur de la fenetre
	 * @throws HeadlessException
	 */
	public Cadre(int w, int h) throws HeadlessException {
		super("Title");
		screen = new Screen(w,h);
		setSize(w, h);

		setLocationRelativeTo(null);
		
		image = new BufferedImage(getWidth(), getHeight(), BufferedImage.TYPE_INT_ARGB);
		pixels = ((DataBufferInt) image.getRaster().getDataBuffer()).getData();
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setExtendedState(MAXIMIZED_BOTH);
		setVisible(true);
		
		Manager.getInstance().setVue(this);
	}
	
	
	/**
	 * affiche le tableau de pixels du Screen a l'ecran
	 */
	public void render() {
		int[] pixels = screen.getPixel();
		BufferStrategy bs = getBufferStrategy();;
		while(bs == null) {
			bs = getBufferStrategy();
			if(bs == null) {
				createBufferStrategy(2); // 2 ou 3
				continue;
			}
		}
		
		for(int i = 0 ; i < pixels.length ; i++) {
			this.pixels[i] = pixels[i];
		}
		
		Graphics g;
		g = bs.getDrawGraphics();
		g.drawImage(image, 0, 0, null);
		g.dispose();
		bs.show();
	}
	
	/**
	 * affiche un ecran noir
	 */
	public void clear(int color) {
		screen.fillColor(color);
	}

	/**
	 * dessine un sprite a une position donnée et son sens d'orientation
	 */
	@Override
	public void drawEntity(int x, int y,Sprite s, boolean flip) {
		screen.renderMob(x, y, s, flip);
		screen.drawPixel(x, y, 0xffff0000);
		
	}

	/**
	 * dessine une tuile (un carre) a une position donnée et une coleur donnée
	 */
	@Override
	public void drawTiles(int x, int y,int size, int tilesAt) {
		screen.drawTile(x, y, size, tilesAt);
	}

	/**
	 * ajoute un keyListener
	 */
	@Override
	public void addKey(KeyListener k) {
		System.out.println("ajout KeyListener " + k.toString());
		addKeyListener(k);
		
	}

	/**
	 * ajoute un MouseMotionListener et un MouseListener
	 */
	@Override
	public void addMouse(MouseMotionListener k, MouseListener l) {
		System.out.println("ajout MouseListener " + l.toString());
		addMouseListener(l);
		
		System.out.println("ajout MouseMotionListener " + k.toString());
		addMouseMotionListener(k);
		
	}

	/**
	 * retourne la largeur de la fenetre
	 */
	@Override
	public int getFrameWidth() {
		return getWidth();
	}

	/**
	 * retourne la hauteur de la fenetre
	 */
	@Override
	public int getFrameHeight() {
		return getHeight();
	}

	
	/**
	 * dessine un curseur a la position de la souris
	 */
	@Override
	public void drawCursor(int mouseX, int mouseY) {
		screen.drawCircle(mouseX, mouseY, 10, 0xffff0000);
		screen.drawLine(mouseX-7, mouseY-7, mouseX+7, mouseY+7, 0xffff0000);
		screen.drawLine(mouseX+7, mouseY-7, mouseX-7, mouseY+7, 0xffff0000);
	}

}
