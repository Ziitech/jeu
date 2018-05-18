package modele.technique.entities;

import java.awt.event.KeyEvent;
import modele.metier.Action;
import modele.metier.Carte;
import modele.metier.entities.mob.Joueur;
import modele.metier.input.Keyboard;
import modele.technique.input.KeyboardTechnique;

public class JoueurTechnique extends EntityTechnique {
	
	private Keyboard key;
	private Action action;
	
	public JoueurTechnique(int x, int y, Carte map, KeyboardTechnique k) {
		super(new Joueur(x,y,map));
		
		this.key = k.getKey();
	}
	
	@Override
	protected void update() {
		Joueur j = (Joueur) e;
		j.controleTrajectoire();
		j.fall();
		
		//if(key.isKeyDown(KeyEvent.VK_SPACE)) //Manager.getInstance().addJoueur(60,60);
		
		if(key.isKey(KeyEvent.VK_Z)) {
			j.saute();
		}
		if(key.isKey(KeyEvent.VK_Q)) j.accelere(-j.getVitesse(), 0);
		if(key.isKey(KeyEvent.VK_D)) j.accelere(j.getVitesse(), 0);
		
		for(float i = 0 ; i < Math.abs(j.getVitesseX()) ; i++) {
			if(j.collision(i, 0)) {
				j.moveX(i);
				break;
			}
		}
		for(int i = 0 ; i < Math.abs(j.getVitesseY()) ; i++) {
			if(j.collision(0, i)) {
				j.moveY(i);
				break;
			}
		}
		
		/*if(!j.collision()) {
			j.move();
		}*/
	}

}