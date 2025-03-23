package com.gameshop.model;

import lombok.*;

import java.time.LocalDateTime;
import java.util.Date;

@Data
@AllArgsConstructor
public class Game {
    private Integer id;
    private String name;
    private Date releaseDate;
    private Float rating;
    private Float cost;
    private String description;
    private String type;
    private LocalDateTime creationDate;

    public Game(String name, Date releaseDate, Float rating, Float cost, String description, String type) {
        this.name = name;
        this.releaseDate = releaseDate;
        this.rating = rating;
        this.cost = cost;
        this.description = description;
        this.type = type;
    }
}
