package vue.menu;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.AbstractButton;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import vue.menu.bouton.BoutonJouer;
import vue.menu.bouton.BoutonParametre;
import vue.menu.bouton.BoutonQuitter;


public class Accueil extends JPanel{
	
	private BoutonJouer jouer;
	private BoutonParametre parametre;
	private BoutonQuitter quitter;
	private Image imagedefond = null;
	
	public Accueil(){
		BoutonJouer jouer = new BoutonJouer();
		BoutonParametre parametre = new BoutonParametre();
		BoutonQuitter quitter = new BoutonQuitter();
		
		imagedefond = Toolkit.getDefaultToolkit().getImage("image/nkkiae_8y.jpg");
		ImageIcon icon = null;
		try {
			icon = new ImageIcon(ImageIO.read(new File("image/Burn-Snail-icon.png")));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		JLabel texte = new JLabel("SnailGame",icon,10);
		texte.setForeground(Color.WHITE);
		texte.setOpaque(false);
		texte.setFocusable(false); // On n'affiche pas l'effet de focus.
		texte.setHorizontalAlignment(SwingConstants.CENTER);
		texte.setHorizontalTextPosition(SwingConstants.CENTER);
		texte.setFont(new Font("Serif", Font.PLAIN, 36));
		this.setLayout(new GridLayout(4,1));
		//add(new JLabel(icon));
		add(texte);
		add(jouer);
		add(parametre);
        add(quitter);
		
	}
	
	public void paintComponent(Graphics g) {
		g.drawImage(imagedefond, 0, 0, this);
	}
	

}
