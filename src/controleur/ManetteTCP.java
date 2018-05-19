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
		if(message == "a") {
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
	}
	
	
	@Override
	public boolean deplacement_droit() {
		return deplacmentDroite;
	}

	@Override
	public boolean deplacement_gauche() {
		// TODO Auto-generated method stub
		return deplacmentGauche;
	}

	@Override
	public boolean sauter() {
		// TODO Auto-generated method stub
		return saute;
	}

	@Override
	public boolean attaquer() {
		// TODO Auto-generated method stub
		return tire;
	}

	@Override
	public boolean action() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean pause() {
		// TODO Auto-generated method stub
		return pause;
	}
}
