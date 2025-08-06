package ru.otus.java.basic.homeworks.homework12;

public class Test {

    public static void main(String[] args) {
        Plate plate = new Plate(40);
        String[] names = {"Barsik", "Fedor", "Matroskin", "Tuk", "Bars"};
        Cat[] cats = new Cat[5];
        for (int i = 0; i < cats.length; i++) {
            cats[i] = new Cat(names[i], (int)(Math.random() * 20));
        }
        for(Cat cat : cats) {
            cat.info();
        }
        for(Cat cat : cats) {
            if (plate.decreaseFood(cat.getAppetite())) {
                cat.successfulEating();
            }
        }
        for(Cat cat : cats) {
            cat.info();
        }
    }
}
