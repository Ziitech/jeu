package controleur;

import modele.metier.Action;

public class ManetteTCP implements Action  {

	private boolean[] action = new boolean[6];
	
	public void recuperation(String message) {
		if(message == "a") {
			sauter();
		}
		else if(message == "b") {
			attaquer();
		}
		else if(message == "y") {
			
		}
		else if(message == "x") {
			
		}
	}
	
	
	@Override
	public boolean deplacement_droit() {
		return false;
	}

	@Override
	public boolean deplacement_gauche() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean sauter() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean attaquer() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean action() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean pause() {
		// TODO Auto-generated method stub
		return false;
	}
}
