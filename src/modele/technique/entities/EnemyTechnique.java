package modele.technique.entities;

import java.awt.Rectangle;

import modele.metier.Action;
import modele.metier.Carte;
import modele.metier.entities.mob.Enemy;
import modele.metier.entities.mob.Tire;

public class EnemyTechnique extends EntityTechnique{

	private Action c;
	Enemy j;
	public EnemyTechnique(int x, int y, Carte map, Action c) {
	
		super(new Enemy(x,y,map));

		this.c = c;
	}

	@Override
	protected void update() {

		this.j = (Enemy) e;
		if(j.isRemoved()){
			j.remove();
		}
		//j.getBounds();
	}

	@Override
	protected void collisionEntite(EntityTechnique entityTechnique) {
		// TODO Auto-generated method stub

	}

	public Rectangle getBounds() {
		return j.getBounds();
	}
	
	public void mort() {
		System.out.println("Dnas enemyTechniaue");
		j.mort();
	}


}
