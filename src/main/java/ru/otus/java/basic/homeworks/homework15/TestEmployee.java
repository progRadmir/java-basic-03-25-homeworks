package ru.otus.java.basic.homeworks.homework15;

import java.util.ArrayList;
import java.util.List;

public class TestEmployee {
    public static void main(String[] args) {
        List<Employee> employees = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            employees.add(new Employee("Сотрудник" + i, 25 + i));
        }
        System.out.println(namesOfEmployees(employees));
        System.out.println(namesOfEmployeesWithCertainAge(employees, 27));
        System.out.println(checkAverageAge(employees, 26));
        System.out.println(findTheYoungestEmployee(employees).getName());
    }


    public static List<String> namesOfEmployees(List<Employee> listOfEmployees) {
        List<String> namesOfEmployees = new ArrayList<>();
        for(Employee employee : listOfEmployees) {
            namesOfEmployees.add(employee.getName());
        }
        return namesOfEmployees;
    }

    public static List<String> namesOfEmployeesWithCertainAge(List<Employee> listOfEmployees, int minAge) {
        List<String> namesOfEmployees = new ArrayList<>();
        for(Employee employee : listOfEmployees) {
            if (employee.getAge() >= minAge) {
                namesOfEmployees.add(employee.getName());
            }
        }
        return namesOfEmployees;
    }

    public static boolean checkAverageAge(List<Employee> listOfEmployees, int minAverageAge) {
        int sumOfAge = 0;
        for(Employee employee : listOfEmployees) {
            sumOfAge += employee.getAge();
        }
        return sumOfAge/listOfEmployees.size() > minAverageAge;
    }

    public static Employee findTheYoungestEmployee(List<Employee> listOfEmployees) {
        int minAge = Integer.MAX_VALUE;
        int indexMinAge = 0;
        for (int i = 0; i < listOfEmployees.size(); i++) {
            if (listOfEmployees.get(i).getAge() < minAge) {
                minAge = listOfEmployees.get(i).getAge();
                indexMinAge = i;
            }
        }
        return listOfEmployees.get(indexMinAge);
    }
}
