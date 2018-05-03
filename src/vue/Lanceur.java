package vue;

import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;

public class Lanceur {

	public Lanceur() {
	}

	public static void main(String[] args) {
		GraphicsDevice gd = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
		int w = gd.getDisplayMode().getWidth();
		int h = gd.getDisplayMode().getHeight();
		new Cadre(w,h);
	}

}
