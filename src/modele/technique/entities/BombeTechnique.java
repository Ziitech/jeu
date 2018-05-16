package modele.technique.entities;

import modele.metier.Carte;
import modele.metier.entities.mob.Bombe;

public class BombeTechnique extends EntityTechnique{
	
	
	
	public BombeTechnique(int x, int y, Carte map) {
		super(new Bombe(x, y, map));
	}

	@Override
	protected void update() {
		Bombe j = (Bombe) e;
		j.fall();
		
		if(j.collision()) {
			j.explose();
		}
		else {
			j.move();
		}
		
	}

}
