package modele.metier.entities.mob;

import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.Random;

import controleur.Manager;
import modele.metier.Carte;
import modele.technique.entities.EnemyTechnique;

public class Tire extends Mob {
	
	//private int cibleX;
	//private int cibleY;
	private int puissance;
	
	private float vitesse;
	
	
	public Tire(int x, int y, int cibleX, int cibleY, Carte map) {
		super(x, y, map);

		this.x = x;
		this.y = y;
		
		Random rand = new Random();
		
		vitesse = 10f;
		
		// petit puissance
		puissance = rand.nextInt(5)+5;
		
		int differenceX = cibleX - x;
		int differenceY = cibleY - y;
		
		float dirLength=(float) Math.sqrt(differenceX*differenceX + differenceY*differenceY);
		float dirX = differenceX/dirLength;
		float dirY = differenceY/dirLength;
		
		
		// donne la direction de la balle
		//vitesseX += cibleX * vitesse;
		vitesseX = dirX * vitesse;
		
		vitesseY = dirY * vitesse;//= cibleY * vitesse;
		
		type = 6;
	}
	
	public void explose() {
		map.explosion(x, y, puissance);
		remove();
	}
	
	
	public Rectangle getBounds(){
		System.out.println("TIRE//// dasn getBounds le x = "+x+"le y = "+y );
		return new Rectangle(x, y, 1540,1540);
	}

	public void checkCollisions() {
		System.out.println("dans checkCollisions");
		ArrayList<EnemyTechnique> enemies = Manager.getInstance().getEnemyList();
		for(int i=0; i< enemies.size(); i++ ){
			EnemyTechnique tempEnemy = enemies.get(i);
			System.out.println("dasn la bouble");
			if(getBounds().intersects(tempEnemy.getBounds())){
				Manager.getInstance().removeEnemy(tempEnemy);
			}
		}
		
	}
	
}
