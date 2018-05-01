package modele.metier.entities;

public abstract class Entity {

	private boolean removed;
	protected int x, y;
	
	public Entity() {
		removed = false;
	}
	
	public void remove() {
		removed = true;
	}

	public boolean isRemoved() {
		return removed;
	}
	
	public abstract void update();
	
	public int getX() { return x;}
	public int getY() { return y;}
	

}
