package modele.metier.entities.mob;

import java.awt.Rectangle;

import modele.metier.Carte;
import modele.metier.Constantes;
import modele.metier.entities.Entity;

public class Enemy extends Mob {

	public Enemy(int x, int y,Carte map) {
		super(x, y, map);
		type = 9;
		// TODO Auto-generated constructor stub
	}
	


	public void mort(){
		System.out.println("Mort");
		this.remove();
	}
	
	public Rectangle getBounds(){
		System.out.println("dasn getBounds le x = "+x+"le y = "+y );
		return new Rectangle(x, y, 1540,1540);
	}
	
	

}
