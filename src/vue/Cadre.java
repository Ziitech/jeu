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

public class Cadre extends JFrame implements Vue {
	

	/**
	 * 
	 */
	private static final long serialVersionUID = 925091389473095140L;
	
	private Screen screen;
	
	private BufferedImage image;
	private int[] pixels;

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
		Manager.getInstance().startGame();
	}
	
	public void render() {
		int[] pixels = screen.getPixel();
		BufferStrategy bs = getBufferStrategy();;
		while(bs == null) {
			bs = getBufferStrategy();
			if(bs == null) {
				createBufferStrategy(2); // 2 / 3
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
	
	public void clear() {
		screen.clear();
	}

	@Override
	public void drawEntity(int x, int y,Sprite s, boolean flip) {
		screen.renderMob(x, y, s, flip);
	}

	@Override
	public void drawTiles(int x, int y,int size, int tilesAt) {
		screen.drawTile(x, y, size, tilesAt);
		//screen.drawRect(x, y, size, tilesAt);
		
	}

	@Override
	public void addKey(KeyListener k) {
		System.out.println("ajout KeyListener " + k.toString());
		addKeyListener(k);
		
	}

	@Override
	public void addMouse(MouseMotionListener k, MouseListener l) {
		System.out.println("ajout MouseListener " + l.toString());
		addMouseListener(l);
		
		System.out.println("ajout MouseMotionListener " + k.toString());
		addMouseMotionListener(k);
		
	}

	@Override
	public int getFrameWidth() {
		return getWidth();
	}

	@Override
	public int getFrameHeight() {
		return getHeight();
	}

	@Override
	public void drawCursor(int mouseX, int mouseY) {
		screen.drawCircle(mouseX, mouseY, 30, 0xffff00ff);
		screen.drawCircle(mouseX, mouseY, 29, 0xffff0000);
		screen.drawCircle(mouseX, mouseY, 28, 0xffff00ff);
	}

}
