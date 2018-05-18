package modele.technique.entities;

import modele.metier.Carte;
import modele.metier.entities.mob.Tire;

public class TireTechnique  extends EntityTechnique{
	
	public TireTechnique(int x, int y, Carte map) {
		super(new Tire(x, y, map));
	}

	@Override
	protected void update() {
		Tire j = (Tire) e;
		j.avance();
		
		if(j.collision()) {
			j.explose();
		}
		else {
			j.move();
		}
		
	}

}
