package vue.menu.bouton;

import javafx.animation.TranslateTransition;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.Duration;
import vue.menu.MenuButton;
import vue.menu.action.JouerAction;

public class JouerBoutton {
	
	public JouerBoutton(VBox menu0, VBox menu1, int offset, Stage primaryStage){
		MenuButton btnResume = new MenuButton("JOUER");
        btnResume.setOnMouseClicked(event -> {
        	System.out.println("cliaue");
        	new JouerAction();
        	TranslateTransition tt = new TranslateTransition(Duration.seconds(0.25), menu0);
            tt.setToX(menu0.getTranslateX() - offset);

            TranslateTransition tt1 = new TranslateTransition(Duration.seconds(0.5), menu1);
            tt1.setToX(menu0.getTranslateX());

            tt.play();
            tt1.play();

            tt.setOnFinished(evt -> {
            	primaryStage.hide();
            });
        	
        	
        });
	}

}
