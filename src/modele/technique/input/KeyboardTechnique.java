package modele.technique.input;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import modele.metier.input.Keyboard;
/**
 * Clavier cote tachnique implements KeyListener pour compatibilité avec Swing
 * @author Nandaleio
 *
 */
public class KeyboardTechnique implements KeyListener {
	
	private Keyboard key;
	
	public KeyboardTechnique() {
		key = new Keyboard();
	}
	
	//Get des booleans
	
	public boolean isKeyPressed(int k) {
		return key.isKeyUp(k);
	}
	
	public boolean isKeyReleased(int k) {
		return key.isKeyDown(k);
	}
	
	public boolean isKey(int k) {
		return key.isKey(k);
	}
	
	
	// Controle des booleans
	
	public void keyPressed(KeyEvent arg0) {
		key.keyPressed(arg0.getKeyCode());
	}


	public void keyReleased(KeyEvent arg0) {
		key.keyReleased(arg0.getKeyCode());
	}
	
	
	
	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	
	public Keyboard getKey() {
		return key;
	}
	
	public void update() {
		key.update();
	}

}
