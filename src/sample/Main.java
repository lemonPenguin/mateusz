package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

import java.io.FileNotFoundException;

public class Main extends Application {

    Stage stage;

    @Override
    public void start(Stage primaryStage) throws Exception{
        stage = primaryStage;
        stage.setTitle("Życie Mateusza");

        draw();
    }

    public void draw() throws FileNotFoundException {
        GridPane root = new GridPane();

        for (int y = 0; y < 7; y++) {
            for (int x = 0; x < 8; x++) {
                Rectangle rectangle = new Rectangle(100,100, Color.LIGHTGRAY);
                rectangle.setStroke(Color.DARKGREY);
                root.add(rectangle,x,y);
            }
        }

        Scene scene = new Scene(root,807,706);
        stage.setScene(scene);
        stage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
