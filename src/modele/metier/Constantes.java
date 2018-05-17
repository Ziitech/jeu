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
	private int typePerso;
	
	private int typeCarte;
	
	public int getTypePerso() {
		return typePerso;
	}

	public void setTypePerso(int typePerso) {
		this.typePerso = typePerso;
	}

	public int getTypeCarte() {
		return typeCarte;
	}

	public void setTypeCarte(int typeCarte) {
		this.typeCarte = typeCarte;
	}

	private Constantes() {
	}
	
	private static Constantes constantes = new Constantes();

	public float getGravite() {
		return gravite;
	}

	public void setGravite(float gravite) {
		this.gravite = gravite;
	}

	public float getVitesse() {
		return vitesse;
	}

	public void setVitesse(float vitesse) {
		this.vitesse = vitesse;
	}

	public boolean isDropColis() {
		return dropColis;
	}

	public void setDropColis(boolean dropColis) {
		this.dropColis = dropColis;
	}

	public static Constantes getConstantes() {
		return constantes;
	} 
	

}
