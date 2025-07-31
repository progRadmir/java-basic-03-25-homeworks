package ru.otus.java.basic.homeworks.homework5;

import java.util.Arrays;

public class Homework5Basic {
    public static void main(String[] args) {
        int[] arr = {4, 5, 1, 2, 7, 8, 3, 9};

        printString(4, "Hello");
        printSumOfArrayElements(arr);
        changeValueOfArrayElements(5, arr);
        increaseValueOfArrayElements(1, arr);
        compareHalvesOfArray(arr);
    }


    public static void printString(int count, String str) {
        for (int i = 0; i < count; i++) {
            System.out.println(str);
        }
    }

    public static void printSumOfArrayElements(int[] arr) {
        int sum = 0;

        for (int i = 0; i < arr.length; i++) {
            if(arr[i] > 5) {
                sum += arr[i];
            }
        }

        System.out.println(sum);
    }

    public static void changeValueOfArrayElements(int number, int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            arr[i] = number;
        }

        System.out.println(Arrays.toString(arr));
    }

    public static void increaseValueOfArrayElements(int number, int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            arr[i] += number;
        }

        System.out.println(Arrays.toString(arr));
    }

    public static void compareHalvesOfArray(int[] arr) {
        int sum1 = 0;
        int sum2 = 0;

        for (int i = 0; i < arr.length/2; i++) {
            sum1 += arr[i];
        }
        for (int i = arr.length/2; i < arr.length; i++) {
            sum2 += arr[i];
        }

        if(sum1 > sum2) {
            System.out.println("Сумма элементов первой половины массива больше");
        } else if(sum1 < sum2) {
            System.out.println("Сумма элементов второй половины массива больше");
        } else if(sum1 == sum2) {
            System.out.println("Суммы элементов первой и второй половин массива одинаковы");
        }
    }

}
