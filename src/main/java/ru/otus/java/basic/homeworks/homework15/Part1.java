package ru.otus.java.basic.homeworks.homework15;

import java.util.ArrayList;
import java.util.List;

public class Part1 {
    public static void main(String[] args) {
        List<Integer> list = generateArrayList(5, 11);
        System.out.println(list);
        System.out.println(sumOfElementsMore5(list));
        rewriteElements(5, list);
        increaseValueOfElements(1, list);
        System.out.println(list);
    }

    
    public static List<Integer> generateArrayList(int min, int max) {
        List <Integer> list = new ArrayList<>();
        for (int i = min; i <= max; i++) {
            list.add(i);
        }
        return list;
    }

    public static int sumOfElementsMore5(List<Integer> list) {
        int sum = 0;
        for(int element : list) {
            if (element > 5) {
                sum += element;
            }
        }
        return sum;
    }

    public static void rewriteElements(int a, List<Integer> list) {
        for (int i = 0; i < list.size(); i++) {
            list.set(i, a);
        }
    }

    public static void increaseValueOfElements(int a, List<Integer> list) {
        for (int i = 0; i < list.size(); i++) {
            list.set(i, list.get(i) + a);
        }
    }
}
