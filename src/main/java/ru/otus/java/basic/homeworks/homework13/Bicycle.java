package ru.otus.java.basic.homeworks.homework13;

public class Bicycle implements Transport{
    private String name;
    private double energyConsumption;

    public String getName() {
        return name;
    }

    public Bicycle(double energyConsumption) {
        this.energyConsumption = energyConsumption;
        name = "Велосипед";
    }

    public boolean move(int distance, Terrain terrain, Human human) {
        if (terrain == Terrain.SWAMP) {
            System.out.println("Велосипедист не может перемещаться по болотам");
            return false;
        }
        if (human.getEndurance() == 0) {
            System.out.println("Велосипедист устал");
            return false;
        }
        human.setEndurance(human.getEndurance() - energyConsumption * distance);
        if (human.getEndurance() < 0) {
            human.setEndurance(0);
            System.out.println("У велосипедиста не хватило сил на такую дистанцию");
            return false;
        }
        if (human.getEndurance() == 0) {
            System.out.println("Велосипедист проехал заданную дистанцию и у него закончились силы");
            return true;
        }
        System.out.printf("Велосипедист успешно проехал заданную дистанцию. Сил велосипедиста осталось на %.1f км\n", human.getEndurance()/energyConsumption);
        return true;
    }
}
