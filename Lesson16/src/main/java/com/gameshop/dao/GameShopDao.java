package com.gameshop.dao;

import com.gameshop.model.Game;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

public interface GameShopDao {
    void add(Game game);

    void delete(int id);

    Game showByName(String name);

    List<Game> filterByPrice(float price);

    List<Game> filterByType(String type);

    List<Game> showByDate();

    List<Game> showAll();
}
