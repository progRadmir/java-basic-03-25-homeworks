package ru.otus.java.basic.homeworks.homework19;

import java.io.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        File initialFile = new File("C:\\Java\\Otus\\java-basic-03-25-homeworks\\src\\main\\java\\ru\\otus\\java\\basic\\homeworks\\homework19");
        File file;
        Scanner scanner = new Scanner(System.in);
        Application application = new Application(initialFile);
        String userFile;
        while (true) {
            application.printFiles();
            System.out.println("Введите имя файла:");
            userFile = scanner.nextLine();
            if (!application.checkFile(userFile)) {
                System.out.println("Такого файла нет в данном каталоге");
                continue;
            }
            if (application.checkDoubleFiles(userFile)) {
                System.out.println("Файлов с таким именем несколько:");
                application.getDoubleFiles(userFile);
                System.out.println("Укажите полный путь:");
                file = new File(scanner.nextLine());
            } else {
                file = application.getFile(userFile);
            }

            try (BufferedInputStream bin = new BufferedInputStream(new FileInputStream(file));
                 BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(file, true));

            ) {
                byte[] byteBuffer = new byte[16];
                int length;
                while ((length = bin.read(byteBuffer)) != -1) {
                    System.out.write(byteBuffer, 0, length);
                }

                String text;
                do {
                    System.out.println("Напишите что-нибудь");
                    text = scanner.nextLine();
                    bos.write(10);
                    bos.write(text.getBytes());
                    bos.flush();
                } while (!text.equals(""));

                break;

            } catch (FileNotFoundException e) {
                System.out.println("Неправильно указан полный путь до файла");
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }

        }
    }
}
