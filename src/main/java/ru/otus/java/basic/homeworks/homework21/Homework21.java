package ru.otus.java.basic.homeworks.homework21;

public class Homework21 {
    static double[] doubleArrayForOneThread = new double[100_000_000];
    static double[] doubleArrayForFourThreads = new double[100_000_000];

    public static void main(String[] args) throws InterruptedException {
        TimeCounter.start();
        createArray();
        TimeCounter.stop();

        TimeCounter.start();
        createArrayByThreads();
        TimeCounter.stop();
    }

    public static void createArray() {
        for (int i = 0; i < doubleArrayForOneThread.length; i++) {
            doubleArrayForOneThread[i] = 1.14 * Math.cos(i) * Math.sin(i * 0.2) * Math.cos (i / 1.2);
        }
    }

    public static void createArrayByThreads() {
        int length = doubleArrayForFourThreads.length;
        ThreadsForCreateArray[] arrayOfThreads = new ThreadsForCreateArray[4];

        for (int i = 0; i < 4; i++) {
            arrayOfThreads[i] = new ThreadsForCreateArray((length / 4 * i), (length / 4 * (i + 1)));
        }
        try {
            for (int i = 0; i < 4; i++) {
                arrayOfThreads[i].join();
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}

class ThreadsForCreateArray extends Thread {
    private final int from;
    private final int to;

    public ThreadsForCreateArray(int from, int to) {
        this.from = from;
        this.to = to;
        this.start();
    }

    @Override
    public void run() {
        for (int i = from; i < to; i++) {
            Homework21.doubleArrayForFourThreads[i] = 1.14 * Math.cos(i) * Math.sin(i * 0.2) * Math.cos (i / 1.2);
        }
    }
}

class TimeCounter {
    static long initialTime;

    public static void start() {
        initialTime = System.currentTimeMillis();
    }

    public static void stop() {
        System.out.println(System.currentTimeMillis() - initialTime);
    }
}
