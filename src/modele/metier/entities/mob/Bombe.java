package modele.metier.entities.mob;

import java.util.Random;

public class Bombe extends Mob {

	public Bombe(int x, int y) {
		this.x = x;
		this.y = y;
		vitesseX = vitesseY = 0;
		accelerationX = accelerationY = 0;
		
	}

	@Override
	public void update() {
		Random rand = new Random();
		//vitesseX = rand.nextFloat()-0.5f;
		vitesseY = rand.nextFloat()-0.5f;
		accelerationX += vitesseX;
		accelerationY += vitesseY;
		x += accelerationX;
		y += accelerationY;
		
	}

}
