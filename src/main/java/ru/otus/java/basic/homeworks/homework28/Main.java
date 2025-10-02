package ru.otus.java.basic.homeworks.homework28;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите имя файла: ");
        String nameOfFile = sc.nextLine();
        System.out.println("Введите последовательность символов: ");
        String combination = sc.nextLine();

        Path pathToFile = Path.of("src\\main\\java\\ru\\otus\\java\\basic\\homeworks\\homework28").resolve(Path.of(nameOfFile));

        System.out.println("Количество совпадений: " + countNumberOfMatches(pathToFile, combination));

    }

    public static int countNumberOfMatches(Path pathToFile, String combination) throws IOException{
        BufferedReader br = Files.newBufferedReader(pathToFile, Charset.forName("UTF-8"));
        char[] combArr = combination.toCharArray();
        int letter, i = 0, numberOfMatches = 0;
        while((letter = br.read()) != -1) {
            if((letter == (int)combArr[i])) {
                if(i == combArr.length - 1) {
                    numberOfMatches++;
                    i = 0;
                } else {
                    i++;
                }
            }
        }
        return numberOfMatches;
    }

}
