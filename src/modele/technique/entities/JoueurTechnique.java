package modele.technique.entities;

import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

import controleur.Manager;
import modele.metier.Carte;
import modele.metier.Constantes;
import modele.metier.entities.mob.Joueur;
import modele.metier.entities.mob.Mob;
import modele.metier.input.Keyboard;
import modele.technique.input.KeyboardTechnique;

public class JoueurTechnique extends EntityTechnique implements MouseMotionListener{
	
	private Keyboard key;
	private float vitesse;
	
	public JoueurTechnique(int x, int y, Carte map, KeyboardTechnique k) {
		super(new Joueur(x,y,map));
		
		this.key = k.getKey();
		vitesse = Constantes.getConstantes().getVitesse();
	}
	
	@Override
	protected void update() {
		Mob j = (Mob) e;
		j.fall();
		
		if(key.isKeyDown(KeyEvent.VK_SPACE)) Manager.getInstance().addJoueur(60,60);
		
		if(key.isKey(KeyEvent.VK_Z)) {
			j.saute();
		}
		if(key.isKey(KeyEvent.VK_Q)) j.accelere(-vitesse, 0);
		if(key.isKey(KeyEvent.VK_D)) j.accelere(vitesse, 0);
		
		if(!j.collision()) {
			j.move();
		}
		
		if(j.recupererArme()) {
			System.out.println("augment la vitesse"+this.vitesse); 
		}
		
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub
		System.out.println(e.getX());
		
	}

}
