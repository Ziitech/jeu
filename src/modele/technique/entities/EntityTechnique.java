package modele.technique.entities;

import controleur.Manager;
import modele.metier.entities.Entity;

/**
 * Entite Technique permet de rendre chaque entite independant 
 * @author Nandaleio
 *
 */
public abstract class EntityTechnique implements Runnable{
	
	/**
	 * l'entite a faire vivre
	 */
	protected Entity e;
	/**
	 * le moteur qui fais vivre l'entite
	 */
	protected Thread thread;
	
	/**
	 * si il faut supprimer cette entite technique
	 */
	protected boolean needRemove;

	/**
	 * demarre la vie d'une entite
	 * @param e l'entite a faire vivre
	 */
	public EntityTechnique(Entity e) {
		this.e = e;
		this.needRemove = false;
		thread = new Thread(this);
		thread.start();
	}

	@Override
	public void run() {
		while(!e.isRemoved()) {
			try {
				Thread.sleep(17); // Pour les 60 update/sec
			} catch (InterruptedException e1) {
				e1.printStackTrace();
			}
			
			if(Manager.getInstance().isPause()) continue;
			
			//update
			update();
		}
		try {
			needRemove = true;
			thread.join();
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}
	}
	
	protected abstract void update();
	
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
