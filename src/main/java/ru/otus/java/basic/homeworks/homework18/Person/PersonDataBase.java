package ru.otus.java.basic.homeworks.homework18.Person;

import java.util.*;

public class PersonDataBase {
    private final Map<Long, Person> personMap;
    private final Set<Position> manager;
    private final Set<Position> employee;

    public PersonDataBase(List<Person> personList) {
        personMap = new HashMap<>();
        for (Person person : personList) {
            personMap.put(person.getId(), person);
        }
        manager = new HashSet<>(Set.of(Position.MANAGER, Position.DIRECTOR, Position.BRANCH_DIRECTOR, Position.SENIOR_MANAGER));
        employee = new HashSet<>(Set.of(Position.DRIVER, Position.ENGINEER, Position.DEVELOPER, Position.QA, Position.JANITOR, Position.PLUMBER, Position.JUNIOR_DEVELOPER));
    }

    public Person findById(Long id) {
        return personMap.get(id);
    }

    public void add(Person person) {
        personMap.put(person.getId(), person);
    }

    public boolean isManager(Person person) {
        return manager.contains(person.getPosition());
    }

   // Альтернативный вариант реализации isManager также за O(1):
   public boolean isManagerAlternative(Person person) {
        switch(person.getPosition()) {
            case MANAGER:
            case DIRECTOR:
            case BRANCH_DIRECTOR:
            case SENIOR_MANAGER: return true;
            default: return false;
        }
   }

    public boolean isEmployee(Long id) {
        return employee.contains(findById(id).getPosition());
    }

}
