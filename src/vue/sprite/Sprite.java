package vue.sprite;

public class Sprite {

	
	public static Sprite snake = new Sprite(32, 1, 0, SpriteSheet.sheet1);
	public static Sprite particule = new Sprite(32, 3, 0, SpriteSheet.sheet1);
	public static Sprite bombe = new Sprite(32, 4, 0, SpriteSheet.sheet1);
	public static Sprite player = new Sprite(64, 0, 6, SpriteSheet.sheet1);
	
	public int[] pixels;
	protected SpriteSheet sheet;
	public final int SIZE;
	private int width, height;
	
	
	private int x, y ;
	
	public Sprite(int size, int color) {
		this.SIZE = size;
		this.width = this.height = size;
		pixels = new int [SIZE*SIZE];
		setColor(color);
		
	}
	
	public Sprite(int width, int height, int color) {
		SIZE = -1;
		this.width = width;
		this.height = height;
		pixels = new int [width*height];
		setColor(color);
	}
	
	public Sprite(int size, int x, int y, SpriteSheet sheet) {
		SIZE = size;
		this.width = this.height = size;
		pixels = new int[SIZE*SIZE];
		this.x = x*size;
		this.y = y* size;
		this.sheet = sheet;
		load();
	}
	
	public Sprite(int[] pixels, int width, int height) {
		if(width == height) SIZE = width;
		else SIZE = -1;
		
		this.width = width;
		this.height = height;
		
		this.pixels = new int[pixels.length];
		System.arraycopy(pixels, 0, this.pixels, 0, pixels.length);
	}
	
	public Sprite(int x,int y ,int width, int height, SpriteSheet sp) {
		SIZE = -1;
		this.width = width;
		this.height = height;
		pixels = sp.getSprite(x, y, width, height);
	}
	
	public Sprite(SpriteSheet sheet, int width, int height) {
		if(width == height) SIZE = width;
		else SIZE = -1;
		
		this.width = width;
		this.height = height;
		this.sheet = sheet;
		pixels = new int[width * height];
		//load();
	}
	
	public int getHeight() {
		return height;
	}
	
	public int getWidth() {
		return width;
	}

	private void load() {
		for(int y = 0 ; y < height; y++) {
			for(int x = 0 ; x < width ; x++) {
				pixels[x + y  *width] = sheet.pixels[(x + this.x) + (y + this.y) * sheet.sprite_Width];
			}
		}
	}

	private void setColor(int color) {
		for(int i = 0; i < pixels.length; i++) {
			pixels[i] = color;
		}
	}

	public void flip() {
		for(int y = height ; y > 0 ; y--) {
				for(int x = 0 ; x < width ; x++) {
					pixels[x + (height-y)*width] = pixels[x+y*width];
				}
		}
		
	}
	
}
