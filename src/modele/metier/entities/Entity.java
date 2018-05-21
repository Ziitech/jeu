package modele.metier.entities;

/**
 * 
 * @author Nandaleio
 * 
 * Classe de base pour tous les objets affichables sur la fenetre
 * POO pas d'ECS
 *
 */

public abstract class Entity {

	/**
	 * indique si l'entite doit etre retirer
	 */
	private boolean removed;
	/**
	 * potition sur l'axe X
	 */
	protected int x;
	/**
	 * position sur l'axe Y
	 */
	protected int y;
	
	/**
	 * si l'entite et tourner vers la droite ou la gauche
	 */
	protected boolean flip;
	
	/**
	 * le type de sprite a afficher
	 */
	protected int type;
	
	/**
	 * initialise flip et removed a false
	 * et type a -1 (UNDEFINED)
	 */
	public Entity(int x, int y) {
		this.x = x;
		this.y = y;
		flip = false;
		removed = false;
		
		type = -1; //undefined
	}
	
	/**
	 * retirer l'entite 
	 */
	public void remove() {
		removed = true;
	}

	/**
	 * 
	 * @return si l'entite doit etre supprimer ou non
	 */
	public boolean isRemoved() {
		return removed;
	}
	
	public int getX() { return x;}
	public int getY() { return y;}
	
	public boolean getFlip() {
		return flip;
	}

	public int getType() {
		return type;
	}
	

}
