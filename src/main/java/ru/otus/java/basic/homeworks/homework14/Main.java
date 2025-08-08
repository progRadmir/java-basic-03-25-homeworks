package ru.otus.java.basic.homeworks.homework14;

public class Main {
    public static void main(String[] args) {
        Object[][] obj = {{1, 2, 3, 4}, {1.1, 2, 3, 4}, {1, 2, 3, 4}, {1, 2, 3, 4}};
        try{
            System.out.println(sum(obj));
        } catch(AppArraySizeException | AppArrayDataException e) {
            System.out.println(e.getMessage());
        }
    }

    public static int sum(Object[][] arr) {
            if (arr.length != 4) {
                throw new AppArraySizeException("В метод sum() можно передать массив размером только 4*4");
            }
            for (int i = 0; i < arr.length; i++) {
                if (arr[i].length != 4) {
                    throw new AppArraySizeException("В метод sum() можно передать массив размером только 4*4");
                }
            }

            int sum = 0;
            for (int i = 0; i < arr.length; i++) {
                for (int j = 0; j < arr[0].length; j++) {
                    if (!(arr[i][j] instanceof Number)) {
                        throw new AppArraySizeException(String.format("Элемент массива по индексу [%d][%d] не является числом", i, j));
                    }
                    sum += ((Number)(arr[i][j])).intValue();
                }
            }
            return sum;

    }


}
