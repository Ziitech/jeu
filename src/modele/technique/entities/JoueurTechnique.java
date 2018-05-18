package modele.technique.entities;

import java.awt.event.KeyEvent;

import controleur.Manager;
import modele.metier.Action;
import modele.metier.Carte;
import modele.metier.entities.mob.Joueur;

public class JoueurTechnique extends EntityTechnique {
	
	private Action c;
	
	public JoueurTechnique(int x, int y, Carte map, Action c) {
		super(new Joueur(x,y,map));
		
		this.c = c;
	}
	
	@Override
		protected void update() {
			Joueur j = (Joueur) e;
			j.controleTrajectoire();
			//j.fall();
			
			//if(key.isKeyDown(KeyEvent.VK_SPACE)) //Manager.getInstance().addJoueur(60,60);
			
			if(c.sauter()) j.saute();
			if(c.deplacement_droit()) j.accelere(j.getVitesse(), 0);
			if(c.deplacement_gauche()) j.accelere(-j.getVitesse(), 0);
			
			if(!j.collision()) {
				j.move();
			}
		}

}