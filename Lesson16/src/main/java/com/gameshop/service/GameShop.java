package com.gameshop.service;

import com.gameshop.model.Game;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

public interface GameShop {
    void add(Game game);
    void delete(int id);
    Game showByName(String name);
    List<Game> filterByPrice(float price);
    List<Game> filterByType(String type);
    List<Game> showByDate();
    List<Game> showAll();
}
