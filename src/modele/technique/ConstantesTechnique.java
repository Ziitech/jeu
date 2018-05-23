package modele.technique;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import modele.metier.Constantes;

public class ConstantesTechnique {
	
	private Properties prop;
	private InputStream input;
	
	public ConstantesTechnique() {
		prop  = new Properties();
	}
	
	
	public void readFile(String path) {
		Constantes singleton = Constantes.getConstantes();
		//open File :
		try {
			input = new FileInputStream(path);
			// load a properties file
			prop.load(input);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		//Set attribute :
		singleton.setDropColis(getBoolean("dropColis"));
		singleton.setGravite(getFloat("gravite"));
		singleton.setVitesse(getFloat("vitesse"));
		singleton.setTypePerso(getInt("typePerso"));
		singleton.setTypeCarte(getInt("typeCarte"));
		singleton.setSaut(getFloat("saut"));
		//singleton.setTypeCarte(getInt("port"));
	}
	
	private float getFloat(String s) {
		String val = prop.getProperty(s);
		return Float.parseFloat(val);
	}
	
	private int getInt(String s) {
		String val = prop.getProperty(s);
		 return Integer.parseInt(val);
	}

	private boolean getBoolean(String s) {
		String val = prop.getProperty(s);
		return Boolean.parseBoolean(val);
	}

}
