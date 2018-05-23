package modele.metier.entities.mob;

import java.awt.Rectangle;

import modele.metier.Carte;
import modele.metier.Constantes;

/**
 * Classe joueur controlable par l'utilisateur
 * 
 * @author Nandaleio
 * 
 *
 */

public class Joueur extends Mob {

	private int vie;
	private float vitesse;
	

	public Joueur(int x, int y,Carte map) {
		super(x,y,map);
		
		type = 1;
		vie = 100;
		vitesse = Constantes.getConstantes().getVitesse();
		type = Constantes.getConstantes().getTypePerso();
		
		//hard coded :
		width = 30;
		height = 40;
	}
	
	public void controleTrajectoire() {
		vitesseX *= 0.5f;
		//vitesseY = 0f; // test
	}
	
	public int getVie() {
		return vie;
	}

	public void setVie(int vie) {
		this.vie = vie;
	}

	public float getVitesse() {
		return vitesse;
	}

	public void setVitesse(float vitesse) {
		this.vitesse = vitesse;
	}
	
	public Rectangle getBounds(){
		return new Rectangle(x, y, 40,40);
	}

	
}
	
