package com.gameshop.model;

import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

@Data
@AllArgsConstructor
public class Game {
    private Integer id;
    private String name;
    private LocalDate releaseDate;
    private Float rating;
    private Float cost;
    private String description;
    private String type;
    private LocalDateTime creationDate;

    public Game(String name, LocalDate releaseDate, Float rating, Float cost, String description, String type) {
        this.name = name;
        this.releaseDate = releaseDate;
        this.rating = rating;
        this.cost = cost;
        this.description = description;
        this.type = type;
    }

    @Override
    public String toString() {
        return String.format(
                "ID: %d, Name: %s, Release Date: %s, Rating: %.1f, Cost: %.2f, Description: %s, Type: %s, Creation Date: %s \n",
                id, name, releaseDate, rating, cost, description, type, creationDate
        );
    }
}
