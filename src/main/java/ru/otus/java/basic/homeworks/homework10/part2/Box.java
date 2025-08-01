package ru.otus.java.basic.homeworks.homework10.part2;

public class Box {
    private int length;
    private int width;
    private int height;
    private String color;

    private boolean open = false;
    private String item;

    public void setColor(String color) {
        this.color = color;
        System.out.println("Вы перекрасили коробку. Текущий цвет: " + color);
    }

    public Box(int length, int width, int height, String color) {
        this.length = length;
        this.width = width;
        this.height = height;
        this.color = color;
    }

    public void info() {
        System.out.printf("Длина коробки: %d \nШирина коробки: %d \nВысота коробки: %d \nЦвет коробки: %s \n",
                length, width, height, color);

        if (open) {
            System.out.println("Коробка открыта");
        } else {
            System.out.println("Коробка закрыта");
        }

        if (item == null) {
            System.out.println("В коробке пусто\n");
        } else {
            System.out.printf("В коробке лежит предмет \"%s\"\n\n", item);
        }
    }

    public void open() {
        if (!open) {
            open = true;
            System.out.println("Вы открыли коробку");
        } else {
            System.out.println("Коробка уже открыта");
        }
    }

    public void close() {
        if (open) {
            open = false;
            System.out.println("Вы закрыли коробку");
        } else {
            System.out.println("Коробка уже открыта");
        }
    }

    public void putIn(String item) {
        if (open) {
            if (this.item == null) {
                this.item = item;
                System.out.printf("Вы положили в коробку предмет \"%s\"\n", this.item);
            } else {
                System.out.printf("В коробке уже есть предмет \"%s\". Снала нужно его достать\n", this.item);
            }
        } else {
            System.out.println("Коробка закрыта. Чтобы положить предмет откройте её");
        }
    }

    public void putOut() {
        if (open) {
            if (item != null) {
                System.out.printf("Вы достали из коробки предмет \"%s\"\n", item);
                item = null;
            } else {
                System.out.println("В коробке пусто");
            }
        } else {
            System.out.println("Коробка закрыта. Чтобы достать предмет откройте её");
        }
    }

}
