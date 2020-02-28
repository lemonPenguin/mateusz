package com.dao;

import com.entities.Backpack;

import java.util.List;

public interface BackpackDao {

    void createBackpackTable();

    void insert(Backpack backpack);

    Backpack selectbyBook(String book);

    List<Backpack> selectAll();

    void delete(String book);

    void update(Backpack backpack, String book);

}
