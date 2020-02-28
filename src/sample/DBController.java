package sample;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DBController {
    private static final String CONN = "jdbc:sqlite:db.sqlite";

    public static List<Backpack> getBackpackFromDB() throws SQLException {
        List<Backpack> backpacks = new ArrayList<>();

        String sqlQuery = "SELECT * FROM backpacks;";

        Connection connection = DriverManager.getConnection(CONN);
        PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);
        ResultSet resultSet = preparedStatement.executeQuery();

        try(connection; preparedStatement; resultSet) {
            while (resultSet.next()) {
                String book = resultSet.getString("book");
                String purpose = resultSet.getString("purpose");

                Backpack backpack = new Backpack(book, purpose);
                backpacks.add(backpack);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return backpacks;
    }
    public static void saveBackpackInDB(Backpack backpack) throws SQLException {
        Connection connection = DriverManager.getConnection(CONN);

        String insertSQL = "INSERT INTO backpacks(book, purpose) VALUES (?, ?);";

        PreparedStatement preparedStatement = connection.prepareStatement(insertSQL);
        try(connection; preparedStatement){
            preparedStatement.setString(1, backpack.getBook());
            preparedStatement.setString(2, backpack.getPurpose());
            preparedStatement.executeUpdate();
        }
        catch (SQLException e){
            e.printStackTrace();
        }
    }

}
