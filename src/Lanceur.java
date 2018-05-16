

import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;

import controleur.Manager;
import menu.Accueil;
import vue.Cadre;
import vue.CadreGeneral;

public class Lanceur {

	public Lanceur() {
	}

	public static void main(String[] args) {
		//recupere la taille de l'ecran
//		GraphicsDevice gd = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
//		int w = gd.getDisplayMode().getWidth();
//		int h = gd.getDisplayMode().getHeight();
//		
//		new Cadre(w,h);
//		Manager.getInstance().startGame();
		
		new CadreGeneral();
	}

}
