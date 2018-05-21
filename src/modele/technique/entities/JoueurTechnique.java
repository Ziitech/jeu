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
			j.saute();
			
			if(c.attaquer()) Manager.getInstance().addTire(j.getX(), j.getY());
			if(c.sauter()) j.saute();
			if(c.deplacement_droit()) j.accelere(j.getVitesse(), 0);
			if(c.deplacement_gauche()) j.accelere(-j.getVitesse(), 0);
			
			if(!j.collision()) {
				j.fall();
				j.move();
			}
		}
}