package ru.otus.java.basic.homeworks.homework27;

public class Main {

    public static void main(String[] args) {

        Apple apple = new Apple(200);
        Orange orange = new Orange(250);
        Box<Fruit> box = new Box<>();
        Box<Apple> boxOfApple = new Box<>();
        Box<Orange> boxOfOrange = new Box<>();

        box.putFruitInBox(apple);
        box.putFruitInBox(orange);
        boxOfApple.putFruitInBox(apple);
        boxOfOrange.putFruitInBox(orange);

        System.out.println(box.compare(boxOfApple));

        boxOfOrange.transfer(box);

        box.whatInBox();
        boxOfApple.whatInBox();
        boxOfOrange.whatInBox();

    }

}
