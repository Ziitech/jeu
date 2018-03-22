package vue;

import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

import controleur.Manager;

public class FractaleFrame extends JFrame implements Vue, MouseMotionListener{

	private static final long serialVersionUID = 1L;
	
	/**
	 * Panel
	 */
	private Panneau panel;
	/**
	 * Bouton reDessiner
	 */
	private BoutonActualise bouton;
	/**
	 * Label Position coordonn�e de la souris
	 */
	private LabelCoord coordonnee;
	/**
	 * Champ de text pour choisir une liste de couleur
	 */
	private ChampText textfield;
	
	public FractaleFrame() 
	{		
		Manager.getInstance().setVue(this);
		panel = new Panneau();
		
		this.setTitle("Les FRACTALS de Mandelbrot");	      	//	Ajouter un titre
		this.setSize(800,800);									//	Taille de la fenetre
		this.setLocationRelativeTo(null);						//	Fenetre au milieu de l'�cran
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	//	Ferme compl�tement le programme quand on ferme la fenetre
		this.setResizable(false);								//	Bloquer la modification de la taille de la fenetre 									
		panel.setLayout(null);
		
		textfield = new ChampText("Couleur");
		bouton = new BoutonActualise("reDessiner");
		coordonnee = new LabelCoord();	
		
		bouton.positionBouton();
		panel.add(bouton);
	    textfield.positionChamp();
	    panel.add(textfield);
	    coordonnee.positionLabel();
	    panel.add(coordonnee);

		this.setContentPane(panel);
		this.setVisible(true);									//	Visibilit� de la fenetre	

	    addMouseMotionListener(this);
	}
	
	/**
	 * Afficher l'image sur le panel
	 */
	@Override
	public void afficher(Image image) {
		
		panel.setImage(image);
		panel.repaint();
	}
	
	@Override
	public void mouseDragged(MouseEvent e) {}

	/**
	 * Gestion de la position de la souris en x et y
	 */
	@Override
	public void mouseMoved(MouseEvent e) {
		int x;
		int y;
	    x = e.getX();
	    y = e.getY();
	    coordonnee.setText("x:"+x+" , y: "+y);
	}
	
	/**
	 * Main
	 * @param args arguments
	 */
	public static void main(String[] args) 
	{
		System.out.println("coucou");
		SwingUtilities.invokeLater(new Runnable() 
		{
			@Override
			public void run() 
			{
				new FractaleFrame();
			}	
		});
	}
}
