package modele.technique.entities;

import modele.metier.entities.Entity;

public class EntityTechnique implements Runnable{
	
	private Entity e;
	private Thread thread;
	
	private boolean needRemove;

	public EntityTechnique(Entity e) {
		this.e = e;
		this.needRemove = false;
		thread = new Thread(this);
		thread.start();
	}

	@Override
	public void run() {
		while(!e.isRemoved()) {
				e.update();
				try {
					Thread.sleep(17); // Pour les 60 update/sec
				} catch (InterruptedException e1) {
					e1.printStackTrace();
				}
		}
		try {
			needRemove = true;
			thread.join();
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}
	}
	
	public int getX() {
		return e.getX();
	}
	
	public int getY() {
		return e.getY();
	}
	
	public boolean getFlip() {
		return e.getFlip();
	}
	
	public boolean needRemove() {
		return needRemove;
	}

	public int getType() {
		return e.getType();
	}


}
