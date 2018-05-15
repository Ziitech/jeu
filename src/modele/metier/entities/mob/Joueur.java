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
	
	private boolean saute;
	
	public Joueur(int x, int y,Carte map, Keyboard k) {
		super(map);
		this.x = x;
		this.y = y;
		key = k;
		
		type = 1;
	}

	@Override
	public void update() {
		vitesseX *= 0.5;
		vitesseY *= 0.5;
		fall();
		
		if(key.isKey(KeyEvent.VK_Z) && !saute) saute();
		if(key.isKey(KeyEvent.VK_Q)) accelere(-4.5f, 0);
		if(key.isKey(KeyEvent.VK_D)) accelere(4.5f, 0);
		
		if(!collision()) {
			move();
		}
		else {
			saute = false;
		}
		
		
		
	}
	
	

}
