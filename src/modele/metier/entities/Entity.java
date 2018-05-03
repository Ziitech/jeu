package modele.metier.entities;

public abstract class Entity {

	private boolean removed;
	protected int x, y;
	protected boolean flip;
	
	protected int type;
	
	public Entity() {
		flip = false;
		removed = false;
		
		type = -1; //undefined
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
	
	public boolean getFlip() {
		return flip;
	}

	public int getType() {
		return type;
	}
	

}
