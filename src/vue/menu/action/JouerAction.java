package vue.menu.action;

import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import controleur.Manager;
import vue.Cadre;

public class JouerAction implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {
		GraphicsDevice gd = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
		int w = gd.getDisplayMode().getWidth();
		int h = gd.getDisplayMode().getHeight();
		
		new Cadre(w,h);
		Manager.getInstance().startGame();

	}

}
