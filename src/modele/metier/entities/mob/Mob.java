package modele.metier.entities.mob;

import modele.metier.Carte;
import modele.metier.entities.Entity;

public abstract class Mob extends Entity {
	
	protected Carte map;
	
	protected float vitesseX;
	protected float vitesseY;

	public Mob(Carte map) {
		this.map = map;
	}

	@Override
	public abstract void update();

}
