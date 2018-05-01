package vue;

import java.awt.Graphics;
import java.awt.HeadlessException;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;

import javax.swing.JFrame;

import controleur.Manager;

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
		setVisible(true);
		screen = new Screen(w,h);
		setSize(w, h);
		
		image = new BufferedImage(getWidth(), getHeight(), BufferedImage.TYPE_INT_ARGB);
		pixels = ((DataBufferInt) image.getRaster().getDataBuffer()).getData();
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		
		Manager.getInstance().setVue(this);
		Manager.getInstance().startGame();
	}
	
	public void render() {
		int[] pixels = screen.getPixel();
		BufferStrategy bs = getBufferStrategy();;
		while(bs == null) {
			bs = getBufferStrategy();
			if(bs == null) {
				createBufferStrategy(2);
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
	public void drawEntity(int x, int y, int color) {
		screen.drawRect(x, y, 10, color);
		
	}


}
