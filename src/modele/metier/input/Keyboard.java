package modele.metier.input;

public class Keyboard  {

	private boolean[] keys = new boolean[256];
	private boolean[] lastKeys = new boolean[256];
	
	public boolean isKey(int key) {
		return keys[key];
	}
	
	public void update() {
		for(int i = 0 ; i < keys.length ; i++) {
			lastKeys[i] = keys[i];
		}
	}
	
	public void keyPressed(int e) {
		keys[e] = true;
	}
	
	public void keyReleased(int e) {
		keys[e] = false;
	}
	
	public boolean isKeyUp(int key) {
		return !keys[key] && lastKeys[key];
	}
	
	public boolean isKeyDown(int key) {
		return keys[key] && !lastKeys[key];
	}

}
