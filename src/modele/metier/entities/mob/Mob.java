
package modele.metier.entities.mob;

import modele.metier.Carte;
import modele.metier.Constantes;
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
	
	private float puissanceSaut;
	
	protected boolean saute;
	
	private float gravite;
	

	protected int width;
	protected int height;

	/**
	 * 
	 * @param map carte sur laquelle est l'Entite mobile
	 */
	public Mob(int x, int y, Carte map) {
		super(x,y);
		vitesseX = vitesseY = 0;
		this.map = map;
		gravite = Constantes.getConstantes().getGravite();
		puissanceSaut = Constantes.getConstantes().getSaut();
		
		//hard coded :
		width = 40;
		height = 40;
	}
	
	
	/**
	 * verifie si l'entite est bien sur la carte
	 */
	public void checkInBound() {
		
		if(y < 0 || y > (map.getHeight()*map.getTileSize())) {
			remove();
			return;
		}
		if(x < 0 || x > (map.getWidth()*map.getTileSize()))  {
			remove();
		}
		
	}
	
	/**
	 * fait tomber l'entite
	 */
	public void fall() {
		//vitesseX *= 0.5;
		vitesseY += gravite;
	}
	
	/**
	 * fais accelerer l'entite dans une direction donné
	 * @param ax acceleration sur l'axe X
	 * @param ay acceleration sur l'axe Y
	 */
	public void accelere(float ax, float ay) {
		this.vitesseX += ax;
		this.vitesseY += ay;
	}

	/**
	 * applique la vitesse de l'entite sur sa position
	 */
	public void move() {
		checkInBound();
		if(vitesseX > 0) flip = false;
		if(vitesseX < 0) flip = true;
		this.x += vitesseX;
		this.y += vitesseY;
	}
	
	public void moveX(float accX) {
		this.x += accX;
	}
	
	public void moveY(float accY) {
		this.y += accY;
	}
	
	public void saute() {
		if(!saute) vitesseY -= puissanceSaut;
		saute = true;
	}
	
	public boolean recupererArme() {
		boolean recupArme = false;
		if((int)(x+vitesseX) >= 400){
			recupArme = true;
		}
		return recupArme;
	}

	/**
	 * test
	 * @param ax
	 * @param ay
	 * @return
	 */
	public boolean collision(float ax, float ay) {
		boolean retour = map.getSolidTileAt((int)(x+ax),(int) (y+ay));
		if(retour) saute = false;
		return retour;
	}
	
	public boolean collision() {
		boolean retour = map.getSolidTileAt((int)(x+vitesseX),(int) (y+vitesseY));
		if(retour) saute = false;
		return retour;
	}
	
	public float getVitesseX() {
		return vitesseX;
	}
	
	public float getVitesseY() {
		return vitesseY;
	}
}
	