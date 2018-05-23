package controleur;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Vector;
import modele.metier.Carte;
import modele.technique.ConstantesTechnique;
import modele.technique.entities.ArmeTechnique;
import modele.technique.entities.BombeTechnique;
import modele.technique.entities.EnemyTechnique;
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
		ajouts = new Vector<>();
		key = new KeyboardTechnique();
		mouse = new MouseTechnique();
		
		constantes = new ConstantesTechnique();
		
		serv = new Serveur(6000);
		serv.go();
		
		
		color = 0.0f;
		
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
			vue.clear(Color.HSBtoRGB(color, 1.0f, 1.0f));
			color += 0.0001f;
			//render Map here ! 
			drawMap();
			
			//TEST :
			if(key.pause()) pause = !pause;
			
			//AFFICHAGE
			for (EntityTechnique e : entities) {
				vue.drawEntity(e.getX(), e.getY(),choixSprite(e.getType()), e.getFlip());
				if(e.needRemove()) removedEntities.add(e);
			}
			
			//REMOVE Entity
			for (EntityTechnique e : removedEntities) {
				entities.remove(e);
			}
			removedEntities.clear();
			
			//adding entity
			for (EntityTechnique e : ajouts) {
				entities.add(e);
			}
			ajouts.clear();
			
			//vue.drawCursor(mouse.getMouse().getMouseX(), mouse.getMouse().getMouseY());
			
			
			vue.render(); // affichage sur la fenetre
		}
	}
	
	//----------------JEU--------------
	private List<EntityTechnique> entities;
	private List<EntityTechnique> ajouts;
	private float color;
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
		
		addJoueurs(vue.getFrameWidth());
		int enemyCount = 5;
		Random rand = new Random();
		for(int i=0; i < enemyCount;i++){
			addEnemy(rand.nextInt(vue.getFrameWidth()), rand.nextInt(vue.getFrameHeight()));
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
	
	public void addJoueurs(int x) {
		int x1 = (int) ((x/2) - (x/2.5f)) ;
		int x2 = (int) ((x/2) + (x/2.5f)) ;
		
		int y = 60;
		
		ajouts.add(new JoueurTechnique(x1, y, map, key));
		ajouts.add(new JoueurTechnique(x2, y, map, serv.getManette()));
		//addEnemy(x2,y);
		
		
	}
	
	public void addArme(int x, int y) {
		ajouts.add(new ArmeTechnique(x, y, map));
	}
	
	public void addEnemy(int x, int y) {
	
//		for(int i=0; i<(Math.random()*5000);i++)
		ajouts.add(new EnemyTechnique(x, 430, map, serv.getManette()));
	}
	
	
	
	public void addBombe(int x, int y) {
		ajouts.add(new BombeTechnique(x, y, map));
	}
	
	public void addTire(int x, int y, boolean d , EntityTechnique e) {
		if(d) ajouts.add(new TireTechnique(x, y, x+1, y, map, e));
		else ajouts.add(new TireTechnique(x, y, x-1, y, map , e));
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
		case 6 :
			retour = Sprite.fleche;
			break;
		default :
			retour = Sprite.snake;
		}
		return retour;
		
	}

	public boolean isPause() {
		return pause;
	}
	
	//List<Arme> arme;


	public void pause() {
		pause = !pause;
	}

	public int[] getPosX() {
		int[] retour = new int[entities.size()];
		
		for (int i : retour) {
			retour[i] = entities.get(i).getX();
		}
		
		return retour;
	}
	
	public int[] getPosY() {
		int[] retour = new int[entities.size()];
		
		for (int i : retour) {
			retour[i] = entities.get(i).getY();
		}
		
		return retour;
	}

	public List<EntityTechnique> getEntities() {
		return entities;
	}
	
	public void removeEntity(EntityTechnique e) {
		System.out.println("removing = " + e);
		e.die();
	}

	public ArrayList<EntityTechnique> getEnemyList() {
		ArrayList<EntityTechnique> retour = new ArrayList<EntityTechnique>(entities);
		return retour;
	}
	
	
	//----------------- ENEMY --------------
	

}