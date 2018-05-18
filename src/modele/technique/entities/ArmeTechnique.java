package modele.technique.entities;

import java.awt.event.KeyEvent;
import java.awt.event.MouseMotionListener;

import controleur.Manager;
import modele.metier.Carte;
import modele.metier.Constantes;
import modele.metier.entities.mob.Bombe;
import modele.metier.entities.mob.Joueur;
import modele.metier.entities.mob.Mob;
import modele.metier.entities.mob.Pistolet;
import modele.metier.input.Keyboard;
import modele.technique.input.KeyboardTechnique;

public class ArmeTechnique extends EntityTechnique {
	
	private Keyboard key;
	private float vitesse;
	
	public ArmeTechnique(int x, int y, Carte map, KeyboardTechnique k) {
		super(new Pistolet(x,y,map));
		
		this.key = k.getKey();
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
