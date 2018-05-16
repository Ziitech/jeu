package vue;

import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.KeyListener;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

import controleur.Manager;
import vue.menu.Accueil;
import vue.sprite.Sprite;

public class CadreGeneral extends JFrame implements Vue{
	
	private Accueil accueil;
	
	public CadreGeneral(){
		accueil = new Accueil();
		Manager.getInstance().setVue(this);
		Image icone = Toolkit.getDefaultToolkit().getImage("image/logoSnail.png");
		ImageIcon icon = null;
		try {
			icon = new ImageIcon(ImageIO.read(new File("image/logoSnail.png")));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		JLabel contentPane = new JLabel(icon);
		//this.setContentPane(contentPane);
		this.add(accueil);
		this.setIconImage(icone);
		this.setTitle("JEU");
		this.setExtendedState(MAXIMIZED_BOTH);
		this.setSize(800, 400);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
		this.setVisible(true);
	}

	@Override
	public void addKey(KeyListener k) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addMouse(MouseMotionListener k, MouseListener l) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void render() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void drawEntity(int x, int y, Sprite s, boolean flip) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void drawTiles(int x, int y, int size, int tilesAt) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int getFrameWidth() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getFrameHeight() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void drawCursor(int mouseX, int mouseY) {
		// TODO Auto-generated method stub
		
	}

}
