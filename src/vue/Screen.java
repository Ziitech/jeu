package vue;

import vue.sprite.Sprite;

public class Screen {

	private int width, height;
	private int[] pixels;
	
	
	public Screen (int width, int height) {
		this.setWidth(width);
		this.setHeight(height);
		pixels = new int[width*height];
		
	}
	
	public void clear() {
		for(int i = 0 ; i < pixels.length ; i++) {
			pixels[i] = 0xff000000;
		}
	}
	
	public int[] getPixel(){
		return pixels;
	}
	
	//int rgb = red;
	//rgb = (rgb << 8) + green;
	//rgb = (rgb << 8) + blue;
	public void drawPixel(int x, int y, int color) {
		if(x < 0 || x >= getWidth()) return;
		if(y < 0 || y >= getHeight()) return;
		
		pixels[x+y*getWidth()] = color;
		
	}
	
	public void drawLine(int x,int y,int x2, int y2, int color) {
	    int w = x2 - x ;
	    int h = y2 - y ;
	    int dx1 = 0, dy1 = 0, dx2 = 0, dy2 = 0 ;
	    if (w<0) dx1 = -1 ; else if (w>0) dx1 = 1 ;
	    if (h<0) dy1 = -1 ; else if (h>0) dy1 = 1 ;
	    if (w<0) dx2 = -1 ; else if (w>0) dx2 = 1 ;
	    int longest = Math.abs(w) ;
	    int shortest = Math.abs(h) ;
	    if (!(longest>shortest)) {
	        longest = Math.abs(h) ;
	        shortest = Math.abs(w) ;
	        if (h<0) dy2 = -1 ; else if (h>0) dy2 = 1 ;
	        dx2 = 0 ;            
	    }
	    int numerator = longest >> 1 ;
	    for (int i=0;i<=longest;i++) {
	    	drawPixel(x,y,color) ;
	        numerator += shortest ;
	        if (!(numerator<longest)) {
	            numerator -= longest ;
	            x += dx1 ;
	            y += dy1 ;
	        } else {
	            x += dx2 ;
	            y += dy2 ;
	        }
	    }
	}
	
	public void drawRect(int xp, int yp, int size, int value) {
		
		if(xp-size/2 < 0 || xp+size/2 > width) return;
		if(yp-size/2 < 0 || yp+size/2 > height) return;
		
		for(int y = -size/2 ; y < size/2 ; y++) {
			int ya = y+yp;
			
			for(int x = -size/2 ; x < size/2 ; x++) {
				int xa = x+xp;
				
				pixels[xa+ya*width] = value;
			}
		}
	}
	
	public void drawRect(int xp, int yp, int sizeX, int sizeY, int value) {
		
		if(xp-sizeX/2 < 0 || xp+sizeX/2 > width) return;
		if(yp-sizeY/2 < 0 || yp+sizeY/2 > height) return;
		
		for(int y = -sizeY/2 ; y < sizeY/2 ; y++) {
			int ya = y+yp;
			
			for(int x = -sizeX/2 ; x < sizeX/2 ; x++) {
				int xa = x+xp;
				
				pixels[xa+ya*width] = value;
			}
		}
	}
	
	public void drawTile(int xp, int yp, int size, int color) {
		if(color == 0xff00c1c1) return;
		for(int y = 0 ; y < size ; y++) {
			int ya = y + yp;
			for(int x = 0 ; x < size ; x++) {
			int xa = x + xp;
				if(xa < -size || xa >= getWidth() ||ya <0|| ya >= getHeight()) break;
				if (xa < 0) xa = 0;
				if(color != 0xff000043) pixels[xa + ya * getWidth()] = color;
				else continue;
			}
		}		
	}
	
	
	public void renderMob(int xp, int yp, Sprite sprite, boolean flip) {
		//Decallage de moitier sur Y
		int spriteHeight = sprite.getHeight()/2;
		for(int y = -spriteHeight ; y < spriteHeight ; y++) {
			int ySprite = y + spriteHeight;
			
			int ya = y + yp;
			
			// Decallage de moitier sur X
			int spriteWidth = sprite.getWidth()/2;
			for(int x = -spriteWidth ; x < spriteWidth  ; x++) {
				int xSprite = x + spriteWidth;
				
				int xa = x + xp;
			
				int xs = (sprite.getWidth()-1)-xSprite;
			
				if(xa < -sprite.SIZE || xa >= width ||ya <0|| ya >= height) break;
				if (xa < 0) xa = 0;
				
				int col;
				if(flip) col = sprite.pixels[xs+ySprite*sprite.getWidth()];
				else col = sprite.pixels[xSprite+ySprite*sprite.getWidth()];
				if(col != 0xffff00ff) pixels[xa+ya*width] = col;
			}
		}
	}
	
	public void drawCircle(int centerX, int centerY, int r, int color) {
		
		if(centerX-r < 0 || centerX+r >= width) return;
		if(centerY-r < 0 || centerY+r >= height) return;
		
		int d = (5 - r * 4)/4;
		int x = 0;
		int y = r;
		//add t to color
		do {
			pixels[(centerX + x)+ (centerY + y) * width]= color;
			pixels[(centerX + x)+ (centerY - y) * width]= color;
			pixels[(centerX - x)+ (centerY + y) * width]= color;
			pixels[(centerX - x)+ (centerY - y) * width]= color;
			pixels[(centerX + y)+ (centerY + x) * width]= color;
			pixels[(centerX + y)+ (centerY - x) * width]= color;
			pixels[(centerX - y)+ (centerY + x) * width]= color;
			pixels[(centerX - y)+ (centerY - x) * width]= color;
			if (d < 0) {
				d += 2 * x + 1;
			} else {
				d += 2 * (x - y) + 1;
				y--;
			}
			x++;
		} while (x <= y);
 
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public void fillColor(int backGroundColor) {
		for(int y = 0 ; y < pixels.length ; y++) {
			pixels[y] = backGroundColor;
		}
		
	}

	
}
