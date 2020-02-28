package sample;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.IdentityHashMap;
import java.util.List;

public class Main extends Application {
    Stage stage;
    List<Building> buildings;
    int mateuszX;
    int mateuszY;

    @Override
    public void start(Stage primaryStage) throws Exception {
        stage = primaryStage;
        System.out.println(DBController.getBackpackFromDB().get(0).getBook());
        DBController.saveBackpackInDB(new Backpack("physics", "u"));
        buildings = Building.getAllBuildings();
        List<Building> tempXD = new ArrayList<>(buildings.size());
        for (int i = 0; i < buildings.size(); i++) {
            tempXD.add(buildings.get(i));
        }
        for (int y = 0; y < 7; y++) {
            for (int x = 0; x < 8; x++) {
                if(Math.random()<0.2){
                    if(!tempXD.isEmpty()) {
                        int index = Building.random(tempXD).getId();
                        Building building = buildings.get(index);
                        building.setX(x);
                        building.setY(y);
                        //System.out.println(buildings.size());
                        tempXD.remove(building);
                        /*System.out.println(buildings.size());
                        System.out.println(tempXD.size());*/
                    }
                }
            }
        }
        mateuszX = buildings.get(1).getX();
        mateuszY = buildings.get(1).getY();
        firstUI();
    }

    public void firstUI() {
        GridPane root = new GridPane();
        root.setVgap(20);
        root.setHgap(10);
        root.setAlignment(Pos.CENTER);

        Text welcomeText = new Text("Welcome, press a button or something idk know yet it sort of depends on what Zosia decides really");

        Button noButton = new Button("no"); // EXTREMELY IMPORTANT DONT DELETE THIS
        noButton.setOnAction(event -> {
            stage.close();
        });
        root.add(noButton, 1, 2);

        Button newPlayerButton = new Button("Enter new Player");
        newPlayerButton.setOnAction(event -> {
            enterNewPlayerUI();
        });
        root.add(newPlayerButton, 2, 2);
        root.add(welcomeText, 1, 1);

        stage.setScene(new Scene(root, 800, 700));
        stage.show();
    }

    private void enterNewPlayerUI() {
        stage.setTitle("Enter New Player Here");
        GridPane root = new GridPane();
        root.setAlignment(Pos.CENTER);
        root.setHgap(10);
        root.setVgap(20);

        Text enterNameHereText = new Text("Enter Desired Player Name Here: ");
        TextField playerNameTextField = new TextField();

        Text enterSurnameHereText = new Text("Enter Desired Player Surame Here: ");
        TextField playerSurnameTextField = new TextField();

        Text enterPlayerAgeText = new Text("Enter Desired Player Age Here: ");
        TextField playerAgeTextField = new TextField();

        Text choosePlayerDesiredGenderHereText = new Text("Choose Desired Player Gender Here");

        ComboBox<String> genderCombobox = new ComboBox<>();
        genderCombobox.getItems().addAll("Male", "Female", "AFAB", "Agender", "Aliagender", "AMAB", "Androgyne", "Aporagender", "Bigender", "Binarism", "Body dysphoria", "Boi", "Butch", "Cisgender", "Demiboy", "Demigirl", "Dyadic", "Feminine-of-center", "Feminine-presenting", "Femme", "FTM", "Gender apatheic", "Gender binary", "Gender dysphoria", "Gender nonconforming", "Gender variant", "Genderfluid", "Genderqueer", "Graygender", "Intergender", "Masculine-of-center", "Masculine-presenting", "Maverique", "MTF", "Neutrois", "Nonbinary", "Novigender", "Pandgender", "Polygender", "Soft butch", "Stone butch", "Third gender", "Transfeminine", "Two-spirit");

        Button enterPlayerButton = new Button("Enter New Player");
        enterPlayerButton.setOnAction(event -> {
            String playerUserName = playerNameTextField.getText();
            String playerSurname = playerSurnameTextField.getText();
            int playerAge = Integer.parseInt(playerAgeTextField.getText());
            String playerGender = genderCombobox.getValue();
            Player player = new Player(playerUserName, playerSurname, playerAge, playerGender);

            weDontCareYoureNameIsMateuszUI(player);

            System.out.println(player);

        });
        root.add(enterPlayerButton, 2, 5);

        root.add(enterNameHereText, 0, 1);
        root.add(playerNameTextField, 1, 1);
        root.add(enterSurnameHereText, 0, 2);
        root.add(playerSurnameTextField, 1, 2);
        root.add(enterPlayerAgeText, 0, 3);
        root.add(playerAgeTextField, 1, 3);
        root.add(choosePlayerDesiredGenderHereText, 0, 4);
        root.add(genderCombobox, 1, 4);

        stage.setScene(new Scene(root, 800, 700));
        stage.show();
    }

    private void weDontCareYoureNameIsMateuszUI(Player player) {
        stage.setTitle("Zycie Mateusza");
        GridPane root = new GridPane();
        root.setAlignment(Pos.CENTER);
        root.setHgap(10);
        root.setVgap(20);

        Text weDontCare = new Text("Unfortunately, we really don't care, your name is Mateusz, your surname is Pszczolek, your age is 17, and your gender is Male, fuck you");

        Button okFineButton = new Button("Okey, Fine, My name is Mateusz");
        okFineButton.setOnAction(event -> {
            try {
                gameUI();
            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            }
        });

        Button noIDontWantMyNameToBeMateuszButton = new Button("No, I want my character to be " + player.toString());
        noIDontWantMyNameToBeMateuszButton.setOnAction(event -> {
            stage.close();
        });

        root.add(weDontCare, 0, 0);
        root.add(okFineButton, 1, 1);
        root.add(noIDontWantMyNameToBeMateuszButton, 0, 1);

        stage.setScene(new Scene(root, 1000, 300));
        stage.show();
    }

    private void gameUI() throws FileNotFoundException {
        GridPane root = new GridPane();

        for (int y = 0; y < 7; y++) {
            for (int x = 0; x < 8; x++) {
                Rectangle rectangle = new Rectangle(100, 100);
                rectangle.setFill(Color.DARKGREY);
                root.add(rectangle, x, y);
            }
        }

        for (int i = 0; i < buildings.size(); i++) {
            root.add(new ImageView(buildings.get(i).getImage()),buildings.get(i).getX(),buildings.get(i).getY());
        }

        Image mateuszIm = new Image(new FileInputStream("pics/mateusz.png"),100,100,true,true);
        ImageView mateusz = new ImageView(mateuszIm);
        root.add(mateusz,mateuszX,mateuszY);


        Scene scene = new Scene(root, 807, 706);
        scene.setOnKeyPressed(event -> {
            if(event.getCode() == KeyCode.W && mateuszY > 0){
                mateuszY--;
            }
            else if(event.getCode() == KeyCode.S && mateuszY < 6){
                mateuszY++;
            }
            else if(event.getCode() == KeyCode.A && mateuszX > 0){
                mateuszX--;
            }
            else if(event.getCode() == KeyCode.D && mateuszX < 7){
                mateuszX++;
            }
            try {
                gameUI();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        });

        scene.setFill(Color.FORESTGREEN);
        stage.setScene(scene);
        stage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
