package vue;

import java.awt.Color;
import java.lang.reflect.Field;
import javax.swing.JTextField;
import javax.swing.event.CaretEvent;
import javax.swing.event.CaretListener;

import controleur.Manager;

public class ChampText extends JTextField implements CaretListener
{
	private static final long serialVersionUID = -1510788044432461151L;
	private Color retour;
	
	/**
	 * Initialisation du champ de text
	 * @param text text
	 */
	public ChampText(String text)
	{
		this.setText(text);
		this.addCaretListener(this);
	}
	/**
	 * Position du champ de text
	 */
	public void positionChamp() {setBounds(130,700,150,50);}
	
	/**
	 * Récupération de la couleur
	 */
	public void getColor() {
			String couleur = getText().toLowerCase();				//	Récupération du text 
			retour = null;
			try {
			    Field field = Class.forName("java.awt.Color").getField(couleur);
			    retour = (Color)field.get(null);
			} catch (Exception e) {									//	Si la couleur n'est pas reconnu
				retour = Color.BLACK;}
		}

	/**
	 *  Modification a chaque changement de textfield
	 */
	@Override
	public void caretUpdate(CaretEvent arg0) {
		getColor();
		Manager.getInstance().getCouleur(retour);						//  Envoie la couleur 
	}
}

