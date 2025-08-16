package ru.otus.java.basic.homeworks.homework19;

import java.io.File;
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

}
