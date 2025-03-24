package com.gameshop.dao.impl;

import com.gameshop.dao.CommonDao;
import com.gameshop.dao.GameShopDao;
import com.gameshop.model.Game;

import java.sql.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class DefaultGameShopDao extends CommonDao implements GameShopDao {
    private Connection conn = getConnection();
    ;
    private static final String ADD_GAME = "INSERT INTO games (NAME, RELEASE_DATE, RATING, COST, DESCRIPTION, TYPE) VALUES(?,?,?,?,?,?)";
    private static final String SHOW_ALL = "SELECT * FROM games";
    private static final String DELETE_GAME = "DELETE FROM games WHERE id = ?";
    private static final String SHOW_BY_NAME = "SELECT * FROM games WHERE name = ?";
    private static final String FILTER_BY_PRICE = "SELECT * FROM games WHERE cost = ?";
    private static final String FILTER_BY_TYPE = "SELECT * FROM games WHERE type = ?";
    private static final String SORT_BY_DATE = "SELECT * FROM games ORDER BY creation_date DESC";


    @Override
    public void add(Game game) {
        try (PreparedStatement pst = conn.prepareStatement(ADD_GAME)) {
            pst.setString(1, game.getName());
            pst.setDate(2, Date.valueOf(game.getReleaseDate()));
            pst.setFloat(3, game.getRating());
            pst.setFloat(4, game.getCost());
            pst.setString(5, game.getDescription());
            pst.setString(6, game.getType());
            pst.executeUpdate();
            System.out.println("Игра была успешно добавлена");
        }catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(int id) {
        try(PreparedStatement pst = conn.prepareStatement(DELETE_GAME)){
            pst.setInt(1, id);
            pst.executeUpdate();
        }catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Game showByName(String name) {
        try(PreparedStatement pst = conn.prepareStatement(SHOW_BY_NAME)){
            pst.setString(1, name);
            ResultSet rset = pst.executeQuery();
            while (rset.next()) {
                Integer id = rset.getInt("ID");
                LocalDate releaseDate = LocalDate.parse(rset.getString("RELEASE_DATE"));
                Float rating = rset.getFloat("RATING");
                Float cost = rset.getFloat("COST");
                String description = rset.getString("DESCRIPTION");
                String type = rset.getString("TYPE");
                LocalDateTime creationDate = rset.getTimestamp("CREATION_DATE").toLocalDateTime();
                Game game = new Game(id, name, releaseDate, rating, cost, description, type, creationDate);
                return game;
            }
        }catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println("Нет игры с таким именем");
        return null;
    }

    @Override
    public List<Game> filterByPrice(float price) {
        List<Game> games = new ArrayList<>();
        try(PreparedStatement pst = conn.prepareStatement(FILTER_BY_PRICE)){
            pst.setFloat(1,price);
            ResultSet rset = pst.executeQuery();
            while (rset.next()) {
                Integer id = rset.getInt("ID");
                String name = rset.getString("NAME");
                LocalDate releaseDate = LocalDate.parse(rset.getString("RELEASE_DATE"));
                Float rating = rset.getFloat("RATING");
                Float cost = rset.getFloat("COST");
                String description = rset.getString("DESCRIPTION");
                String type = rset.getString("TYPE");
                LocalDateTime creationDate = rset.getTimestamp("CREATION_DATE").toLocalDateTime();
                Game game = new Game(id, name, releaseDate, rating, cost, description, type, creationDate);
                games.add(game);
            }
        }catch (SQLException e) {
            e.printStackTrace();
        }
        return games;
    }

    @Override
    public List<Game> filterByType(String type) {
        List<Game> games = new ArrayList<>();
        try(PreparedStatement pst = conn.prepareStatement(FILTER_BY_TYPE)){
            pst.setString(1,type);
            ResultSet rset = pst.executeQuery();
            while (rset.next()) {
                Integer id = rset.getInt("ID");
                String name = rset.getString("NAME");
                LocalDate releaseDate = LocalDate.parse(rset.getString("RELEASE_DATE"));
                Float rating = rset.getFloat("RATING");
                Float cost = rset.getFloat("COST");
                String description = rset.getString("DESCRIPTION");
                LocalDateTime creationDate = rset.getTimestamp("CREATION_DATE").toLocalDateTime();
                Game game = new Game(id, name, releaseDate, rating, cost, description, type, creationDate);
                games.add(game);
            }
        }catch (SQLException e) {
            e.printStackTrace();
        }
        return games;
    }

    @Override
    public List<Game> showByDate() {
        List<Game> games = new ArrayList<>();
        try (PreparedStatement pst = conn.prepareStatement(SORT_BY_DATE)) {
            ResultSet rset = pst.executeQuery();
            while (rset.next()) {
                Integer id = rset.getInt("ID");
                String name = rset.getString("NAME");
                LocalDate releaseDate = LocalDate.parse(rset.getString("RELEASE_DATE"));
                Float rating = rset.getFloat("RATING");
                Float cost = rset.getFloat("COST");
                String description = rset.getString("DESCRIPTION");
                String type = rset.getString("TYPE");
                LocalDateTime creationDate = rset.getTimestamp("CREATION_DATE").toLocalDateTime();
                Game game = new Game(id, name, releaseDate, rating, cost, description, type, creationDate);
                games.add(game);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return games;
    }

    @Override
    public List<Game> showAll() {
        List<Game> games = new ArrayList<>();
        try (PreparedStatement pst = conn.prepareStatement(SHOW_ALL)) {
            ResultSet rset = pst.executeQuery();
            while (rset.next()) {
                Integer id = rset.getInt("ID");
                String name = rset.getString("NAME");
                LocalDate releaseDate = LocalDate.parse(rset.getString("RELEASE_DATE"));
                Float rating = rset.getFloat("RATING");
                Float cost = rset.getFloat("COST");
                String description = rset.getString("DESCRIPTION");
                String type = rset.getString("TYPE");
                LocalDateTime creationDate = rset.getTimestamp("CREATION_DATE").toLocalDateTime();
                Game game = new Game(id, name, releaseDate, rating, cost, description, type, creationDate);
                games.add(game);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return games;
    }
}
