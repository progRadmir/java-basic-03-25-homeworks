package ru.otus.java.basic.homeworks.homework30;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class PrintLetter {
    private volatile char currentLetter = 'C';
    public static void main(String[] args) {
        PrintLetter printLetter = new PrintLetter();
        try(ExecutorService executorService = Executors.newFixedThreadPool(3)) {
            executorService.execute(() -> printLetter.printA());
            executorService.execute(() -> printLetter.printB());
            executorService.execute(() -> printLetter.printC());
            executorService.shutdown();
        }
    }

    public synchronized void printA(){
        for (int i = 0; i < 5; i++) {
            while(currentLetter != 'C') {
                try {
                    wait();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            System.out.print('A');
            currentLetter = 'A';
            notifyAll();
        }
    }

    public synchronized void printB(){
        for (int i = 0; i < 5; i++) {
            while(currentLetter != 'A') {
                try {
                    wait();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            System.out.print('B');
            currentLetter = 'B';
            notifyAll();
        }
    }

    public synchronized void printC(){
        for (int i = 0; i < 5; i++) {
            while(currentLetter != 'B') {
                try {
                    wait();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            System.out.print('C');
            currentLetter = 'C';
            notifyAll();
        }
    }
}


