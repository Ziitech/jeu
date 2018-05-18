package modele.metier.entities.mob;

import modele.metier.Carte;

public class Pistolet extends Mob {
	
	private int puissance;

	public Pistolet(int x, int y,Carte map) {
		super(x,y,map);
		this.type = 22;
		this.puissance = 100;
	}

	public int getPuissance() {
		return puissance;
	}

	public void setPuissance(int puissance) {
		this.puissance = puissance;
	}
	
	public void isRecuperer() {
		//map.explosion(x, y, puissance);
		remove();
	}
	
//	public boolean getSolidTileAt(int x, int y) {
//		
//		if(x<0 || x>= width) return false;
//		if(y<0 || y>= height) return false;
//		
//		boolean retour = false;
//		if(tiles[x+y*width] != backgroundColor) retour = true;
//		
//		return retour;
//	}
	
	public int positionX() {
		return x;
	}
	
	public int positionY() {
		return y;
	}
	
	public static void verif(){}
	

}
