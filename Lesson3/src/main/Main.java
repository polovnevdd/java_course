package main;

import area.Area;
import area.Circle;
import area.Square;
import area.Triangle;
import overcoming.*;

import java.lang.reflect.Array;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        double sumArea = 0;
        Area[] areas = {
                new Circle(3),
                new Square(5),
                new Triangle(4, 6)
        };
        for (Area area : areas) {
            sumArea += area.getArea();
        }
        System.out.println(sumArea);

        Participant[] participants = {
                new Human("Саша",1000,3),
                new Cat("Бублик",2000,5),
                new Robot("Ромбик",3000,10)
        };

        Barrier[] barriers = {
                new Wall(6),
                new Treadmill(1500)
        };
        for (Participant participant : participants){
            for (Barrier barrier : barriers){
                if(barrier.overcome(participant) == false){
                    break;
                }
            }
            
        }
    }
}