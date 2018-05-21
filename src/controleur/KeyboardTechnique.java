package controleur;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import modele.metier.Action;
/**
 * Clavier cote tachnique implements KeyListener pour compatibilité avec Swing
 * @author Nandaleio
 *
 */
public class KeyboardTechnique implements KeyListener, Action {
	
	private boolean saute;
	private boolean deplacmentDroite;
	private boolean deplacmentGauche;
	private boolean tire;
	private boolean pause;
	
	public KeyboardTechnique() {
	}
	
	@Override
	public boolean deplacement_droit() {
		return deplacmentDroite;
	}

	@Override
	public boolean deplacement_gauche() {
		return deplacmentGauche;
	}

	@Override
	public boolean sauter() {
		return saute;
	}

	@Override
	public boolean attaquer() {
		return tire;
	}

	@Override
	public boolean action() {
		return false;
	}

	@Override
	public boolean pause() {
		return pause;
	}

	@Override
	public void keyPressed(KeyEvent arg0) {
		//reset();
		switch(arg0.getKeyCode()) {
		case KeyEvent.VK_Z :
			saute = true;
			break;
		case KeyEvent.VK_D :
			deplacmentDroite = true;
			break;
		case KeyEvent.VK_Q :
			deplacmentGauche = true;
			break;
		case KeyEvent.VK_P :
			pause = true;
			break;
		case KeyEvent.VK_SPACE :
			tire = true;
			break;
		}
		
	}

	/*private void reset() {
		pause = tire = deplacmentDroite = deplacmentGauche = saute = false;
	}*/

	@Override
	public void keyReleased(KeyEvent arg0) {
		switch(arg0.getKeyCode()) {
		case KeyEvent.VK_Z :
			saute = false;
			break;
		case KeyEvent.VK_D :
			deplacmentDroite = false;
			break;
		case KeyEvent.VK_Q :
			deplacmentGauche = false;
			break;
		case KeyEvent.VK_P :
			pause = false;
			break;
		case KeyEvent.VK_SPACE :
			tire = false;
			break;
		}
		
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}
