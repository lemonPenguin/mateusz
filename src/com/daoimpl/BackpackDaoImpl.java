package com.daoimpl;

import com.dao.BackpackDao;
import com.entities.Backpack;
import sample.ConnectionConfiguration;

import java.sql.Connection;
import java.sql.Statement;
import java.util.List;

public class BackpackDaoImpl implements BackpackDao {
    @Override
    public void createBackpackTable() {
        Connection connection = null;
        Statement statement = null;

        try{
            connection = ConnectionConfiguration.getConnection();
            statement = connection.createStatement();
            statement.execute("CREATE TABLE COMPANY \" +\n" +
                    "                        \" BOOK           TEXT    NOT NULL, \" + \n" +
                    "                        \" PURPOSE            TEXT     NOT NULL, \" + \n");


        }catch (Exception e){
            e.printStackTrace();
        }finally {
            if (statement != null){
                try {
                    connection.close();

                }catch (Exception e){
                    e.printStackTrace();

                }

            }

        }
    }

    @Override
    public void insert(Backpack backpack) {

    }

    @Override
    public Backpack selectbyBook(String book) {
        return null;
    }

    @Override
    public List<Backpack> selectAll() {
        return null;
    }

    @Override
    public void delete(String book) {

    }

    @Override
    public void update(Backpack backpack, String book) {

    }
}
