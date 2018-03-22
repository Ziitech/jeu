package controleur;

import java.awt.Color;
import java.awt.image.BufferedImage;

import modele.metier.Fractale;
import vue.Vue;

public final class Manager {
    
    private static Manager moi = new Manager();
    private BufferedImage image;
    private Fractale fractale;
    private Color color;

    /**
     * Vue du projet 
     */
    private Vue vue;
    
    private Manager() 
    {
        super();
        color = Color.BLACK;
        image = new BufferedImage(800,800, 2);
        fractale = new Fractale();
    }

    public final static Manager getInstance() {return moi;}
    public void setVue(Vue vue){this.vue = vue;}
        
    /**
     * Récupération de la couleur
     * @param c couleur
     */
    public void getCouleur(Color c){color = c;}
    
    /**
     * Affichage du fractale
     */
    public void afficheFractale()
    {
    	fractale.generate(image,color);
    	vue.afficher(image);
    }
}


