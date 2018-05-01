package modele.technique.entities;

import modele.metier.entities.Entity;

public class EntityTechnique implements Runnable{
	
	private Entity e;
	private Thread thread;

	public EntityTechnique(Entity e) {
		this.e = e;
		thread = new Thread(this);
		thread.start();
	}
	
	public String getEntityClassName() {
		return e.getClass().getSimpleName();
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


}
