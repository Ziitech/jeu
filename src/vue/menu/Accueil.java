package vue.menu;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;

import javax.swing.JFrame;

import javafx.animation.FadeTransition;
import javafx.animation.TranslateTransition;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.effect.DropShadow;
import javafx.scene.effect.GaussianBlur;
import javafx.scene.effect.Glow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;
import vue.menu.action.JouerAction;
import vue.menu.bouton.BoutonJouer;
import javafx.scene.input.KeyCode;

public class Accueil extends Application {

    private GameMenu gameMenu;
    Stage primaryStage;
    GraphicsDevice gd = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
	int w = gd.getDisplayMode().getWidth();
	int h = gd.getDisplayMode().getHeight();
    
    @Override
    public void start(Stage primaryStage) throws Exception {

        Pane root = new Pane();
        
        this.primaryStage = primaryStage;
        root.setMinSize(w-10, h-10);
        InputStream is = Files.newInputStream(Paths.get("image/nkkiae_8y.jpg"));
        Image img = new Image(is);
        is.close();

        ImageView imgView = new ImageView(img);
        imgView.setFitWidth(w);
        imgView.setFitHeight(h);

        gameMenu = new GameMenu(primaryStage,w,h);
        gameMenu.setVisible(false);

        root.getChildren().addAll(imgView, gameMenu);

        Scene scene = new Scene(root);
        gameMenu.setVisible(true);
        
        
        primaryStage.setScene(scene);
        primaryStage.show();
        
        
    }

    public static void main(String[] args) {
        launch(args);
    }
}

