package modele.technique.entities;

import java.util.ArrayList;

import controleur.Manager;
import modele.metier.Carte;
import modele.metier.entities.mob.Tire;

public class TireTechnique  extends EntityTechnique{
	

	private EntityTechnique tireur;
	
	public TireTechnique(int x, int y, int cx, int cy, Carte map, EntityTechnique t) {
		super(new Tire(x, y, cx, cy, map));
		tireur = t;
	}

	@Override
	protected void update() {
		Tire j = (Tire) e;
		
		j.move();
		checkCollisions();
		if(j.collision()) {
			
			j.explose();
		}
		
	}
	
	public void checkCollisions() {
		ArrayList<EntityTechnique> enemies = Manager.getInstance().getEnemyList();
		enemies.remove(this);
		enemies.remove(tireur);
		for(int i=0; i< enemies.size(); i++ ){
			EntityTechnique tempEnemy = enemies.get(i);
			if(this.getBounds().intersects(tempEnemy.getBounds())){
				Manager.getInstance().removeEntity(tempEnemy);
				e.remove();
			}
		}
		
	}

	@Override
	protected void collisionEntite(EntityTechnique entityTechnique) {
		entityTechnique.die();
	}

}