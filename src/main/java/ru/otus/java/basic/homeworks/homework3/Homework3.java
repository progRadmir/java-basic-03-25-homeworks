package ru.otus.java.basic.homeworks.homework3;

import java.util.Scanner;

public class Homework3 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int usersNumber;

        System.out.println("Введите число от 1 до 5");
        usersNumber = scanner.nextInt();
        switch(usersNumber) {
            case 1: {
                System.out.println("Вы выбрали метод greetings");
                greetings();
                break;
            }
            case 2: {
                System.out.println("Вы выбрали метод checkSign. Введите первое число:");
                int a = scanner.nextInt();
                System.out.println("Введите второе число:");
                int b = scanner.nextInt();
                System.out.println("Введите третье число:");
                int c = scanner.nextInt();
                checkSign(a, b, c);
                break;
            }
            case 3: {
                System.out.println("Вы выбрали метод selectColor");
                selectColor();
                break;
            }
            case 4: {
                System.out.println("Вы выбрали метод compareNumbers");
                compareNumbers();
                break;
            }
            case 5: {
                int initValue, delta;
                String sign = "";
                boolean increment;

                System.out.println("Вы выбрали метод increment. Введите любое число:");
                initValue = scanner.nextInt();
                System.out.println("Введите дэльту:");
                delta = scanner.nextInt();
                scanner.nextLine();
                System.out.println("Введите \"+\" чтобы прибавить или \"-\" чтобы вычесть:");
                sign = scanner.nextLine();

                if(sign.equals("+")) {
                    increment = true;
                } else if(sign.equals("-")){
                    increment = false;
                } else {
                    System.out.println("Вы ввели неправильный символ");
                    break;
                }

                addOrSubtractAndPrint(initValue, delta, increment);
                break;
            }
        }
    }


    public static void greetings() {
        System.out.println("Hello");
        System.out.println("World");
        System.out.println("from");
        System.out.println("Java");
    }

    public static void checkSign(int a, int b, int c) {
        int sum = a + b + c;
        if(sum >= 0) {
            System.out.println("Сумма положительная");
        } else {
            System.out.println("Сумма отрицательная");
        }
    }

    public static void selectColor() {
        int data = (int)(Math.random() * 30);
        if(data <= 10) {
            System.out.println("Красный");
        } else if(data > 10 && data <= 20) {
            System.out.println("Жёлтый");
        } else if(data > 20) {
            System.out.println("Зелёный");
        }
    }

    public static void compareNumbers() {
        int a = (int) (Math.random() * 10);
        int b = (int) (Math.random() * 10);
        if (a >= b) {
            System.out.println("a >= b");
        } else {
            System.out.println("a < b");
        }
    }

    public static void addOrSubtractAndPrint(int initValue, int delta, boolean increment) {
        if (increment) {
            System.out.println(initValue + delta);
        } else {
            System.out.println(initValue - delta);
        }
    }


}
