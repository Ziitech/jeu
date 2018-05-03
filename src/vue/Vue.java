package vue;

import java.awt.event.KeyListener;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import vue.sprite.Sprite;

public interface Vue {
	
	public void addKey(KeyListener k);
	public void addMouse(MouseMotionListener k, MouseListener l);
	
	public void render();
	public void drawEntity(int x, int y, Sprite s ,boolean flip);
	public void clear();
	public void drawTiles(int x, int y, int size, int tilesAt);
	
	public int getFrameWidth();
	public int getFrameHeight();
	public void drawCursor(int mouseX, int mouseY);


}
