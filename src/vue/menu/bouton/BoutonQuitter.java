package vue.menu.bouton;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.SwingConstants;

import vue.menu.action.QuitterAction;

public class BoutonQuitter extends JButton{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Font fontEntered;
	
	public BoutonQuitter(){
		fontEntered = new Font(Font.SERIF, Font.ITALIC, 70);
		
		this.setForeground(Color.WHITE);
		this.setOpaque(false);
		this.setContentAreaFilled(false); // On met � false pour emp�cher le composant de peindre l'int�rieur du JButton.
		this.setBorderPainted(false); // De m�me, on ne veut pas afficher les bordures.
		this.setFocusPainted(false); // On n'affiche pas l'effet de focus.
		this.setHorizontalAlignment(SwingConstants.CENTER);
		this.setHorizontalTextPosition(SwingConstants.CENTER);
		this.setFont(fontEntered);
		this.setText("Quitter");
		this.addActionListener(new QuitterAction());
	}
	

}
