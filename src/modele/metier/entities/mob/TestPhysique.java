package modele.metier.entities.mob;

import modele.metier.Carte;

public class TestPhysique extends Mob {

	public TestPhysique(int x, int y, Carte map) {
		super(map);
		this.x = x;
		this.y = y;
	}

	@Override
	public void update() {
		if(x < 0 || x >= map.getWidth() * map.getTileSize()) remove();
		if(y < 0 || y >= map.getHeight() * map.getTileSize()) remove();
		
		vitesseY += 0.7f;
		
		if(map.getSolidTileAt(x, y)) {
			vitesseX *= -0.5;
			vitesseY *= -0.5;
		}
			y += vitesseY;
			x += vitesseX;
	}

}
