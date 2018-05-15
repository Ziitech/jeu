package controleur;

import java.awt.event.KeyEvent;
import java.util.List;
import java.util.Vector;

import modele.metier.Carte;
import modele.metier.entities.Entity;
import modele.metier.entities.mob.Bombe;
import modele.metier.entities.mob.Joueur;
import modele.metier.entities.mob.Particule;
import modele.technique.ConstantesTechnique;
import modele.technique.entities.EntityTechnique;
import modele.technique.input.KeyboardTechnique;
import modele.technique.input.MouseTechnique;
import vue.Vue;
import vue.sprite.Sprite;

public class Manager implements Runnable{
	
	//-----------SINGLETON-------------------------
	
	private static Manager instance = new Manager();

	private Manager() {
		affichage = new Thread(this);
		entities = new Vector<>();
		
		
		key = new KeyboardTechnique();
		mouse = new MouseTechnique();
		
		constantes = new ConstantesTechnique();
	}
	
	public static Manager getInstance() {
		return instance;
	}
	
	//--------------VUE-----------
	
	private Vue vue;
	
	public void setVue(Vue v) {
		System.out.println("Vue initialise");
		this.vue = v;
		vue.addKey(key);
		vue.addMouse(mouse, mouse);
		map = new Carte(vue.getFrameWidth(),vue.getFrameHeight());
	}
	//--------------AFFICHAGE----------
	
	/**
	 * affiche en boucle les elements du jeu (carte + entites)
	 */
	@Override
	public void run() {
		while(true) {
			List<EntityTechnique> removedEntities = new Vector<>();
			
			//clear l'ecran
			//vue.clear();	//inutile
			
			//render Map here ! 
			drawMap();
			
			//TEST :
			if(mouse.getMouse().buttonClicked(1)) addEntity(new Bombe(mouse.getMouse().getMouseX(), mouse.getMouse().getMouseY(), map));
			if(key.getKey().isKeyDown(KeyEvent.VK_G)) map.generate();
			if(key.getKey().isKeyDown(KeyEvent.VK_P)) pause = !pause;
			
			
			//AFFICHAGE
			for (EntityTechnique e : entities) {
				vue.drawEntity(e.getX(), e.getY(),choixSprite(e.getType()), e.getFlip());
				if(e.needRemove()) removedEntities.add(e);
			}
			//REMOVE
			for (EntityTechnique e : removedEntities) {
				entities.remove(e);
			}
			
			vue.drawCursor(mouse.getMouse().getMouseX(), mouse.getMouse().getMouseY());
			
			mouse.update();
			key.update();
			
			vue.render(); // affichage sur la fenetre
		}
	}
	
	//----------------JEU--------------
	private List<EntityTechnique> entities;
	private Carte map;
	
	/**
	 * 
	 */
	private Thread affichage;
	
	private boolean pause;
	
	private ConstantesTechnique constantes;
	private KeyboardTechnique key;
	private MouseTechnique mouse;
	
	public synchronized void startGame() {
		System.out.println("Starting new Game !");
		constantes.readFile("chemin du fichier !!!");
		addEntity(new Joueur(150,150,map,key.getKey()));
		addEntity(new Bombe(200,200, map));
		for(int i = 0 ; i < 10 ; i++) { // up to 10 ok
			addEntity(new Particule(750,500));
		}
		pause = false;
		
		
		affichage.start();
	}
	
	private void drawMap() {
		int w = map.getWidth();
		int h = map.getHeight();
		int size = map.getTileSize();
		
		for(int y = 0 ; y < h ; y++) {
			int yp = y * size;
			
			for(int x = 0 ; x < w ; x++) {
				int xp = x * size;
				
				vue.drawTiles(xp,yp,size,map.getTilesAt(x, y));
			}
		}
	}
	
	public void addEntity(Entity e) {
		entities.add(new EntityTechnique(e));
	}
	
	private Sprite choixSprite(int type) {
		Sprite retour = null;
		switch(type) {
		case 1 :
			retour = Sprite.player;
			break;
		case 3 :
			retour = Sprite.particule;
			break;
		case 4 :
			retour = Sprite.bombe;
			break;
		default :
			retour = Sprite.snake;
		}
		return retour;
		
	}

	public boolean isPause() {
		return pause;
	}

	
	

}
