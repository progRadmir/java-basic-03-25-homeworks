package ru.otus.java.basic.homeworks.homework19;

import java.io.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        File initialFile = new File("src/main/java/ru/otus/java/basic/homeworks/homework19");
        String userFile;
        File file;
        Scanner scanner = new Scanner(System.in);
        Application application = new Application(initialFile);

        while (true) {
            application.printFiles();
            System.out.println("Введите имя файла:");
            userFile = scanner.nextLine();
            file = application.inputNameOfFile(userFile);
            if (file == null) {
                continue;
            }
            application.printTextFromFile(file);
            application.printSomethingInFile(file);
        }
    }
}
