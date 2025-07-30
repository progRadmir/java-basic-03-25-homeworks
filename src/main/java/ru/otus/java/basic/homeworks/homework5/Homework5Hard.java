package ru.otus.java.basic.homeworks.homework5;

import java.util.Arrays;

public class Homework5Hard {
    public static void main(String[] args) {
        int[] arr1 = {9, 1, 10, -5, 5};
        int[] arr2 = {5, 6, 7, 8, 4};

        sumOfArrays(arr1, arr2);
        pointOfSumArrayHalves(arr1);
        checkOrder(arr2);
        revertArray(arr2);
    }


    public static void sumOfArrays(int[]...arr) {
        int maxLength = 0;

        for (int i = 0; i < arr.length; i++) {
            maxLength = Math.max(arr[i].length, maxLength);
        }

        int[] buffer = new int[maxLength];

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                buffer[j] += arr[i][j];
            }
        }

        System.out.println(Arrays.toString(buffer));
    }

    public static void pointOfSumArrayHalves(int[] arr) {
        int sumLeft = 0;
        int sumRight = 0;

        for (int i = 0; i < arr.length; i++) {
           sumLeft += arr[i];
        }

        for (int i = arr.length - 1; i > 0 ; i--) {
            sumLeft -= arr[i];
            sumRight += arr[i];
            if(sumLeft == sumRight) {
                System.out.println("Точка равенства сумм находится после элемента массива №" + (i - 1) + ", который равняется " + arr[i-1]);
            }
            // Осутствие break в случае первичного нахождения равенства сумм
            // объясняется возможным наличием подобного массива: [5, 0, 0, 5]
        }
    }

    public static void checkOrder(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            if(arr[i + 1] < arr[i]) {
                System.out.println("Элементы не идут в порядке возрастания");
                break;
            }
        }
    }

    public static void revertArray(int[] arr) {
        int buffer = 0;

        for (int i = 0; i < arr.length/2; i++) {
            buffer = arr[i];
            arr[i] = arr[arr.length - 1 - i];
            arr[arr.length - 1 - i] = buffer;
        }

        System.out.println(Arrays.toString(arr));
    }
}
