package ru.otus.java.basic.homeworks.homework19;

import java.io.*;
import java.util.*;

public class Application {

    private final List<File> listOfFiles = new ArrayList<>();

    public Application(File directoryOrFile) {
        searchFiles(directoryOrFile);
    }


    public void searchFiles(File directoryOrFile) {
        if (directoryOrFile.isDirectory()) {
            File[] listOfInnerElements = directoryOrFile.listFiles();
            for (File innerElement : listOfInnerElements) {
                searchFiles(innerElement);
            }
        } else if (directoryOrFile.getName().endsWith(".txt")) {
            listOfFiles.add(directoryOrFile);
        }
    }

    public void printFiles() {
        for (File element : listOfFiles) {
            System.out.println(element.getName());
        }
    }

    public File inputNameOfFile(String nameOfFile) {
        if (!this.checkFile(nameOfFile)) {
            System.out.println("Такого файла нет в данном каталоге");
            return null;
        }
        if (this.checkDoubleFiles(nameOfFile)) {
            System.out.println("Файлов с таким именем несколько:");
            this.getDoubleFiles(nameOfFile);
            System.out.println("Укажите полный путь:");
            return new File(new Scanner(System.in).nextLine());
        }
        return this.getFile(nameOfFile);
    }

    public boolean checkFile(String nameOfFile) {
        for (File element : listOfFiles) {
            if (element.getName().equals(nameOfFile)) {
                return true;
            }
        }
        return false;
    }

    public boolean checkDoubleFiles(String nameOfFile) {
        int count = 0;
        for (File element : listOfFiles) {
            if (element.getName().equals(nameOfFile)) {
                count++;
            }
        }
        if (count > 1) {
            return true;
        }
        return false;
    }

    public void getDoubleFiles(String nameOfFile) {
        List<File> doubleElements = new ArrayList<>();
        for (File element : listOfFiles) {
            if (element.getName().equals(nameOfFile)) {
                doubleElements.add(element);
            }
        }
        for (File element : doubleElements) {
            System.out.println(element);
        }
    }

    public File getFile(String nameOfFile) {
        for (File element : listOfFiles) {
            if (element.getName().equals(nameOfFile)) {
                return element;
            }
        }
        return null;
    }

    public void printTextFromFile(File file) {
        try (BufferedInputStream bin = new BufferedInputStream(new FileInputStream(file))) {
            byte[] byteBuffer = new byte[16];
            int length;
            while ((length = bin.read(byteBuffer)) != -1) {
                System.out.write(byteBuffer, 0, length);
            }
        } catch (FileNotFoundException e) {
            System.out.println("Неправильно указан полный путь до файла");
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public void printSomethingInFile(File file) {
        try (BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(file, true))) {
            Scanner scanner = new Scanner(System.in);
            String text;
            do {
                System.out.println("Напишите что-нибудь");
                text = scanner.nextLine();
                bos.write(10);
                bos.write(text.getBytes());
                bos.flush();
            } while (!text.equals(""));
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    }
