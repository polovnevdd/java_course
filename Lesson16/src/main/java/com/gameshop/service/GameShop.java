package com.gameshop.service;

import com.gameshop.model.Game;

import java.util.List;

public interface GameShop {
    void add();
    void delete();
    List<Game> showByName();
    List<Game> filterByPrice();
    List<Game> filterByType();
    List<Game> showByDate();
    List<Game> showAll();
}
