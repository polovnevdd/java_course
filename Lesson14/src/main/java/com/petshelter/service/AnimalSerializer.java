package com.petshelter.service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.petshelter.model.Animal;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class AnimalSerializer {
    public void serialize(List<Animal> animal) {
        ObjectMapper mapper = new ObjectMapper();
        try {
            mapper.writeValue(new File("Lesson14/src/main/resources/animal.json"), animal);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<Animal> deserialize(List<Animal> animal) {
        ObjectMapper mapper = new ObjectMapper();
        List<Animal> listOfAnimals = new ArrayList<>();
        try {
            return listOfAnimals = mapper.readValue(new File("Lesson14/src/main/resources/animal.json"), new TypeReference<List<Animal>>() {
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
