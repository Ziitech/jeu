package modele.metier.entities.mob;

import java.util.Random;

import modele.metier.Carte;


/**
 * elements qui explose des qu'il touche une tuile solid de la carte
 */

public class Bombe extends Mob {

	/**
	 *  
	 * @param x position en X
	 * @param y position en Y
	 * @param map carte sur laquelle doit etre situé la bombe
	 */
	public Bombe(int x, int y, Carte map) {
		super(map);
		this.x = x;
		this.y = y;
		
		Random rand = new Random();
		
		vitesseX = 0; // tombe verticalement
		vitesseY = (rand.nextFloat()-0.5f) *5;
		
		type = 4;
		
	}

	@Override
	public void update() {
		if(x < 0 || x >= map.getWidth() * map.getTileSize()) remove();
		if(y < 0 || y >= map.getHeight() * map.getTileSize()) remove();
		
		vitesseY += 0.7f;
		
		if(map.getSolidTileAt(x, y)) {
			map.explosion(x, y, 25);
			remove();
		}
		else {
			y += vitesseY;
			x += vitesseX;
		}
	}

}
