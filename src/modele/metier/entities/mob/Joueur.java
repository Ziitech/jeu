package modele.metier.entities.mob;

import java.awt.event.KeyEvent;

import modele.metier.Carte;
import modele.metier.input.Keyboard;

public class Joueur extends Mob {
	
	private Keyboard key;
	
	public Joueur(int x, int y,Carte map, Keyboard k) {
		super(map);
		this.x = x;
		this.y = y;
		key = k;
		
		type = 1;
	}

	@Override
	public void update() {
		
		vitesseX = vitesseY = 0;
		//vitesseY += 1;
		if(key.isKey(KeyEvent.VK_Z)) vitesseY = -5.5f;
		if(key.isKey(KeyEvent.VK_S)) vitesseY = 5.5f;
		if(key.isKey(KeyEvent.VK_Q)) vitesseX = -5.5f;
		if(key.isKey(KeyEvent.VK_D)) vitesseX = 5.5f;
		
		if(key.isKey(KeyEvent.VK_E)) map.explosion(x, y, 10);
		
		if(vitesseX < 0) flip = true;
		if(vitesseX > 0) flip = false;
		
		if(!map.getSolidTileAt(x, y)) {
			x += vitesseX;
			y += vitesseY;
		}
	}

}
