package ru.otus.java.basic.homeworks.homework10.part1;

public class TestUser{
    public static void main(String[] args) {
        User[] users = new User[10];

        for (int i = 0; i < users.length; i++) {
            users[i] = new User(randomName(), randomSurname(), randomPatronymic(), randomYear(), randomEmail());
        }

        for (User user : users) {
            if (user.getYearOfBirth() < 1985) {
                user.printInfo();
            }
        }
    }

    public static String randomName() {
        String[] names = {"Иван", "Сергей", "Роман", "Павел", "Руслан"};
        return names[(int) (Math.random() * 5)];
    }

    public static String randomSurname() {
        String[] surnames = {"Иванов", "Козлов", "Митрошин", "Ежов", "Воробьев"};
        return surnames[(int) (Math.random() * 5)];
    }

    public static String randomPatronymic() {
        String[] patronymics = {"Валентинович", "Александрович", "Сергеевич", "Иванович", "Ильич"};
        return patronymics[(int) (Math.random() * 5)];
    }

    public static int randomYear() {
        return 1960 + (int) (Math.random() * 50);
    }

    public static String randomEmail() {
        int length = (int) (Math.random() * 9) + 2;
        StringBuilder email = new StringBuilder();
        for (int i = 0; i < length; i++) {
            email.append((char) ((int) (Math.random() * 26) + 97));
        }
        email.append("@mail.ru");

        return email.toString();
    }
}
