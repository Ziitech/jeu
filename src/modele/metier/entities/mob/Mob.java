package modele.metier.entities.mob;

import modele.metier.entities.Entity;

public abstract class Mob extends Entity {
	
	protected float vitesseX;
	protected float vitesseY;
	
	protected float accelerationX;
	protected float accelerationY;

	public Mob() {
	}

	@Override
	public abstract void update();

}
