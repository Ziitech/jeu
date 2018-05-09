package modele.metier.entities.mob;

import java.awt.event.KeyEvent;

import modele.metier.Carte;
import modele.metier.input.Keyboard;

/**
 * Classe joueur controlable par l'utilisateur
 * 
 * @author Nandaleio
 * 
 *
 */

public class Joueur extends Mob {
	
	/**
	 * clavier qui controle le joueur
	 */
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
		vitesseX = vitesseY =0;
		//fall();
		
		if(key.isKey(KeyEvent.VK_S)) accelere(0f  , 5.5f);
		if(key.isKey(KeyEvent.VK_Z)) accelere(0f  , -5.5f);
		if(key.isKey(KeyEvent.VK_Q)) accelere(-5.5f, 0);
		if(key.isKey(KeyEvent.VK_D)) accelere(5.5f, 0);
		
		if(!map.getSolidTileAt(x, y)) {
			move();
		}
		
		
		
	}
	
	

}
