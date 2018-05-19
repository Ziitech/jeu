package vue.menu;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.event.ChangeListener;

import javafx.animation.TranslateTransition;
import javafx.beans.value.ObservableValue;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.control.ComboBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.Label;
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleGroup;
import javafx.scene.effect.GaussianBlur;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;
import vue.menu.action.JouerAction;

public class GameMenu extends Parent {
	public GameMenu(Stage primaryStage, int w, int h) {
		VBox menu0 = new VBox(10);
		VBox menu1 = new VBox(10);
		VBox menu2 = new VBox(10);

		menu0.setTranslateX(100);
		menu0.setTranslateY(250);

		menu1.setTranslateX(100);
		menu1.setTranslateY(400);
		menu2.setTranslateX(100);
		menu2.setTranslateY(400);

		final int offset = 400;

		menu1.setTranslateX(offset);

		MenuButton btnResume = new MenuButton("JOUER");
		btnResume.setOnMouseClicked(event -> {
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


		MenuButton btnOptions = new MenuButton("OPTIONS");
		btnOptions.setOnMouseClicked(event -> {
			getChildren().add(menu1);

			TranslateTransition tt = new TranslateTransition(Duration.seconds(0.25), menu0);
			tt.setToX(menu0.getTranslateX() - offset);

			TranslateTransition tt1 = new TranslateTransition(Duration.seconds(0.5), menu1);
			tt1.setToX(menu0.getTranslateX());

			tt.play();
			tt1.play();

			tt.setOnFinished(evt -> {
				getChildren().remove(menu0);
			});
		});

		MenuButton btnExit = new MenuButton("QUITTER");
		btnExit.setOnMouseClicked(event -> {
			System.exit(0);
		});

		MenuButton btnBack = new MenuButton("BACK");
		btnBack.setOnMouseClicked(event -> {
			getChildren().add(menu0);

			TranslateTransition tt = new TranslateTransition(Duration.seconds(0.25), menu1);
			tt.setToX(menu1.getTranslateX() + offset);

			TranslateTransition tt1 = new TranslateTransition(Duration.seconds(0.5), menu0);
			tt1.setToX(menu1.getTranslateX());

			tt.play();
			tt1.play();

			tt.setOnFinished(evt -> {
				getChildren().remove(menu1);
			});
		});

		RadioButton radioButton1 = new RadioButton("1");
		RadioButton radioButton2 = new RadioButton("2");
		RadioButton radioButton3 = new RadioButton("3");

		ToggleGroup radioGroup = new ToggleGroup();
		radioButton1.setTextFill(Color.WHITE);
		radioButton1.setFont(Font.font(20));
		radioButton1.setToggleGroup(radioGroup);
		radioButton2.setPrefSize(70, 70);
		radioButton2.setTextFill(Color.WHITE);
		radioButton2.setFont(Font.font(20));
		radioButton2.setToggleGroup(radioGroup);
		radioButton3.setPrefSize(70, 70);
		radioButton3.setTextFill(Color.WHITE);
		radioButton3.setFont(Font.font(20));
		radioButton3.setToggleGroup(radioGroup);

		MenuButton btnJoueurs = new MenuButton("JOUEURS");
		btnJoueurs.setOnMouseClicked(event -> {
			getChildren().add(menu2);            


			TranslateTransition tt = new TranslateTransition(Duration.seconds(0.25), menu1);
			tt.setToX(menu1.getTranslateX() - offset);

			TranslateTransition tt1 = new TranslateTransition(Duration.seconds(0.5), menu2);
			tt1.setToX(menu1.getTranslateX());

			tt.play();
			tt1.play();

			tt.setOnFinished(evt -> {
				getChildren().remove(menu1);
			});
		});


		MenuButton btnVideo = new MenuButton("NIVEAU");
		btnVideo.setOnMouseClicked(event -> {
			getChildren().add(menu2);            


			TranslateTransition tt = new TranslateTransition(Duration.seconds(0.25), menu1);
			tt.setToX(menu1.getTranslateX() - offset);

			TranslateTransition tt1 = new TranslateTransition(Duration.seconds(0.5), menu2);
			tt1.setToX(menu1.getTranslateX());

			tt.play();
			tt1.play();

			tt.setOnFinished(evt -> {
				getChildren().remove(menu1);
			});
		});

		MenuButton btnCommande = new MenuButton("CONTROL");
		btnCommande.setOnMouseClicked(event -> {
			getChildren().add(menu2);            


			TranslateTransition tt = new TranslateTransition(Duration.seconds(0.25), menu1);
			tt.setToX(menu1.getTranslateX() - offset);

			TranslateTransition tt1 = new TranslateTransition(Duration.seconds(0.5), menu2);
			tt1.setToX(menu1.getTranslateX());

			tt.play();
			tt1.play();

			tt.setOnFinished(evt -> {
				getChildren().remove(menu1);
			});
		});


		MenuButton btnBack1 = new MenuButton("BACK");
		btnBack1.setOnMouseClicked(event -> {
			getChildren().add(menu1);

			TranslateTransition tt = new TranslateTransition(Duration.seconds(0.25), menu2);
			tt.setToX(menu2.getTranslateX() + offset);

			TranslateTransition tt1 = new TranslateTransition(Duration.seconds(0.5), menu1);
			tt1.setToX(menu2.getTranslateX());

			tt.play();
			tt1.play();

			tt.setOnFinished(evt -> {
				getChildren().remove(menu2);
			});
		});

		TextField textfield1 = new TextField();
		TextField textfield2 = new TextField();
		Label label1 = new Label("label1");
		label1.setTextFill(Color.WHITE);
		Label label2 = new Label("label2");
		label2.setTextFill(Color.WHITE);
		menu0.getChildren().addAll(btnResume, btnOptions, btnExit);
		menu1.getChildren().addAll(btnBack, btnJoueurs, btnVideo, btnCommande);
		menu2.getChildren().addAll(btnBack1,radioButton1,radioButton2, radioButton3,textfield1,textfield2,label1,label2);

		Rectangle bg = new Rectangle(w, h);
		bg.setFill(Color.GREY);
		bg.setOpacity(0.4);

		Title title = new Title("S N A I L W O R M S");
		title.setTranslateX(875);
		title.setTranslateY(350);

		getChildren().addAll(title, menu0);
	}

}
