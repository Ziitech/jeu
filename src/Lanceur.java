

import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;

import controleur.Manager;
import vue.Cadre;

public class Lanceur {

	public Lanceur() {
	}

	public static void main(String[] args) {
		//recupere la taille de l'ecran
		GraphicsDevice gd = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
		int w = gd.getDisplayMode().getWidth();
		int h = gd.getDisplayMode().getHeight();
		
		new Cadre(w,h);
		Manager.getInstance().startGame();
	}

}
