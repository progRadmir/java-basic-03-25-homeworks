package ru.otus.java.basic.homeworks.homework11;

public class Animal {

    String name;
    double speedRun;
    int endurance;
    boolean fresh = true;

    public Animal(String name, double speedRun, int endurance) {
        this.name = name;
        this.speedRun = speedRun;
        this.endurance = endurance;
    }

    public double run(int distance) {
        endurance -= distance;
        if (endurance < 0) {
            fresh = false;
            System.out.printf("У %s не хватило сил на такую дистанцию\n", name);
            return -1;
        } if (endurance == 0) {
            fresh = false;
            System.out.printf("%s пробежал %d метров за %d секунд, и у него закончились силы\n", name, distance, (int)(distance / speedRun));
            return distance / speedRun;
        } else {
            System.out.printf("%s пробежал %d метров за %d секунд\n", name, distance, (int)(distance / speedRun));
            return distance / speedRun;
        }
    }

    public void info() {
        if (fresh) {
            System.out.printf("У %s осталось %d сил\n", name, endurance);
        } else {
            System.out.printf("%s хочет отдохнуть\n", name);
        }
    }

}
