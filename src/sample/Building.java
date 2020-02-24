package sample;

import javafx.scene.image.Image;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

public class Building {
    String name;
    private int x;
    private int y; //x,y = coordinates
    private Image image;
    private int id;
    private static int freeId = 0;

    public Building(String name, int x, int y, Image image) {
        this.name = name;
        this.x = x;
        this.y = y;
        this.image = image;
        this.id = freeId;
        freeId++;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public static Building random(List<Building> buildings){
        return buildings.get((int)(Math.random()*buildings.size()));
    }

    public static List<Building> getAllBuildings() throws FileNotFoundException {
        List<Building> buildings = new ArrayList<>();

        buildings.add(new Building("the only hospital in town", 0,0,
                new Image(new FileInputStream("pics/hospital.png"),100,100,true,true)));

        buildings.add(new Building("you live here", 0,0,
                new Image(new FileInputStream("pics/home.png"),100,100,true,true)));

        buildings.add(new Building("just police", 0,0,
                new Image(new FileInputStream("pics/policeStation.png"),100,100,true,true)));

        buildings.add(new Building("topo", 0,0,
                new Image(new FileInputStream("pics/school.png"),100,100,true,true)));

        buildings.add(new Building("monopolowy", 0,0,
                new Image(new FileInputStream("pics/shop.png"),100,100,true,true)));

        buildings.add(new Building("st.Mary's church", 0,0,
                new Image(new FileInputStream("pics/church.png"),100,100,true,true)));

        buildings.add(new Building("???", 0,0,
                new Image(new FileInputStream("pics/hauntedHouse.png"),100,100,true,true)));

        return buildings;
    }
}
