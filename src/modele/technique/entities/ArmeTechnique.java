package modele.technique.entities;

import modele.metier.Carte;
import modele.metier.Constantes;
import modele.metier.entities.mob.Pistolet;

public class ArmeTechnique extends EntityTechnique {
	
	private float vitesse;
	
	public ArmeTechnique(int x, int y, Carte map) {
		super(new Pistolet(x,y,map));
		
		vitesse = Constantes.getConstantes().getVitesse();
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
	

}
