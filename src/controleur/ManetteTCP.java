package controleur;

import modele.metier.Action;

public class ManetteTCP implements Action  {

	private boolean saute;
	private boolean deplacmentDroite;
	private boolean deplacmentGauche;
	private boolean tire;
	private boolean pause;
	
	public void recuperation(String message) {
		saute = tire = pause = deplacmentDroite = deplacmentGauche = false;
		if(message.equals("a")) {
			saute = true;
		}
		else if(message.equals("b")) {
			tire = true;
		}
		else if(message.equals("y")) {
			pause = true;
		}
		else if(message.equals("x")) {
		}
		else if(message.equals("r")) {
			deplacmentDroite = true;
		}
		else if(message.equals("l")) {
			deplacmentGauche = true;
		}
		else if(message.equals("c")) {
			deplacmentGauche = false;
			deplacmentDroite = false;
		}
		else if(message.equals("s")) {
			tire = false;
			pause = false;
			saute = false;
		}
	}
	
	
	@Override
	public boolean deplacement_droit() {
		return deplacmentDroite;
	}

	@Override
	public boolean deplacement_gauche() {
		return deplacmentGauche;
	}

	@Override
	public boolean sauter() {
		return saute;
	}

	@Override
	public boolean attaquer() {
		return tire;
	}

	@Override
	public boolean action() {
		return false;
	}

	@Override
	public boolean pause() {
		// TODO Auto-generated method stub
		return pause;
	}
}
