package vue.menu;

import javafx.geometry.Pos;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

public class Title extends StackPane {
        public Title(String name) {
            Rectangle bg = new Rectangle(550, 60);
            bg.setStroke(Color.WHITE);
            bg.setStrokeDashOffset(100);
            bg.setStrokeWidth(2);
            bg.setFill(null);

            Text text = new Text(name);
            text.setFill(Color.WHITE);
            text.setFont(Font.font("Tempus Sans ITC", FontWeight.SEMI_BOLD, 70));

            setAlignment(Pos.CENTER);
            getChildren().addAll(bg, text);
        }
    

}
