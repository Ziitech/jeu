package controleur;

import java.awt.event.KeyEvent;
import java.util.List;
import java.util.Random;
import java.util.Vector;

import modele.metier.Carte;
import modele.metier.entities.mob.Arme;
import modele.technique.ConstantesTechnique;
import modele.technique.entities.ArmeTechnique;
import modele.technique.entities.BombeTechnique;
import modele.technique.entities.EntityTechnique;
import modele.technique.entities.JoueurTechnique;
import modele.technique.entities.TireTechnique;
import modele.technique.input.Serveur;
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
		
		serv = new Serveur(6000);
		serv.go();
		
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
			vue.clear();	//inutile ?
			
			//render Map here ! 
			drawMap();
			
			//TEST :
			//if(mouse.getMouse().buttonClicked(1)) addBombe(mouse.getX(), mouse.getY());
			//if(key.getKey().isKeyDown(KeyEvent.VK_G)) map.generate();
			//if(key.getKey().isKeyDown(KeyEvent.VK_P)) pause = !pause;
			
			//AFFICHAGE
			for (EntityTechnique e : entities) {
				vue.drawEntity(e.getX(), e.getY(),choixSprite(e.getType()), e.getFlip());
				if(e.needRemove()) removedEntities.add(e);
			}
			//REMOVE
			for (EntityTechnique e : removedEntities) {
				entities.remove(e);
			}
			
			//vue.drawCursor(mouse.getMouse().getMouseX(), mouse.getMouse().getMouseY());
			
			
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
	private Serveur serv;
	
	public synchronized void startGame() {
		System.out.println("Starting new Game !");
		constantes.readFile("src/prop.properties");
		
		addJoueur(100, 100);
		
		Random rand = new Random();
		//for(int i=0; i < 10;i++){
		//	addArme(rand.nextInt(vue.getFrameWidth()), 20);
		//}
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
	
	public void addJoueur(int x, int y) {
		entities.add(new JoueurTechnique(x, y, map, key));
		entities.add(new JoueurTechnique(x+350, y+10, map, serv.getManette()));
	}
	
	public void addArme(int x, int y) {
		entities.add(new ArmeTechnique(x, y, map));
	}
	
	public void addBombe(int x, int y) {
		entities.add(new BombeTechnique(x, y, map));
	}
	
	public void addTire(int x, int y) {
		entities.add(new TireTechnique(x, y, mouse.getX(), mouse.getY(), map));
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
		case 5:
			retour = Sprite.balle;
			break;
		default :
			retour = Sprite.snake;
		}
		return retour;
		
	}

	public boolean isPause() {
		return pause;
	}
	
	List<Arme> arme;
	

}