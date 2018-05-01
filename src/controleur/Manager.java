package controleur;

import java.util.List;
import java.util.Vector;

import modele.metier.entities.mob.Bombe;
import modele.technique.entities.EntityTechnique;
import vue.Vue;

public class Manager implements Runnable{
	
	//-----------SINGLETON-------------------------
	
	private static Manager instance = new Manager();

	private Manager() {
		affichage = new Thread(this);
		entities = new Vector<>();
	}
	
	public static Manager getInstance() {
		return instance;
	}
	
	//--------------VUE-----------
	
	private Vue vue;
	
	public void setVue(Vue v) {
		this.vue = v;
	}
	//--------------AFFICHAGE----------
	@Override
	public void run() {
		while(true) {
			//clear l'ecran
			vue.clear();
			
			//render Map here ! 
			
			
			for (EntityTechnique e : entities) {
				drawEntity(e.getX(), e.getY(), e.hashCode());
			}
			
			vue.render(); // affichage sur la fenetre
		}
	}
	
	//----------------JEU--------------
	private List<EntityTechnique> entities;
	private Thread affichage;
	
	public synchronized void startGame() {
		entities.add(new EntityTechnique(new Bombe(150,150)));
		entities.add(new EntityTechnique(new Bombe(200,120)));
		affichage.start();
	}
	

	public void drawEntity(int x, int y, int s) {
		vue.drawEntity(x,y,s);
		
	}

	

	
	

}
