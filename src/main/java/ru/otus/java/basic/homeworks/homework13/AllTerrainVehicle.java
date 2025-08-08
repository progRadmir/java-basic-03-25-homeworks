package ru.otus.java.basic.homeworks.homework13;

public class AllTerrainVehicle implements Transport{
    private String name;
    private double fuelConsumption;
    private double tankCapacity;
    private double currentAmountFuel;

    public String getName() {
        return name;
    }

    public AllTerrainVehicle(double fuelConsumption, double tankCapacity) {
        this.fuelConsumption = fuelConsumption;
        this.tankCapacity = tankCapacity;
        currentAmountFuel = tankCapacity;
        name = "Вездеход";
    }

    public boolean move(int distance, Terrain terrain, Human human) {
        if (currentAmountFuel == 0) {
            System.out.println("Топливный бак пуст");
            return false;
        }
        currentAmountFuel -= fuelConsumption * distance;
        if (currentAmountFuel < 0) {
            currentAmountFuel = 0;
            System.out.println("Топливо закончилось до окончания маршрута");
            return false;
        }
        if (currentAmountFuel == 0) {
            System.out.println("Вы проехали заданную дистанцию, но топливо закончилось");
            return true;
        }
        System.out.printf("Вы успешно проехали заданную дистанцию. Топлива осталось на %.1f км\n", currentAmountFuel/fuelConsumption);
        return true;
    }
}
