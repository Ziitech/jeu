package modele.metier;

/**
 * Singleton pour acceder au fichier parametre
 * @author Nandaleio
 *
 */

public class Constantes {
	
	private float gravite;
	private float vitesse;
	private float saut;
	private int typePerso;
	private int typeCarte;
	private boolean armeCac;
	private boolean dropColis;
	private int pourcentageColis;
	private int nbVie;
	private int nbManche;
	
	public float getSaut() {
		return saut;
	}

	public void setSaut(float saut) {
		this.saut = saut;
	}

	public boolean isArmeCac() {
		return armeCac;
	}

	public void setArmeCac(boolean armeCac) {
		this.armeCac = armeCac;
	}

	public int getPourcentageColis() {
		return pourcentageColis;
	}

	public void setPourcentageColis(int pourcentageColis) {
		this.pourcentageColis = pourcentageColis;
	}

	public int getNbVie() {
		return nbVie;
	}

	public void setNbVie(int nbVie) {
		this.nbVie = nbVie;
	}

	public int getNbManche() {
		return nbManche;
	}

	public void setNbManche(int nbManche) {
		this.nbManche = nbManche;
	}

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
