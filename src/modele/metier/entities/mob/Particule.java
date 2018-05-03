package modele.metier.entities.mob;

import java.util.Random;

import modele.metier.Carte;

public class Particule extends Mob {
	
	private int tempsVie;
	
	public Particule(int x, int y, Carte map) {
		super(map);
		
		Random rand = new Random();
		this.x = x;
		this.y = y;
		vitesseX = vitesseY = 0;
		
		tempsVie = 60*5 + rand.nextInt(30);
		
		type = 3;
	}

	@Override
	public void update() {
		Random rand = new Random();
		vitesseX += rand.nextFloat()-0.5f;
		vitesseY += rand.nextFloat()-0.5f;
		x += vitesseX*3;
		y += vitesseY*3;
		tempsVie--;
		if(tempsVie <= 0) remove();
	}

}
