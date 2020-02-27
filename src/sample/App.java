package sample;

import com.daoimpl.BackpackDaoImpl;
import com.entities.Backpack;

import java.sql.Connection;
import java.sql.SQLException;

public class App {

    public static void main(String[] args) {
        BackpackDaoImpl pdi = new BackpackDaoImpl();
        pdi.createBackpackTable();
    }
}
