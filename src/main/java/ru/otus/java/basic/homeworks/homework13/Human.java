package ru.otus.java.basic.homeworks.homework13;

public class Human {
    private String name;
    private Transport currentTransport;
    private double energyConsumption;
    private double maxEndurance;
    private double endurance;

    public double getEndurance() {
        return endurance;
    }

    public void setEndurance(double endurance) {
        this.endurance = endurance;
    }

    public Human(String name, double energyConsumption, double maxEndurance) {
        this.name = name;
        this.energyConsumption = energyConsumption;
        this.maxEndurance = maxEndurance;
        this.endurance = maxEndurance;
    }

    public void getInto(Transport currentTransport) {
        if (this.currentTransport != null) {
            System.out.println("Чтобы сесть в транспорт, сначала нужно выйти в него");
            return;
        }
        this.currentTransport = currentTransport;
        System.out.printf("%s выбрал транспорт %s\n", name, currentTransport.getName());
    }

    public void getOut() {
        if (currentTransport == null) {
            System.out.println("Чтобы выйти из транспорта, сначала нужно сесть в него");
            return;
        }
        System.out.printf("%s отменил выбор транспорта %s\n", name, currentTransport.getName());
        this.currentTransport = null;
    }

    public boolean move(int distance, Terrain terrain) {
        if (currentTransport == null) {
            if (endurance == 0) {
                System.out.printf("%s без сил\n", name);
                return false;
            }
            endurance -= energyConsumption * distance;
            if (endurance < 0) {
                endurance = 0;
                System.out.printf("%s не смог осилить такую дистанцию\n", name);
                return false;
            }
            if (endurance == 0) {
                System.out.printf("%s прошёл заданную дистанцию и у него закончились силы\n", name);
                return true;
            }
            if (endurance > 0) {
                System.out.printf("%s успешно прошёл заданную дистанцию. Сил осталось на %.1f км\n", name, endurance/energyConsumption);
            }
            return true;
        }
        return currentTransport.move(distance, terrain, this);
    }

}
