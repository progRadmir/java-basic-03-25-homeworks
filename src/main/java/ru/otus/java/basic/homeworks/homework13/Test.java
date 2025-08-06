package ru.otus.java.basic.homeworks.homework13;

import java.util.Scanner;

public class Test {

    public static void main(String[] args) {
        Human human = new Human("Вася", 2, 50);
        Car car = new Car(0.1, 30);
        Horse horse = new Horse(5, 150);
        Bicycle bicycle = new Bicycle(1);
        AllTerrainVehicle monster = new AllTerrainVehicle(0.4, 50);

        Scanner scanner = new Scanner(System.in);
        String s;

        while (true) {
            System.out.println("Выберите действие: сесть, выйти, переместиться");
            s = scanner.nextLine();
            if (s.equals("сесть")) {
                System.out.println("Выберите транспорт: машина, лошадь, велосипед, вездеход");
                s = scanner.nextLine();
                switch (s) {
                    case "машина" : human.getInto(car); break;
                    case "лошадь" : human.getInto(horse); break;
                    case "велосипед" : human.getInto(bicycle); break;
                    case "вездеход" : human.getInto(monster); break;
                    default: System.out.println("Некорректный ввод");
                }
            } else if (s.equals("выйти")) {
                human.getOut();
            } else if (s.equals("переместиться")) {
                int distance;
                System.out.println("Укажите дистанцию");
                distance = scanner.nextInt();
                scanner.nextLine();
                System.out.println("Укажите местность: лес, равнина, болото ");
                s = scanner.nextLine();
                boolean success = switch (s) {
                    case "лес" : yield human.move(distance, Terrain.DENSE_FOREST);
                    case "равнина" : yield human.move(distance, Terrain.PLAIN);
                    case "болото" : yield human.move(distance, Terrain.SWAMP);
                    default: System.out.println("Некорректный ввод"); yield false;
                };
                if (success) {
                    System.out.println("Перемещение совершено успешно");
                } else {
                    System.out.println("Перемещение не состоялось");
                }
            } else {
                System.out.println("Некорректный ввод");
            }
        }


    }

}
