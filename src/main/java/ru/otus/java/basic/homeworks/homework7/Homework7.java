package ru.otus.java.basic.homeworks.homework7;

import java.util.Arrays;

public class Homework7 {
    public static void main(String[] args) {
        int[][] arr1 = {{1, -2, 3, 4}, {-5, 6, 7}, {8, 9}};
        int[][] arr2 = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 16}};

        //1 метод
        System.out.println(sumOfPositiveElements(arr1));

        //2 метод
        printSquare(5);

        //3 метод
        zeroingDiagonals(arr2);
        // prettyArrayDisplay(int[][] arr) - дополнительный метод для красивого отображения двумерного массива
        prettyArrayDisplay(arr2);

        //4 метод
        System.out.println(findMax(arr1));

        //5 метод
        System.out.println(sumOfSecondLine(arr1));
    }


    /**
     * Далее в методах используются переменные amountLine и amountCount.
     * Введены они для того, чтобы в циклах каждый раз не обращаться к полю length.
     * И вот тут вопрос: есть ли в этом смысл? Поможет ли это оптимизировать выполнение программы
     * или это бесполезная работа? Если бы length был бы методом, как мне кажется,
     * в этом определённо был бы смысл, а вот с полем не совсем понятно.
     * Если заполнение данного поля происходит во время инициализации массива,
     * то, наверное, смысла в доп. переменных нет. Дайте, пожалуйста, подробный ответ.
     * -----
     * Отсутствие инициализации переменной amountCount при объявлении объясняется возможным наличием
     * массивов с разной длиной
     */

    public static int sumOfPositiveElements(int[][] arr) {
        int amountLine = arr.length;
        int amountColumn;
        int sum = 0;

        for (int i = 0; i < amountLine; i++) {
            amountColumn = arr[i].length;
            for (int j = 0; j < amountColumn; j++) {
                if (arr[i][j] > 0) {
                    sum += arr[i][j];
                }
            }
        }

        return sum;
    }

    public static void printSquare(int size) {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                System.out.printf("%2c ", '*');
            }
            System.out.println();
        }
    }

    public static void zeroingDiagonals(int[][] arr) {
        int amountLine = arr.length;
        int amountColumn = arr[0].length;

        for (int i = 0; i < amountLine; i++) {
            for (int j = 0; j < amountColumn; j++) {
                if ((i == j) || (j == amountColumn - 1 - i)) {
                    arr[i][j] = 0;
                }
            }
        }
    }

    public static int findMax(int[][] arr) {
        int amountLine = arr.length;
        int amountColumn;
        int max = Integer.MIN_VALUE;

        for (int i = 0; i < amountLine; i++) {
            amountColumn = arr[i].length;
            for (int j = 0; j < amountColumn; j++) {
                max = Math.max(arr[i][j], max);
            }
        }

        return max;
    }

    public static int sumOfSecondLine(int[][] arr) {
        if (arr[1] == null) {
            return -1;
        } else {
            int sum = 0;

            for (int i = 0; i < arr[1].length; i++) {
                sum += arr[1][i];
            }

            return sum;
        }
    }

    public static void prettyArrayDisplay(int[][] arr) {
        int amountLine = arr.length;
        int amountColumn;

        for (int i = 0; i < amountLine; i++) {
            amountColumn = arr[i].length;
            for (int j = 0; j < amountColumn; j++) {
                System.out.printf("%2d ", arr[i][j]);
            }
            System.out.println();
        }
    }

}
