package sample;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
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
import java.util.List;

public class Main extends Application {
    Stage stageGlobal;
    List<Building> buildings;
    int mateuszX;
    int mateuszY;
    int flag = 0;

    @Override
    public void start(Stage primaryStage) throws Exception {
        stageGlobal = primaryStage;

        buildings = Building.getAllBuildings();

        setCoor();

        mateuszX = buildings.get(1).getX();
        mateuszY = buildings.get(1).getY();
//        firstUI();
        gameUI();
//        warningPopUp();
    }

    private void setCoor() {
        for (int i = 0; i < buildings.size(); i++) {
            buildings.get(i).setX((int)(Math.random()*8));
            buildings.get(i).setY((int)(Math.random()*7));
        }
        for (int i = 0; i < buildings.size() - 1; i++) {
            for (int j = i + 1; j < buildings.size(); j++) {
                if(buildings.get(i).getX() == buildings.get(j).getX() && buildings.get(i).getY() == buildings.get(j).getY()){
                    setCoor();
                }
            }
        }
    }


    public void firstUI() {
        GridPane root = new GridPane();
        root.setVgap(20);
        root.setHgap(10);
        root.setAlignment(Pos.CENTER);

        Text welcomeText = new Text("Welcome, press a button or something idk know yet it sort of depends on what Zosia decides really");

        Button noButton = new Button("no"); // EXTREMELY IMPORTANT DONT DELETE THIS
        noButton.setOnAction(event -> {
            stageGlobal.close();
        });
        root.add(noButton, 1, 2);

        Button whatevenIsThisButton = new Button("What is this I really don't understand");
        whatevenIsThisButton.setOnAction(event -> {
            gitgud();
        });
        root.add(whatevenIsThisButton, 1, 3);

        Button newPlayerButton = new Button("Enter new Player");
        newPlayerButton.setOnAction(event -> {
            enterNewPlayerUI();
        });
        root.add(newPlayerButton, 2, 2);
        root.add(welcomeText, 1, 1);

        stageGlobal.setScene(new Scene(root, 800, 700));
        stageGlobal.show();
    }

    private void gitgud() {
        Stage stage = new Stage();
        stage.setTitle("Help");
        GridPane root = new GridPane();
        root.setAlignment(Pos.CENTER);
        root.setHgap(10);
        root.setVgap(20);

        Text gidGudText = new Text("Git Gud");

        Button whywouldYOusaythatBUtton = new Button("That's very disrespectful, let me talk to your supervisor!");
        whywouldYOusaythatBUtton.setOnAction(event -> {
            gidGudText.setText("no");
            stage.setTitle("Just play the game");
            whywouldYOusaythatBUtton.setText("THIS BUTTON LITERALLY DOES NOTHING");

        });

        root.add(gidGudText, 1, 1);
        root.add(whywouldYOusaythatBUtton, 2, 2);

        stage.setScene(new Scene(root, 600, 500));
        stage.show();
    }

    private void enterNewPlayerUI() {
        stageGlobal.setTitle("Enter New Player Here");
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

        stageGlobal.setScene(new Scene(root, 800, 700));
        stageGlobal.show();
    }

    private void weDontCareYoureNameIsMateuszUI(Player player) {
        stageGlobal.setTitle("Zycie Mateusza");
        GridPane root = new GridPane();
        root.setAlignment(Pos.CENTER);
        root.setHgap(10);
        root.setVgap(20);

        Text weDontCare = new Text("Unfortunately, we really don't care, your name is Mateusz, your surname is Pszczolek, your age is 17, and your gender is Male");

        Button okFineButton = new Button("Okey, Fine, My name is Mateusz");
        okFineButton.setOnAction(event -> {
            gameUI();
        });

        Button noIDontWantMyNameToBeMateuszButton = new Button("No, I want my character to be " + player.toString());
        noIDontWantMyNameToBeMateuszButton.setOnAction(event -> {
            stageGlobal.close();
        });

        root.add(weDontCare, 0, 0);
        root.add(okFineButton, 1, 1);
        root.add(noIDontWantMyNameToBeMateuszButton, 0, 1);

        stageGlobal.setScene(new Scene(root, 1000, 300));
        stageGlobal.show();
    }

