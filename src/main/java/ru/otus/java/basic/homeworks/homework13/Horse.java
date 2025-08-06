package ru.otus.java.basic.homeworks.homework13;

public class Horse implements Transport{
    private String name;
    private double energyConsumption;
    private double maxEndurance;
    private double endurance;

    public String getName() {
        return name;
    }

    public Horse(double energyConsumption, double maxEndurance) {
        this.energyConsumption = energyConsumption;
        this.maxEndurance = maxEndurance;
        endurance = maxEndurance;
        name = "Лошадь";
    }

    public boolean move(int distance, Terrain terrain, Human human) {
        if (terrain == Terrain.SWAMP) {
            System.out.println("Лошадь не может перемещаться по болотам");
            return false;
        }
        if (endurance == 0) {
            System.out.println("Лошадь устала");
            return false;
        }
        endurance -= energyConsumption * distance;
        if (endurance < 0) {
            endurance = 0;
            System.out.println("Лошадь устала до окончания маршрута");
            return false;
        }
        if (endurance == 0) {
            System.out.println("Вы проехали заданную дистанцию, но лошадь устала");
            return true;
        }
        System.out.printf("Вы успешно проехали заданную дистанцию. Сил лошади осталось на %.1f км\n", endurance/energyConsumption);
        return true;
    }
}
