package ru.otus.java.basic.homeworks.homework17;

public class TestPhoneBook {
    public static void main(String[] args) {
        PhoneBook phoneBook = new PhoneBook();
        phoneBook.add("Егоров Валентин Семенович", 89274536760L);
        phoneBook.add("Пушкина Валентина Васиковна", 89374536890L);
        phoneBook.add("Толстова Алина Васильевна", 89194596811L);
        phoneBook.add("Иванов Иван Иванович", 89374896900L);
        phoneBook.add("Иванов Иван Иванович", 89274896905L);
        phoneBook.add("Иванов Иван Иванович", 89274896905L);

        System.out.println(phoneBook.find("Пушкина Валентина Васиковна"));
        System.out.println(phoneBook.find("Иванов Иван Иванович"));

        System.out.println(phoneBook.containsPhoneNumber(89274536760L));
        System.out.println(phoneBook.containsPhoneNumber(89374536890L));
        System.out.println(phoneBook.containsPhoneNumber(89194596811L));
        System.out.println(phoneBook.containsPhoneNumber(89374896900L));
        System.out.println(phoneBook.containsPhoneNumber(89274896905L));
        System.out.println(phoneBook.containsPhoneNumber(89474896905L));

    }
}
