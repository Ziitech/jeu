package modele.technique.entities;

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
			
			if(c.attaquer()) {
				if(j.getVitesseX() > 0) Manager.getInstance().addTire(j.getX(), j.getY() , true);
				if(j.getVitesseX() < 0) Manager.getInstance().addTire(j.getX(), j.getY() , false);
			}
			if(c.sauter()) j.saute();
			if(c.deplacement_droit()) j.accelere(j.getVitesse(), 0);
			if(c.deplacement_gauche()) j.accelere(-j.getVitesse(), 0);
			
			checkCollisionEntite(Manager.getInstance().getEntities());
			
			if(!j.collision()) {
				j.fall();
				j.move();
			}
		}

	@Override
	protected void collisionEntite(EntityTechnique entityTechnique) {
		// TODO Auto-generated method stub
		
	}
}