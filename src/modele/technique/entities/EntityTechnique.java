package modele.technique.entities;

import java.util.List;
import java.util.Vector;

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
	
	protected void checkCollisionEntite(List<EntityTechnique> ent) {
		
		List<EntityTechnique> nouvEnt =  new Vector(ent);
		nouvEnt.remove(this);
		
		int[] posX = new int[nouvEnt.size()];
		int[] posY = new int[nouvEnt.size()];
		
		for(int i = 0 ; i < nouvEnt.size() ; i++) {
			posX[i] = nouvEnt.get(i).getX();
			posY[i] = nouvEnt.get(i).getY();
		}
		
		if(posY.length != posX.length) return;
		
		for(int i = 0 ; i < posY.length ; i++) {
			if(e.getX() == posX[i] && e.getY() == posY[i]) {
				collisionEntite(nouvEnt.get(i));
			}
		}
		
	}
	
	protected abstract void collisionEntite(EntityTechnique entityTechnique);
	
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

	public void die() {
		e.remove();
	}


}
