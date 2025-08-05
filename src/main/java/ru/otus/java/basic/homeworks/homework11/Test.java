package ru.otus.java.basic.homeworks.homework11;

public class Test {
    public static void main(String[] args) {
        Cat cat = new Cat("Barsik", 2.5, 1000);
        Dog dog = new Dog("Bobik", 3.1, 2000, 0.5);
        Horse horse = new Horse("Wind", 4.1, 3000, 0.1);

        cat.run(100);
        cat.info();

        dog.run(100);
        dog.swim(500);
        dog.swim(450);
        dog.info();

        horse.run(100);
        horse.swim(500);
        horse.swim(450);
        horse.info();
    }


}
