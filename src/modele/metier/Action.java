package modele.metier;

public interface Action {
public boolean deplacement_droit();
public boolean deplacement_gauche();
public boolean sauter();
public boolean attaquer();
public boolean action();
public boolean pause();
}
