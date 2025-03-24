package com.gameshop.service.impl;

import com.gameshop.dao.GameShopDao;
import com.gameshop.dao.impl.DefaultGameShopDao;
import com.gameshop.model.Game;
import com.gameshop.service.GameShop;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

public class DefaultGameShop implements GameShop {
    GameShopDao gameShopDao = new DefaultGameShopDao();

    @Override
    public void add(Game game) {
        gameShopDao.add(game);
    }

    @Override
    public void delete(int id) {
        gameShopDao.delete(id);
    }

    @Override
    public Game showByName(String name) {
        return gameShopDao.showByName(name);
    }

    @Override
    public List<Game> filterByPrice(float price) {
        return gameShopDao.filterByPrice(price);
    }

    @Override
    public List<Game> filterByType(String type) {
        return gameShopDao.filterByType(type);
    }

    @Override
    public List<Game> showByDate() {
        return gameShopDao.showByDate();
    }

    @Override
    public List<Game> showAll() {
        return gameShopDao.showAll();
    }
}
