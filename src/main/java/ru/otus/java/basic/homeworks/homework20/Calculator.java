package ru.otus.java.basic.homeworks.homework20;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

public class Calculator {
    public static int calculate(String expression) {
        List<Character> exp = convertStringToList(expression);
        StringBuilder sb = new StringBuilder();
        ArrayDeque<Integer> numbers = new ArrayDeque<>();
        ArrayDeque<Character> signs = new ArrayDeque<>();

        for (int i = 0; i < exp.size(); i++) {
            if (exp.get(i) == ' ') {
                continue;
            }
            if (exp.get(i) >= 48 && exp.get(i) <= 57) {
                sb.append(exp.get(i));
                if (i < exp.size() - 1) {
                    continue;
                }
            }
            convertToInt(sb, numbers);
            multiplicationOrDivision(numbers, signs);
            addIfIsSign(exp.get(i), signs);
        }
        additionAndSubtraction(numbers, signs);
        return numbers.removeLast();
    }

    private static List<Character> convertStringToList(String expression) {
        List<Character> exp = new ArrayList<>();
        for (char ch : expression.toCharArray()) {
            exp.add(ch);
        }
        return exp;
    }

    private static void convertToInt(StringBuilder sb, ArrayDeque<Integer> numbers) {
        if (!sb.toString().isEmpty()) {
            numbers.addLast(Integer.parseInt(sb.toString()));
            sb.delete(0, sb.length());
        }
    }

    private static void multiplicationOrDivision(ArrayDeque<Integer> numbers, ArrayDeque<Character> signs) {
        if (!signs.isEmpty()) {
            char sign = signs.peekLast();
            if (sign == '*' || sign == '/') {
                int number2 = numbers.removeLast();
                int number1 = numbers.removeLast();
                if (sign == '*') {
                    numbers.addLast(number1 * number2);
                } else {
                    numbers.addLast(number1 / number2);
                }
                signs.removeLast();
            }
        }
    }

    private static void addIfIsSign(char sign, ArrayDeque<Character> signs) {
        if (sign == '+' || sign == '-' || sign == '*' || sign == '/') {
            signs.addLast(sign);
        }
    }

    private static void additionAndSubtraction(ArrayDeque<Integer> numbers, ArrayDeque<Character> signs) {

        while (!signs.isEmpty()) {
            int number1 = numbers.removeFirst();

            if (signs.size() == numbers.size() + 1 && signs.removeFirst() == '-') {
                number1 *= -1;
            }

            int number2 = numbers.removeFirst();

            if (signs.removeFirst() == '+') {
                numbers.addFirst(number1 + number2);
            } else {
                numbers.addFirst(number1 - number2);
            }
        }
    }
}
