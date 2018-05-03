package modele.metier;

import java.util.Random;

public class Carte {
	
	private int width, height;
	private int[] tiles;
	
	private int tileSize;
	
	private int backgroundColor;
	
	public Carte(int w, int h) {
		
		
		setTileSize(8);
		
		width = w/tileSize;
		height = h/tileSize;
		
		backgroundColor = 0xff00c1c1;
		
		tiles = new int[width*height];
		generate();
	}
	
	public void generate() {
		Random rand = new Random();
		int decalage = 0;
		for(int x = 0 ; x < width ; x++) {
			
			if(rand.nextBoolean())decalage++;
			else decalage--;
			for(int y = 0 ; y < height ; y++) {
				
				if(y<3 || y>=height-3) tiles[x+y*width] = 0xffc1c1c1;
				else if(x<3 || x>=width-3) tiles[x+y*width] = 0xffc1c1c1;
				else if(y >= height/2 + decalage) tiles[x+y*width] = 0xff99ff66;
				else tiles[x+y*width] = backgroundColor;
			}
		}
	}
	
	public boolean getSolidTileAt(int x, int y) {
		x/=tileSize;
		y/=tileSize;
		
		if(x<0 || x>= width) return false;
		if(y<0 || y>= height) return false;
		
		boolean retour = false;
		if(tiles[x+y*width] != backgroundColor) retour = true;
		
		return retour;
	}
	
	public int getTilesAt(int x, int y) {
		if(x < 0 || x >= width) return 0xffff00ff;
		if(y < 0 || y >= height) return 0xffff00ff;
		
		return tiles[x+y*width];
	}
	
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

	public void setTileSize(int tileSize) {
		this.tileSize = tileSize;
	}

}
