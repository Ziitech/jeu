package modele.technique.entities;

import modele.metier.Carte;
import modele.metier.entities.mob.Pistolet;

public class ArmeTechnique extends EntityTechnique {
	
	
	public ArmeTechnique(int x, int y, Carte map) {
		super(new Pistolet(x,y,map));
	}
	
	@Override
	protected void update() {
		//Mob j = (Mob) e;
		Pistolet j = (Pistolet) e;
		//j.fall();
		
		if(j.recupererArme()) {
			j.isRecuperer();
		}
		else {
			j.move();
		}
//		if(j.collision()) {
//			j.move();
//		}
		
	}

	@Override
	protected void collisionEntite(EntityTechnique entityTechnique) {
		// TODO Auto-generated method stub
		
	}
	

}
