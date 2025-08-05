package ru.otus.java.basic.homeworks.homework11;

public class Horse extends Animal{

    double speedSwim;
    static final int SWIM_METRE_EXPENSES = 4;

    public Horse(String name, double speedRun, int endurance, double speedSwim) {
        super(name, speedRun, endurance);
        this.speedSwim = speedSwim;
    }

    public double swim(int distance) {
        endurance -= distance * SWIM_METRE_EXPENSES;
        if (endurance < 0) {
            fresh = false;
            System.out.printf("У %s не хватило сил на такую дистанцию\n", name);
            return -1;
        } if (endurance == 0) {
            fresh = false;
            System.out.printf("%s проплыл %d метров за %d секунд, и у него закончились силы\n", name, distance, (int)(distance / speedSwim));
            return distance / speedSwim;
        } else {
            System.out.printf("%s проплыл %d метров за %d секунд\n", name, distance, (int)(distance / speedSwim));
            return distance / speedSwim;
        }
    }
}
