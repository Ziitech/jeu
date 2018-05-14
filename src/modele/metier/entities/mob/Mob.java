package modele.metier.entities.mob;

import modele.metier.Carte;
import modele.metier.entities.Entity;

/**
 * 
 * @author Nandaleio
 * 
 * Entity mobile
 *
 */
public abstract class Mob extends Entity {
	
	/**
	 * Carte qui permet d'interagire avec le terrain (Collision / Explosion)
	 */
	protected Carte map;
	
	/**
	 * Vitesse sur l'axe X
	 */
	protected float vitesseX;
	
	/**
	 * Vitesse sur l'axe Y
	 */
	protected float vitesseY;

	/**
	 * 
	 * @param map carte sur laquelle est l'Entite mobile
	 */
	public Mob(Carte map) {
		this.map = map;
	}
	
	
	/**
	 * verifie si l'entite est bien sur la carte
	 */
	public void checkInBound() {
		if(x < 0 || x > (map.getWidth()*map.getTileSize()))  {
			remove();
		}
		if(y < 0 || y > (map.getHeight()*map.getTileSize())) {
			remove();
		}
	}
	
	/**
	 * fait tomber l'entite
	 */
	protected void fall() {
		vitesseY += 0.5f;
	}
	
	/**
	 * fais accelerer l'entite dans une direction donné
	 * @param ax acceleration sur l'axe X
	 * @param ay acceleration sur l'axe Y
	 */
	protected void accelere(float ax, float ay) {
		this.vitesseX += ax;
		this.vitesseY += ay;
	}

	/**
	 * applique la vitesse de l'entite sur sa position
	 */
	protected void move() {
		if(vitesseX > 0) flip = false;
		if(vitesseX < 0) flip = true;
		this.x += vitesseX;
		this.y += vitesseY;
	}
	
	protected boolean collision() {
		return map.getSolidTileAt((int)(x+vitesseX),(int) (y+vitesseY));
	}
	
}
