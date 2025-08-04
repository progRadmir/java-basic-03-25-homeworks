package ru.otus.java.basic.homeworks.homework10.part1;

public class User {
    private String name;
    private String surname;
    private String patronymic;
    private int yearOfBirth;
    private String email;

    public int getYearOfBirth() {
        return yearOfBirth;
    }

    public User(String name, String surname, String patronymic, int yearOfBirth, String email) {
        this.name = name;
        this.surname = surname;
        this.patronymic = patronymic;
        this.yearOfBirth = yearOfBirth;
        this.email = email;
    }

    public void printInfo() {
        System.out.printf("ФИО: %s %s %s \n", surname, name, patronymic);
        System.out.printf("Год рождения: %d \n", yearOfBirth);
        System.out.printf("e-mail: %s \n\n", email);
    }
}
