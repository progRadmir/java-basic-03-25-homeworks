package ru.otus.java.basic.homeworks.homework18.Sorting;

public class QuickSort {

    public static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
        int pivot = (low + high) / 2;
        int buffer;
        int vacationPosition = -1;

        buffer = arr[high];
        arr[high] = arr[pivot];
        arr[pivot] = buffer;
        pivot = high;

        for (int i = high - 1; i >= 0; i--) {
            if (arr[i] > arr[pivot]) {
                buffer = arr[i];
                arr[i] = arr[pivot];
                arr[pivot] = buffer;
                pivot = i;
                if (vacationPosition != -1) {
                    buffer = arr[vacationPosition];
                    arr[vacationPosition] = arr[pivot];
                    arr[pivot] = buffer;
                    pivot = vacationPosition;
                    vacationPosition--;
                }
            } else if (arr[i] == arr[pivot]) {
                pivot = i;
            } else if (vacationPosition == -1) {
                vacationPosition = i;
            }
        }
            quickSort(arr, low, pivot - 1);
            quickSort(arr, pivot + 1, high);
        }
    }

}
