package com.gameshop.service.impl;

import com.gameshop.dao.GameShopDao;
import com.gameshop.dao.impl.DefaultGameShopDao;
import com.gameshop.model.Game;
import com.gameshop.service.GameShop;

import java.util.List;

public class DefaultGameShop implements GameShop {
    GameShopDao gameShopDao = new DefaultGameShopDao();

    @Override
    public void add() {
        gameShopDao.add();
    }

    @Override
    public void delete() {
        gameShopDao.delete();
    }

    @Override
    public List<Game> showByName() {
        gameShopDao.showByName();
        return null;
    }

    @Override
    public List<Game> filterByPrice() {
        gameShopDao.filterByPrice();
        return null;
    }

    @Override
    public List<Game> filterByType() {
        gameShopDao.filterByType();
        return null;
    }

    @Override
    public List<Game> showByDate() {
        gameShopDao.showByDate();
        return null;
    }

    @Override
    public List<Game> showAll() {
        gameShopDao.showAll();
        return null;
    }
}