    private void gameUI() {
        stageGlobal.setTitle("Zycie Mateusza");
        GridPane root = new GridPane();

        for (int y = 0; y < 7; y++) {
            for (int x = 0; x < 8; x++) {
                Rectangle rectangle = new Rectangle(100, 100);
                rectangle.setFill(Color.DARKGREY);
                root.add(rectangle, x, y);
            }
        }

        for (int i = 0; i < buildings.size(); i++) {
            root.add(new ImageView(buildings.get(i).getImage()), buildings.get(i).getX(), buildings.get(i).getY());
        }

        Image mateuszIm = null;
        try {
            mateuszIm = new Image(new FileInputStream("pics/mateusz.png"), 100, 100, true, true);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        ImageView mateusz = new ImageView(mateuszIm);
        root.add(mateusz, mateuszX, mateuszY);


        Scene scene = new Scene(root, 800, 700);
        scene.setOnKeyPressed(event -> {
            if ((event.getCode() == KeyCode.W || event.getCode() == KeyCode.UP) && mateuszY > 0) {
                mateuszY--;
            } else if ((event.getCode() == KeyCode.S || event.getCode() == KeyCode.DOWN) && mateuszY < 6) {
                mateuszY++;
            } else if ((event.getCode() == KeyCode.A || event.getCode() == KeyCode.LEFT) && mateuszX > 0) {
                mateuszX--;
            } else if ((event.getCode() == KeyCode.D || event.getCode() == KeyCode.RIGHT) && mateuszX < 7) {
                mateuszX++;
            } else if (event.getCode() == KeyCode.E) {
                backpackUIorsmthImNotReallySureYet();
            } else if (event.getCode() == KeyCode.SPACE) {
                for (int i = 0; i < buildings.size(); i++) {
                    if (mateuszX == buildings.get(i).getX() && mateuszY == buildings.get(i).getY()) {
                        if (flag == 0) {
                            buildingspopup(i);
                            flag = 1;
                        } else if (flag == 1) {
                            warningPopUp();
                        }
                    }
                }
            }
            gameUI();
        });


        stageGlobal.setScene(scene);
        stageGlobal.show();
    }

    private void warningPopUp() {
        Stage stage = new Stage();
        stage.setTitle("There has been a problem");
        GridPane root = new GridPane();
        root.setAlignment(Pos.CENTER);
        root.setHgap(10);
        root.setVgap(20);

        Text text = new Text("Oops! You made a mistake! You didn't save last time, try again! \n" +
                " (You most likely closed the ''Backpack'' window without saving, try again!) ");

        Button button = new Button("Okey!");
        button.setOnAction(event -> {
            flag = 0;
            stage.close();
        });


        root.add(text, 1, 1);
        root.add(button, 2, 2);


        stage.setScene(new Scene(root, 800, 600));
        stage.show();
    }

    private void buildingspopup(int i) {
        Stage stage = new Stage();
        stage.setTitle("Popup Test");
        GridPane root = new GridPane();
        root.setAlignment(Pos.CENTER);
        root.setVgap(20);
        root.setHgap(10);

        Text text = new Text("Test");


        Button button = new Button("Ok");
        button.setOnAction(event -> {
            flag = 0;
            stage.close();
        });


        root.add(text, 1, 1);
        root.add(button, 2, 2);

        stage.setScene(new Scene(root, 700, 800));
        stage.show();
    }

    void backpackUIorsmthImNotReallySureYet() {
        Stage stage = new Stage();
        GridPane root = new GridPane();
        root.setAlignment(Pos.BASELINE_LEFT);
        root.setVgap(20);
        root.setHgap(10);

        Double money = 00.00;

        Text moneyText = new Text("Mateusz has : " + money.toString() + "$");


// TODO: 2/25/2020 fix
        Backpack backpack = null;

        ListView<List<Item>> BackpackItemsListView = new ListView<>();
        BackpackItemsListView.getItems().addAll((List<Item>) backpack);

        Text backPackItemsText = new Text("Current Items Mateusz has in his Backpack : ");

        root.add(backPackItemsText, 1, 1);
        root.add(BackpackItemsListView, 1, 2);
        root.add(moneyText, 3, 0);


        stage.setScene(new Scene(root, 500, 500));
        stage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
