package modele.metier.entities.mob;

import java.util.Random;

import modele.metier.Carte;

public class Projectile extends Mob {
	
	private int degat;

	public Projectile(int x, int y, int vx, int vy, Carte map) {
		super(x, y, map);
		vitesseX += vx;
		vitesseY += vy;
		
		Random rand = new Random();
		setDegat(10 + rand.nextInt(10)-5);
	}

	public int getDegat() {
		return degat;
	}

	public void setDegat(int degat) {
		this.degat = degat;
	}

}
