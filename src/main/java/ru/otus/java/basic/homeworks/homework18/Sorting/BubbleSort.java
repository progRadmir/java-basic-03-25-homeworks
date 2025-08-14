package ru.otus.java.basic.homeworks.homework18.Sorting;

public class BubbleSort {

    public static void bubbleSort(int[] arr) {
        boolean needNextStep;
        int iterator = -1;
        int buffer;

        do {
            needNextStep = false;
            iterator++;
            for (int i = 0; i < arr.length - 1 - iterator; i++) {
                if (arr[i] > arr[i+1]) {
                    buffer = arr[i];
                    arr[i] = arr[i+1];
                    arr[i+1] = buffer;
                    needNextStep = true;
                }
            }
        } while (needNextStep);
    }

}
