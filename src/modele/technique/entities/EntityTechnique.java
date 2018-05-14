package modele.technique.entities;

import java.util.List;
import java.util.Vector;

import modele.metier.entities.Entity;

/**
 * Entite Technique permet de rendre chaque entite independant 
 * @author Nandaleio
 *
 */
public class EntityTechnique implements Runnable{
	
	/**
	 * l'entite a faire vivre
	 */
	private Entity e;
	/**
	 * le moteur qui fais vivre l'entite
	 */
	private Thread thread;
	
	/**
	 * si il faut supprimer cette entite technique
	 */
	private boolean needRemove;

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
			//update
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
