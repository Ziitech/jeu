package modele.metier.entities.mob;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.Random;

import modele.metier.Carte;

public class Tire extends Mob {
	private int cibleX;
	private int cibleY;
	private int puissance;
	
	
	public Tire(int x, int y, Carte map) {
		super(x, y, map);

		this.x = x;
		this.y = y;
		
		Random rand = new Random();
		
		puissance = rand.nextInt(5)+20;
		
		vitesseX = 0; // tombe verticalement
		vitesseY = (rand.nextFloat()-0.5f) *5;
		
		type = 3;
	}
	
	public void explose() {
		map.explosion(x, y, puissance);
		remove();
	}
	
	
	
}
