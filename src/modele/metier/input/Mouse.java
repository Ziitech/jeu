package modele.metier.input;

public class Mouse {
	
	private int mouseX;
	private int mouseY;
	
	private boolean[] boutons = new boolean[4];
	private boolean[] oldBoutons = new boolean[4];
	
	public void update() {
		for(int i = 0 ; i < boutons.length ; i++) {
			oldBoutons[i] = boutons[i];
		}
	}
	
	public void bouttonPressed(int b) {
		boutons[b] = true;
	}
	
	public void bouttonReleased(int b) {
		boutons[b] = false;
	}
	
	public boolean buttonClicked(int button) {
		return boutons[button] && !oldBoutons[button];
	}
	
	public boolean buttonRelease(int button) {
		return !boutons[button] && oldBoutons[button];
	}
	
	public boolean getBouton(int button) {
		return boutons[button];
	}

	public int getMouseX() {
		return mouseX;
	}

	public void setMouseX(int mouseX) {
		this.mouseX = mouseX;
	}

	public int getMouseY() {
		return mouseY;
	}

	public void setMouseY(int mouseY) {
		this.mouseY = mouseY;
	}
	
	

}
