package ru.otus.java.basic.homeworks.homework10.part2;

public class TestBox {
    public static void main(String[] args) {
        Box box = new Box(4, 5, 9, "gray");
        box.info();
        box.putIn("hummer");
        box.open();
        box.putIn("hummer");
        box.info();
        box.close();
        box.info();
        box.putOut();
        box.open();
        box.putOut();
        box.putOut();
        box.info();
        box.close();
        box.setColor("blue");
        box.info();

    }
}
