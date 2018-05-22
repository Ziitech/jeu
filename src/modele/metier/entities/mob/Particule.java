package modele.metier.entities.mob;


/**
 * Entite mobile purement esthetique 
 * @author Nandaleio
 *
 */
public class Particule extends Mob {
	
	/**
	 * nombre de cycle avant qu'elle ne soit retire
	 */
	//private int tempsVie;
	
	public Particule(int x, int y) {
		super(x,y,null);
		
		//Random rand = new Random();
		this.x = x;
		this.y = y;
		vitesseX = vitesseY = 0;
		
		//tempsVie = 60*5 + rand.nextInt(30);
		
		type = 3;
	}

}
