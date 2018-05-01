package modele.technique.input;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import modele.metier.input.Mouse;


public class MouseTechnique implements MouseListener , MouseMotionListener{
	
	private Mouse mouse;

	@Override
	public void mouseDragged(MouseEvent e) {
		
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		mouse.setMouseX(e.getX());
		mouse.setMouseY(e.getY());
	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		mouse.bouttonPressed(arg0.getButton());
		
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		mouse.bouttonReleased(arg0.getButton());
		
	}

}
