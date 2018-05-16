package modele.metier.entities.mob;

import java.util.Random;

import modele.metier.Carte;


/**
 * elements qui explose des qu'il touche une tuile solid de la carte
 */

public class Bombe extends Mob {

	private int puissance;
	
	/**
	 *  
	 * @param x position en X
	 * @param y position en Y
	 * @param map carte sur laquelle doit etre situé la bombe
	 */
	public Bombe(int x, int y, Carte map) {
		super(x,y,map);
		this.x = x;
		this.y = y;
		
		Random rand = new Random();
		
		puissance = rand.nextInt(5)+20;
		
		vitesseX = 0; // tombe verticalement
		vitesseY = (rand.nextFloat()-0.5f) *5;
		
		type = 4;
		
	}

	public void explose() {
		map.explosion(x, y, puissance);
		remove();
	}
	
	/*@Override
	public void update() {
		if(x < 0 || x >= map.getWidth() * map.getTileSize()) remove();
		if(y < 0 || y >= map.getHeight() * map.getTileSize()) remove();
		
		vitesseY += 0.7f;
		
		if(map.getSolidTileAt(x, y)) {
			
			remove();
		}
		else {
			y += vitesseY;
			x += vitesseX;
		}
	}*/

}
