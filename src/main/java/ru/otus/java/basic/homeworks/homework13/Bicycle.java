package ru.otus.java.basic.homeworks.homework13;

public class Bicycle implements Transport{
    private String name;
    private double energyConsumption;
    private Human cyclist;

    public String getName() {
        return name;
    }

    public Bicycle(double energyConsumption, Human cyclist) {
        this.energyConsumption = energyConsumption;
        this.cyclist = cyclist;
        name = "Велосипед";
    }

    public boolean move(int distance, Terrain terrain) {
        if (terrain == Terrain.SWAMP) {
            System.out.println("Велосипедист не может перемещаться по болотам");
            return false;
        }
        if (cyclist.getEndurance() == 0) {
            System.out.println("Велосипедист устал");
            return false;
        }
        cyclist.setEndurance(cyclist.getEndurance() - energyConsumption * distance);
        if (cyclist.getEndurance() < 0) {
            cyclist.setEndurance(0);
            System.out.println("У велосипедиста не хватило сил на такую дистанцию");
            return false;
        }
        if (cyclist.getEndurance() == 0) {
            System.out.println("Велосипедист проехал заданную дистанцию и у него закончились силы");
            return true;
        }
        System.out.printf("Велосипедист успешно проехал заданную дистанцию. Сил велосипедиста осталось на %.1f км\n", cyclist.getEndurance()/energyConsumption);
        return true;
    }
}
