package modele.metier.entities.mob;

import java.util.Random;

/**
 * Entite mobile purement esthetique 
 * @author Nandaleio
 *
 */
public class Particule extends Mob {
	
	/**
	 * nombre de cycle avant qu'elle ne soit retire
	 */
	private int tempsVie;
	
	public Particule(int x, int y) {
		super(null);
		
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
