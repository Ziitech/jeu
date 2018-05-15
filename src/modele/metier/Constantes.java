package modele.metier;

/**
 * Singleton pour acceder au fichier parametre
 * @author Nandaleio
 *
 */

public class Constantes {
	
	private float gravite;
	private float vitesse;
	private boolean dropColis;
	
	private Constantes() {
		readFile();
	}
	
	/**
	 * lis le fichier de configuration et applique les valeurs
	 */
	private void readFile() {
		
	}
	
	private static Constantes constantes = new Constantes(); 
	

}
