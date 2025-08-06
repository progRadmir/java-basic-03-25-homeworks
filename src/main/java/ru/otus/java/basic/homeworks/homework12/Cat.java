package ru.otus.java.basic.homeworks.homework12;

public class Cat {
    private String name;
    private int appetite;
    private boolean satiety;

    public int getAppetite() {
        return appetite;
    }

    public Cat(String name, int appetite) {
        this.name = name;
        this.appetite = appetite;
    }

    public void successfulEating() {
        satiety = true;
    }

    public void info() {
        if (satiety) {
            System.out.printf("Кот %s не голоден\n", name);
            return;
        }
        System.out.printf("Кот %s хочет съесть %d еды\n", name, appetite);
    }
}
