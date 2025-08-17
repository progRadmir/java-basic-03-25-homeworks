package ru.otus.java.basic.homeworks.homework18.Person;

public class Person {
    private String name;
    private Position position;
    private final Long id;

    public String getName() {
        return name;
    }

    public Position getPosition() {
        return position;
    }

    public Long getId() {
        return id;
    }

    public Person(String name, Position position, Long id) {
        this.name = name;
        this.position = position;
        this.id = id;
    }
}
