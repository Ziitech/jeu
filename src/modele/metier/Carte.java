package modele.metier;

import java.util.Random;

public class Carte {
	
	private int width, height;
	private int[] tiles;
	
	private int tileSize;
	
	private int backgroundColor;
	
	/**
	 * 
	 * @param w largeur de la fenetre
	 * @param h hauteur de la fenetre
	 */
	public Carte(int w, int h) {
		
		
		setTileSize(4); // 4 
		
		width = w/tileSize;
		height = h/tileSize;
		
		backgroundColor = 0xff00c1c1;
		
		tiles = new int[width*height];
		generate();
	}
	
	public void generateFlat() {
		
		for(int x = 0 ; x < width ; x++) {
			for(int y = 0 ; y < height ; y++) {
				
				if(y> height / 2) tiles[x+y*width] = 0xff99ff66;
				else tiles[x+y*width] = backgroundColor;
			
			}
		}
				
		
	}
	
	/**
	 * genere un terrain aleatoire
	 */
	public void generate() {
		Random rand = new Random();
		int decalageP = 0;
		int decalage = 0;
		for(int x = 0 ; x < width ; x++) {
			
			if(rand.nextBoolean())decalage++;
			else decalage--;
			
			if(rand.nextBoolean())decalageP++;
			else decalageP--;
			
			for(int y = 0 ; y < height ; y++) {
				
				//bordure
				if(y<3 || y>=height-3) tiles[x+y*width] = 0xffc1c1c1;
				else if(x<3 || x>=width-3) tiles[x+y*width] = 0xffc1c1c1;
				
				//niveau pierre
				else if(y >= height/2 + decalageP+25) tiles[x+y*width] = 0xff808080;
				
				//niveau sol
				else if(y >= height/2 + decalage) tiles[x+y*width] = 0xff99ff66;
				
				
				//ciel
				else tiles[x+y*width] = backgroundColor;
			}
		}
	}
	
	/**
	 * determine si une tuile est solid pour une entite selon un position 
	 * @param x position en X
	 * @param y position en Y
	 * @return si la tuile est solid ou pas
	 */
	public boolean getSolidTileAt(int x, int y) {
		
		x/=tileSize;
		y/=tileSize;
		
		if(x<0 || x>= width) return false;
		if(y<0 || y>= height) return false;
		
		boolean retour = false;
		if(tiles[x+y*width] != backgroundColor) retour = true;
		
		return retour;
	}
	
	/**
	 * retourne la tuile a une position donnée
	 * @param x position en X
	 * @param y position en Y
	 * @return la couleur de la tuile;
	 */
	public int getTilesAt(int x, int y) {
		if(x < 0 || x >= width) return 0xffff00ff;
		if(y < 0 || y >= height) return 0xffff00ff;
		
		return tiles[x+y*width];
	}
	
	/**
	 * detruit (ou pas) une partie du terrain 
	 * @param x position en X
	 * @param y position en Y
	 * @param p taille de l'explosion
	 */
	public void explosion(int x, int y, int p) {
		x/=tileSize;
		y/=tileSize;
		
		for(int j = -p/2 ; j < p/2 ; j++) {
			int yp = j+y;
			if(yp < 0 || yp >= height) continue;
			
			for(int i = -p/2 ; i < p/2 ; i++) {
				int xp = i+x;
				if(xp < 0 || xp >= width) continue;
				
				if(tiles[xp+yp*width] != 0xffc1c1c1) tiles[xp+yp*width] = backgroundColor;
				
			}
		}
	}
	
	public int[] getTiles() {
		return tiles;
	}
	
	public int getWidth() {
		return width;
	}
	
	public int getHeight() {
		return height;
	}

	public int getTileSize() {
		return tileSize;
	}

	/**
	 * initialise la taille des tuiles
	 * (ne peut pas etre inferieure a 1)
	 * @param tileSize taille a affecter
	 */
	public void setTileSize(int tileSize) {
		if(tileSize <= 0) tileSize = 1;
		this.tileSize = tileSize;
	}

}
