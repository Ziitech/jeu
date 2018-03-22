package vue;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;

import controleur.Manager;

public class BoutonActualise extends JButton implements MouseListener
{
	private static final long serialVersionUID = 4225142909667643077L;

	/**
	 * Initialisation du bouton
	 * @param text text
	 */
	public BoutonActualise(String text)
	{
		setText(text);
		setForeground(Color.BLACK);
		setOpaque(false);
		setContentAreaFilled(true); 				// On met à false pour empêcher le composant de peindre l'intérieur du JButton.
		setBorderPainted(false); 					// On ne veut pas afficher les bordures.
		setFocusPainted(false); 					// On n'affiche pas l'effet de focus.
	    this.addMouseListener(this);
	}
	
	/**
	 * Position du bouton 
	 */
	public void positionBouton() {setBounds(325,700,150,50);}

	/**
	 *  Quand on appuie sur le bouton
	 */
	@Override
	public void mousePressed(MouseEvent e) {
		Manager.getInstance().afficheFractale();	// Affichage du fractale 
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {}

	@Override
	public void mouseEntered(MouseEvent e) {}

	@Override
	public void mouseExited(MouseEvent e) {}

	@Override
	public void mouseReleased(MouseEvent e) {}
}
