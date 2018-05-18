package modele.technique.entities;

import java.awt.event.KeyEvent;

import modele.metier.Carte;
import modele.metier.Constantes;
import modele.metier.entities.mob.Joueur;
import modele.metier.input.Keyboard;
import modele.technique.input.KeyboardTechnique;

public class JoueurTechnique extends EntityTechnique {
	
	private Keyboard key;
	private float vitesse;
	
	public JoueurTechnique(int x, int y, Carte map, KeyboardTechnique k) {
		super(new Joueur(x,y,map));
		
		this.key = k.getKey();
		vitesse = Constantes.getConstantes().getVitesse();
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
		if(key.isKey(KeyEvent.VK_Q)) j.accelere(-vitesse, 0);
		if(key.isKey(KeyEvent.VK_D)) j.accelere(vitesse, 0);
		
		if(!j.collision()) {
			j.move();
		}
	}

}