package modele.metier.entities.mob;

import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.util.List;

import modele.metier.Carte;
import modele.metier.Constantes;
import modele.metier.input.Keyboard;

/**
 * Classe joueur controlable par l'utilisateur
 * 
 * @author Nandaleio
 * 
 *
 */

public class Joueur extends Mob {


	/**
	 * clavier qui controle le joueur
	 */
	private int vie;
	private float vitesse;
	
	public Joueur(int x, int y,Carte map) {
		super(x,y,map);
		
		type = 1;
		vie = 100;
		vitesse = Constantes.getConstantes().getVitesse();
	}


}
