package modele.technique.entities;

import modele.metier.Carte;
import modele.metier.entities.mob.Tire;

public class TireTechnique  extends EntityTechnique{
	
	public TireTechnique(int x, int y, int cx, int cy, Carte map) {
		super(new Tire(x, y, cx, cy, map));
	}

	@Override
	protected void update() {
		Tire j = (Tire) e;
		
		j.move();
		
		if(j.collision()) {
			j.explose();
		}
		
	}

}