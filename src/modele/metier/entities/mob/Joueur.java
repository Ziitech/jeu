package modele.metier.entities.mob;

import java.awt.event.KeyEvent;

import modele.metier.Carte;
import modele.metier.Constantes;
import modele.metier.input.Keyboard;

/**
 * Classe joueur controlable par l'utilisateur
 * 
 * @author Nandaleio
 * 
 *
 */

public class Joueur extends Mob {
	
	private int vie;
	private float vitesse;
	
	public Joueur(int x, int y,Carte map ) {
		super(x,y, map);
		
		type = 1;
		vie = 100;
		vitesse = Constantes.getConstantes().getVitesse(); // Possible ???
	}

	/*@Override
	public void update() {
		vitesseX *= 0.5;
		vitesseY *= 0.5;
		fall();
		
		if(key.isKey(KeyEvent.VK_Z)) {
			saute();
		}
		if(key.isKey(KeyEvent.VK_Q)) accelere(-vitesse, 0);
		if(key.isKey(KeyEvent.VK_D)) accelere(vitesse, 0);
		
		if(!collision()) {
			move();
		}
		
		
		
	}*/
	
	

}
