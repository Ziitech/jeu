package modele.metier.entities.mob;

import java.awt.Rectangle;

import modele.metier.Carte;

public class Enemy extends Mob {

	public Enemy(int x, int y,Carte map) {
		super(x, y, map);
		type = 9;
		
		width = 20;
		height = 20;
	}
	
	

}
