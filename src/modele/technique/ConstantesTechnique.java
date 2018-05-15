package modele.technique;

import modele.metier.Constantes;

public class ConstantesTechnique {
	
	private Constantes singleton;
	
	public ConstantesTechnique() {
		singleton = Constantes.getConstantes();
	}
	
	public void readFile(String path) {
		//open File :
		
		
		//Set attribute :
		singleton.setDropColis(false);
		singleton.setGravite(0.7f);
		singleton.setVitesse(4.5f);
	}

}
