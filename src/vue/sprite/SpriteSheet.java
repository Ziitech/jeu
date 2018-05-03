package vue.sprite;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class SpriteSheet {
	
	public static SpriteSheet sheet1 = new SpriteSheet("/Player.png", 512);

	private String path;
	public int[] pixels;
	public final int SIZE;
	public int sprite_Width, sprite_Height;
	
	private Sprite[] sprites;

	private int width, height;
	
	public SpriteSheet(SpriteSheet sheet, int x, int y, int width , int height , int spriteSize) {
		int xx = x * spriteSize;
		int yy = y * spriteSize;
		int w = width * spriteSize;
		int h = height * spriteSize;
		if(w == h) SIZE = w;
		else SIZE = -1;
		this.sprite_Width = w;
		this.sprite_Height = h;
		pixels = new int[w * h];
		for(int y0 = 0; y0 < h ; y0++) {
			int yp = y0 + yy;
			for(int x0 = 0 ; x0 < w ; x0++) {
				int xp = xx + x0;
				pixels[x0 + y0 * w] = sheet.pixels[xp + yp * sheet.sprite_Width];
			}
		}
		
		sprites = new Sprite[w*h];
		int frame = 0;
		
		for(int ya = 0 ; ya < height ; ya++) {
			for(int xa = 0 ; xa < width ; xa++) {

				int spritePixels[] = new int [spriteSize * spriteSize];
				
					for(int y0 = 0 ; y0 < spriteSize ; y0++) {
							for(int x0 = 0 ; x0 < spriteSize ; x0++) {
								
								spritePixels[x0 + y0 * spriteSize] = pixels[(x0 + xa * spriteSize) + (y0 + ya * spriteSize) * sprite_Width];
								
							}
					}
					Sprite sprite = new Sprite(spritePixels, spriteSize , spriteSize);
					sprites[frame++] = sprite;
			}
		}
	}
	
	public SpriteSheet(String path, int size) {
		this.path = path;
		this.SIZE = size;
		this.sprite_Width = size;
		this.sprite_Height = size;
		pixels = new int[SIZE * SIZE];
		load();
	}
	
	public SpriteSheet(String path, int width, int height) {
		this.path = path;
		this.sprite_Width = width;
		this.sprite_Height = height;
		SIZE = -1;
		pixels = new int[sprite_Width * sprite_Height];
		load();
	}
	
	public int[] getSprite(int x, int y, int width, int height) {
		int[] retour = new int[width*height];
		
		for(int j = 0 ; j < height ; j++) {
			for(int i = 0 ; i < width ; i++) {
				
				retour[i+j*width] = pixels[(x+i)+(j+y)*this.width];
				
			}
		}
			return retour;
	}
	
	public int getHeight() {
		return height;
	}
	
	public int[] getPixels() {
		return pixels;
	}

	public int getSIZE() {
		return SIZE;
	}

	public Sprite[] getSprite() {
		return sprites;
	}

	public int getWidth() {
		return width;
	}

	private void load() {
		try {
			System.out.print("Trying to load : " + path);
			BufferedImage image = ImageIO.read(SpriteSheet.class.getResource(path));
			width = image.getWidth();
			height = image.getHeight();
			pixels = new int[width * height];
			image.getRGB(0,0, width, height, pixels, 0,width);
			System.out.println(" DONE !");
		} catch (IOException e) {
			System.out.println(" FAILED !");
			e.printStackTrace();
		}
	}
	
}
